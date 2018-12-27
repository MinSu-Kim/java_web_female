package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.service.CustomUiService;
import kr.or.yi.java_web_female.ui.join.JoinUI;
import kr.or.yi.java_web_female.ui.join.SearchPostUI;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;
import kr.or.yi.java_web_female.ui.list.CustomerList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CustommerListPannel extends JPanel implements ActionListener {
	private List<Customer> list;
	private JTextField tfZipCode;
	private JTextField tfAddr;
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
	private JComboBox<String> cmbLicense;
	private JDateChooser birthday;
	private JComboBox<Employee> cmbEmpCode;
	private JComboBox<Grade> cmbGrade;

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
		tfCusCode.setColumns(10);
		panelInput1.add(tfCusCode);

		JLabel tfCusName_1 = new JLabel("고객명");
		tfCusName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(tfCusName_1);

		tfCusName = new JTextField();
		tfCusName.setColumns(10);
		panelInput1.add(tfCusName);

		JLabel lblCusId = new JLabel("고객아이디");
		lblCusId.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(lblCusId);

		tfCusId = new JTextField();
		tfCusId.setColumns(10);
		panelInput1.add(tfCusId);

		JLabel lblDob = new JLabel("생년월일");
		lblDob.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput1.add(lblDob);

		birthday = new JDateChooser();
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
		tfZipCode.setColumns(10);
		pAddr.add(tfZipCode);

		JButton btnSearchAddr = new JButton("우편번호 검색");
		btnSearchAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPostUI frame = new SearchPostUI();
				frame.setJoinUi(CustommerListPannel.this); // 추가해줌. setAddress()호출하기 위핸
				frame.setVisible(true);
			}
		});
		pAddr.add(btnSearchAddr);

		JLabel lblAddrDetail = new JLabel("주소");
		lblAddrDetail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblAddrDetail);

		tfAddr = new JTextField();
		panelInput2.add(tfAddr);
		tfAddr.setColumns(10);

		JLabel lblEmpCode = new JLabel("직원코드");
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblEmpCode);

		List<Employee> empList = service.getEmpList();
		DefaultComboBoxModel<Employee> empModel = new DefaultComboBoxModel<>(new Vector<>(empList));
		cmbEmpCode = new JComboBox<>(empModel);
		panelInput2.add(cmbEmpCode);

		JLabel lblLicence = new JLabel("면허종류");
		lblLicence.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblLicence);

		cmbLicense = new JComboBox<>();
		panelInput2.add(cmbLicense);
		cmbLicense.addActionListener(this);
		cmbLicense.setModel(new DefaultComboBoxModel<String>(new String[] { "선택하세요", "1종보통", "2종보통" }));

		JLabel lblGradeName = new JLabel("등급명");
		lblGradeName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblGradeName);

		List<Grade> gradeList = service.getGradeList();
		DefaultComboBoxModel<Grade> gradeModel = new DefaultComboBoxModel<>(new Vector<>(gradeList));
		cmbGrade = new JComboBox<>(gradeModel);
		cmbGrade.setEnabled(false);
		panelInput2.add(cmbGrade);

		JLabel lblRentCnt = new JLabel("대여횟수");
		lblRentCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput2.add(lblRentCnt);

		tfRentCnt = new JTextField();
		panelInput2.add(tfRentCnt);
		tfRentCnt.setEditable(false);
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
		
		enableField();
	}

	private void enableField() {
		if(btnCusOk.getText().equals("수정")) {
			cmbGrade.setEnabled(true);
			tfRentCnt.setEditable(true);
		}else {
			cmbGrade.setEnabled(false);
			tfRentCnt.setEditable(false);
		}
	}

	/* 추가해줌 */
	public void setAddress(Post post) {
		this.tfZipCode.setText(post.getZipcode());
		this.tfAddr.setText(post.toString());
		tfAddr.requestFocus();
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
				enableField();
			}

		});
		popMenu.add(updateItem);

		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Customer customer = panelList.getSelectedItem();
				CustomEvent customEvent = new CustomEvent();
				System.out.println(customer.getCode());
				customEvent.setCustomCode(customer.getCode());

				service.deleteCustomerEvent(customer, customEvent);
				panelList.setList(service.selectCustomerByAll());
				panelList.loadDatas();

				// CustomEvent customEvent = new CustomEvent();
				// CustomEvent("EVT1", customer.getCode(), false);

