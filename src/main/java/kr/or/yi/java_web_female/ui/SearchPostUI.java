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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class SearchPostUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfDoro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPostUI frame = new SearchPostUI();
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
	public SearchPostUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JComboBox cmb = new JComboBox();
		panel.add(cmb);
		
		JLabel lblDoro = new JLabel("도로명");
		lblDoro.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDoro);
		
		tfDoro = new JTextField();
		panel.add(tfDoro);
		tfDoro.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		panel.add(btnSearch);
		
		JPanel pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane);
	}

}
