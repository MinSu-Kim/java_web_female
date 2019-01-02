package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class RentStatisticsBarPanel extends JPanel {

	private RentTotalPriceBarChart pBarChart;

	public RentTotalPriceBarChart getpBarChart() {
		return pBarChart;
	}

	/**
	 * Create the panel.
	 */
	public RentStatisticsBarPanel() {
		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pBarChart = new RentTotalPriceBarChart();
		add(pBarChart, BorderLayout.CENTER);
		Platform.runLater(() -> initFX(pBarChart));
	}

	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

}
