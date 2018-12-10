package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;

public class Rent extends JFrame {

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
					Rent frame = new Rent();
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
	public Rent() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("차량 대여");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(label);
		
		ComboPanel panel_1 = new ComboPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNewLabel = new JLabel("고객명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 0));
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblNewLabel_1 = new JLabel("대여일자");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel lblNewLabel_2 = new JLabel("대여시간");
		panel_4.add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		panel_4.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		panel_4.add(spinner_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblNewLabel_4 = new JLabel("반납일자");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_4);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 3, 10, 0));
		
		JLabel lblNewLabel_3 = new JLabel("반납시간");
		panel_7.add(lblNewLabel_3);
		
		JSpinner spinner_2 = new JSpinner();
		panel_7.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		panel_7.add(spinner_3);
		
		JLabel lblNewLabel_5 = new JLabel("자차손해 면책 제도");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_10 = new JPanel();
		panel_1.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("가입안함");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("일반자차");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("최종 요금");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnNewButton_2 = new JButton("대여");
		panel_9.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("닫기");
		panel_9.add(btnNewButton_3);
	}

}
