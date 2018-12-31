package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;

import javax.swing.BoxLayout;

public class RentStatisticsPanel extends JPanel {
	private RentLineChart rentLineChart;
	
	/**
	 * Create the panel.
	 */
	public RentStatisticsPanel() {
		initComponents();

	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel pRentLineChart = new JPanel();
		add(pRentLineChart);
		
		rentLineChart = new RentLineChart();
		pRentLineChart.add(rentLineChart);
		
		Platform.runLater(() -> initFX(rentLineChart));
	}

	private void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

}
