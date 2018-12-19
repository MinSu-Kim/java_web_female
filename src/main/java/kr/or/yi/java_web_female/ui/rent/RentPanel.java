package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.sub.CarInfoPanel;
import kr.or.yi.java_web_female.ui.rent.sub.CustomerInfoPanel;
import kr.or.yi.java_web_female.ui.rent.sub.InsurancePanel;
import kr.or.yi.java_web_female.ui.rent.sub.OptionInfoPanel;
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
	private int totalPrice;
	private RentInfoPanel pRentInfo;
	
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
		pContents.add(pInfo);

		pRentInfo = new RentInfoPanel(service);
		pContents.add(pRentInfo);

		pInsurance = new InsurancePanel(service);
		pContents.add(pInsurance);

		pOption = new OptionInfoPanel(service);
		
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
		lblResultPrice.setText("totalPrice : " + totalPrice);
	}
	
	public void setSelectedCarModel(CarModel selectedCarModel) {
		this.selectedCarModel = selectedCarModel;
//		JOptionPane.showMessageDialog(null, selectedCarModel);
		
		pInsurance.setSelectedCarModel(selectedCarModel);
		int price = pOption.getTotalOptionPrice();
		JOptionPane.showMessageDialog(null, price);
	}
	
	//요금
	public int getTotalRentPrice() throws ParseException {
		totalPrice = 0;
		
		//차량기본비용
		int basicCharge = selectedCarModel.getBasicCharge();
		int diff = (int) pRentInfo.totalRentDate();
		
		totalPrice = (basicCharge * diff);
		
		return totalPrice;
	}
	
}
