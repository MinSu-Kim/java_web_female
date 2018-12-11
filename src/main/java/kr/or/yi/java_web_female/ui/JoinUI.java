package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Post;

@SuppressWarnings("serial")
public class JoinUI extends JFrame {

   private JPanel contentPane;
   private JTextField tfName;
   private JTextField tfId;
   private JTextField tfPwd1;
   private JTextField tfPwd2;
   private JTextField tfTel2;
   private JTextField tfTel3;
   private JTextField tfEmail1;
   private JTextField tfEmail2;
   private JTextField tfZipCode;
   private JTextField tfAddr;

   public JoinUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 571, 510);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel pContent = new JPanel();
      contentPane.add(pContent, BorderLayout.CENTER);
      pContent.setLayout(new GridLayout(0, 2, 10, 10));
      
      JLabel lblName = new JLabel("이름");
      lblName.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblName);
      
      tfName = new JTextField();
      tfName.setColumns(10);
      pContent.add(tfName);
      
      JLabel lblId = new JLabel("아이디");
      lblId.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblId);
      
      JPanel pId = new JPanel();
      pContent.add(pId);
      pId.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfId = new JTextField();
      tfId.setColumns(10);
      pId.add(tfId);
      
      JButton btnDupConfirm = new JButton("중복확인");
      pId.add(btnDupConfirm);
      
      JLabel lblPw1 = new JLabel("비밀번호");
      lblPw1.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblPw1);
      
      JPanel pPwd1 = new JPanel();
      pContent.add(pPwd1);
      pPwd1.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfPwd1 = new JTextField();
      tfPwd1.setColumns(10);
      pPwd1.add(tfPwd1);
      
      JLabel lblBlank1 = new JLabel("");
      lblBlank1.setHorizontalAlignment(SwingConstants.CENTER);
      pPwd1.add(lblBlank1);
      
      JLabel lblPw2 = new JLabel("비밀번호 확인");
      lblPw2.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblPw2);
      
      JPanel panel_2 = new JPanel();
      pContent.add(panel_2);
      panel_2.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfPwd2 = new JTextField();
      tfPwd2.setColumns(10);
      panel_2.add(tfPwd2);
      
      JLabel lblBlank2 = new JLabel("");
      lblBlank2.setHorizontalAlignment(SwingConstants.CENTER);
      panel_2.add(lblBlank2);
      
      JLabel lblBirth = new JLabel("생년월일");
      lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblBirth);
      
      JDateChooser birthDay = new JDateChooser();
      pContent.add(birthDay);
      
      JLabel lblTel = new JLabel("전화번호");
      lblTel.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblTel);
      
      JPanel pTel = new JPanel();
      pContent.add(pTel);
      pTel.setLayout(new BoxLayout(pTel, BoxLayout.X_AXIS));
      
      JComboBox<String> cmbTel1 = new JComboBox<>();
      cmbTel1.setModel(new DefaultComboBoxModel<String>(new String[] {"010", "011", "017"}));
      pTel.add(cmbTel1);
      
      JLabel lbl1 = new JLabel("-");
      lbl1.setHorizontalAlignment(SwingConstants.CENTER);
      pTel.add(lbl1);
      
      tfTel2 = new JTextField();
      tfTel2.setColumns(10);
      pTel.add(tfTel2);
      
      JLabel lbl2 = new JLabel("-");
      lbl2.setHorizontalAlignment(SwingConstants.CENTER);
      pTel.add(lbl2);
      
      tfTel3 = new JTextField();
      tfTel3.setColumns(10);
      pTel.add(tfTel3);
      
      JLabel lblEmail = new JLabel("이메일");
      lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblEmail);
      
      JPanel pEmail = new JPanel();
      pContent.add(pEmail);
      pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.X_AXIS));
      
      tfEmail1 = new JTextField();
      tfEmail1.setColumns(8);
      pEmail.add(tfEmail1);
      
      JLabel lblAt = new JLabel("@");
      lblAt.setHorizontalAlignment(SwingConstants.CENTER);
      pEmail.add(lblAt);
      
      tfEmail2 = new JTextField();
      tfEmail2.setColumns(8);
      pEmail.add(tfEmail2);
      
      JComboBox<String> cmbEmail3 = new JComboBox<>();
      pEmail.add(cmbEmail3);
      
      JLabel lblAddr = new JLabel("우편번호");
      lblAddr.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblAddr);
      
      JPanel pAddr = new JPanel();
      pContent.add(pAddr);
      pAddr.setLayout(new GridLayout(0, 2, 0, 0));
      
      tfZipCode = new JTextField();
      tfZipCode.setColumns(10);
      pAddr.add(tfZipCode);
      
      JButton btnSearchAddr = new JButton("우편번호 검색");
      btnSearchAddr.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            SearchPostUI frame = new SearchPostUI();
            frame.setJoinUi(JoinUI.this); //추가해줌. setAddress()호출하기 위핸
            frame.setVisible(true);
         }
      });
      pAddr.add(btnSearchAddr);
      
      JLabel lblAddrDetail = new JLabel("주소");
      lblAddrDetail.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblAddrDetail);
      
      tfAddr = new JTextField();
      pContent.add(tfAddr);
      tfAddr.setColumns(10);
      
      JPanel pBtn = new JPanel();
      contentPane.add(pBtn, BorderLayout.SOUTH);
      
      JButton btnJoin = new JButton("가입");
      pBtn.add(btnJoin);
      
      JButton btnCalcel = new JButton("취소");
      pBtn.add(btnCalcel);
   }

   /* 추가해줌 */
   public void setAddress(Post post) {
	   this.tfZipCode.setText(post.getZipcode());
	   this.tfAddr.setText(post.toString());
	   tfAddr.requestFocus();
   }
}