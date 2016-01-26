package de.dani.utility.swing;

import javax.swing.JFrame;

public class FileDialog {
	public static String showFileDialog(JFrame f, String msg, int mode,
			String fileType) {
		java.awt.FileDialog fd = new java.awt.FileDialog(f, msg, mode);
		fd.setFile(fileType);
		fd.setDirectory(System.getProperty("user.home"));
		fd.setLocationRelativeTo(f);
		fd.setVisible(true);
		return fd.getDirectory() + fd.getFile();
	}

}
