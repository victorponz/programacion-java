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
