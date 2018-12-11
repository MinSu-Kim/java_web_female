package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {

   private JPanel contentPane;
   private JTextField tfId;
   private JTextField tfPasswd;

   
   /**
    * Create the frame.
    */
   public LoginUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel pContent = new JPanel();
      contentPane.add(pContent, BorderLayout.CENTER);
      pContent.setLayout(new GridLayout(0, 3, 10, 10));
      
      JLabel lblId = new JLabel("아이디");
      lblId.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblId);
      
      tfId = new JTextField();
      pContent.add(tfId);
      tfId.setColumns(10);
      
      JButton btnLogin = new JButton("로그인");
      pContent.add(btnLogin);
      
      JLabel lblPasswd = new JLabel("비밀번호");
      lblPasswd.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(lblPasswd);
      
      tfPasswd = new JTextField();
      tfPasswd.setColumns(10);
      pContent.add(tfPasswd);
      
      JCheckBox checkBox = new JCheckBox("관리자 모드");
      checkBox.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(checkBox);
      
      JPanel pBtn = new JPanel();
      contentPane.add(pBtn, BorderLayout.SOUTH);
      
      JButton btnJoin = new JButton("회원가입");
      btnJoin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JoinUI frame = new JoinUI();
            frame.setVisible(true);
         }
      });
      pBtn.add(btnJoin);
      
      JButton btnSearch = new JButton("ID/PW찾기");
      pBtn.add(btnSearch);
   }

}