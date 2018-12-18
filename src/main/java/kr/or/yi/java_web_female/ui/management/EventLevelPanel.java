package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;

public class EventLevelPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EventLevelPanel() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("추가");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_3.add(btnNewButton_1);

	}

}
