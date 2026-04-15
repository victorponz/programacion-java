---
typora-copy-images-to: ../assets/img/javafx/
typora-root-url: ../../
layout: post
title: JavaFx + Spring
categories: javafx
conToc: true
permalink: javafx-spring
---



## ¿Qué es esta aplicación?

Es una aplicación de escritorio (ventana real en tu ordenador) que permite gestionar profesores en una base de datos. Puedes crear, editar y eliminar profesores. Por debajo usa dos tecnologías que trabajan juntas:

- **Spring Boot** → gestiona la base de datos (el "cerebro" de los datos)
- **JavaFX** → dibuja la ventana que ves en pantalla (la "cara" de la aplicación)

------

## La estructura del proyecto

Primero, el mapa de archivos importantes:

![image-20260324112837884](/programacion-java/assets/img/javafx/image-20260324112837884.png)

## Archivo por archivo

### 1. `pom.xml` — El "carrito de la compra" del proyecto

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>4.0.3</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>org.example</groupId>
    <artifactId>JavaFXTeacher</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>JavaFXTeacher</name>
    <description>JavaFXTeacher</description>
    <url/>
    <licenses>
        <license/>
    </licenses>
    <developers>
        <developer/>
    </developers>
    <scm>
        <connection/>
        <developerConnection/>
        <tag/>
        <url/>
    </scm>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <!-- Spring Boot + JPA + H2 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>20.0.2</version>
        </dependency>
        <!-- JavaFX -->
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>20.0.2</version>
        </dependency>

        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>22.0.1</version>
        </dependency>
        <!-- AtlantaFX -->
        <dependency>
            <groupId>io.github.mkpaz</groupId>
            <artifactId>atlantafx-base</artifactId>
            <version>2.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <configuration>
                    <mainClass>org.ieselcaminas.teacher.JavaFxTeacherApplication</mainClass>
                </configuration>
            </plugin>

        </plugins>
    </build>

</project>
```

Este archivo le dice a Maven (el gestor de dependencias) qué librerías necesita descargar. Las más importantes son:

- `spring-boot-starter-data-jpa` → Para hablar con bases de datos sin escribir SQL a mano
- `h2` → Una base de datos que vive en la memoria RAM (perfecta para desarrollo, se borra al cerrar)
- `javafx-controls` → Los componentes visuales: botones, listas, campos de texto
- `atlantafx-base` → Un tema visual bonito llamado "PrimerDark" (estilo oscuro)

------

### 2. `Teacher.java` y `Departament.java` — Los modelos (las "plantillas de datos")

Debes crear los `package` `org.ieselcaminas.teacher`

Estos archivos representan las tablas de la base de datos como clases Java. La anotación `@Entity` le dice a Spring: *"esta clase es una tabla en la BD"*.

```java
package org.ieselcaminas.teacher.model;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;      // Columna ID, se genera sola (1, 2, 3...)

    private String name;  // Columna nombre

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {
        
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne            // Un profesor pertenece a UN departamento
    @JoinColumn(name = "departament_id")
    private Departament departament;

    @Override
    public String toString() {
        return name;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
```

y

```java
package org.ieselcaminas.teacher.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "departament")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Departament() {
    }

    public Departament(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "departament", orphanRemoval = true)
    private Set<Teacher> teachers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public  String toString() {
        return name;
    }
}
```

La relación entre las dos entidades es:

<img src="/programacion-java/assets/img/javafx/image-20260324112953568.png" alt="image-20260324112953568" style="zoom:67%;" />

### 3. Los repositorios — El acceso a la base de datos "gratis"

```java
package org.ieselcaminas.teacher.repository;

import org.ieselcaminas.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
```

y

```java
package org.ieselcaminas.teacher.repository;

import org.ieselcaminas.teacher.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {}
```

Esta interfaz está **completamente vacía**, pero eso es lo mágico. Al extender `JpaRepository`, Spring Data JPA le regala automáticamente todos estos métodos sin que tengas que escribir ni una línea de SQL:

- `repo.findAll()` → devuelve todos los profesores
- `repo.save(teacher)` → guarda o actualiza un profesor
- `repo.deleteById(id)` → borra un profesor por su id
- `repo.findById(id)` → busca un profesor por id

------

### 4 El Controlador y la vista

Esta clase va a gestionar toda la lógica de la aplicación (de momento, no hace nada):

```java
package org.ieselcaminas.teacher.controller;

