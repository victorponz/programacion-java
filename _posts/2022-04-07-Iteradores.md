---
typora-copy-images-to: ./programacion-java/assets/img/iteradores/
typora-root-url: ../../
layout: post
title: Iteradores
categories: varios
conToc: false
permalink: iteradores
---
Para recorrer `ArrayList` hemos estando usando `for-each`.

Por ejemplo, en la clase `GestorPersonas`:

```java
public void addSamplePersons(){
    Persona p;
    p = new Persona("Pepe", "M");
    addPersona(p);
    p = new Persona("Juan", "J");
    addPersona(p);
    p = new Persona("Ana", "A");
    addPersona(p);
    p = new Persona("Julia", "J");
    addPersona(p);
}

public void printPersons(String search){
    for (Persona p : personas){
        if (p.getNombre().contains(search)){
            System.out.println(p);
        }   
    }
}    
```

Ahora suponed que pretendemos borrar de la lista aquellas personas que tengan un determinado patrón en el nombre.

Podemos buscar la ayuda de `ArrayList` y observamos que tiene un método llamado `remove(O o)` que elimina la primera ocurrencia del objeto `o`  en la lista.

Así que es muy sencillo borrar un elemento de la lista:

```java
public void removePersonsForeach(String search){
    for (Persona p : personas){
        if (p.getNombre().contains(search)){
            //Usamos el método remove para eliminar el objeto
            personas.remove(p);
        }   
    }
}
```

Vamos a crear un nuevo objecto `GestorPersonas` y llamar al método `removePersonsForeach("u")`;

Pero ocurre lo siguiente:

![1547813064361](/programacion-java/assets/img/iteradores/1547813064361.png)

Nos ha lanzado la excepción `java.util.ConcurrentModificationException`. Esto es normal: no se puede borrar ningún elemento de un `ArrayList` usando un `for-each`.

**¿Por qué ocurre esto?**

Suponed que la lista tiene 4 personas y la 3 persona queremos borrarla. Al hacer un `for-each`, cuando borramos la 3, la lista ahora tiene 3 elementos en vez de 4!! y el elemento 4 se ha convertido en el 3. 

Podemos solucionarlo usando un bucle `for`:

```java
public void removePersonsFor(String search){
    for(int i = 0; i < personas.size(); i++){
        Persona p = personas.get(i);
        if (p.getNombre().contains(search)){
            personas.remove(i);
            //Ahora el índice lo decremento en 1.
            i--;
        }   
    }
}
```

Pero la solución extendida en Java es usar **Iteradores**. Hemos de importar la clase `import java.util.Iterator; `

Y ahora creamos el método con **Iteradores**:

```java
public void removePersonsIterator(String search){    
    Iterator<Persona> it = personas.iterator();
    while (it.hasNext()) {
        Persona p = it.next();
        if(p.getNombre().contains(search)){
            it.remove();
        }
    }
}   
```

Los `ArrayList` y otras colecciones de java tienen un método que devuelve un `Iterator`

![1547813575153](/programacion-java/assets/img/iteradores/1547813575153.png)

Este `Iterator` siempre se recorre de la misma forma:

```java
Iterator<TipoElemento> it = miLista.iterator();
while (it.hasNext()) {
    // llamar a it.next() para obtener el siguiente elemento;
    // hacer algo con ese elemento;
}
```
Ahora ya podemos usar `it.remove()` porque no salta ninguna excepción al llamar a `remove()`
