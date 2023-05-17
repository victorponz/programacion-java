---
typora-copy-images-to: ../assets/img/swing/img/swing/
typora-root-url: ../../
layout: post
title: Bloc de notas en Swing
categories: swing
conToc: true
permalink: bloc-de-notas--swing
---


Vamos a crear una aplicación de bloc de notas mediante Swing.

<video src='assets/img/swing/blocdenotas.m4v' controls='controls' ></video>

En este ejercicio aprenderás a:

* Crear menús
* Crear toolbars
* Mostrar ventanas de diálogo para seleccionar un fichero
* Leer/escribir en ficheros de texto
* Mostrar otras ventanas.

Partimos del siguiente código:
```java
package swing.ejercicios.block;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Block extends JFrame {

	private Container contentPane = getContentPane();
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public Block() {
		
		setTitle("Bloc de notas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Fijamos el tamaño preferido. Se usará este tamaño cada vez que llamemos a
		// pack()
		setPreferredSize(new Dimension(800, 400));

		setJMenuBar(createMenu());

		contentPane.add(createToolbar(), BorderLayout.NORTH);

		contentPane.add(createTextArea(), BorderLayout.CENTER);

		pack();
		
		//Es importante llamar a este método después de hacer pack, ya que ahora ya sabe las
		//dimensiones de la ventana!!
		setLocationRelativeTo(null); 
		
	}
	
	private JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnNewMenu = new JMenu("Fichero");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNew = new JMenuItem("Nuevo");
		mntmNew.setMnemonic(KeyEvent.VK_N);
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mntmNew.addActionListener((e) -> {
			newTextArea();
		});
	
		mntmNew.setIcon(getIcon("new.png"));
		mnNewMenu.add(mntmNew);
		
		//TODO
		//Añadir el resto de menús y de ítems
		
		return menuBar;
	}
	private ImageIcon getIcon(String iconName) {
		//las imágenes deben estar en el directorio indicado. Cámbialo por el tuyo, si hace falta
		Image image;
		try {
			image = ImageIO.read(new File("./src/swing/ejercicios/block/images/" + iconName));
		}catch(IOException ioe) {
			return null;
		}
		return new ImageIcon(image);
	}
	
	private JScrollPane createTextArea() {
		textArea = new JTextArea();
		return new JScrollPane(textArea);
	}

	private JToolBar createToolbar() {
		JToolBar toolBar = new JToolBar();

		JButton btnSaveButton = new JButton("Guardar");
		btnSaveButton.addActionListener((e) -> {
			save();
		});
		btnSaveButton.setIcon(getIcon("save.png"));
		toolBar.add(btnSaveButton);

		//TODO
		//Crear el botón Abrir
		
		return toolBar;
	}
	/**
	 * Limpia la caja de texto textArea
	 */
	private void newTextArea() {
		//TODO
		System.out.println("Nuevo");
	}
	
	/**
	 * Muestra la ventana About
	 */
	private void showAbout() {
		//TODO
		System.out.println("About");
	}

	/**
	 * Muestra un diálogo para seleccionar un archivo y lo carga en la caja de texto textArea
	 */
	private void load() {
		//TODO
		System.out.println("load");
	}

	/**
	 * Muestra un diálogo para seleccionar un archivo y guarda en él el contenido de la caja de texto textArea
	 */
	private void save() {
		//TODO
		System.out.println("save");
	}
	/**
	 * Cierra el JFrame y finaliza la aplicación
	 */
	private void salir() {
		//TODO
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new Block().setVisible(true));
	}
}

```

## Crear menú
>-info- En este [enlace](assets/images-bloc-notas.zip) tenéis los iconos usados

Para asignar un menú a un `JFrame` debemos:

* crear una barra de menús, mediante la clase `JMenuBar` e ir añadiendo ítems
* finalmente, asignar esta barra al `JFrame`

Para facilitar la lectura de código vamos a escribir todo el código relativo a la creación de la barra de menús en un método llamado `createMenu()` que devuelve un `JMenuBar`.  

En el ejemplo, ya tenéis creada la barra de menús 

![1554290641121](assets/img/swing/1554290641121.png)

```java
private JMenuBar createMenu() {
	JMenuBar menuBar = new JMenuBar();
	JMenu mnNewMenu = new JMenu("Fichero");
	menuBar.add(mnNewMenu);

	JMenuItem mntmNew = new JMenuItem("Nuevo");
	mntmNew.setMnemonic(KeyEvent.VK_N);
	mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
	mntmNew.addActionListener((e) -> {
		newTextArea();
	});

	// iconos por defecto
	// http://6iserver.osinerg.gob.pe/discwb4/applet/com/sun/java/swing/plaf/windows/icons/
	mntmNew.setIcon(new ImageIcon(BlockV0.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
	mnNewMenu.add(mntmNew);
	
	//TODO
	//Añadir el resto de menús y de ítems
	
	return menuBar;
}
```

Los pasos son:

1. crear la barra de menús mediante  `new JMenuBar()`.
2. crear un nuevo menú mediante `new JMenu("Fichero");` y añadirlo a la barra creada mediante`menuBar.add(mnNewMenu);`
3. crear un nuevo ítem mediante `new JMenuItem("Nuevo");` ponerle atributos y añadirlo al menú mediante `mnNewMenu.add(mntmNew);`
4. devolver la barra `JMenuBar` creada

Asignar esta barra de menús es tan sencillo como:

```java
public Block() {
    //....
    setJMenuBar(createMenu());
    //....
}
```



### Ejercicio

Debéis completar el menú:

![1554290987379](assets/img/swing/1554290987379.png)

![1554291026193](assets/img/swing/1554291026193.png)

