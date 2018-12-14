package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.FuelList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class FuelListPanel extends JPanel implements ActionListener {
	private JTextField tfCode;
	private JTextField tfNo;
	private CarUiService service;
	private List<Fuel> list;
	private FuelList panelList;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Create the panel.
	 */
	public FuelListPanel() {
		service = new CarUiService();
		initcomponent();
	}

	private void initcomponent() {
		
		panelList = new FuelList();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = service.selectAllFuel();
		panelList.setList(list);
		panelList.loadDatas();
		setLayout(new GridLayout(0, 2, 0, 0));
		add(panelList);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "\uC5F0\uB8CC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNo = new JLabel("번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setColumns(10);
		panelInput.add(tfNo);
		
		JLabel lblCode = new JLabel("연료코드");
		panelInput.add(lblCode);
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfCode = new JTextField();
		panelInput.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel_1.add(panelBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		
		panelBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panelBtn.add(btnCancel);
		
		//pop
		panelList.setPopupMenu(createDeptPopupMenu());
	}

	private JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Fuel item = panelList.getSelectedItem();
				setItem(item);
				btnOk.setText("수정");
			}
		});
		popMenu.add(updateItem);
		
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				service.deleteFuel(panelList.getSelectedItem());
				panelList.setList(service.selectAllFuel());
				panelList.loadDatas();
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
		Fuel item = getItem();
		service.updateFuel(item);
		list = service.selectAllFuel();
		panelList.setList(list);
		panelList.loadDatas();	
		clearTf();
		btnOk.setText("추가");
	}

	private Fuel getItem() {
		String code = tfCode.getText();
		String no = tfNo.getText();
		Fuel item = new Fuel();
		item.setNo(Integer.parseInt(no));
		item.setCode(code);
		
		return item;
	}

	protected void do_btnOk_actionPerformed(ActionEvent e) {
		//추가버튼 눌렀을시 실행
		Fuel newFuel = getItem();
		service.insertFuel(newFuel);
		list = service.selectAllFuel();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		clearTf();
		
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		if(btnOk.getText()=="수정") {
			btnOk.setText("추가");
		}
		//취소버튼 눌렀을시 실행
		clearTf();
	}

	private void clearTf() {
		tfCode.setText("");
		tfNo.setText("");
	}
	
	private void setItem(Fuel item) {
		tfCode.setText(item.getCode());
		tfNo.setText(item.getNo()+"");
	}
}
