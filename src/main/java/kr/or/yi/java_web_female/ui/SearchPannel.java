package kr.or.yi.java_web_female.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class SearchPannel extends JPanel {
	private JTextField tfId;
	private JTextField textField_1;
	private JTextField tfEmail;
	private JTextField tfName;

	/**
	 * Create the panel.
	 */
	public SearchPannel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = new JPanel();
		add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnIdSearch = new JRadioButton("아이디 찾기");
		rdbtnIdSearch.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(rdbtnIdSearch);
		
		JRadioButton rdbtnPassSearch = new JRadioButton("비밀번호 찾기");
		rdbtnPassSearch.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(rdbtnPassSearch);
		
		JPanel panel = new JPanel();
		pContent.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblId);
		
		tfId = new JTextField();
		pContent.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblName);
		
		tfName = new JTextField();
		pContent.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblEmail);
		
		JPanel panel_2 = new JPanel();
		pContent.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("@");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		tfEmail = new JTextField();
		panel_2.add(tfEmail);
		tfEmail.setColumns(10);
		
		JComboBox cmbEmail = new JComboBox();
		panel_2.add(cmbEmail);
		
		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		
		JButton btnIdSearch = new JButton("아이디 찾기");
		pBtn.add(btnIdSearch);
		
		JButton btnPassSearch = new JButton("비밀번호 찾기");
		pBtn.add(btnPassSearch);
		
		JButton btnCancel = new JButton("나가기");
		pBtn.add(btnCancel);

	}

}
