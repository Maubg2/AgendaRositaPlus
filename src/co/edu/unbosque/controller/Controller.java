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


/**
 * En esta clase se conecta la vista con el modelo, se le piden los datos al usuario
 * con la vista, y se mandan esos datos recolectados al modelo mediante los parámetros
 * de los métodos
 * @author HP
 * @see ActionListener
 */
public class Controller implements ActionListener{
	
	private WindowView WindowTool;
	private MainView mainView;
	private ControllerDAO ControllerDAO;
	
	/**
	 * <h2>Constructor</h2>
	 * <p>
	 * Se instancian los objetos de vista y modelo, WindowTool es para
	 * el manejo de ventanas emergentes, mainView es donde están todos los paneles
	 * y ControllerDAO es donde se administran los DAOs del archivo properties y de
	 * los binarios
	 * </p>
	 */
	
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
	
	/**
	 *<h2>Configurar botones</h2>
	 *<p>Este metodo asgina los listeners a todos los botones</p> 
	 */
	
	public void setButtons() {
		mainView.getButtonsPanel().getAddButton().addActionListener(this);
		mainView.getButtonsPanel().getAddButton().setActionCommand("add");
		mainView.getButtonsPanel().getSearchButton().addActionListener(this);
		mainView.getButtonsPanel().getSearchButton().setActionCommand("search");
		mainView.getButtonsPanel().getModifyButton().addActionListener(this);
		mainView.getButtonsPanel().getModifyButton().setActionCommand("modify");
		mainView.getButtonsPanel().getDeleteButton().addActionListener(this);
		mainView.getButtonsPanel().getDeleteButton().setActionCommand("delete");
		mainView.getButtonsPanel().getLoadFileButton().addActionListener(this);
		mainView.getButtonsPanel().getLoadFileButton().setActionCommand("loadFile");
		mainView.getButtonsPanel().getSeeData().addActionListener(this);
		mainView.getButtonsPanel().getSeeData().setActionCommand("seeData");
	}
	
