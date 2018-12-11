package kr.or.yi.java_web_female.ui.list;

import kr.or.yi.java_web_female.dto.Post;

@SuppressWarnings("serial")
public class AddressTable extends AbstractListPanel<Post> {

   @Override
   protected void setAlignWidth() {
      
      
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
/*      String zipCode = (String) table.getValueAt(selectedIndex, 0);
      Post searchPost = new Post(zipCode);
      int index = list.indexOf(searchPost);
      
      return list.get(index);*/
	   return list.get(selectedIndex);
   }

}