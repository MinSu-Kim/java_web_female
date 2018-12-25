package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Customer;

@SuppressWarnings("serial")
public class CustomConfirmTable extends AbstractListPanel<Customer> {
	public CustomConfirmTable() {
	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(100, 100, 100, 200, 200);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"고객번호", "고객명", "고객등급", "연락처", "이메일"};
	}

	@Override
	protected Object[] getItemRows(Customer item) {
		return new Object[] {
				item.getCode(), item.getName(), item.getGradeCode().getCode(), item.getPhone(), item.getEmail()
		};
	}

	@Override
	protected Customer getItem(int selectedIndex) {
		return list.get(selectedIndex);
	}

}
