package kr.or.yi.java_web_female.chart_panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

@SuppressWarnings("serial")
public class PieChartCarType extends JPanel{
	
	private JPanel contentPane;
	private DataPieChartCarType pPieChart;
	
	
	public DataPieChartCarType getpPieChart() {
		return pPieChart;
	}

	public PieChartCarType() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		add(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pPieChart = new DataPieChartCarType();
		contentPane.add(pPieChart);
		
		Platform.runLater(() -> initFX(pPieChart));
		
	}

	private void initFX(DataPieChartCarType fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel)fxPanel;
		panel.setScene(scene);
	}
	
	


}





















