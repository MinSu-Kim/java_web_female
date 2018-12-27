package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.ui.rent.RentListPanel;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private JLabel lblResult;
	
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
		lblResult.setText(getOverdueFee() + "");
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
		
		JLabel lblOverdue = new JLabel("초과 비용");
		lblOverdue.setFont(new Font("굴림", Font.BOLD, 12));
		lblOverdue.setHorizontalAlignment(SwingConstants.CENTER);
		pRentInfo.add(lblOverdue);
		
		lblResult = new JLabel("");
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
	
	public long getOverdueFee() {
		long overdueFee = 0;
		
		//연체료구하기
		//오늘날짜시간 - 반납일 ==> 단위 : 시간으로 구하기 ==> car_model 테이블에 있는 초과비용
		long exceed = ExceedHours();
		JOptionPane.showMessageDialog(null, exceed);
		
		return overdueFee;
	}
	
	public long ExceedHours() {
		//오늘 날짜
		Date start = new Date();
		SimpleDateFormat todaySdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = todaySdf.format(start);
		JOptionPane.showMessageDialog(null, "today " + today);
		
		//반납일
		String endDate = rent.getEndDate();
		String endHour = rent.getEndTime();
		
		long diff = diffHours(today, endDate + endHour);
		
		return diff;
	} 
	
	public long diffHours(String today, String end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		long diffHours = 0;
		
		
		try {
			Date todayDate = sdf.parse(today);
			JOptionPane.showMessageDialog(null, "today" + today);
			JOptionPane.showMessageDialog(null, "todayDate yyyyMMddHH " + todayDate);
			long todayTime = todayDate.getTime();
			
			Date endDate = sdf.parse(end);
			long endTime = endDate.getTime();
			
			long diff = todayTime - endTime;
			JOptionPane.showMessageDialog(null, "todayTime " + todayTime + "endTime " + endTime);
			diffHours = diff / ( 1000 * 60 * 60 );
			JOptionPane.showMessageDialog(null, diffHours);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return diffHours;
	}

}
