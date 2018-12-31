package kr.or.yi.java_web_female.chart_panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;

@SuppressWarnings("serial")
public class LineChartRentCount extends JPanel {
	private JPanel contentPane;
	private DataLineChartRentCount pLineChart;
	
	public DataLineChartRentCount getpLineChart() {
		return pLineChart;
	}

	public LineChartRentCount() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		add(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//라인차트 패널 붙이기
		pLineChart = new DataLineChartRentCount();
		contentPane.add(pLineChart);
		
		Platform.runLater(() -> initFX(pLineChart));
	}

	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
}

























