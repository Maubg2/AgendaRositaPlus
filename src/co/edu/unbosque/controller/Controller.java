package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.WindowView;
import co.edu.unbosque.model.persistence.*;

public class Controller implements ActionListener{
	
	private WindowView WindowTool;
	private MainView mainView;
	private ControllerDAO ControllerDAO;
	
	public Controller() {
		
		WindowTool = new WindowView();
		mainView = new MainView();
		ControllerDAO = new ControllerDAO();
		funcionar();
		
	}
	
	//private String src = "src/datos/agendaFisica.properties"; //Variable para agregar la ruta del archivo
	
	public void funcionar() {
		setButtons();
		//ControllerDAO.getPropertiesDAO().loadData(src);
	}
	
	public void setButtons() {
		mainView.getButtonsPanel().getAddButton().addActionListener(this);
		mainView.getButtonsPanel().getAddButton().setActionCommand("add");
		mainView.getButtonsPanel().getSearchButton().addActionListener(this);
		mainView.getButtonsPanel().getSearchButton().setActionCommand("search");
		mainView.getButtonsPanel().getModifyButton().addActionListener(this);
		mainView.getButtonsPanel().getModifyButton().setActionCommand("modify");
		mainView.getButtonsPanel().getDeleteButton().addActionListener(this);
		mainView.getButtonsPanel().getDeleteButton().setActionCommand("delete");
		mainView.getButtonsPanel().getLoadDataButton().addActionListener(this);
		mainView.getButtonsPanel().getLoadDataButton().setActionCommand("loadData");
		mainView.getButtonsPanel().getLoadFileButton().addActionListener(this);
		mainView.getButtonsPanel().getLoadFileButton().setActionCommand("loadFile");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "add":
			System.out.println("Añadir presionado");
			//Preguntar a qué categoría desea añadir
			//Si es a countries, preguntar el nombre
			//Crear un nuevo objeto countries
			//Actualizar la información con el método UpdateData de ControlerDAO
			
			break;
		case "search":
			System.out.println("Buscar presionado");
			break;
		case "modify":
			System.out.println("Modificar presionado");
			break;
		case "delete":
			System.out.println("Borrar presionado");
			break;
		case "loadData":
			System.out.println("Ver datos presionado");
			break;
		case "loadFile":
			//System.out.println("Cargar archivo presionado");
			ControllerDAO.getPropertiesDAO().loadData(mainView.showFileChooser());
			//Dividir los datos en archivos binarios
			ControllerDAO.setBinaries();
			boolean response = ControllerDAO.getPropertiesDAO().isFileLoaded();
			if(response) 
				mainView.getFilePanel().setLoadedValue("Si");
			else 
				mainView.getFilePanel().setLoadedValue("No");
			
			break;
		default:
			System.out.println("Error en los botones");
			break;
		}
	}

}
