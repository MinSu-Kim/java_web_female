package kr.or.yi.java_web_female.ui.rent.sub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.login.LoginUI;
import kr.or.yi.java_web_female.ui.rent.CustomerSearchFrame;
import kr.or.yi.java_web_female.ui.rent.RentPanel;

@SuppressWarnings("serial")
public class CustomerInfoPanel extends CarSubPanel implements ActionListener {
	private JTextField tfCstmName;
	private Customer rentCustomer;
	private JButton btnCstmSearch;
	private CustomerSearchFrame cf; // 고객확인프레임
	private RentPanel rentPanel;
	
	public void setRentPanel(RentPanel rentPanel) {
		this.rentPanel = rentPanel;
	}

	public void setRentCustomer(Customer rentCustomer) {
		//code로 검색.
		this.rentCustomer = service.selectCustomerByCode(rentCustomer).get(0);
		//this.rentCustomer = rentCustomer;
		

		// 고객 정보가 들어오는 지 확인하기
/*		JOptionPane.showMessageDialog(null, "선택된 고객 " + this.rentCustomer);
		JOptionPane.showMessageDialog(null, "rentPanel " + rentPanel);*/
		rentPanel.setSelectedCustomer(this.rentCustomer);
	}

	/**
	 * Create the panel.
	 */
	public CustomerInfoPanel(RentUIService service) {
		super(service);
		initComponents();
	}

	private void initComponents() {
		setBorder(new TitledBorder(null, "\uAC1C\uC778 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));

		JLabel lblCstmName = new JLabel("고객명");
		add(lblCstmName);

		tfCstmName = new JTextField();
		tfCstmName.setColumns(10);
		
		add(tfCstmName);
		
		if(LoginUI.loginCusotmer == null) {
			tfCstmName.setText("김영희");
			btnCstmSearch = new JButton("검색");
			btnCstmSearch.addActionListener(this);
			add(btnCstmSearch);
			
		} else {
			tfCstmName.setText(LoginUI.loginCusotmer.getName());
			tfCstmName.setEditable(false);
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCstmSearch) {
			do_btnCstmSearch_actionPerformed(e);
		}
	}

	// 고객명 검색버튼
	protected void do_btnCstmSearch_actionPerformed(ActionEvent e) {
		Customer customer = new Customer();
		if (tfCstmName.getText().trim().length() > 1) {
			customer.setName(tfCstmName.getText().trim());
		} else {
			JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
		}

		if (cf == null) {
			cf = new CustomerSearchFrame();
		}
		try {
			
			List<Customer> cList = service.selectCustomer(customer);
			if (cList.size() > 1) {

				cf.setCustomerInfoPanel(this);
				cf.setcList(cList);
				cf.setVisible(true);
			} else {
				setRentCustomer(cList.get(0));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
