package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RentPanel extends JPanel {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfName;
	private JTextField tfTotalPrice;

	/**
	 * Create the panel.
	 */
	public RentPanel() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("차량 대여");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titlePanel.add(lblTitle);
		
		ComboPanel contentPanel = new ComboPanel();
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblName = new JLabel("고객명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblName);
		
		JPanel pCustomer = new JPanel();
		contentPanel.add(pCustomer);
		pCustomer.setLayout(new GridLayout(0, 2, 10, 0));
		
		tfName = new JTextField();
		tfName.setColumns(10);
		pCustomer.add(tfName);
		
		JButton btnSearch = new JButton("검색");
		pCustomer.add(btnSearch);
		
		JPanel pStartDate = new JPanel();
		contentPanel.add(pStartDate);
		pStartDate.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblStartDate = new JLabel("대여일자");
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		pStartDate.add(lblStartDate);
		
		JPanel panel_3 = new JPanel();
		pStartDate.add(panel_3);
		
		JPanel pStartTime = new JPanel();
		contentPanel.add(pStartTime);
		pStartTime.setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel lblStartTime = new JLabel("대여시간");
		pStartTime.add(lblStartTime);
		
		JSpinner spStartHour = new JSpinner();
		pStartTime.add(spStartHour);
		
		JSpinner spStartMinutes = new JSpinner();
		pStartTime.add(spStartMinutes);
		
		JPanel pEndDate = new JPanel();
		contentPanel.add(pEndDate);
		pEndDate.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblEndDate = new JLabel("반납일자");
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		pEndDate.add(lblEndDate);
		
		JPanel panel_6 = new JPanel();
		pEndDate.add(panel_6);
		
		JPanel pEndTime = new JPanel();
		contentPanel.add(pEndTime);
		pEndTime.setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel label_5 = new JLabel("반납시간");
		pEndTime.add(label_5);
		
		JSpinner spEndHour = new JSpinner();
		pEndTime.add(spEndHour);
		
		JSpinner spEndMinutes = new JSpinner();
		pEndTime.add(spEndMinutes);
		
		JLabel lblInsurance = new JLabel("자차손해 면책 제도");
		lblInsurance.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblInsurance);
		
		JPanel pGender = new JPanel();
		contentPanel.add(pGender);
		pGender.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rbNotReg = new JRadioButton("가입안함");
		rbNotReg.setHorizontalAlignment(SwingConstants.CENTER);
		pGender.add(rbNotReg);
		
		JRadioButton rbReg = new JRadioButton("일반자차");
		rbReg.setHorizontalAlignment(SwingConstants.CENTER);
		pGender.add(rbReg);
		
		JLabel lblTotalPrice = new JLabel("최종 요금");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblTotalPrice);
		
		tfTotalPrice = new JTextField();
		tfTotalPrice.setColumns(10);
		contentPanel.add(tfTotalPrice);
		
		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnRent = new JButton("대여");
		pBtn.add(btnRent);
		
		JButton btnClose = new JButton("닫기");
		pBtn.add(btnClose);
	}
	
}
