package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class MainView extends JFrame{
	
	private PTitle titlePanel;
	private PFile filePanel;
	private PButtons buttonsPanel;
	
	public MainView() {
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#002B5B"));
		setTitle("Agenda de Rosita plus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		funcionar();
		
	}
	
	public void funcionar() {
		
		titlePanel = new PTitle();
		filePanel = new PFile();
		buttonsPanel = new PButtons();
		
	}

	public PTitle getTitlePanel() {
		return titlePanel;
	}

	public void setTitlePanel(PTitle titlePanel) {
		this.titlePanel = titlePanel;
	}

	public PFile getFilePanel() {
		return filePanel;
	}

	public void setFilePanel(PFile filePanel) {
		this.filePanel = filePanel;
	}

	public PButtons getButtonsPanel() {
		return buttonsPanel;
	}

	public void setButtonsPanel(PButtons buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

}
