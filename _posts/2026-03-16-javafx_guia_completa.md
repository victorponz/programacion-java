---
typora-copy-images-to: ../assets/img/javafx/
typora-root-url: ../../
layout: post
title: JavaFx Primeros Pasos
categories: javafx
conToc: true
permalink: javafx-primeros-pasos
---

## 1. Ciclo de vida de la aplicación

JavaFX es el framework de interfaces gráficas moderno para Java. Su arquitectura sigue un modelo de árbol de nodos renderizado sobre un escenario.

<img src="/programacion-java/assets/img/javafx/image-20260316105919371.png" alt="image-20260316105919371" style="zoom: 50%;" />



La clase principal debe extender `javafx.application.Application` e implementar `start()`. El flujo de ejecución es el siguiente:

| Fase | Hilo | Descripción |
|---|---|---|
| `main()` | Hilo principal de Java | Punto de entrada |
| `Application.launch()` | Hilo principal de Java | Inicia el toolkit JavaFX |
| `init()` | Hilo de la aplicación (no JavaFX Thread) | Pre-inicialización. No crear nodos UI aquí |
| `start(Stage stage)` | JavaFX Application Thread | Construye y muestra la UI |
| `stop()` | JavaFX Application Thread | Limpieza al cerrar la ventana |

> -alert-**Importante:** `init()` se ejecuta en el hilo de la aplicación, no en el JavaFX Thread. Todo lo visual debe ir en `start()`.

### Ejemplo mínimo

```java
public class MiApp extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hola, JavaFX");
        Scene scene = new Scene(new StackPane(label), 400, 300);
        stage.setScene(scene);
        stage.setTitle("Mi primera app");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

---

## 2. La jerarquía Stage → Scene → Node

<img src="/programacion-java/assets/img/javafx/image-20260316110027287.png" alt="image-20260316110027287" style="zoom: 50%;" />

- **`Stage`** es la ventana nativa del sistema operativo.
- **`Scene`** vive dentro del Stage y aloja el grafo de nodos.
- El **nodo raíz** es siempre un contenedor, y a partir de él se ramifica el **Scene Graph**: un árbol de nodos que JavaFX recorre para renderizar.

---

## 3. Contenedores principales (layouts)

El primer paso para diseñar el UI es pensar qué distribución (layouts) vamos a usar. Los layouts se crean con contenedores que son los elementos que integran el resto de controles.

Los contenedores organizan sus nodos hijos según reglas de posicionamiento distintas.

<img src="/programacion-java/assets/img/javafx/image-20260316110049950.png" alt="image-20260316110049950" style="zoom: 50%;" />

### VBox

Apila los nodos hijos en **vertical**, uno debajo del otro.

```java
VBox vbox = new VBox(10); // 10px de separación entre hijos
vbox.getChildren().addAll(new Label("Uno"), new Label("Dos"), new Button("Tres"));
```

### HBox

Apila los nodos hijos en **horizontal**, uno al lado del otro.

```java
HBox hbox = new HBox(8);
hbox.getChildren().addAll(new Label("Nombre:"), new TextField());
```

### GridPane

Organiza los nodos en una **cuadrícula de filas y columnas**. Ideal para formularios.

```java
GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(8);
grid.add(new Label("Usuario:"), 0, 0); // columna 0, fila 0
grid.add(new TextField(),       1, 0); // columna 1, fila 0
grid.add(new Label("Email:"),   0, 1);
grid.add(new TextField(),       1, 1);
```

### BorderPane

Divide el espacio en **5 regiones fijas**: `Top`, `Bottom`, `Left`, `Right` y `Center`. Ideal para la estructura general de una ventana (barra de menú arriba, barra de estado abajo, panel lateral, contenido central).

```java
BorderPane border = new BorderPane();
border.setTop(new MenuBar());
border.setLeft(new ListView<>());
border.setCenter(new TextArea());
border.setBottom(new Label("Listo"));
```

### AnchorPane

Permite fijar nodos a los **bordes del contenedor** mediante anclas (distancias respecto a cada lado).

```java
AnchorPane anchor = new AnchorPane();
Button btn = new Button("Esquina");
AnchorPane.setTopAnchor(btn, 10.0);
AnchorPane.setRightAnchor(btn, 10.0);
anchor.getChildren().add(btn);
```

### StackPane

Apila los nodos **uno sobre otro**, centrados. Útil para superponer elementos (por ejemplo, un texto sobre una imagen).

```java
StackPane stack = new StackPane();
stack.getChildren().addAll(new Rectangle(200, 200), new Label("Encima"));
```

---

## 4. Componentes (controles) principales

Los controles heredan de `javafx.scene.control.Control`.

| Control | Descripción |
|---|---|
| `Button` | Botón pulsable |
| `Label` | Texto no editable |
| `TextField` | Campo de texto de una línea |
| `TextArea` | Campo de texto multilínea |
| `CheckBox` | Casilla de verificación |
| `RadioButton` | Selección exclusiva (usar con `ToggleGroup`) |
| `ComboBox<T>` | Lista desplegable |
| `ListView<T>` | Lista con selección |
| `TableView<T>` | Tabla con columnas |
| `Slider` | Selector de valor numérico |
| `ProgressBar` | Barra de progreso |
| `MenuBar` / `Menu` / `MenuItem` | Barra de menús |

### Ejemplo: RadioButton con ToggleGroup

```java
ToggleGroup grupo = new ToggleGroup();
RadioButton r1 = new RadioButton("Opción A");
RadioButton r2 = new RadioButton("Opción B");
r1.setToggleGroup(grupo);
r2.setToggleGroup(grupo);
```

### Ejemplo: TableView

```java
TableView<Persona> tabla = new TableView<>();
TableColumn<Persona, String> colNombre = new TableColumn<>("Nombre");
colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
tabla.getColumns().add(colNombre);
tabla.setItems(FXCollections.observableArrayList(lista));
```

---

## 5. Manejadores de eventos

JavaFX usa un sistema de eventos basado en **propagación** con dos fases:

1. **Capture (bajada):** el evento viaja desde la raíz hasta el nodo objetivo (*target*).
2. **Bubble (subida):** el evento sube desde el target de vuelta hacia la raíz.

<img src="/programacion-java/assets/img/javafx/image-20260316110204597.png" alt="image-20260316110204597" style="zoom: 50%;" />

Llamar a `event.consume()` en cualquier punto detiene la propagación.

---

### Formas de registrar manejadores

#### 1. `setOnXxx` — la más sencilla (fase bubble)

```java
button.setOnAction(event -> {
    System.out.println("Botón pulsado");
});

