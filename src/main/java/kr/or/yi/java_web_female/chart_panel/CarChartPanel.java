package kr.or.yi.java_web_female.chart_panel;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CarChartPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CarChartPanel() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelCar = new JPanel();
		add(panelCar);
		panelCar.setLayout(new GridLayout(0, 2, 0, 0));
		
		BarChartCarModel panel_BarChart = new BarChartCarModel();
		panelCar.add(panel_BarChart);
		
		PieChartCarType panel_PieChart = new PieChartCarType();
		panelCar.add(panel_PieChart);
		
		JPanel panelCar2 = new JPanel();
		add(panelCar2);
		panelCar2.setLayout(new GridLayout(0, 2, 0, 0));
		
		PieChartBrand panel = new PieChartBrand();
		panelCar2.add(panel);
		
		LineChartRentCount panel_1 = new LineChartRentCount();
		panelCar2.add(panel_1);

	}

}
