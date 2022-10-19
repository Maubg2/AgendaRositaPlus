package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import co.edu.unbosque.model1.Countries;
import co.edu.unbosque.model1.Friends;
import co.edu.unbosque.model1.WorkContacts;

/**
 * <h2>DAO del archivo properties</h2>
 * <p>
 * Clase que contiene toda la lógica para extraer los datos del archivo .properties
 * dado
 * </p>
 * @author J&M Sistemas
 *
 */
public class PropertiesDAO {
	
	//private FileProperties FP;
	private File f;
	private FileInputStream FIS;
	private Properties prop;
	
	private Friends friends;
	private WorkContacts workContacts;
	private Countries countries;
	
	public PropertiesDAO() {
		
	}
	
	/**
	 * <h2>Cargar datos</h2>
	 * <p>
	 * Busca el archivo en la ruta especificada en los parámetros
	 * y si no existe, crea los archivos .dat
	 * </p>
	 * 
	 * @param src
	 */
	
	public void loadData(String src) {
		try {
			f = new File(src);
			FIS = new FileInputStream(f);
			prop = new Properties();
			prop.load(FIS);
			FIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch(IOException e) {
			System.out.println("Error cargando el archivo");
		} catch(NullPointerException e) {
			System.out.println("La ruta no fue cargada");
		}
		
	}
	
	/**
	 * Traer una propiedad del archivo en base a una clave dada
	 * @param key
	 * @return
	 */
	
	public String readData(String key) {
		return prop.getProperty(key);
	}
	
	/**
	 * <h2>Archivo está cargado</h2>
	 * <p>
	 * Verificar si el atributo file tiene valor, retorna true si si tiene, y false si
	 * no tiene valor
	 * </p>
	 * @return
	 */
	public boolean isFileLoaded() {
		return (f != null) ? true : false;
		
	}
	public File getFileProperties() {
		return this.f;
	}
	
	/**
	 * <h2>Obtener datos de países</h2>
	 * <p>Trae toda la información de la sección países del archivo properties</p>
	 * @return
	 */
	
	public ArrayList<Countries> getCountryData() {
		ArrayList<Countries> countriesList = new ArrayList<Countries>();
		
		try {
			f = new File("src/datos/agendaFisica.properties");
			FIS = new FileInputStream(f);
			prop = new Properties();
			prop.load(FIS);
			FIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch(IOException e) {
			System.out.println("Error cargando el archivo");
		} catch(NullPointerException e) {
			System.out.println("La ruta no fue cargada");
		}
		
		String country;
		
		for(int i = 1; i <= 6; i++) {
			country = prop.getProperty("agenda.pais" + i);
			countries = new Countries(country);
			countriesList.add(countries);
		}
		
		
	/*	for(Countries x : countriesList) {//Prueba del método
			System.out.println(x);
		}*/
		return countriesList;
	}
	
	/**
	 * <h2>Traer datos de amigos</h2>
	 * <p>
	 * Extrae y retorna toda la información contenida en la sección amigos del
	 * archivo .properties
	 * </p>
	 * @return
	 */
	
	public ArrayList<Friends> getFriendsData() {
		
		ArrayList<Friends> closeFriends = new ArrayList<Friends>();
		
		try {
			f = new File("src/datos/agendaFisica.properties");
			FIS = new FileInputStream(f);
			prop = new Properties();
			prop.load(FIS);
			FIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch(IOException e) {
			System.out.println("Error cargando el archivo");
		} catch(NullPointerException e) {
			System.out.println("La ruta no fue cargada");
		}
		
		String name = "";
		String country = "";
		String phoneNumber = "";
		String email = "";
		
		for(int i = 1; i <= 4; i++) {
	
			name = prop.getProperty("amigo.nombre" + i);
			country = prop.getProperty("amigo.pais" + i);
			phoneNumber = prop.getProperty("amigo.telefono" + i);
			email = prop.getProperty("amigo.correo" + i);
			
			friends = new Friends(name, country, phoneNumber, email);
			closeFriends.add(friends);
			
		}
		/*
		for(Friends x : closeFriends) {//Prueba del ciclo for
			System.out.println(x);
		}
		*/
		return closeFriends;
	}
	
	/**
	 * <h2>Traer la información de contactos</h2>
	 * <p>
	 * Extrae y retorna toda la información de la sección contactos de trabajo del
	 * archivo .properties
	 * </p>
	 * @return
	 */
	
	public ArrayList<WorkContacts> getWorkContactsData() {
		
		ArrayList<WorkContacts> workContactsList = new ArrayList<WorkContacts>();
		
		try {
			f = new File("src/datos/agendaFisica.properties");
			FIS = new FileInputStream(f);
			prop = new Properties();
			prop.load(FIS);
			FIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch(IOException e) {
			System.out.println("Error cargando el archivo");
		} catch(NullPointerException e) {
			System.out.println("La ruta no fue cargada");
		}
		
		String name = "";
		String business = "";
		String country = "";
		String phoneManager = "";
		String email = "";
		
		for(int i = 1; i <= 3; i++) {
			name = prop.getProperty("contacto.nombre" + i);
			business = prop.getProperty("contacto.empresa" + i);
			country = prop.getProperty("contacto.pais" + i);
			phoneManager = prop.getProperty("contacto.telefonoManager" + i);
			email = prop.getProperty("contacto.correo" + i);
			
			workContacts = new WorkContacts(name, business, country, phoneManager, email);
			workContactsList.add(workContacts);
		}

		
	/*	for(WorkContacts x : workContactsList) {
			System.out.println(x);
		}*/
		return workContactsList;
	}
}
