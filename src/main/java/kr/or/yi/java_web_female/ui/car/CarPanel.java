package kr.or.yi.java_web_female.ui.car;

import javax.swing.JPanel;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.service.CarUiService;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import kr.or.yi.java_web_female.ui.list.CarTotalList;
import kr.or.yi.java_web_female.ui.ComboPanel;
import kr.or.yi.java_web_female.ui.list.CarOptionList;
import kr.or.yi.java_web_female.ui.list.CarModelListPanel;

@SuppressWarnings("serial")
public class CarPanel extends JPanel {
	private JTextField tfName;
	private JTextField tfCode;
	private CarUiService service;


	public CarPanel() {
		service = new CarUiService();
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSelect = new JPanel();
		add(panelSelect, BorderLayout.NORTH);
		panelSelect.setLayout(new GridLayout(0, 2, 0, 0));
		
		ComboPanel<CarType> panelCarType = new ComboPanel<>();
		panelCarType.setTitle("차종");
		List<CarType> arr = service.selectAllCarType();
		
		//콤보박스에 차종 불러오기
		panelCarType.setComboItems(arr);
		panelSelect.add(panelCarType);
		
		ComboPanel<Brand> panelBrand = new ComboPanel<>();
		panelBrand.setTitle("브랜드");
		List<Brand> arrBrand = service.selectAllBrand();
		//콤보박스에 브랜드 불러오기
		panelBrand.setComboItems(arrBrand);
		panelSelect.add(panelBrand);
		
		JPanel panelName = new JPanel();
		panelSelect.add(panelName);
		panelName.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelName.add(lblName);
		
		tfName = new JTextField();
		panelName.add(tfName);
		tfName.setColumns(10);
		
		JPanel panelCode = new JPanel();
		panelSelect.add(panelCode);
		panelCode.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("CarCode");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panelCode.add(lblCode);
		
		tfCode = new JTextField();
		panelCode.add(tfCode);
		tfCode.setColumns(10);
		
		CarTotalList panel = new CarTotalList();
		add(panel, BorderLayout.CENTER);
		
		
		JPanel panelBtn = new JPanel();
		add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("선택");
		panelBtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		panelBtn.add(btnCancel);
	}

}