	/**
	 * <h2>actionPerformed</h2>
	 * <p>
	 * En este metodo abstracto se dan las acciones a realizar cuando se presione
	 * dicho boton
	 * </p>
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "add":
			
			boolean isLoaded = ControllerDAO.getPropertiesDAO().isFileLoaded();
			
			if(isLoaded) {
				try {
					String ref = WindowTool.getDataWindow("A qué categoria le desea añadir");
					ref = ref.toLowerCase();
					
					if(ref.equals("paises") || ref.equals("pais")) {//Hay que ponerlo en español
						
						String newCountry = WindowTool.getDataWindow("Qué pais va a agregar");
						Countries country = new Countries(newCountry);
						
						String resFormat = ControllerDAO.checkFormat(country.getCountry(), null, null);
						if(resFormat.equals("1")) {
							WindowTool.showWindow("El nombre contiene caracteres ilegales");
						}else if(resFormat.equals("0") && newCountry != null) {
							String res = ControllerDAO.add(ref, country, null, null);
							//Este res es para checkear si el atributo unico está repetido
							if(res.equals("0")) 
								WindowTool.showWindow("No se pudo añadir: El nombre está repetido");
							else if(res.equals("1"))
								WindowTool.showWindow("Se añadió correctamente");
							else if(res.equals("2"))
								WindowTool.showWindow("No se encontró la categoría");
						
						}
						
						ArrayList<Countries>countriesList = ControllerDAO.getAppDTO().getCountriesDB();
						//countriesList = appDTO.getCountriesDB();
						//countriesList = ControllerDAO.getAppDTO().getCountriesDB();
						//ControllerDAO.updateData(ref, countriesList, null, null);
						
						//Actualizar textArea
						mainView.getFilePanel().getCountriesArea().setText(null);
						mainView.loadTextArea(countriesList, null, null);
						
					}else if(ref.equals("amigos")) {
						
						String name = WindowTool.getDataWindow("Agregar amigo: ");
						String country = WindowTool.getDataWindow("Agregar Pais: ");
						String phoneNumber = WindowTool.getDataWindow("Agregar número de celular: ");
						String email = WindowTool.getDataWindow("Agregar correo electronico: ");
						Friends friend = new Friends(name, country, phoneNumber, email);
						
						String resFormatName = ControllerDAO.checkFormat(name, null, null);
						boolean correctName = false;
						String resFormatPhone = ControllerDAO.checkFormat(null, phoneNumber, null);
						boolean correctPhone = false;
						String resFormatEmail = ControllerDAO.checkFormat(null, null, email);
						boolean correctEmail = false;
						
						if(resFormatName.equals("1")) 
							WindowTool.showWindow("Tiene caracteres ilegales");
						else if(resFormatName.equals("0") && name != null) 
							correctName = true;
						
						if(resFormatPhone.equals("2")) 
							WindowTool.showWindow("El telefono debería tener 9 caracteres");
						else if(resFormatPhone.equals("3")) 
							WindowTool.showWindow("El formato del número debería ser: xxx-xxx-xxx");
						else if(resFormatPhone.equals("0") && phoneNumber != null)
							correctPhone = true;
						
						if(resFormatEmail.equals("4")) 
							WindowTool.showWindow("El correo debe terminar en: @xxxx.com");
						else if(resFormatEmail.equals("0") && email != null)
							correctEmail = true;
						
						if(correctName == true && correctPhone == true && correctEmail == true && country != null) {
							String res = ControllerDAO.add(ref, null, friend, null);
							if(res.equals("0")) 
								WindowTool.showWindow("No se pudo añadir: El nombre está repetido");
							else if(res.equals("1"))
								WindowTool.showWindow("Se añadió correctamente");
							else if(res.equals("2"))
								WindowTool.showWindow("No se encontró la categoría");
						}
						
						ArrayList<Friends>friendsList = ControllerDAO.getAppDTO().getFriendsDB();
						//friendsList = appDTO.getFriendsDB();
						//ControllerDAO.updateData(ref, null, friendsList, null);
						
						//Actualizar textArea
						mainView.getFilePanel().getFriendsArea().setText(null);
						mainView.loadTextArea(null, friendsList, null);
						
					}else if(ref.equals("contactos")) {
						
						String name = WindowTool.getDataWindow("Agregar nombre: ");
						String business = WindowTool.getDataWindow("Agregar empresa: ");
						String country = WindowTool.getDataWindow("Agregar pais: ");
						String phoneManager = WindowTool.getDataWindow("Agregar telefono del manager: ");
						String email = WindowTool.getDataWindow("Agregar correo electronico: ");
						WorkContacts workContacts = new WorkContacts(name, business, country, phoneManager, email);
						
						String resFormatName = ControllerDAO.checkFormat(name, null, null);
						boolean correctName = false;
						String resFormatPhone = ControllerDAO.checkFormat(null, phoneManager, null);
						boolean correctPhone = false;
						String resFormatEmail = ControllerDAO.checkFormat(null, null, email);
						boolean correctEmail = false;
						
						if(resFormatName.equals("1")) 
							WindowTool.showWindow("Tiene caracteres ilegales");
						else if(resFormatName.equals("0") && name != null) 
							correctName = true;
						
						if(resFormatPhone.equals("2")) 
							WindowTool.showWindow("El telefono debería tener 9 caracteres");
						else if(resFormatPhone.equals("3")) 
							WindowTool.showWindow("El formato del número debería ser: xxx-xxx-xxx");
						else if(resFormatPhone.equals("0") && phoneManager != null)
							correctPhone = true;
						
						if(resFormatEmail.equals("4")) 
							WindowTool.showWindow("El correo debe terminar en: @xxxx.com");
						else if(resFormatEmail.equals("0") && email != null)
							correctEmail = true;
						
						if(correctName == true && correctPhone == true && correctEmail == true && country != null) {
							String res = ControllerDAO.add(ref, null, null, workContacts);
							if(res.equals("0")) 
								WindowTool.showWindow("No se pudo añadir: El nombre está repetido");
							else if(res.equals("1"))
								WindowTool.showWindow("Se añadió correctamente");
							else if(res.equals("2"))
								WindowTool.showWindow("No se encontró la categoría");
						}
					
						ArrayList<WorkContacts>contactsList = ControllerDAO.getAppDTO().getWorkContactsDB();
						
						//Actualizar textArea
						
						mainView.getFilePanel().getContactsArea().setText(null);
						mainView.loadTextArea(null, null, contactsList);
						
					}else {
						WindowTool.showWindow("Escriba una opción valida (paises, amigos o contactos)");
					}
				}catch(NullPointerException x) {
					WindowTool.showWindow("Debe ingresar algún valor");
				}
				
			}else {
				WindowTool.showWindow("Primero debe cargar el archivo");
			}
			
			break;
		case "search":
			
			isLoaded = ControllerDAO.getPropertiesDAO().isFileLoaded();
			
			if(isLoaded) {
				try {
					String ref = WindowTool.getDataWindow("En qué categoria va a buscar");
					String keyword = WindowTool.getDataWindow("Valor a buscar: ");
					Object res = ControllerDAO.search(ref, keyword);
					
					if(res != null) {
						WindowTool.showWindow("Busca a: " + "\n" + res);
					}else {
						WindowTool.showWindow("No se encontró ningún valor");
					}
				}catch(NullPointerException x) {
					WindowTool.showWindow("Debe ingresar algún valor");
				}
				
			}else{
				WindowTool.showWindow("Primero debe cargar el archivo");
			}
			
			break;
		case "modify":
			
			isLoaded = ControllerDAO.getPropertiesDAO().isFileLoaded();
			
			if(isLoaded) {
				try {
					
					String ref = WindowTool.getDataWindow("Qué categoria desea modificar");
					
					if(ref.equals("paises")) {
						String keyword = WindowTool.getDataWindow("Nombre del pais a modificar");
						String newValue = WindowTool.getDataWindow("Nombre del pais");
						
						String resFormat = ControllerDAO.checkFormat(newValue, null, null);
						if(resFormat.equals("1")) {
							WindowTool.showWindow("El nombre contiene caracteres ilegales");
						}else if(resFormat.equals("0") && newValue != null) {
							boolean res = ControllerDAO.modifyCountries(ref, keyword, newValue);
							//Este res es para checkear si el atributo unico está repetido
							if(res) {
								WindowTool.showWindow("Pais modificado correctamente");
								//Cargar datos en los textArea
								mainView.getFilePanel().getFriendsArea().setText(null);
								mainView.getFilePanel().getContactsArea().setText(null);
								mainView.getFilePanel().getCountriesArea().setText(null);
								mainView.loadTextArea(ControllerDAO.getAppDTO().getCountriesDB(), ControllerDAO.getAppDTO().getFriendsDB(), ControllerDAO.getAppDTO().getWorkContactsDB());
								
							}
						
						}

					}else if(ref.equals("amigos") || ref.equals("contactos")) {
						String keyword = WindowTool.getDataWindow("Nombre del objeto a modificar");
						String atribute = WindowTool.getDataWindow("Qué propiedad desea cambiar");
						String newValue = WindowTool.getDataWindow("Ingrese el nuevo valor para " + atribute);
						
						//Checkear formato
						atribute = atribute.toLowerCase();
						switch(atribute) {
						case "nombre":
							String resFormatName = ControllerDAO.checkFormat(newValue, null, null);
							if(resFormatName.equals("1")) {
								WindowTool.showWindow("El nombre contiene caracteres ilegales");
								System.out.println("Caracteres ilegales");
								break;
							}else if(resFormatName.equals("0") && newValue != null) {
								boolean res = ControllerDAO.modifyCountries(ref, keyword, newValue);
								//Este res es para checkear si el atributo unico está repetido
								if(res) {
									WindowTool.showWindow("Pais modificado correctamente");
									//Cargar datos en los textArea
									mainView.getFilePanel().getFriendsArea().setText(null);
									mainView.getFilePanel().getContactsArea().setText(null);
									mainView.getFilePanel().getCountriesArea().setText(null);
									mainView.loadTextArea(ControllerDAO.getAppDTO().getCountriesDB(), ControllerDAO.getAppDTO().getFriendsDB(), ControllerDAO.getAppDTO().getWorkContactsDB());
									break;
								}
							}
						case "telefono", "teléfono":
							String resFormatPhone = ControllerDAO.checkFormat(null, newValue, null);
							if(resFormatPhone.equals("2")) {
								WindowTool.showWindow("El número debería tener 9 números");
								break;
							}else if(resFormatPhone.equals("3")) {
								WindowTool.showWindow("El número debería ser de la forma: xxx-xxx-xxx");
							}
							else if(resFormatPhone.equals("0") && newValue != null) {
								boolean res = ControllerDAO.modifyCountries(ref, keyword, newValue);
								//Este res es para checkear si el atributo unico está repetido
								if(res) {
									WindowTool.showWindow("Pais modificado correctamente");
									//Cargar datos en los textArea
									mainView.getFilePanel().getFriendsArea().setText(null);
									mainView.getFilePanel().getContactsArea().setText(null);
									mainView.getFilePanel().getCountriesArea().setText(null);
									mainView.loadTextArea(ControllerDAO.getAppDTO().getCountriesDB(), ControllerDAO.getAppDTO().getFriendsDB(), ControllerDAO.getAppDTO().getWorkContactsDB());
									break;
								}
							}
							break;
						case "email":
							String resFormatEmail = ControllerDAO.checkFormat(null, null, newValue);
							if(resFormatEmail.equals("4")) {
								WindowTool.showWindow("El email debe ser un correo válido");
								break;
							}
							else if(resFormatEmail.equals("0") && newValue != null) {
								boolean res = ControllerDAO.modifyCountries(ref, keyword, newValue);
								//Este res es para checkear si el atributo unico está repetido
								if(res) {
									WindowTool.showWindow("Pais modificado correctamente");
									//Cargar datos en los textArea
									mainView.getFilePanel().getFriendsArea().setText(null);
									mainView.getFilePanel().getContactsArea().setText(null);
									mainView.getFilePanel().getCountriesArea().setText(null);
									mainView.loadTextArea(ControllerDAO.getAppDTO().getCountriesDB(), ControllerDAO.getAppDTO().getFriendsDB(), ControllerDAO.getAppDTO().getWorkContactsDB());
									break;
								}
							}
							break;
							
						}
						
						
					}else {
						
					}
					
					
				}catch(NullPointerException x) {
					WindowTool.showWindow("Debe ingresar algún valor");
				}
				
			}else {
				WindowTool.showWindow("Primero debe cargar el archivo");
			}
			
			break;
		case "delete":
			
			isLoaded = ControllerDAO.getPropertiesDAO().isFileLoaded();
			
			if(isLoaded) {
				try {
					String ref = WindowTool.getDataWindow("En qué categoria va a eliminar elementos");
					String keyword = WindowTool.getDataWindow("Elemento que va a borrar");//Hay que cambiar el texto
					boolean res = ControllerDAO.delete(ref, keyword);
					if(res) {
						WindowTool.showWindow("Elemento borrado correctamente");
						//Actualizar textArea
						mainView.getFilePanel().getFriendsArea().setText(null);
						mainView.getFilePanel().getContactsArea().setText(null);
						mainView.getFilePanel().getCountriesArea().setText(null);
						mainView.loadTextArea(ControllerDAO.getAppDTO().getCountriesDB(), ControllerDAO.getAppDTO().getFriendsDB(), ControllerDAO.getAppDTO().getWorkContactsDB());
					}
					else {
						WindowTool.showWindow("No se encontró el elemento");
					}
				}catch(NullPointerException x) {
					WindowTool.showWindow("Debe ingresar algún valor");
				}
				
			}else {
				WindowTool.showWindow("Primero debe cargar el archivo");
			}
				
			break;
		case "seeData":
			//Mostrar porcentajes
			
			
			
			break;
		case "loadFile":
			//System.out.println("Cargar archivo presionado");
			ControllerDAO.getPropertiesDAO().loadData(mainView.showFileChooser());
			//Dividir los datos en archivos binarios
			ControllerDAO.setBinaries();
			mainView.getFilePanel(); //Agregar porcentajes
			boolean response = ControllerDAO.getPropertiesDAO().isFileLoaded();
			if(response) 
				mainView.getFilePanel().setLoadedValue("Si");
			else 
				mainView.getFilePanel().setLoadedValue("No");
			
			//Cargar datos en los textArea
			mainView.loadTextArea(ControllerDAO.getAppDTO().getCountriesDB(), ControllerDAO.getAppDTO().getFriendsDB(), ControllerDAO.getAppDTO().getWorkContactsDB());
			
			break;
		default:
			System.out.println("Error en los botones");
			break;
		}
	}
	
	public void loadCantInfo() {
		mainView.getFilePanel().setfriendsCantValue("" + ControllerDAO.getAppDTO().getFriendsDB().size());
		
	}
	
	public void reloadTextArea() {
		
	}

}
