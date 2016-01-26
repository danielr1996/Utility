package de.dani.demo;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.dani.utility.l10n.Localization;
import de.dani.utility.properties.PropertyHandler;

public class MainFrame implements ItemListener {
	private JFrame frame;
	private JLabel lbl;
	private JComboBox<String> box;
	private Localization l10n;
	private PropertyHandler ph;

	public MainFrame() {
		init();
	}

	private void init() {
		ph = PropertyHandler.getHandler("res/config.properties");
		frame = new JFrame("L10N Demo");
		l10n = new Localization(ph.get("lang"));
		lbl = new JLabel(l10n.get("hello"));
		box = new JComboBox<String>(new String[] { "de", "en", "fr", "it", "es" });
		box.setSelectedItem(ph.get("lang"));
		System.out.println("Property: " +ph.get("lang"));
		box.addItemListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(getPanel());
		frame.pack();
		frame.setVisible(true);
	}

	private JComponent getPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(box, BorderLayout.NORTH);
		p.add(lbl, BorderLayout.SOUTH);

		return p;
	}

	public static void main(String... args) {
		new MainFrame();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		l10n.setLang(box.getSelectedItem().toString());
		lbl.setText(l10n.get("hello"));
		ph.put("lang", box.getSelectedItem().toString());
	}
}
