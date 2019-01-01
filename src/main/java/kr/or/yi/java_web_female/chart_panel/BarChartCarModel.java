
package kr.or.yi.java_web_female.chart_panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BarChartCarModel extends JPanel implements ActionListener{
	
	private JPanel contentPane;
	private DataBarChartCarModel pBarChart;

	public DataBarChartCarModel getpBarChart() {
		return pBarChart;
	}
	//차종별 라디오버튼
	private JRadioButton rdbtnS1;
	private JRadioButton rdbtnS2;
	private JRadioButton rdbtnS3;
	private JRadioButton rdbtnS4;
	private JRadioButton rdbtnS5;
	private JRadioButton rdbtnS6;
	private JRadioButton btnReset;
	private JPanel panelRbtn;
	/**
	 * Create the panel.
	 */
	public BarChartCarModel() {
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
/*		contentPane = new JPanel();
		add(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));*/
		
		//바차트 패널 붙임
		pBarChart = new DataBarChartCarModel();
//		contentPane.add(pBarChart);
		add(pBarChart);
		
		Platform.runLater(() -> initFX(pBarChart));
		
		//라디오버튼
		
		panelRbtn = new JPanel();
		panelRbtn.setLayout(new GridLayout(0, 7, 0, 0));
				
		ButtonGroup group = new ButtonGroup();
				
		rdbtnS1 = new JRadioButton("경형");
		rdbtnS1.addActionListener(this);
		group.add(rdbtnS1);
		panelRbtn.add(rdbtnS1);
				
		rdbtnS2 = new JRadioButton("소형");
		rdbtnS2.addActionListener(this);
		group.add(rdbtnS2);
		panelRbtn.add(rdbtnS2);
				
		rdbtnS3 = new JRadioButton("중형");
		rdbtnS3.addActionListener(this);
		group.add(rdbtnS3);
		panelRbtn.add(rdbtnS3);
				
		rdbtnS4 = new JRadioButton("대형");
		rdbtnS4.addActionListener(this);
		group.add(rdbtnS4);
		panelRbtn.add(rdbtnS4);
				
		rdbtnS5 = new JRadioButton("승합");
		rdbtnS5.addActionListener(this);
		group.add(rdbtnS5);
		panelRbtn.add(rdbtnS5);
				
		rdbtnS6 = new JRadioButton("suv");
		rdbtnS6.addActionListener(this);
		group.add(rdbtnS6);
		panelRbtn.add(rdbtnS6);
		
		btnReset = new JRadioButton("전체");
		btnReset.addActionListener(this);
		group.add(btnReset);
		panelRbtn.add(btnReset);
		
//		contentPane.add(panelRbtn, BorderLayout.SOUTH);
		add(panelRbtn, BorderLayout.SOUTH);
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtnS5) {
			do_rdbtnS5_actionPerformed(e);
		}
		if (e.getSource() == rdbtnS6) {
			do_rdbtnS6_actionPerformed(e);
		}
		if (e.getSource() == rdbtnS4) {
			do_rdbtnS4_actionPerformed(e);
		}
		if (e.getSource() == rdbtnS2) {
			do_rdbtnS2_actionPerformed(e);
		}
		if (e.getSource() == rdbtnS3) {
			do_rdbtnS3_actionPerformed(e);
		}
		if (e.getSource() == rdbtnS1) {
			do_rdbtnS1_actionPerformed(e);
		}
		if (e.getSource() == btnReset) {
			do_btnReset_actionPerformed(e);
		}
	}
	private void do_btnReset_actionPerformed(ActionEvent e) {
		// 초기화버튼 눌렀을때 전체통계
		Platform.runLater(() -> {
			pBarChart.getBarChart().getData().clear();
			Map<String, String> maps = new HashMap<>();
			pBarChart.getChartData(maps);
			pBarChart.getBarChart().setData(pBarChart.getChartData(maps));
		});
		
	}
	protected void do_rdbtnS1_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.getBarChart().getData().clear();
			Map<String, String> maps = new HashMap<>();
			maps.put("cartype", "S1");
			pBarChart.getBarChart().setData(pBarChart.getChartData(maps));
		});
	}
	protected void do_rdbtnS3_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.getBarChart().getData().clear();
			Map<String, String> maps = new HashMap<>();
			maps.put("cartype", "S3");
			pBarChart.getBarChart().setData(pBarChart.getChartData(maps));
		});
	}
	protected void do_rdbtnS2_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.getBarChart().getData().clear();
			Map<String, String> maps = new HashMap<>();
			maps.put("cartype", "S2");
			pBarChart.getBarChart().setData(pBarChart.getChartData(maps));
		});
	}
	protected void do_rdbtnS4_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.getBarChart().getData().clear();
			Map<String, String> maps = new HashMap<>();
			maps.put("cartype", "S4");
			pBarChart.getBarChart().setData(pBarChart.getChartData(maps));
		});
	}
	protected void do_rdbtnS6_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.getBarChart().getData().clear();
			Map<String, String> maps = new HashMap<>();
			maps.put("cartype", "S6");
			pBarChart.getBarChart().setData(pBarChart.getChartData(maps));
		});
	}
	protected void do_rdbtnS5_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.getBarChart().getData().clear();
			Map<String, String> maps = new HashMap<>();
			maps.put("cartype", "S5");
			pBarChart.getBarChart().setData(pBarChart.getChartData(maps));
		});
	}
	
	public void isRadioBtns(boolean isVisible) {
		this.panelRbtn.setVisible(isVisible);
	}
}
