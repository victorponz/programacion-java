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
