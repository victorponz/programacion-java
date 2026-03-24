---
typora-copy-images-to: ../assets/img/javafx/
typora-root-url: ../../
layout: post
title: JavaFx Recursos Fxml
categories: javafx
conToc: true
permalink: javafx-recursos-fxm l
---

# Resources FXML en JavaFX

En JavaFX, los archivos **FXML** son archivos XML que describen la interfaz gráfica de forma declarativa. Para usarlos correctamente, es fundamental entender cómo gestionarlos como **recursos** del proyecto.

------



## ¿Qué es un Resource en Java?

Un *resource* es cualquier archivo que se incluye dentro del classpath del proyecto (imágenes, CSS, FXML, etc.). En lugar de usar rutas absolutas del sistema de archivos, se accede a ellos mediante el **classloader**, lo que hace que el proyecto sea portable.

------

## Estructura típica del proyecto

```
src/
└── main/
    ├── java/
    │   └── com/ejemplo/
    │       ├── MainApp.java
    │       └── controllers/
    │           └── MainController.java
    └── resources/
        └── com/ejemplo/
            ├── views/
            │   └── main-view.fxml
            └── styles/
                └── style.css
```

> 💡 Es buena práctica **replicar la estructura de paquetes** dentro de `resources/` para mantener el orden.

------

## Cómo cargar un FXML como resource

La forma correcta es usando `getClass().getResource(...)`:

```java
// En MainApp.java
FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ejemplo/views/main-view.fxml"));
Parent root = loader.load();
```

### ¿Por qué no usar rutas absolutas?

```java
// ❌ MAL - Ruta absoluta, no funcionará en otro ordenador
new File("C:/proyectos/miapp/src/main/resources/views/main-view.fxml");

// ✅ BIEN - Resource path, funciona siempre
getClass().getResource("/com/ejemplo/views/main-view.fxml");
```

------

## El archivo FXML por dentro

xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Button?>

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.ejemplo.controllers.MainController"
      spacing="10">

    <Label fx:id="miLabel" text="Hola, DAW!"/>
    <Button text="Púlsame" onAction="#handleBoton"/>

</VBox>
```

Las partes clave son:

| Elemento             | Descripción                                               |
| -------------------- | --------------------------------------------------------- |
| `fx:controller`      | Clase Java que actúa como controlador                     |
| `fx:id`              | Identificador para inyectar el elemento en el controlador |
| `onAction="#metodo"` | Referencia a un método del controlador                    |



------

## El Controlador asociado

```java
public class MainController {

    @FXML
    private Label miLabel;  // Se inyecta automáticamente si tiene fx:id="miLabel"

    @FXML
    private void handleBoton(ActionEvent event) {
        miLabel.setText("¡Botón pulsado!");
    }

    @FXML
    public void initialize() {
        // Se ejecuta automáticamente al cargar el FXML
        System.out.println("Controlador inicializado");
    }
}
```

La anotación `@FXML` le dice a JavaFX que inyecte el elemento cuyo `fx:id` coincida con el nombre del atributo.

### Errores comunes

| Error                            | Causa probable                                               |
| -------------------------------- | ------------------------------------------------------------ |
| `NullPointerException` al cargar | Ruta del resource **incorrecta**                             |
| `fx:id` no inyectado             | El nombre del atributo no coincide con el `fx:id`            |
| Controlador no encontrado        | `fx:controller` apunta a una clase que no existe o mal escrita |
| FXML no encontrado en el JAR     | El archivo no está dentro de `resources/      

## Resumen

El flujo completo es:
```
FXML (diseño UI)  ──►  FXMLLoader (carga el fichero)
                              │
                              ▼
                    Controller (lógica + @FXML)
                              │
                              ▼
                      Stage / Scene (se muestra)
```
## Hoja de estilo CSS en JavaFX
JavaFX tiene su propio sistema de CSS, muy parecido al CSS web pero con propiedades propias con el prefijo `-fx-`.

Estructura del archivo css `com/ejemplo/styles/style.cs`

```css

/* =============================================
   VARIABLES GLOBALES
   ============================================= */
.root {
    -fx-font-family: "Segoe UI", Arial, sans-serif;
    -fx-font-size: 14px;
    -fx-background-color: #f4f4f4;

    /* Colores personalizados reutilizables */
    color-primario:   #2c7be5;
    color-secundario: #6c757d;
    color-peligro:    #e63757;
    color-fondo:      #f4f4f4;
}

💡 Las variables definidas en .root se pueden referenciar en cualquier selector con color-primario (sin var() como en CSS web).
```

**Selectores disponibles**

