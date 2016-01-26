package de.dani.utility.serializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	static ObjectOutputStream o;
	static ObjectInputStream i;

	public static Object read(File file) {
		try {
			i = new ObjectInputStream(new FileInputStream(file));
			return i.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				i.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Object read(String filename) {
		try {
		
			i = new ObjectInputStream(new FileInputStream("serialized/"
					+ filename + ".bin"));
			return i.readObject();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		} finally {
			try {
				if(i != null){
					i.close();	
				}
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		return null;
	}

	/*public static Object read(Class<?> clazz) {
		try {
			i = new ObjectInputStream(new FileInputStream("serialized/"
					+ clazz.getName() + ".bin"));
			return i.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				i.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}*/

	public static void write(Object obj, File file) {
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			o = new ObjectOutputStream(new FileOutputStream(file));
			o.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void write(Object obj, String filename) {
		write(obj, new File(filename));
		/*try {
			o = new ObjectOutputStream(new FileOutputStream("serialized/"
					+ filename + ".bin"));
			o.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}

	/*public static void write(Object obj) {
		try {
			o = new ObjectOutputStream(new FileOutputStream("serialized/" +obj.getClass().getName() +".bin"));
			o.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}
