package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CarUpdateUi extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfBrand;
	private JTextField tfCarType;
	private JTextField tfFuel;
	private JTextField tfOption;


	/**
	 * Create the frame.
	 */
	public CarUpdateUi() {
		setTitle("차량 정보 수정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_img = new JPanel();
		panel.add(panel_img);
		
		JPanel panel_info = new JPanel();
		panel.add(panel_info);
		panel_info.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("모델명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_info.add(lblName);
		
		tfName = new JTextField();
		panel_info.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblBrand = new JLabel("브랜드");
		lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
		panel_info.add(lblBrand);
		
		tfBrand = new JTextField();
		panel_info.add(tfBrand);
		tfBrand.setColumns(10);
		
		JLabel lblCarType = new JLabel("차종");
		lblCarType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_info.add(lblCarType);
		
		tfCarType = new JTextField();
		tfCarType.setColumns(10);
		panel_info.add(tfCarType);
		
		JLabel lblFuel = new JLabel("연료");
		lblFuel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_info.add(lblFuel);
		
		tfFuel = new JTextField();
		tfFuel.setColumns(10);
		panel_info.add(tfFuel);
		
		JLabel lblOption = new JLabel("옵션");
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		panel_info.add(lblOption);
		
		tfOption = new JTextField();
		panel_info.add(tfOption);
		tfOption.setColumns(10);
	}

}
