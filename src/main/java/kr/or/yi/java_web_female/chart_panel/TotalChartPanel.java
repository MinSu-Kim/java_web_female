package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class TotalChartPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TotalChartPanel() {
		setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelCar = new JPanel();
		add(panelCar);
		panelCar.setLayout(new GridLayout(0, 3, 0, 0));
		
		BarChartCarModel panel_BarChart = new BarChartCarModel();
		panelCar.add(panel_BarChart);
		
		PieChartCarType panel_PieChart = new PieChartCarType();
		panelCar.add(panel_PieChart);
		
		JPanel panelCustomer = new JPanel();
		add(panelCustomer);
		
		JPanel panelRent = new JPanel();
		add(panelRent);

	}

}
