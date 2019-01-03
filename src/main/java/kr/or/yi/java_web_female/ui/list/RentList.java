package kr.or.yi.java_web_female.ui.list;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.ui.list.CarTotalList.CarColorTableCellRenderer;
import kr.or.yi.java_web_female.ui.list.CustomerList.ReturnTableCellRenderer;

@SuppressWarnings("serial")
public class RentList extends AbstractListPanel<Rent> {

	public RentList() {

	}

	@Override
	protected void setAlignWidth() {
		// TODO Auto-generated method stub
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(80, 100, 80, 80, 120, 100, 120, 100, 80, 100);
		
		TableColumn tcName = table.getColumn("반납여부");
		tcName.setCellRenderer(new ReturnTableCellRenderer());
		
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "대여코드", "차량명", "고객코드", "고객명", "대여일", "대여시간", "반납일", "반납시간", "반납여부", "차량보험" };
	}

	@Override
	protected Object[] getItemRows(Rent item) {
		return new Object[] { item.getCode(), item.getCarCode().getName(), item.getCustomerCode().getCode(),
				item.getCustomerCode().getName(), item.getStartDate(), item.getStartTime(), item.getEndDate(),
				item.getEndTime(), item.isReturn() == false ? "N" : "Y",
				item.getInsuranceCode().getCode().equals("I000") ? "가입안함" : "일반자차", };
	}

	@Override
	protected Rent getItem(int selectedIndex) {
		return list.get(selectedIndex);
	}

	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			setText(value.toString());
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true);
			
			if (value.toString().equals("N")) {
				setBackground(new Color(255, 0, 0, 20));
			}else {
				setBackground(new Color(178, 235, 244, 80));
			}
			return this;
		}
	}
}
