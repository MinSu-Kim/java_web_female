package kr.or.yi.java_web_female.ui.rent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import kr.or.yi.java_web_female.ui.rent.sub.RentSearchPanel;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;

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
