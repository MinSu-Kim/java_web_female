package kr.or.yi.java_web_female.ui.list;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import kr.or.yi.java_web_female.dto.CarModel;

@SuppressWarnings("serial")
public class CarTotalList extends AbstractListPanel<CarModel> {
	
	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
		tableSetWidth(100, 100, 100,100,100,100,100,100);
		TableColumn tcName = table.getColumn("색상");
		tcName.setCellRenderer(new CarColorTableCellRenderer());
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {
				"차코드","모델명","색상","기어","브랜드","차종","연료","렌트여부"
		};
	}

	@Override
	protected Object[] getItemRows(CarModel item) {
		String color = item.getColor();
		switch(color) {
			case "wh":color = "하양";break;
			case "bk":color = "검정";break;
			case "bl":color = "파랑";break;
			case "gr":color = "회색";break;
			case "mt":color = "민트";break;
			case "re":color = "빨강";break;
		}
		String brandName = item.getBrand().getName();
		switch(brandName) {
			case "hyundai"	: brandName="현대";break;
			case "kia"		: brandName="기아";break;
		}
		return new Object[] {
				item.getCarCode(),
				item.getName(),
				color,
				item.getGear().equals("auto")?"자동":"수동",
				brandName,
				item.getCarType().getType(),
				item.getFuel(),
				item.isRent()==true?"렌트 중":"X"
		};
	}

	@Override
	public CarModel getItem(int selectedIndex) {
		return list.get(selectedIndex);
	}
	
	public class CarColorTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value.toString());
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true);
			if (value.toString().equals("하양")) {
				setBackground(Color.WHITE);
				setForeground(Color.BLACK);
			}else if (value.toString().equals("검정")) {
				setBackground(Color.BLACK);
				setForeground(Color.WHITE);
			}else if (value.toString().equals("회색")) {
				setBackground(new Color(100, 100, 100, 40));
				setForeground(Color.BLACK);
			}else if (value.toString().equals("파랑")) {
				setBackground(new Color(0, 0, 255, 70));
				setForeground(Color.BLACK);
			}else if (value.toString().equals("민트")) {
				setBackground(Color.GREEN);
				setForeground(Color.BLACK);
			}else if (value.toString().equals("빨강")) {
				setBackground(Color.RED);
				setForeground(Color.BLACK);
			}
			return this;
		}
	}

}