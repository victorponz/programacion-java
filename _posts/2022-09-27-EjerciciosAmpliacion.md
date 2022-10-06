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

## 5 Kaprekar

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

## 6 Códigos de barras

En el lejano 1952, tres norteamericanos patentaron lo que terminó llamándose *código de barras*. Consiste en una técnica para representar números (y, en menos  ocasiones, letras) mediante una serie de líneas verticales paralelas,  con diferentes grosores y separaciones entre ellas. Si bien el primer  uso sirvió para identificar de manera automática los vagones de un  ferrocarril, hoy los códigos de barras se utilizan en infinidad de  lugares, siendo la catalogación de productos la más habitual.

La manera concreta de codificar mediante barras los números y las letras puede ser muy variada, lo que ha llevado a la aparición de diferentes  estándares. De todos ellos, el EAN (*European Article Number*)  resulta ser el más extendido. De éste, hay principalmente dos formatos,  que se diferencian en el ancho. Existe así el llamado EAN-8, que  codifica 8 números, y el EAN-13, que, naturalmente, codifica 13.

![image-20221006172603328](/programacion-java/assets/img/refuerzo/image-20221006172603328.png)

El último dígito del código se utiliza para detección de errores, y se calcula a partir de los demás. Para eso:

- Empezando por la derecha  (sin contar el dígito de control que se está calculando), se suman los dígitos individuales, multiplicados por un factor:  

  - Los dígitos en posiciones impares (empezando a contar por la derecha saltándonos el de control) se multiplican por 3.
  - Los dígitos en posiciones pares se multiplican por 1.

  Por ejemplo, para el código EAN-8 de la figura la operación a realizar es:

    2 · 3 + 5 · 1 + 9 · 3 + 3 · 1 + 8 · 3 + 5 · 1 + 6 · 3 = 88

- El dígito de comprobación es el número que hay que sumar al resultado anterior para llegar a un valor múltiplo de 10. En el ejemplo  de EAN-8, para llegar al múltiplo de 10 más cercano por encima del  número 88 hay que sumar 2 (y llegar al 90).  Ten en cuenta que si la suma resulta ser ya múltiplo de 10, el dígito de control será 0.

> -toogle-Piensa antes de ver la solución
>
> ```java
> public class CodigoBarras {
>     public boolean check(String codigo) {
>         int calculo, codigoControl, flag, len, n;
> 
>         len = codigo.length();
> 
>         if (len < 14) {
>             flag = 0;
>             calculo = 0;
> 
>             for (int i = len - 2; i >= 0; i--) {
>                 n = Integer.parseInt("" + codigo.charAt(i));
>                 if (flag == 0) {
>                     calculo += n * 3;
>                     flag = 1;
>                 } else {
>                     calculo += n;
>                     flag = 0;
>                 }
>             }
> 
>             codigoControl = Integer.parseInt("" + codigo.charAt(len - 1));
> 
>             if ((codigoControl + calculo) % 10 == 0) {
>                 return true;
>             } else {
>                 return false;
>             }
>         } else {
>             return false;
>         }
>     }
> }
> ```
>
> 

```java
assertEquals(codigoBarras.check("65839522"), true);
assertEquals(codigoBarras.check("65839521"), false);
assertEquals(codigoBarras.check("8414533043847"), true);
assertEquals(codigoBarras.check("5029365779425"), true);
assertEquals(codigoBarras.check("5129365779425"), false);
```

## 7 Escudos del ejército romano

Son famosas las formaciones que el antiguo ejército romano utilizaba para entrar en batalla. En esas formaciones, los legionarios se agrupaban en una figura geométrica (normalmente un rectángulo) y protegían tanto los flancos como la parte superior utilizando escudos. Los legionarios que ocupaban posiciones interiores cubrían la parte superior colocando el escudo sobre su cabeza, mientras que los que ocupaban los flancos llevaban dos y hasta tres escudos: uno para proteger la parte superior y uno o dos escudos (si estaban en la esquina) para proteger los laterales. Con esta formación, todos los legionarios quedaban protegidos por los escudos y eran muy difíciles de vencer.

