---
typora-copy-images-to: ../assets/img/refuerzo/
typora-root-url: ../../
layout: post
title: Ejercicios de ampliación
categories: varios
conToc: true
permalink: ejercicios-ampliacion
---

## 1 Pedir un número entre 0 y 9.999 y mostrarlo con las cifras al revés

> -toogle- Piensa antes de ver la solución
>
> ```java
> import java.util.Scanner;
> 
> public class AlReves {
>     public static void main(String[] args) {
>         int num;
>         int dm, um, c, d, u;
>         Scanner teclado = new Scanner(System.in);
>         // 9 9 . 9 9 9 a nombramos cada dígito así:
>         // dm um c d u: dm (decenas de millar), um:(unidades de millar)
>         // c: (centenas), d: (decenas), u: (unidades)
>         System.out.print("Introduzca un número entre 0 y 99.999: ");
>         num = teclado.nextInt();
>         teclado.close();
>         
>         // unidad
>         u = num % 10;
>         num = num / 10;
>         // decenas
>         d = num % 10;
>         num = num / 10;
>         // centenas
>         c = num % 10;
>         num = num / 10;
>         // unidades de millar
>         um = num % 10;
>         num = num / 10;
>         // decenas de millar
>         dm = num;
> 
>         // mostramos:
>         System.out.println(u + " " + d + " " + c + " " + um + " " + dm);
>         // otra forma de hacerlo es utilizando el polinomio:
>         num = 10000 * u + 1000 * d + 100 * c + 10 * um + dm;
>         System.out.println(num);
>     }
> }
> ```

## 2 Lucky number

Se desea conocer el lucky number (número de la suerte) de cualquier persona. Dicho número
se consigue reduciendo la fecha de nacimiento a un número de solo un dígito.

Por ejemplo, la fecha de nacimiento de Isabel es: 

```
03-09-1971 -> 3 + 9 + 1971 -> 3 + 9 + 1 + 9 + 7 + 1 = 30 -> 3 + 0 = 3
```

El número de la suerte de Isabel será el 3.

> -toogle- Piensa antes de ver la solución
>
> ```java
> public class LuckyNumber {
>     public static int luckyNumber(int aaaa, int mm, int dd){
>      
>         int cifra = aaaa + mm + dd;
>         int suma = 0;
> 
>         // sumar los dígitos de la cifra resultante
>         for (int i = 1; i <= 4; i++) {
>             suma = suma + (cifra % 10);
>             cifra = cifra / 10;
>         }
> 
>         if (cifra == 0 && suma > 9) {
>             // reducir lo dos digitos de la suma a uno solo
>             cifra = suma;
>             suma = cifra % 10;
>             cifra = cifra / 10;
>             suma = suma + cifra;
>         }
>        
>         return suma;
>     }
>     public static void main(String[] args) {
>         int aaaa, mm, dd;
> 
>         aaaa = 1970;
>         mm = 7;
>         dd = 12;
> 
>         System.out.println("Tu número de la suerte es: " + luckyNumber(aaaa, mm, dd));
>     }
> 
> }
> ```

## 3 Número Armstrong o narcisista

Realiza un método que, dado un número de tres cifras, averigüe si es un número Armstrong. Un número es Armstrong cuando la suma de cada uno de sus dígitos elevado al número de dígitos que componen el número da como resultado el propio número. Veamos un ejemplo:

![image-20220927195348667](/programacion-java/assets/img/refuerzo/image-20220927195348667.png)

```java
assertEquals(amstrong.armstrong(370), true);
assertEquals(amstrong.armstrong(371), true);
assertEquals(amstrong.armstrong(407), true);
assertEquals(amstrong.armstrong(698), false);
```

> -toogle- Piensa antes de mirar
>
> ```java
> public class Armstrong {
>     public static boolean armstrong(int numero) {
>         int cifra1 = numero / 100;
>         int cifra2 = (numero - 100 * cifra1) / 10;
>         int cifra3 = numero - 100 * cifra1 - 10 * cifra2;
>         double dat = Math.pow(cifra1, 3) + Math.pow(cifra2, 3) + Math.pow(cifra3, 3);
> 
>         return dat == numero;
>     }
> }
> ```

## 4 Radares de tramo

La Dirección Particular de Tráfico (DPT) está empeñada en hacer que los conductores respeten los límites de velocidad. Sin entrar en si es por razones de seguridad, por ahorrar combustible, o con un mero afán recaudatorio, ahora sabemos que además de los radares fijos tradicionales, están poniendo en funcionamiento los radares de tramo.

Desde un punto de vista formal, estos radares se basan en el teorema de Lagrange (también llamado de *valor medio* o de Bonnet-Lagrange), que dice que si tienes una función continua en un intervalo cerrado y derivable en el intervalo abierto, entonces algún punto de ese intervalo abierto tendrá derivada instantánea igual a la pendiente media de la curva en el intervalo cerrado.

Aunque asuste a primera vista, la repercusión es sencilla: si hacemos un viaje desde Madrid a Zaragoza y nuestra velocidad media es de 111Km/h, *forzosamente* en algún punto del camino, nuestra velocidad ha sido de 111Km/h.

