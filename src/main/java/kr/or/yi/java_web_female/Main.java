package kr.or.yi.java_web_female;

import java.awt.EventQueue;

import kr.or.yi.java_web_female.ui.CarManagementUi;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarManagementUi frame = new CarManagementUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
