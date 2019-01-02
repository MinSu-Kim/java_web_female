package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class RentStatisticsPiePanel extends JPanel {
	private RentCarOptionsPieChart rentCarOptionsPieChart;
	private JPanel pCarOptionsPieChart;
	
	public RentCarOptionsPieChart getRentCarOptionsPieChart() {
		return rentCarOptionsPieChart;
	}

	/**
	 * Create the panel.
	 */
	public RentStatisticsPiePanel() {
		
		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		pCarOptionsPieChart = new JPanel();
		add(pCarOptionsPieChart, BorderLayout.CENTER);
		pCarOptionsPieChart.setLayout(new BorderLayout(0, 0));
		
		rentCarOptionsPieChart = new RentCarOptionsPieChart();
		pCarOptionsPieChart.add(rentCarOptionsPieChart);
		
		Platform.runLater(() -> initFX(rentCarOptionsPieChart));
	}

	private void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

}
