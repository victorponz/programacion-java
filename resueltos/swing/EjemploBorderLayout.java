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
