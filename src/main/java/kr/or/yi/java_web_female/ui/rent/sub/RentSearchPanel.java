package kr.or.yi.java_web_female.ui.rent.sub;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;
import kr.or.yi.java_web_female.ui.rent.RentListPanel;

@SuppressWarnings("serial")
public class RentSearchPanel extends JPanel implements ItemListener, ActionListener {
	private JTextField tfCstmName;
	private RentUIService service;
//	private JComboBox<String> comboBoxCarType;
	private JComboBox<String> cmbCarType;
//	private CarInfoPanel carInfoPanel;
	private List<CarType> carTypeList;
	private List<CarModel> carModelList;
//	private int selectedIndex;
	private RentListPanel rentListPanel;
	private Map<String, String> map;
	private JComboBox<String> cmbCarModel;
	private JButton btnSearch;
	private RentList rentList;


	/**
	 * Create the panel.
	 */
	public RentSearchPanel() {
		service = new RentUIService();
		map = new HashMap<>();
		// is_return을 0으로
		
		initComponents();
	}

	private void initComponents() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAC80\uC0C9", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 3, 5, 5));

		JPanel pCarType = new JPanel();
		add(pCarType);

		JLabel lblCarType = new JLabel("차종 선택");
		pCarType.add(lblCarType);

		////////////////////////////////////////////
		cmbCarType = new JComboBox<>();
		cmbCarType.addItemListener(this);

		carTypeList = service.selectAllCarTypes();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("모든 차종");
		for (CarType ct : carTypeList) {
//			JOptionPane.showMessageDialog(null, r);
			model.addElement(ct.getType());
		}
		cmbCarType.setModel(model);

		pCarType.add(cmbCarType);
		////////////////////////////////////////////

		JPanel pCarModel = new JPanel();
		add(pCarModel);

		JLabel lblCarModel = new JLabel("차량 선택");
		pCarModel.add(lblCarModel);

		//////////////////////////////////////
		cmbCarModel = new JComboBox<>();
		cmbCarModel.addItemListener(this);

		carModelList = service.selectCarModel();
		DefaultComboBoxModel<String> carModel = new DefaultComboBoxModel<>();
		carModel.addElement("모든 차량명");
		for (CarModel cm : carModelList) {
			carModel.addElement(cm.getName());
		}
		cmbCarModel.setModel(carModel);

		pCarModel.add(cmbCarModel);

		////////////////////////////////////

		JPanel pCstm = new JPanel();
		add(pCstm);

		JLabel lblCstmName = new JLabel("고객명");
		pCstm.add(lblCstmName);

		tfCstmName = new JTextField();
		pCstm.add(tfCstmName);
		tfCstmName.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pCstm.add(btnSearch);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbCarType) {
			do_cmbCarType_itemStateChanged(e);
		}
		if (e.getSource() == cmbCarModel) {
			do_cmbCarModel_itemStateChanged(e);
		}
	}

	// 차량명 콤보박스
	private void do_cmbCarModel_itemStateChanged(ItemEvent e) {
		String carModel = (String) cmbCarModel.getSelectedItem();

		if (carModel.equals("모든 차량명")) {
			map.remove("carTypeName");
		} else {
			map.put("carTypeName", carModel);
		}
		filterReLoad();
	}

	// 차종 콤보박스
	protected void do_cmbCarType_itemStateChanged(ItemEvent e) {
		String carType = (String) cmbCarType.getSelectedItem();

		if (carType.equals("모든 차종")) {
			map.remove("carTypeCode");
		} else {
			map.put("carTypeCode", carType);
		}
		filterReLoad();

	}

	// 고객명 검색버튼
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		String name = tfCstmName.getText();
//		JOptionPane.showMessageDialog(null, name);
		
		if(name.equals("")) {
			map.remove("customerName");
		} else{
			map.put("customerName", name);
		}
		filterReLoad();
		tfCstmName.requestFocus();
		tfCstmName.setSelectionStart(0);
	}

	private void filterReLoad() {
		List<Rent> rList = service.FilterRentInfo(map);
		if(rentListPanel != null) {
			rentListPanel.reloadList(rList);
		} else {
			rentList.setList(rList);
			rentList.loadDatas();
			
		}
		
	}

	public void setSelectedCarTypeIndex(int i) {
		cmbCarType.setSelectedIndex(i);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}

	public void setRentList(RentList rentList) {
		this.rentList = rentList;
	}
	
	public void setRentListPanel(RentListPanel rentListPanel) {
		this.rentListPanel = rentListPanel;
		map.put("isReturn", "기본값");
	}


}
