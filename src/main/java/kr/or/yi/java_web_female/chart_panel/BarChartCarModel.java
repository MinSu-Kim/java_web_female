package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.service.CarModelService;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarChartCarModel extends JPanel{
	
	private JPanel contentPane;
	private CarModelService service;
	private DataBarChartCarModel pBarChart;
	/**
	 * Create the panel.
	 */
	public BarChartCarModel() {
		service = new CarModelService();
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		add(contentPane);
		
		//바차트 패널 붙임
		pBarChart = new DataBarChartCarModel();
		contentPane.add(pBarChart);
		
		Platform.runLater(() -> initFX(pBarChart));
	
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
	


}
