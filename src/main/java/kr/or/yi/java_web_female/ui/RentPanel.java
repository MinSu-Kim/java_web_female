package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.service.RentUIService;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class RentPanel extends JPanel implements ActionListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tfName;
	private JButton btnSearch;
	private CustomerSearchFrame cf;	//고객확인프레임
	private RentUIService service;
	private Customer rentCustomer;
	private JRadioButton rbNotReg;
	private JRadioButton rbReg;
	
	public RentPanel() {
		service = new RentUIService();
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
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
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
		
		JPanel pInsurance = new JPanel();
		contentPanel.add(pInsurance);
		pInsurance.setLayout(new GridLayout(0, 2, 0, 0));
		
		rbNotReg = new JRadioButton("가입안함");
		rbNotReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rbNotReg.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rbNotReg);
		pInsurance.add(rbNotReg);
		
		rbReg = new JRadioButton("일반자차");
		rbReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rbReg.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rbReg);
		pInsurance.add(rbReg);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("카시트");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("블랙박스");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(chckbxNewCheckBox_1);
		
		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("선루프");
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("운전기사");
		chckbxNewCheckBox_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(chckbxNewCheckBox_4);
		
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
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}
	
	//검색버튼
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		if(cf == null) {
			Customer customer = new Customer();
			customer.setName(tfName.getText().trim());
			try {
				List<Customer> cList = service.selectCustomer(customer);
				if(cList.size() > 1) {
					cf = new CustomerSearchFrame();
					cf.setRentPanel(this);
					cf.setcList(cList);
					cf.setVisible(true);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void setRentCustomer(Customer rentCustomer) {
		this.rentCustomer = rentCustomer;
		JOptionPane.showMessageDialog(null, "선택된 고객 " + rentCustomer);
	}
}
