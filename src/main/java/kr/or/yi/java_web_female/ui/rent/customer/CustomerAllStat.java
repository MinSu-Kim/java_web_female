package kr.or.yi.java_web_female.ui.rent.customer;

import java.awt.GridLayout;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;

public class CustomerAllStat extends JPanel {
	private CustomerPieBrand customerPieBrand;
	private CustomerBarChart customerBarChart;
	
	
	/**
	 * Create the panel.
	 */
	public CustomerAllStat() {
		setLayout(new GridLayout(0, 1, 5, 5));
		
/*		JPanel pPieBrand = new JPanel();
		add(pPieBrand);*/
		
		customerPieBrand = new CustomerPieBrand();
		add(customerPieBrand);
		
		Platform.runLater(() -> initFX(customerPieBrand));
		
		customerBarChart = new CustomerBarChart();
		add(customerBarChart);
		
		Platform.runLater(() -> initFX(customerBarChart));
	}
	
	private void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
}
