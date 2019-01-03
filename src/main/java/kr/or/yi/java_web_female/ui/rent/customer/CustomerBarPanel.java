package kr.or.yi.java_web_female.ui.rent.customer;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;

import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerBarPanel extends JPanel {
	private CustomerBarChart customerBarChart;
	
	public CustomerBarChart getCustomerBarChart() {
		return customerBarChart;
	}

	/**
	 * Create the panel.
	 */
	public CustomerBarPanel() {
		initComponents();
		
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		customerBarChart = new CustomerBarChart();
		add(customerBarChart, BorderLayout.CENTER);
		Platform.runLater(() -> initFX(customerBarChart));
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}

}
