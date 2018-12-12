package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource;
import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.service.CustomerUiService;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;

import javax.swing.JPasswordField;

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
	private CustomerUiService cusService;
	private AbstractListPanel<Customer> cTable;
	private JTextField tfConfirm;

	public void setcTable(AbstractListPanel<Customer> cTable) {
		this.cTable = cTable;
	}

	public JoinUI() {
		cusService = new CustomerUiService();
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

		JComboBox<String> cmbTel1 = new JComboBox<>();
		cmbTel1.setModel(new DefaultComboBoxModel<String>(new String[] { "010", "011", "017" }));
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
		tfEmail2.setColumns(8);
		pEmail.add(tfEmail2);

		cmbEmail3 = new JComboBox<>();
		cmbEmail3.setModel(new DefaultComboBoxModel<String>(
				new String[] { "선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com" }));
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

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnJoin = new JButton("가입");
		btnJoin.addActionListener(this);
		pBtn.add(btnJoin);

		JButton btnCalcel = new JButton("취소");
		pBtn.add(btnCalcel);
	}

	/* 추가해줌 */
	public void setAddress(Post post) {
		this.tfZipCode.setText(post.getZipcode());
		this.tfAddr.setText(post.toString());
		tfAddr.requestFocus();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) {
			do_btnJoin_actionPerformed(e);
		}
		if (e.getSource() == btnDupConfirm) {
			try {
				do_btnDupConfirm_actionPerformed(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void do_btnDupConfirm_actionPerformed(ActionEvent e) throws SQLException {
		try {
			Customer customer = getItemCustomer();
			/* JOptionPane.showMessageDialog(null, customer); */
			int res = cusService.selectCustomerById(customer); // 1이면 중복 0이면 사용가능
			/* JOptionPane.showMessageDialog(null, res); */
			if (tfId.getText().trim().length() > 1) {
				if (res == 0) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
					tfPwd1.requestFocus();

				}
				if (res == 1) {
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
			
			Customer customer = getItemCustomer();
			
			JOptionPane.showMessageDialog(null, "추가했습니다.");
			cTable.setList(cusService.selectCustomerByAll());
			cTable.loadDatas();
			clearTf();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	private void clearTf() {
		tfName.setText("");
		tfId.setText("");
		String pw1 = new String(tfPwd1.getPassword());
		String pw2 = new String(tfPwd2.getPassword());

	}

	private Customer getItemCustomer() {

		String cusId = tfId.getText().trim();
		String cusPw = new String(tfPwd1.getPassword());
		String cusName = tfName.getText().trim();
		String cusAddress = tfAddr.getText().trim();
		String cusPhone = tfTel2.getText().trim() /*tfTel3.getText().trim()*/;
		Date cusDob = birthDay.getDate();
		String cusEmail = tfEmail1.getText().trim();
		
		/* JOptionPane.showMessageDialog(null, cusId); */
		return new Customer(cusId, cusPw, cusName, cusAddress, cusPhone, cusDob, cusEmail);
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
		          
//		JOptionPane.showMessageDialog(null, "생년월일"+birthDay.getDate());
		if (birthDay.getDate() == null) {
			birthDay.requestFocus();
			throw new Exception("생년월일을 입력해 주세요.");
		}

		if (tfTel2.getText().equals("")) {
			tfTel2.requestFocus();
			throw new Exception("전화번호 가운데 자리를 입력해 주세요.");
		}
		if (tfTel3.getText().equals("")) {
			tfTel3.requestFocus();
			throw new Exception("전화번호 마지막 자리를 입력해 주세요.");
		}

	}
}