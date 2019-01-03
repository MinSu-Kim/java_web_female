package kr.or.yi.java_web_female.ui.rent.customer;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.LoginUiService;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.login.LoginUI;

public class CustomerAllStat extends JPanel {
	private CustomerPieBrand customerPieBrand;
	private CustomerBarChart customerBarChart;
	private List<Rent> list;
	private RentUIService service;
	private LoginUiService loginService;
	public static Customer loginCustomer;
	public static LoginUI loginUI;
	
	public static void setLoginUI(LoginUI loginUI) {
		CustomerAllStat.loginUI = loginUI;
	}

	/**
	 * Create the panel.
	 */
	public CustomerAllStat() {
		service = new RentUIService();
		loginService = new LoginUiService();
		
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
	
	///////////////// 테스트
	public void reloadList() {
		list = service.selectRentByAll();
	}
}
