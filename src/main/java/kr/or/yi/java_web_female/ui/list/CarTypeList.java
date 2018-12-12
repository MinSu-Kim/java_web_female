package kr.or.yi.java_web_female.ui.list;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.CarType;

public class CarTypeList extends AbstractListPanel<CarType> {



	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableSetWidth(100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"차종코드","차량유형"};
	}

	@Override
	protected Object[] getItemRows(CarType item) {
		return new Object[] {
				item.getCode(),item.getType()
		};
	}

	@Override
	protected CarType getItem(int selectedIndex) {
		String code = (String)table.getValueAt(selectedIndex, 0);
		String type = (String)table.getValueAt(selectedIndex, 1);
		CarType carType = new CarType();
		carType.setCode(code);
		carType.setType(type);
		return carType;
	}

}
