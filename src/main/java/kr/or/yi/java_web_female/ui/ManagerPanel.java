package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.yi.java_web_female.ui.car.CarPanel;
import kr.or.yi.java_web_female.ui.rent.RentPanel;
import kr.or.yi.java_web_female.ui.car.CarManagementPanel;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		tabbedPane.addTab("고객관리", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		tabbedPane.addTab("개인정보관리", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setToolTipText("");
		tabbedPane.addTab("사원관리", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("");
		tabbedPane.addTab("등급관리", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setToolTipText("");
		tabbedPane.addTab("이벤트관리", null, panel_5, null);
		
		CarPanel panel_6 = new CarPanel();
		tabbedPane.addTab("차량관리", null, panel_6, null);
		
		CarManagementPanel panel_7 = new CarManagementPanel();
		tabbedPane.addTab("차량옵션관리", null, panel_7, null);
		
		RentPanel panel_8 = new RentPanel();
		tabbedPane.addTab("대여관리", null, panel_8, null);
		
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("대여현황", null, panel_9, null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("반납관리", null, panel_10, null);
		
		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("전체통계", null, panel_11, null);
		
		


	}

}
