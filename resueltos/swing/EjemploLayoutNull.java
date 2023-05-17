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
