package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.service.CustomUiService;
import kr.or.yi.java_web_female.ui.join.MyDocumentListener;
import kr.or.yi.java_web_female.ui.join.SearchPostUI;
import kr.or.yi.java_web_female.ui.list.CustomerList;
import kr.or.yi.java_web_female.ui.login.LoginUI;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Dimension;

public class CustommerUpdate extends JPanel implements ActionListener {
	private List<Customer> list;
	private JTextField tfName;
	private JTextField tfId;
	private JTextField tfZipcode;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfDomain;
	private JTextField tfTel2;
	private JTextField tfTel3;
	private JComboBox<String> cmbDomain;
	private JComboBox<String> cmbTel;
	private CustomerList panelList;
	private CustomUiService service;
	private JDateChooser dateChooser;
	private JPasswordField pwfNowPw;
	private JPasswordField pwfNewPw;
	private JPasswordField pwfConfirmPw;
	private JTextField tfConfirm;
	private JButton btnUpdate;
	private JButton btnZipcode;
	private JTextField tfCode;
	private JComboBox<String> cmbLicence;
	private Customer loginCustomer;

	/**
	 * Create the panel.
	 */

	public CustommerUpdate() {
		service = new CustomUiService();
		initcomponents();

	}

	private void initcomponents() {
		setLayout(new BorderLayout(0, 0));

		loginCustomer = LoginUI.loginCusotmer;

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelInput1 = new JPanel();
		panelInput1.setBorder(new TitledBorder(null, "\uAE30\uBCF8\uC815\uBCF4\uC218\uC815", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		panel.add(panelInput1, BorderLayout.CENTER);
		panelInput1.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblCode = new JLabel("고객코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblCode);

		tfCode = new JTextField();
		tfCode.setEditable(false);
		tfCode.setText(loginCustomer.getCode());
		panelInput1.add(tfCode);
		tfCode.setColumns(10);

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblName);

		tfName = new JTextField();
		tfName.setText(loginCustomer.getName());
		panelInput1.add(tfName);
		tfName.setColumns(10);

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblId);

		tfId = new JTextField();
		tfId.setText(loginCustomer.getId());
		panelInput1.add(tfId);
		tfId.setColumns(10);

		JLabel lblDob = new JLabel("생일");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblDob);

		dateChooser = new JDateChooser();
		dateChooser.setDate(loginCustomer.getDob());
		panelInput1.add(dateChooser);

		JLabel lblPhone = new JLabel("연락처");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblPhone);