textField.setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.ENTER) {
        procesar();
    }
});

// Otros ejemplos
nodo.setOnMouseEntered(e -> nodo.setStyle("-fx-opacity: 0.8;"));
nodo.setOnMouseExited(e -> nodo.setStyle("-fx-opacity: 1.0;"));
```

#### 2. `addEventHandler` — fase bubble, permite múltiples handlers

```java
button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
    System.out.println("Click en: " + event.getX() + ", " + event.getY());
});

// Se puede añadir otro handler al mismo nodo para el mismo evento
button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
    System.out.println("Segundo handler también se ejecuta");
});
```

#### 3. `addEventFilter` — fase capture, intercepta antes de llegar al target

```java
scene.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
    System.out.println("Interceptado en capture: " + event.getTarget());
    // Descomentar para bloquear la propagación:
    // event.consume();
});
```

---

### Tipos de eventos más comunes

| Evento | Clase | Descripción |
|---|---|---|
| Acción | `ActionEvent` | Botones, menús, Enter en TextField |
| Clic / movimiento | `MouseEvent` | Clics, movimiento, arrastre del ratón |
| Teclado | `KeyEvent` | Teclas presionadas, soltadas, escritas |
| Scroll | `ScrollEvent` | Rueda del ratón o gesto de scroll |
| Arrastrar y soltar | `DragEvent` | Drag & drop entre nodos |
| Ventana | `WindowEvent` | Abrir, cerrar, minimizar ventana |
| Cambio de propiedad | `ChangeListener` | Cambio de valor en una `Property` |

---

### Properties y Bindings — el sistema reactivo de JavaFX

Las `Property` (`IntegerProperty`, `StringProperty`, `BooleanProperty`, etc.) son la clave del patrón MVC en JavaFX: permiten conectar el modelo con la vista sin acoplarlos directamente.

#### Con `ChangeListener`

```java
slider.valueProperty().addListener((observable, oldVal, newVal) -> {
    label.setText(String.format("Valor: %.0f", newVal.doubleValue()));
});
```

#### Con binding directo (sin listener explícito)

```java
// El label se actualiza automáticamente cuando cambia el slider
label.textProperty().bind(
    slider.valueProperty().asString("Valor: %.0f")
);
```

#### Binding bidireccional

```java
// Ambas propiedades se sincronizan en ambas direcciones
textField1.textProperty().bindBidirectional(textField2.textProperty());
```

#### Bindings compuestos

```java
// El botón se deshabilita si el campo está vacío
boton.disableProperty().bind(
    textField.textProperty().isEmpty()
);
```

---

*Generado a partir de conversación con Claude — JavaFX desde cero.*
