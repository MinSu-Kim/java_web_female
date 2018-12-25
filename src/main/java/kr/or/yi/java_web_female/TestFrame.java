package kr.or.yi.java_web_female;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.ui.ManagerPanel;
import kr.or.yi.java_web_female.ui.login.LoginUI;

@SuppressWarnings("serial")
public class TestFrame extends JFrame {

	private ManagerPanel contentPane;
	private Customer loginCusotmer;
	private Employee loginEmployee;
	
	public TestFrame() {
		setTitle(getLoginUser());
		
		JOptionPane.showMessageDialog(null, loginCusotmer==null?loginEmployee:loginCusotmer);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 700);
		contentPane = new ManagerPanel();
		setContentPane(contentPane);
	}
	
	private String getLoginUser() {
		String loginUserName = null;
		if (LoginUI.loginCusotmer !=null) {
			loginCusotmer = LoginUI.loginCusotmer;
			loginUserName = loginCusotmer.getName();
		}
		if (LoginUI.loginEmployee !=null) {
			loginEmployee = LoginUI.loginEmployee;
			loginUserName = loginEmployee.getName();
		}
		return String.format("%s님", loginUserName);
	}
	
	public static boolean loginEmployee() {
		if(LoginUI.loginEmployee !=null) {
			return true;
		}else {
			return false;
		}
	}
}
