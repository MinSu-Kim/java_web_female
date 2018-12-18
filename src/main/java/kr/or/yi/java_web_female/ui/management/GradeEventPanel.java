package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GradeEventPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GradeEventPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		GradeListPanel panelGrade = new GradeListPanel();
		panel.add(panelGrade);
		
		EventListPanel panelEvent = new EventListPanel();
		panel.add(panelEvent);

	}

}
