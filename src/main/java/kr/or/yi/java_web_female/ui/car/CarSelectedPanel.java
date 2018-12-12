package kr.or.yi.java_web_female.ui.car;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class CarSelectedPanel extends JPanel {

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
