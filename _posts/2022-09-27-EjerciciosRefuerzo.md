---
typora-copy-images-to: ../assets/img/refuerzo/
typora-root-url: ../../
layout: post
title: Ejercicios de refuerzo
categories: varios
conToc: true
permalink: ejercicios-refuerzo
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
