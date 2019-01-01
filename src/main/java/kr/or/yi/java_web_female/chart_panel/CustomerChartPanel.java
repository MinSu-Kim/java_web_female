package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;

public class CustomerChartPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_BarCustomer;
	private JPanel panelAllChart;
	private JPanel panelTotal;
	private JPanel panelSelectedOne;
	private JRadioButton rdbtnAddr;
	private JRadioButton rdbtnGrade;
	
	private JRadioButton rdbtnTotal;
	private PieChartGradeType panel_PieGrade;

	/**
	 * Create the panel.
	 */
	public CustomerChartPanel() {
		setLayout(new BorderLayout(0, 0));

		panelTotal = new JPanel();
		panelTotal.setBorder(new EmptyBorder(15, 15, 15, 15));
		add(panelTotal);
		panelTotal.setLayout(new BorderLayout(0, 0));

		panelAllChart = new JPanel();
		panelTotal.add(panelAllChart, BorderLayout.CENTER);
		panelAllChart.setLayout(new GridLayout(0, 2, 0, 0));

		panel_BarCustomer = new BarChartAddr();

		panelAllChart.add(panel_BarCustomer);
		
		panel_PieGrade = new PieChartGradeType();
		panelAllChart.add(panel_PieGrade);


		panelSelectedOne = new JPanel();
		add(panelSelectedOne, BorderLayout.SOUTH);
		panelSelectedOne.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelRbtn = new JPanel();
		add(panelRbtn, BorderLayout.NORTH);

		rdbtnAddr = new JRadioButton("지역별 고객 인원");
		buttonGroup.add(rdbtnAddr);
		panelRbtn.add(rdbtnAddr);

		rdbtnGrade = new JRadioButton("등급별  고객 인원");
		buttonGroup.add(rdbtnGrade);
		panelRbtn.add(rdbtnGrade);

		rdbtnTotal = new JRadioButton("전체보기");
		buttonGroup.add(rdbtnTotal);
		panelRbtn.add(rdbtnTotal);

	}

}
