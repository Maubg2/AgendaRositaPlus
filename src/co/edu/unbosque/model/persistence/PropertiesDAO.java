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
	
	public String readData(String key) {
		return prop.getProperty(key);
	}
	public boolean isFileLoaded() {
		return (f != null) ? true : false;
		
	}
	public File getFileProperties() {
		return this.f;
	}
	public void loadSrcFile(String src) {
		
	}
	
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
