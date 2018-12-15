package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Fuel;

@SuppressWarnings("serial")
public class CarTotalList extends AbstractListPanel<CarModel> {
	
	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3/*, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13*/);
		tableSetWidth(100, 100, 100,100/*,100,100,100,100,100,100,100,100,100,100*/);
		
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {
				"차코드","모델명","색상","기어"/*,"브랜드","차종","기본료","6시간","10시간","12시간","12시간이상","연료","렌트여부","렌트횟수"*/
		};
	}

	@Override
	protected Object[] getItemRows(CarModel item) {
		return new Object[] {
				item.getCarCode(),
				item.getName(),
				item.getColor(),
				item.getGear()/*,
				item.getBrand(),
				item.getCarType().getType(),
				item.getBasicCharge(),
				item.getHour6(),
				item.getHour10(),
				item.getHour12(),
				item.getHourElse(),
				item.getFuel().getCode(),
				item.isRent(),
				item.getRentCnt()*/
		};
	}

	@Override
	protected CarModel getItem(int selectedIndex) {
		String code = (String)table.getValueAt(selectedIndex, 0);
		String name = (String)table.getValueAt(selectedIndex, 1);
		String color = (String)table.getValueAt(selectedIndex, 2);
		String gear = (String)table.getValueAt(selectedIndex, 3);
		/*Brand brand = (Brand)table.getValueAt(selectedIndex, 4);
		CarType type = (CarType)table.getValueAt(selectedIndex, 5);
		int basicCharge = (int)table.getValueAt(selectedIndex, 6);
		int hour6 = (int)table.getValueAt(selectedIndex, 7);
		int hour10 = (int)table.getValueAt(selectedIndex, 8);
		int hour12 = (int)table.getValueAt(selectedIndex, 9);
		int hourElse = (int)table.getValueAt(selectedIndex, 10);
		Fuel fuel = (Fuel)table.getValueAt(selectedIndex, 11);
		boolean isRent = ((int)table.getValueAt(selectedIndex, 12)==1?true:false);
		int count = (int)table.getValueAt(selectedIndex, 13);*/
		
		CarModel model = new CarModel();
		
		model.setCarCode(code);
		model.setName(name);
		model.setColor(color);
		model.setGear(gear);
		/*model.setBrand(brand);
		model.setCarType(type);
		model.setBasicCharge(basicCharge);
		model.setHour6(hour6);
		model.setHour10(hour10);
		model.setHour10(hour10);
		model.setHour12(hour12);
		model.setHourElse(hourElse);
		model.setFuel(fuel);
		model.setRent(isRent);
		model.setRentCnt(count);*/
		
		return model;
	}

}











