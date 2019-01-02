package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.chart_panel.RentStatisticsBarPanel;
import kr.or.yi.java_web_female.chart_panel.RentStatisticsLinePanel;
import kr.or.yi.java_web_female.chart_panel.RentStatisticsPiePanel;

public class RentStatistics extends JPanel implements ActionListener{
	private JRadioButton rdbtnLine;
	private JRadioButton rdbtnPie;
	private JRadioButton rdbtnAll;
	private JPanel panelFour;
	private JPanel panelSelectedOne;
	private JPanel panelTotal;
	private RentStatisticsLinePanel linePanel;
	private RentStatisticsPiePanel piePanel;
	private RentStatisticsBarPanel barPanel;
	private JPanel panel_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnBar;

	/**
	 * Create the panel.
	 */
	public RentStatistics() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		rdbtnLine = new JRadioButton("월별 차량 대여 횟수");
		buttonGroup.add(rdbtnLine);
		rdbtnLine.addActionListener(this);
		panel.add(rdbtnLine);
		
		rdbtnBar = new JRadioButton("브랜드별 매출액");
		buttonGroup.add(rdbtnBar);
		rdbtnBar.addActionListener(this);
		panel.add(rdbtnBar);
		
		rdbtnPie = new JRadioButton("대여 시 옵션 선호도");
		buttonGroup.add(rdbtnPie);
		rdbtnPie.addActionListener(this);
		panel.add(rdbtnPie);
		
		rdbtnAll = new JRadioButton("전체보기");
		buttonGroup.add(rdbtnAll);
		rdbtnAll.addActionListener(this);
		panel.add(rdbtnAll);
		
		panelSelectedOne = new JPanel();
		add(panelSelectedOne, BorderLayout.SOUTH);
		
		panelSelectedOne.setVisible(false);
		
		panelTotal = new JPanel();
		panelTotal.setBorder(new EmptyBorder(15, 15, 15, 15));
		add(panelTotal, BorderLayout.CENTER);
		panelTotal.setLayout(new BorderLayout(0, 0));
		
		panelFour = new JPanel();
		panelTotal.add(panelFour);
		panelFour.setLayout(new GridLayout(0, 2, 0, 0));
		
		linePanel = new RentStatisticsLinePanel();
		linePanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelFour.add(linePanel);
		
		piePanel = new RentStatisticsPiePanel();
		piePanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelFour.add(piePanel);
		
		barPanel = new RentStatisticsBarPanel();
		piePanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelFour.add(barPanel);
		
		panel_3 = new JPanel();
		panelFour.add(panel_3);
		
		

	}

	
	private void addReplaceChartPanel(JPanel panel) {
		panelTotal.setVisible(false);
		panelSelectedOne.setVisible(true);
		add(panelSelectedOne, BorderLayout.CENTER);
		panelTotal.add(panelFour, BorderLayout.SOUTH);
		add(panelTotal, BorderLayout.SOUTH);

		panelSelectedOne.removeAll();
		panelSelectedOne.add(panel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtnBar) {
			do_rdbtnBar_actionPerformed(e);
		}
		if (e.getSource() == rdbtnAll) {
			do_rdbtnAll_actionPerformed(e);
		}
		if (e.getSource() == rdbtnLine) {
			do_rdbtnLine_actionPerformed(e);
		}
		if (e.getSource() == rdbtnPie) {
			do_rdbtnPie_actionPerformed(e);
		}
	}
	
	protected void do_rdbtnPie_actionPerformed(ActionEvent e) {
		addReplaceChartPanel(piePanel);
		piePanel.getRentCarOptionsPieChart().getPieChart().setPrefSize(700, 450);
	}
	
	protected void do_rdbtnLine_actionPerformed(ActionEvent e) {
		addReplaceChartPanel(linePanel);
		linePanel.getRentLineChart().getLineChart().setPrefSize(700, 450);
	}
	
	protected void do_rdbtnBar_actionPerformed(ActionEvent e) {
		addReplaceChartPanel(barPanel);
		barPanel.getpBarChart().getBarChart().setPrefSize(700, 450);
	}
	
	protected void do_rdbtnAll_actionPerformed(ActionEvent e) {
		// 전체보기 선택
		panelTotal.setVisible(true);
		panelSelectedOne.setVisible(false);
		panelTotal.add(panelFour, BorderLayout.CENTER);
		add(panelFour, BorderLayout.CENTER);	
		add(panelSelectedOne, BorderLayout.SOUTH);

		linePanel.getRentLineChart().getLineChart().setPrefSize(440, 250);
		piePanel.getRentCarOptionsPieChart().getPieChart().setPrefSize(440, 250);
		barPanel.getpBarChart().getBarChart().setPrefSize(440, 250);

		/*panelTotal.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelFour.setBorder(new EmptyBorder(0, 15, 0, 15));*/

		// 네개 다시 붙여넣기
		panelFour.add(linePanel);
		panelFour.add(piePanel);
		panelFour.add(barPanel);
		panelFour.add(panel_3);
		panelTotal.add(panelFour);
	}
	
}
