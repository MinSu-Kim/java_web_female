package kr.or.yi.java_web_female.chart_panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class PieChartGradeType extends JPanel {

	private JPanel contentPane;
	private DataPieChartGradeType pPieChart;

	public DataPieChartGradeType getpPieChart() {
		return pPieChart;
	}

	public PieChartGradeType() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pPieChart = new DataPieChartGradeType();
		add(pPieChart);

		Platform.runLater(() -> initFX(pPieChart));
	}

	private void initFX(DataPieChartGradeType fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
}
