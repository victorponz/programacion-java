---
typora-copy-images-to: ../assets/img/swing/
typora-root-url: ../../
layout: post
title: Programación gráfica con Swing
categories: swing
conToc: true
permalink: programacion-grafica-swing
---
## Elementos GUI

Para poder crear una interfaz GUI, hemos de comprender tres áreas:

- ¿Qué elementos se pueden mostrar en pantalla?
- ¿Cómo se pueden organizar?
- ¿Cómo reaccionan a la entrada de usuario?

Por ejemplo, algunos  elementos básicos en HTML son  `p`, `span`, `input`, `a`, `ol`, etc. Hemos de conocerlos todos porque cada uno de ellos tiene una representación en el navegador. Para organizarlos, usamos elementos contenedores como `body`, `span`, `section`, `nav,` etc, a los que vamos añadiendo otros elementos (simples, o que son a su vez contenedores). Además usamos reglas de estilo css para decorarlos. Por último, algunos de ellos pueden reaccionar a la entrada de usuario. Por ejemplo en una imagen se puede hacer clic para mostrarla más grande en una ventana modal, o se puede arrastrar un elemento por pantalla, o podemos modificar la imagen que se muestra en un carrusel, etc. Las posibilidades son infinitas.

En una aplicación Java ocurre lo mismo. En este tema aprenderemos los distintos tipos de contenedores y de componentes simples, así como las posibilidades existentes para organizarlos en pantalla. 

## 0 SWING

**Swing** es una biblioteca gráfica para Java. Incluye widgets para interfaz gráfica de usuario. Una interfaz es lo que le permite a un usuario comunicarse con un programa a través de componentes visuales como cajas de texto, botones, desplegables, tablas, etc.

## 1 Componentes y Contenedores

Un componente no es más que un objeto que representa un elemento de una interfaz gráfica y que en su mayoría tienen una representación gráfica. Se puede dividir en dos tipos:

1. **Simples o atómicos**: Son los que no están formados por otros componentes: Ejemplo: Etiquetas, botones, cajas de texto.

2. **Contenedores**: Son componentes que pueden contener a otros. Pueden ser:

   * **Contenedores de Alto Nivel**: Son aquellos que brindan un espacio dentro de la
     pantalla para todos los elementos de una interfaz gráfica. Ejemplo: `JFrame`,
     `JDialog`.
   * **Contenedores intermedios**: Permiten agrupar y organizar los componentes de
     una interfaz gráfica dentro de un contenedor de alto nivel. Ejemplo: `JPanel` 

El patrón de desarrollo que utiliza Swing es **MVC** (Modelo Vista Controlador), que permite dividir una aplicación en 3 partes:

* **Modelo**: Datos que se manejan en la aplicación.
* **Vista**: Interfaz gráfica
* **Controlador**: Permite manejar las interacciones del usuario con la interfaz gráfica y a su vez manejar los cambios entre la vista y el modelo.

## 2 Jerarquía de Componentes

Todos los componentes para el diseño de una interfaz gráfica obedecen a una jerarquía de clases.

![1526996638766](assets/img/swing/1526996638766.png)



## 3 Contenedores

### 3.1 JFrame

`JFrame` es el componente, control u objeto principal de una aplicación visual o gráfica en java.
Para crear un `Frame` deberemos crear una instancia de `JFrame`, y si deseamos modificar algunas propiedades de la ventana debemos crear una clase que extienda de `JFrame`. En este caso estamos usando **herencia**.

```java
package ejemplos.swing;

import javax.swing.*;

public class EjemploJFrame extends JFrame {
	// el constructor
	public EjemploJFrame() {
		super("Hola!!!"); // Pone un título a la ventana
		//o this.setTitle("Hola!!!");
		setSize(300, 200);// método heredado que le da un tamaño a la ventana
		
		setResizable(true); //¿Se puede cambiar el tamaño?
		setLocationRelativeTo(null); //¿La posición es relativa a?
		setVisible(true);
	}

	public static void main(String[] args) {
		//El programa main es siempre igual
		//https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploJFrame();
			}
		});
		/*
		 * También se podría hacer
		 * new EjemploJFrame();
		 * Pero esta otra forma es la indicada porque trabaja con threads
		 */
	}
}
```



