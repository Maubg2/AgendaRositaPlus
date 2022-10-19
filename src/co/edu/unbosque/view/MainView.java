package co.edu.unbosque.view;

import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model1.Countries;
import co.edu.unbosque.model1.Friends;
import co.edu.unbosque.model1.WorkContacts;

/**
 * <h2>MainView</h2>
 * <p>Clase que contiene e instancia todos los paneles del programa, 
 * se le da valor al JFrame y contiene metodos del JFileChooser</p>
 * 
 * @author J&M Sistemas 
 */

public class MainView extends JFrame{
	
	private PTitle titlePanel;
	private PFile filePanel;
	private PButtons buttonsPanel;
	private JFileChooser fileChooser;
	
	public MainView() {
		
		funcionar();
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#002B5B"));
		setTitle("Agenda de Rosita plus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
	public void funcionar() {
		
		titlePanel = new PTitle();
		titlePanel.setBounds(0, 0, 800, 100);
		getContentPane().add(titlePanel);
		
		filePanel = new PFile();
		filePanel.setBounds(210, 100, 550, 850);
		getContentPane().add(filePanel);
		
		buttonsPanel = new PButtons();
		buttonsPanel.setBounds(0, 100, 400, 500);
		buttonsPanel.setBackground(Color.decode("#2B4865"));
		getContentPane().add(buttonsPanel);
		
		fileChooser = new JFileChooser();
		
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PROPERTIES", "properties"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		
	}
	
	/**
	 * <h2>Mostrar JFileChooser</h2>
	 * <p>Metodo que muestra el JFileChooser y retorna la opcion elegida</p>
	 * @return
	 */
	public String showFileChooser() {
		String response = null;
		int r = fileChooser.showSaveDialog(null);
		if(r == JFileChooser.APPROVE_OPTION) {
			response = fileChooser.getSelectedFile().getAbsolutePath();
		}
		else {
			System.out.println("Operación cancelada");
		}
		
		return response;
	}
	
	/**
	 * <h2>Cargar JTextArea</h2>
	 * <p>Metodo que muestra todos los datos contenidos en los ArrayList
	 * en su respectivo JTextArea</p>
	 * @param countriesDB
	 * @param friendsDB
	 * @param contactsDB
	 */
	
	public void loadTextArea(ArrayList<Countries> countriesDB, ArrayList<Friends> friendsDB, ArrayList<WorkContacts> contactsDB) {
		
		if(countriesDB != null) {
			for(Countries x : countriesDB) {
				filePanel.writeCountriesArea(x.toString());
			}
		}
		
		if(friendsDB != null) {
			for(Friends x : friendsDB) {
				filePanel.writefriendsArea(x.toString());
			}
		}
		
		if(contactsDB != null) {
			for(WorkContacts x : contactsDB) {
				filePanel.writeContactsArea(x.toString());
			}
		}
		
		//filePanel.getFriendsArea()
	}
	
	
	/**
	 * <h2>Actualizar JTextArea</h2>
	 * <p>Metodo que al actualizar los ArrayList añade los nuevos datos al JTextArea</p>
	 * @param newCountry
	 * @param newFriend
	 * @param newWorkContact
	 */
	public void updateTextArea(Countries newCountry, Friends newFriend, WorkContacts newWorkContact) {
		
		if(newCountry != null) {
			filePanel.writeCountriesArea(filePanel.getCountriesArea().getText() + "\n" + newCountry.toString());
		}
		
		if(newFriend != null) {
			filePanel.writefriendsArea(filePanel.getFriendsArea().getText() + "\n" + newFriend.toString());
		}
		
		if(newWorkContact != null) {
			filePanel.writeContactsArea(filePanel.getContactsArea().getText() + "\n" + newWorkContact.toString());
		}
	}

	public PTitle getTitlePanel() {
		return titlePanel;
	}

	public void setTitlePanel(PTitle titlePanel) {
		this.titlePanel = titlePanel;
	}

	public PFile getFilePanel() {
		return filePanel;
	}

	public void setFilePanel(PFile filePanel) {
		this.filePanel = filePanel;
	}

	public PButtons getButtonsPanel() {
		return buttonsPanel;
	}

	public void setButtonsPanel(PButtons buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

}
