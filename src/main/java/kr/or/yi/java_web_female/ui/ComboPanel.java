package kr.or.yi.java_web_female.ui;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComboPanel<T> extends JPanel {

	private JLabel lblTitle;
	private JComboBox<T> comboBox;

	/**
	 * Create the panel.
	 */
	public ComboPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		lblTitle = new JLabel("name");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		comboBox = new JComboBox<>();
		add(comboBox);

	}
	public void setTitle(String title) {
		lblTitle.setText(title);
	}
	
	public void setComboItems(List<T> items) {
		DefaultComboBoxModel<T> model = new DefaultComboBoxModel<>(new Vector<T>(items));
		comboBox.setModel(model);
	}
}
