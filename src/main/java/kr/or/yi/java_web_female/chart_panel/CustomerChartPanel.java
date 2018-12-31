package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CustomerChartPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public CustomerChartPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTotal = new JPanel();
		add(panelTotal, BorderLayout.CENTER);
		panelTotal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTotal_1 = new JPanel();
		panelTotal.add(panelTotal_1, BorderLayout.CENTER);
		panelTotal_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelAllChart = new JPanel();
		panelTotal_1.add(panelAllChart);
		panelAllChart.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panelAllChart.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panelAllChart.add(panel_2);
		
		JPanel panelSelectedOne = new JPanel();
		add(panelSelectedOne, BorderLayout.SOUTH);
		
		JPanel panelRbtn = new JPanel();
		add(panelRbtn, BorderLayout.NORTH);
		
		JRadioButton rdbtnAddr = new JRadioButton("지역별 고객 인원");
		buttonGroup.add(rdbtnAddr);
		panelRbtn.add(rdbtnAddr);
		
		JRadioButton rdbtnGrade = new JRadioButton("등급별  고객 인원");
		buttonGroup.add(rdbtnGrade);
		panelRbtn.add(rdbtnGrade);
		
		JRadioButton rdbtnTotal = new JRadioButton("전체보기");
		buttonGroup.add(rdbtnTotal);
		panelRbtn.add(rdbtnTotal);

	}

}
