package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.service.RentUIService;

import javax.swing.UIManager;
import java.awt.Color;

public class RentSearchPanel extends JPanel {
	private JTextField tfCstmName;
	private RentUIService service;
	private JComboBox<String> comboBoxCarType;

	
	/**
	 * Create the panel.
	 */
	public RentSearchPanel() {
		service = new RentUIService();
		initComponents();
	}

	private void initComponents() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel pCarType = new JPanel();
		add(pCarType);
		
		JLabel lblCarType = new JLabel("차종 선택");
		pCarType.add(lblCarType);
		
		////////////////////////////////////////////
		JComboBox cmbCarType = new JComboBox();
		
		List<CarType> list = service.selectAllCarTypes();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		for(CarType ct : list) {
			model.addElement(ct.getType());
		}
		
		cmbCarType.setModel(model);
		pCarType.add(cmbCarType);
		////////////////////////////////////////////
			
		JPanel pCarModel = new JPanel();
		add(pCarModel);
		
		JLabel lblCarModel = new JLabel("차량 선택");
		pCarModel.add(lblCarModel);
		
		JComboBox cmbCarModel = new JComboBox();
		
		List<CarModel> carModelList = service.selectCarModel();
		DefaultComboBoxModel<String> carModel = new DefaultComboBoxModel<>();
		for(CarModel cm : carModelList) {
			carModel.addElement(cm.getName());
		}
		cmbCarModel.setModel(carModel);
		pCarModel.add(cmbCarModel);
		
		JPanel pCstm = new JPanel();
		add(pCstm);
		
		JLabel lblCstmName = new JLabel("고객명");
		pCstm.add(lblCstmName);
		
		tfCstmName = new JTextField();
		pCstm.add(tfCstmName);
		tfCstmName.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		pCstm.add(btnSearch);
	}

}
