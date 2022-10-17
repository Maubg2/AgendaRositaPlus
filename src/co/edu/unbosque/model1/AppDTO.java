package co.edu.unbosque.model1;

import java.util.ArrayList;

public class AppDTO {
	//Central de datos
	private ArrayList<Countries> countriesDB;
	private ArrayList<Friends> friendsDB;
	private ArrayList<WorkContacts> workContactsDB;
	
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
