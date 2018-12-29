package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridLayout;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.service.EmployeeUiService;
import kr.or.yi.java_web_female.ui.list.EmployeeList;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class EmployeeListPanel extends JPanel implements ActionListener {
	protected List<Employee> list;
	private JTextField tfEmpCode;
	private JTextField tfEmpName;
	private JTextField tfEmpPhone;
	private EmployeeUiService service;

	private EmployeeList panelList;
	private JButton btnEmpOk;
	private JButton btnEmpCancel;
	//private JPasswordField ptfEmpPw;

	/**
	 * Create the panel.
	 */
	public EmployeeListPanel() {
		setBorder(
				new TitledBorder(null, "\uC9C1\uC6D0\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new EmployeeUiService();
		initcomponents();
	}

	private void initcomponents() {

		panelList = new EmployeeList();
		BorderLayout borderLayout = (BorderLayout) panelList.getLayout();
		borderLayout.setVgap(20);
		list = service.selectEmployeeByAll();
		panelList.setList(list);
		panelList.loadDatas();
		
		panelList.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Employee item = panelList.getSelectedItem();
					setItem(item);
					btnEmpOk.setText("수정");
				}
			}
		});
		setLayout(new BorderLayout(0, 0));
		add(panelList, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnEmpOk = new JButton("추가");
		panel_1.add(btnEmpOk);

		btnEmpCancel = new JButton("취소");
		panel_1.add(btnEmpCancel);
		btnEmpCancel.addActionListener(this);
		btnEmpOk.addActionListener(this);

		JPanel panelInput = new JPanel();
		panel.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.X_AXIS));

		JLabel lblEmpCode = new JLabel("직원코드");
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEmpCode);

		tfEmpCode = new JTextField();
		panelInput.add(tfEmpCode);
		tfEmpCode.setColumns(10);

		JLabel lblEmpName = new JLabel("직원명");
		lblEmpName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEmpName);

		tfEmpName = new JTextField();
		panelInput.add(tfEmpName);
		tfEmpName.setColumns(10);

		JLabel lblEmpPhone = new JLabel("연락처");
		lblEmpPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEmpPhone);

		tfEmpPhone = new JTextField();
		panelInput.add(tfEmpPhone);
		tfEmpPhone.setColumns(15);

		/*JLabel lblEmpPw = new JLabel("비밀번호");
		lblEmpPw.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEmpPw);

		ptfEmpPw = new JPasswordField();
		panelInput.add(ptfEmpPw);*/

		panelList.setPopupMenu(createDeptPopupMenu());

	}

	private JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Employee item = panelList.getSelectedItem();
				setItem(item);
				btnEmpOk.setText("수정");
			}

		});
		popMenu.add(updateItem);

		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				service.deleteEmployee(panelList.getSelectedItem());
				panelList.setList(service.selectEmployeeByAll());
				panelList.loadDatas();
			}
		});
		popMenu.add(delItem);

		return popMenu;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmpCancel) {
			do_btnEmpCancel_actionPerformed(e);
		}
		if (e.getSource() == btnEmpOk) {
			if (btnEmpOk.getText() == "추가") {
				do_btnEmpOk_actionPerformed(e);
			} else {
				do_btnUpdate_actionPerformed(e);
			}
		}
	}

	private void do_btnUpdate_actionPerformed(ActionEvent e) {
		Employee employee = getItem();
		service.updateEmployee(employee);
		panelList.setList(service.selectEmployeeByAll());
		panelList.loadDatas();
		clearTf();
		btnEmpOk.setText("추가");

	}

	private Employee getItem() {
		String eCode = tfEmpCode.getText();
		String eName = tfEmpName.getText();
		String ePhone = tfEmpPhone.getText();
		//String ePassword = new String(ptfEmpPw.getPassword());
		Employee item = new Employee();
		item.setCode(eCode);
		item.setName(eName);
		item.setPhone(ePhone);
		//item.setPasswd(ePassword);
		return item;
	}

	protected void do_btnEmpOk_actionPerformed(ActionEvent e) {
		String eCode = tfEmpCode.getText();
		String eName = tfEmpName.getText();
		String ePhone = tfEmpPhone.getText();
		//String ePassword = new String(ptfEmpPw.getPassword());
		Employee employee = new Employee();
		employee.setCode(eCode);
		employee.setName(eName);
		employee.setPhone(ePhone);
		//employee.setPasswd(ePassword);
		service.insertEmployee(employee);
		list = service.selectEmployeeByAll();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		clearTf();
	}

	private void clearTf() {
		tfEmpCode.setText("");
		tfEmpName.setText("");
		tfEmpPhone.setText("");
		//ptfEmpPw.setText("");

	}

	protected void do_btnEmpCancel_actionPerformed(ActionEvent e) {
		if (btnEmpOk.getText() == "수정") {
			btnEmpOk.setText("추가");
		}
		clearTf();
	}

	private void setItem(Employee item) {
		tfEmpCode.setText(item.getCode() + "");
		tfEmpName.setText(item.getName() + "");
		tfEmpPhone.setText(item.getPhone() + "");
		//ptfEmpPw.setText(item.getPasswd() + "");

	}

}
