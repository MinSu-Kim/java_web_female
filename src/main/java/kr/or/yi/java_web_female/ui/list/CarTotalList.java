package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.CarModel;

@SuppressWarnings("serial")
public class CarTotalList extends AbstractListPanel<CarModel> {
	
	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8/*, 9, 10, 11, 12, 13*/);
		tableSetWidth(100, 100, 100,100,100,100,100,100,100/*,100,100,100,100,100*/);
		
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {
				"차코드","모델명","색상","기어","브랜드","차종"/*,"기본료","6시간","10시간","12시간","12시간이상"*/,"연료","렌트여부","렌트횟수"
		};
	}

	@Override
	protected Object[] getItemRows(CarModel item) {
		return new Object[] {
				item.getCarCode(),
				item.getName(),
				item.getColor(),
				item.getGear(),
				item.getBrand().getName(),
				item.getCarType().getType(),
				/*item.getBasicCharge(),
				item.getHour6(),
				item.getHour10(),
				item.getHour12(),
				item.getHourElse(),*/
				item.getFuel(),
				item.isRent()==true?"대여중":"대여가능",
				item.getRentCnt()
		};
	}

	@Override
	public CarModel getItem(int selectedIndex) {
/*		String carCode = (String)table.getValueAt(selectedIndex, 0);
		CarModel carModel = new CarModel(carCode);
		int index = list.indexOf(carModel);
		System.out.println(selectedIndex +":"+index);
		return list.get(index);*/
		return list.get(selectedIndex);
	}

}