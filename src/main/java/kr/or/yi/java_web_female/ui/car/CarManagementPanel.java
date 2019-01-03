package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CarManagementPanel extends JPanel {
	private CarPanel carPanel;

	public CarManagementPanel() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		CarTypeListPanel panelType = new CarTypeListPanel();
		panelType.setCarManagementPanel(this);
		panel.add(panelType);
		
		BrandListPanel panelBrand = new BrandListPanel();
		panelBrand.setCarManagementPanel(this);
		panel.add(panelBrand);
		
		FuelListPanel panelFuel = new FuelListPanel();
		panelFuel.setCarManagementPanel(this);
		panel.add(panelFuel);
		
		CarOptionListPanel panelOption = new CarOptionListPanel();
		panel.add(panelOption);
	}

	public void setCarPanel(CarPanel carPanel) {
		this.carPanel = carPanel;
	}
	public void setListComboBoxManagement() {
		carPanel.setListComboBox();
	}

}
