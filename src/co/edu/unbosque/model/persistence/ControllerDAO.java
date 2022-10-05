package co.edu.unbosque.model.persistence;

public class ControllerDAO {
	
	private PropertiesDAO PropDAO;
	
	public ControllerDAO() {
		PropDAO = new PropertiesDAO();
	}
	
	public PropertiesDAO getPropertiesDAO() {
		return this.PropDAO;
	}
}
