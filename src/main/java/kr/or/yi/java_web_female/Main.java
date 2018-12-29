package kr.or.yi.java_web_female;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import kr.or.yi.java_web_female.ui.login.LoginUI;

public class Main {

	public static void main(String[] args) {	
		// 룩앤필 변경
/*		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				|
				UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}*/
/*		try {
		    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		*/
		 try {
	            // select Look and Feel
	            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
	            // start application
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }

			
/*		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		*
		*/
		
		
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
