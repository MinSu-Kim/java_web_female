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
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.service.CustomUiService;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;
import kr.or.yi.java_web_female.ui.list.CustomerList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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
	private JTextField tfCusCode;
	private JTextField tfCusName;
	private JTextField tfCusId;
	private JTextField tfTel2;
	private JTextField tfTel3;
	private JTextField tfCusEmail1;
	private JTextField tfCusEmail2;
	private JComboBox<String> cmbTel1;
	private JComboBox<String> cmbCusEmail2;
	private JComboBox<?> cmbLicence;

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

		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_4.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelInput1 = new JPanel();
		panel.add(panelInput1);
		panelInput1.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblCusCode = new JLabel("고객코드");
		lblCusCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(lblCusCode);

		tfCusCode = new JTextField();
		tfCusCode.setEditable(false);
		tfCusCode.setColumns(10);
		panelInput1.add(tfCusCode);

		JLabel tfCusName_1 = new JLabel("고객명");
		tfCusName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(tfCusName_1);

		tfCusName = new JTextField();
		tfCusName.setEditable(false);
		tfCusName.setColumns(10);
		panelInput1.add(tfCusName);

		JLabel lblCusId = new JLabel("고객아이디");
		lblCusId.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(lblCusId);

		tfCusId = new JTextField();
		tfCusId.setEditable(false);
		tfCusId.setColumns(10);
		panelInput1.add(tfCusId);

		JLabel lblDob = new JLabel("생년월일");
		lblDob.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(lblDob);

		JDateChooser birthday = new JDateChooser();
		panelInput1.add(birthday);

		JLabel label_4 = new JLabel("연락처");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(label_4);

		JPanel pTel = new JPanel();
		panelInput1.add(pTel);
		pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));

		cmbTel1 = new JComboBox<>();
		cmbTel1.setModel(new DefaultComboBoxModel<String>(new String[] { "010", "011", "017" }));
		pTel.add(cmbTel1);

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

		JLabel label_7 = new JLabel("이메일");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(label_7);

		JPanel pEmail = new JPanel();
		panelInput1.add(pEmail);
		pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.X_AXIS));

		tfCusEmail1 = new JTextField();
		tfCusEmail1.setColumns(15);
		pEmail.add(tfCusEmail1);

		JLabel lblAt = new JLabel("@");
		lblAt.setHorizontalAlignment(SwingConstants.CENTER);
		pEmail.add(lblAt);

		tfCusEmail2 = new JTextField();
		tfCusEmail2.setEditable(false);
		tfCusEmail2.setColumns(15);
		pEmail.add(tfCusEmail2);

		cmbCusEmail2 = new JComboBox<String>();
		cmbCusEmail2.addActionListener(this);
		
		cmbCusEmail2.setModel(new DefaultComboBoxModel<String>(
				new String[] { "선택하세요", "naver.com", "gmail.com", "daum.net", "nate.com", "직접입력" }));
		pEmail.add(cmbCusEmail2);

		JPanel panelInput2 = new JPanel();
		panel.add(panelInput2);
		panelInput2.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblAddr = new JLabel("우편번호");
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblAddr);

		JPanel pAddr = new JPanel();
		panelInput2.add(pAddr);
		pAddr.setLayout(new BoxLayout(pAddr, BoxLayout.X_AXIS));

		tfZipCode = new JTextField();
		tfZipCode.setEditable(false);
		tfZipCode.setColumns(10);
		pAddr.add(tfZipCode);

		JButton btnSearchAddr = new JButton("우편번호 검색");
		pAddr.add(btnSearchAddr);

		JLabel lblAddrDetail = new JLabel("주소");
		lblAddrDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblAddrDetail);

		tfAddr = new JTextField();
		tfAddr.setEditable(false);
		panelInput2.add(tfAddr);
		tfAddr.setColumns(10);

		JLabel lblEmpCode = new JLabel("직원코드");
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblEmpCode);

		tfEmpCode = new JTextField();
		tfEmpCode.setEditable(false);
		panelInput2.add(tfEmpCode);
		tfEmpCode.setColumns(10);

		JLabel lblLicence = new JLabel("면허종류");
		lblLicence.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblLicence);

		cmbLicence = new JComboBox<>();
		panelInput2.add(cmbLicence);

		JLabel lblGradeName = new JLabel("등급명");
		lblGradeName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblGradeName);

		tfGradeName = new JTextField();
		tfGradeName.setEditable(false);
		panelInput2.add(tfGradeName);
		tfGradeName.setColumns(10);

		JLabel lblRentCnt = new JLabel("대여횟수");
		lblRentCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblRentCnt);

		tfRentCnt = new JTextField();
		tfRentCnt.setEditable(false);
		panelInput2.add(tfRentCnt);
		tfRentCnt.setColumns(10);

		JPanel panelBtn = new JPanel();
		panel_4.add(panelBtn, BorderLayout.SOUTH);

		btnCusOk = new JButton("추가");
		btnCusOk.addActionListener(this);
		panelBtn.add(btnCusOk);

		btnCusCancel = new JButton("취소");
		btnCusCancel.addActionListener(this);
		panelBtn.add(btnCusCancel);
		add(panelList, BorderLayout.CENTER);

		panelList.setPopupMenu(createDeptPopupMenu());
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
		if (arg0.getSource() == cmbCusEmail2) {
			do_cmbCusEmail2_actionPerformed(arg0);
		}
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
		tfEmpCode.setText("");
		tfTel2.setText("");
		tfTel3.setText("");
		tfZipCode.setText("");
		tfGradeName.setText("");
		tfRentCnt.setText("");

	}

	private Customer getItem() {
		String cId = tfCusId.getText();
		String cAddr = tfAddr.getText();
		String cCode = tfCusCode.getText();
		String cEmail1 = tfCusEmail1.getText();
		String cEmail2 =  tfCusEmail2.getText();
		String cName = tfCusName.getText();
		String eCode = tfEmpCode.getText();
		String cTel2 = tfTel2.getText();
		String cTel3 = tfTel3.getText();
		String zipCode = tfZipCode.getText();
		String gradeName = tfGradeName.getText();
		int rentCnt = Integer.parseInt(tfRentCnt.getText()); 

		Customer item = new Customer();
		item.setId(cId);
		item.setAddress(cAddr);
		item.setCode(cCode);
		item.setEmail(cEmail1);
		item.setEmail(cEmail2);
		item.setName(cName);
		
		Employee empCode = new Employee("E001");
		Grade gradeCode = new Grade("G001");
		
		item.setEmpCode(empCode);
		item.setPhone(cTel2);
		item.setPhone(cTel3);
		item.setAddress(zipCode);
		item.setGradeCode(gradeCode);
		item.setRentCnt(rentCnt);
		return item;
	}

	protected void do_btnCusOk_actionPerformed(ActionEvent arg0) {
		String cId = tfCusId.getText();
		String cAddr = tfAddr.getText();
		String cCode = tfCusCode.getText();
		String cEmail1 = tfCusEmail1.getText();
		String cEmail2 =  tfCusEmail2.getText();
		String cName = tfCusName.getText();
		String eCode = tfEmpCode.getText();
		String cTel2 = tfTel2.getText();
		String cTel3 = tfTel3.getText();
		String zipCode = tfZipCode.getText();
		String gradeName = tfGradeName.getText();
		int rentCnt = Integer.parseInt(tfRentCnt.getText()); 
		
		Customer customer = new Customer();
		customer.setId(cId);
		customer.setAddress(cAddr);
		customer.setCode(cCode);
		customer.setEmail(cEmail1);
		customer.setEmail(cEmail2);
		customer.setName(cName);
		
		Employee empCode = new Employee("E001");
		Grade gradeCode = new Grade("G001");
		
		customer.setEmpCode(empCode);
		customer.setPhone(cTel2);
		customer.setPhone(cTel3);
		customer.setAddress(zipCode);
		customer.setGradeCode(gradeCode);
		customer.setRentCnt(rentCnt);
		
		service.insertCustomer(customer);
		list = service.selectCustomerByAll();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		clearTf();
	}

	protected void do_btnCusCancel_actionPerformed(ActionEvent arg0) {
		if (btnCusOk.getText() == "수정") {
			btnCusOk.setText("추가");
		}
		clearTf();
	}

	private void setItem(Customer item) {
		tfCusId.setText(item.getId() + "");
		tfAddr.setText(item.getAddress() + "");
		tfCusCode.setText(item.getCode() + "");
		tfCusEmail1.setText(item.getEmail() + "");
		tfCusEmail2.setText(item.getEmail() + "");
		tfCusName.setText(item.getName() + "");
		tfEmpCode.setText(item.getEmpCode() + "");
		tfTel2.setText(item.getPhone() + "");
		tfTel3.setText(item.getPhone() + "");
		tfZipCode.setText(item.getAddress() + "");
		tfGradeName.setText(item.getGradeCode() + "");
		tfRentCnt.setText(item.getRentCnt() + "");
		
		

	}

	protected void do_cmbCusEmail2_actionPerformed(ActionEvent arg0) {
		if(cmbCusEmail2.getSelectedIndex()<5) {
			tfCusEmail2.setEditable(false);
			tfCusEmail2.setText((String)cmbCusEmail2.getSelectedItem());
		}else {
			tfCusEmail2.requestFocus();
			tfCusEmail2.setText("");
			tfCusEmail2.setEditable(true);
		}
	}
}
