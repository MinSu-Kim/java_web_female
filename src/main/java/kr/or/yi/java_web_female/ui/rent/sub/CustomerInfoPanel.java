package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.CustomerSearchFrame;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class CustomerInfoPanel extends CarSubPanel implements ActionListener {
	private JTextField tfCstmName;
	private Customer rentCustomer;
	private JButton btnCstmSearch;
	private CustomerSearchFrame cf; // 고객확인프레임
	
	public void setRentCustomer(Customer rentCustomer) {
		this.rentCustomer = rentCustomer;
		
		//고객 정보가 들어오는 지 확인하기
		JOptionPane.showMessageDialog(null, "선택된 고객 " + rentCustomer);
	}
	
	/**
	 * Create the panel.
	 */
	public CustomerInfoPanel(RentUIService service) {
		super(service);
		initComponents();
	}
	private void initComponents() {
		setBorder(new TitledBorder(null, "\uAC1C\uC778 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCstmName = new JLabel("고객명");
		add(lblCstmName);
		
		tfCstmName = new JTextField();
		add(tfCstmName);
		tfCstmName.setColumns(10);
		
		btnCstmSearch = new JButton("검색");
		btnCstmSearch.addActionListener(this);
		add(btnCstmSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCstmSearch) {
			do_btnCstmSearch_actionPerformed(e);
		}
	}
	
	//고객명 검색버튼
	protected void do_btnCstmSearch_actionPerformed(ActionEvent e) {
		Customer customer = new Customer();
		if (cf == null) {
			if (tfCstmName.getText().trim().length() > 1) {
				customer.setName(tfCstmName.getText().trim());
			} else {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
			}
			try {
				List<Customer> cList = service.selectCustomer(customer);
				if (cList.size() > 1) {
					cf = new CustomerSearchFrame();
					cf.setCustomerInfoPanel(this);
					cf.setcList(cList);
					cf.setVisible(true);
				} else {
					setRentCustomer(cList.get(0));
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			if (tfCstmName.getText().trim().length() > 1) {
				customer.setName(tfCstmName.getText().trim());
			} else {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
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
}
