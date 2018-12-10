package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pContent = new JPanel();
		contentPane.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 3, 10, 10));
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblNewLabel);
		
		textField = new JTextField();
		pContent.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("로그인");
		pContent.add(btnNewButton_2);
		
		JLabel label = new JLabel("비밀번호");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		pContent.add(textField_1);
		
		JCheckBox checkBox = new JCheckBox("관리자 모드");
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(checkBox);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("회원가입");
		pBtn.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ID/PW찾기");
		pBtn.add(btnNewButton_1);
	}

}
