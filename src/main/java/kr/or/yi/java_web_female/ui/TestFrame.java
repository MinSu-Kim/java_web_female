package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarType;

public class TestFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ComboPanel<Brand> panel = new ComboPanel<>();
		panel.setTitle("Brand");
		List<Brand> arr = new ArrayList<>();
		Brand b1 = new Brand();
		b1.setNo("B4");
		b1.setName("GM");
		
		Brand b2 = new Brand();
		b2.setNo("B5");
		b2.setName("르노");
		
		arr.add(b1);
		arr.add(b2);
		
		panel.setComboItems(arr);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ComboPanel<CarType> pCarType = new ComboPanel<>();
		pCarType.setTitle("CarType");
		List<CarType> arr2 = new ArrayList<>();
		
		CarType carType = new CarType();
		carType.setCode("S7");
		carType.setType("버스");
		
		CarType carType2 = new CarType();
		carType2.setCode("S8");
		carType2.setType("버스2");
		
		arr2.add(carType);
		arr2.add(carType2);
		
		pCarType.setComboItems(arr2);
		
		contentPane.add(pCarType, BorderLayout.SOUTH);
		contentPane.add(panel, BorderLayout.CENTER);
	}

}














