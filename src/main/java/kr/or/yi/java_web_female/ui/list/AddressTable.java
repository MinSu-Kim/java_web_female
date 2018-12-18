package kr.or.yi.java_web_female.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.java_web_female.dto.Post;

@SuppressWarnings("serial")
public class AddressTable extends AbstractListPanel<Post> {

   @Override
   protected void setAlignWidth() {
	   tableCellAlignment(SwingConstants.CENTER, 0);
	   tableCellAlignment(SwingConstants.LEFT, 1);
		tableSetWidth(100, 600);
      
   }

   @Override
   protected String[] getColumnNames() {
      // TODO Auto-generated method stub
      return new String[] {"우편번호", "주소"};
   }

   @Override
   protected Object[] getItemRows(Post item) {
      // TODO Auto-generated method stub
      return new Object[] {item.getZipcode(), item.toString()};
   }

   @Override
   public Post getItem(int selectedIndex) {
	   return list.get(selectedIndex);
   }

}