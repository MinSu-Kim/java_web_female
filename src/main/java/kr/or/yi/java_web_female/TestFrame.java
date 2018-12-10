package kr.or.yi.java_web_female;

import javax.swing.JFrame;

import kr.or.yi.java_web_female.ui.ManagerPanel;

@SuppressWarnings("serial")
public class TestFrame extends JFrame {

	private ManagerPanel contentPane;

	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ManagerPanel();
		setContentPane(contentPane);
	}

}
