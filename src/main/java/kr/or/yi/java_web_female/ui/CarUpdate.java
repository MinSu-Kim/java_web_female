package kr.or.yi.java_web_female.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CarUpdate extends JPanel {

	/**
	 * Create the panel.
	 */
	public CarUpdate() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		ComboPanel panel_1 = new ComboPanel();
		panel.add(panel_1);
		
		ComboPanel panel_3 = new ComboPanel();
		panel.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);

	}

}
