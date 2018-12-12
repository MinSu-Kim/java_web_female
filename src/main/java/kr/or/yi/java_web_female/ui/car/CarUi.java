package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.CarOptionList;

public class CarUi extends JFrame {

	private CarOptionList contentPane;
	private CarUiService service;
	/*private List<CarOption> list;*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarUi frame = new CarUi();
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
	public CarUi() {
		service = new CarUiService();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new CarOptionList();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	

}

















