package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.UserPic;
import kr.or.yi.java_web_female.service.RentUIService;
import java.awt.Dimension;
import java.awt.Color;

public class RentResultFrame extends JFrame implements ActionListener {

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
	private JLabel lblPrice;
	private JTextField tfDiscount;
	private JButton btnCancel;
	private JLabel lblCarImg;
	private RentUIService service;
	private JButton btnRent;

	public void setService(RentUIService service) {
		this.service = service;
	}

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
		
		lblCarImg = new JLabel("");
		lblCarImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarImg.setPreferredSize(new Dimension(250, 150));
		pCar.add(lblCarImg, BorderLayout.CENTER);
		
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
		
		JLabel lblInsucrance = new JLabel("보험 가격");
		lblInsucrance.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblInsucrance.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblInsucrance);
		
		tfInsurance = new JTextField();
		tfInsurance.setEditable(false);
		pInfo.add(tfInsurance);
		tfInsurance.setColumns(10);
		
		JLabel lblOption = new JLabel("옵션 가격");
		lblOption.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblOption);
		
		tfOption = new JTextField();
		tfOption.setEditable(false);
		pInfo.add(tfOption);
		tfOption.setColumns(10);
		
		JLabel lblTitleDiscount = new JLabel("할인율");
		lblTitleDiscount.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblTitleDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblTitleDiscount);
		
		tfDiscount = new JTextField();
		tfDiscount.setEditable(false);
		pInfo.add(tfDiscount);
		tfDiscount.setColumns(10);
		
		JLabel lblPriceTitle = new JLabel("최종 대여요금");
		lblPriceTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblPriceTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblPriceTitle);
		
		lblPrice = new JLabel("");
		lblPrice.setForeground(Color.RED);
		lblPrice.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pInfo.add(lblPrice);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnRent = new JButton("대여");
		btnRent.addActionListener(this);
		btnRent.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pBtn.add(btnRent);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pBtn.add(btnCancel);
	}

	public void setRent(Rent rent) {
		this.rent = rent;
		setItems();
		loadImages();
		///////isReturn : false 반납X true : 반납O ==> 대여버튼 누르면 true로 변경되게 하기
//		JOptionPane.showMessageDialog(null, rent.isReturn());
	}
	

	public void setItems() {
		tfCarName.setText(rent.getCarCode().getName()); //차량명
		tfCustomer.setText(rent.getCustomerCode().getName()); //고객명
		tfStartDate.setText(rent.getStartDate()); //대여일자
		tfStartTime.setText(rent.getStartTime()); //대여시간
		tfEndDate.setText(rent.getEndDate());	//반납일자
		tfEndTime.setText(rent.getEndTime());	//반납시간
		tfInsurance.setText(rent.getInsuranceCode().getPrice() + "원");	//보험가격
		tfOption.setText(rent.getOptPrice() + "원");

	}

	public void setDisCount(int discount) {
		tfDiscount.setText(String.format("%s", discount+"%"));
	}
	
	public void setLblPrice(long lblPrice) {
		this.lblPrice.setText(String.format("%,d원", lblPrice));
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRent) {
			do_btnRent_actionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
	}
	
	//취소버튼
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	public void loadImages() {
		UserPic userPic = service.getUserPic(rent.getCarCode().getCarCode());
		
		ImageIcon img = new ImageIcon(userPic.getPic());
		Image image = img.getImage();
		Image changedImg= image.getScaledInstance(350, 250, Image.SCALE_SMOOTH );
		ImageIcon resimg = new ImageIcon(changedImg);
		lblCarImg.setIcon(resimg);
	}
	
	
	//대여버튼 ==> rent 테이블에 데이터 들어가게 하기
	protected void do_btnRent_actionPerformed(ActionEvent e) {
/*		Map<String, Object> map = new HashMap<>();
		map.put("custom_code", rent.getCustomerCode().getCode());
		map.put("rent_code", service.nextRentNo());
		map.put("carCode", rent.getCarCode().getCarCode());
		map.put("isGrade", rent.geteRate() < rent.getCustomerCode().getGradeCode().getRate() ? 1 : 0);
		
		service.insertRent(rent, map);*/
		service.insertRent(rent);
		dispose();
	}
}
