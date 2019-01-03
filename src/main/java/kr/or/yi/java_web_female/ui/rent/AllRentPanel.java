package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;
import kr.or.yi.java_web_female.ui.rent.sub.RentListInfoPanel;
import kr.or.yi.java_web_female.ui.rent.sub.RentSearchPanel;

@SuppressWarnings("serial")
public class AllRentPanel extends JPanel {
	private RentUIService service;
	private List<Rent> list;
	private RentList pList;
	private RentSearchPanel pSearch;
	private RentListInfoPanel rentListInfoPanel;
	private RentListPanel rentListPanel;
	
	public void setRentListPanel(RentListPanel rentListPanel) {
		this.rentListPanel = rentListPanel;
	}

	public void setRentListInfoPanel(RentListInfoPanel rentListInfoPanel) {
		this.rentListInfoPanel = rentListInfoPanel;
	}

	/**
	 * Create the panel.
	 */
	public AllRentPanel() {
		service = new RentUIService();
		initComponents();

	}

	private void initComponents() {
		service.selectRentByAll();
		
		setLayout(new BorderLayout(0, 0));
		
		pList = new RentList();
		pSearch = new RentSearchPanel();
		pSearch.setRentList(pList);
		
		reloadList();
		
		add(pSearch, BorderLayout.NORTH);
		add(pList, BorderLayout.CENTER);
	}

	public void reloadList() {
		list = service.selectRentAll();
		pList.setList(list);
		pList.loadDatas();
	}

}
