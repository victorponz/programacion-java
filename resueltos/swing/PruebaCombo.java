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
