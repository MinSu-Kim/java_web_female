package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JTextField tfId;
   private JTextField tfPasswd;
   private JButton btnSearch;

   public LoginUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 186);
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
      
      btnSearch = new JButton("ID/PW찾기");
      btnSearch.addActionListener(this);
      pBtn.add(btnSearch);
   }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		SearchIdPwUI frame = new SearchIdPwUI();
        frame.setVisible(true);
	}
}