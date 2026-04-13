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
    <name>JavaFXTecher</name>
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

Estos archivos representan las tablas de la base de datos como clases Java. La anotación `@Entity` le dice a Spring: *"esta clase es una tabla en la BD"*.

```java
package org.ieselcaminas.teacher;

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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne            // Un profesor pertenece a UN departamento
    @JoinColumn(name = "departament_id")
    private Departament departament;

}
```

y

```java
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "departament")
public class Departament {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

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
}
```

La relación entre las dos entidades es:

<img src="/programacion-java/assets/img/javafx/image-20260324112953568.png" alt="image-20260324112953568" style="zoom:67%;" />

### 3. Los repositorios — El acceso a la base de datos "gratis"

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
```

y

```java
import org.springframework.data.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
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
package org.ieselcaminas.teacher;

import org.springframework.context.ApplicationContext;

public class TeacherController {

    private ApplicationContext springContext;

    // 🔌 Inyectamos Spring manualmente
    public void setSpringContext(ApplicationContext context) {
        this.springContext = context;
    }

}
```

Y ahora creamos la vista `teacher-view.fxml`, guarda en el directorio de recursos:

```java
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.*?>

<VBox spacing="10" style="-fx-padding: 20;"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="org.ieselcaminas.teacher.TeacherController">
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

Hasta ahora, hemos creado la siguiente interfaz:

![image-20260413101458777](/programacion-java/assets/img/javafx/image-20260413101458777.png)

La ventana se construye con contenedores y componentes. Vamos a ir creando el resto de controles junto con los controladores de eventos.

Primero el `label` y el `inputText` para el nombre del profesor. Añade lo siguiente al archivo `teacher-view.fxml`

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
   package org.ieselcaminas.teacher;
   
   import javafx.fxml.FXML;
   import javafx.scene.control.Label;
   import javafx.scene.control.ListView;
   import javafx.scene.control.TextField;
   import org.springframework.context.ApplicationContext;
   
   public class TeacherController {
   
       private ApplicationContext springContext;
       @FXML // El campo para el nombre
       private TextField nameField;
   
       @FXML
       private ListView<Teacher> teacherList;
       // 🔌 Inyectamos Spring manualmente
       public void setSpringContext(ApplicationContext context) {
           this.springContext = context;
       }
       @FXML
       private void onSave() {
           
           String name = nameField.getText().trim(); // Quitamos espacios en blancos del principio y final
           if (!name.isEmpty()) {
               //Cogemos el repositorio asociado a Teacher
               TeacherRepository repo = springContext.getBean(TeacherRepository.class);
               // Lo guadamos
               Teacher teacher = repo.save(new Teacher(name));
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

   

### 6. Los tres botones y cómo funcionan

El comportamiento del botón **Guardar** distingue si estás creando o editando gracias a la variable `teacherEditing`:

```java
// Si teacherEditing es null → crear nuevo profesor
if (teacherEditing == null) {
    Teacher teacher = repo.save(new Teacher(name)); // INSERT en BD
    teachers.add(teacher);                          // añade a la lista visual
} else {
    // Si teacherEditing tiene valor → modificar el existente
    teacher.setName(name);
    repo.save(teacher);          // UPDATE en BD
    teacherList.refresh();       // refresca la lista visual
    teacherEditing = null;       // vuelve a modo "crear"
}
```

El botón **Eliminar** borra lo que esté seleccionado en la lista:

```java
Teacher selected = teacherList.getSelectionModel().getSelectedItem();
repo.deleteById(selected.getId()); // DELETE en BD
teachers.remove(selected);         // quita de la lista visual
```

Y el **doble clic** en un elemento de la lista activa el modo edición:

```java
if (event.getClickCount() == 2) {
    nameField.setText(selected.getName()); // rellena el campo
    teacherEditing = selected;             // activa modo edición
}
```

------

### 7. `ObservableList` — La "lista mágica" de JavaFX

```java
private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
```

Esta no es una lista normal. Es una lista que la `ListView` "observa" continuamente. Cuando haces `teachers.add(...)` o `teachers.remove(...)`, la ventana se actualiza sola automáticamente, sin que tengas que decirle nada más.

------

## Flujo completo de una operación

<img src="/programacion-java/assets/img/javafx/image-20260324113204416.png" alt="image-20260324113204416" style="zoom:50%;" />

## Resumen de conceptos clave

En esta aplicación están presentes varios conceptos fundamentales que conviene tener claros:

* **`@SpringBootApplication`** — Le dice a Spring que esta clase es el punto de entrada y que active toda su magia automática (escaneo de componentes, configuración automática, etc.).

* **`@Entity`** — Convierte una clase Java en una tabla de base de datos. Cada campo de la clase es una columna.

* **`@Id` + `@GeneratedValue`** — Marca el campo como clave primaria y hace que se genere automáticamente (1, 2, 3...).

* **`@ManyToOne` / `@OneToMany`** — Definen relaciones entre tablas directamente desde Java, sin escribir SQL de relaciones.

* **`JpaRepository`** — Interfaz mágica de Spring que proporciona todos los métodos CRUD sin escribir nada.

* **`ObservableList`** — Lista especial de JavaFX que avisa a la interfaz gráfica cuando cambia, actualizándola automáticamente.

* **`springContext.getBean(...)`** — La forma de pedirle a Spring un objeto que él gestiona, desde fuera de su sistema de inyección habitual.

