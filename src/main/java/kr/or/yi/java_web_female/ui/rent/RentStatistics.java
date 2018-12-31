package kr.or.yi.java_web_female.ui.rent;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import kr.or.yi.java_web_female.chart_panel.RentStatisticsPanel;

public class RentStatistics extends JPanel {

	/**
	 * Create the panel.
	 */
	public RentStatistics() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		RentStatisticsPanel panel = new RentStatisticsPanel();
		add(panel);

	}

}
