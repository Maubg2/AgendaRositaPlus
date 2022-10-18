package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model1.*;

public class ControllerDAO {
	
	private PropertiesDAO PropDAO;
	//private BinDAO BinDAO;
	private AppDTO AppDTO;
	private BinDAO CountriesBin;
	private BinDAO FriendsBin;
	private BinDAO WorkContactsBin;
	
	public ControllerDAO() {
		PropDAO = new PropertiesDAO();
		AppDTO = new AppDTO();
	}
	
	/**
	 * <p>Crear y cargar los datos a los binarios</P>
	 */
	public void setBinaries() {
		CountriesBin = new BinDAO("src/datos/CountriesBin.dat");
		FriendsBin = new BinDAO("src/datos/FriendsBin.dat"); //Traer o crear los binarios
		WorkContactsBin = new BinDAO("src/datos/WorkContacts.dat");
		
		AppDTO.setCountriesDB(PropDAO.getCountryData()); //Cargarlo al DTO (Central de datos)
		CountriesBin.loadCountry(AppDTO.getCountriesDB()); //Cargarlo al binario con los datos de la central
		
		AppDTO.setFriendsDB(PropDAO.getFriendsData());
		FriendsBin.loadFriends(AppDTO.getFriendsDB());
		
		AppDTO.setWorkContactsDB(PropDAO.getWorkContactsData());
		WorkContactsBin.loadWorkContacts(AppDTO.getWorkContactsDB());
		
	}
	
	//CRUD
	
	/**
	 * <h2>Actualizar<h2>
	 * <p>Este método sirve para actualizar la información luego de haber modificado las bases de datos, los arraylist que se piden ya deben venir modificados</p>
	 * <p>Se piden todas las bases de datos, y segun la variable ref, se especificara cual de ellas se va a modificar</p>
	 * @param ref
	 * @param countriesDB
	 * @param friendsDB
	 * @param contactsDB
	 */

	
	
	/**
	 * <h2>Añadir</h2>
	 * <p>Método que añade un objeto a la categoría especificada en ref</p>  
	 * @param ref
	 * @param country
	 * @param friend
	 * @param contact
	 */
	public void add(String ref, Countries country, Friends friend, WorkContacts contact) { //Todos los parámetros deben llenarse con null, menos ref y el objeto a añadir
		
		ref = ref.toLowerCase();
		switch(ref) {
		case "paises":
			
			ArrayList<Countries> countriesDB = AppDTO.getCountriesDB();//Traer la base de datos
			countriesDB.add(country); //Agregar el objeto correspondiente a su array
			for(Countries x : countriesDB) {
				System.out.println(x);
			}
			AppDTO.setCountriesDB(countriesDB);//Actualizar central de datos
			CountriesBin.loadCountry(AppDTO.getCountriesDB()); //Actualizar binario con los datos actualizados de la central
			
			break;
		case "amigos":
			
			ArrayList<Friends> friendsDB = AppDTO.getFriendsDB();
			friendsDB.add(friend);
			for(Friends x : friendsDB) {
				System.out.println(x);
			}
			AppDTO.setFriendsDB(friendsDB);
			FriendsBin.loadFriends(AppDTO.getFriendsDB());
			
			break;
		case "contactos":
			
			ArrayList<WorkContacts> contactsDB = AppDTO.getWorkContactsDB();
			contactsDB.add(contact);
			for(WorkContacts x : contactsDB) {
				System.out.println(x);
			}
			AppDTO.setWorkContactsDB(contactsDB);
			WorkContactsBin.loadWorkContacts(AppDTO.getWorkContactsDB());
			
			break;
		}
	}
	
