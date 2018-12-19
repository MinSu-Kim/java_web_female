package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton btnClose;
	private JButton btnRent;
	private CarModel selectedCarModel;
	private JLabel lblResultPrice;
	private InsurancePanel pInsurance;
	private OptionInfoPanel pOption;
	
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

		RentInfoPanel pRentInfo = new RentInfoPanel(service);
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
		lblResultPrice.setForeground(Color.RED);
		
		pPrice.add(lblResultPrice);

		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnRent = new JButton("확인");
		btnRent.addActionListener(this);
		btnRent.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnRent);

		btnClose = new JButton("닫기");
		btnClose.addActionListener(this);
		btnClose.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnClose);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setSelectedCarModel(CarModel selectedCarModel) {
		this.selectedCarModel = selectedCarModel;
		JOptionPane.showMessageDialog(null, selectedCarModel);
		
		pInsurance.setSelectedCarModel(selectedCarModel);
		int price = pOption.getTotalOptionPrice();
		JOptionPane.showMessageDialog(null, price);
		lblResultPrice.setText(selectedCarModel.getName() + " option price" + price);
	}
	
	
}
