package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.sub.CarInfoPanel;
import kr.or.yi.java_web_female.ui.rent.sub.CustomerInfoPanel;
import kr.or.yi.java_web_female.ui.rent.sub.InsurancePanel;
import kr.or.yi.java_web_female.ui.rent.sub.OptionInfoPanel;
import kr.or.yi.java_web_female.ui.rent.sub.RentDateDto;
import kr.or.yi.java_web_female.ui.rent.sub.RentInfoPanel;

@SuppressWarnings("serial")
public class RentPanel extends JPanel implements ActionListener{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private RentUIService service;
	private JButton btnOk;
	private JButton btnTotalPrice;
	private CarModel selectedCarModel;
	private JLabel lblResultPrice;
	private InsurancePanel pInsurance;
	private OptionInfoPanel pOption;
	private List<CarOption> optionPriceList;
	private int totalPrice;
	private RentInfoPanel pRentInfo;
	private Insurance insurance;
	private Customer selectedCustomer;
	private int maxEventRate;
	private RentDateDto rentDateDto;
	
	



	public RentPanel() {
		service = new RentUIService();
		initComponents();
	}

	

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("차량 대여");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titlePanel.add(lblTitle);

		JPanel pContents = new JPanel();
		add(pContents, BorderLayout.CENTER);
		pContents.setLayout(new GridLayout(0, 1, 0, 10));

		CarInfoPanel pCarInfo = new CarInfoPanel(service);
		pCarInfo.setRentPanel(this);
		pContents.add(pCarInfo);

		CustomerInfoPanel pInfo = new CustomerInfoPanel(service);
		pInfo.setRentPanel(this);
		pContents.add(pInfo);

		pRentInfo = new RentInfoPanel(service);
		pRentInfo.setRentPanel(this);
		pContents.add(pRentInfo);

		pInsurance = new InsurancePanel(service);
		pInsurance.setRentPanel(this);
		pContents.add(pInsurance);

		pOption = new OptionInfoPanel(service);
		pOption.setRentPanel(this);
		pOption.addCarOption();
		pContents.add(pOption);

		JPanel pPrice = new JPanel();
		pPrice.setBorder(new TitledBorder(null, "\uCD5C\uC885 \uC694\uAE08", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		pContents.add(pPrice);
		pPrice.setLayout(new GridLayout(0, 2, 10, 0));

		JLabel lblPrice = new JLabel("최종 요금");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		pPrice.add(lblPrice);

		lblResultPrice = new JLabel("New label");
		lblResultPrice.setFont(new Font("Dialog", Font.BOLD, 12));
		lblResultPrice.setForeground(Color.RED);
		pPrice.add(lblResultPrice);

		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnTotalPrice = new JButton("최종 요금 계산하기");
		btnTotalPrice.addActionListener(this);
		btnTotalPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnTotalPrice);

		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		btnOk.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnOk);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTotalPrice) {
			try {
				do_btnTotalPrice_actionPerformed(e);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	//최종요금계산하기
	private void do_btnTotalPrice_actionPerformed(ActionEvent e) throws ParseException {
		// TODO Auto-generated method stub
		getTotalRentPrice();
		lblResultPrice.setText(totalPrice + "원");
	}
	
	public void setSelectedCarModel(CarModel selectedCarModel) {
		this.selectedCarModel = selectedCarModel;
//		JOptionPane.showMessageDialog(null, selectedCarModel);
		
		pInsurance.setSelectedCarModel(selectedCarModel);
		
		getTotalRentPrice();
	}
	
	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
		maxEventRate = -1;
		
		for(CustomEvent ce : selectedCustomer.getEvents()) {
//			JOptionPane.showMessageDialog(null, ce);
			for(Event e : ce.getEvents()) {
				JOptionPane.showMessageDialog(null, e);
				//가장 큰 이벤트 할인율 가져오기
				if(e.getRate() > maxEventRate) {
					maxEventRate = e.getRate();
				}
			}
		}
		JOptionPane.showMessageDialog(null, maxEventRate);
		getTotalRentPrice();
	}
	
	//요금
	public int getTotalRentPrice() {
		totalPrice = 0;
		
		//차량기본비용
		int basicCharge = selectedCarModel.getBasicCharge();
//		int diff = (int) pRentInfo.totalRentDate();
		int optionPrice = pOption.getTotalOptionPrice();
		StringBuilder sb = new StringBuilder();
		if(optionPriceList != null){
			for(CarOption co : optionPriceList) {
				sb.append(co.getName() );
				sb.append(",");
				sb.append(co.getPrice());
			}

//		JOptionPane.showMessageDialog(null, optionPrice);
//		int diff = (int) rentDateDto.getDiff();
		totalPrice = ((basicCharge) + (insurance==null?0:insurance.getPrice()) + optionPrice) * (100-maxEventRate)/100;
		
		//Rent r = new Rent(code, startDate, startTime, endDate, endTime, isReturn, diff, carCode, customerCode, insuranceCode, eRate, optPrice)
		String msg = String.format("자동차 기본비용%d, 보험가격%d, 옵션가격%d(%s), 할인율%d, 대여일정보%s", basicCharge,(insurance==null?0:insurance.getPrice()), optionPrice, sb.length()==0?"":sb, maxEventRate, rentDateDto);
		lblResultPrice.setText(msg);
//		lblResultPrice.setText(totalPrice + "원");
		return totalPrice;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
		getTotalRentPrice();
	}

	public void setOptionPriceList(List<CarOption> optionPriceList) {
		this.optionPriceList = optionPriceList;
		getTotalRentPrice();
	}

	public void setRentDateDto(RentDateDto rentDateDto) {
		this.rentDateDto = rentDateDto;
		getTotalRentPrice();
	}
	
	
}
