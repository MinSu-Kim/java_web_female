
package kr.or.yi.java_web_female;

import java.awt.EventQueue;

import javax.swing.UIManager;

import kr.or.yi.java_web_female.ui.login.LoginUI;

public class Main {

	public static void main(String[] args) {

		try {
			// select Look and Feel
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			// start application
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}




































