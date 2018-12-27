package kr.or.yi.java_web_female.chart_panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.service.CarModelService;

public class PieChartBrand extends JPanel{
	
	private JPanel contentPane;
	private CarModelService service;
	private DataPieChartBrand pPieChart;
	/**
	 * Create the panel.
	 */
	public PieChartBrand() {
		service = new CarModelService();
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




