import org.springframework.context.ApplicationContext;

public class TeacherController {

    private ApplicationContext springContext;

    // 🔌 Inyectamos Spring manualmente
    public void setSpringContext(ApplicationContext context) {
        this.springContext = context;
    }

}
```

Y ahora creamos la vista `teacher-view.fxml`, guardada en el directorio de recursos:

```java
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.*?>

<VBox spacing="10" style="-fx-padding: 20;"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="org.ieselcaminas.teacher.controller.TeacherController">
</VBox>
```

### 5. `JavaFxTeacherApplication.java` — El corazón de la aplicación

```java
package org.ieselcaminas.teacher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.ieselcaminas.teacher.controller.TeacherController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaFxTeacherApplication extends Application {

    private ConfigurableApplicationContext springContext;


    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(JavaFxTeacherApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
		// Creamos la ventana que hemos creado con SceneBuilder
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/teacher-view.fxml"));
        VBox root = loader.load();

        // 🔌 Pasar Spring al controller
        TeacherController controller = loader.getController();
        controller.setSpringContext(springContext);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Teacher CRUD");
        stage.show();
    }

    @Override
    public void stop() {
        springContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
```

Este es el archivo más complejo. Hace dos cosas a la vez: **arrancar Spring Boot** y **construir la ventana**. Veamos el flujo de arranque:

<img src="/programacion-java/assets/img/javafx/image-20260324113029253.png" alt="image-20260324113029253" style="zoom:67%;" />



------

### 6. La interfaz gráfica — Lo que ve el usuario

> -alert- Para poder ejecutar la aplicación desde el botón Ejecutar, has de crear una Configuración desde 
>
> ![image-20260414095300331](/programacion-java/assets/img/javafx/image-20260414095350260.png)
>
> ![image-20260414095408019](/programacion-java/assets/img/javafx/image-20260414095408019.png)
>
> Ahora, dale ejecutar a la configuración recién creada.



Hasta ahora, hemos creado la siguiente interfaz:

![image-20260413101458777](/programacion-java/assets/img/javafx/image-20260413101458777.png)

Vamos a empezar a definir la ventana principal de la aplicación que se construye con contenedores y componentes. Vamos a ir creando el resto de controles junto con los controladores de eventos.

#### Añadir

Primero el `label` y el `inputText` para el nombre del profesor y la lista de profesores. Añade lo siguiente al archivo `teacher-view.fxml` dentro del contenedor `VBox`

```xml
     <!-- Input -->
    <HBox spacing="10">
        <Label text="Nombre del profesor:"/>
        <TextField fx:id="nameField" promptText="Escribe el nombre"/>
    </HBox>
    <!-- Buttons -->
    <HBox spacing="10">
        <Button text="Guardar"/>
    </HBox>
    <!-- List -->
    <ListView fx:id="teacherList" prefHeight="200"/>
```

![image-20260413102123981](/programacion-java/assets/img/javafx/image-20260413102123981.png)



Ahora, cuando el usuario pulse guardar, vamos a guardarlo en la BBDD y a añadirlo a la lista.

El proceso consta de 2 partes:

1. Crear un método en el controlador ` onSave`

   ```java
   package org.ieselcaminas.teacher.controller;
   
   import javafx.collections.FXCollections;
   import javafx.collections.ObservableList;
   import javafx.fxml.FXML;
   import javafx.scene.control.ListView;
   import javafx.scene.control.TextField;
   import org.ieselcaminas.teacher.model.Teacher;
   import org.ieselcaminas.teacher.repository.TeacherRepository;
   import org.springframework.context.ApplicationContext;
   
   public class TeacherController {
   
       private ApplicationContext springContext;
       
       @FXML // El campo para el nombre
       private TextField nameField;
   
       @FXML
       private ListView<Teacher> teacherList;
       // Creamos una lista que se va a mantener sincronizada automáticamente
       // con el ListView
       private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
   
       // 🔌 Inyectamos Spring manualmente
       public void setSpringContext(ApplicationContext context) {
           this.springContext = context;
       }
       @FXML
       public void initialize() {
           // Le decimos al ListView que tiene que estar sincronizada con la List `teachers`
           teacherList.setItems(teachers);
       }
       @FXML
       private void onSave() {
           String name = nameField.getText().trim(); // Quitamos espacios en blancos del principio y final
           if (!name.isEmpty()) {
               //Cogemos el repositorio asociado a Teacher
               TeacherRepository repo = springContext.getBean(TeacherRepository.class);
               // Lo guardamos
               Teacher teacher = repo.save(new Teacher(name));
               teachers.add(teacher);
           }
           nameField.clear();
       }
   }
   ```

   

2. Asociar dicho método al botón guardar.

   ```xml
       <!-- Buttons -->
       <HBox spacing="10">
           <Button text="Guardar" onAction="#onSave"/>
       </HBox>
   ```

#### Modificar

Ahora vamos a modificar un elemento de la lista al hacer doble clic en un elemento de la vista.

Primero nos creamos una propiedad en el controlador para discriminar si estamos editando un `teacher`

```java
// Esta variable almacena el teacher sobre el que se ha hecho doble clic para editarlo
private Teacher teacherEditing = null;
```

Y ahora creamos el evento en `initialize()`

```java
@FXML
public void initialize() {
    teacherList.setItems(teachers);

    teacherList.setOnMouseClicked(event -> {
        // en `event` tenemos mucha información, por ejemplo si se ha hecho doble clic
        if (event.getClickCount() == 2) {
            // Cogemos el `teacher` seleccionado
            Teacher selected = teacherList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                // Si hay algo, rellenamos el campo nombre
                nameField.setText(selected.getName());
                teacherEditing = selected; // Marcamos que estamos editando este teacher
            }
        }
    });
}
```

Y ahora vamos a modificar la acción de guardar, para saber si es nuevo o estamos editando:

```java
saveBtn.setOnAction(e -> {
    String name = nameField.getText().trim();
    if (!name.isEmpty()) {
        TeacherRepository repo = springContext.getBean(TeacherRepository.class);
        // NO estamos editando, por tanto `teacherEditing` es nulo
        if (teacherEditing == null) {
            Teacher teacher = repo.save(new Teacher(name));
            teachers.add(teacher);
        } else {
            // Aquí SÍ estamos estamos editando, por lo que obtenemos
            // el `teacher` cuyo `id` sea el de `teacherEditing`
            Teacher teacher = repo.findById(teacherEditing.getId()).orElse(null);
            if (teacher != null) {
                // Hay que actualizar tanto el nombre del `teacher` como del `teacherEditing`
                // para que se coordinen
                teacher.setName(name);
                repo.save(teacher);
                teacherEditing.setName(name);
                teacherList.refresh();
            }
            // Ya hemos acabado, ya no estamos editando
            teacherEditing = null;
        }
        nameField.clear();
    }
});
```

####  Eliminar

Añadir el botón en `teacher-view.fxml` 

```xml
    <HBox spacing="10">
        <Button text="Guardar" onAction="#onSave"/>
        <Button text="Eliminar" onAction="#onDelete"/>
    </HBox>
```

y el método `onDelete`

```java
@FXML
private void onDelete() {
    // Obtener el repositorio de profesores
    TeacherRepository repo = springContext.getBean(TeacherRepository.class);
    // Obtener el `teacher` seleccionado
    Teacher selected = teacherList.getSelectionModel().getSelectedItem();
    if (selected != null) {
        repo.deleteById(selected.getId()); // DELETE en BD
        teachers.remove(selected);         // quita de la lista visual
    }
}
```

------

### 7. `ObservableList` — La "lista mágica" de JavaFX

```java
private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
```

**Esta no es una lista normal**. Es una lista que la `ListView` "observa" continuamente. Cuando haces `teachers.add(...)` o `teachers.remove(...)`, la ventana se actualiza sola automáticamente, sin que tengas que decirle nada más.

------

## Flujo completo de una operación

<img src="/programacion-java/assets/img/javafx/image-20260324113204416.png" alt="image-20260324113204416" style="zoom:50%;" />



## Departamentos

Vamos a implementar la relación `1:n` entre Profesores y Departamentos.

Primero creamos una vista para el departamento llamada `departament-view.fxml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.*?>

<?import javafx.scene.control.TextField?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.ListView?>
<VBox spacing="10" style="-fx-padding: 20;"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="org.ieselcaminas.teacher.controller.DepartamentController">
    <!-- Input -->
    <HBox spacing="10">
        <Label text="Nombre del departamento:"/>
        <TextField fx:id="nameField" promptText="Escribe el nombre"/>
    </HBox>
    <!-- Buttons -->
    <HBox spacing="10">
        <Button text="Guardar" onAction="#onSave"/>
        <Button text="Eliminar" onAction="#onDelete"/>
    </HBox>
    <!-- List -->
    <ListView fx:id="departamentList" prefHeight="200"/>
</VBox>
```

Esta vista tiene los mismos componentes que `teacher-view.fxml`

Ahora añadimos un botón en la vista `teacher-view` para que abra la vista `departament-view`

```xml
    <HBox spacing="10">
        <Button text="Guardar" onAction="#onSave"/>
        <Button text="Eliminar" onAction="#onDelete"/>
        <Button text="Gestionar departamentos" onAction="#onOpenDepartaments"/> // Este botón es nuevo
    </HBox>
```

Y ahora implementamos el método `onOpenDepartaments` en `TeacherController` 

```java
/**
 * Botón Gestionar departamentos: abre la ventana modal de departamentos.
 */
@FXML
private void onOpenDepartaments() throws IOException {
    // Cargamos la vista del departamento
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/departament-view.fxml"));

    Stage deptStage = new Stage();
    // Aquí le estamos diciendo que esta ventama pertenece a la ventana a la que pertenece la lista
    deptStage.initOwner(teacherList.getScene().getWindow());
    // Y la abrimpo modal
    deptStage.initModality(Modality.WINDOW_MODAL);
    deptStage.setTitle("Gestión de departamentos");
    deptStage.setScene(new Scene(loader.load(), 480, 400));

    // Inyectamos el contexto en el controlador de departamentos
    DepartamentController deptController = loader.getController();
    deptController.setSpringContext(springContext);
    deptController.initialize();

    deptStage.show();
}
```

> -info-Una ventana `modal` es un tipo de ventana que se superpone a todas las demás y en la que el foco no puede salir de la misma, a no ser que la cerremos

Por último, creamos `departamentController` que es igual que `teacherController` pero para la entidad `departament`

![image-20260415090721959](/programacion-java/assets/img/javafx/image-20260415090721959.png)

#### Últimos retoques

Modificamos `teacher-view.fxml` para añadir un combo box para poder seleccionar un departamento para el profesor:

```xml
    <!--
       Fila: selector de departamento.
       fx:id="departamentCombo" lo inyecta TeacherController con @FXML.
       promptText aparece cuando no hay nada seleccionado.
   -->
    <HBox spacing="10" alignment="CENTER_LEFT">
        <Label text="Departamento:"/>
        <ComboBox fx:id="departamentCombo"
                  promptText="Sin departamento"
                  HBox.hgrow="ALWAYS"
                  maxWidth="Infinity"/>
    </HBox>
```

En `TeacherController`

```java
@FXML 
private ComboBox<Departament> departamentCombo;  // ← NUEVO

/**
 * Lista compartida de departamentos.
 * Esta MISMA instancia se pasa al DepartamentController, de modo que
 * cualquier add/remove que haga ese controlador se refleja aquí
 * automáticamente gracias a que ObservableList notifica a sus observadores.
 */
private final ObservableList<Departament> departaments = FXCollections.observableArrayList();  // ← NUEVO

public void initialize() {
    // ── Configurar ComboBox ──────────────────────────────────────────
	departamentCombo.setItems(departaments); // ← NUEVO
 	....
}

 teacherList.setOnMouseClicked(event -> { // ← MODIFICADO
    // en `event` tenemos mucha información, por ejemplo si se ha hecho doble clic
    if (event.getClickCount() == 2) {
        // Cogemos el `teacher` seleccionado
        Teacher selected = teacherList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            // Si hay algo, rellenamos el campo nombre
            nameField.setText(selected.getName());
            teacherEditing = selected; // Estamos editando este `teacher`
            // Seleccionar el departamento actual en el combo.
            // Buscamos en la lista del combo el que tenga el mismo id.
            if (selected.getDepartament() != null) {
                departaments.stream()
                        .filter(d -> d.getId().equals(selected.getDepartament().getId()))
                        .findFirst()
                        .ifPresent(departamentCombo::setValue);
            } else {
                departamentCombo.setValue(null);
            }
        }
    }
});

