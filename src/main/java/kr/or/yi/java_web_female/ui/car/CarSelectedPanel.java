package kr.or.yi.java_web_female.ui.car;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import kr.or.yi.java_web_female.ui.ComboPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import kr.or.yi.java_web_female.ui.list.CarPriceList;

public class CarSelectedPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public CarSelectedPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_img = new JPanel();
		panel_2.add(panel_img);
		
		JPanel panel_info = new JPanel();
		panel_2.add(panel_info);
		panel_info.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelCode = new JPanel();
		panel_info.add(panelCode);
		panelCode.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("차량코드");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCode.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		panelCode.add(textField);
		textField.setColumns(10);
		
		JPanel panelName = new JPanel();
		panel_info.add(panelName);
		panelName.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("모델명");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelName.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panelName.add(textField_1);
		textField_1.setColumns(10);
		
		
		ComboPanel panelBrand = new ComboPanel();
		panelBrand.setTitle("브랜드");
		panel_info.add(panelBrand);
		
		ComboPanel panelCarType = new ComboPanel();
		panelCarType.setTitle("차종");
		panel_info.add(panelCarType);
		
		CarPriceList panelPrice = new CarPriceList();
		panel_info.add(panelPrice);
		
		JPanel panelRentCnt = new JPanel();
		panel_info.add(panelRentCnt);
		panelRentCnt.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelRentCnt.add(lblNewLabel);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnUpdate = new JButton("수정");
		panelBtn.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		panelBtn.add(btnDelete);
		
		JButton btnCancel = new JButton("취소");
		panelBtn.add(btnCancel);

	}

}
