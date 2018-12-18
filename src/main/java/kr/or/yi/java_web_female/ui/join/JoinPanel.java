package kr.or.yi.java_web_female.ui.join;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class JoinPanel extends JPanel {
   private JTextField tfName;
   private JTextField tfId;
   private JTextField tfPsass01;
   private JTextField tfPass02;
   private JTextField tfTel02;
   private JTextField tfTel03;
   private JTextField tfEmail01;
   private JTextField tfEmail02;
   private JTextField tfPost;
   private JTextField tfAddr;

   public JoinPanel() {
      setLayout(new BorderLayout(0, 0));
      
      JPanel pContent = new JPanel();
      add(pContent);
      pContent.setLayout(new GridLayout(0, 2, 10, 10));
      
      JLabel lblName = new JLabel("이름");
      lblName.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblName);
      
      tfName = new JTextField();
      pContent.add(tfName);
      tfName.setColumns(10);
      
      JLabel lblId = new JLabel("아이디");
      lblId.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblId);
      
      JPanel pId = new JPanel();
      pContent.add(pId);
      pId.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfId = new JTextField();
      pId.add(tfId);
      tfId.setColumns(10);
      
      JButton btnIdConfirm = new JButton("중복확인");
      pId.add(btnIdConfirm);
      
      JLabel lblPass01 = new JLabel("비밀번호");
      lblPass01.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblPass01);
      
      JPanel pPass01 = new JPanel();
      pContent.add(pPass01);
      pPass01.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfPsass01 = new JTextField();
      pPass01.add(tfPsass01);
      tfPsass01.setColumns(10);
      
      JLabel lblNewLabel_3 = new JLabel("");
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      pPass01.add(lblNewLabel_3);
      
      JLabel lblPass02 = new JLabel("비밀번호 확인");
      lblPass02.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblPass02);
      
      JPanel pPass02 = new JPanel();
      pContent.add(pPass02);
      pPass02.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfPass02 = new JTextField();
      tfPass02.setColumns(10);
      pPass02.add(tfPass02);
      
      JLabel label = new JLabel("");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      pPass02.add(label);
      
      JLabel lblBirth = new JLabel("생년월일");
      lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblBirth);
      
      JDateChooser dateChooser = new JDateChooser();
      pContent.add(dateChooser);
      
      JLabel lblTel = new JLabel("전화번호");
      lblTel.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblTel);
      
      JPanel pTel = new JPanel();
      pContent.add(pTel);
      pTel.setLayout(new GridLayout(0, 5, 0, 0));
      
      JComboBox<String> cmbTel01 = new JComboBox<>();
      pTel.add(cmbTel01);
      
      JLabel lblDash01 = new JLabel("-");
      lblDash01.setHorizontalAlignment(SwingConstants.CENTER);
      pTel.add(lblDash01);
      
      tfTel02 = new JTextField();
      tfTel02.setColumns(10);
      pTel.add(tfTel02);
      
      JLabel lblDash02 = new JLabel("-");
      lblDash02.setHorizontalAlignment(SwingConstants.CENTER);
      pTel.add(lblDash02);
      
      tfTel03 = new JTextField();
      tfTel03.setColumns(10);
      pTel.add(tfTel03);
      
      JLabel lblEmail = new JLabel("이메일");
      lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblEmail);
      
      JPanel pEmail = new JPanel();
      pContent.add(pEmail);
      pEmail.setLayout(new GridLayout(0, 4, 0, 0));
      
      tfEmail01 = new JTextField();
      tfEmail01.setColumns(10);
      pEmail.add(tfEmail01);
      
      JLabel lblAt = new JLabel("@");
      lblAt.setHorizontalAlignment(SwingConstants.CENTER);
      pEmail.add(lblAt);
      
      tfEmail02 = new JTextField();
      tfEmail02.setColumns(10);
      pEmail.add(tfEmail02);
      
      JComboBox<String> cmbEmail = new JComboBox<>();
      pEmail.add(cmbEmail);
      
      JLabel lblPost = new JLabel("주소");
      lblPost.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblPost);
      
      JPanel pPost = new JPanel();
      pContent.add(pPost);
      pPost.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfPost = new JTextField();
      pPost.add(tfPost);
      tfPost.setColumns(10);
      
      JButton btnPostSearch = new JButton("우편번호 검색");
      pPost.add(btnPostSearch);
      
      JLabel lblAddress = new JLabel("상세 주소");
      lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblAddress);
      
      tfAddr = new JTextField();
      pContent.add(tfAddr);
      tfAddr.setColumns(10);
      
      JPanel pBtn = new JPanel();
      add(pBtn, BorderLayout.SOUTH);
      
      JButton btnJoin = new JButton("가입");
      pBtn.add(btnJoin);
      
      JButton btnCancel = new JButton("취소");
      pBtn.add(btnCancel);

   }

}