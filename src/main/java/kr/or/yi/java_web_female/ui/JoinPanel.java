package kr.or.yi.java_web_female.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class JoinPanel extends JPanel {
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   private JTextField textField_3;
   private JTextField textField_4;
   private JTextField textField_5;
   private JTextField textField_6;
   private JTextField textField_7;
   private JTextField textField_8;
   private JTextField textField_9;

   /**
    * Create the panel.
    */
   public JoinPanel() {
      setLayout(new BorderLayout(0, 0));
      
      JPanel pContent = new JPanel();
      add(pContent);
      pContent.setLayout(new GridLayout(0, 2, 10, 10));
      
      JLabel lblNewLabel = new JLabel("이름");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblNewLabel);
      
      textField = new JTextField();
      pContent.add(textField);
      textField.setColumns(10);
      
      JLabel lblNewLabel_1 = new JLabel("아이디");
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblNewLabel_1);
      
      JPanel panel = new JPanel();
      pContent.add(panel);
      panel.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_1 = new JTextField();
      panel.add(textField_1);
      textField_1.setColumns(10);
      
      JButton btnNewButton = new JButton("중복확인");
      panel.add(btnNewButton);
      
      JLabel lblNewLabel_2 = new JLabel("비밀번호");
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblNewLabel_2);
      
      JPanel panel_1 = new JPanel();
      pContent.add(panel_1);
      panel_1.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_2 = new JTextField();
      panel_1.add(textField_2);
      textField_2.setColumns(10);
      
      JLabel lblNewLabel_3 = new JLabel("");
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      panel_1.add(lblNewLabel_3);
      
      JLabel lblNewLabel_4 = new JLabel("비밀번호 확인");
      lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblNewLabel_4);
      
      JPanel panel_2 = new JPanel();
      pContent.add(panel_2);
      panel_2.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_3 = new JTextField();
      textField_3.setColumns(10);
      panel_2.add(textField_3);
      
      JLabel label = new JLabel("");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      panel_2.add(label);
      
      JLabel lblNewLabel_5 = new JLabel("생년월일");
      lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblNewLabel_5);
      
      JPanel panel_3 = new JPanel();
      pContent.add(panel_3);
      
      JLabel label_1 = new JLabel("전화번호");
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_1);
      
      JPanel panel_4 = new JPanel();
      pContent.add(panel_4);
      panel_4.setLayout(new GridLayout(0, 5, 0, 0));
      
      JComboBox comboBox = new JComboBox();
      panel_4.add(comboBox);
      
      JLabel label_2 = new JLabel("-");
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      panel_4.add(label_2);
      
      textField_4 = new JTextField();
      textField_4.setColumns(10);
      panel_4.add(textField_4);
      
      JLabel label_3 = new JLabel("-");
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      panel_4.add(label_3);
      
      textField_5 = new JTextField();
      textField_5.setColumns(10);
      panel_4.add(textField_5);
      
      JLabel label_4 = new JLabel("이메일");
      label_4.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_4);
      
      JPanel panel_5 = new JPanel();
      pContent.add(panel_5);
      panel_5.setLayout(new GridLayout(0, 4, 0, 0));
      
      textField_6 = new JTextField();
      textField_6.setColumns(10);
      panel_5.add(textField_6);
      
      JLabel label_5 = new JLabel("@");
      label_5.setHorizontalAlignment(SwingConstants.CENTER);
      panel_5.add(label_5);
      
      textField_7 = new JTextField();
      textField_7.setColumns(10);
      panel_5.add(textField_7);
      
      JComboBox comboBox_1 = new JComboBox();
      panel_5.add(comboBox_1);
      
      JLabel label_6 = new JLabel("주소");
      label_6.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_6);
      
      JPanel panel_6 = new JPanel();
      pContent.add(panel_6);
      panel_6.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_8 = new JTextField();
      panel_6.add(textField_8);
      textField_8.setColumns(10);
      
      JButton btnNewButton_1 = new JButton("우편번호 검색");
      panel_6.add(btnNewButton_1);
      
      JLabel lblNewLabel_6 = new JLabel("상세 주소");
      lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblNewLabel_6);
      
      textField_9 = new JTextField();
      pContent.add(textField_9);
      textField_9.setColumns(10);
      
      JPanel pBtn = new JPanel();
      add(pBtn, BorderLayout.SOUTH);
      
      JButton btnJoin = new JButton("가입");
      pBtn.add(btnJoin);
      
      JButton btnCancel = new JButton("취소");
      pBtn.add(btnCancel);

   }

}