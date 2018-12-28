package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.yi.java_web_female.ui.car.CarPanel;
import kr.or.yi.java_web_female.ui.rent.RentListPanel;
import kr.or.yi.java_web_female.ui.rent.RentPanel;
import kr.or.yi.java_web_female.TestFrame;
import kr.or.yi.java_web_female.chart_panel.BarChartCarModel;
import kr.or.yi.java_web_female.chart_panel.PieChartCarType;
import kr.or.yi.java_web_female.chart_panel.CarChartPanel;
import kr.or.yi.java_web_female.ui.car.CarManagementPanel;
import kr.or.yi.java_web_female.ui.management.GradeEventPanel;
import kr.or.yi.java_web_female.ui.management.EmployeeListPanel;
import kr.or.yi.java_web_female.ui.management.CustommerListPannel;
import kr.or.yi.java_web_female.ui.management.CustommerUpdate;

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
			
			
			tabbedPane.addTab("반납현황", null, panel_07, null);
			
			CarChartPanel panel_9 = new CarChartPanel();
			tabbedPane.addTab("차량통계", null, panel_9, null);
			
			JPanel panel_10 = new JPanel();
			tabbedPane.addTab("고객통계", null, panel_10, null);
			
			JPanel panel_11 = new JPanel();
			tabbedPane.addTab("렌트통계", null, panel_11, null);

		}
		
		
		if(!TestFrame.loginEmployee()) {
			
			RentPanel panel_01 = new RentPanel();
			tabbedPane.addTab("대여관리", null, panel_01, null);
			
			CarPanel panel_02 = new CarPanel();
			tabbedPane.addTab("보유차량", null, panel_02, null);

			JPanel panel_03 = new CustommerUpdate();
			tabbedPane.addTab("개인정보관리", null, panel_03, null);
		}
		
		


	}

}
