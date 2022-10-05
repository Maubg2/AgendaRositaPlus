package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDAO {
	
	//private FileProperties FP;
	private File f;
	private FileInputStream FIS;
	private Properties prop;
	
	public PropertiesDAO() {
		
	}
	
	public void loadData(String src) {
		try {
			f = new File(src);
			FIS = new FileInputStream(f);
			prop = new Properties();
			prop.load(FIS);
			FIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch(IOException e) {
			System.out.println("Error cargando el archivo");
		} catch(NullPointerException e) {
			System.out.println("Archivo no cargado");
		}
		
	}
	
	public String readData(String key) {
		return prop.getProperty(key);
	}
	public boolean isFileLoaded() {
		return (f != null) ? true : false;
		
	}
	public File getFileProperties() {
		return this.f;
	}
	public void loadSrcFile(String src) {
		
	}
}