	public boolean modify(String ref, String keyword, String attribute, String newValue ) { //ref es la categoría a modificar, keyword es el valor del atributo único para ubicar el objeto, attribute es la variable a modificar
		ref = ref.toLowerCase();
		keyword = keyword.toLowerCase();
		attribute = attribute.toLowerCase();
		boolean found = false; //Para saber cuando se encotró o no se encontró el objeto buscado
		boolean legal = true; //Para saber si un valor de un atributo único está ya repetido: True: no está repetido
							  //              												  False: Está repetido
		
		switch(ref) {
		case "paises":
			//Traer la base de datos
			ArrayList<Countries> countriesDB = AppDTO.getCountriesDB();

			//Verificar que el valor nuevo no esté repetido
			for(Countries x : countriesDB) {
				if(x.getCountry().equals(newValue)) {
					legal = false; //El valor a poner ya lo tiene otro objeto
				}
			}
			//Buscar el objeto por su atributo único
			if(legal) { //Si el valor nuevo no está repetido
				for(Countries x : countriesDB) {
					if(x.getCountry().toLowerCase().equals(keyword)) {
						x.setCountry(newValue);
						found = true;
						break;
					}
				}
				return found; //True si lo encuentra, false si no lo encuentra
			}else {
				return found; //false, el valor a poner ya existe, por lo que ni buscó el objeto
			}
		
		case "amigos":
			//Traer la base de datos
			ArrayList<Friends> friendsDB = AppDTO.getFriendsDB();
			
			//Verificar que el valor nuevo no esté repetido en el atributo único
			if(attribute.equals("nombre")) { //Si está intentando modificar el atributo único
				for(Friends x : friendsDB) {
					if(x.getName().equals(newValue)) { //El atributo único de friends es name
						legal = false;  //El newValue ya existe
						break;
					}
				}
			}
			
			//Buscar el objeto por su atributo único
			for(Friends x : friendsDB) {
				if(x.getName().equals(keyword)) { //Si encuentra el objeto
					//Ver cual es el atributo que quiere modificar de este objeto
					switch(attribute) {
					case "nombre": //Busca actualizar el atributo único
						if(legal) { //El newValue no está repetido, se puede poner
							found = true;
							x.setName(newValue);
						}
						break;
					case "pais": //Busca actualizar country
						x.setCountry(newValue); //Actualizar el atributo
						found = true;
						break;
					case "telefono":
						x.setPhoneNumber(newValue);
						found = true;
						break;
					case "correo":
						x.setEmail(newValue);
						found = true;
						break;
					default: 
						//Atributo no encontrado
						found = false;
						break;
					}
					break; //Para detener el for-each
					
				}
			}
			//Actualizar la base de datos y binario
			if(found) {
				AppDTO.setFriendsDB(friendsDB); //Actualizar central de datos
				FriendsBin.loadFriends(AppDTO.getFriendsDB()); //Actualizar binario
				return found;
			}else { //No se encontró o no se modificó el objeto
				return found;
			}
			
			
		case "contactos":
			//Traer la base de datos
			ArrayList<WorkContacts> contactsDB = AppDTO.getWorkContactsDB();
			
			//Verificar si newValue ya existe en su atributo único
			if(attribute.equals("nombre")) { //El atributo único de WorkContacts es name
				for(WorkContacts x : contactsDB) {
					if(x.getName().equals(newValue)) {
						legal = false; //newValue ya es valor de un atributo único
						break;
					}
				}
			}
			
			//Buscar el objeto por su atributo único
			for(WorkContacts x : contactsDB) {
				if(x.getName().equals(keyword)) {
					//Se encontró el objeto, ahora a ver cuál atributo desea modificar
					switch(attribute) {
					case "nombre":
						if(legal) { //newValue no está repetido en los atributos únicos, se puede poner
							x.setName(newValue);
							found = true;
						}
						break;
					
					case "empresa":
						x.setBusiness(newValue);
						found = true;
						break;
					case "pais": 
						x.setCountry(newValue);
						found = true;
						break;
					case "telefono":
						x.setPhoneManager(newValue);
						found = true;
						break;
					case "correo":
						x.setEmail(newValue);
						found = true;
						break;
					default:
						//No se encontró el atributo
						found = false;
						break;
						
					}//del switch attribute
					
					break; //Para detener el for-each
				}
			}
			//Actualizar el valor en la central y en el binario
			if(found) {
				AppDTO.setWorkContactsDB(contactsDB);
				WorkContactsBin.loadWorkContacts(AppDTO.getWorkContactsDB());
				return found;
			}else { //No se encontró el objeto o no se modificó
				return found;
				
			}
		
		default:
			//La categoría no se encontró
			return false;
			
		} //del switch ref
	}
	
