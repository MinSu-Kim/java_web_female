package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Rent;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RentListInfoPanel extends JPanel {
	private JTextField tfRentCode;
	private JTextField tfCarName;
	private JTextField tfCstmCode;
	private JTextField tfCstmName;
	private JTextField tfStartDate;
	private JTextField tfStartTime;
	private JTextField tfEndDate;
	private JTextField tfEndTime;
	private Rent rent;
	
	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
		JOptionPane.showMessageDialog(null, rent);
		tfRentCode.setText(rent.getCode());
		tfCarName.setText(rent.getCarCode().getName());
		tfCstmCode.setText(rent.getCustomerCode().getCode());
		tfCstmName.setText(rent.getCustomerCode().getName());
		tfStartDate.setText(rent.getStartDate());
		tfStartTime.setText(rent.getEndTime());
		tfEndDate.setText(rent.getEndDate());
		tfEndTime.setText(rent.getEndTime());
	}

	/**
	 * Create the panel.
	 */
	public RentListInfoPanel() {
		setLayout(new BorderLayout(5, 5));
		
		JPanel pRentInfo = new JPanel();
		pRentInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB300\uC5EC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(pRentInfo, BorderLayout.CENTER);
		pRentInfo.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblRentCode = new JLabel("대여코드");
		lblRentCode.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblRentCode);
		
		tfRentCode = new JTextField();
		tfRentCode.setHorizontalAlignment(SwingConstants.CENTER);
		tfRentCode.setEditable(false);
		pRentInfo.add(tfRentCode);
		tfRentCode.setColumns(10);
		
		JLabel lblCarName = new JLabel("차량명");
		lblCarName.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblCarName);
		
		tfCarName = new JTextField();
		tfCarName.setHorizontalAlignment(SwingConstants.CENTER);
		tfCarName.setEditable(false);
		pRentInfo.add(tfCarName);
		tfCarName.setColumns(10);
		
		JLabel lblCstmCode = new JLabel("고객코드");
		lblCstmCode.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblCstmCode);
		
		tfCstmCode = new JTextField();
		tfCstmCode.setHorizontalAlignment(SwingConstants.CENTER);
		tfCstmCode.setEditable(false);
		pRentInfo.add(tfCstmCode);
		tfCstmCode.setColumns(10);
		
		JLabel lblCstmName = new JLabel("고객명");
		lblCstmName.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblCstmName);
		
		tfCstmName = new JTextField();
		tfCstmName.setHorizontalAlignment(SwingConstants.CENTER);
		tfCstmName.setEditable(false);
		pRentInfo.add(tfCstmName);
		tfCstmName.setColumns(10);
		
		JLabel lblStartDate = new JLabel("대여일");
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblStartDate);
		
		tfStartDate = new JTextField();
		tfStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		tfStartDate.setEditable(false);
		pRentInfo.add(tfStartDate);
		tfStartDate.setColumns(10);
		
		JLabel lblStartTime = new JLabel("대여시간");
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblStartTime);
		
		tfStartTime = new JTextField();
		tfStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfStartTime.setEditable(false);
		pRentInfo.add(tfStartTime);
		tfStartTime.setColumns(10);
		
		JLabel lblEndDate = new JLabel("반납일");
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblEndDate);
		
		tfEndDate = new JTextField();
		tfEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		tfEndDate.setEditable(false);
		pRentInfo.add(tfEndDate);
		tfEndDate.setColumns(10);
		
		JLabel lblEndTime = new JLabel("반납시간");
		lblEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblEndTime);
		
		tfEndTime = new JTextField();
		tfEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfEndTime.setEditable(false);
		pRentInfo.add(tfEndTime);
		tfEndTime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		pRentInfo.add(lblNewLabel);
		
		JLabel lblExcessCosts = new JLabel("초과 비용");
		lblExcessCosts.setFont(new Font("굴림", Font.BOLD, 12));
		lblExcessCosts.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblExcessCosts);
		
		JLabel lblResult = new JLabel("");
		lblResult.setFont(new Font("굴림", Font.BOLD, 12));
		lblResult.setForeground(Color.RED);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblResult);
		
		JLabel lblNewLabel_2 = new JLabel("");
		pRentInfo.add(lblNewLabel_2);
		
		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		
		JButton btnReturn = new JButton("반납");
		pBtn.add(btnReturn);

	}

}
