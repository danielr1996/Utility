package de.dani.utility.swing;

import javax.swing.JOptionPane;

class InputDialog {
	public static String showStringDialog(String msg) {
		String s = JOptionPane.showInputDialog(msg);
		if (s.equals("") || s == null) {
			return "";
		}
		return s;
	}

	public static int showIntDialog(String msg) {
		while (true) {
			try {
				String s = showStringDialog(msg);
				if (s.equals("")) {
					return 0;
				}
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
			}
		}
	}
}
