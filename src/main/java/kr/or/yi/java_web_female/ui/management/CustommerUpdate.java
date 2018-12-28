package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.service.CustomUiService;
import kr.or.yi.java_web_female.ui.list.CustomerList;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CustommerUpdate extends JPanel implements ActionListener {
	private List<Customer> list;
	private JTextField tfName;
	private JTextField tfId;
	private JTextField tfZipcode;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfDomain;
	private JTextField tfTel2;
	private JTextField tfTel3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<String> cmbDomain;
	private JComboBox<String> cmbTel;
	private CustomerList panelList;
	private CustomUiService service;

	/**
	 * Create the panel.
	 */

	public CustommerUpdate() {
		service = new CustomUiService();
		initcomponents();

	}

	private void initcomponents() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelInput1 = new JPanel();
		panelInput1.setBorder(new TitledBorder(null, "\uAE30\uBCF8\uC815\uBCF4\uC218\uC815", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		panel.add(panelInput1, BorderLayout.NORTH);
		panelInput1.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblName);

		tfName = new JTextField();
		panelInput1.add(tfName);
		tfName.setColumns(10);

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblId);

		tfId = new JTextField();
		tfId.setEditable(false);
		panelInput1.add(tfId);
		tfId.setColumns(10);

		JLabel lblDob = new JLabel("생일");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblDob);

		JDateChooser dateChooser = new JDateChooser();
		panelInput1.add(dateChooser);

		JLabel lblPhone = new JLabel("연락처");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblPhone);

		JPanel pTel = new JPanel();
		panelInput1.add(pTel);
		pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));

		cmbTel = new JComboBox<String>();
		cmbTel.setModel(new DefaultComboBoxModel<String>(new String[] { "010", "011", "017" }));
		pTel.add(cmbTel);

		JLabel lblTel1 = new JLabel("-");
		lblTel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel1.setEnabled(false);
		pTel.add(lblTel1);

		tfTel2 = new JTextField();
		tfTel2.setColumns(10);
		pTel.add(tfTel2);

		JLabel lblTel2 = new JLabel("-");
		lblTel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel2.setEnabled(false);
		pTel.add(lblTel2);

		tfTel3 = new JTextField();
		tfTel3.setColumns(10);
		pTel.add(tfTel3);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblEmail);

		JPanel pEmail = new JPanel();
		panelInput1.add(pEmail);
		pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.X_AXIS));

		tfEmail = new JTextField();
		tfEmail.setColumns(15);
		pEmail.add(tfEmail);

		JLabel labelAt = new JLabel("@");
		labelAt.setHorizontalAlignment(SwingConstants.CENTER);
		pEmail.add(labelAt);

		tfDomain = new JTextField();
		tfDomain.setEditable(false);
		tfDomain.setColumns(15);
		pEmail.add(tfDomain);

		cmbDomain = new JComboBox<String>();
		cmbDomain.addActionListener(this);
		cmbDomain.setModel(new DefaultComboBoxModel<String>(
				new String[] { "선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com", "직접입력" }));
		pEmail.add(cmbDomain);

		JLabel lbl_1 = new JLabel("우편번호");
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lbl_1);

		JPanel pAddr = new JPanel();
		panelInput1.add(pAddr);
		pAddr.setLayout(new BoxLayout(pAddr, BoxLayout.X_AXIS));

		tfZipcode = new JTextField();
		pAddr.add(tfZipcode);
		tfZipcode.setColumns(10);

		JButton btnZipcode = new JButton("우편번호 검색");
		pAddr.add(btnZipcode);

		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(lblAddress);

		tfAddress = new JTextField();
		panelInput1.add(tfAddress);
		tfAddress.setColumns(10);

		JLabel label = new JLabel("현재비밀번호");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		panelInput1.add(textField);

		JLabel label_1 = new JLabel("새비밀번호");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panelInput1.add(textField_1);

		JLabel label_2 = new JLabel("비밀번호확인");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput1.add(label_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panelInput1.add(textField_2);

		panelList = new CustomerList();
		list = service.selectCustomerByAll();
		panelList.setList(list);
		panelList.loadDatas();
		panel.add(panelList, BorderLayout.CENTER);
		//setLayout(new BorderLayout(0, 0));

		JPanel pBtn = new JPanel();
		panel.add(pBtn, BorderLayout.SOUTH);

		JButton btnUpdate = new JButton("수정");
		pBtn.add(btnUpdate);

		JButton btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cmbDomain) {
			do_cmbDomain_actionPerformed(arg0);
		}
	}

	protected void do_cmbDomain_actionPerformed(ActionEvent arg0) {
		if (cmbDomain.getSelectedIndex() < 5) {
			tfDomain.setEditable(false);
			tfDomain.setText((String) cmbDomain.getSelectedItem());
		} else {
			tfDomain.requestFocus();
			tfDomain.setText("");
			tfDomain.setEditable(true);
		}
	}
}
