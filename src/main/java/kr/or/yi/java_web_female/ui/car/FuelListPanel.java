package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.FuelList;

@SuppressWarnings("serial")
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
		setBorder(new TitledBorder(null, "Fuel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		//더블클릭시 구현
		panelList.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Fuel item = panelList.getSelectedItem();
					setItem(item);
					btnOk.setText("수정");
				}
			}
		});
		setLayout(new BorderLayout(0, 0));
		add(panelList, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panel_1.add(panelInput);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
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
				try {
					service.deleteFuel(panelList.getSelectedItem());
					panelList.setList(service.selectAllFuel());
					panelList.loadDatas();
					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
				} catch (PersistenceException e2) {
					JOptionPane.showMessageDialog(null, "해당 연료를 사용하는 차량 보유 중 (삭제 불가능)");//외래키 걸려있지 않기에 다른방법 필요
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
		Fuel item = getItem();
		service.updateFuel(item);
		list = service.selectAllFuel();
		panelList.setList(list);
		panelList.loadDatas();	
		JOptionPane.showMessageDialog(null, "수정되었습니다.");
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
		JOptionPane.showMessageDialog(null, "추가되었습니다.");
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
