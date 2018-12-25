package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Customer;

public class CustomerList extends AbstractListPanel<Customer>{

	
	
	public CustomerList() {
		
	}

	@Override
	protected void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		tableSetWidth(100, 100, 100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"고객코드","아이디", "고객이름", "우편번호", "주소", "연락처", "생년월일", "이메일","면허종류", "등급명", "대여횟수"};
	}

	@Override
	protected Object[] getItemRows(Customer item) {
		return new Object[] {
				item.getCode(),item.getId(), item.getName(), item.getZipCode() ,item.getAddress(), item.getPhone(), String.format("%tF", item.getDob()), item.getEmail(), item.getLicense(), item.getGradeCode(), item.getRentCnt() 
		};
	}

	@Override
	protected Customer getItem(int selectedIndex) {
		// TODO Auto-generated method stub
		return list.get(selectedIndex);
	}

}
