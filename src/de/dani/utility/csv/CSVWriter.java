package de.dani.utility.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
	File file;

	public CSVWriter(File file) {
		this.file = file;
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String... strings) {
		try  {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			for (int i = 0; i < strings.length; i++) {
				bw.write(strings[i] + ",");
			}
			bw.newLine();
			bw.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
