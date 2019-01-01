package kr.or.yi.java_web_female.chart_panel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class CarChartPanel extends JPanel implements ActionListener{
	//라디오버튼
	private JRadioButton rdbtnTotal;
	private JRadioButton rdbtnRentCount;
	private JRadioButton rdbtnCarType;
	private JRadioButton rdbtnBrand;
	private JRadioButton rdbtnCarModel;
	//패널
	private JPanel panelChart;
	private JPanel panelSelectedOne;
	private JPanel panelTotal;
	//차트4가지
	private BarChartCarModel panel_BarChart;
	private PieChartCarType panel_PieCarType;
	private PieChartBrand panel_PieBrand;
	private LineChartRentCount panel_LineRentCount;

	/**
	 * Create the panel.
	 */
	public CarChartPanel() {
		setLayout(new BorderLayout(0, 0));
		
		panelTotal = new JPanel();
		panelTotal.setBorder(new EmptyBorder(15, 15, 15, 15));
		add(panelTotal, BorderLayout.CENTER);
		panelTotal.setLayout(new BorderLayout(0, 0));
		
		panelChart = new JPanel();
		panelTotal.add(panelChart, BorderLayout.CENTER);
		panelChart.setLayout(new GridLayout(0, 2, 15, 15));
		
		panel_BarChart = new BarChartCarModel();
		panel_BarChart.getpBarChart().setBorder(new EmptyBorder(0, 0, 0, 20));
		panelChart.add(panel_BarChart);
		
		panel_PieCarType = new PieChartCarType();
		panel_PieCarType.getpPieChart().setBorder(new EmptyBorder(0, 0, 0, 20));
		panelChart.add(panel_PieCarType);
		
		panel_PieBrand = new PieChartBrand();
		panel_PieBrand.getpPieChart().setBorder(new EmptyBorder(0, 0, 0, 20));
		panelChart.add(panel_PieBrand);
		
		panel_LineRentCount = new LineChartRentCount();
		panel_LineRentCount.getpLineChart().setBorder(new EmptyBorder(0, 0, 0, 20));
		panelChart.add(panel_LineRentCount);
		
		panelSelectedOne = new JPanel();
		add(panelSelectedOne, BorderLayout.SOUTH);
		panelSelectedOne.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelBtn = new JPanel();
		add(panelBtn, BorderLayout.NORTH);
		
		ButtonGroup group = new ButtonGroup();
		
		rdbtnCarModel = new JRadioButton("차량별 대여회수");
		rdbtnCarModel.addActionListener(this);
		group.add(rdbtnCarModel);
		panelBtn.add(rdbtnCarModel);
		
		rdbtnCarType = new JRadioButton("차종별 보유개수");
		rdbtnCarType.addActionListener(this);
		group.add(rdbtnCarType);
		panelBtn.add(rdbtnCarType);
		
		rdbtnBrand = new JRadioButton("브랜드별 보유개수");
		rdbtnBrand.addActionListener(this);
		group.add(rdbtnBrand);
		panelBtn.add(rdbtnBrand);
		
		rdbtnRentCount = new JRadioButton("차종별 월 렌트 수");
		rdbtnRentCount.addActionListener(this);
		group.add(rdbtnRentCount);
		panelBtn.add(rdbtnRentCount);
		
		rdbtnTotal = new JRadioButton("전체보기");
		rdbtnTotal.addActionListener(this);
		group.add(rdbtnTotal);
		panelBtn.add(rdbtnTotal);
		

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtnCarModel) {
			do_rdbtnCarModel_actionPerformed(e);
		}
		if (e.getSource() == rdbtnBrand) {
			do_rdbtnBrand_actionPerformed(e);
		}
		if (e.getSource() == rdbtnCarType) {
			do_rdbtnCarType_actionPerformed(e);
		}
		if (e.getSource() == rdbtnRentCount) {
			do_rdbtnRentCount_actionPerformed(e);
		}
		if (e.getSource() == rdbtnTotal) {
			do_rdbtnTotal_actionPerformed(e);
		}
		revalidate();
	}
	
	protected void do_rdbtnTotal_actionPerformed(ActionEvent e) {
		//전체보기 선택
		panelTotal.setVisible(true);
		panelSelectedOne.setVisible(false);
		panelTotal.add(panelChart, BorderLayout.CENTER);
		add(panelTotal, BorderLayout.CENTER);
		add(panelSelectedOne, BorderLayout.SOUTH);
		
		panel_BarChart.getpBarChart().getBarChart().setPrefSize(440,230);
		panel_PieCarType.getpPieChart().getPieChart().setPrefSize(440, 250);
		panel_PieBrand.getpPieChart().getPieChart().setPrefSize(440, 250);
		panel_LineRentCount.getpLineChart().getLineChart().setPrefSize(440, 250);
		//네개 다시 붙여넣기
		panelChart.add(panel_BarChart);
		panelChart.add(panel_PieCarType);
		panelChart.add(panel_PieBrand);
		panelChart.add(panel_LineRentCount);
	}
	
	protected void do_rdbtnRentCount_actionPerformed(ActionEvent e) {
		//월별 차종별 렌트 횟수 선택
		addReplaceChartPanel(panel_LineRentCount);
		panel_LineRentCount.getpLineChart().getLineChart().setPrefSize(700,450);
	}
	
	protected void do_rdbtnCarType_actionPerformed(ActionEvent e) {
		//차종별 보유차량 수 선택
		addReplaceChartPanel(panel_PieCarType);
		panel_PieCarType.getpPieChart().getPieChart().setPrefSize(700,450);
	}
	protected void do_rdbtnBrand_actionPerformed(ActionEvent e) {
		//브랜드별 보유차량 수 선택
		addReplaceChartPanel(panel_PieBrand);
		panel_PieBrand.getpPieChart().getPieChart().setPrefSize(700,450);
	}
	
	protected void do_rdbtnCarModel_actionPerformed(ActionEvent e) {
		//모델별 렌트 횟수 선택
		addReplaceChartPanel(panel_BarChart);
		panel_BarChart.getpBarChart().getBarChart().setPrefSize(700,450);
	}

	private void addReplaceChartPanel(JPanel panel) {
		panelTotal.setVisible(false);
		panelSelectedOne.setVisible(true);
		panelSelectedOne.add(panelChart, BorderLayout.CENTER);
		add(panelSelectedOne, BorderLayout.CENTER);
		panelTotal.add(panelChart, BorderLayout.SOUTH);
		add(panelTotal, BorderLayout.SOUTH);

		panelSelectedOne.removeAll();
		panelSelectedOne.add(panel);
	}

}