| Selector          | Equivalente web | Ejemplo JavaFX        |
| ----------------- | --------------- | --------------------- |
| `.miClase`        | clase CSS       | `.boton-primario`     |
| `#miId`           | id CSS          | `#btnGuardar`         |
| `Button`          | etiqueta HTML   | `Button { }`          |
| `.boton:hover`    | pseudoclase     | `.boton:hover { }`    |
| `.boton:pressed`  | pseudoclase     | `.boton:pressed { }`  |
| `.boton:disabled` | pseudoclase     | `.boton:disabled { }` |
| `.boton:focused`  | pseudoclase     | `.boton:focused { }`  |

Archivo CSS completo de ejemplo:

```css
   /*=============================================
   VARIABLES
   ============================================= */
.root {
    -fx-font-family: "Segoe UI", Arial, sans-serif;
    -fx-font-size: 14px;
    color-primario:   #2c7be5;
    color-exito:      #00d97e;
    color-peligro:    #e63757;
    color-fondo:      #f4f4f4;
    color-texto:      #1a1a2e;
}

/* =============================================
   VENTANA / CONTENEDORES
   ============================================= */
.fondo-principal {
    -fx-background-color: color-fondo;
    -fx-padding: 20px;
    -fx-spacing: 10px;
}

.tarjeta {
    -fx-background-color: white;
    -fx-background-radius: 8px;
    -fx-border-color: #dee2e6;
    -fx-border-radius: 8px;
    -fx-border-width: 1px;
    -fx-padding: 20px;
    -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 8, 0, 0, 2);
}

/* =============================================
   TIPOGRAFÍA
   ============================================= */
.titulo {
    -fx-font-size: 24px;
    -fx-font-weight: bold;
    -fx-text-fill: color-texto;
}

.subtitulo {
    -fx-font-size: 16px;
    -fx-font-weight: bold;
    -fx-text-fill: color-texto;
}

.texto-secundario {
    -fx-font-size: 12px;
    -fx-text-fill: color-secundario;
}

/* =============================================
   BOTONES
   ============================================= */
.boton-primario {
    -fx-background-color: color-primario;
    -fx-text-fill: white;
    -fx-font-weight: bold;
    -fx-background-radius: 6px;
    -fx-padding: 8px 20px;
    -fx-cursor: hand;
}

.boton-primario:hover {
    -fx-background-color: #1a68d1;   /* tono más oscuro */
}

.boton-primario:pressed {
    -fx-background-color: #1558b0;
    -fx-scale-x: 0.97;
    -fx-scale-y: 0.97;
}

.boton-primario:disabled {
    -fx-opacity: 0.5;
    -fx-cursor: default;
}

.boton-peligro {
    -fx-background-color: color-peligro;
    -fx-text-fill: white;
    -fx-background-radius: 6px;
    -fx-padding: 8px 20px;
    -fx-cursor: hand;
}

.boton-peligro:hover {
    -fx-background-color: #c0392b;
}

/* =============================================
   CAMPOS DE TEXTO
   ============================================= */
.campo-texto {
    -fx-background-color: white;
    -fx-border-color: #ced4da;
    -fx-border-radius: 6px;
    -fx-background-radius: 6px;
    -fx-border-width: 1px;
    -fx-padding: 8px 12px;
}

.campo-texto:focused {
    -fx-border-color: color-primario;
    -fx-border-width: 2px;
    /* Efecto de sombra azul al hacer foco */
    -fx-effect: dropshadow(gaussian, rgba(44,123,229,0.25), 6, 0, 0, 0);
}

.campo-texto-error {
    -fx-border-color: color-peligro;
    -fx-border-width: 2px;
}

/* =============================================
   TABLA (TableView)
   ============================================= */
.tabla-datos {
    -fx-background-color: white;
    -fx-border-color: #dee2e6;
    -fx-border-radius: 8px;
}

.tabla-datos .column-header {
    -fx-background-color: #f8f9fa;
    -fx-font-weight: bold;
    -fx-text-fill: color-texto;
    -fx-padding: 10px;
}

.tabla-datos .table-row-cell:odd {
    -fx-background-color: #fafafa;
}

.tabla-datos .table-row-cell:selected {
    -fx-background-color: derive(color-primario, 80%);
    -fx-text-fill: color-texto;
}

/* =============================================
   BARRA DE MENÚ
   ============================================= */
.barra-menu {
    -fx-background-color: #1a1a2e;
    -fx-padding: 0;
}

.barra-menu .menu {
    -fx-text-fill: white;
    -fx-padding: 8px 16px;
}

.barra-menu .menu:hover,
.barra-menu .menu:showing {
    -fx-background-color: color-primario;
}
```

**Cómo aplicar estilos en el FXML**

```xml
<!-- Opción 1: styleClass (equivale a class="..." en HTML) -->
<Button text="Guardar"
        styleClass="boton-primario"
        onAction="#handleGuardar"/>

<!-- Opción 2: varios estilos a la vez -->
<VBox styleClass="fondo-principal, tarjeta">
    <Label text="Título" styleClass="titulo"/>
</VBox>

<!-- Opción 3: estilo inline (evitar si es posible) -->
<Label text="Alerta"
       style="-fx-text-fill: red; -fx-font-weight: bold;"/>
```

