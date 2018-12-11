package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.security.Provider.Service;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.service.SearchPostService;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;
import kr.or.yi.java_web_female.ui.list.AddressTable;

public class SearchPostUI extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JTextField tfDoro;
   private JComboBox<String> cmb;
   private JButton btnSearch;
   private SearchPostService postService;
   private AddressTable pList;
   private int selectedIndex;
   private Post doro;

   public void setpList(AddressTable pList) {
      this.pList = pList;
   }

   /**
    * Create the frame.
    */
   public SearchPostUI() {
      postService = new SearchPostService();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 550, 350);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(0, 0));

      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.NORTH);
      panel.setLayout(new GridLayout(0, 5, 0, 0));

      JLabel lblSido = new JLabel("시도");
      lblSido.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(lblSido);

      String[] strArr = { "강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시", "대전광역시", "부산광역시", "서울특별시", "세종특별자치시",
            "울산광역시", "인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도" };
      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(strArr);
      cmb = new JComboBox<>(model);
      cmb.setSelectedIndex(-1);

      panel.add(cmb);

      JLabel lblDoro = new JLabel("도로명");
      lblDoro.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(lblDoro);

      tfDoro = new JTextField();
      panel.add(tfDoro);
      tfDoro.setColumns(10);

      btnSearch = new JButton("검색");
      btnSearch.addActionListener(this);
      ;
      panel.add(btnSearch);

       pList =  new AddressTable();
      contentPane.add(pList, BorderLayout.CENTER);

   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnSearch) {
         do_btnSearch_actionPerformed(e);
      }
   }

   protected void do_btnSearch_actionPerformed(ActionEvent e) {

      try {
         doro = new Post();
         doro.setSido((String)cmb.getSelectedItem());
         doro.setDoro(tfDoro.getText().trim());
         pList.setList(postService.selectPostByName(doro));
         pList.loadDatas();
//         pList.getItem(selectedIndex);

      } catch (SQLException e1) {
         e1.printStackTrace();
      }
   }

}