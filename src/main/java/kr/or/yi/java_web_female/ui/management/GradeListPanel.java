package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GradeListPanel extends JPanel {
	private JTextField tfGradeCode;
	private JTextField tfGradeName;
	private JTextField tfGradeRate;

	/**
	 * Create the panel.
	 */
	public GradeListPanel() {
		setBorder(new TitledBorder(null, "\uB4F1\uAE09\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelList = new JPanel();
		add(panelList);
		panelList.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panel.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblGradeCode = new JLabel("등급코드");
		lblGradeCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblGradeCode);
		
		tfGradeCode = new JTextField();
		panelInput.add(tfGradeCode);
		tfGradeCode.setColumns(10);
		
		JLabel lblGradeName = new JLabel("등급명");
		lblGradeName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblGradeName);
		
		tfGradeName = new JTextField();
		panelInput.add(tfGradeName);
		tfGradeName.setColumns(10);
		
		JLabel lblGradeRate = new JLabel("할인율");
		lblGradeRate.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblGradeRate);
		
		tfGradeRate = new JTextField();
		panelInput.add(tfGradeRate);
		tfGradeRate.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnGradeOk = new JButton("추가");
		panelBtn.add(btnGradeOk);
		
		JButton btnGradeCancel = new JButton("취소");
		panelBtn.add(btnGradeCancel);

	}

}
