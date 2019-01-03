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
		
		return new Object[] {
				item.getCarCode(),
				item.getName(),
				item.getColor().equals("wh")==true?"하양":
					item.getColor().equals("bk")==true?"검정":
						item.getColor().equals("bl")==true?"파랑":
							item.getColor().equals("gr")==true?"회색":
								item.getColor().equals("mt")==true?"민트":
									item.getColor().equals("re")==true?"빨강":item.getColor(),
				item.getGear().equals("auto")==true?"자동":"수동",
				item.getBrand().getName().equals("hyundai")==true?"현대":
					item.getBrand().getName().equals("kia")==true?"기아":
						item.getBrand().getName(),
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
			}
			if (value.toString().equals("검정")) {
				setBackground(Color.BLACK);
			}
			if (value.toString().equals("회색")) {
				setBackground(Color.LIGHT_GRAY);
			}
			if (value.toString().equals("파랑")) {
				setBackground(new Color(0, 0, 255, 70));
			}
			if (value.toString().equals("민트")) {
				setBackground(Color.GREEN);
			}
			if (value.toString().equals("빨강")) {
				setBackground(Color.RED);
			}
			return this;
		}
	}

}