Las ventanas `JFrame` son invisibles por defecto, se debe modificar la propiedad por defecto de `JFrame` de manera que nuestra ventana sea visible, para esto se llama el método `setVisible(true)`.

Algunos métodos de `JFrame` son:

* `setResizable(boolean)`: Permite hacer modificable el tamaño de la ventana
* `setState(int)`: Modificar el tamaño de la ventana, recibe como parámetro un valor entero que corresponde a una constante de JFrame, que puede ser:
  * **JFrame.NORMAL**
  * **JFrame.ICONFIED** 
* `setLocationReativeTo(Component)`: Ubicar la ventana en base a un segundo componente pasado como parámetro. Para ubicar la ventana en el centro de la pantalla el parámetro deberá ser **null**.

Al extender de la clase `JFrame`, no hace falta anteponer la palabra reservada **this** para acceder a los métodos, aunque también se puede hacer así:

```java
this.setVisible(true);
```

Para obtener una lista de los métodos disponibles desde **Eclipse** sólo hace falta pulsar las teclas `Ctrl+Esp` en el caso de que no antepongamos **this**.

Vamos a ver el mismo código usando **composición**:

```java
package ejemplos.swing;

import javax.swing.*;

public class EjemploJFrameComposition {
	// el constructor
	private JFrame frame;
	public EjemploJFrameComposition() {
		frame = new JFrame();
		frame.setTitle("Hola!!!");
		
		frame.setSize(300, 200);// método heredado que le da un tamaño a la ventana
		
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//El programa main es siempre igual
		//https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EjemploJFrameComposition();
			}
		});
		/*
		 * También se podría hacer
		 * new EjemploJFrame();
		 * Pero esta otra forma es la indicada porque trabaja con threads
		 */
	}
}

```

En este caso estamos usando composición: nuestra aplicación ya no es un `JFrame` sino que tiene un `JFrame`.

Hay una discusión acalorada en internet acerca de si es mejor usar herencia o composición. Simplemente googlea "Composition over inheritance"

### 3.2 JDialog

`JDialog` es un Componente que sirve para presentar diálogos que son ventanas auxiliares, sirven para prevención o en su defecto se puede utilizar para dar información sobre algo, los diálogos que `JDialog` muestra pueden ser **modales** o **no modales**, esto quiere decir que si son modales la ventana del diálogo bloquea las entradas a otras ventanas.
Todos los diálogos dependen de un `frame`, las modificaciones que se le hagan al frame afectarán al diálogo: en caso de que el frame sea cerrado, minimizado o maximizado, sus diálogos tendrán el mismo comportamiento

Un `JDialog` siempre deberá tener un componente **parent** del cual se derive, que debe ser un contenedor de alto nivel y sobre el cual aplicará su efecto modal o no.

```java
package ejemplos.swing;

import javax.swing.*;

public class EjemploJDialog extends JFrame {
	// el constuctor
	public EjemploJDialog() {
		super("Ejemplo ventana con dialog enfrente!");
		setTitle("Ejemplo ventana con dialog enfrente!");
		setSize(300,200);
		setVisible(true);
		JDialog cuadroDialogo= new JDialog(this, true); //Crea un dialog modal
		cuadroDialogo.setSize(100,100);
		cuadroDialogo.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploJDialog();
			}
		});
		
	}
}

```


Si ejecutas el código verás que no puedes acceder al botón de cerrar el `JFrame` padre porque el diálogo es modal.

![1526998358822](assets/img/swing/1526998358822.png)

Ahora prueba a cambiar la línea

```java
JDialog cuadroDialogo = new JDialog(this, true); // Crea un dialog modal
```

por 

```java
JDialog cuadroDialogo = new JDialog(this, false); // Crea un dialog no modal
```

y observarás que ya puedes cerrar la ventana padre (y hacer clic en ella).



#### 3.2.1 ShowMessageDialog y ShowInputDialog

Veamos como funcionan las cajas de diálogo viendo un ejemplo práctico. Utilizaremos las cajas de diálogo `MessageDialog` que muestran información:

![1526997732822](assets/img/swing/1526997732822.png)