Los radares de tramo consisten en colocar dos cámaras en dos puntos alejados de una carretera para poder comprobar cuánto tiempo ha tardado el coche en recorrer ese tramo. Si la velocidad media supera la velocidad máxima permitida, gracias al teorema anterior podremos saber (aunque no le hayamos visto) que en algún punto del trayecto ha superado esa velocidad. Por ejemplo, si colocamos las cámaras separadas 10Km en un tramo cuya velocidad está limitada a 110Km/h, y un coche tarda 5 minutos en ser visto por la segunda cámara, sabremos que su velocidad media ha sido de 120Km/h, y por tanto en algún sitio ha superado el límite de velocidad aunque al pasar por debajo de las dos cámaras el coche fuera a 80Km/h.

El programa recibe tres datos: 

* distancia en metros que separan los radares
* velocidad máxima
* tiempo empleado

```java
assertEquals(radar.esMulta(9165, 110, 300), false);
assertEquals(radar.esMulta(9165, 110, 299), true);
assertEquals(radar.esMulta(12000, 100, 433), false);
assertEquals(radar.esMulta(12000, 100, 431), true);
```

> -toogle-Piensa antes de ver la solución
>
> ```java
> public class Radar {
> 
>     static int ONE_HOUR = 3600;
>     static int ONE_KILOMETTER = 1000;
> 
>     public static boolean esMulta(double metters, double  maxTime, double timeSeconds){
>         double km = metters / ONE_KILOMETTER;
>         double timeHours = timeSeconds / ONE_HOUR;
>         double medianTime = km / timeHours;
> 
>         return !(medianTime < maxTime);
> 
>     }
> }
> ```

## Kaprekar (avanzado)

El matemático indio Dattaraya Ramchandra Kaprekar descubrió en 1949 una curiosa característica del número 6174. Hoy, se conoce a dicho número como *constante de Kaprekar* en honor a él.

El número es notable por la siguiente propiedad:

1. Elige un número de cuatro dígitos que tenga al menos dos diferentes  (es válido colocar el dígito 0 al principio, por lo que el número 0009  es válido).
2. Coloca sus dígitos en orden ascendente y en orden descendente para  formar dos nuevos números. Puedes añadir los dígitos 0 que necesites al  principio.
3. Resta el menor al mayor.
4. Vuelve al paso 2.

​    A este proceso se le conoce como *la rutina de Kaprekar*, y siempre llegará al número 6174 en, como mucho, 7 iteraciones. Una vez en él, el proceso no avanzará, dado que 7641 − 1467 = 6174.    

​    Por ejemplo, el número 3524 alcanzará la constante de Kaprekar en 3 iteraciones:    

```
5432 − 2345 = 3087
8730 − 0378 = 8352
8532 − 2358 = 6174
```

Los únicos dígitos de cuatro cifras para los que la rutina de Kaprekar *no* alcanza el número 6174 son los    *repdigits*, es decir aquellos cuyas cuatro cifras son iguales (como 1111), pues en la primera iteración se alcanzará el valor 0 y no podrá salirse de él. Es por esto que en el paso 1 se pedía explícitamente que el número inicial tuviera al menos dos dígitos diferentes.    

El resto de los números de cuatro cifras terminarán siempre en el número 6174.    

A continuación se muestran dos ejemplos más:

- El número 1121 necesita 5 iteraciones:

​         2111 − 1112 = 0999         
​         9990 − 0999 = 8991         
​         9981 − 1899 = 8082         
​         8820 − 0288 = 8532         
​         8532 − 2358 = **6174**      

- El número 1893 necesita 7:

​         9831 − 1389 = 8442         
​         8442 − 2448 = 5994         
​         9954 − 4599 = 5355         
​         5553 − 3555 = 1998         
​         9981 − 1899 = 8082         
​         8820 − 0288 = 8532         
​         8532 − 2358 = **6174**      

```java
assertEquals(kaprekar.iterations(3524), 3);
assertEquals(kaprekar.iterations(1111), 8);
assertEquals(kaprekar.iterations(1121), 5);
assertEquals(kaprekar.iterations(3524), 3);
assertEquals(kaprekar.iterations(1893), 7);
```

> -toogle-Piensa antes de ver la solución
>
> ```java
> import java.util.Arrays;
> 
> public class Kaprekar {
>     public static int descendente(int num){
>         StringBuilder s =  new StringBuilder();
>         //Convertimos a StringBuilder para poder hace reverse
>         String inverso = s.append((Integer.toString(num))).reverse().toString();
>         //Rellenamos con 0's por la izquierda
>         return Integer.parseInt(String.format("%1$-4s", inverso).replace(' ', '0'));
>     }
>     public static int ascendente(int num){
>         char[] numChar = Integer.toString(num).toCharArray();
>         Arrays.sort(numChar);
>         return Integer.parseInt(new String(numChar));
>     }
>     public static int iterations(int num){
>         int ascendente, descendente;
>         int contador = 1;
>         final int KAPREKAR =  6174;
> 
>         while (contador < 8 ){
>             ascendente = ascendente(num);
>             descendente = descendente(ascendente);
>             num =  descendente - ascendente;
>             if (num == KAPREKAR){
>                 break;
>             }
>             contador++;
>         }
>         return contador;
>     }
> }
> ```