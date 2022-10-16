package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model1.Countries;

public class ControllerDAO {
	
	private PropertiesDAO PropDAO;
	private BinDAO BinDAO;
	
	public ControllerDAO() {
		PropDAO = new PropertiesDAO();
	}
	
	public void setBinaries() {
		BinDAO CountriesBin = new BinDAO("src/datos/CountriesBin.dat");
		BinDAO FriendsBin = new BinDAO("src/datos/FriendsBin.dat"); //Traer o crear los binarios
		BinDAO WorkContactsBin = new BinDAO("src/datos/WorkContacts.dat");
		
		CountriesBin.loadCountry(PropDAO.getCountryData());
		FriendsBin.loadFriends(PropDAO.getFriendsData()); //Agregarle los ArrayList a los binarios traídos del properties
		WorkContactsBin.loadWorkContacts(PropDAO.getWorkContactsData());
	}
	
	public PropertiesDAO getPropertiesDAO() {
		return this.PropDAO;
	}
}
