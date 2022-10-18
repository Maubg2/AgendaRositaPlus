package co.edu.unbosque.model1;

import java.io.Serializable;

public class WorkContacts implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name; //Atributo único
	private String business;
	private String country;
	private String phoneManager;
	private String email;
	
	public WorkContacts(String name, String business, String country, String phoneManager, String email) {
		this.name = name;
		this.business = business;
		this.country = country;
		this.phoneManager = phoneManager;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneManager() {
		return phoneManager;
	}

	public void setPhoneManager(String phoneManager) {
		this.phoneManager = phoneManager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Nombre: " + name + "\nEmpresa: " + business + "\nPais: " + country + "\nTelefono del manager: "
				+ phoneManager + "\nCorreo electronico: " + email + "\n";
	}

}
