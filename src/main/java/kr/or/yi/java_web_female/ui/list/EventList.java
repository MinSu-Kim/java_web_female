package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Event;

@SuppressWarnings("serial")
public class EventList extends AbstractListPanel<Event>{
	public EventList() {
	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidth(100, 100, 100);
		
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"이벤트코드","이벤트명","할인율"};
	}

	@Override
	protected Object[] getItemRows(Event item) {
		return new Object[] {
				item.getCode(),item.getName(),item.getRate()
		};
	}

	@Override
	protected Event getItem(int selectedIndex) {
		// TODO Auto-generated method stub
		return list.get(selectedIndex);
	}

	

}
