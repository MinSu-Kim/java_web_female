package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class RentPanel extends JPanel implements ActionListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private RentUIService service;
	private JButton btnOk;
	private CarModel selectedCarModel;
	private JLabel lblResultPrice;
	private InsurancePanel pInsurance;
	private OptionInfoPanel pOption;
	private List<CarOption> optionPriceList;
	private RentInfoPanel pRentInfo;
	private Insurance insurance;
	private Customer selectedCustomer;
	private int maxEventRate;
	private RentDateDto rentDateDto;
	private JLabel lblPriceInfo;
	private RentResultFrame rentResultFrame;
	private int cGradeRate;
	private boolean isEventRate;
	private Rent rent;
	private long totalPrice;
	private int optionPrice;

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
		pPrice.setLayout(new GridLayout(0, 1, 10, 0));

		lblPriceInfo = new JLabel("");
		lblPriceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		pPrice.add(lblPriceInfo);

		JPanel panel = new JPanel();
		pPrice.add(panel);
		panel.setLayout(new GridLayout(0, 2, 5, 5));

		JLabel lblPrice = new JLabel("최종 요금");
		panel.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		lblResultPrice = new JLabel("New label");
		panel.add(lblResultPrice);
		lblResultPrice.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblResultPrice.setForeground(Color.RED);

		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		btnOk.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnOk);
	}

	public void setSelectedCarModel(CarModel selectedCarModel) {
		this.selectedCarModel = selectedCarModel;
//		JOptionPane.showMessageDialog(null, selectedCarModel);
		pInsurance.setSelectedDefault();
		pInsurance.setSelectedCarModel(selectedCarModel);
		getTotalRentPrice();
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
		maxEventRate = -1;

		for (CustomEvent ce : selectedCustomer.getEvents()) {
//			JOptionPane.showMessageDialog(null, ce);
			for (Event e : ce.getEvents()) {
//				JOptionPane.showMessageDialog(null, e);
				// 가장 큰 이벤트 할인율 가져오기
				if (e.getRate() > maxEventRate) {
					maxEventRate = e.getRate();
				}
			}
		}
		cGradeRate = this.selectedCustomer.getGradeCode().getRate();

		isEventRate = maxEventRate > cGradeRate ? true : false;

//		System.out.println("등급 할인율" + selectedCustomer.getGradeCode().getRate());
		// 이벤트 할인율 중 가장 높은 값 들고오기
//		JOptionPane.showMessageDialog(null, maxEventRate);
		getTotalRentPrice();

	}

	// 요금
	public long getTotalRentPrice() {
		totalPrice = 0;

		// 차량기본비용
		int basicCharge = selectedCarModel.getBasicCharge();
		optionPrice = pOption.getTotalOptionPrice();
		StringBuilder sb = new StringBuilder();
		if (optionPriceList != null) {
			for (CarOption co : optionPriceList) {
				sb.append(co.getName());
				sb.append(" ");
				/* sb.append(co.getPrice()); */
			}
		}

//		JOptionPane.showMessageDialog(null, optionPrice);
		long diff = 1;
		if (rentDateDto != null) {
			diff = rentDateDto.getDiff();
		}
		totalPrice = ((basicCharge * diff) + (insurance == null ? 0 : insurance.getPrice()) + optionPrice)
				* (100 - maxEventRate) / 100;

		System.out.println("rentDate" + rentDateDto);
//		rent = new Rent(service.nextRentNo(), rentDateDto.getStartDate(), rentDateDto.getStartHour(), rentDateDto.getEndDate(), rentDateDto.getEndHour(), false, totalPrice, selectedCarModel, selectedCustomer, insurance, isEventRate?maxEventRate:cGradeRate ,optionPrice);
		//
		String msg = String.format("차량 기본비용 %d, 대여일 %s, 보험가격 %d, 옵션가격 %d(%s), 할인율 %d", basicCharge, rentDateDto,
				(insurance == null ? 0 : insurance.getPrice()), optionPrice, sb.length() == 0 ? "" : sb, isEventRate ? maxEventRate : cGradeRate);

		lblPriceInfo.setText(msg);
		lblResultPrice.setText(totalPrice + "원");

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			do_btnCstmSearch_actionPerformed(e);
		}
	}

	// 확인버튼
	private void do_btnCstmSearch_actionPerformed(ActionEvent e) {
		
		Rent rent = new Rent(service.nextRentNo(), rentDateDto.getStartDate(), rentDateDto.getStartHour(),
				rentDateDto.getEndDate(), rentDateDto.getEndHour(), false, totalPrice, selectedCarModel,
				selectedCustomer, insurance, isEventRate ? maxEventRate : cGradeRate, optionPrice);
		System.out.println(rent);
		if (rentResultFrame == null) {
			rentResultFrame = new RentResultFrame();
		}
		rentResultFrame.setService(service);
		rentResultFrame.setRent(rent);

//		rentResultFrame.setLblPrice(getTotalRentPrice());
		rentResultFrame.setVisible(true);
	}

}
