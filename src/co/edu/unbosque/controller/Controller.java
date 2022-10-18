package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
			
			boolean isLoaded = ControllerDAO.getPropertiesDAO().isFileLoaded();
			
			if(isLoaded) {
				String ref = WindowTool.getDataWindow("A qué categoria le desea añadir");
				ref = ref.toLowerCase();
				
				if(ref.equals("paises")) {//Hay que ponerlo en español
					
					String newCountry = WindowTool.getDataWindow("Qué pais va a agregar");
					Countries country = new Countries(newCountry);
					ControllerDAO.add(ref, country, null, null);
					ArrayList<Countries>countriesList = ControllerDAO.getAppDTO().getCountriesDB();
					//countriesList = appDTO.getCountriesDB();
					//countriesList = ControllerDAO.getAppDTO().getCountriesDB();
					//ControllerDAO.updateData(ref, countriesList, null, null);
					
				}else if(ref.equals("amigos")) {
					
					String name = WindowTool.getDataWindow("Agregar amigo: ");
					String country = WindowTool.getDataWindow("Agregar Pais: ");
					String phoneNumber = WindowTool.getDataWindow("Agregar número de celular: ");
					String email = WindowTool.getDataWindow("Agregar correo electronico: ");
					Friends friend = new Friends(name, country, phoneNumber, email);
					ControllerDAO.add(ref, null, friend, null);
					ArrayList<Friends>friendsList = ControllerDAO.getAppDTO().getFriendsDB();
					//friendsList = appDTO.getFriendsDB();
					//ControllerDAO.updateData(ref, null, friendsList, null);
					
				}else if(ref.equals("contactos")) {
					
					String name = WindowTool.getDataWindow("Agregar nombre: ");
					String business = WindowTool.getDataWindow("Agregar empresa: ");
					String country = WindowTool.getDataWindow("Agregar pais: ");
					String phoneManager = WindowTool.getDataWindow("Agregar telefono del manager: ");
					String email = WindowTool.getDataWindow("Agregar correo electronico: ");
					WorkContacts workContacts = new WorkContacts(name, business, country, phoneManager, email);
					ControllerDAO.add(ref, null, null, workContacts);
					ArrayList<WorkContacts>contactsList = ControllerDAO.getAppDTO().getWorkContactsDB();		
					
				}else {
					WindowTool.showWindow("Escriba una opción valida (paises, amigos o contactos)");
				}
				
				//Preguntar a qué categoría desea añadir
				//Si es a countries, preguntar el nombre
				//Crear un nuevo objeto countries
				//Actualizar la información con el método UpdateData de ControlerDAO
			}else {
				WindowTool.showWindow("Primero debe cargar el archivo");
			}
			
			break;
		case "search":
			
			isLoaded = ControllerDAO.getPropertiesDAO().isFileLoaded();
			
			if(isLoaded) {
				String ref = WindowTool.getDataWindow("En qué categoria va a buscar");
				String keyword = WindowTool.getDataWindow("Valor a buscar: ");
				Object res = ControllerDAO.search(ref, keyword);
				
				if(res != null) {
					WindowTool.showWindow("Busca a: " + "\n" + res);
				}else {
					WindowTool.showWindow("No se encontró ningún valor");
				}
				
			}else{
				WindowTool.showWindow("Primero debe cargar el archivo");
			}
			
			break;
		case "modify":
			
			isLoaded = ControllerDAO.getPropertiesDAO().isFileLoaded();
			
			if(isLoaded) {
				String ref = WindowTool.getDataWindow("Qué categoria desea modificar");
				String keyword = WindowTool.getDataWindow("Valor a modificar");
				String atribute = WindowTool.getDataWindow("Atributo que quiere modificar");
				String newValue = WindowTool.getDataWindow("Escriba el nuevo valor");
				boolean res = ControllerDAO.modify(ref, keyword, atribute, newValue);
				
				if(res) {
					WindowTool.showWindow("Modificado correctamente");
					
				//	ArrayList<Countries> countriesDB = ControllerDAO.getAppDTO().getCountriesDB();
				//	for(Countries x : countriesDB) {
				//		System.out.println(x);
				//	}
					
				/*	ArrayList<Friends> amigosDB = ControllerDAO.getAppDTO().getFriendsDB();
						for(Friends x : amigosDB) {
							System.out.println(x);
					}*/
				}else {
					WindowTool.showWindow("El valor ya existe");
				}
				
			}else {
				WindowTool.showWindow("Primero debe cargar el archivo");
			}
			
			break;
		case "delete":
			String ref1 = WindowTool.getDataWindow("En qué categoria va a eliminar elementos");
			String keyword1 = WindowTool.getDataWindow("Valor del atributo");//Hay que cambiar el texto
			ControllerDAO.delete(ref1, keyword1);
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
