package kr.or.yi.java_web_female.ui.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.Customer;

public class CustomerUi extends JFrame {

	private JPanel contentPane;
	private boolean isAdd;
	private CustommerListPannel custommerListPannel;

	public CustomerUi(boolean isAdd) {
		this.isAdd = isAdd;
		initComponents();
	}

	private void initComponents() {
		if(isAdd) {
			setTitle("차량정보추가");
		}else {
			setTitle("차량 세부정보관리");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void setCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void setCustomerPanel(CustommerListPannel custommerListPannel) {
		// TODO Auto-generated method stub
		
	}

	public void reloadDataCarPanel() {
		//custommerListPannel.setLoadDatas();
		
	}



}
