package kr.or.yi.java_web_female.chart_frame;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.java_web_female.InitScene;
import kr.or.yi.java_web_female.chart_panel.PanelBarChart;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.service.CarModelService;

@SuppressWarnings("serial")
public class ChartMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private PanelBarChart pBarChart;
	private JButton btnDel;
	private JButton btnUpdate;
	private JButton btnAllClear;
	private JButton btnClearAfterAdd;
	private JButton btnLineAdd;
	private CarModelService service;

	public ChartMain() {
		service = new CarModelService();
		initComponents();
	}
	
	private void initComponents() {
		setTitle("통계");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 520, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		//바차트 패널 붙임
		pBarChart = new PanelBarChart();
		contentPane.add(pBarChart);
		
		
		Platform.runLater(() -> initFX(pBarChart));

		
		JPanel pBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(pBtn);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new BtnAddActionListener());
		pBtn.add(btnAdd);
		
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pBtn.add(btnDel);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtn.add(btnUpdate);
		
		btnAllClear = new JButton("전체삭제");
		btnAllClear.addActionListener(this);
		pBtn.add(btnAllClear);
		
		btnClearAfterAdd = new JButton("삭제후추가");
		btnClearAfterAdd.addActionListener(this);
		pBtn.add(btnClearAfterAdd);
		
		btnLineAdd = new JButton("라인항목추가");
		btnLineAdd.addActionListener(this);
		pBtn.add(btnLineAdd);
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}


	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Platform.runLater(() -> {
				String nextCode = service.nextCarCode();
				int max = (Integer.parseInt(nextCode.substring(1, 3)));
				String code = String.format("V%03d", max);
				CarModel model = new  CarModel();
				model.setCarCode(code);
				model = service.selectCarModelByNo(model);
				System.out.println(model);
				pBarChart.addChartData(new CarModel(model.getCarCode(), model.getName(), model.getRentCnt()));
			});
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnClearAfterAdd) {
			do_btnClearAfterAdd_actionPerformed(e);
		}
		if (e.getSource() == btnAllClear) {
			do_btnAllClear_actionPerformed(e);
		}
		if (e.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(e);
		}
		if (e.getSource() == btnDel) {
			do_btnDel_actionPerformed(e);
		}
	}
	
	protected void do_btnDel_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.delChartData(new CarModel("V003", "벤틀리", 25));
		});
	}
	
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.updateChartData(new CarModel("V003", "벤틀리", 25));
		});
	}
	
	protected void do_btnAllClear_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.deleteAllData();
		});
	}
	
	protected void do_btnClearAfterAdd_actionPerformed(ActionEvent e) {
		Platform.runLater(() -> {
			pBarChart.deleteAllData();
			pBarChart.addAllChartData();
		});
	}
	

}