		JPanel pTel = new JPanel();
		panelInput1.add(pTel);
		pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));

		cmbTel = new JComboBox<String>();
		cmbTel.setEditable(true);
		String[] arrayT1 = loginCustomer.getPhone().split("-");
		cmbTel.setPreferredSize(new Dimension(100, 22));
		cmbTel.setModel(new DefaultComboBoxModel<String>(new String[] { "010", "011", "017" }));
		cmbTel.setSelectedIndex(-1);
		cmbTel.setSelectedItem(arrayT1[0] + "");
		pTel.add(cmbTel);

		JLabel lblTel1 = new JLabel("-");
		lblTel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel1.setEnabled(false);
		pTel.add(lblTel1);

		tfTel2 = new JTextField();
		String[] arrayT2 = loginCustomer.getPhone().split("-");
		tfTel2.setText(arrayT2[1] + "");
		tfTel2.setColumns(10);
		pTel.add(tfTel2);

		JLabel lblTel2 = new JLabel("-");
		lblTel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel2.setEnabled(false);
		pTel.add(lblTel2);

		tfTel3 = new JTextField();
		String[] arrayT3 = loginCustomer.getPhone().split("-");
		tfTel3.setText(arrayT3[2] + "");
		tfTel3.setColumns(10);
		pTel.add(tfTel3);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblEmail);

		JPanel pEmail = new JPanel();
		panelInput1.add(pEmail);
		pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.X_AXIS));

		tfEmail = new JTextField();
		String[] arrayE1 = loginCustomer.getEmail().split("@");
		tfEmail.setText(arrayE1[0] + "");
		tfEmail.setColumns(15);
		pEmail.add(tfEmail);

		JLabel labelAt = new JLabel("@");
		labelAt.setHorizontalAlignment(SwingConstants.CENTER);
		pEmail.add(labelAt);

		tfDomain = new JTextField();
		String[] arrayE2 = loginCustomer.getEmail().split("@");
		tfDomain.setText(arrayE2[1] + "");
		tfDomain.setColumns(15);
		pEmail.add(tfDomain);

		cmbDomain = new JComboBox<String>();
		cmbDomain.setEditable(true);
		cmbDomain.setPreferredSize(new Dimension(150, 22));
		cmbDomain.addActionListener(this);
		cmbDomain.setModel(new DefaultComboBoxModel<String>(
				new String[] { "선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com", "직접입력" }));
		pEmail.add(cmbDomain);

		JLabel lbl_1 = new JLabel("우편번호");
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lbl_1);

		JPanel pAddr = new JPanel();
		panelInput1.add(pAddr);
		pAddr.setLayout(new BoxLayout(pAddr, BoxLayout.X_AXIS));

		tfZipcode = new JTextField();
		tfZipcode.setText(loginCustomer.getZipCode());
		pAddr.add(tfZipcode);
		tfZipcode.setColumns(10);

		btnZipcode = new JButton("우편번호 검색");
		btnZipcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPostUI frame = new SearchPostUI();
				frame.setJoinUi(CustommerUpdate.this); // 추가해줌. setAddress()호출하기 위핸
				frame.setVisible(true);
			}
		});
		pAddr.add(btnZipcode);

		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblAddress);

		tfAddress = new JTextField();
		tfAddress.setText(loginCustomer.getAddress());
		panelInput1.add(tfAddress);
		tfAddress.setColumns(10);

		JLabel lblLicence = new JLabel("면허종류");
		lblLicence.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblLicence);

		cmbLicence = new JComboBox<>();
		cmbLicence.setEditable(true);
		cmbLicence.setModel(new DefaultComboBoxModel<String>(new String[] { "선택하세요", "1종보통", "2종보통" }));
		cmbLicence.setSelectedItem(loginCustomer.getLicense());
		panelInput1.add(cmbLicence);

		JLabel lblNowPw = new JLabel("현재비밀번호");
		lblNowPw.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblNowPw);

		pwfNowPw = new JPasswordField();
		panelInput1.add(pwfNowPw);

		JLabel lblNewPw = new JLabel("새비밀번호");
		lblNewPw.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblNewPw);

		JPanel pPw = new JPanel();
		panelInput1.add(pPw);
		pPw.setLayout(new GridLayout(0, 2, 0, 0));

		pwfNewPw = new JPasswordField();
		pwfNewPw.getDocument().addDocumentListener(new MyDocumentListener() {

			@Override
			public void msg() {
				String pw1 = new String(pwfNewPw.getPassword());
				String pw2 = new String(pwfConfirmPw.getPassword());
				if (pw1.length() == 0 && pw2.length() == 0) {
					tfConfirm.setText("");
				} else if (pw1.equals(pw2)) {
					tfConfirm.setText("비밀번호 일치.");
				} else {
					tfConfirm.setText("비밀번호 불일치.");
				}
			}
		});

		pPw.add(pwfNewPw);

		JLabel lblConfirmPw = new JLabel("비밀번호확인");
		lblConfirmPw.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblConfirmPw);

		JPanel panel_1 = new JPanel();
		panelInput1.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		pwfConfirmPw = new JPasswordField();
		panel_1.add(pwfConfirmPw);

		tfConfirm = new JTextField();
		panel_1.add(tfConfirm);
		tfConfirm.setColumns(10);

		pwfConfirmPw.getDocument().addDocumentListener(new MyDocumentListener() {

			@Override
			public void msg() {

				String pw1 = new String(pwfNewPw.getPassword());
				String pw2 = new String(pwfConfirmPw.getPassword());

				if (pw1.length() == 0 && pw2.length() == 0) {
					tfConfirm.setText("");
				} else if (pw1.equals(pw2)) {
					tfConfirm.setText("비밀번호 일치.");
				} else {
					tfConfirm.setText("비밀번호 불일치.");
				}
			}
		});

		JPanel pBtn = new JPanel();
		panel.add(pBtn, BorderLayout.SOUTH);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtn.add(btnUpdate);
	}

	/* 추가해줌 */
	public void setAddress(Post post) {
		this.tfZipcode.setText(post.getZipcode());
		this.tfAddress.setText(post.toString());
		tfAddress.requestFocus();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(arg0);
		}
		if (arg0.getSource() == cmbDomain) {
			do_cmbDomain_actionPerformed(arg0);
		}
	}

	protected void do_cmbDomain_actionPerformed(ActionEvent arg0) {
		if (cmbDomain.getSelectedIndex() < 5) {
			tfDomain.setEditable(false);
			tfDomain.setText((String) cmbDomain.getSelectedItem());
		} else {
			tfDomain.requestFocus();
			tfDomain.setText("");
			tfDomain.setEditable(true);
		}
	}

	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		Customer customer = getItem();		

		String nowPw = new String(pwfNowPw.getPassword());
		String newPw = new String(pwfNewPw.getPassword()).trim();
		String confirmPw = new String(pwfConfirmPw.getPassword()).trim();		

		Customer c = LoginUI.loginCusotmer;
		c.setPasswd(nowPw);
		int sameResult = service.samePwd(c); // 현재 비밀번호를 db랑 비교 0이면 다름 1이면 같음

		if (sameResult == 1 && newPw.equals(confirmPw)) {
			customer.setPasswd(newPw);
			service.updateCustomer(customer);

		}else if(sameResult == 1){
			service.updateInfo(customer);
		}else {
			JOptionPane.showMessageDialog(null, "비밀번호를 확인해 주세요");
		}

	}

	private Customer getItem() {
		Customer item = new Customer();

		String code = tfCode.getText().trim();
		String name = tfName.getText().trim();
		String id = tfId.getText().trim();
		Date dob = dateChooser.getDate();
		String phone = (cmbTel.getSelectedItem()) + "-" + (tfTel2.getText().trim()) + "-" + (tfTel3.getText().trim());
		String email = (tfEmail.getText().trim()) + "@" + (tfDomain.getText().trim());
		String zipCode = tfZipcode.getText().trim();
		String addr = tfAddress.getText().trim();
		String license = null;
		if (cmbLicence.getSelectedIndex() == 0) {
			cmbLicence.setSelectedIndex(2);
			license = (cmbLicence.getSelectedItem() + "").trim();
		} else {
			license = (String) cmbLicence.getSelectedItem();
		}
		String nowPw = new String(pwfNowPw.getPassword());
	
		
		Employee empCode = new Employee(loginCustomer.getEmpCode().getCode());
		Grade gradeCode = new Grade(loginCustomer.getGradeCode().getCode());
		JOptionPane.showMessageDialog(null, "gradeCode = " + gradeCode);

		/*
		 * String newPw = new String(pwfNewPw.getPassword());
		 *  String confirmPw = new
		 * String(pwfConfirmPw.getPassword());
		 */

		item.setCode(code);
		item.setName(name);
		item.setId(id);
		item.setDob(dob);
		item.setPhone(phone);
		item.setEmail(email);
		item.setZipCode(zipCode);
		item.setAddress(addr);
		
		item.setPasswd(nowPw);
		/*item.setPasswd(newPw);
		item.setPasswd(confirmPw);*/
		
		item.setLicense(license);
		item.setEmpCode(empCode);
		item.setGradeCode(gradeCode);
		
		
		
		return item;
	}

}
