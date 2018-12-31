package kr.or.yi.java_web_female.chart_panel;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;

import com.jtattoo.plaf.graphite.GraphiteRootPaneUI;

@SuppressWarnings("serial")
public class CarChartPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CarChartPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelCar = new JPanel();
		panel_2.add(panelCar);
		panelCar.setLayout(new GridLayout(0, 2, 0, 0));
		
		BarChartCarModel panel_BarChart = new BarChartCarModel();
		panelCar.add(panel_BarChart);
		
		PieChartCarType panel_PieChart = new PieChartCarType();
		panelCar.add(panel_PieChart);
		
		JPanel panelCar2 = new JPanel();
		panel_2.add(panelCar2);
		panelCar2.setLayout(new GridLayout(0, 2, 0, 0));
		
		PieChartBrand panel = new PieChartBrand();
		panelCar2.add(panel);
		
		LineChartRentCount panel_1 = new LineChartRentCount();
		panelCar2.add(panel_1);
		
		JPanel panelBtn = new JPanel();
		add(panelBtn, BorderLayout.NORTH);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnCarModel = new JRadioButton("차량별 대여회수");
		group.add(rdbtnCarModel);
		panelBtn.add(rdbtnCarModel);
		
		JRadioButton rdbtnCarType = new JRadioButton("차종별 보유개수");
		group.add(rdbtnCarType);
		panelBtn.add(rdbtnCarType);
		
		JRadioButton rdbtnBrand = new JRadioButton("브랜드별 보유개수");
		group.add(rdbtnBrand);
		panelBtn.add(rdbtnBrand);
		
		JRadioButton rdbtnRentCount = new JRadioButton("차종별 월 렌트 수");
		group.add(rdbtnRentCount);
		panelBtn.add(rdbtnRentCount);

	}

}
