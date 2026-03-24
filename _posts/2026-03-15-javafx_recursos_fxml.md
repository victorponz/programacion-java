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

```java

```