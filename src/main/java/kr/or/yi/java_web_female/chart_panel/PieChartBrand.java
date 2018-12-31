package kr.or.yi.java_web_female.chart_panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

@SuppressWarnings("serial")
public class PieChartBrand extends JPanel{
	
	private JPanel contentPane;
//	private CarModelService service;
	private DataPieChartBrand pPieChart;
	/**
	 * Create the panel.
	 */
	public PieChartBrand() {
//		service = new CarModelService();
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		add(contentPane);
		
		pPieChart = new DataPieChartBrand();
		contentPane.add(pPieChart);
		
		Platform.runLater(() -> initFX(pPieChart));
		
	}

	private void initFX(DataPieChartBrand fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel)fxPanel;
		panel.setScene(scene);
	}
	
	


}





















