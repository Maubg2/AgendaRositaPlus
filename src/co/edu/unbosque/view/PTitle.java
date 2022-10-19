package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <p>Clase que contiene, instancia y ubica en el panel al titulo principal </p>
 * 
 * @author J&M Sistemas 
 */

public class PTitle extends JPanel{
	
	private JLabel mainTitle;
	
	public PTitle() {
		
		setLayout(null);
		funcionar();
		setVisible(true);
		
		/*setLayout(null);
		setBounds(0, 0, 800, 100);
		//setBackground(Color.BLACK);
		setForeground(Color.black);
		setVisible(true);
		mainTitle = new JLabel("Agenda de Rosita plus");
		funcionar();
		*/
	}
	
	public void funcionar() {
		
		setBackground(Color.decode("#256D85"));
		
		mainTitle = new JLabel("Agenda de Rosita plus");
		mainTitle.setForeground(Color.BLACK);
		mainTitle.setBounds(220, 20, 380, 60);
		mainTitle.setFont(new Font("times new roman", Font.BOLD, 30));
		add(mainTitle);
		
	}

	public JLabel getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(JLabel mainTitle) {
		this.mainTitle = mainTitle;
	}

}
