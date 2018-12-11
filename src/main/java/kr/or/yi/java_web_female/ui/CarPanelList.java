package kr.or.yi.java_web_female.ui;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kr.or.yi.java_web_female.dto.CarModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

public class CarPanelList extends JPanel {
	private List<CarModel> list;
	private JTable table;

	public void setList(List<CarModel> list) {
		this.list = list;
	}
	
	/**
	 * Create the panel.
	 */
	public CarPanelList() {
		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();

		scrollPane.setViewportView(table);
	}
	
	public void loadDatas() {
		table.setModel(new DefaultTableModel(
					getDatas(),
					getColumnName()
			));
		}
	

	private String[] getColumnName() {
		return new String[] {
				"차코드","모델명","색상","기어","브랜드","차종","기본료","6시간",
				"10시간","12시간","12시간이상","연료","렌트여부","렌트횟수","옵션"
		};
	}

	private Object[][] getDatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i=0;i<list.size();i++) {
			datas[i] = getItemrow(list.get(i));
		}
		return datas;
	}

	private Object[] getItemrow(CarModel carModel) {
		return new Object[] {
				carModel.getCarCode(),
				carModel.getName(),
				carModel.getColor(),
				carModel.getGear(),
				carModel.getBrand().getName(),
				carModel.getCartype().getType(),
				carModel.getBasic_charge(),
				carModel.getHour6(),
				carModel.getHour10(),
				carModel.getHour12(),
				carModel.getHourElse(),
				carModel.getFuel().getCode(),
				carModel.isRent(),
				carModel.getRentCnt(),
				carModel.getCarOption()
		};
	}
	
	public CarModel getSelectedItem() {
		int selectedRow = table.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "해당정보를 선택하세요");
			return null;
		};
		return getItem(selectedRow);
	}

	private CarModel getItem(int selectedRow) {
		String carModelCode = (String)table.getValueAt(selectedRow, 0);
		CarModel newModel = new CarModel(carModelCode);
		int index = list.indexOf(newModel);
		return list.get(index);
	}
	
	
}




















