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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public SearchPannel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = new JPanel();
		add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("아이디 찾기");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("비밀번호 찾기");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(rdbtnNewRadioButton_1);
		
		JPanel panel = new JPanel();
		pContent.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("아이디");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		pContent.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblNewLabel);
		
		textField_3 = new JTextField();
		pContent.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("이메일");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		pContent.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("@");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("아이디 찾기");
		pBtn.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("비밀번호 찾기");
		pBtn.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("나가기");
		pBtn.add(btnNewButton_2);

	}

}
