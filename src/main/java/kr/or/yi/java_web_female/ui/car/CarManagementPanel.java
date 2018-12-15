package kr.or.yi.java_web_female.ui.car;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CarManagementPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CarManagementPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		CarTypeListPanel panelType = new CarTypeListPanel();
		panel.add(panelType);
		
		BrandListPanel panelBrand = new BrandListPanel();
		panel.add(panelBrand);
		
		FuelListPanel panelFuel = new FuelListPanel();
		panel.add(panelFuel);
		
		CarOptionListPanel panelOption = new CarOptionListPanel();
		panel.add(panelOption);

	}

}