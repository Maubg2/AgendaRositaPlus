package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.WindowView;

public class ModelProperties {
	
	//PropertiesDAO propD;
	ControllerDAO controllerDAO;
	WindowView windowTool;
	
	Properties prop;
	FileInputStream FIS;
	//File file = new File("src/datos/agendaFisica.properties");
	//MainView mainView;
	
	
	
	public ModelProperties() {
		
		controllerDAO = new ControllerDAO();
		windowTool = new WindowView();
		//propD = new PropertiesDAO();
		//mainView = new MainView();
		prop = new Properties();
		/*
		try {
			FIS = new FileInputStream(file);
			prop.load(FIS);
			FIS.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		//funcionar();
		
	}
	
	public void cambiarNombre() { // El método se está implementando en controller (opción agregar)
		
		//propD.loadData(mainView.showFileChooser());
		//controllerDAO.getPropertiesDAO().loadData(mainView.showFileChooser());
	/*
		try {
			String nombre = windowTool.getDataWindow("Nombre a cambiar:");
			prop.setProperty("amigo.nombre1", nombre);
			prop.store(new FileOutputStream(file), null);
			System.out.println(prop.getProperty("amigo.nombre1"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} */
		
		/*
		try {
			controllerDAO.getPropertiesDAO().loadData("src/datos/agendaFisica.properties");
			prop.setProperty("amigo.nombre1", "Mau");
			prop.store(new FileOutputStream("src/datos/agendaFisica.properties"), null);
			windowTool.showWindow(prop.getProperty("amigo.nombre1"));
			System.out.println(prop.getProperty("amigo.nombre1"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Properties prop;
		FileInputStream FIS;
		File file = new File("src/datos/agendaFisica.properties");
		
	
		String nombre = windowTool.getDataWindow("Digite el nuevo nombre");
		
		try {
			prop = new Properties();
			FIS = new FileInputStream(file);
			prop.load(FIS);
			prop.setProperty("amigo.nombre1", nombre); //Pruebas con amigo.nombre1
			prop.store(new FileOutputStream(file), null);
			
			FIS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	
	}

}
