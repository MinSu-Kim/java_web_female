package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class SearchIdPwUI extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfDomain;
	private JComboBox<String> cmbDomain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchIdPwUI frame = new SearchIdPwUI();
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
	public SearchIdPwUI() {
		setTitle("ID/PW찾기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rbtnSearchId = new JRadioButton("아이디 찾기");
		rbtnSearchId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(rbtnSearchId);
		
		JRadioButton rbtnSearchPw = new JRadioButton("비밀번호 찾기");
		rbtnSearchPw.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(rbtnSearchPw);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		panel_2.add(tfId);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		panel_2.add(tfName);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblEmail);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 4, 0, 0));
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		panel_4.add(tfEmail);
		
		JLabel label_3 = new JLabel("@");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_3);
		
		tfDomain = new JTextField();
		tfDomain.setColumns(10);
		panel_4.add(tfDomain);
		
		cmbDomain = new JComboBox<String>();
		cmbDomain.addMouseListener(this);
		cmbDomain.setModel(new DefaultComboBoxModel<String>(new String[] {"선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com"}));
		panel_4.add(cmbDomain);
		
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnSearchId = new JButton("아이디 찾기");
		panel.add(btnSearchId);
		
		JButton btnSearchPw = new JButton("비밀번호 찾기");
		panel.add(btnSearchPw);
		
		JButton btnCancel = new JButton("나가기");
		panel.add(btnCancel);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cmbDomain) {
			do_cmbDomain_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void do_cmbDomain_mouseClicked(MouseEvent e) {
		
		
	}
}
