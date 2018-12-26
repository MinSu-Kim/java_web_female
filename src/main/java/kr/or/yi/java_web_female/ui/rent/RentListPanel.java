package kr.or.yi.java_web_female.ui.rent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RentListPanel extends JPanel {
	private RentUIService service;
	private List<Rent> list;
	private RentList pList;
	
	/**
	 * Create the panel.
	 */
	public RentListPanel() {
		service = new RentUIService();
		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(5, 5));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(10, 10));
		
		pList = new RentList();
		list = service.selectRentByAll();
		pList.setList(list);
		pList.loadDatas();
		add(pList, BorderLayout.CENTER);
	}
}
