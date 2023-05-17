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
