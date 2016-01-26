package de.dani.utility.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	File file;
	BufferedReader br;

	public CSVReader(File file) {
		this.file = file;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<String[]> read() {
		List<String[]> lines = new ArrayList<String[]>();
		try  {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			lines = new ArrayList<String[]>();
			while ((s = br.readLine()) != null) {
				lines.add(s.replaceAll(";", "").split(","));
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return lines;
	}

	public String[] readLine() {
		String line;
		try {
			line = br.readLine();
			if (line != null) {
				return line.replaceAll(";", "").split(",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
