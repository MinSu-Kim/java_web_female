package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Fuel;

@SuppressWarnings("serial")
public class FuelList extends AbstractListPanel<Fuel> {

	public FuelList() {

	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableSetWidth(100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "번호", "연료" };
	}

	@Override
	protected Object[] getItemRows(Fuel item) {
		return new Object[] { item.getNo(), item.getCode() };
	}

	@Override
	protected Fuel getItem(int selectedIndex) {
		int no = (int) table.getValueAt(selectedIndex, 0);
		String code = (String) table.getValueAt(selectedIndex, 1);
		Fuel fuel = new Fuel();
		fuel.setCode(code);
		fuel.setNo(no);
		return fuel;
	}

}
