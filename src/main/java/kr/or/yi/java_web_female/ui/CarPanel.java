package kr.or.yi.java_web_female.ui;

import javax.swing.JPanel;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarType;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import kr.or.yi.java_web_female.ui.list.CarPanelList;

@SuppressWarnings("serial")
public class CarPanel extends JPanel {
	private JTextField tfName;
	private JTextField tfCode;

	public CarPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSelect = new JPanel();
		add(panelSelect, BorderLayout.NORTH);
		panelSelect.setLayout(new GridLayout(0, 2, 0, 0));
		
		ComboPanel<CarType> panelCarType = new ComboPanel<>();
		panelCarType.setTitle("CarType");
		List<CarType> arr = new ArrayList<>();

		panelSelect.add(panelCarType);
		
		ComboPanel<Brand> panelBrand = new ComboPanel<>();
		panelBrand.setTitle("Brand");
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
		
		
		JPanel panelBtn = new JPanel();
		add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("선택");
		panelBtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		panelBtn.add(btnCancel);
		
		CarPanelList panel = new CarPanelList();
		add(panel, BorderLayout.CENTER);

	}

}
