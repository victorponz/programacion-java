---
typora-copy-images-to: ../assets/img/estructuras/
typora-root-url: ../../
layout: post
title: Estructuras avanzadas
categories: estructuras
conToc: true
permalink: estructuras-avanzadas
---

## Pilas

El marco de Java Collection proporciona una clase `Stack` que modela e implementa una estructura de datos Stack. La clase se basa en el principio básico de (LIFO) último en entrar, primero en salir. Además de las operaciones básicas de inserción y extracción, la clase proporciona tres funciones más de vaciar, buscar y mirar. También se puede decir que la clase extiende Vector y trata a la clase como una pila con las cinco funciones mencionadas. La clase también puede denominarse subclase de Vector.

```java
// Java code for stack implementation

import java.io.*;
import java.util.*;

class Pila
{
	// Pushing element on the top of the stack
	static void stack_push(Stack<Integer> stack)
	{
		for(int i = 0; i < 5; i++)
		{
			stack.push(i);
		}
	}
	
	// Popping element from the top of the stack
	static void stack_pop(Stack<Integer> stack)
	{
		System.out.println("Pop Operation:");

		for(int i = 0; i < 5; i++)
		{
			Integer y = (Integer) stack.pop();
			System.out.println(y);
		}
	}

	// Displaying element on the top of the stack
	static void stack_peek(Stack<Integer> stack)
	{
		Integer element = (Integer) stack.peek();
		System.out.println("Element on stack top: " + element);
	}
	
	// Searching element in the stack
	static void stack_search(Stack<Integer> stack, int element)
	{
		Integer pos = (Integer) stack.search(element);

		if(pos == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element is found at position: " + pos);
	}


	public static void main (String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();

		stack_push(stack);
		stack_pop(stack);
		stack_push(stack);
		stack_peek(stack);
		stack_search(stack, 2);
		stack_search(stack, 6);
	}
}
```

**Salida**

```
Pop Operation:
4
3
2
1
0
Element on stack top: 4
Element is found at position: 3
Element not found
```



Referencias

[https://www.geeksforgeeks.org/java-util-vector-class-java/](https://www.geeksforgeeks.org/java-util-vector-class-java/)