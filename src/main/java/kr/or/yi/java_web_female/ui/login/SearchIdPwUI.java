package kr.or.yi.java_web_female.ui.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
import kr.or.yi.java_web_female.service.SearchIdPwService;

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
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;


	public SearchIdPwUI() {

		searchService = new SearchIdPwService();

		setTitle("ID/PW찾기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(150, 10));
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		lblPhone = new JLabel("연락처");
		panel_2.add(lblPhone);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEmail = new JLabel("이메일");
		panel_2.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);

		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 10));

		pTel = new JPanel();
		panel_3.add(pTel);
		pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));

		cmbTel = new JComboBox<String>();
		cmbTel.setPreferredSize(new Dimension(80, 27));
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

		JPanel pEmail = new JPanel();
		panel_3.add(pEmail);
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
		cmbDomain.setPreferredSize(new Dimension(150, 27));
		cmbDomain.addActionListener(this);
		cmbDomain.setModel(new DefaultComboBoxModel<String>(
				new String[] { "선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com", "직접입력" }));
		pEmail.add(cmbDomain);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnSearch = new JButton("아이디 찾기");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		rbtnSearchId = new JRadioButton("아이디 찾기");
		panel_1.add(rbtnSearchId);
		rbtnSearchId.setSelected(true);
		rbtnSearchId.addActionListener(this);
		buttonGroup.add(rbtnSearchId);
		rbtnSearchId.setHorizontalAlignment(SwingConstants.CENTER);

		rbtnSearchPw = new JRadioButton("비밀번호 찾기");
		panel_1.add(rbtnSearchPw);
		rbtnSearchPw.addActionListener(this);
		buttonGroup.add(rbtnSearchPw);

		rbtnSearchPw.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
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
		if (rbtnSearchPw.isSelected()) {
			btnSearch.setText("비밀번호 변경");
		}

	}

	protected void do_rbtnSearchId_actionPerformed(ActionEvent e) {
		if (rbtnSearchId.isSelected()) {
			btnSearch.setText("아이디 찾기");
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		try {
			if (rbtnSearchId.isSelected()) {
				Customer customer = getItem();
				Customer findCustomer = searchService.searchId(customer);
				if (findCustomer == null) {
					JOptionPane.showMessageDialog(null, "연락처와 이메일을 다시 확인해 주세요.");
					return;
				}
				JOptionPane.showMessageDialog(null, "고객의 아이디는 '" + findCustomer.getId() + "' 입니다.");
				LoginUI frame = new LoginUI();
				frame.setId(findCustomer.getId());
				frame.setVisible(true);
				dispose();

			}
			if (rbtnSearchPw.isSelected()) {
				Customer customer = getItem();
				Customer findCustomer = searchService.searchId(customer);
				if (findCustomer == null) {
					JOptionPane.showMessageDialog(null, "연락처와 이메일을 다시 확인해 주세요.");
					return;
				}
				String newPwd = searchService.getRandPw();
				customer.setPasswd(newPwd);
				searchService.changePw(customer);
				JOptionPane.showMessageDialog(null, "비밀번호가 '" + newPwd + "' 로 변경되었습니다. 환경설정에서 비밀번호를 변경해 주세요");

				LoginUI frame = new LoginUI();
				frame.setPasswd(newPwd);
				frame.setVisible(true);
				dispose();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	private Customer getItem() throws Exception {

		if (tfTel2.getText().trim().equals("") || tfTel3.getText().trim().equals("")
				|| tfEmail.getText().trim().equals("") || tfDomain.getText().trim().equals("")) {

			throw new Exception("연락처와 이메일을 다시 확인해 주세요.");
		}
		String cusPhone = (cmbTel.getSelectedItem()) + "-" + (tfTel2.getText().trim()) + "-"
				+ (tfTel3.getText().trim());

		String cusEmail = (tfEmail.getText().trim()) + "@" + (tfDomain.getText().trim());

		Customer customer = new Customer();
		customer.setPhone(cusPhone);
		customer.setEmail(cusEmail);

		return customer;
	}

	public void close() {
		dispose();
	}
}
