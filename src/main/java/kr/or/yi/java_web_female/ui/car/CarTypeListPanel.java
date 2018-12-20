package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.CarTypeList;
@SuppressWarnings("serial")
public class CarTypeListPanel extends JPanel implements ActionListener {
	private JTextField tfCode;
	private JTextField tfType;
	private CarTypeList panelList;
	private CarUiService service;
	private List<CarType> list;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public CarTypeListPanel() {
		setBorder(new TitledBorder(null, "\uCC28\uC885", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new CarUiService();
		initcomponent();
	}

	private void initcomponent() {
		
		panelList = new CarTypeList();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = service.selectAllCarType();
		panelList.setList(list);
		panelList.loadDatas();
		setLayout(new GridLayout(0, 2, 0, 0));
		add(panelList);
		
		JPanel panelList_2 = new JPanel();
		add(panelList_2);
		panelList_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panelList_2.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblCode = new JLabel("차종코드");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblCode);
		
		tfCode = new JTextField();
		panelInput.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblType = new JLabel("차량유형");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblType);
		
		tfType = new JTextField();
		panelInput.add(tfType);
		tfType.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panelList_2.add(panelBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		panelBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panelBtn.add(btnCancel);
		
		panelList.setPopupMenu(createDeptPopupMenu());
	}

	private JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		//수정
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CarType item = panelList.getSelectedItem();
				setItem(item);
				btnOk.setText("수정");
			}
		});
		popMenu.add(updateItem);
		//삭제
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					service.deleteCarType(panelList.getSelectedItem());
					panelList.setList(service.selectAllCarType());
					panelList.loadDatas();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "해당 차종의 차량을 보유 중 (삭제 불가능)");
				}
			}
		});
		popMenu.add(delItem);
		
		return popMenu;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			if(btnOk.getText()=="추가") {
				do_btnOk_actionPerformed(e);
			}else {
				do_btnUpdate_actionPerformed(e);
			}
		}
	}
	private void do_btnUpdate_actionPerformed(ActionEvent e) {
		CarType item = getItem();
		service.updateCarType(item);
		panelList.setList(service.selectAllCarType());
		panelList.loadDatas();
		clearTf();
		btnOk.setText("추가");
	}

	private CarType getItem() {
		String code = tfCode.getText();
		String type = tfType.getText();
		CarType item = new CarType();
		item.setCode(code);
		item.setType(type);
		return item;
	}

	protected void do_btnOk_actionPerformed(ActionEvent e) {
		String code = tfCode.getText();
		String type = tfType.getText();
		CarType carType = new CarType();
		carType.setCode(code);
		carType.setType(type);
		service.insertCarType(carType);
		list = service.selectAllCarType();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		clearTf();
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		if(btnOk.getText()=="수정") {
			btnOk.setText("추가");
		}
		clearTf();
	}
	
	private void setItem(CarType item) {
		tfCode.setText(item.getCode());
		tfType.setText(item.getType());
	}

	private void clearTf() {
		tfCode.setText("");
		tfType.setText("");
	}
}
