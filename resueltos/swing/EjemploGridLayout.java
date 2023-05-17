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
