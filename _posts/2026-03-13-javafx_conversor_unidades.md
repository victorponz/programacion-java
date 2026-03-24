---
typora-copy-images-to: ../assets/img/javafx/
typora-root-url: ../../
layout: post
title: JavaFx Conversor unidades
categories: javafx
conToc: true
permalink: javafx-conversor-unidades
---

## Objetivo

En esta práctica vamos a crear un conversor de unidades de millas ➡️ kilómetros. 

![image-20260323101848511](/programacion-java/assets/img/javafx/image-20260323101848511.png)


> -info-Os dejo aquí el esqueleto de la [aplicación](../../assets/conversor-pasoapaso.zip)

Este es el contenido de `MainApp`

```java
package org.ieselcaminas.conversor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

     /**
     * Punto de entrada REAL de JavaFX.
     * Se llama automáticamente después de launch().
     * Aquí se construye la ventana principal (Stage).
     *
     * @param stage El escenario (ventana) principal que nos proporciona JavaFX.
     */
    @Override
    public void start(Stage stage) {
        // La ventana que vamos a mostrar
        ConverterView view = new ConverterView();
        // Cogemos del DOM la raíz para crear una escena
        Scene scene = new Scene(view.getRoot(), 780, 680);

        // El stage es la ventana
        stage.setTitle("Conversor de Distancias");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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
    /** Ciclo de vida que ejecuta JavaFX
        main()
          └─► launch()
                ├─► init()       ← preparar recursos
                ├─► start()      ← construir y mostrar la ventana  ← aquí está todo
                └─► stop()       ← liberar recursos al cerrar
    */
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



## Creación del panel  ➡️  millas

Creamos primero la vista:

```java
public class ConverterView {
    private static final int DECIMALS = 4;

    private VBox root;
    private TextField millasInput;
    private Label kmResultLabel;

    public ConverterView() {
        // En el constructor se llama a buildUI() por convención
        buildUI();
    }

    private void buildUI() {
        // La pantalla principal será una caja vertical con un separación entre cajas de 20
        root = new VBox(20);
        
        // Le ponemos padding en el interior para que no se apelotonen los controles
        root.setPadding(new Insets(32, 36, 32, 36));
        
        // Y la ponemos en el centro
        root.setAlignment(Pos.TOP_CENTER);

        // ── Título ──────────────────────────────────────────────
        Label titulo = new Label("Conversor de Distancias");
        titulo.setFont(Font.font("SansSerif", FontWeight.BOLD, 26));

        Label subtitulo = new Label("Millas  ↔  Kilómetros");

        VBox header = new VBox(4, titulo, subtitulo);
        header.setAlignment(Pos.CENTER);

        Separator sep1 = new Separator();

        // ── Un panel ─────────────────────
        VBox panelMillas = buildConversionPanelMillas();

        root.getChildren().addAll(
                header, sep1,
                panelMillas
        );

    }
    private VBox buildConversionPanelMillas() {
        // Creamos el título 
        Label panelTitulo = new Label("🏁  Millas  →  Kilómetros");
        panelTitulo.setFont(Font.font("SansSerif", FontWeight.SEMI_BOLD, 14));

        // Creamos una etiqueta para el control de de texto
        Label inputLabel = new Label("Introduce las millas:");
        millasInput = new TextField();
        millasInput.setPromptText("Ej: 10");
        // Lo hacemos máximo para que ocupe toda la caja
        millasInput.setMaxWidth(Double.MAX_VALUE);

        Label unidadLabel = new Label("kilómetros");
        // Creamos un botón que, de momento, no hace nada
        Button btnConvertir = new Button("Convertir a km");
        btnConvertir.setMaxWidth(Double.MAX_VALUE);

        // Creamos un label para mostrar el resultado
        kmResultLabel = new Label("—");
        kmResultLabel.setFont(Font.font("SansSerif", FontWeight.BOLD, 36));
        kmResultLabel.setTextAlignment(TextAlignment.CENTER);

        // Y ahora creamos una caja vertical con una separación de 2 con el resultado
        VBox resultBox = new VBox(2, kmResultLabel, unidadLabel);
        resultBox.setAlignment(Pos.CENTER);

        // Y ahora, creamos otra caja vertical para apilar todos los controles
        VBox panel = new VBox(10, panelTitulo, inputLabel, millasInput, btnConvertir, resultBox);
        panel.setStyle("-fx-background-color: -color-bg-subtle; -fx-background-radius: 8;");
        panel.setPadding(new Insets(16));

        return panel;
    }
}
```

Este debe ser el resultado:

![image-20260323081817231](/programacion-java/assets/img/javafx/image-20260323081817231.png)

### Manejo de eventos

Ahora vamos a crear la **lógica** de la ventana: al pulsar el botón, debe aparecer la conversión a kilómetros en el `millasResultadoLabel`

**Clase `DistanceConverter`**

Creamos la clase `DistanceConverter` donde se aloja la lógica para hacer los cálculos y así **separamos la lógica de la representación**.

```java
public class DistanceConverter {

