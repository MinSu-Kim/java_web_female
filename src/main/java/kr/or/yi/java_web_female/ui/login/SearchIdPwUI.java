package kr.or.yi.java_web_female.ui.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.service.JoinUiService;
import kr.or.yi.java_web_female.service.SearchIdPwService;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class SearchIdPwUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JTextField tfDomain;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbtnSearchId;
	private JRadioButton rbtnSearchPw;
	private JComboBox<String> cmbDomain;
	private JLabel lblPhone;
	private JPanel pTel;
	private JComboBox<String> cmbTel;
	private JLabel label;
	private JTextField tfTel2;
	private JLabel label_1;
	private JTextField tfTel3;
	private JButton btnSearch;
	private SearchIdPwService searchService;
	private JButton btnCancel;

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

	public SearchIdPwUI() {

		searchService = new SearchIdPwService();

		setTitle("ID/PW찾기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		rbtnSearchId = new JRadioButton("아이디 찾기");
		rbtnSearchId.setSelected(true);
		rbtnSearchId.addActionListener(this);
		buttonGroup.add(rbtnSearchId);
		rbtnSearchId.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtnSearchId);

		rbtnSearchPw = new JRadioButton("비밀번호 찾기");
		rbtnSearchPw.addActionListener(this);
		buttonGroup.add(rbtnSearchPw);

		rbtnSearchPw.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtnSearchPw);

		lblPhone = new JLabel("연락처");
		panel.add(lblPhone);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);

		pTel = new JPanel();
		panel.add(pTel);
		pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));

		cmbTel = new JComboBox<String>();
		cmbTel.setModel(new DefaultComboBoxModel<String>(new String[] { "010", "011", "017" }));
		pTel.add(cmbTel);

		label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setEnabled(false);
		pTel.add(label);

		tfTel2 = new JTextField();
		tfTel2.setColumns(10);
		pTel.add(tfTel2);

		label_1 = new JLabel("-");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setEnabled(false);
		pTel.add(label_1);

		tfTel3 = new JTextField();
		tfTel3.setColumns(10);
		pTel.add(tfTel3);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEmail);

		JPanel pEmail = new JPanel();
		panel.add(pEmail);
		pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.X_AXIS));

		tfEmail = new JTextField();
		tfEmail.setColumns(15);
		pEmail.add(tfEmail);

		JLabel label_3 = new JLabel("@");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		pEmail.add(label_3);

		tfDomain = new JTextField();
		tfDomain.setColumns(15);
		pEmail.add(tfDomain);

		cmbDomain = new JComboBox<String>();
		cmbDomain.addActionListener(this);
		cmbDomain.setModel(new DefaultComboBoxModel<String>(
				new String[] { "선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com", "직접입력" }));
		pEmail.add(cmbDomain);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnSearch = new JButton("아이디 찾기");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);

		btnCancel = new JButton("나가기");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
		if (e.getSource() == rbtnSearchId) {
			do_rbtnSearchId_actionPerformed(e);
		}
		if (e.getSource() == rbtnSearchPw) {
			do_rbtnSearchPw_actionPerformed(e);
		}
		if (e.getSource() == cmbDomain) {
			do_cmbDomain_actionPerformed(e);
		}
	}

	protected void do_cmbDomain_actionPerformed(ActionEvent e) {
		if (cmbDomain.getSelectedIndex() < 5) {
			tfDomain.setEditable(false);
			tfDomain.setText((String) cmbDomain.getSelectedItem());
		} else {
			tfDomain.requestFocus();
			tfDomain.setText("");
			tfDomain.setEditable(true);

		}
	}

	protected void do_rbtnSearchPw_actionPerformed(ActionEvent e) {
		/*
		 * if(rbtnSearchId.isSelected()) { lblId.setVisible(true);
		 * tfId.setVisible(true); }
		 */
		if (rbtnSearchPw.isSelected()) {
			btnSearch.setText("비밀번호 변경");
		}

	}

	protected void do_rbtnSearchId_actionPerformed(ActionEvent e) {
		/*
		 * if(rbtnSearchPw.) { lblId.setVisible(false); tfId.setVisible(false); }
		 */
		if (rbtnSearchId.isSelected()) {
			btnSearch.setText("아이디 찾기");
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		try {
			if(rbtnSearchId.isSelected()) {
				Customer customer = getItem();
				Customer searchId = searchService.searchId(customer);

				JOptionPane.showMessageDialog(null, searchId);
			}
			if(rbtnSearchPw.isSelected()) {
				Customer customer = getItem();
				int changePw = searchService.changePw(customer);
				
				JOptionPane.showMessageDialog(null, "비밀번호가 '12341234'로 변경되었습니다. 환경설정에서 비밀번호를 변경해 주세요");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private Customer getItem() {
		String cusPhone = (cmbTel.getSelectedItem()) + "-" + (tfTel2.getText().trim()) + "-"
				+ (tfTel3.getText().trim());

		String cusEmail = (tfEmail.getText().trim()) + "@" + (tfDomain.getText().trim());
		Customer customer = new Customer();
		customer.setPhone(cusPhone);
		customer.setEmail(cusEmail);

		return customer;
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		LoginUI frame = new LoginUI();
		frame.setVisible(true);
		dispose();
	}
	
	public void close() {
		dispose();
	}
}
