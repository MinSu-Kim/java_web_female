package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Customer;

public class CustmConfirmTable extends AbstractListPanel<Customer> {

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(150, 150, 150, 150, 150);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"고객번호", "고객명", "고객등급", "연락처", "이메일"};
	}

	@Override
	protected Object[] getItemRows(Customer item) {
		return new Object[] {
				item.getCode(), item.getName(), item.getGradeCode(), item.getPhone(), item.getEmail()
		};
	}

	@Override
	protected Customer getItem(int selectedIndex) {
		String code = (String) table.getValueAt(selectedIndex, 0);
		String name = (String) table.getValueAt(selectedIndex, 1);
		Customer customer = new Customer();
		customer.setCode(code);
		customer.setName(name);
		return customer;
	}

}
