package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Rent;

@SuppressWarnings("serial")
public class RentList extends AbstractListPanel<Rent> {


	public RentList() {

	}

	@Override
	protected void setAlignWidth() {
		// TODO Auto-generated method stub
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(80, 100, 80, 80, 120, 100, 120, 100, 80, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {
				"대여코드", "차량명", "고객코드", "고객명", "대여일", "대여시간", "반납일", "반납시간", "반납여부", "차량보험"
		};
	}

	@Override
	protected Object[] getItemRows(Rent item) {
		return new Object[] {
				item.getCode(),
				item.getCarCode().getName(),
				item.getCustomerCode().getCode(),
				item.getCustomerCode().getName(),
				item.getStartDate(),
				item.getStartTime(),
				item.getEndDate(),
				item.getEndTime(),
				item.isReturn() == false ? "N" : "Y",
				item.getInsuranceCode().getCode().equals("I000") ? "가입안함" : "일반자차",	
		};
	}

	@Override
	protected Rent getItem(int selectedIndex) {
		return list.get(selectedIndex);
	}

}
