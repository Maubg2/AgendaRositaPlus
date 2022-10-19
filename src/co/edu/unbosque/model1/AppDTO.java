package co.edu.unbosque.model1;

import java.util.ArrayList;

/**
 * <h2>DTO de la app</h2>
 * <p>
 * Clase que sirve como central de datos para que toda la app use la misma información
 * y tener control de donde se guarda
 * </p>
 * @author J&M Sistemas
 *
 */
public class AppDTO {
	//Central de datos
	private ArrayList<Countries> countriesDB = new ArrayList<Countries>();
	private ArrayList<Friends> friendsDB = new ArrayList<Friends>();
	private ArrayList<WorkContacts> workContactsDB = new ArrayList<WorkContacts>();
	
	public AppDTO() {
		System.out.println("Funciona");
	}

	public ArrayList<Countries> getCountriesDB() {
		return countriesDB;
	}

	public void setCountriesDB(ArrayList<Countries> countriesDB) {
		this.countriesDB = countriesDB;
	}

	public ArrayList<Friends> getFriendsDB() {
		return friendsDB;
	}

	public void setFriendsDB(ArrayList<Friends> friendsDB) {
		this.friendsDB = friendsDB;
	}

	public ArrayList<WorkContacts> getWorkContactsDB() {
		return workContactsDB;
	}

	public void setWorkContactsDB(ArrayList<WorkContacts> workContactsDB) {
		this.workContactsDB = workContactsDB;
	}
	
	
}
