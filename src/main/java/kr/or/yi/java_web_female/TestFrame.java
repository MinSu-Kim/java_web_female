package kr.or.yi.java_web_female;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.yi.java_web_female.ui.ManagerPanel;

public class TestFrame extends JFrame {

	private ManagerPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ManagerPanel();
		setContentPane(contentPane);
	}

}
