package kr.or.yi.java_web_female.ui.list;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Employee;

public class EmployeeList extends AbstractListPanel<Employee> {
	public EmployeeList() {

	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidth(100, 100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "직원코드", "직원명", "연락처" };
	}

	@Override
	protected Object[] getItemRows(Employee item) {
		return new Object[] { item.getCode(), item.getName(), item.getPhone() };
	}

	@Override
	protected Employee getItem(int selectedIndex) {
		// TODO Auto-generated method stub
		return list.get(selectedIndex);
	}

}
