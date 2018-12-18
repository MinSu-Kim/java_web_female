package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Brand;

@SuppressWarnings("serial")
public class BrandList extends AbstractListPanel<Brand> {

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableSetWidth(100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "브랜드번호", "브랜드명" };
	}

	@Override
	protected Object[] getItemRows(Brand item) {
		return new Object[] { item.getNo(), item.getName() };
	}

	@Override
	protected Brand getItem(int selectedIndex) {
/*		String no = (String) table.getValueAt(selectedIndex, 0);
		String name = (String) table.getValueAt(selectedIndex, 1);
		Brand brand = new Brand();
		brand.setNo(no);
		brand.setName(name);
		return brand;*/
		return list.get(selectedIndex);
	}

}
