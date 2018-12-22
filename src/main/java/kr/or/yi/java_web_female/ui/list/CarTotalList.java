package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import kr.or.yi.java_web_female.dto.CarModel;

@SuppressWarnings("serial")
public class CarTotalList extends AbstractListPanel<CarModel> {
	
	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
		tableSetWidth(100, 100, 100,100,100,100,100,100,100);
		
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {
				"차코드","모델명","색상","기어","브랜드","차종","연료","렌트여부","렌트횟수"
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
				item.getFuel(),
				item.isRent()==true?"대여중":"대여가능",
				item.getRentCnt()
		};
	}

	@Override
	public CarModel getItem(int selectedIndex) {
		return list.get(selectedIndex);
	}
	
	
	

}