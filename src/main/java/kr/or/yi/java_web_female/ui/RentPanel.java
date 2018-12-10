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
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import java.awt.Color;

public class RentPanel extends JPanel {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfName;

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
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblName);
		
		JPanel pCustomer = new JPanel();
		contentPanel.add(pCustomer);
		pCustomer.setLayout(new GridLayout(0, 2, 10, 0));
		
		tfName = new JTextField();
		tfName.setColumns(10);
		pCustomer.add(tfName);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pCustomer.add(btnSearch);
		
		JPanel pStartDate = new JPanel();
		contentPanel.add(pStartDate);
		pStartDate.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblStartDate = new JLabel("대여일자");
		lblStartDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		pStartDate.add(lblStartDate);
		
		JDateChooser dateChooser = new JDateChooser();
		pStartDate.add(dateChooser);
		
		JPanel pStartTime = new JPanel();
		contentPanel.add(pStartTime);
		pStartTime.setLayout(new BoxLayout(pStartTime, BoxLayout.X_AXIS));
		
		JLabel lblStartTime = new JLabel("대여시간");
		lblStartTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pStartTime.add(lblStartTime);
		
		JSpinner spStartHour = new JSpinner();
		spStartHour.setModel(new SpinnerNumberModel(12, 1, 24, 1));
		pStartTime.add(spStartHour);
		
		JLabel lblSH = new JLabel("시");
		lblSH.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pStartTime.add(lblSH);
		
		JSpinner spStartMinutes = new JSpinner();
		spStartMinutes.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		pStartTime.add(spStartMinutes);
		
		JLabel lblSM = new JLabel("분");
		lblSM.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pStartTime.add(lblSM);
		
		JPanel pEndDate = new JPanel();
		contentPanel.add(pEndDate);
		pEndDate.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblEndDate = new JLabel("반납일자");
		lblEndDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		pEndDate.add(lblEndDate);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		pEndDate.add(dateChooser_1);
		
		JPanel pEndTime = new JPanel();
		contentPanel.add(pEndTime);
		pEndTime.setLayout(new BoxLayout(pEndTime, BoxLayout.X_AXIS));
		
		JLabel label_5 = new JLabel("반납시간");
		label_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(label_5);
		
		JSpinner spEndHour = new JSpinner();
		spEndHour.setModel(new SpinnerNumberModel(12, 1, 24, 1));
		pEndTime.add(spEndHour);
		
		JLabel lblEH = new JLabel("시");
		lblEH.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEH);
		
		JSpinner spEndMinutes = new JSpinner();
		spEndMinutes.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		pEndTime.add(spEndMinutes);
		
		JLabel lblEM = new JLabel("분");
		lblEM.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEM);
		
		JLabel lblInsurance = new JLabel("자차손해 면책 제도");
		lblInsurance.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblInsurance.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblInsurance);
		
		JPanel pGender = new JPanel();
		contentPanel.add(pGender);
		pGender.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rbNotReg = new JRadioButton("가입안함");
		rbNotReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rbNotReg.setHorizontalAlignment(SwingConstants.CENTER);
		pGender.add(rbNotReg);
		
		JRadioButton rbReg = new JRadioButton("일반자차");
		rbReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rbReg.setHorizontalAlignment(SwingConstants.CENTER);
		pGender.add(rbReg);
		
		JLabel lblTotalPrice = new JLabel("최종 요금");
		lblTotalPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblTotalPrice);
		
		JLabel lblPrice = new JLabel("New label");
		lblPrice.setForeground(Color.RED);
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lblPrice);
		
		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnRent = new JButton("대여");
		btnRent.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnRent);
		
		JButton btnClose = new JButton("닫기");
		btnClose.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnClose);
	}
	
}
