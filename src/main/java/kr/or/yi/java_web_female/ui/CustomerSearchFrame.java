package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;
import kr.or.yi.java_web_female.ui.list.CustmConfirmTable;

public class CustomerSearchFrame extends JFrame {

	private JPanel contentPane;
	private AbstractListPanel<Customer> cPanel;
	private List<Customer> cList;
	private RentPanel rentPanel;

	
	public void setcList(List<Customer> cList) {
		this.cList = cList;
		cPanel.setList(cList);
		cPanel.loadDatas();
	}

	/**
	 * Create the frame.
	 */
	public CustomerSearchFrame() {
		initComponents();
	}


	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("고객 확인");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		cPanel = new CustmConfirmTable();
		cPanel.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Customer i = cPanel.getSelectedItem();
				rentPanel.setRentCustomer(i);
				CustomerSearchFrame.this.dispose();
			}
			
		});
		
		contentPane.add(cPanel, BorderLayout.CENTER);
	}

	public void setRentPanel(RentPanel rentPanel) {
		this.rentPanel = rentPanel;
	}

}
