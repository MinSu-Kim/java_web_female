package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.CarModel;

@SuppressWarnings("serial")
public class CarModelListPanel extends AbstractListPanel<CarModel> {

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		tableSetWidth(100, 100, 100, 100, 100, 100, 100);

	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "번호", "이름", "색상", "변속기", "브랜드", "기본비용", "연료" };
	}

	@Override
	protected Object[] getItemRows(CarModel item) {
		return new Object[] { item.getCarCode(), item.getName(), item.getColor(), item.getGear(),
				item.getBrand().getName(), item.getBasicCharge(), item.getFuel().getCode() };
	}

	@Override
	protected CarModel getItem(int selectedIndex) {
		return list.get(selectedIndex);
	}


}
