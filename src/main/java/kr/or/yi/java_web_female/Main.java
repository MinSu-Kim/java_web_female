package kr.or.yi.java_web_female;

import java.awt.EventQueue;

import kr.or.yi.java_web_female.ui.Brand;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brand frame = new Brand();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
