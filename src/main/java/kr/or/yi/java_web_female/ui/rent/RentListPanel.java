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
//		reloadList();

		pRentInfo = new RentListInfoPanel();
		pRentInfo.setRentListPanel(this);
		pRentInfo.setService(service);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pSearch = new RentSearchPanel();
		add(pSearch);
		add(pRentInfo);
		
		pList = new RentList();
		
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
	}

	public void reloadList() {
		list = service.selectRentByAll();
		pList.setList(list);
		pList.loadDatas();
	}
	

}