@FXML
private void onSave() { // ← MODIFICADO
    String name = nameField.getText().trim();
    // Coger el departamento del combo
    Departament selectedDept = departamentCombo.getValue(); // puede ser null
    if (!name.isEmpty()) {
        TeacherRepository repo = springContext.getBean(TeacherRepository.class);
        // NO estamos editando, por tanto `teacherEditing` es nulo
        if (teacherEditing == null) {
            Teacher teacher = repo.save(new Teacher(name));
            // Fijar el departamento
            teacher.setDepartament(selectedDept);
            teachers.add(teacher);
        } else {
            // Aquí SÍ estamos editando, por lo que obtenemos
            // el `teacher` cuyo `id` sea el de `teacherEditing`
            Teacher teacher = repo.findById(teacherEditing.getId()).orElse(null);
            if (teacher != null) {
                // Hay que actualizar tanto el nombre del `teacher` como del `teacherEditing`
                // para que se coordinen
                teacher.setName(name);
                // Fijar el departamento
                teacher.setDepartament(selectedDept);
                repo.save(teacher);
                teacherEditing.setName(name);
                teacherList.refresh();
            }
            // Ya hemos acabado, por lo que ya no estamos editando
            teacherEditing = null;
        }
        nameField.clear();
        departamentCombo.setValue(null);
    }
}

