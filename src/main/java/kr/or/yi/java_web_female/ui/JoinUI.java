package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinUI extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   private JTextField textField_3;
   private JTextField textField_4;
   private JTextField textField_5;
   private JTextField textField_6;
   private JTextField textField_7;
   private JTextField textField_9;
   private JTextField textField_8;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               JoinUI frame = new JoinUI();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public JoinUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 550, 510);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel pContent = new JPanel();
      contentPane.add(pContent, BorderLayout.CENTER);
      pContent.setLayout(new GridLayout(0, 2, 10, 10));
      
      JLabel label = new JLabel("이름");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label);
      
      textField = new JTextField();
      textField.setColumns(10);
      pContent.add(textField);
      
      JLabel label_1 = new JLabel("아이디");
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_1);
      
      JPanel panel = new JPanel();
      pContent.add(panel);
      panel.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_1 = new JTextField();
      textField_1.setColumns(10);
      panel.add(textField_1);
      
      JButton button = new JButton("중복확인");
      panel.add(button);
      
      JLabel label_2 = new JLabel("비밀번호");
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_2);
      
      JPanel panel_1 = new JPanel();
      pContent.add(panel_1);
      panel_1.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_2 = new JTextField();
      textField_2.setColumns(10);
      panel_1.add(textField_2);
      
      JLabel label_3 = new JLabel("");
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      panel_1.add(label_3);
      
      JLabel label_4 = new JLabel("비밀번호 확인");
      label_4.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_4);
      
      JPanel panel_2 = new JPanel();
      pContent.add(panel_2);
      panel_2.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_3 = new JTextField();
      textField_3.setColumns(10);
      panel_2.add(textField_3);
      
      JLabel label_5 = new JLabel("");
      label_5.setHorizontalAlignment(SwingConstants.CENTER);
      panel_2.add(label_5);
      
      JLabel label_6 = new JLabel("생년월일");
      label_6.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_6);
      
      JDateChooser dateChooser = new JDateChooser();
      pContent.add(dateChooser);
      
      JLabel label_7 = new JLabel("전화번호");
      label_7.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_7);
      
      JPanel panel_3 = new JPanel();
      pContent.add(panel_3);
      panel_3.setLayout(new GridLayout(0, 5, 0, 0));
      
      JComboBox comboBox = new JComboBox();
      panel_3.add(comboBox);
      
      JLabel label_8 = new JLabel("-");
      label_8.setHorizontalAlignment(SwingConstants.CENTER);
      panel_3.add(label_8);
      
      textField_4 = new JTextField();
      textField_4.setColumns(10);
      panel_3.add(textField_4);
      
      JLabel label_9 = new JLabel("-");
      label_9.setHorizontalAlignment(SwingConstants.CENTER);
      panel_3.add(label_9);
      
      textField_5 = new JTextField();
      textField_5.setColumns(10);
      panel_3.add(textField_5);
      
      JLabel label_10 = new JLabel("이메일");
      label_10.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_10);
      
      JPanel panel_4 = new JPanel();
      pContent.add(panel_4);
      panel_4.setLayout(new GridLayout(0, 4, 0, 0));
      
      textField_6 = new JTextField();
      textField_6.setColumns(10);
      panel_4.add(textField_6);
      
      JLabel label_11 = new JLabel("@");
      label_11.setHorizontalAlignment(SwingConstants.CENTER);
      panel_4.add(label_11);
      
      textField_7 = new JTextField();
      textField_7.setColumns(10);
      panel_4.add(textField_7);
      
      JComboBox comboBox_1 = new JComboBox();
      panel_4.add(comboBox_1);
      
      JLabel label_12 = new JLabel("주소");
      label_12.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_12);
      
      JPanel panel_6 = new JPanel();
      pContent.add(panel_6);
      panel_6.setLayout(new GridLayout(0, 2, 0, 0));
      
      textField_9 = new JTextField();
      textField_9.setColumns(10);
      panel_6.add(textField_9);
      
      JButton button_2 = new JButton("우편번호 검색");
      button_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            SearchPostUI frame = new SearchPostUI();
            frame.setVisible(true);
         }
      });
      panel_6.add(button_2);
      
      JLabel label_13 = new JLabel("상세 주소");
      label_13.setHorizontalAlignment(SwingConstants.CENTER);
      pContent.add(label_13);
      
      textField_8 = new JTextField();
      pContent.add(textField_8);
      textField_8.setColumns(10);
      
      JPanel pBtn = new JPanel();
      contentPane.add(pBtn, BorderLayout.SOUTH);
      
      JButton btnJoin = new JButton("가입");
      pBtn.add(btnJoin);
      
      JButton btnCalcel = new JButton("취소");
      pBtn.add(btnCalcel);
   }

}