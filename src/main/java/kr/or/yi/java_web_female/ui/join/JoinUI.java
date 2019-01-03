package kr.or.yi.java_web_female.ui.join;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.service.JoinUiService;
import kr.or.yi.java_web_female.ui.login.LoginUI;

@SuppressWarnings("serial")
public class JoinUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfId;
	private JPasswordField tfPwd1;
	private JPasswordField tfPwd2;
	private JTextField tfTel2;
	private JTextField tfTel3;
	private JTextField tfEmail1;
	private JTextField tfEmail2;
	private JTextField tfZipCode;
	private JTextField tfAddr;
	private JButton btnDupConfirm;
	private JButton btnJoin;
	private JComboBox<String> cmbEmail3;
	private JDateChooser birthDay;
	private JTextField tfConfirm;
	private JButton btnCalcel;
	private JComboBox<String> cmbTel1;

	private JoinUiService joinService;
	private JComboBox<String> cmbLicense;

	public JoinUI() {
		joinService = new JoinUiService();

		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pContent = new JPanel();
		contentPane.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		pContent.add(tfName);

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblId);

		JPanel pId = new JPanel();
		pContent.add(pId);
		pId.setLayout(new GridLayout(0, 2, 0, 0));

		tfId = new JTextField();
		tfId.setColumns(10);
		pId.add(tfId);

		btnDupConfirm = new JButton("중복확인");
		btnDupConfirm.addActionListener(this);
		pId.add(btnDupConfirm);

		JLabel lblPw1 = new JLabel("비밀번호");
		lblPw1.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblPw1);

		JPanel pPwd1 = new JPanel();
		pContent.add(pPwd1);
		pPwd1.setLayout(new GridLayout(0, 2, 0, 0));

		tfPwd1 = new JPasswordField();
		tfPwd1.getDocument().addDocumentListener(new MyDocumentListener() {

			@Override
			public void msg() {
				String pw1 = new String(tfPwd1.getPassword());
				String pw2 = new String(tfPwd2.getPassword());
				if (pw1.length() == 0 && pw2.length() == 0) {
					tfConfirm.setText("");
				} else if (pw1.equals(pw2)) {
					tfConfirm.setText("비밀번호 일치.");
				} else {
					tfConfirm.setText("비밀번호 불일치.");
				}
			}
		});
		tfPwd1.setColumns(10);
		pPwd1.add(tfPwd1);

		JLabel lblBlank1 = new JLabel("");
		lblBlank1.setHorizontalAlignment(SwingConstants.CENTER);
		pPwd1.add(lblBlank1);

		JLabel lblPw2 = new JLabel("비밀번호 확인");
		lblPw2.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblPw2);

		JPanel panel_2 = new JPanel();
		pContent.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		tfPwd2 = new JPasswordField();
		tfPwd2.setColumns(10);
		panel_2.add(tfPwd2);

		tfConfirm = new JTextField();
		tfConfirm.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tfConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		tfConfirm.setEditable(false);
		panel_2.add(tfConfirm);
		tfConfirm.setColumns(10);

		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblBirth);

		birthDay = new JDateChooser();
		pContent.add(birthDay);

		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblTel);

		JPanel pTel = new JPanel();
		pContent.add(pTel);
		pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));

		cmbTel1 = new JComboBox<>();
		cmbTel1.setModel(new DefaultComboBoxModel<String>(new String[] { "선택하세요", "010", "011", "017" }));
		pTel.add(cmbTel1);

		JLabel lbl1 = new JLabel("-");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		pTel.add(lbl1);

		tfTel2 = new JTextField();
		tfTel2.setColumns(10);
		pTel.add(tfTel2);

		JLabel lbl2 = new JLabel("-");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		pTel.add(lbl2);

		tfTel3 = new JTextField();
		tfTel3.setColumns(10);
		pTel.add(tfTel3);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblEmail);

		JPanel pEmail = new JPanel();
		pContent.add(pEmail);
		pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.X_AXIS));

		tfEmail1 = new JTextField();
		tfEmail1.setColumns(8);
		pEmail.add(tfEmail1);

		JLabel lblAt = new JLabel("@");
		lblAt.setHorizontalAlignment(SwingConstants.CENTER);
		pEmail.add(lblAt);

		tfEmail2 = new JTextField();
		tfEmail2.setEditable(false);
		tfEmail2.setColumns(8);
		pEmail.add(tfEmail2);

		cmbEmail3 = new JComboBox<>();
		cmbEmail3.addActionListener(this);
		cmbEmail3.setModel(new DefaultComboBoxModel<String>(
				new String[] { "선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com", "직접입력" }));
		pEmail.add(cmbEmail3);

		JLabel lblAddr = new JLabel("우편번호");
		lblAddr.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblAddr);

		JPanel pAddr = new JPanel();
		pContent.add(pAddr);
		pAddr.setLayout(new GridLayout(0, 2, 0, 0));

		tfZipCode = new JTextField();
		tfZipCode.setColumns(10);
		pAddr.add(tfZipCode);

		tfPwd2.getDocument().addDocumentListener(new MyDocumentListener() {

			@Override
			public void msg() {

				String pw1 = new String(tfPwd1.getPassword());
				String pw2 = new String(tfPwd2.getPassword());

				if (pw1.length() == 0 && pw2.length() == 0) {
					tfConfirm.setText("");
				} else if (pw1.equals(pw2)) {
					tfConfirm.setText("비밀번호 일치.");
				} else {
					tfConfirm.setText("비밀번호 불일치.");
				}

			}

		});

		JButton btnSearchAddr = new JButton("우편번호 검색");
		btnSearchAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPostUI frame = new SearchPostUI();
				frame.setJoinUi(JoinUI.this); // 추가해줌. setAddress()호출하기 위핸
				frame.setVisible(true);
			}
		});
		pAddr.add(btnSearchAddr);

		JLabel lblAddrDetail = new JLabel("주소");
		lblAddrDetail.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblAddrDetail);

		tfAddr = new JTextField();
		pContent.add(tfAddr);
		tfAddr.setColumns(10);

		JLabel lblLicense = new JLabel("면허종류");
		lblLicense.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblLicense);

		cmbLicense = new JComboBox<>();
		cmbLicense.setModel(new DefaultComboBoxModel<String>(new String[] { "선택하세요", "1종 보통", "2종 보통" }));

		pContent.add(cmbLicense);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnJoin = new JButton("가입");
		btnJoin.addActionListener(this);
		pBtn.add(btnJoin);

		btnCalcel = new JButton("취소");
		btnCalcel.addActionListener(this);
		pBtn.add(btnCalcel);
	}

	/* 추가해줌 */
	public void setAddress(Post post) {
		this.tfZipCode.setText(post.getZipcode());
		this.tfAddr.setText(post.toString());
		tfAddr.requestFocus();
	}

	/*
	 * public void setEmail() { cmbEmail3.setSelectedItem(cmbEmail3);
	 * tfEmail2.setText(); }
	 */

	/*
	 * pList = new AddressTable();
	 * 
	 * // 클릭리스너추가 pList.getTable().addMouseListener(new MouseAdapter() {
	 * 
	 * @Override public void mouseClicked(MouseEvent e) { Post post =
	 * pList.getSelectedItem(); joinUi.setAddress(post);
	 * SearchPostUI.this.dispose(); } });
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbEmail3) {
			do_cmbEmail3_actionPerformed(e);
		}
		if (e.getSource() == btnCalcel) {
			do_btnCalcel_actionPerformed(e);
		}
		if (e.getSource() == btnJoin) {
			do_btnJoin_actionPerformed(e);
		}
		if (e.getSource() == btnDupConfirm) {
			try {
				do_btnDupConfirm_actionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	protected void do_btnDupConfirm_actionPerformed(ActionEvent e) throws SQLException {
		try {
			Customer customer = getItemCustomer();
			Customer searchCustomer = joinService.selectCustomerById(customer);
			if (tfId.getText().trim().length() > 1) {
				if (searchCustomer == null) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
					tfPwd1.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
			}

		} catch (Exception e2) {
			e2.printStackTrace();

		}
	}

	protected void do_btnJoin_actionPerformed(ActionEvent e) {

		try {
			validCheck();
			regCheck();
			Customer customer = getItemCustomer();
			customer.setCode(joinService.getNextCustomerCode());
			CustomEvent customEvent = new CustomEvent("EVT1", customer.getCode(), false);

///////////////////////// 트랜잭션 처리 //////////////////////////

			joinService.joinCustomer(customer, customEvent);
			JOptionPane.showMessageDialog(null, "고객님의 회원가입을 축하합니다.");
			LoginUI frame = new LoginUI();
			frame.setVisible(true);

			close();
			clearTf();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
			e2.printStackTrace();
		}
	}

	private void regCheck() throws Exception {
		String name = "^[가-힣]{2,5}$";
		boolean cusName = Pattern.matches(name, tfName.getText().trim());

		if (cusName == true) {
			tfId.requestFocus();
		} else {
			throw new Exception("이름을 올바르게 입력해 주세요.");
		}

		String id = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
		boolean cusId = Pattern.matches(id, tfId.getText().trim());
		if (cusId == true) {

		} else {
			throw new Exception("아이디 시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하");
		}

		String passwd = "^(?=.*\\\\d)(?=.*[~`!@#$%\\\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,12}$\r\n" + "\r\n";
		String pw1 = new String(tfPwd1.getPassword());
		String pw2 = new String(tfPwd2.getPassword());
		boolean cusPasswd = Pattern.matches(passwd, pw1);
		boolean cusPass = Pattern.matches(passwd, pw2);
		if (cusPasswd == true) {

		} else {
			throw new Exception("1. 영문(대소문자 구분), 숫자, 특수문자 조합\r\n" + "\r\n" + "2. 8~12자리 사이 문자\r\n" + "\r\n"
					+ "3. 같은 문자 4개 이상 사용 불가\r\n" + "\r\n" + "4. 비밀번호에 ID 포함 불가\r\n" + "\r\n" + "5. 공백문자 사용 불가\r\n"
					+ "\r\n" + "\r\n" + "\r\n");
		}
		if (cusPass == true) {

		} else {
			throw new Exception("1. 영문(대소문자 구분), 숫자, 특수문자 조합\r\n" + "\r\n" + "2. 8~12자리 사이 문자\r\n" + "\r\n"
					+ "3. 같은 문자 4개 이상 사용 불가\r\n" + "\r\n" + "4. 비밀번호에 ID 포함 불가\r\n" + "\r\n" + "5. 공백문자 사용 불가\r\n"
					+ "\r\n" + "\r\n" + "\r\n");
		}

		String phoneM = "^[0-9]{3,4}$";
		String phoneL = "^[0-9]{4}$";
		boolean phone2 = Pattern.matches(phoneM, tfTel2.getText().trim());
		boolean phone3 = Pattern.matches(phoneL, tfTel3.getText().trim());
		if (phone2 == true) {
			tfTel3.requestFocus();
			if (phone3 == true) {
				tfEmail1.requestFocus();
			} else {
				throw new Exception("전화번호 형식이 올바르지 않습니다 숫자만 입력해 주세요");
			}
		} else {
			throw new Exception("전화번호 형식이 올바르지 않습니다  숫자만 입력해 주세요");

		}

	}

	private void clearTf() {
		tfName.setText("");
		tfId.setText("");
		tfPwd1.setText("");
		tfPwd2.setText("");
		birthDay.setDate(null);
		tfTel2.setText("");
		tfTel3.setText("");
		tfEmail1.setText("");
		tfEmail2.setText("");
		tfZipCode.setText("");
		tfAddr.setText("");
	}

	private Customer getItemCustomer() {
		String cusId = tfId.getText().trim();
		String cusPw = new String(tfPwd1.getPassword()).trim();
		String cusName = tfName.getText().trim();
		String zipCode = tfZipCode.getText().trim();
		String cusAddress = tfAddr.getText().trim();
		String cusPhone = (cmbTel1.getSelectedItem()) + "-" + (tfTel2.getText().trim()) + "-"
				+ (tfTel3.getText().trim());
		Date cusDob = birthDay.getDate();
		String cusEmail = (tfEmail1.getText().trim()) + "@" + (tfEmail2.getText().trim());

		String license = null;
		if (cmbLicense.getSelectedIndex() == 0) {
			cmbLicense.setSelectedIndex(2);
			license = (cmbLicense.getSelectedItem() + "").trim();
		} else {
			license = (String) cmbLicense.getSelectedItem();
		}

		Employee empCode = new Employee("E001");
		Grade gradeCode = new Grade("G001");

		return new Customer(cusId, cusPw, cusName, zipCode, cusAddress, cusPhone, cusDob, cusEmail, empCode, license,
				gradeCode, 0);
	}

	private void validCheck() throws Exception {
		if (tfName.getText().equals("")) {
			tfName.requestFocus();
			throw new Exception("이름을 입력해 주세요.");
		}

		if (tfId.getText().equals("")) {
			tfId.requestFocus();
			throw new Exception("아이디를 입력해 주세요.");
		}

		String pw1 = new String(tfPwd1.getPassword());
		String pw2 = new String(tfPwd2.getPassword());

		if (pw1.equals("")) {
			tfPwd1.requestFocus();
			throw new Exception("Password를 입력해 주세요");
		}
		if (pw2.equals("")) {
			tfPwd2.requestFocus();
			throw new Exception("Password를 입력해 주세요");
		}

		if (birthDay.getDate() == null) {
			birthDay.requestFocus();
			throw new Exception("생년월일을 입력해 주세요.");
		}
		if (cmbTel1.getSelectedItem().equals("선택하세요")) {
			cmbTel1.requestFocus();
			throw new Exception("전화번호 첫자리를 선택해 주세요.");
		}

		if (tfTel2.getText().equals("")) {
			tfTel2.requestFocus();
			throw new Exception("전화번호 가운데 자리를 입력해 주세요.");
		}

		if (tfTel3.getText().equals("")) {
			tfTel3.requestFocus();
			throw new Exception("전화번호 마지막 자리를 입력해 주세요.");
		}
		if (cmbEmail3.getSelectedItem().equals("선택하세요")) {
			cmbEmail3.requestFocus();
			throw new Exception("이메일 첫자리를 선택해 주세요.");
		}

		/*
		 * if (cmbLicense.getSelectedItem().equals("선택하세요")) {
		 * cmbLicense.requestFocus(); throw new Exception("면허종류를  선택해 주세요."); }
		 */

	}

	protected void do_btnCalcel_actionPerformed(ActionEvent e) {
		clearTf();
	}

	protected void do_cmbEmail3_actionPerformed(ActionEvent e) {
		if (cmbEmail3.getSelectedIndex() < 5) {
			tfEmail2.setEditable(false);
			tfEmail2.setText((String) cmbEmail3.getSelectedItem());
		} else {
			tfEmail2.requestFocus();
			tfEmail2.setText("");
			tfEmail2.setEditable(true);
		}
	}

	public void close() {
		dispose();
	}

}