@FXML
private void onOpenDepartaments() throws IOException {  // ← MODIFICADo
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/departament-view.fxml"));

    Stage deptStage = new Stage();
    deptStage.initOwner(teacherList.getScene().getWindow());
    deptStage.initModality(Modality.WINDOW_MODAL);
    deptStage.setTitle("Gestión de departamentos");
    deptStage.setScene(new Scene(loader.load(), 480, 400));

    // Inyectamos el contexto en el controlador de departamentos
    DepartamentController deptController = loader.getController();
    deptController.setSpringContext(springContext);
    // ↓ Pasamos nuestra lista compartida: el controlador de depts
    //   operará sobre ella en lugar de crear la suya propia.
    deptController.setDepartaments(departaments);  // ← NUEVO
    deptController.initialize();

    deptStage.show();
}
```

En `DepartamentController`

```java
// Esta lista es la que se comparte entre la ventana del profesor y la del departamento para que se actualice automáticamente
private ObservableList<Departament> departaments = FXCollections.observableArrayList();

/**
 * Recibe la ObservableList del TeacherController para operar sobre ella.
 * Debe llamarse ANTES de initialize().
 */
public void setDepartaments(ObservableList<Departament> 
                            departaments) { // ← NUEVO
    this.departaments = departaments;
}
```



## Resumen de conceptos clave

En esta aplicación están presentes varios conceptos fundamentales que conviene tener claros:

* **`@SpringBootApplication`** — Le dice a Spring que esta clase es el punto de entrada y que active toda su magia automática (escaneo de componentes, configuración automática, etc.).

* **`@Entity`** — Convierte una clase Java en una tabla de base de datos. Cada campo de la clase es una columna.

* **`@Id` + `@GeneratedValue`** — Marca el campo como clave primaria y hace que se genere automáticamente (1, 2, 3...).

* **`@ManyToOne` / `@OneToMany`** — Definen relaciones entre tablas directamente desde Java, sin escribir SQL de relaciones.

* **`JpaRepository`** — Interfaz mágica de Spring que proporciona todos los métodos CRUD sin escribir nada.

* **`ObservableList`** — Lista especial de JavaFX que avisa a la interfaz gráfica cuando cambia, actualizándola automáticamente.

* **`springContext.getBean(...)`** — La forma de pedirle a Spring un objeto que él gestiona, desde fuera de su sistema de inyección habitual.

