package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;

public class CarManagementUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
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

	/**
	 * Create the frame.
	 */
	public CarManagementUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		
		CarTypeListPanel panelCarType = new CarTypeListPanel();
		panel.add(panelCarType);
		
		BrandListPanel panelBrand = new BrandListPanel();
		panel.add(panelBrand);
		
		FuelListPanel panelFuel = new FuelListPanel();
		panel.add(panelFuel);
		
		CarOptionListPanel panelCarOption = new CarOptionListPanel();
		panel.add(panelCarOption);
	}

}
