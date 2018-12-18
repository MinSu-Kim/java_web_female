package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GradeEventMngPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GradeEventMngPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		GradePanel panelGrade = new GradePanel();
		panel.add(panelGrade);
		
		EventPanel panelEvent = new EventPanel();
		panel.add(panelEvent);

	}

}
