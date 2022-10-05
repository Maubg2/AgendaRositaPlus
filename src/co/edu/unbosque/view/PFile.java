package co.edu.unbosque.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PFile extends JPanel{
	
	private JTextArea textArea;
	private JLabel fileLoaded;
	private JLabel loadedValue;
	
	public PFile(){
		
		textArea = new JTextArea();
		fileLoaded = new JLabel("Archivo cargado: ");
		loadedValue = new JLabel("No");
		
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JLabel getFileLoaded() {
		return fileLoaded;
	}

	public void setFileLoaded(JLabel fileLoaded) {
		this.fileLoaded = fileLoaded;
	}

	public JLabel getLoadedValue() {
		return loadedValue;
	}

	public void setLoadedValue(JLabel loadedValue) {
		this.loadedValue = loadedValue;
	}

}