y  `InputDialog` que piden información y el programa recoge esa información:

![1526997760047](assets/img/swing/1526997760047.png)



```java
package ejemplos.swing;

import javax.swing.JOptionPane;

public class EjemploJDialogShow {
	public static void main(String[] args) {
		String user = JOptionPane.showInputDialog(null, "user");
		String password = JOptionPane.showInputDialog(null, "password");
		if (user.equals("admin") && password.equals("1234")) {
			JOptionPane.showMessageDialog(null, "login ok");
		}else {
			JOptionPane.showMessageDialog(null, "login failed");
		}
	}
}

```

### 3.3 JPanel

`JPanel` es un objeto de los llamados *contenedores*. Es así porque sirven para contener otros objetos.
Para añadir un `JPanel` a nuestro frame primero obtenemos uno de los objetos que forman el frame: el *panel contenedor* (**content pane**). Para ello invocaremos al método `getContentPane` de nuestro `JFrame`. El objeto que nos devuelve será de tipo `Container`:

```java
Container contentpane = this.getContentPane();
```

A continuación invocamos al método `add()` del `Container` obtenido para añadir el panel, pasándole el propio panel al método:

```java
contentpane.add(panel);
```

Para agregar componentes a un panel se utiliza el método `add`:

```java
panel.add(new JButton("Clic aquí"));
```

Si no señalamos la ubicación de los componentes en el panel, éstos se ubican conforme se vayan añadiendo de manera horizontal, uno después de otro en todo el ancho de la ventana.

```java
package ejemplos.swing;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PruebaJPanel extends JFrame {
	public PruebaJPanel() {
		//Recordad que todos los métodos hacen referencia a this (es decir al JFrame)
		setTitle("Hola!!!");
		setSize(300, 200);
		
		// Le pido al JFrame su objeto contenedor
		Container contentpane = getContentPane();
		
		// Creo un objeto de tipo JPanel
		JPanel panel = new JPanel();
		
		// Añado el panel en el objeto contenedor del frame
		contentpane.add(panel);
		
		// Pongo el color de fondo del panel de color rojo
		panel.setBackground(Color.RED);
		
		//Y le añado un botón anónimo
		panel.add(new JButton("Click aquí"));
		
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new PruebaJPanel();
			}
		});
	}
}
```

## 4 Componentes simples

Todos los contenedores así como los componentes tienen propiedades que se pueden modificar mediante los métodos de la clase que corresponden, así como sus respectivos constructores.

### 4.1 JLabel

Es una etiqueta de texto que podemos colocar al lado de cualquier componente para darle una indicación al usuario de cuál es la función de dicho componente.

```java
JLabel label = new JLabel("1 x 7 = 7");
```

### 4.2 JTextField

Está pensado para obtener texto del usuario, este tecleará en él y cuando pulse `intro` podremos disponer del texto que tecleó. Únicamente se puede recoger una línea de texto.

`JTextArea`, `JTextPane` y `JTextField` son componentes básicos del `Swing` de Java y su función principal es la de capturar texto ingresado desde teclado por el usuario.

```java
package ejemplos.swing;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class PruebaJTextField extends JFrame {

	public PruebaJTextField() {

		setTitle("DATOS");
		setSize(300, 200);
		
		JLabel lblNombre = new JLabel("Nombre");

		JTextField txtNombre = new JTextField(18);
		
		JLabel lblEdad = new JLabel("Edad");
		
		JTextField txtEdad = new JTextField(10);
		
		Container contentpane = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		
		//Añadir los controles al panel
		panel.add(lblNombre);
		panel.add(txtNombre);
		panel.add(lblEdad);
		panel.add(txtEdad);
		
		contentpane.add(panel);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new PruebaJTextField();
			}
		});
	}
}
```

### 4.3 JPasswordField

Al igual que los anteriores permite al Usuario ingresar un texto que es reemplazado por un carácter que oculta lo que se escribe, por ejemplo: *. Se emplea para pedirle contraseñas al usuario y evitar que puedan ser leídas por alguien.

### 4.4 JButton

Esta clase nos permite crear botones, cuya acción al pulsar será programado con el manejo de eventos que más adelante veremos.
Para crear un botón podemos utilizar los siguientes constructores:

