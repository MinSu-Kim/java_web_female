package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dao.EmployeeMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.service.CustomerUiService;
import kr.or.yi.java_web_female.service.EmployeeUiService;
import kr.or.yi.java_web_female.ui.rent.CarSearchFrame;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JButton btnSearch;
	private JButton btnLogin;
	private CustomerUiService cusService;
	private EmployeeUiService empService;
	private JPasswordField tfPwd;
	private JCheckBox checkManager;
	private CustomerMapperImpl cusDao;
	private EmployeeMapperImpl empDao;
	


	public LoginUI() {
		cusDao = CustomerMapperImpl.getInstance();
		empDao = EmployeeMapperImpl.getInstance();
		cusService = new CustomerUiService();
		
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
		isLoginCheck();
		/*if(checkManager.isSelected()) {
			TestFrame frame = new TestFrame(); 
			frame.setVisible(true);
		}else {
			CarSearchFrame frame = new CarSearchFrame(); 
			frame.setVisible(true);
		}*/
		

	}

	private void isLoginCheck() {
		/*String id= tfId.getText().trim();
		String pw = new String(tfPwd.getPassword()).trim();
		Customer customer = getItemCustomer(); */
		
	
		try {
			Customer customer = getItemCustomer(); 
			Employee employee = getItemEmployee();
			
			JOptionPane.showMessageDialog(null, customer);
			JOptionPane.showMessageDialog(null, employee);
			
			int res = cusService.selectCustomerById(customer);
			int resw = cusService.selectCustomerByPw(customer);
			
			int empRes = empService.selectEmployeeById(employee);
			int empResw = empService.selectEmployeeByPw(employee);
			
			JOptionPane.showMessageDialog(null, res);
			JOptionPane.showMessageDialog(null, resw);
			//JOptionPane.showMessageDialog(null, res+resw);
			if (res + resw == 1) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				TestFrame frame = new TestFrame(); // 고객용 화면 UI로 변경 해야됨
				frame.setVisible(true);
			}
			if (res + resw == 0) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인해 주세요.");
			}
			
			/*if(resw==1) {
				JOptionPane.showMessageDialog(null, "비밀번호 성공");
				
			}
			if (resw== 0) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인해 주세요.");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * try { Customer customer = getItemCustomer();
		 * JOptionPane.showMessageDialog(null, customer); int res =
		 * cusService.selectCustomerById(customer); // 1이면 중복 0이면 사용가능
		 * JOptionPane.showMessageDialog(null, res); if (tfId.getText().trim().length()
		 * > 1) { if (res == 0) { JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
		 * tfPwd1.requestFocus();
		 * 
		 * } if (res == 1) { JOptionPane.showMessageDialog(null, "중복된 아이디입니다."); } }
		 * else { JOptionPane.showMessageDialog(null, "아이디를 입력해주세요"); }
		 * 
		 * } catch (Exception e2) { e2.printStackTrace();
		 * 
		 * }
		 */
	}

	private Employee getItemEmployee() {
		String empId = tfId.getText().trim();
		String empPw = new String(tfPwd.getPassword()).trim();
		
		return new Employee(empId, empPw);
	}

	private Customer getItemCustomer() {
		String cusId = tfId.getText().trim();
		String cusPw = new String(tfPwd.getPassword()).trim();
		/*
		 * String cusPw = new String(tfPwd1.getPassword()).trim(); String cusName =
		 * tfName.getText().trim(); String cusAddress = tfAddr.getText().trim(); String
		 * cusPhone = tfTel2.getText().trim() tfTel3.getText().trim() ; Date cusDob =
		 * birthDay.getDate(); String cusEmail = tfEmail1.getText().trim();
		 */

		return new Customer(cusId, cusPw);
	}
	
}