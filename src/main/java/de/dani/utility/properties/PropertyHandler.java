package de.dani.utility.properties;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyHandler {
	OutputStream o;
	InputStream i;
	Properties prop;
	String propFile;
	static Map<String, PropertyHandler> handlerPool = new HashMap<String, PropertyHandler>();
	
	private PropertyHandler(String propFile) {
		prop = new Properties();
		o = null;
		i = null;
		this.propFile = propFile;
		File f = new File(propFile);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static PropertyHandler getHandler(String filename){
		PropertyHandler ph = handlerPool.get(filename);
		if(ph == null){
			ph = new PropertyHandler(filename);
			handlerPool.put(filename, ph);
		}
		
		return ph;
	}
	

	public void put(String key, String value) {
		try {
			o = new FileOutputStream(propFile);
			prop.setProperty(key, value);
			prop.store(o, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (o != null) {
				try {
					o.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String get(String key) {
		try {
			i = new FileInputStream(propFile);
			prop.load(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (i != null) {
				try {
					i.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(key);
	}
}
