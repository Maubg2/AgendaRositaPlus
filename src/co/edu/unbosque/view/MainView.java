package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainView extends JFrame{
	
	private PTitle titlePanel;
	private PFile filePanel;
	private PButtons buttonsPanel;
	
	public MainView() {
		
		titlePanel = new PTitle();
		filePanel = new PFile();
		buttonsPanel = new PButtons();
		funcionar();
		
	}
	
	public void funcionar() {
		
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
