package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.yi.java_web_female.TestFrame;
import kr.or.yi.java_web_female.chart_panel.CarChartPanel;
import kr.or.yi.java_web_female.chart_panel.CustomerChartPanel;
import kr.or.yi.java_web_female.ui.car.CarManagementPanel;
import kr.or.yi.java_web_female.ui.car.CarPanel;
import kr.or.yi.java_web_female.ui.login.LoginUI;
import kr.or.yi.java_web_female.ui.management.CustommerListPannel;
import kr.or.yi.java_web_female.ui.management.CustommerUpdate;
import kr.or.yi.java_web_female.ui.management.EmployeeListPanel;
import kr.or.yi.java_web_female.ui.management.GradeEventPanel;
import kr.or.yi.java_web_female.ui.rent.AllRentPanel;
import kr.or.yi.java_web_female.ui.rent.RentListPanel;
import kr.or.yi.java_web_female.ui.rent.RentPanel;
import kr.or.yi.java_web_female.ui.rent.RentStatistics;
import kr.or.yi.java_web_female.ui.rent.customer.CustomerAllStat;
import kr.or.yi.java_web_female.ui.rent.customer.CustomerStaticsPanel;


@SuppressWarnings("serial")
public class ManagerPanel extends JPanel implements ActionListener {

	private JPanel panel;
	private JButton btnLogout;
	private TestFrame testFrame;
	private JLabel lblName;
	private JLabel lblLoginTime;
	private JLabel lblGrade;
	private JLabel lblID;
	private JLabel lblEvent;

	/**
	 * Create the panel.
	 */
	public ManagerPanel(String today) {

		setLayout(new BorderLayout(0, 0));

		JPanel pLoginInfo = new JPanel();
		add(pLoginInfo, BorderLayout.NORTH);

		lblName = new JLabel("");
		if (LoginUI.loginCusotmer == null) {
			lblName.setText(LoginUI.loginEmployee.getName() + "님");
		} else {
			lblName.setText(LoginUI.loginCusotmer.getName() + "님");
		}

		lblID = new JLabel("");
		pLoginInfo.add(lblID);
		if (LoginUI.loginCusotmer == null) {
			lblID.setText(LoginUI.loginEmployee.getCode() + "(" + LoginUI.loginEmployee.getName() + ")" + "님");
		} else {
			lblID.setText(LoginUI.loginCusotmer.getId() + "(" + LoginUI.loginCusotmer.getName() + ")" + "님");
		}

		lblLoginTime = new JLabel("");
		pLoginInfo.add(lblLoginTime);
		if (LoginUI.loginCusotmer == null) {
			lblLoginTime.setText(today);

		} else {
			lblLoginTime.setText(today);

		}

		lblGrade = new JLabel("");
		pLoginInfo.add(lblGrade);
		if (LoginUI.loginCusotmer == null) {

		} else {
			lblGrade.setText(LoginUI.loginCusotmer.getGradeCode().getName() + " 등급입니다.");
		}

		lblEvent = new JLabel("");
		pLoginInfo.add(lblEvent);
		if (LoginUI.loginCusotmer == null) {
			/*
			 * lblID.setText(LoginUI.loginEmployee.getCode() + "(" +
			 * LoginUI.loginEmployee.getName() + ")" + "님");
			 */
		} else {
			String event = LoginUI.loginCusotmer.getEvents().toString();
			event=event.replace("[", "");
			event=event.replace("]", "");
			lblEvent.setText("고객님이 가지고 있는 쿠폰은 "+event + " 입니다.");
		
		}

		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(this);
		pLoginInfo.add(btnLogout);
		panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, BorderLayout.CENTER);

		if (TestFrame.loginEmployee()) {

			CustommerListPannel panel_01 = new CustommerListPannel();
			tabbedPane.addTab("고객관리", null, panel_01, null);

			EmployeeListPanel panel_02 = new EmployeeListPanel();
			tabbedPane.addTab("사원관리", null, panel_02, null);

			GradeEventPanel panel_03 = new GradeEventPanel();
			tabbedPane.addTab("등급&이벤트관리", null, panel_03, null);

			CarPanel panel_04 = new CarPanel();
			tabbedPane.addTab("차량관리", null, panel_04, null);

			CarManagementPanel panel_05 = new CarManagementPanel();
			panel_05.setCarPanel(panel_04);
			tabbedPane.addTab("차량옵션관리", null, panel_05, null);

			RentListPanel panel_07 = new RentListPanel();
			panel_07.setCarPanel(panel_04);
			panel_07.setCustommerListPannel(panel_01);
			
			
			AllRentPanel panel_12 = new AllRentPanel();
			
			RentPanel panel_06 = new RentPanel();
			
			panel_06.setRentListPanel(panel_07);
			//
			panel_07.setAllRentPanel(panel_12);
			//
			
			tabbedPane.addTab("대여관리", null, panel_06, null);
			tabbedPane.addTab("반납현황", null, panel_07, null);
			tabbedPane.addTab("대여현황", null, panel_12, null);

			CarChartPanel panel_9 = new CarChartPanel();
			tabbedPane.addTab("차량통계", null, panel_9, null);

			JPanel panel_10 = new CustomerChartPanel();
			tabbedPane.addTab("고객통계", null, panel_10, null);

			RentStatistics panel_11 = new RentStatistics();
			tabbedPane.addTab("대여통계", null, panel_11, null);

			tabbedPane.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					if (e.getSource() instanceof JTabbedPane) {
						JTabbedPane pane = (JTabbedPane) e.getSource();
						Component p = pane.getSelectedComponent();
						if (p instanceof AllRentPanel) {
							AllRentPanel arp = (AllRentPanel) p;
							arp.reloadList();
						}
						System.out.println(p);
					}
				}
			 });
		}

		if (!TestFrame.loginEmployee()) {
			
			CustomerStaticsPanel panel_04 = new CustomerStaticsPanel();
			CustomerAllStat panel_05 = new CustomerAllStat();
			RentPanel panel_01 = new RentPanel();
			panel_01.setCustomerStaticsPanel(panel_04);
			panel_01.setCustomerAllStat(panel_05);
			
			
			tabbedPane.addTab("차량대여", null, panel_01, null);
			tabbedPane.addTab("대여내역", null, panel_04, null);
			
			
			tabbedPane.addTab("MY", null, panel_05, null);
			
			CarPanel panel_02 = new CarPanel();
			tabbedPane.addTab("차량조회", null, panel_02, null);

			JPanel panel_03 = new CustommerUpdate();
			tabbedPane.addTab("개인정보관리", null, panel_03, null);
		}

	}

	public void setTestFrame(TestFrame testFrame) {
		this.testFrame = testFrame;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogout) {
			do_btnLogout_actionPerformed(arg0);
		}
	}

	protected void do_btnLogout_actionPerformed(ActionEvent arg0) {
		if (LoginUI.loginCusotmer == null) {// 관리자 로그인 한경우
			LoginUI.loginEmployee = null;
		} else { // 고객 로그인 한 경우
			LoginUI.loginCusotmer = null;
		}
		JOptionPane.showMessageDialog(null, "로그아웃 하셨습니다.");
		LoginUI.loginUI.setVisible(true);
		testFrame.dispose();
	}
}
