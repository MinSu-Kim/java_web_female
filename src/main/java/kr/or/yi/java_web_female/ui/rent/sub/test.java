package kr.or.yi.java_web_female.ui.rent.sub;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.service.RentUIService;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		RentUIService service = new RentUIService();
		CarInfoPanel panel_1 = new CarInfoPanel(service);
		contentPane.add(panel_1);
		
		InsurancePanel panel = new InsurancePanel(service);
		contentPane.add(panel);
		
		OptionInfoPanel panel_2 = new OptionInfoPanel((RentUIService) null);
		contentPane.add(panel_2);
	}

}
