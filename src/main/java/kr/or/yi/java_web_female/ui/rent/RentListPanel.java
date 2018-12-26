package kr.or.yi.java_web_female.ui.rent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import kr.or.yi.java_web_female.ui.rent.sub.RentListInfoPanel;

public class RentListPanel extends JPanel {
	private RentUIService service;
	private List<Rent> list;
	private RentList pList;
	private RentListInfoPanel pRentInfo;
	
	/**
	 * Create the panel.
	 */
	public RentListPanel() {
		service = new RentUIService();
		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(5, 5));
		
		pList = new RentList();
		reloadList();

		pRentInfo = new RentListInfoPanel();
		
		/////////////////////
		pList.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					///////////////
					Rent item = pList.getSelectedItem();
					pRentInfo.setRent(item);
				}
			}
			
		});
		add(pRentInfo, BorderLayout.NORTH);
		add(pList, BorderLayout.CENTER);
	}

	public void reloadList() {
		list = service.selectRentByAll();
		pList.setList(list);
		pList.loadDatas();
	}
	
	

}
