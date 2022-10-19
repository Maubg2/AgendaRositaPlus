package co.edu.unbosque.view;

import javax.swing.JOptionPane;

/**
 * <p>Clase encargada de crear dos herramientas para mostrar informacion
 * y para pedir un dato retornar la respuesta</p>
 * 
 * @author J&M Sistemas
 */

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
