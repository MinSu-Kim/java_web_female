package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

import org.apache.ibatis.exceptions.PersistenceException;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.CarOptionList;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CarOptionListPanel extends JPanel implements ActionListener {
	
	//리스트
	protected List<CarOption> list;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfPrice;
	private CarOptionList panelList;
	private CarUiService service;
	private JButton btnOk;
	private JButton btnCancel;
	


	public CarOptionListPanel() {
		setBorder(new TitledBorder(null, "\uCC28\uB7C9\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new CarUiService();
		initcomponents();
	}
	
	

	private void initcomponents() {
		
		panelList = new CarOptionList();
		list = service.selectAllCarOption();
		panelList.setList(list);
		panelList.loadDatas();
		setLayout(new BorderLayout(0, 0));
		add(panelList);
		

		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panel.add(panelInput);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("옵션번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblNo);
		
		tfNo = new JTextField();
		panelInput.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("옵션명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblName);
		
		tfName = new JTextField();
		panelInput.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblPrice = new JLabel("옵션가격");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblPrice);
		
		tfPrice = new JTextField();
		panelInput.add(tfPrice);
		tfPrice.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		
		panelBtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
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
				CarOption item = panelList.getSelectedItem();
				setItem(item);
				btnOk.setText("수정");
			}
		});
		popMenu.add(updateItem);
		
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					service.deleteCarOption(panelList.getSelectedItem());
					panelList.setList(service.selectAllCarOption());
					panelList.loadDatas();
				} catch (PersistenceException e2) {
					JOptionPane.showMessageDialog(null, "해당 옵션이 포함된 차량 보유 중 (삭제 불가능)");
				}
				
			}
		});
		popMenu.add(delItem);
		
		return popMenu;
	}



	protected void do_btnOk_actionPerformed(ActionEvent e) {
		//추가버튼 눌렀을시 실행
		int no = Integer.parseInt(tfNo.getText());
		String name = tfName.getText();
		int price = Integer.parseInt(tfPrice.getText());
		CarOption carOption = new CarOption();
		carOption.setNo(no);
		carOption.setName(name);
		carOption.setPrice(price);
		service.insertCarOption(carOption);
		list = service.selectAllCarOption();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		clearTf();
		
	}
	
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		//취소버튼 눌렀을시 실행
		if(btnOk.getText()=="수정") {
			btnOk.setText("추가");
		}
		clearTf();
	}
	
	private void setItem(CarOption item) {
		tfNo.setText(item.getNo()+"");
		tfName.setText(item.getName());
		tfPrice.setText(item.getPrice()+"");
	}



	private void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		tfPrice.setText("");
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
		CarOption carOption = getItem();
		service.updateCarOption(carOption);
		panelList.setList(service.selectAllCarOption());
		panelList.loadDatas();
		clearTf();
		btnOk.setText("추가");
	}



	private CarOption getItem() {
		int no = Integer.parseInt(tfNo.getText());
		String name = tfName.getText();
		int price = Integer.parseInt(tfPrice.getText());
		CarOption item = new CarOption();
		item.setNo(no);
		item.setName(name);
		item.setPrice(price);
		return item;
	}
}