//				JOptionPane.showMessageDialog(null, customer);
//				JOptionPane.showMessageDialog(null, customEvent);

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
		enableField();
	}

	private void clearTf() {

		tfCusId.setText("");
		tfAddr.setText("");
		tfZipCode.setText("");
		tfCusCode.setText("");
		tfCusEmail1.setText("");
		tfCusEmail2.setText("");
		tfCusName.setText("");
		cmbEmpCode.setSelectedIndex(-1);
		tfTel2.setText("");
		tfTel3.setText("");
		tfZipCode.setText("");
		cmbGrade.setSelectedIndex(-1);
		tfRentCnt.setText("");
		birthday.setDate(null);
		cmbCusEmail2.setSelectedItem("선택하세요");
		cmbLicense.setSelectedItem("선택하세요");
		cmbTel1.setSelectedItem("010");

	}

	private Customer getItem() {
		Customer item = new Customer();
		item.setCode(tfCusCode.getText().trim());

		Customer updateCustomer = list.get(list.indexOf(item));

		String cId = tfCusId.getText().trim();
		String cName = tfCusName.getText().trim();
		String cAddr = tfAddr.getText().trim();
		String zipCode = tfZipCode.getText().trim();
		Date cusDob = birthday.getDate();
		/*String cTel1 = (String) cmbTel1.getSelectedItem();
		String cTel2 = tfTel2.getText().trim();
		String cTel3 = tfTel3.getText().trim();*/
		String cEmail1 = tfCusEmail1.getText().trim();
		String cEmail2 = tfCusEmail2.getText().trim();
		String cEmail3 = (String) cmbCusEmail2.getSelectedItem();
		String cusPhone = (cmbTel1.getSelectedItem()) + "-" + (tfTel2.getText().trim()) + "-"
				+ (tfTel3.getText().trim());
		
		String license = null;
		if (cmbLicense.getSelectedIndex() == 0) {
			cmbLicense.setSelectedIndex(2);
			license = (cmbLicense.getSelectedItem() + "").trim();
		} else {
			license = (String) cmbLicense.getSelectedItem();
		}

		Employee empCode = new Employee("E001");
		Grade gradeCode = new Grade("G001");
		updateCustomer.setId(cId);
		updateCustomer.setAddress(cAddr);
		updateCustomer.setZipCode(zipCode);
		updateCustomer.setEmail(cEmail1);
		updateCustomer.setEmail(cEmail2);
		updateCustomer.setEmail(cEmail3);
		updateCustomer.setName(cName);
		updateCustomer.setDob(cusDob);
		updateCustomer.setPhone(cusPhone);
		
		updateCustomer.setAddress(zipCode);
		updateCustomer.setLicense(license);
		updateCustomer.setEmpCode(empCode);
		updateCustomer.setGradeCode(gradeCode);
		return updateCustomer;
	}

	protected void do_btnCusOk_actionPerformed(ActionEvent arg0) {
//		JOptionPane.showMessageDialog(null, "do_btnCusOk_actionPerformed 추가");
		String cId = tfCusId.getText().trim();
		String cName = tfCusName.getText().trim();
		String cCode = tfCusCode.getText().trim();
		String cAddr = tfAddr.getText().trim();
		Date cusDob = birthday.getDate();
		String cEmail1 = tfCusEmail1.getText().trim();
		String cEmail2 = tfCusEmail2.getText().trim();
		
		Employee eCode = (Employee) cmbEmpCode.getSelectedItem();
		Grade gradeName=(Grade) cmbGrade.getSelectedItem();
		String license = null;
		if (cmbLicense.getSelectedIndex() == 0) {
			cmbLicense.setSelectedIndex(2);
			license = (cmbLicense.getSelectedItem() + "").trim();
		} else {
			license = (String) cmbLicense.getSelectedItem();
		}
		String zipCode = tfZipCode.getText();

//		Grade gradeName = (Grade) cmbGrade.getSelectedItem();
		int rentCnt = 0;

		Customer customer = new Customer();
		//Grade gradeCode = new Grade("G001");
		
		customer.setId(cId);
		customer.setPasswd("1234");
		customer.setGradeCode(new Grade("G001"));
		customer.setName(cName);
		customer.setLicense(license);
		customer.setZipCode(zipCode);
		customer.setAddress(cAddr);
		customer.setCode(cCode);
		customer.setDob(cusDob);

		customer.setEmail(String.format("%s@%s", cEmail1, cEmail2));
		
		

		Employee empCode = service.getEmployeeByNo(eCode);
		Grade gradeCode = service.getGradeByName(gradeName);

		customer.setEmpCode(empCode);
		String cusPhone = (cmbTel1.getSelectedItem()) + "-" + (tfTel2.getText().trim()) + "-"
				+ (tfTel3.getText().trim());

		customer.setPhone(cusPhone);
		customer.setAddress(cAddr);
		customer.setGradeCode(gradeCode);
		customer.setRentCnt(rentCnt);

		//JOptionPane.showMessageDialog(null, customer);
		service.insertCustomer(customer);
		
		list = service.selectCustomerByAll();
		panelList.setList(list);
		panelList.loadDatas();
//		add(panelList);
		clearTf();
	}

	protected void do_btnCusCancel_actionPerformed(ActionEvent arg0) {
		if (btnCusOk.getText() == "수정") {
			btnCusOk.setText("추가");
			enableField();
		}
		clearTf();
	}

	private void setItem(Customer item) {
		tfCusId.setText(item.getId() + "");

		tfCusCode.setText(item.getCode() + "");
		birthday.setDate(item.getDob());

		String[] array1 = item.getEmail().split("@");
		tfCusEmail1.setText(array1[0] + "");
		tfCusEmail2.setText(array1[1] + "");
		tfCusName.setText(item.getName() + "");
		cmbEmpCode.setSelectedItem(item.getEmpCode());
		cmbGrade.setSelectedItem(item.getGradeCode());

		String[] array2 = item.getPhone().split("-");
		cmbTel1.setSelectedItem(array2[0] + "");
		tfTel2.setText(array2[1] + "");
		tfTel3.setText(array2[2] + "");

		tfZipCode.setText(item.getZipCode() + "");
		tfAddr.setText(item.getAddress() + "");
		cmbLicense.setSelectedItem(item.getLicense());
		tfRentCnt.setText(item.getRentCnt() + "");

	}

	protected void do_cmbCusEmail2_actionPerformed(ActionEvent arg0) {
		if (cmbCusEmail2.getSelectedIndex() < 5) {
			tfCusEmail2.setEditable(false);
			tfCusEmail2.setText((String) cmbCusEmail2.getSelectedItem());
		} else {
			tfCusEmail2.requestFocus();
			tfCusEmail2.setText("");
			tfCusEmail2.setEditable(true);
		}
	}

}
