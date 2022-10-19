package co.edu.unbosque.model1;

import java.io.Serializable;

/**
 * <h2>Clase de atributos tipo Friends</h2>
 * <p>
 * Estan todos los atributos, metodos setters y getters y toString de Friends
 * </p>
 * 
 * @author J&M Sistemas
 */

public class Friends implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name; //Atributo único
	private String country; 
	private String phoneNumber;
	private String email;
	
	public Friends(String name, String country, String phoneNumber, String email) {
		this.name = name;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		return "Nombre: " + name + "\nPais: " + country + "\nNumero de telefono: " + phoneNumber + "\nCorreo electronico: " + email + "\n";
	}

}
