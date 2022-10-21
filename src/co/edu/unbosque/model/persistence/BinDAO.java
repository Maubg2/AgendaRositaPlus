package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model1.Countries;
import co.edu.unbosque.model1.Friends;
import co.edu.unbosque.model1.WorkContacts;

/**
 * <h2>Binario</h2>
 * <p>Clase que almacena la base de los archivos binarios</p>
 * 
 * @author J&M Sistemas
 *
 */
public class BinDAO{
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private File file;
	
	public BinDAO(String src) {
		file = new File(src);
		if(!file.exists()) {
			try {
				file.createNewFile();
				this.file = file;
			} catch (IOException e) {
				System.out.println("Error creando el archivo"); //Debug
			}
		}else {
			this.file = file;
		}
	}
	
	/**
	 * <h2>Cargar países</h2>
	 * <p>Carga un ArrayList de tipo Countries al binario Countries.dat</p>
	 * @param data
	 */
	public void loadCountry(ArrayList<Countries> data) {
		
		try {
			FileOutputStream FOS = new FileOutputStream(file);
			output = new ObjectOutputStream(FOS);
			output.writeObject(data); 
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado (loadCountry)");
		} catch (IOException e) {
			System.out.println("Error (loadCountry)");
		}
		
	}
	
	/**
	 * <h2>Cargar amigos</h2>
	 * <p>Carga un ArrayList de tipo Friends al binario de Friends.dat</p>
	 * @param data
	 */
	
	public void loadFriends(ArrayList<Friends> data) {
		try {
			FileOutputStream FOS = new FileOutputStream(file);
			output = new ObjectOutputStream(FOS);
			output.writeObject(data); 
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado (loadFriends)");
		} catch (IOException e) {
			System.out.println("Error (loadFriends)");
		}
	}
	
	/**
	 * <h2>Cargar contactos de trabajo</h2>
	 * <p>Carga un ArrayList de tipo WorkContacts al binario WorkContacts.bin</p>
	 * @param data
	 */
	
	public void loadWorkContacts(ArrayList<WorkContacts> data) {
		try {
			FileOutputStream FOS = new FileOutputStream(file);
			output = new ObjectOutputStream(FOS);
			output.writeObject(data); 
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado (loadFriends)");
		} catch (IOException e) {
			System.out.println("Error (loadFriends)");
		}
	}
}
