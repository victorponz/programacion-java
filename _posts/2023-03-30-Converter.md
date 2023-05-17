---
typora-copy-images-to: ../assets/img/swing/
typora-root-url: ../../
layout: post
title: Conversor millas a kilómetros en Swing
categories: swing
conToc: true
permalink: conversion-millas-kilometros-swing
---

## Versión 1

Vamos a realizar una pequeña aplicación que nos permita convertir kilómetros en millas y viceversa:

![1552564360829](assets/img/swing/1552564360829.png) 

Está compuesto por dos cajas de texto y dos botones que permiten convertir entre las dos unidades.

Para hacer el código más mantenible, lo vamos a dividir en dos partes:

* una para crear el interfaz gráfico de usuario
* otra para manejar los eventos

De esta forma, podemos modificar el UI sin modificar la gestión de la ventana.

El prototipo de la aplicación será el siguiente:

```java
package swing.ejercicios;

import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Converter extends JFrame {
	final private Container container = getContentPane();
	
	final private JTextField textFieldMiles =  new JTextField();
	final private JTextField textFieldKilometers =  new JTextField();
	
	final private JPanel panel1 = new JPanel();
	final private JPanel panel2 = new JPanel();
	final private JButton btnConvertToKilometers = new JButton("-> Kms");
	final private JButton btnConvertToMiles = new JButton("-> Millas");

	/**
	 * Create the frame.
	 */
	public Converter() {
		createGUI();
		attachEvents();
	}
	private void createGUI() {
		//Código para crear el UI
        ;
	}
	private void attachEvents() {
        //Código para manejar los eventos
		;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Converter().setVisible(true));
	}
}
```

La parte UI la implementaremos de esta forma (cada cual la puede implementar a su gusto). Las únicas variables que debemos mantener son:

* `textFieldMiles`
* `textFieldKilometers`
* `btnConvertToKilometers`
* `btnConvertToMiles`

Pues se hace referencia a ellas en el resto del código.

![1552567884371](assets/img/swing/1552567884371.png)

Y ya sólo nos queda implementar los manejadores de eventos:

![1552567900842](assets/img/swing/1552567900842.png)

Pero no estamos controlando las excepciones: ¿Qué ocurre si introducimos algo distinto de un número? Saltará una excepción que hemos de controlar.

![1552565158826](assets/img/swing/1552565158826.png)

Modificamos ahora los manejadores para gestionar esta excepción:

![1552567921016](assets/img/swing/1552567921016.png)

También es posible crear un método para cada uno de los manejadores, de tal forma que el código todavía queda mucho más legible:

![1552567940042](assets/img/swing/1552567940042.png)

## Versión 2

Vamos a usar botones de opción:

![1552567508173](assets/img/swing/1552567508173.png)

El código será el siguiente:

```java
//*****
public class ConverterDos extends JFrame {
    //Campos usados en toda la aplicación 
	static String toKmsCommand= "K";
	static String toMilesCommnad = "M";
    
	final private ButtonGroup group = new ButtonGroup();
	 
	final private Container container = getContentPane();
	final private JPanel panel = new JPanel();
	final private JPanel panel2 = new JPanel();
	
	
	final private JTextField textFieldQuantity =  new JTextField();

	final private JButton btnConvert = new JButton("Convertir");
	
```

Modificamos el método `createGUI()`:

![1552567977069](assets/img/swing/1552567977069.png)

Y ahora modificamos el manejador de eventos:

![1552567995875](assets/img/swing/1552567995875.png)


