package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.yi.java_web_female.ui.car.CarPanel;
import kr.or.yi.java_web_female.ui.rent.RentPanel;
import kr.or.yi.java_web_female.ui.car.CarManagementPanel;
import kr.or.yi.java_web_female.ui.management.GradeEventPanel;
import kr.or.yi.java_web_female.ui.management.EmployeeListPanel;
import kr.or.yi.java_web_female.ui.management.CustommerListPannel;

@SuppressWarnings("serial")
public class ManagerPanel extends JPanel {
	
	
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		CustommerListPannel panel_01 = new CustommerListPannel();
		tabbedPane.addTab("고객관리", null, panel_01, null);
		
		JPanel panel_02 = new JPanel();
		tabbedPane.addTab("개인정보관리", null, panel_02, null);
		
		EmployeeListPanel panel_03 = new EmployeeListPanel();
		tabbedPane.addTab("사원관리", null, panel_03, null);
		
		GradeEventPanel panel_04 = new GradeEventPanel();
		tabbedPane.addTab("등급&이벤트관리", null, panel_04, null);
			
		CarPanel panel_05 = new CarPanel();
		tabbedPane.addTab("차량관리", null, panel_05, null);
		
		CarManagementPanel panel_06 = new CarManagementPanel();
		tabbedPane.addTab("차량옵션관리", null, panel_06, null);
		
		RentPanel panel_07 = new RentPanel();
		tabbedPane.addTab("대여관리", null, panel_07, null);
		
		JPanel panel_08 = new JPanel();
		tabbedPane.addTab("대여현황", null, panel_08, null);
		
		JPanel panel_09 = new JPanel();
		tabbedPane.addTab("반납관리", null, panel_09, null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("전체통계", null, panel_10, null);
		
		


	}

}
