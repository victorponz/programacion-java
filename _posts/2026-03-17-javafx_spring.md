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

Este archivo le dice a Maven (el gestor de dependencias) qué librerías necesita descargar. Las más importantes son:

- `spring-boot-starter-data-jpa` → Para hablar con bases de datos sin escribir SQL a mano
- `h2` → Una base de datos que vive en la memoria RAM (perfecta para desarrollo, se borra al cerrar)
- `javafx-controls` → Los componentes visuales: botones, listas, campos de texto
- `atlantafx-base` → Un tema visual bonito llamado "PrimerDark" (estilo oscuro)

------

### 2. `Teacher.java` y `Departament.java` — Los modelos (las "plantillas de datos")

Estos archivos representan las tablas de la base de datos como clases Java. La anotación `@Entity` le dice a Spring: *"esta clase es una tabla en la BD"*.

```java
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;      // Columna ID, se genera sola (1, 2, 3...)

    private String name;  // Columna nombre

    @ManyToOne            // Un profesor pertenece a UN departamento
    @JoinColumn(name = "departament_id")
    private Departament departament;
}
```

La relación entre las dos entidades es:

<img src="/programacion-java/assets/img/javafx/image-20260324112953568.png" alt="image-20260324112953568" style="zoom:67%;" />

### 3. Los repositorios — El acceso a la base de datos "gratis"

```java
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
```

Esta interfaz está **completamente vacía**, pero eso es lo mágico. Al extender `JpaRepository`, Spring Data JPA le regala automáticamente todos estos métodos sin que tengas que escribir ni una línea de SQL:

- `repo.findAll()` → devuelve todos los profesores
- `repo.save(teacher)` → guarda o actualiza un profesor
- `repo.deleteById(id)` → borra un profesor por su id
- `repo.findById(id)` → busca un profesor por id

------

### 4. `JavaFxTeacherApplication.java` — El corazón de la aplicación

Este es el archivo más complejo. Hace dos cosas a la vez: **arrancar Spring Boot** y **construir la ventana**. Veamos el flujo de arranque:

<img src="/programacion-java/assets/img/javafx/image-20260324113029253.png" alt="image-20260324113029253" style="zoom:67%;" />

El truco clave está aquí:

```java
springContext = new SpringApplicationBuilder(JavaFxTeacherApplication.class).run();
```

Esto arranca Spring Boot "a mano" dentro del método `init()` de JavaFX, y guarda el contexto en `springContext`. Luego, cuando necesitamos el repositorio, lo pedimos así:

```java
TeacherRepository repo = springContext.getBean(TeacherRepository.class);
```

Es como decirle a Spring: *"dame el objeto repositorio que tú gestionas"*.

------

### 5. La interfaz gráfica — Lo que ve el usuario

La ventana se construye con contenedores y componentes:

<img src="/programacion-java/assets/img/javafx/image-20260324113101634.png" alt="image-20260324113101634" style="zoom:50%;" />

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

