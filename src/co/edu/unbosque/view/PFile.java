package co.edu.unbosque.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PFile extends JPanel{
	
	private JTextArea textArea;
	private JLabel fileLoaded;
	private JLabel loadedValue;
	
	public PFile(){
		
		setLayout(null);
		funcionar();
		setVisible(true);
		
		
	}
	
	public void funcionar() {
		
		textArea = new JTextArea();
		textArea.setBounds(20, 20, 300, 300);
		add(textArea);
		
		fileLoaded = new JLabel("Archivo cargado: ");
		fileLoaded.setBounds(100, 400, 120, 50);
		add(fileLoaded);
		
		loadedValue = new JLabel("No");
		loadedValue.setBounds(150, 400, 50, 50);
		add(loadedValue);
		
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
