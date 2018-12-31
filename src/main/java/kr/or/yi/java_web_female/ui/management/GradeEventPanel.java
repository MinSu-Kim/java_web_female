package kr.or.yi.java_web_female.ui.management;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.yi.java_web_female.service.GradeEventUiService;

@SuppressWarnings("serial")
public class GradeEventPanel extends JPanel {

	private GradeEventUiService service;

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
