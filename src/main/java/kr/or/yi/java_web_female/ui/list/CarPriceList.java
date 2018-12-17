package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.CarModel;

public class CarPriceList extends AbstractListPanel<CarModel> {

	public CarPriceList() {

	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(100, 100, 100, 100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"기본비용","6시간","10시간","12시간","12시간초과"};
	}

	@Override
	protected Object[] getItemRows(CarModel item) {
		return new Object[] {
				item.getBasicCharge(),item.getHour6(),item.getHour10(),item.getHour12(),item.getHourElse()
		};
	}

	@Override
	protected CarModel getItem(int selectedIndex) {
		int basicCharge = (int)table.getValueAt(selectedIndex, 0);
		int hour6 = (int)table.getValueAt(selectedIndex, 1);
		int hour10 = (int)table.getValueAt(selectedIndex, 2);
		int hour12 = (int)table.getValueAt(selectedIndex, 3);
		int hourElse = (int)table.getValueAt(selectedIndex, 4);
		
		CarModel model = new CarModel();
		model.setBasicCharge(basicCharge);
		model.setHour6(hour6);
		model.setHour10(hour10);
		model.setHour12(hour12);
		model.setHourElse(hourElse);
		return model;
	}

}






















