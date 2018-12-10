package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class CarManagementUi extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public CarManagementUi() {
		setTitle("차량관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelComboBox = new JPanel();
		contentPane.add(panelComboBox, BorderLayout.NORTH);
		panelComboBox.setLayout(new GridLayout(0, 2, 0, 0));
		
		ComboPanel panelCarType = new ComboPanel();
		panelComboBox.add(panelCarType);
		
		ComboPanel panelBrand = new ComboPanel();
		panelComboBox.add(panelBrand);
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.CENTER);
		panel1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel2 = new JPanel();
		panel1.add(panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JList list = new JList();
		panel2.add(list);
		
		JPanel panel3 = new JPanel();
		panel1.add(panel3);
		
		JPanel panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnUpdate = new JButton("수정");
		panelBtn.add(btnUpdate);
		
		JButton btndelete = new JButton("삭제");
		panelBtn.add(btndelete);
		
		JButton btnCancel = new JButton("취소");
		panelBtn.add(btnCancel);
	}

}
