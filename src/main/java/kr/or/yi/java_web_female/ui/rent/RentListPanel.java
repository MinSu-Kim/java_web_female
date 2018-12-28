package kr.or.yi.java_web_female.ui.rent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;
import kr.or.yi.java_web_female.ui.rent.sub.RentListInfoPanel;
import kr.or.yi.java_web_female.ui.rent.sub.RentSearchPanel;

public class RentListPanel extends JPanel {
	private RentUIService service;
	private List<Rent> list;
	private RentList pList;
	private RentListInfoPanel pRentInfo;
	private RentSearchPanel pSearch;
	
	/**
	 * Create the panel.
	 */
	public RentListPanel() {
		service = new RentUIService();
		initComponents();

	}

	private void initComponents() {
//		reloadList(); pList가 45번라인에서 생성되는데 먼저 호출되면 67라인에서 에러뜨지 않을까?

		pRentInfo = new RentListInfoPanel();
		pRentInfo.setRentListPanel(this);
		pRentInfo.setService(service);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pList = new RentList();
		pSearch = new RentSearchPanel();
		pSearch.setRentListPanel(this);
		pSearch.setSelectedCarTypeIndex(0);
		add(pSearch);
		add(pRentInfo);
		
		
		
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
		add(pList);
		
		reloadList();
	}

	public void reloadList() {
		list = service.selectRentByAll();
		pList.setList(list);
		pList.loadDatas();
	}
	
	public void reloadList(List<Rent> list) {
		pList.setList(list);
		pList.loadDatas();
	}
}
