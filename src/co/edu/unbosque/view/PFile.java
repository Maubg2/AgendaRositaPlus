package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

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
		
		setBackground(Color.decode("#002B5B"));
		
		textArea = new JTextArea();
		textArea.setBounds(30, 30, 330, 300);
		add(textArea);
		
		fileLoaded = new JLabel("Archivo cargado: ");
		fileLoaded.setFont(new Font("Times New Roman", 0, 20));
		fileLoaded.setForeground(Color.WHITE);
		fileLoaded.setBounds(100, 360, 200, 50);
		add(fileLoaded);
		
		loadedValue = new JLabel("No");
		loadedValue.setFont(new Font("Times New Roman", 0, 20));
		loadedValue.setForeground(Color.WHITE);
		loadedValue.setBounds(250, 360, 50, 50);
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
