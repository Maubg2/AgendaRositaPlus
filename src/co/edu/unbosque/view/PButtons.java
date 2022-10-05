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
		
		addButton = new JButton();
		searchButton = new JButton();
		modifyButton = new JButton();
		deleteButton = new JButton();
		loadData = new JButton();
		loadFile = new JButton();
		
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

	public JButton getLoadData() {
		return loadData;
	}

	public void setLoadData(JButton loadData) {
		this.loadData = loadData;
	}

	public JButton getLoadFile() {
		return loadFile;
	}

	public void setLoadFile(JButton loadFile) {
		this.loadFile = loadFile;
	}

}
