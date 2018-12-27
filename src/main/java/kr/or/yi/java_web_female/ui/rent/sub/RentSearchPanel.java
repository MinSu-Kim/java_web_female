package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class RentSearchPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RentSearchPanel() {
		setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("차량명");
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("고객명");
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		panel_1.add(btnNewButton);

	}

}