Los métodos que deben implementar los listeners ya están creados. Sólo debéis crear el `ActionListener` para cada ítem del menú llamando al método correspondiente: `showAbout()`, `load()`, `save()`, `salir()`.

Estos métodos los iremos creando poco a poco.

## Crear toolbar

Para añadir un toolbar a un `JFrame` debemos:

- crear un toolbar, mediante la clase `JToolBar` e ir añadiendo botones
- finalmente, añadir el toolbar al `JFrame`

Para facilitar la lectura de código vamos a escribir todo el código relativo a la creación del toolbar en un método llamado `createToolbar()` que devuelve un `JToolBar`.  

En el ejemplo, ya tenéis creado un toolbar.

![1554291962285](assets/img/swing/1554291962285.png)

```java
private JToolBar createToolbar() {
	JToolBar toolBar = new JToolBar();

	JButton btnNewButton = new JButton("Guardar");
	btnNewButton.addActionListener((e) -> {
		save();
	});
	btnNewButton.setIcon(new ImageIcon(BlockV0.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
	toolBar.add(btnNewButton);

	//TODO
	//Crear el botón Abrir
	
	return toolBar;
}
```

Los pasos son:

1. crear el toolbar mediante  `new JToolBar()`.
2. crear un nuevo botón mediante `new JButton("Guardar");` ponerle atributos y añadirlo al toolbar mediante `toolBar.add(btnNewButton);`
3. devolver el `JToolBar` creado

Añadir este toolbar a nuestra ventana es tan sencillo como añadirlo al `contentPane`.

```java
public Block() {
    //....
	contentPane.add(createToolbar(), BorderLayout.NORTH);
    //....
}
```

### Ejercicio

Añade un nuevo botón:

![1554292260280](assets/img/swing/1554292260280.png)

El icono es directory.gif y el método asociado es `load()`.

## Cargar el archivo

Mostrar una ventana para seleccionar un archivo es tan sencillo como usar la clase `JFileChooser` y llamar al método `showOpenDialog`. Este método acepta un parámetro parent, que identifica el componente en el que se basa Java para calcular la posición de la ventana de diálogo.

La llamada `showOpenDialog()` se quedará bloqueada hasta que el usuario elija un fichero y cierre la ventana. A la vuelta, en selección tendremos  

-  `JFileChooser.CANCEL_OPTION` Si el usuario le ha dado al botón Cancelar.
-  `JFileChooser.APPROVE_OPTION` Si el usuario le ha dado al botón Abrir
-  `JFileChooser.ERROR_OPTION` Si ha ocurrido algún error.

Comprobando que se ha dado al botón Abrir, podemos obtener el fichero seleccionado por el usuario así.

![1554789761375](assets/img/swing/1554789761375.png)

![1554712056648](assets/img/swing/1554712056648.png)

Ahora que ya hemos seleccionado el archivo, vamos a mostrar su contenido en el área de texto.

Creamos un nuevo método llamado `loadFile(String fileName)`. 

Este método debe abrir un `Stream` orientado a caracteres y le aplicamos el decorador `BufferedReader` para poder leer línea a línea. De momento sólo vamos a mostrarlo por consola.

![1554789781833](assets/img/swing/1554789781833.png)

Y modificamos el método `load()`

![1554789797998](assets/img/swing/1554789797998.png)

Ahora ya es momento de modificar el método `loadFile()` para que en vez de mostrarlo en consola, devuelva un **String** con el contenido del fichero. Iremos leyendo el fichero línea a línea y concatenándolo en una variable de tipo **String**. Pero esta vez usaremos la clase `StringBuilder` que es más eficiente que la clase **String**. Los métodos más comunes de `StringBuilder` son `append()`, que permite añadir contenido a y `toString()` que devuelve el contenido como un **String**.

![1554789817839](assets/img/swing/1554789817839.png)

Y ya podemos modificar el método `load():`

![1554789831722](assets/img/swing/1554789831722.png)

## Guardar el archivo

El proceso para guardar el archivo es muy parecido a cargarlo. Pero esta vez hemos de mostrar el diálogo mediante `showSaveDialog()`. 

Una vez seleccionado el fichero en el que guardar, creamos un método llamado `saveFile(String fileName)` que guardará en **fileName** el contenido del área de texto. Para ello hemos de crear un `Stream` de tipo `FileWriter` y aplicarle el decorador  `PrintWriter()`.

## Filtrar por el tipo de fichero

En este momento, podemos cargar cualquier tipo de fichero sin importar la extensión del mismo. Puedes probar a cargar un archivo que no sea de texto a ver qué ocurre.

La forma más sencilla es aplicar un filtro por extensión. Por ejemplo, sólo queremos que aparezcan archivos con la extensión txt.

![1554789847657](assets/img/swing/1554789847657.png)

 Pero esto no nos asegura que el usuario seleccione un archivo con extensión txt

<video src='assets/img/swing/filtro.m4v' controls='controls' />

Así que hay que asegurarse también que el archivo seleccionado mediante `getSelectedFile()` tenga la extensión **.txt**

Otra opción es crear un filtro hecho por nosotros. Vamos a crear un filtro que sólo muestre archivos cuyo mime type sea "text/*". Para ellos extendemos la clase `FileFilter`:

![1556781725103](assets/img/swing/1556781725103.png)

Pero esto tampoco impide que el usuario seleccione un archivo que no sea de texto!

Así que vamos a hacer que, una  vez seleccionado el archivo, se compruebe si es de tipo texto.

Para ello, refactorizamos `TextFileFilter` para crear un método que compruebe si es del tipo correcto.

![1556781786111](assets/img/swing/1556781786111.png)

Y ahora lo usamos en `load();`

![1554789914135](assets/img/swing/1554789914135.png)

