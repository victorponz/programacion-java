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

En esta práctica vamos a crear un conversor de unidades de millas :left_right_arrow: kilómetros. 

![image-20260317114353745](/programacion-java/assets/img/javafx/image-20260317114353745.png)


> -info-Os dejo aquí el esqueleto de la [aplicación](../assets/conversor-pasoapaso.zip)

## Creación del panel km :arrow_right: millas

Creamos primero la vista:

```java
public class ConverterView {
    private static final int DECIMALS = 4;

    private VBox root;
    private TextField millasInput;
    private Label kmResultLabel;

    public ConverterView() {
        buildUI();
    }

    private void buildUI() {
        root = new VBox(20);
        root.setPadding(new Insets(32, 36, 32, 36));
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
        Label panelTitulo = new Label("🏁  Millas  →  Kilómetros");
        panelTitulo.setFont(Font.font("SansSerif", FontWeight.SEMI_BOLD, 14));

        Label inputLabel = new Label("Introduce las millas:");

        millasInput = new TextField();
        millasInput.setPromptText("Ej: 10");
        millasInput.setMaxWidth(Double.MAX_VALUE);

        Label unidadLabel = new Label("kilómetros");
        Button btnConvertir = new Button("Convertir a km");
        btnConvertir.setMaxWidth(Double.MAX_VALUE);

        btnConvertir.setOnAction(e -> {
            convertirMillasAKm();
        });

        kmResultLabel = new Label("—");
        kmResultLabel.setFont(Font.font("SansSerif", FontWeight.BOLD, 36));
        kmResultLabel.setTextAlignment(TextAlignment.CENTER);

        VBox resultBox = new VBox(2, kmResultLabel, unidadLabel);
        resultBox.setAlignment(Pos.CENTER);

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

Ahora vamos a crear la lógica de la ventana: al pulsar el botón, debe aparecer la conversión a kilómetros en el `millasResultadoLabel`

**Clase `DistanceConverter`**

En la clase `DistanceConverter`creamos la lógica para hacer los cálculo y así separamos la lógica de la representación.

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

**Evento `click`**

En `buildConversionPanel`

```java
// Al hacer click
btnConvertir.setOnAction(e -> {
    convertirKmAMilas();
});
```

Ahora ya debe funcionar la conversión:

![image-20260323084320066](/programacion-java/assets/img/javafx/image-20260323084320066.png)

## Creación del panel millas  :left_right_arrow: kilómetros

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

Y, por último, modificamos la vista principal para añadir este panel:

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
    Label titulo = new Label("📋  Historial de conversiones");
    titulo.setFont(Font.font("SansSerif", FontWeight.SEMI_BOLD, 14));

    historialList = new ListView<>();
    historialList.setPrefHeight(120);
    historialList.getStyleClass().add(Styles.DENSE);
    historialList.setPlaceholder(new Label("Aún no hay conversiones..."));

    Button btnLimpiar = new Button("Limpiar historial");
    btnLimpiar.getStyleClass().add(Styles.DANGER);
    btnLimpiar.setOnAction(e -> historialList.getItems().clear());

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
    // Si la actual ya está añadida la primera, no la agrego
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

Y ahora, cada vez que hagamos clic lo añadimos a la lista:

```java
 private void convertirKmAMillas() {
    try {
        double km = Double.parseDouble(kmInput.getText().replace(",", "."));
        double millas = DistanceConverter.kmToMiles(km);
        String resultado = DistanceConverter.format(millas, DECIMALS);
        millasResultadoLabel.setText(resultado);
        // Ahora lo añadimos al historial
        agregarHistorial(String.format("%.4f km  →  %s mi", km, resultado));

    } catch (NumberFormatException e) {
        millasResultadoLabel.setText("Valor inválido");
    }
}
private void convertirMillasAKm() {
    try {
        double millas = Double.parseDouble(millasInput.getText().replace(",", "."));
        double km = DistanceConverter.milesToKm(millas);
        String resultado = DistanceConverter.format(km, DECIMALS);
        kmResultLabel.setText(resultado);
		// Ahora lo añadimos al historial
        agregarHistorial(String.format("%.4f mi  →  %s km", millas, resultado));

    } catch (NumberFormatException e) {
        kmResultLabel.setText("Valor inválido");
    }
}

```

Y este es el resultado:

![image-20260323101848511](/programacion-java/assets/img/javafx/image-20260323101848511.png)
