package co.edu.unbosque.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PTitle extends JPanel{
	
	private JLabel mainTitle;
	
	public PTitle() {
		
		mainTitle = new JLabel("Agenda de Rosita plus");
		
	}

	public JLabel getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(JLabel mainTitle) {
		this.mainTitle = mainTitle;
	}

}
