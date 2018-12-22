package kr.or.yi.java_web_female.chart_frame;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChartTotalPanel extends JPanel implements ActionListener {
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public ChartTotalPanel() {

		initComponents();
	}
	private void initComponents() {
		
		JPanel panel = new JPanel();
		add(panel);
		
		btnNewButton = new JButton("차량별 통계");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		ChartMain frame = new ChartMain();
		frame.setVisible(true);
	}
}
