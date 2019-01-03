package kr.or.yi.java_web_female.ui.rent.customer;

import javax.swing.JPanel;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.LoginUiService;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.login.LoginUI;

import java.awt.BorderLayout;
import java.util.List;

public class CustomerStaticsPanel extends JPanel {
	private RentUIService service;
	private LoginUiService loginService;
	private RentCustomerStat pList;
	
	public static Customer loginCustomer;
	public static LoginUI loginUI;

	public static void setLoginUI(LoginUI loginUI) {
		CustomerStaticsPanel.loginUI = loginUI;
	}

	/**
	 * Create the panel.
	 */
	public CustomerStaticsPanel() {
		
		loginService = new LoginUiService();
		service = new RentUIService();
		
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		pList = new RentCustomerStat();
		
		reloadList();
		
		add(pList, BorderLayout.CENTER);
	}

	public void reloadList() {
		List<Rent> rentList = service.selectRentAllByCustomerCode(loginUI.loginCusotmer.getCode());
		pList.setList(rentList);
		pList.loadDatas();
	}
}
