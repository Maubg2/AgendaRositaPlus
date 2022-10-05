package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class WindowView {
	
	public WindowView() {
		
	}
	
	public void showWindow(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getDataWindow(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}

}
