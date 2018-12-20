package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Customer;

import kr.or.yi.java_web_female.service.CustomUiService;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;
import kr.or.yi.java_web_female.ui.list.CustomerList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CustommerListPannel extends JPanel implements ActionListener {
	private List<Customer> list;
	private JTextField tfZipCode;
	private JTextField tfAddr;
	private JTextField tfEmpCode;
	private JTextField tfGradeName;
	private JTextField tfRentCnt;
	private CustomUiService service;
	private JButton btnCusOk;
	private JButton btnCusCancel;
	private CustomerList panelList;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public CustommerListPannel() {
		setBorder(
				new TitledBorder(null, "\uACE0\uAC1D\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new CustomUiService();
		initcomponents();
	}

	private void initcomponents() {
		panelList = new CustomerList();
		list = service.selectCustomerByAll();
		panelList.setList(list);
		panelList.loadDatas();
		setLayout(new BorderLayout(0, 0));
		add(panelList, BorderLayout.CENTER);

		panelList.setPopupMenu(createDeptPopupMenu());

		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_4.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel label = new JLabel("고객코드");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		panel_2.add(textField);

		JLabel label_1 = new JLabel("고객명");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_2.add(textField_1);

		JLabel label_2 = new JLabel("고객아이디");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);

		JLabel label_3 = new JLabel("생년월일");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_3);

		JDateChooser dateChooser = new JDateChooser();
		panel_2.add(dateChooser);

		JLabel label_4 = new JLabel("연락처");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_4);

		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);

		JLabel label_5 = new JLabel("-");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setEnabled(false);
		panel_1.add(label_5);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_1.add(textField_3);

		JLabel label_6 = new JLabel("-");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setEnabled(false);
		panel_1.add(label_6);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_1.add(textField_4);

		JLabel label_7 = new JLabel("이메일");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label_7);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		textField_5 = new JTextField();
		textField_5.setColumns(15);
		panel_3.add(textField_5);

		JLabel label_8 = new JLabel("@");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_8);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(15);
		panel_3.add(textField_6);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		panel_3.add(comboBox_1);

		JPanel panelInput = new JPanel();
		panel.add(panelInput);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblAddr = new JLabel("우편번호");
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblAddr);

		JPanel pAddr = new JPanel();
		panelInput.add(pAddr);
		pAddr.setLayout(new BoxLayout(pAddr, BoxLayout.X_AXIS));

		tfZipCode = new JTextField();
		tfZipCode.setColumns(10);
		pAddr.add(tfZipCode);

		JButton btnSearchAddr = new JButton("우편번호 검색");
		pAddr.add(btnSearchAddr);

		JLabel lblAddrDetail = new JLabel("주소");
		lblAddrDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblAddrDetail);

		tfAddr = new JTextField();
		panelInput.add(tfAddr);
		tfAddr.setColumns(10);

		JLabel lblEmpCode = new JLabel("직원코드");
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEmpCode);

		tfEmpCode = new JTextField();
		panelInput.add(tfEmpCode);
		tfEmpCode.setColumns(10);

		JLabel lblLicence = new JLabel("면허종류");
		lblLicence.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblLicence);

		JComboBox cmbLicence = new JComboBox();
		panelInput.add(cmbLicence);

		JLabel lblGradeName = new JLabel("등급명");
		lblGradeName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblGradeName);

		tfGradeName = new JTextField();
		panelInput.add(tfGradeName);
		tfGradeName.setColumns(10);

		JLabel lblRentCnt = new JLabel("대여횟수");
		lblRentCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblRentCnt);

		tfRentCnt = new JTextField();
		panelInput.add(tfRentCnt);
		tfRentCnt.setColumns(10);

		JPanel panelBtn = new JPanel();
		panel_4.add(panelBtn, BorderLayout.SOUTH);

		btnCusOk = new JButton("추가");
		btnCusOk.addActionListener(this);
		panelBtn.add(btnCusOk);

		btnCusCancel = new JButton("취소");
		btnCusCancel.addActionListener(this);
		panelBtn.add(btnCusCancel);
	}

	private JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer item = panelList.getSelectedItem();
				setItem(item);
				btnCusOk.setText("수정");
			}

		});
		popMenu.add(updateItem);

		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				service.deleteCustomer(panelList.getSelectedItem());
				panelList.setList(service.selectCustomerByAll());
				panelList.loadDatas();
			}
		});
		popMenu.add(delItem);

		return popMenu;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCusCancel) {
			do_btnCusCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCusOk) {
			if (btnCusOk.getText() == "추가") {
				do_btnCusOk_actionPerformed(arg0);
			} else {
				do_btnUpdate_actionPerformed(arg0);
			}

		}
	}

	private void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		Customer customer = getItem();
		service.updateCustomer(customer);
		panelList.setList(service.selectCustomerByAll());
		panelList.loadDatas();
		clearTf();
		btnCusOk.setText("추가");

	}

	private void clearTf() {
		tfCusId.setText("");
		tfAddr.setText("");
		tfCusCode.setText("");
		tfCusEmail1.setText("");
		tfCusEmail2.setText("");
		tfCusName.setText("");
		// tfEmpCode.setText("");
		tfTel2.setText("");
		tfTel3.setText("");
		tfZipCode.setText("");

	}

	private Customer getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void do_btnCusOk_actionPerformed(ActionEvent arg0) {
	}

	protected void do_btnCusCancel_actionPerformed(ActionEvent arg0) {
		if (btnCusOk.getText() == "수정") {
			btnCusOk.setText("추가");
		}
		clearTf();
	}

	private void setItem(Customer item) {
		// TODO Auto-generated method stub

	}

}