* `JButton()` Crea un botón sin etiqueta
* `JButton(String label)` Crea un botón con una etiqueta de texto

Si descomentamos la linea 

```java
panel.add(new JButton("Clic aquí"));
```

del código anterior veremos como se añade el botón siguiente:

![1526999658239](assets/img/swing/1526999658239.png)

### 4.5 JComboBox

Permite seleccionar un objeto (opción) de una lista que se visualiza al dar click en la pestaña de este componente.
Los constructores de la clase son:

* `JComboBox(ComboBoxModel amodel)`: Requiere un objeto Modelo para el `ComboBox`

* `JComboBox(Object [] items)`: Crea un combo, cuyos ítems corresponderán a los objetos.

```java
package ejemplos.swing;

import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PruebaCombo extends JFrame {
	public PruebaCombo() {
		setTitle("Selector!!!");
		setSize(300, 200);
		String[] opciones = { "Arriba", "Abajo", "Derecha", "Izquierda", "Todas las direcciones" };
		JComboBox<String> cmbLista = new JComboBox<String>(opciones);
		Container contentpane = getContentPane();
		JPanel panel = new JPanel();
		panel.add(cmbLista);
		contentpane.add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new PruebaCombo();
			}
		});
		
	}
}
```

Si alguien está interesado en ver cómo se puede usar una combo con objetos propios, que consulte los siguientes gist (se adelantan algunos conceptos que veremos más adelante):