	public Object search(String ref, String keyword) { //Ref es la categoría (countries, friends, etc) y keyword es el valor del atributo único para buscar
		ref = ref.toLowerCase();
		keyword = keyword.toLowerCase(); //No se puede hacer esto, ya que en el archivo inicia en Mayusculas
		String search = "";							//A menos que "x.getCountry" se convierta antes
		switch(ref) {
		case "paises":
			//Traer base de datos
			ArrayList<Countries> countriesDB = AppDTO.getCountriesDB();
			//Buscar el objeto por su atributo único
			for(Countries x : countriesDB) {
				search = x.getCountry().toLowerCase();
				if(search.equals(keyword)) { //country es el atributo único de Countries
					return x;
				}
			}
			System.out.println("null(Desde el método)");
			return null; //No se encontró el objeto
			
		case "amigos":
			//Traer base de datos
			ArrayList<Friends> friendsDB = AppDTO.getFriendsDB();
			//Buscar el objeto por su atributo único
			for(Friends x : friendsDB) {
				search = x.getName().toLowerCase();
				if(search.equals(keyword)) { //name es el atributo único de friends
					return x;
				}
			}
			return null; //No se encontró el objeto
			
		case "contactos":
			ArrayList<WorkContacts> contactsDB = AppDTO.getWorkContactsDB();
			
			for(WorkContacts x : contactsDB) {
				search = x.getName().toLowerCase();
				if(search.equals(keyword)) { //name es el atributo único de WorkContacts
					return x;
				}
			}
			return null; //No se encontró el objeto
		
		default:
			//No se encontró la categoría buscada
			return null;
		}
		
	}
	
	public boolean delete(String ref, String keyword) { //Ref es la categoría (countries, friends, etc) y keyword es el valor del atributo único para buscar
		ref = ref.toLowerCase();
		keyword = keyword.toLowerCase();
		boolean deleted = false;
		
		switch(ref) {
		case "paises":
			//Traer base de datos
			ArrayList<Countries> countriesDB = AppDTO.getCountriesDB();
			//Buscar el objeto por su atributo único
			for(Countries x : countriesDB) {
				if(x.getCountry().toLowerCase().equals(keyword)) { //country es el atributo único de Countries
					countriesDB.remove(x);
					deleted = true;
					return deleted;
				}
			}
			return deleted; //No se encontró el objeto, por lo que no se borró nada
			
		case "amigos":
			//Traer base de datos
			ArrayList<Friends> friendsDB = AppDTO.getFriendsDB();
			//Buscar el objeto por su atributo único
			for(Friends x : friendsDB) {
				if(x.getName().toLowerCase().equals(keyword)) { //name es el atributo único de friends
					friendsDB.remove(x);
					deleted = true;
					return deleted;
				}
			}
			return deleted; 
			
		case "contactos": 
			//La misma lógica de los anteriores
			ArrayList<WorkContacts> contactsDB = AppDTO.getWorkContactsDB();
			
			for(WorkContacts x : contactsDB) {
				if(x.getName().toLowerCase().equals(keyword)) { //name es el atributo único de WorkContacts
					contactsDB.remove(x);
					deleted = true;
					return deleted;
				}
			}
			return deleted;
		
		default:
			//No se encontró la categoría buscada
			return deleted; //false
		}
		
	}
	
	public PropertiesDAO getPropertiesDAO() {
		return this.PropDAO;
	}

	public AppDTO getAppDTO() {
		return AppDTO;
	}

	public void setAppDTO(AppDTO appDTO) {
		AppDTO = appDTO;
	}
	
}
