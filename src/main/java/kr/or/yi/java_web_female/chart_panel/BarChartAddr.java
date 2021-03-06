package kr.or.yi.java_web_female.chart_panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;

public class BarChartAddr extends JPanel {
	
	private JPanel contentPane;
	public DataBarChartCustomerAddr pBarChart;
	
	public DataBarChartCustomerAddr getpBarChart() {
		return pBarChart;
	}
	
	public BarChartAddr() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pBarChart = new DataBarChartCustomerAddr();
		add(pBarChart);
		Platform.runLater(() -> initFX(pBarChart));
		
	}

	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
	
}
