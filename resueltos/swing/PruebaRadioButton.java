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