    private static final double KM_PER_MILE = 1.609344;

    /**
     * Convierte millas a kilómetros.
     */
    public static double milesToKm(double miles) {
        return miles * KM_PER_MILE;
    }

    /**
     * Convierte kilómetros a millas.
     */
    public static double kmToMiles(double km) {
        return km / KM_PER_MILE;
    }

    /**
     * Formatea un número con N decimales.
     */
    public static String format(double value, int decimals) {
        return String.format("%." + decimals + "f", value);
    }
}
```

Creamos un método `convertirKmAMillas` para llamar a `DistanceConverter.kmToMiles` y actualizamos el estado de la ventana:

```java
private void convertirKmAMillas() {
    try {
        // En español, los decimales se escriben con `coma` pero java espera que sea un `punto`
        double km = Double.parseDouble(kmInput.getText().replace(",", "."));
        // Hacemos la conversión propiamente dichar
        double millas = DistanceConverter.kmToMiles(km);
        // Lo formateamos a 4 decimales
        String resultado = DistanceConverter.format(millas, DECIMALS);
        // Ponemos el resultado en el `millasResultadoLabel`
        millasResultadoLabel.setText(resultado);
        // Anima la etiqueta para que crezca
        animarLabel(millasResultadoLabel);
    } catch (NumberFormatException e) {
        millasResultadoLabel.setText("Valor inválido");
    }
}
```

Y un método para hacer una chulada:

```java
private void animarLabel(Label label) {
    ScaleTransition st = new ScaleTransition(Duration.millis(150), label);
    st.setFromX(0.85);
    st.setFromY(0.85);
    st.setToX(1.0);
    st.setToY(1.0);

    FadeTransition ft = new FadeTransition(Duration.millis(150), label);
    ft.setFromValue(0.4);
    ft.setToValue(1.0);

    st.play();
    ft.play();
}
```

**Evento `click`**

En `buildConversionPanel`, ya podemos convertir a millas

```java
// Al hacer clic
btnConvertir.setOnAction(e -> {
    convertirKmAMillas();
});
```

Ahora ya debe funcionar la conversión:

![image-20260323084320066](/programacion-java/assets/img/javafx/image-20260323084320066.png)

## Creación del panel millas   ➡️  kilómetros

Es igual que el anterior. Primero creamos el panel.

```java
private VBox buildConversionPanelKms() {
    Label panelTitulo = new Label("📍  Kilómetros  →  Millas");
    panelTitulo.setFont(Font.font("SansSerif", FontWeight.SEMI_BOLD, 14));

    Label inputLabel = new Label("Introduce los kilómetros:");

    kmInput = new TextField();
    kmInput.setPromptText("Ej: 10");
    kmInput.setMaxWidth(Double.MAX_VALUE);

    Label unidadLabel = new Label("millas");
    Button btnConvertir = new Button("Convertir a millas");
    btnConvertir.setMaxWidth(Double.MAX_VALUE);

    btnConvertir.setOnAction(e -> {
        convertirKmAMillas();
    });

    millasResultadoLabel = new Label("—");
    millasResultadoLabel.setFont(Font.font("SansSerif", FontWeight.BOLD, 36));
    millasResultadoLabel.setTextAlignment(TextAlignment.CENTER);

    VBox resultBox = new VBox(2, millasResultadoLabel, unidadLabel);
    resultBox.setAlignment(Pos.CENTER);

    VBox panel = new VBox(10, panelTitulo, inputLabel, kmInput, btnConvertir, resultBox);
    panel.setStyle("-fx-background-color: -color-bg-subtle; -fx-background-radius: 8;");
    panel.setPadding(new Insets(16));

    return panel;
}
```

Creamos el método que convierte:

```java
private void convertirKmAMillas() {
    try {
        double km = Double.parseDouble(kmInput.getText().replace(",", "."));
        double millas = DistanceConverter.kmToMiles(km);
        String resultado = DistanceConverter.format(millas, DECIMALS);
        millasResultadoLabel.setText(resultado);
        animarLabel(millasResultadoLabel);
    } catch (NumberFormatException e) {
        millasResultadoLabel.setText("Valor inválido");
    }
}
```

Y, por último, modificamos la vista principal  `buildUI` para añadir este panel:

```java
// ── Un panel para millas ─────────────────────
VBox panelMillas = buildConversionPanelMillas();

