package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Grade;

@SuppressWarnings("serial")
public class GradeList extends AbstractListPanel<Grade> {

	public GradeList() {

	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		tableSetWidth(100, 100, 100, 100, 100);
		
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"등급코드","등급명","등급별할인율","최소범위","최대범위"};
	}

	@Override
	protected Object[] getItemRows(Grade item) {
		return new Object[] {
				item.getCode(),item.getName(),item.getRate(),item.getgLosal(),item.getgHisal()
		};
	}

	@Override
	protected Grade getItem(int selectedIndex) {
		// TODO Auto-generated method stub
		return list.get(selectedIndex);
	}

}
