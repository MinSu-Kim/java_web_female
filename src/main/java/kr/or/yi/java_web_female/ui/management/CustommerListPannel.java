package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.service.CustomUiService;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CustommerListPannel extends JPanel {
	
	private JTextField tfCusCode;
	private JTextField tfCusName;
	private JTextField tfCusId;
	private JTextField tfTel2;
	private JTextField tfTel3;
	private JTextField tfCusEmail1;
	private JTextField tfCusEmail2;
	private JTextField tfZipCode;
	private JTextField tfAddr;
	private JTextField tfEmpCode;
	private JTextField tfGradeName;
	private JTextField tfRentCnt;
	private CustomUiService service;

	public CustommerListPannel() {
		setBorder(new TitledBorder(null, "\uACE0\uAC1D\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new CustomUiService();
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelList = new JPanel();
		add(panelList);
		panelList.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panel.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblCusCode = new JLabel("고객코드");
		lblCusCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblCusCode);
		
		tfCusCode = new JTextField();
		panelInput.add(tfCusCode);
		tfCusCode.setColumns(10);
		
		JLabel lblCusName = new JLabel("고객명");
		lblCusName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblCusName);
		
		tfCusName = new JTextField();
		panelInput.add(tfCusName);
		tfCusName.setColumns(10);
		
		JLabel lblCusId = new JLabel("고객아이디");
		lblCusId.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblCusId);
		
		tfCusId = new JTextField();
		panelInput.add(tfCusId);
		tfCusId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("생년월일");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblNewLabel_3);
		
		JDateChooser birthday = new JDateChooser();
		panelInput.add(birthday);
		
		JLabel lblCusPhone = new JLabel("연락처");
		lblCusPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblCusPhone);
		
		JPanel pTel = new JPanel();
		panelInput.add(pTel);
		pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));
		
		JComboBox cmbTel1 = new JComboBox();
		pTel.add(cmbTel1);
		
		JLabel lblTel1 = new JLabel("-");
		lblTel1.setEnabled(false);
		lblTel1.setHorizontalAlignment(SwingConstants.CENTER);
		pTel.add(lblTel1);
		
		tfTel2 = new JTextField();
		pTel.add(tfTel2);
		tfTel2.setColumns(10);
		
		JLabel lblTel2 = new JLabel("-");
		lblTel2.setEnabled(false);
		lblTel2.setHorizontalAlignment(SwingConstants.CENTER);
		pTel.add(lblTel2);
		
		tfTel3 = new JTextField();
		pTel.add(tfTel3);
		tfTel3.setColumns(10);
		
		JLabel lblCusEmail = new JLabel("이메일");
		lblCusEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblCusEmail);
		
		JPanel pEmail = new JPanel();
		panelInput.add(pEmail);
		pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.X_AXIS));
		
		tfCusEmail1 = new JTextField();
		tfCusEmail1.setColumns(15);
		pEmail.add(tfCusEmail1);
		
		JLabel lblAt = new JLabel("@");
		lblAt.setHorizontalAlignment(SwingConstants.CENTER);
		pEmail.add(lblAt);
		
		tfCusEmail2 = new JTextField();
		tfCusEmail2.setEditable(false);
		tfCusEmail2.setColumns(15);
		pEmail.add(tfCusEmail2);
		
		JComboBox<String> cmbCusEmail2 = new JComboBox<String>();
		pEmail.add(cmbCusEmail2);
		
		JLabel lblAddr = new JLabel("우편번호");
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblAddr);
		
		JPanel pAddr = new JPanel();
		panelInput.add(pAddr);
		pAddr.setLayout(new BoxLayout(pAddr, BoxLayout.X_AXIS));
		
		tfZipCode = new JTextField();
		tfZipCode.setColumns(10);
		pAddr.add(tfZipCode);
		
		JButton btnSearchAddr = new JButton("우편번호 검색");
		pAddr.add(btnSearchAddr);
		
		JLabel lblAddrDetail = new JLabel("주소");
		lblAddrDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblAddrDetail);
		
		tfAddr = new JTextField();
		panelInput.add(tfAddr);
		tfAddr.setColumns(10);
		
		JLabel lblEmpCode = new JLabel("직원코드");
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEmpCode);
		
		tfEmpCode = new JTextField();
		panelInput.add(tfEmpCode);
		tfEmpCode.setColumns(10);
		
		JLabel lblLicence = new JLabel("면허종류");
		lblLicence.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblLicence);
		
		JComboBox cmbLicence = new JComboBox();
		panelInput.add(cmbLicence);
		
		JLabel lblGradeName = new JLabel("등급명");
		lblGradeName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblGradeName);
		
		tfGradeName = new JTextField();
		panelInput.add(tfGradeName);
		tfGradeName.setColumns(10);
		
		JLabel lblRentCnt = new JLabel("대여횟수");
		lblRentCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblRentCnt);
		
		tfRentCnt = new JTextField();
		panelInput.add(tfRentCnt);
		tfRentCnt.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnCusOk = new JButton("추가");
		panelBtn.add(btnCusOk);
		
		JButton btnCusCancel = new JButton("취소");
		panelBtn.add(btnCusCancel);

	}

}
