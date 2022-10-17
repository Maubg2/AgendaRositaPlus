package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.WindowView;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.model1.AppDTO;
import co.edu.unbosque.model1.Countries;
import co.edu.unbosque.model1.Friends;
import co.edu.unbosque.model1.WorkContacts;

public class Controller implements ActionListener{
	
	private WindowView WindowTool;
	private MainView mainView;
	private ControllerDAO ControllerDAO;
	
	private AppDTO appDTO;
	
	public Controller() {
		
		
		WindowTool = new WindowView();
		mainView = new MainView();
		ControllerDAO = new ControllerDAO();
		appDTO = new AppDTO();
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
			//System.out.println("Añadir presionado");
			
			String ref = WindowTool.getDataWindow("A qué categoria le desea añadir");
			if(ref.equals("countries")) {//Hay que ponerlo en español
				String newCountry = WindowTool.getDataWindow("Qué pais va a agregar");
				Countries country = new Countries(newCountry);
				ControllerDAO.add(ref, country, null, null);
				ArrayList<Countries>countriesList = new ArrayList<>();
				countriesList = appDTO.getCountriesDB();
				//ControllerDAO.updateData(ref, countriesList, null, null);
				
			
			}else if(ref.equals("friends")) {
				
				
				String name = WindowTool.getDataWindow("Amigo a agregar");
				String country = WindowTool.getDataWindow("Pais");
				String phoneNumber = WindowTool.getDataWindow("Número de celular");
				String email = WindowTool.getDataWindow("Correo electronico");
				Friends friend = new Friends(name, country, phoneNumber, email);
				ControllerDAO.add(ref, null, friend, null);
				ArrayList<Friends>friendsList = appDTO.getFriendsDB();
				//friendsList = appDTO.getFriendsDB();
				//ControllerDAO.updateData(ref, null, friendsList, null);
				
			}else if(ref.equals("contacts")) {
				
				String name = WindowTool.getDataWindow("");
				String business = WindowTool.getDataWindow("");
				String country = WindowTool.getDataWindow("");
				String phoneManager = WindowTool.getDataWindow("");
				String email = WindowTool.getDataWindow("");
				WorkContacts workContacts = new WorkContacts(name, business, country, phoneManager, email);
				ControllerDAO.add(ref, null, null, workContacts);
				ArrayList<WorkContacts>contactsList = appDTO.getWorkContactsDB();

			}else {
				WindowTool.showWindow("Escriba una opción valida");
			}
			
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
			ref = WindowTool.getDataWindow("En qué categoria va a eliminar elementos");
			String keyword = WindowTool.getDataWindow("Valor del atributo");//Hay que cambiar el texto
			ControllerDAO.delete(ref, keyword);
			//System.out.println("Borrar presionado");
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
