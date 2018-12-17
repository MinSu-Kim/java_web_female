package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.TestFrame;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.exception.LoginFailException;
import kr.or.yi.java_web_female.service.LoginUiService;

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JButton btnSearch;
	private JButton btnLogin;
	private LoginUiService loginService;
	
	private JPasswordField tfPwd;
	private JCheckBox checkManager;
	
	public static Customer loginCusotmer;
	public static Employee loginEmployee;

	public LoginUI() {
		loginService = new LoginUiService();
		
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pContent = new JPanel();
		contentPane.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblId);

		tfId = new JTextField();
		pContent.add(tfId);
		tfId.setColumns(10);

		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		pContent.add(btnLogin);

		JLabel lblPasswd = new JLabel("비밀번호");
		lblPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblPasswd);

		tfPwd = new JPasswordField();
		
		pContent.add(tfPwd);

		checkManager = new JCheckBox("관리자 모드");
		checkManager.addActionListener(this);
		checkManager.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(checkManager);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		JButton btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinUI frame = new JoinUI();
				frame.setVisible(true);
			}
		});
		pBtn.add(btnJoin);

		btnSearch = new JButton("ID/PW찾기");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);
		
		
		// 테스트용도
		tfId.setText("asd132");
		tfPwd.setText("rootroot");
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogin) {
			do_btnLogin_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		SearchIdPwUI frame = new SearchIdPwUI();
		frame.setVisible(true);
	}

	protected void do_btnLogin_actionPerformed(ActionEvent e) {
		try {
			isLoginCheck();
			dispose();
			TestFrame frame = new TestFrame(); 
			frame.setVisible(true);
		} catch (LoginFailException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
	}

	private void isLoginCheck() throws LoginFailException {
		if (checkManager.isSelected()) {			
			loginEmployee = loginService.selectEmployeeByPw((Employee) getUser(true));
		} else {
			loginCusotmer = loginService.selectCustomerByPw((Customer) getUser(false));
		}
	}

	//추가
	private Object getUser(boolean isEmployee) {
		String id = tfId.getText().trim();
		String pwd = new String(tfPwd.getPassword()).trim();
		if (isEmployee) {
			return new Employee(id, pwd);
		}else {
			return new Customer(id, pwd);
		}
	}
}