package kr.or.yi.java_web_female.chart_panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerChartPanel extends JPanel implements ActionListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private BarChartAddr panel_BarCustomer;
	private JPanel panelAllChart;
	private JPanel panelTotal;
	private JPanel panelSelectedOne;
	private JRadioButton rdbtnAddr;
	private JRadioButton rdbtnGrade;

	private JRadioButton rdbtnTotal;
	private PieChartGradeType panel_PieGrade;
	// private BarChartAddr panel_BarAddr;
	private JPanel panel;
	private JPanel panel_1;

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
		panel_BarCustomer.setBorder(new EmptyBorder(0, 10, 0, 10));

		panelAllChart.add(panel_BarCustomer);

		panel_PieGrade = new PieChartGradeType();
		panel_PieGrade.getpPieChart().setBorder(new EmptyBorder(0, 10, 0, 10));
		panelAllChart.add(panel_PieGrade);

		panel = new JPanel();
		panelAllChart.add(panel);

		panel_1 = new JPanel();
		panelAllChart.add(panel_1);

		panelSelectedOne = new JPanel();
		add(panelSelectedOne, BorderLayout.SOUTH);
		panelSelectedOne.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelRbtn = new JPanel();
		add(panelRbtn, BorderLayout.NORTH);

		rdbtnAddr = new JRadioButton("지역별 고객 인원");
		rdbtnAddr.addActionListener(this);
		buttonGroup.add(rdbtnAddr);
		panelRbtn.add(rdbtnAddr);

		rdbtnGrade = new JRadioButton("등급별  고객 인원");
		rdbtnGrade.addActionListener(this);
		buttonGroup.add(rdbtnGrade);
		panelRbtn.add(rdbtnGrade);

		rdbtnTotal = new JRadioButton("전체보기");
		rdbtnTotal.addActionListener(this);
		buttonGroup.add(rdbtnTotal);
		panelRbtn.add(rdbtnTotal);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rdbtnAddr) {
			do_rdbtnAddr_actionPerformed(arg0);
		}
		if (arg0.getSource() == rdbtnTotal) {
			do_rdbtnTotal_actionPerformed(arg0);
		}
		if (arg0.getSource() == rdbtnGrade) {
			do_rdbtnGrade_actionPerformed(arg0);
		}
	}

	protected void do_rdbtnTotal_actionPerformed(ActionEvent arg0) {
		// 전체
		panelTotal.setVisible(true);
		panelSelectedOne.setVisible(false);
		panelTotal.add(panelAllChart, BorderLayout.CENTER);
		add(panelTotal, BorderLayout.CENTER);
		add(panelSelectedOne, BorderLayout.SOUTH);
		panel_PieGrade.getpPieChart().getPieChart().setPrefSize(440, 250);
		panel_BarCustomer.getpBarChart().getBarChart().setPrefSize(440, 250);
		
		panelAllChart.add(panel_PieGrade);
		panelAllChart.add(panel_BarCustomer);
		panelAllChart.add(panel);
		panelAllChart.add(panel_1);

	}

	protected void do_rdbtnGrade_actionPerformed(ActionEvent arg0) {
		// 등급별
		addReplaceChartPanel(panel_PieGrade);
		panel_PieGrade.getpPieChart().getPieChart().setPrefSize(700, 450);
	}

	protected void do_rdbtnAddr_actionPerformed(ActionEvent arg0) {
		// 주소
		addReplaceChartPanel(panel_BarCustomer);
		panel_BarCustomer.getpBarChart().getBarChart().setPrefSize(700, 450);
	}

	private void addReplaceChartPanel(JPanel panel) {
		panelTotal.setVisible(false);
		panelSelectedOne.setVisible(true);
		panelSelectedOne.add(panelAllChart, BorderLayout.CENTER);
		add(panelSelectedOne, BorderLayout.CENTER);
		panelTotal.add(panelAllChart, BorderLayout.SOUTH);
		add(panelTotal, BorderLayout.SOUTH);

		panelSelectedOne.removeAll();
		panelSelectedOne.add(panel);
	}
}
