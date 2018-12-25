package kr.or.yi.java_web_female.ui.car;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	 

    @Override

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

          Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

          if (!isSelected) {

                 if (column == 0) {
                        cell.setForeground(Color.white);
                        if (value.equals("bk")) {
                              cell.setBackground(Color.BLACK);
                        } else if (value.equals("gr")) {
                              cell.setBackground(Color.gray);
                        } else if (value.equals("bl")) {
                              cell.setBackground(Color.BLUE);
                        } else if (value.equals("mt")) {
                              cell.setBackground(Color.GREEN);
                        }

                 } else {
                        cell.setBackground(Color.white);
                 }

          }

          return this;

    }


}