Cuenta la historia que existió un general que estableció que la mejor figura para la formación no era la rectangular sino la cuadrada, de forma que el número de filas y columnas de legionarios coincidía. El problema al que se enfrentaba este general era decidir en cuántas formaciones (y de qué tamaño) debía separar su ejército para que:

- No quedara ningún legionario fuera de una formación (aunque admitía formaciones de *un único legionario*).
- Se minimizara el número de escudos necesarios para protegerlos.

Nuestro general, después de hacer muchos cálculos, decidió que la mejor manera de que estas dos condiciones se cumpliesen era comenzar haciendo  el cuadrado más grande posible con  sus legionarios. Con los que le quedasen libres volvía a repetir la  operación, y así hasta que no quedasen legionarios que formar[3](https://www.aceptaelreto.com/problem/statement.php?id=119#ftn.3). 

Por ejemplo, si el número de legionarios en el ejército era 35, la  manera utilizada por el general para hacer la formación consistía en un cuadrado de 25 legionarios (5×5), otro de 9 (3×3) y otro de 1 (1×1):

![image-20221006175121262](/programacion-java/assets/img/refuerzo/image-20221006175121262.png)

> -toogle-Piensa antes de ver la solución
>
> ```java
> public class EjercitoRomano {
> 
>     public int cuantosEscudos(int ejercito) {
>         int total, temp;
> 
>         total = 0;
>         while (true) {
>             if (ejercito == 0)
>                 break;
>             if (ejercito < 4) {
>                 total += ejercito * 5;
>                 break;
>             }
>             temp = (int) Math.sqrt(ejercito);
>             ejercito -= (temp * temp);
>             total += (temp - 2) * (temp - 2); // interior
>             total += (((temp - 2) * 4) * 2) + 12; // exterior + esquinas
>         }
>         return total;
>     }
> 
> }
> ```
>
> 

```java
assertEquals(ejercitoRomano.cuantosEscudos(35), 71);
assertEquals(ejercitoRomano.cuantosEscudos(20), 44);
assertEquals(ejercitoRomano.cuantosEscudos(10), 26);
```

## 8 ¿Cuántas me llevo?

Cuando aprendemos a sumar números pronto nos cuentan aquello de "llevarse una": cuando los dos dígitos que sumamos llegan a la decena tenemos "acarreo" que debemos sumar a los siguientes dígitos (de la izquierda).

Cuando nuestros maestros nos ponían ejercicios, antes tenían que contar cuántas veces tendríamos que "llevarnos una" y en base a eso medían la dificultad del ejercicio.

¿Puedes hacer un programa que automatice esa tarea?

> -toogle-Piensa antes de ver la solución
>
> ```java
> public class CuantasMeLlevo {
>     public int calcular(int num1, int num2) {
>         String str1 = Integer.toString(num1);
>         String str2 = Integer.toString(num2);
>         int[] n1, n2;
>         n1 = new int[Math.max(str1.length(), str2.length())];
>         n2 = new int[Math.max(str1.length(), str2.length())];
>         for (int i = 0; i < str1.length(); i++) {
>             n1[i] = Integer.parseInt(str1.charAt(str1.length() - 1 - i) + "");
>         }
>         for (int i = 0; i < str2.length(); i++) {
>             n2[i] = Integer.parseInt(str2.charAt(str2.length() - 1 - i) + "");
>         }
>         int ans = 0, carry = 0;
>         for (int i = 0; i < n1.length; i++) {
>             if ((n1[i] + n2[i] + carry) >= 10) {
>                 ans++;
>                 carry = (n1[i] + n2[i] + carry) / 10;
>             } else
>                 carry = 0;
>         }
> 
>         return ans;
>     }
> }
> 
> ```
>
> 

```java
assertEquals(cuantasMeLlevo.calcular(123, 456), 0);
assertEquals(cuantasMeLlevo.calcular(555, 555), 3);
assertEquals(cuantasMeLlevo.calcular(123, 594), 1);
```

## 9 Separar en palabras

Dado una frase, devuelve de cuántas palabras está compuesta. Ten en cuenta que las palabras pueden estar separadas por más de un espacio. No tengas en cuenta los signos de puntuación

**Sólo** se pueden usar los métodos `String.length()` y `String.charAt()`