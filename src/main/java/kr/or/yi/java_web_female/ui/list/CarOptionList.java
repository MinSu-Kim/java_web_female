package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.CarOption;

@SuppressWarnings("serial")
public class CarOptionList extends AbstractListPanel<CarOption> {

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidth(100, 100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"옵션번호","옵션명","옵션비용"};
	}

	@Override
	protected Object[] getItemRows(CarOption item) {
		return new Object[] {
				item.getNo(),item.getName(),item.getPrice()
		};
	}

	@Override
	protected CarOption getItem(int selectedIndex) {
/*		int no = (int)table.getValueAt(selectedIndex, 0);
		String name = (String)table.getValueAt(selectedIndex, 1);
		CarOption carOption = new CarOption();
		carOption.setNo(no);
		carOption.setName(name);
		return carOption;*/
		return list.get(selectedIndex);
	}

}
