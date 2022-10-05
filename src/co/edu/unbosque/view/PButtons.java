package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PButtons extends JPanel{
	
	private JButton addButton;
	private JButton searchButton;
	private JButton modifyButton;
	private JButton deleteButton;
	private JButton loadData;
	private JButton loadFile;
	
	//Asisgnar Action listener en controlador
	
	public PButtons() {
		
		addButton = new JButton("Agregar");
		searchButton = new JButton("Buscar");
		modifyButton = new JButton("Modificar");
		deleteButton = new JButton("Borrar");
		loadData = new JButton("Ver datos");
		loadFile = new JButton("Cargar archivo");
		//System.out.println("Funciona");
		funcionar();
	}
	
	public void funcionar() {
		addButton.setBounds(30, 20, 120, 60);
		add(addButton);
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

	public JButton getLoadDataButton() {
		return loadData;
	}

	public void setLoadDataButton(JButton loadData) {
		this.loadData = loadData;
	}

	public JButton getLoadFileButton() {
		return loadFile;
	}

	public void setLoadFileButton(JButton loadFile) {
		this.loadFile = loadFile;
	}

}
