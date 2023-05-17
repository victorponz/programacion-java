package ejemplos.swing;

import javax.swing.*;

public class EjemploJFrame extends JFrame {
	// el constructor
	public EjemploJFrame() {
		super("Hola!!!"); // Pone un título a la ventana
		// o this.setTitle("Hola!!!");
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
		 * new EjemploJFrame().setVisible(true);
		 * Pero esta otra forma es la indicada porque trabaja con threads
		 */
	}
}
