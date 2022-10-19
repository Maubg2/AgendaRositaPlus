package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * <p>Esta clase se encarga de contener, instanciar y ubicar en el panel a 
 * todos los botones usados en el programa</P>
 * 
 * @author J&M Sistemas
 */

public class PButtons extends JPanel{
	
	private JButton addButton;
	private JButton searchButton;
	private JButton modifyButton;
	private JButton deleteButton;
	private JButton loadFile;
	
	//Asisgnar Action listener en controlador
	
	public PButtons() {
		
		
		//System.out.println("Funciona");
		setLayout(null);
		funcionar();
		setVisible(true);
	}
	
	public void funcionar() {
		addButton = new JButton("Agregar");
		searchButton = new JButton("Buscar");
		modifyButton = new JButton("Modificar");
		deleteButton = new JButton("Borrar");
		loadFile = new JButton("Cargar archivo");
		
		addButton.setBounds(30, 20, 150, 20);
		add(addButton);
		
		searchButton.setBounds(30, 50, 150, 20);
		add(searchButton);
		
		modifyButton.setBounds(30, 80, 150, 20);
		add(modifyButton);
		
		deleteButton.setBounds(30, 110, 150, 20);
		add(deleteButton);
		
		loadFile.setBounds(30, 180, 150, 20);
		add(loadFile);
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JButton getModifyButton() {
		return modifyButton;
	}

	public void setModifyButton(JButton modifyButton) {
		this.modifyButton = modifyButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JButton getLoadFileButton() {
		return loadFile;
	}

	public void setLoadFileButton(JButton loadFile) {
		this.loadFile = loadFile;
	}

}