------

**Cómo aplicar estilos desde Java**¡

```java
// Añadir una clase CSS
boton.getStyleClass().add("boton-primario");

// Quitar una clase CSS
boton.getStyleClass().remove("boton-primario");

// Reemplazar una clase por otra (útil para validaciones)
campo.getStyleClass().remove("campo-texto");
campo.getStyleClass().add("campo-texto-error");

// Estilo inline desde código (último recurso)
label.setStyle("-fx-text-fill: red;");
```

**Propiedades CSS más usadas en JavaFX**

| Propiedad               | Efecto                    |
| ----------------------- | ------------------------- |
| `-fx-background-color`  | Color de fondo            |
| `-fx-text-fill`         | Color del texto           |
| `-fx-font-size`         | Tamaño de fuente          |
| `-fx-font-weight`       | `bold` / `normal`         |
| `-fx-padding`           | Relleno interior          |
| `-fx-background-radius` | Bordes redondeados        |
| `-fx-border-color`      | Color del borde           |
| `-fx-border-width`      | Grosor del borde          |
| `-fx-effect`            | Sombras y efectos         |
| `-fx-cursor`            | Cursor del ratón          |
| `-fx-opacity`           | Transparencia (0.0 – 1.0) |

Esta sería la aplicación completa:

```java
package org.ieselcaminas.conversor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Clase principal de la aplicación JavaFX.
 * Extiende Application, que es el punto de entrada de toda app JavaFX.
 */
public class MainApp extends Application {

    // Constantes para no hardcodear valores por el código
    private static final String TITULO_APP    = "Mi Aplicación JavaFX";
    private static final double ANCHO_VENTANA = 800;
    private static final double ALTO_VENTANA  = 600;
    private static final String FXML_PRINCIPAL = "/org/ieselcaminas/conversor/views/main-view.fxml";

    /**
     * Punto de entrada REAL de JavaFX.
     * Se llama automáticamente después de launch().
     * Aquí se construye la ventana principal (Stage).
     *
     * @param stage El escenario (ventana) principal que nos proporciona JavaFX.
     */
    @Override
    public void start(Stage stage) {
        try {
            // 1. Localizamos el archivo FXML como resource del classpath
            URL fxmlUrl = getClass().getResource(FXML_PRINCIPAL);

            if (fxmlUrl == null) {
                System.err.println("ERROR: No se encontró el FXML en: " + FXML_PRINCIPAL);
                return;
            }

            // 2. Cargamos el FXML con FXMLLoader
            //    Esto también instancia e inicializa el controlador asociado
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            // 3. (Opcional) Obtenemos el controlador si necesitamos pasarle datos iniciales
            // MainController controller = loader.getController();
            // controller.setAlgunDato("valor inicial");

            // 4. Creamos la escena con el nodo raíz cargado del FXML
            Scene scene = new Scene(root, ANCHO_VENTANA, ALTO_VENTANA);

            // 5. (Opcional) Añadimos una hoja de estilos CSS externa
            URL cssUrl = getClass().getResource("/org/ieselcaminas/conversor/styles/style.css");
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            }

            // 6. Configuramos el Stage (la ventana) y lo mostramos
            stage.setTitle(TITULO_APP);
            stage.setScene(scene);
            stage.setResizable(true);      // Permite redimensionar la ventana
            stage.centerOnScreen();        // La centra en el monitor
            stage.show();                  // ¡La hace visible!

        } catch (IOException e) {
            // Error al leer/parsear el archivo FXML
            System.err.println("ERROR al cargar el FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método llamado ANTES de start().
     * Útil para inicializar recursos: conexión a BD, cargar configuración, etc.
     */
    @Override
    public void init() {
        System.out.println("Aplicación iniciando...");
        // Aquí podrías inicializar, por ejemplo:
        // - Conexión a base de datos
        // - Cargar un fichero de propiedades
        // - Preparar un servicio singleton
    }

    /**
     * Método llamado al CERRAR la aplicación.
     * Ideal para liberar recursos: cerrar conexiones, guardar estado, etc.
     */
    @Override
    public void stop() {
        System.out.println("Aplicación cerrando. Liberando recursos...");
        // Aquí podrías:
        // - Cerrar conexión a BD
        // - Guardar preferencias del usuario
        // - Detener hilos en segundo plano
    }

    /**
     * Punto de entrada del programa (main).
     * En JavaFX, main() simplemente llama a launch(),
     * que es quien arranca el ciclo de vida de la aplicación.
     *
     * @param args Argumentos de línea de comandos (raramente usados en JavaFX).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
```

