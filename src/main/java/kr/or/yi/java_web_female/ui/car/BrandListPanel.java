package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.BrandList;

public class BrandListPanel extends JPanel implements ActionListener {
	private JTextField tfNo;
	private JTextField tfName;
	private CarUiService service;
	private List<Brand> list;
	private BrandList panelList;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Create the panel.
	 */
	public BrandListPanel() {
		setBorder(new TitledBorder(null, "Brand", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new CarUiService();
		initcomponent();
	}

	private void initcomponent() {
		
		panelList = new BrandList();
		list = service.selectAllBrand();
		panelList.setList(list);
		panelList.loadDatas();
		setLayout(new BorderLayout(0, 0));
		add(panelList);
		
		panelList.setPopupMenu(createDeptPopupMenu());
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panel.add(panelInput);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("브랜드번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblNo);
		
		tfNo = new JTextField();
		panelInput.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("브랜드명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblName);
		
		tfName = new JTextField();
		panelInput.add(tfName);
		tfName.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		panelBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panelBtn.add(btnCancel);
	}

	private JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		//수정
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Brand item = panelList.getSelectedItem();
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
					service.deleteBrand(panelList.getSelectedItem());
					panelList.setList(service.selectAllBrand());
					panelList.loadDatas();
				} catch (PersistenceException e2) {
					JOptionPane.showMessageDialog(null, "해당 브랜드에 속하는 차량을 보유 중 (삭제 불가능)");
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
		Brand item = getItem();
		service.updateBrand(item);
		panelList.setList(service.selectAllBrand());
		panelList.loadDatas();
		clearTf();
		btnOk.setText("추가");
	}

	protected void do_btnOk_actionPerformed(ActionEvent e) {
		Brand brand = getItem();
		service.insertBrand(brand);
		list = service.selectAllBrand();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		clearTf();
	}
	
	private void setItem(Brand item) {
		tfNo.setText(item.getNo());
		tfName.setText(item.getName());
	}

	private Brand getItem() {
		String no = tfNo.getText();
		String name = tfName.getText();
		Brand brand = new Brand();
		brand.setNo(no);
		brand.setName(name);
		return brand;
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		if(btnOk.getText()=="수정") {
			btnOk.setText("추가");
		}
		clearTf();
	}

	private void clearTf() {
		tfNo.setText("");
		tfName.setText("");
	}
}
