package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Rent;

public class RentResultFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfCustomer;
	private JTextField tfStartDate;
	private JTextField tfStartTime;
	private JTextField tfCarName;
	private JTextField tfEndDate;
	private JTextField tfEndTime;
	private JTextField tfOption;
	private JTextField tfInsurance;
	private Rent rent;

	/**
	 * Create the frame.
	 */
	public RentResultFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uB300\uC5EC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pWrap = new JPanel();
		contentPane.add(pWrap);
		pWrap.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel pCar = new JPanel();
		pWrap.add(pCar);
		pCar.setLayout(new BorderLayout(0, 0));
		
		JPanel pCarInfo = new JPanel();
		pCar.add(pCarInfo, BorderLayout.NORTH);
		pCarInfo.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblCarName = new JLabel("차량명");
		lblCarName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCarName.setHorizontalAlignment(SwingConstants.CENTER);
		pCarInfo.add(lblCarName);
		
		tfCarName = new JTextField();
		tfCarName.setEditable(false);
		pCarInfo.add(tfCarName);
		tfCarName.setColumns(10);
		
		JPanel pCarImg = new JPanel();
		FlowLayout fl_pCarImg = (FlowLayout) pCarImg.getLayout();
		fl_pCarImg.setVgap(10);
		fl_pCarImg.setHgap(10);
		pCar.add(pCarImg, BorderLayout.CENTER);
		
		JPanel pInfo = new JPanel();
		pWrap.add(pInfo);
		pInfo.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblCustomer = new JLabel("고객명");
		lblCustomer.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblCustomer);
		
		tfCustomer = new JTextField();
		tfCustomer.setEditable(false);
		pInfo.add(tfCustomer);
		tfCustomer.setColumns(10);
		
		JLabel lblStartDate = new JLabel("대여일자");
		lblStartDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblStartDate);
		
		tfStartDate = new JTextField();
		tfStartDate.setEditable(false);
		pInfo.add(tfStartDate);
		tfStartDate.setColumns(10);
		
		JLabel lblStartTime = new JLabel("대여시간");
		lblStartTime.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblStartTime);
		
		tfStartTime = new JTextField();
		tfStartTime.setEditable(false);
		pInfo.add(tfStartTime);
		tfStartTime.setColumns(10);
		
		JLabel lblEndDate = new JLabel("반납일자");
		lblEndDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblEndDate);
		
		tfEndDate = new JTextField();
		tfEndDate.setEditable(false);
		pInfo.add(tfEndDate);
		tfEndDate.setColumns(10);
		
		JLabel lblEndTime = new JLabel("반납시간");
		lblEndTime.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblEndTime);
		
		tfEndTime = new JTextField();
		tfEndTime.setEditable(false);
		pInfo.add(tfEndTime);
		tfEndTime.setColumns(10);
		
		JLabel lblInsucrance = new JLabel("보험 선택");
		lblInsucrance.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblInsucrance.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblInsucrance);
		
		tfInsurance = new JTextField();
		tfInsurance.setEditable(false);
		pInfo.add(tfInsurance);
		tfInsurance.setColumns(10);
		
		JLabel lblOption = new JLabel("옵션 선택");
		lblOption.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblOption);
		
		tfOption = new JTextField();
		tfOption.setEditable(false);
		pInfo.add(tfOption);
		tfOption.setColumns(10);
		
		JLabel lblTitleDiscount = new JLabel("할인");
		lblTitleDiscount.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblTitleDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblTitleDiscount);
		
		JLabel lblDiscount = new JLabel("New label");
		lblDiscount.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblDiscount);
		
		JLabel lblPriceTitle = new JLabel("최종 대여요금");
		lblPriceTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblPriceTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblPriceTitle);
		
		JLabel lblPrice = new JLabel("New label");
		lblPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblPrice);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		JButton btnRent = new JButton("대여");
		btnRent.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pBtn.add(btnRent);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pBtn.add(btnCancel);
	}
	
	public void setRent(Rent rent) {
		this.rent = rent;
		setItems();
	}
	
	public void setItems() {
		tfCarName.setText(rent.getCarCode().getName()); //차량명
		tfCustomer.setText(rent.getCustomerCode().getName()); //고객명
		tfStartDate.setText(rent.getStartDate()); //대여일자
		tfStartTime.setText(rent.getStartTime()); //대여시간
		tfEndDate.setText(rent.getEndDate());	//반납일자
		tfEndTime.setText(rent.getEndTime());	//반납시간
		tfInsurance.setText(rent.getInsuranceCode().getPrice()+"");	//보험가격
	}

}
