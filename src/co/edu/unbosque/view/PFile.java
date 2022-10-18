package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PFile extends JPanel{
	
	//private JTextArea textArea;
	
	private JTextArea countriesArea;
	private JLabel countriesLabel;
	private JTextArea friendsArea;
	private JLabel friendsLabel;
	private JTextArea contactsArea;
	private JLabel contactsLabel;
	private JLabel fileLoaded;
	private JLabel loadedValue;
	private JScrollPane areaScroll;
	
	public PFile(){
		
		setLayout(null);
		funcionar();
		setVisible(true);
		
		
	}
	
	public void funcionar() {
		
		setBackground(Color.decode("#002B5B"));
		
		/*
		textArea = new JTextArea();
		
		//textArea.setBounds(30, 30, 330, 300);
		//add(textArea);
		
		areaScroll = new JScrollPane(textArea);
		areaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setBounds(30, 30, 330, 300);
		add(areaScroll);
		*/
		
		//Zona de countries
		countriesArea = new JTextArea();
		areaScroll = new JScrollPane(countriesArea);
		areaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setBounds(30, 50, 140, 220);
		add(areaScroll);
		
		countriesLabel = new JLabel("Países");
		countriesLabel.setFont(new Font("Times New Roman", 0, 20));
		countriesLabel.setForeground(Color.WHITE);
		countriesLabel.setBounds(72, 24, 60, 20);
		add(countriesLabel);
		
		//Zona de friends
		friendsArea = new JTextArea();
		areaScroll = new JScrollPane(friendsArea);
		areaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setBounds(200, 50, 140, 220);
		add(areaScroll);
		
		friendsLabel = new JLabel("Amigos");
		friendsLabel.setFont(new Font("Times New Roman", 0, 20));
		friendsLabel.setForeground(Color.WHITE);
		friendsLabel.setBounds(240, 24, 100, 20);
		add(friendsLabel);
		
		//Zona de contacts
		contactsArea = new JTextArea();
		areaScroll = new JScrollPane(contactsArea);
		areaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		areaScroll.setBounds(370, 50, 140, 220);
		add(areaScroll);
		
		contactsLabel = new JLabel("Contactos de trabajo");
		contactsLabel.setFont(new Font("Times New Roman", 0, 16));
		contactsLabel.setForeground(Color.WHITE);
		contactsLabel.setBounds(376, 24, 180, 20);
		add(contactsLabel);
		
		
		fileLoaded = new JLabel("Archivo cargado: ");
		fileLoaded.setFont(new Font("Times New Roman", 0, 20));
		fileLoaded.setForeground(Color.WHITE);
		fileLoaded.setBounds(180, 400, 200, 50);
		add(fileLoaded);
		
		loadedValue = new JLabel("No");
		loadedValue.setFont(new Font("Times New Roman", 0, 20));
		loadedValue.setForeground(Color.WHITE);
		loadedValue.setBounds(330, 400, 50, 50);
		add(loadedValue);
		
	}

	/*
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
*/
	public JLabel getFileLoaded() {
		return fileLoaded;
	}

	public void setFileLoaded(JLabel fileLoaded) {
		this.fileLoaded = fileLoaded;
	}

	public JLabel getLoadedValue() {
		return loadedValue;
	}

	public void setLoadedValue(String loadedValue) {
		this.loadedValue.setText(loadedValue);
	}

}
