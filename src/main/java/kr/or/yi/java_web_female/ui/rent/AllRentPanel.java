package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;
import kr.or.yi.java_web_female.ui.rent.sub.RentSearchPanel;

@SuppressWarnings("serial")
public class AllRentPanel extends JPanel {
	private RentUIService service;
	
	/**
	 * Create the panel.
	 */
	public AllRentPanel() {
		service = new RentUIService();
		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		RentList pList = new RentList();
		
		RentSearchPanel pSearch = new RentSearchPanel();
		pSearch.setRentList(pList);
		
		
		List<Rent> list = service.selectRentAll();
		pList.setList(list);
		pList.loadDatas();
		
		add(pSearch, BorderLayout.NORTH);
		add(pList, BorderLayout.CENTER);
	}

}
