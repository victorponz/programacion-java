package ejemplos.swing;

import javax.swing.JOptionPane;

public class EjemploJDialogShow {
	public static void main(String[] args) {
		String user = JOptionPane.showInputDialog(null, "user");
		String password = JOptionPane.showInputDialog(null, "password");
		if (user.equals("admin") && password.equals("1234")) {
			JOptionPane.showMessageDialog(null, "login ok");
		}else {
			JOptionPane.showMessageDialog(null, "login failed");
		}
	}
}
