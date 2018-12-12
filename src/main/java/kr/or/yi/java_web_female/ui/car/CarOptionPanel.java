package kr.or.yi.java_web_female.ui.car;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;

public class CarOptionPanel extends AbstractListPanel<CarOption> {
	private CarUiService service;
	private List<CarOption> list;
	/**
	 * Create the panel.
	 */
	public CarOptionPanel() {
		service = new CarUiService();
	}

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
		int no = (int)table.getValueAt(selectedIndex, 0);
		String name = (String)table.getValueAt(selectedIndex, 1);
		CarOption carOption = new CarOption();
		carOption.setNo(no);
		carOption.setName(name);
		return carOption;
	}

}