// ── Otro para los kilómetros ─────────────────
VBox panelKm = buildConversionPanelKms();

// ── Los paneles los ponemos uno al lado del otro
HBox panelesSideBySide = new HBox(16, panelMillas, panelKm);
panelesSideBySide.setAlignment(Pos.CENTER);

// ── Los paneles crecen hasta ocupar todo el ancho
HBox.setHgrow(panelMillas, Priority.ALWAYS);
HBox.setHgrow(panelKm, Priority.ALWAYS);

// ── Añadimos el nuevo panelesSideBySide ──────────
root.getChildren().addAll(
        header, sep1,
        panelesSideBySide
);
```

Este es el resultado

![image-20260323094831686](/programacion-java/assets/img/javafx/image-20260323094831686.png)

### Hoja de estilo

Los controles de javaFX se pueden estilizar mediante css. Vamos a utilizar una librería que ya trae una serie de temas predefinidos. En `pon.xml` añade esta dependencia:

```xml
<dependency>
    <groupId>io.github.mkpaz</groupId>
    <artifactId>atlantafx-base</artifactId>
    <version>2.0.1</version>
</dependency>
```

Y ahora en `MainApp.start()`

```java
....
import atlantafx.base.theme.NordDark;
....
Application.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());
```

Y ahora el look and feel es este:

![image-20260323095531906](/programacion-java/assets/img/javafx/image-20260323095531906.png)

Los temas incluidos son los siguientes:

* CupertinoDark, CupertinoLight

* NordDark, NordLight

* Dracula

* PrimerDark, PrimerLight

  

## Historial

Vamos a crear una lista donde se vayan guardando las conversiones realizadas:

![image-20260323100115288](/programacion-java/assets/img/javafx/image-20260323100115288.png)

Primero creamos la vista:

```java
...
private ListView<String> historialList;
...
private VBox buildHistorialPanel() {
    // EL título
    Label titulo = new Label("📋  Historial de conversiones");
    titulo.setFont(Font.font("SansSerif", FontWeight.SEMI_BOLD, 14));

    // Una lista para escribir las conversiones
    historialList = new ListView<>();
    historialList.setPrefHeight(120);
    historialList.getStyleClass().add(Styles.DENSE);
    historialList.setPlaceholder(new Label("Aún no hay conversiones..."));

    // Botón para limpiar la vista
    Button btnLimpiar = new Button("Limpiar historial");
    btnLimpiar.getStyleClass().add(Styles.DANGER);
    btnLimpiar.setOnAction(e -> historialList.getItems().clear());

    // Y el panel vertical donde añado todos los controles
    VBox panel = new VBox(8, titulo, historialList, btnLimpiar);
    panel.setStyle("-fx-background-color: -color-bg-subtle; -fx-background-radius: 8;");
    panel.setPadding(new Insets(16));
    return panel;
}
```

Y en `buildUI`

```java
VBox panelHistorial = buildHistorialPanel();

Separator sep2 = new Separator();

// ── Añadimos el nuevo panelHistorial ───────
root.getChildren().addAll(
        header, sep1,
        panelesSideBySide, sep2, panelHistorial
);
```

Un  nuevo método para agregar el historial:

```java
private void agregarHistorial(String entrada) {
    // Si la entrada actual ya está añadida la primera, no la agrego
    if (!historialList.getItems().isEmpty() &&
            historialList.getItems().getFirst().equals(entrada)) return;
    
    // Siempre la pongo la primera
    historialList.getItems().addFirst(entrada);
   
    // Solo caben 20 items
    if (historialList.getItems().size() > 20) {
        historialList.getItems().remove(20, historialList.getItems().size());
    }
}
```

Y ahora, en `convertirKmAMillas`

```java
agregarHistorial(String.format("%.4f km  →  %s mi", km, resultado));
```

Y en `convertirMillasAKm`

```java
 agregarHistorial(String.format("%.4f mi  →  %s km", millas, resultado));
```

Y este es el resultado:

![image-20260323101848511](/programacion-java/assets/img/javafx/image-20260323101848511.png)
