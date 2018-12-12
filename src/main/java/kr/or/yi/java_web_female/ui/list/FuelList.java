package kr.or.yi.java_web_female.ui.list;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Fuel;

public class FuelList extends AbstractListPanel<Fuel> {

	/**
	 * Create the panel.
	 */
	public FuelList() {

	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0);
		tableSetWidth(100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"연료"};
	}

	@Override
	protected Object[] getItemRows(Fuel item) {
		return new Object[] {
				item.getCode()
		};
	}

	@Override
	protected Fuel getItem(int selectedIndex) {
		String code = (String)table.getValueAt(selectedIndex, 0);
		Fuel fuel = new Fuel();
		fuel.setCode(code);
		return fuel;
	}

}
