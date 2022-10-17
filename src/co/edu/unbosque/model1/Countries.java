package co.edu.unbosque.model1;

import java.io.Serializable;

public class Countries implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String country; //Atributo único
	
	public Countries(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Pais: " + country;
	}

}
