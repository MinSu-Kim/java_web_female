package kr.or.yi.java_web_female.ui.rent.customer;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;

@SuppressWarnings("serial")
public class RentCustomerStat extends AbstractListPanel<Rent> {

	@Override
	protected void setAlignWidth() {
		// TODO Auto-generated method stub
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(150, 150, 100, 100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {
				"대여일자", "반납일자", "차종", "브랜드", "차량명"
		};
	}

	@Override
	protected Object[] getItemRows(Rent item) {
		return new Object[] {
				item.getStartDate() + " " + item.getStartTime(),
				item.getEndDate() + " " + item.getEndTime(),
				item.getCarCode().getCarType().getType(),
				item.getCarCode().getBrand().getName(),
				item.getCarCode().getName()
		};
	}

	@Override
	protected Rent getItem(int selectedIndex) {
		return list.get(selectedIndex);
	}

}
