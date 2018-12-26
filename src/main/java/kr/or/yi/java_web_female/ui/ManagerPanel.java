package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.yi.java_web_female.ui.car.CarPanel;
import kr.or.yi.java_web_female.ui.rent.RentListPanel;
import kr.or.yi.java_web_female.ui.rent.RentPanel;
import kr.or.yi.java_web_female.TestFrame;
import kr.or.yi.java_web_female.chart_frame.ChartTotalPanel;
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
		

		if(TestFrame.loginEmployee()) {
			
			CustommerListPannel panel_01 = new CustommerListPannel();
			tabbedPane.addTab("고객관리", null, panel_01, null);
			
			EmployeeListPanel panel_02 = new EmployeeListPanel();
			tabbedPane.addTab("사원관리", null, panel_02, null);
			
			GradeEventPanel panel_03 = new GradeEventPanel();
			tabbedPane.addTab("등급&이벤트관리", null, panel_03, null);
				
			CarPanel panel_04 = new CarPanel();
			tabbedPane.addTab("차량관리", null, panel_04, null);
			
			CarManagementPanel panel_05 = new CarManagementPanel();
			tabbedPane.addTab("차량옵션관리", null, panel_05, null);

			RentListPanel panel_07 = new RentListPanel();
			RentPanel panel_06 = new RentPanel();
			panel_06.setRentListPanel(panel_07);
			tabbedPane.addTab("대여관리", null, panel_06, null);
			
			
			tabbedPane.addTab("대여현황", null, panel_07, null);
			
			ChartTotalPanel panel_9 = new ChartTotalPanel();
			tabbedPane.addTab("전체통계", null, panel_9, null);

		}
		
		
		if(!TestFrame.loginEmployee()) {
			
			RentPanel panel_01 = new RentPanel();
			tabbedPane.addTab("대여관리", null, panel_01, null);

			JPanel panel_02 = new CustommerListPannel();
			tabbedPane.addTab("개인정보관리", null, panel_02, null);
		}
		
		


	}

}
