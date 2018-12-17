package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.CarModel;

public class CarUi extends JFrame {

	private JPanel contentPane;
	private CarSelectedPanel panel;
	private CarModel carModel;


	/**
	 * Create the frame.
	 */
	public CarUi() {
		initComponents();
	}
	private void initComponents() {
		setTitle("차량 세부정보관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new CarSelectedPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}
	
	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

}