* [SwingJComboBoxLibro.java](https://gist.github.com/victorponz/4319c7547913c300b04341976412407a) 
* [MyComboBoxModel.java](https://gist.github.com/victorponz/8ab3f9d1f19267a900932cb24ec2b920#file-mycomboboxmodel-java) 
* [Libro.java](https://gist.github.com/victorponz/0430be21444f5670cf31d59f7dc4067f)

### 4.6 JCheckBox

Se trata de un componente empleado para tomar información del usuario sobre aspectos del tipo booleano (verdadero/falso, si/no, etc..).
Dos de los constructores de un `JCheckBox` son:

* `JCheckBox(String)`: Crea un `JCheckBox` con etiqueta
* `JCheckBox(String,boolean)`: Crea un `JCheckBox` con etiqueta y se indica si debe aparecer seleccionado o no

### 4.7 JRadioButton

Si queremos que usuario seleccione entre varias opciones usaremos `JRadioButton`.
Dos de los constructores de un `JRadioButton` son:

* `JRadioButton(String)`: Crea un `JRadioButton` con etiqueta
* `JRadioButton(String,boolean)`: Crea un `JRadioButton` con etiqueta y se indica si debe aparecer seleccionado

Para utilizar este componente debe ser añadido a un grupo de manera que permita seleccionar una sola opción entre las del grupo. Para ello se utiliza el componente `ButtonGroup`. 

```java
package ejemplos.swing;

import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class PruebaRadioButton extends JFrame {
	public PruebaRadioButton() {
		setTitle("Elige");
		setSize(300, 200);
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("Radio1");
		JRadioButton rb2 = new JRadioButton("Radio2");
		bg.add(rb1);
		bg.add(rb2);
		Container contentpane = getContentPane();
		JPanel panel = new JPanel();
		panel.add(rb1);
		panel.add(rb2);
		contentpane.add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new PruebaRadioButton();
			}
		});
	}
}

```

## 5 Layout Manager

El layout manager es el encargado de decidir en qué posiciones se mostrarán los componentes, que tamaño tendrán, que porción del contenedor abarcarán, etc.

Un contenedor es un componente Java que puede contener otros componentes.

Si queremos cambiar el layout manager de un contenedor en un momento dado, tan sólo tendremos que llamar al método:

```java
contenedor.setLayout(LayoutManager layout);
```

Si en cualquier momento decidimos encargarnos nosotros mismos de la gestión de componentes tan sólo tendremos que escribir `contenedor.setLayout(null)` como veremos en el siguiente apartado.

Cada componente de nuestro interfaz gráfico tiene asignada una coordenada horizontal, una coordenada vertical, una longitud y una anchura determinadas. Estos valores serán los que se utilizarán para renderizar el componente en pantalla.

La clase `java.awt.Component` nos ofrece una serie de métodos para poder modificar los valores de los atributos anteriores:

```java
public void setSize(Dimension size);
public void setBounds(Rectangle r);
```

### 5.1 Layout null

Podemos decidir no utilizar layouts para ubicar los componentes de la ventana, en este caso el `Layout` se establece a **null** y en el código se decide la posición de cada botón y qué tamaño ocupa.

```java
package ejemplos.swing;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EjemploLayoutNull extends JFrame {
	final JButton boton = new JButton("Clic");

	public EjemploLayoutNull() {
		setSize(300, 200);
		Container contenedor = getContentPane();
		// Eliminamos el layout JButton
		contenedor.setLayout(null);

		contenedor.add(boton); // Añadimos el botón
		 // Botón en posicion 50,100
		// con ancho 40 pixels //alto 20
		boton.setBounds(50, 100, 80, 60);

		setVisible(true);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploLayoutNull();
			}
		});
	}
}

```

**Esto no es recomendable**. Si se expande la ventana los componentes seguirán en su sitio, no se expandirán con la ventana. Si cambiamos de sistema operativo, resolución de pantalla o fuente de letra, los componentes no se visualizarán estéticamente bien.

### 5.2 FlowLayout

Es el que tienen los paneles por defecto. Los objetos se van colocando en filas en el mismo orden en que se añadieron al contenedor. Cuando se llena una fila se pasa a la siguiente.

Tiene tres posibles constructores:

* `FlowLayout()`: crea el layout con alineación por defecto de los componentes.

* `FlowLayout(FlowLayout.LEFT|RIGTH|CENTER) `: indica la alineación de los componentes: a la izquierda, derecha o centro.

* `FlowLayout(FlowLayout.LEFT|RIGTH|CENTER, gap_horizontal, gap_vertical)` : además de la alineación de los componentes indica un espaciado (gap) entre los distintos componentes, de tal modo que no aparecen unos junto a otros.

`FlowLayout` respeta siempre el tamaño preferido de cada componente. Los componentes de cada fila se encuentran equiespaciados horizontal y verticalmente.

Veámoslo con un ejemplo:

```java
package ejemplos.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class EjemploFlowLayout extends JFrame {
	final JPanel panel = new JPanel();
	final JButton boton1 = new JButton("botón 1");
	final JButton boton2 = new JButton("Este es el botón 2");
	final JButton boton3 = new JButton("botón 3");
	public EjemploFlowLayout() {
		panel.add(boton1);
		panel.add(boton2);
		panel.add(boton3);
		setContentPane(panel);
		setSize(400, 150);
		setTitle("Prueba de FlowLayout");
		
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploFlowLayout();
			}
		});
	}
}

```



### 5.3 BorderLayout

Este layout distribuye los componentes en cinco zonas predeterminadas: son norte (NORTH), sur (SOUTH), este (EAST), oeste (WEST) y centro (CENTER). Si no especificamos ninguna región, por defecto el componente se inserta en el centro del contenedor.

![1527006536522](assets/img/swing/1527006536522.png)

Posee dos contructores:

* `BorderLayout()`
* `BorderLayout(int gap_horizontal, int gap_vertical)`: creará el layout dejando espacios horizontales y verticales entre sus distintas zonas.

En el momento de añadir componentes se debe especificar en el método `add()` la región donde queremos añadir el componente:

```java
panel.add(componente_a_añadir, BorderLayout.NORTH);
```

Veámoslo con un ejemplo

```java
package ejemplos.swing;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class EjemploBorderLayout extends JFrame {
	final JButton norte = new JButton("Norte");
	final JButton sur = new JButton("Sur");
	final JButton este = new JButton("Este");
	final JButton oeste = new JButton("Oeste");
	final JButton centro = new JButton("Centro");
	final Container panel = getContentPane();

	public EjemploBorderLayout() {
		panel.add(norte, BorderLayout.NORTH);
		panel.add(sur, BorderLayout.SOUTH);
		panel.add(este, BorderLayout.EAST);
		panel.add(oeste, BorderLayout.WEST);
		panel.add(centro, BorderLayout.CENTER);
		setSize(350, 250);
		setTitle("Prueba de BorderLayoutLayout");
		
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploBorderLayout();
			}
		});
	}
}
```

### 5.4 GridLayout

Distribuye los componentes de un contenedor en celdas y se ordenarán en el orden como sean añadidas, de izquierda a derecha y de arriba hacia abajo.

El `GridLayout` es adecuado para hacer tableros, calculadoras en que todos los botones son iguales, etc.

Todas las cuadrículas serán del mismo tamaño y crecerán o se harán más pequeñas hasta ocupar toda el área del contenedor.

Hay dos posibles constructores:

* `GridLayout(int filas, int columnas)`
* `GridLayout(int columnas, int filas, int gap_horizontal, int gap_vertical)`: especifica espaciados verticales y horizontales entre las cuadrículas.

```java
package ejemplos.swing;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class EjemploGridLayout extends JFrame {
	final Container container = getContentPane();

	public EjemploGridLayout() {
		int X = 3;
		int Y = 3;
		container.setLayout(new GridLayout(X, Y));
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				container.add(new JButton(i + "x" + j));
			}
		}
		setSize(350, 250);
		setTitle("Prueba de GridLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploGridLayout();
			}
		});
	}
}
```

### 5.5 BoxLayout

Este layout manager es uno de los más sencillos y de los más útiles. Aquí los componentes son agrupados horizontal o verticalmente dentro del contenedor que los contiene. Los componentes no se solapan de ningún modo. La anidación de paneles utilizando este layout manager nos puede permitir crear interfaces muy complejos.

El constructor de BoxLayout es muy simple:

* `BoxLayout(Container objetivo, int eje)`: Donde el parámetro entero eje puede tomar los valores

  * **X_AXIS**, los componentes se organizan de izquierda a derecha y en horizontal
  * **Y_AXIS**, los componentes se organizan de arriba a abajo y en vertical.
  * **LINE_AXIS**, los componentes se organizan como si estuviesen en una línea. Para ello se tiene en cuenta la propiedad **ComponentOrientation** del contenedor
    Si esta propiedad es horizontal entonces los componentes se organizarán horizontalmente y además según su valor lo harán de izquierda a derecha o de
    derecha a izquierda. En otro caso se organizarán verticalmente de arriba a abajo.
  * **PAGE_AXIS**, los componentes se organizan como si estuvieran en una página.
    Para ello se tiene en cuenta la propiedad **ComponentOrientation** del contenedor

La propiedad ComponentOrientation se establece por ejemplo a través de:

```java
container.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
```

Los componentes se organizan en el orden en el que se añaden al contenedor.

En el caso de organización horizontal, `BoxLayout` intentará que todos los componentes del contenedor tengan la misma altura, siendo esta la máxima de los elementos del contenedor. En caso de que no sea posible, `BoxLayout` intentará alinearlos a todos horizontalmente de modo que sus centros coincidan en una línea horizontal imaginaria que los atraviese, de manera similar, si la organización es vertical.

```java
package ejemplos.swing;

import java.awt.*;
import javax.swing.*;

public class EjemploBoxLayout extends JFrame {
	final Container container = getContentPane();
	final JPanel panel1 = new JPanel();
	final JPanel panel2 = new JPanel();

	public EjemploBoxLayout() {
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));// Orientación horizontal
		((JPanel) container).setBorder(BorderFactory.createTitledBorder("Demo BoxLayout")); // Creamos un borde

		panel1.setBorder(BorderFactory.createTitledBorder("Panel1"));// Creamos un borde
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));// Orientación vertical

		panel2.setBorder(BorderFactory.createTitledBorder("Panel2"));// Creamos un borde
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));// Orientación vertical

		for (int i = 0; i < 3; i++) {
			panel1.add(new JButton("Botón número " + i));
			panel2.add(new JButton("Botón número " + i));
		}
		container.add(panel1);
		container.add(panel2);
		setSize(350, 300);
		setTitle("Demo BoxLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);

	}

	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManaer.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// handle exception
		}
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new EjemploBoxLayout();
			}
		});
	}
}
```


