---
typora-copy-images-to: ../assets/img/tests/
typora-root-url: ../../
layout: post
title: Tests unitarios
categories: varios
conToc: true
permalink: test-unitarios
---

## ¿Qué son?

Las pruebas unitarias de software son una técnica de testing que se utiliza para **evaluar** individualmente las partes más pequeñas y aisladas  de un programa de software, llamadas **unidades**. Estas unidades suelen ser funciones, métodos o clases. El objetivo principal de las pruebas  unitarias es asegurarse de que cada unidad funcione correctamente de manera independiente antes de integrarlas en el sistema completo. Esto  ayuda a detectar y corregir errores tempranos en el proceso de  desarrollo de software, lo que mejora la calidad y la confiabilidad del  software en general.

Hasta ahora habéis probado a mano los programas que habéis hecho. Si algo falla debéis corregirlo y volver a ejecutar la prueba introduciendo manualmente los datos de nuevo.

Mediante las herramientas específicamente diseñadas para tests unitarios este proceso se automatiza y simplifica.

## JUnit

[JUnit](https://junit.org/junit5/) es un framework de java para realizar este tipo de pruebas. 

Veamos cómo funciona.

Creamos un nuevo proyecto:

![image-20230928134751626](/programacion-java/assets/img/tests/image-20230928134751626.png)

Crea un **directorio** llamado `test` que es donde vamos a guardar cada uno de los tests que vamos a lanzar.

![image-20230928135507088](/programacion-java/assets/img/tests/image-20230928135507088.png)

Y ahora vamos a decirle a IntelliJ que ahí es donde van a residir los tests. Lo hacemos pulsando el botón derecho sobre el mismo y seleccionar la opción `Mark Directory as => Test Sources Root`

![image-20230928135755201](/programacion-java/assets/img/tests/image-20230928135755201.png)

Ahora creamos la clase `Suma` y un método llamado `suma` que recibe dos parámetros

![image-20230928135051018](/programacion-java/assets/img/tests/image-20230928135051018.png)

Pulsa con el botón secundario en el nombre de la clase `Suma` y elige la opción `Show context actions`

![image-20230928135313345](/programacion-java/assets/img/tests/image-20230928135313345.png)

Y selecciona la opción `Create Test`

![image-20231002175718296](/programacion-java/assets/img/tests/image-20231002175718296.png)

En el caso de que no encuentre la librería JUnit5 dale al botón **Fix**

Este es el código generado;

```java
import static org.junit.jupiter.api.Assertions.*;

class SumaTest {

    @org.junit.jupiter.api.Test
    void suma() {
        
    }
}
```

La parte que nos interesa es el método `suma` que es el anotado como `Test` y es donde vamos a escribir los test unitarios.

Por ejemplo, 

```java
import static org.junit.jupiter.api.Assertions.*;

class SumaTest {

    @org.junit.jupiter.api.Test
    void suma() {
        //Esto significa que el resultado de llamar a Suma.suma(5, 6) es 11.
        //Si devolviera otro resultado, la prueba ha fallado
        assertEquals(11, Suma.suma(5, 6));
    }
}
```

Fijaos que han aparecido dos iconos verdes en el lateral izquierdo del Test

![image-20231004165807540](/programacion-java/assets/img/tests/image-20231004165807540.png)

El primero de ellos permite lanzar todas las pruebas que existen en el Test, mientras que el segundo botón sólo prueba el Test `suma`. Ten en cuenta que puede haber más de una función de test.

Si todo va bien al finalizar el Test, aparecerá el resultado del mismo en el panel `Run` de la parte inferior de la pantalla.

![image-20231004170111119](/programacion-java/assets/img/tests/image-20231004170111119.png)

Como veis, el Test ha sido exitoso.

Ahora vamos a modificar el método `Suma.suma` para hacerlo mal a propósito:

```java
public class Suma {
    public static int suma(int a, int b){
        return a - b;
    }
}
```

Si volvemos a ejecutar el test:

![image-20231004170305131](/programacion-java/assets/img/tests/image-20231004170305131.png)

Ahora indicar que ha salido mal y además te muestra cuál era el resultado esperado y el que ha devuelto el método `Suma.suma`

![image-20231004170449333](/programacion-java/assets/img/tests/image-20231004170449333.png)

