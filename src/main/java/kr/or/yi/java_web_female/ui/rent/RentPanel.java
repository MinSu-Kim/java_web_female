package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;

@SuppressWarnings("serial")
public class RentPanel extends JPanel implements ActionListener{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private CustomerSearchFrame cf; // 고객확인프레임
	private CarSearchFrame csf;	//차량선택프레임
	private RentUIService service;
	private Customer rentCustomer;
	private JTextField tfCstmName;
	private JButton btnSearch;
	private JButton btnClose;
	private JComboBox<String> comboBoxCar;
	private List<CarType> list;
	private JButton btnRent;
	private JButton btnSearchCar;
	private CarModel selectedCarModel;
	
	public RentPanel() {
		service = new RentUIService();
		initComponents();
		loadComboCarType();
		
	}

	private void loadComboCarType() {
		list = service.selectAllCarTypes();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		for(CarType ct : list) {
			model.addElement(ct.getType());
		}
		comboBoxCar.setModel(model);
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

		JPanel pCarInfo = new JPanel();
		pCarInfo.setBorder(new TitledBorder(null, "\uCC28\uB7C9 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		pContents.add(pCarInfo);
		pCarInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		pCarInfo.add(panel);

		JLabel lblChoiceCar = new JLabel("차종 선택");
		panel.add(lblChoiceCar);

		
		comboBoxCar = new JComboBox<>();
		panel.add(comboBoxCar);

		btnSearchCar = new JButton("선택");
		btnSearchCar.addActionListener(this);
		panel.add(btnSearchCar);

		JPanel pInfo = new JPanel();
		pInfo.setBorder(new TitledBorder(null, "\uAC1C\uC778 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		pContents.add(pInfo);
		pInfo.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblCstmName = new JLabel("고객명");
		lblCstmName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCstmName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pInfo.add(lblCstmName);

		JPanel pSearchCstm = new JPanel();
		pInfo.add(pSearchCstm);
		pSearchCstm.setLayout(new GridLayout(0, 2, 10, 0));

		tfCstmName = new JTextField();
		tfCstmName.setColumns(10);
		pSearchCstm.add(tfCstmName);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pSearchCstm.add(btnSearch);

		JPanel pRentInfo = new JPanel();
		pRentInfo.setBorder(new TitledBorder(null, "\uB300\uC5EC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		pContents.add(pRentInfo);
		pRentInfo.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pStart = new JPanel();
		pRentInfo.add(pStart);
		pStart.setLayout(new GridLayout(0, 2, 10, 0));

		JPanel pStartDate = new JPanel();
		pStart.add(pStartDate);
		pStartDate.setLayout(new GridLayout(0, 2, 10, 0));

		JLabel lblStartDate = new JLabel("대여일자");
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pStartDate.add(lblStartDate);

		dateChooser_2 = new JDateChooser();
		pStartDate.add(dateChooser_2);

		JPanel pEndTime_1 = new JPanel();
		pStart.add(pEndTime_1);
		pEndTime_1.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel lblEndTime_1 = new JLabel("대여시간");
		lblEndTime_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime_1.add(lblEndTime_1);

		spStartHour = new JSpinner();
		pEndTime_1.add(spStartHour);

		JLabel lblStartHour = new JLabel("시");
		lblStartHour.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime_1.add(lblStartHour);

		spStartMinutes = new JSpinner();
		pEndTime_1.add(spStartMinutes);

		JLabel lblStartMinutes = new JLabel("분");
		lblStartMinutes.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime_1.add(lblStartMinutes);

		JPanel pEnd = new JPanel();
		pRentInfo.add(pEnd);
		pEnd.setLayout(new GridLayout(0, 2, 10, 0));

		JPanel pEndDate = new JPanel();
		pEnd.add(pEndDate);
		pEndDate.setLayout(new GridLayout(0, 2, 10, 0));

		JLabel lblEndDate = new JLabel("반납일자");
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndDate.add(lblEndDate);

		dateChooser_3 = new JDateChooser();
		pEndDate.add(dateChooser_3);

		JPanel pEndTime = new JPanel();
		pEnd.add(pEndTime);
		pEndTime.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel lblEndTime = new JLabel("반납시간");
		lblEndTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndTime);

		spEndHour = new JSpinner();
		pEndTime.add(spEndHour);

		JLabel lblEndHour = new JLabel("시");
		lblEndHour.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndHour);

		spEndMinutes = new JSpinner();
		pEndTime.add(spEndMinutes);

		JLabel lblEndMinutes = new JLabel("분");
		lblEndMinutes.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndMinutes);

		JPanel pInsurance = new JPanel();
		pInsurance.setBorder(new TitledBorder(null, "\uBCF4\uD5D8 \uAC00\uC785\uC5EC\uBD80", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pContents.add(pInsurance);
		pInsurance.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblInsurance = new JLabel("자차손해 면책 제도");
		lblInsurance.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsurance.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pInsurance.add(lblInsurance);

		JPanel pRb = new JPanel();
		pInsurance.add(pRb);
		pRb.setLayout(new GridLayout(0, 2, 0, 0));

		JRadioButton rBNotReg = new JRadioButton("가입안함");
		rBNotReg.setHorizontalAlignment(SwingConstants.CENTER);
		rBNotReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		buttonGroup.add(rBNotReg);
		pRb.add(rBNotReg);

		JRadioButton rBReg = new JRadioButton("일반자차");
		rBReg.setHorizontalAlignment(SwingConstants.CENTER);
		rBReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		buttonGroup.add(rBReg);
		pRb.add(rBReg);

		pOption = new JPanel();
		pOption.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"\uC635\uC158 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addCarOption();
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

	private void addCarOption() {
		coList = service.selectAllCarOptions();
		for(CarOption co : coList) {
			JCheckBox cb = new JCheckBox(co.getName());
//			cb.addActionListener(chkListener);
			pOption.add(cb);
			if(co.getName().equals("driver")) {
				cb.setEnabled(false);
			}
		}
	}

/*	ActionListener chkListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, e.getActionCommand());
			
		}
	};*/
	
	private List<CarOption> coList;
	private JPanel pOption;
	private JCheckBox cb;
	private List<CarOption> selectCoList;
	private JDateChooser dateChooser_2;
	private JSpinner spStartHour;
	private JSpinner spStartMinutes;
	private JDateChooser dateChooser_3;
	private JSpinner spEndMinutes;
	private JSpinner spEndHour;
	private JLabel lblResultPrice;
	private List<CarModel> carModelList;
	private int selectedIndex;
	private Customer customer;
	private String startDate;
	private String sHour;
	private String sMinutes;
	private String endDate;
	private String eHour;
	private String eMinutes;
	private int basicCharge;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRent) {
			try {
				do_btnRent_actionPerformed(e);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnClose) {
			do_btnClose_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
		if (e.getSource() == btnSearchCar) {
			do_btnSearchCar_actionPerformed(e);
		}
	}

	public void setRentCustomer(Customer rentCustomer) {
		this.rentCustomer = rentCustomer;
		JOptionPane.showMessageDialog(null, "선택된 고객 " + rentCustomer);
	}
	

	// 검색버튼
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		customer = new Customer();
		if (cf == null) {
			if (tfCstmName.getText().trim().length() > 1) {
				customer.setName(tfCstmName.getText().trim());
			} else {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
			}
			try {
				List<Customer> cList = service.selectCustomer(customer);
				if (cList.size() > 1) {
					cf = new CustomerSearchFrame();
					cf.setRentPanel(this);
					cf.setcList(cList);
					cf.setVisible(true);
				} else {
					setRentCustomer(cList.get(0));
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			if (tfCstmName.getText().trim().length() > 1) {
				customer.setName(tfCstmName.getText().trim());
			} else {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
			}
			try {
				List<Customer> cList = service.selectCustomer(customer);
				if (cList.size() > 1) {
					cf.setRentPanel(this);
					cf.setcList(cList);
					cf.setVisible(true);
				} else {
					setRentCustomer(cList.get(0));
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	// 닫기버튼
	protected void do_btnClose_actionPerformed(ActionEvent e) {

	}
	
	//대여버튼
	protected void do_btnRent_actionPerformed(ActionEvent e) throws ParseException {
		/*//옵션
		selectCoList = new ArrayList<>();
		JOptionPane.showMessageDialog(null, coList.toString());
		for(Component c : pOption.getComponents()) {
			cb = (JCheckBox) c;
			if(cb.isSelected()) {
				CarOption co = new CarOption();
				co.setName(cb.getText());
				CarOption findCo = coList.get(coList.indexOf(co));
				selectCoList.add(findCo);
				JOptionPane.showMessageDialog(null, findCo);
			}
		}*/
		//대여날짜
		Date start = dateChooser_2.getDate();
		SimpleDateFormat ssdf = new SimpleDateFormat("yyyyMMdd");
		startDate = ssdf.format(start);

		sHour = spStartHour.getValue().toString();
		sMinutes = spStartMinutes.getValue().toString();
		//반납날짜
		Date end = dateChooser_3.getDate();
		SimpleDateFormat esdf = new SimpleDateFormat("yyyyMMdd");
		endDate = esdf.format(end);
		eHour = spEndHour.getValue().toString();
		eMinutes = spEndMinutes.getValue().toString();
		
		Event evt = new Event();
		Insurance ins = new Insurance();
		Rent r = new Rent("R004", startDate, sHour+":"+sMinutes+":00", endDate, eHour+":"+eMinutes+":00", false, 60000, selectedCarModel, customer, ins, evt, 0);
		
		int shLength = sHour.length();
		int smLength = sMinutes.length();
		int ehLength = eHour.length();
		int emLength = eMinutes.length();
		
		if(shLength == 1 || smLength == 1 || ehLength == 1 | emLength == 1) {
			String startHour = "0" + sHour;
			String startMinutes = "0" + sMinutes;
			String endHour = "0" + eHour;
			String endMinutes = "0" + eMinutes;
			
//			JOptionPane.showMessageDialog(null, startHour + ", " + startMinutes + ", " + endHour + ", " + endMinutes);
			long dd = diffDays(startDate+startHour+startMinutes, endDate+endHour+endMinutes);
			lblResultPrice.setText((basicCharge*dd)+"");
			JOptionPane.showMessageDialog(null, dd);
			
		} else {
			// ========= 테스트
			long dd = diffDays(startDate+sHour+sMinutes, endDate+eHour+eMinutes);
			JOptionPane.showMessageDialog(null, dd);
		}

		RentResultFrame rrf = new RentResultFrame();
		rrf.setVisible(true);
		
	}
	
	//차량선택버튼
	protected void do_btnSearchCar_actionPerformed(ActionEvent e) {
		selectedIndex = comboBoxCar.getSelectedIndex();
		CarType ct = list.get(selectedIndex);
		
		carModelList = service.selectAllCarModels(ct);
		
		if(csf == null) {
			csf = new CarSearchFrame();
		}
		csf.setRentPanel(this);
		csf.setCarList(carModelList);
		csf.setVisible(true);
	}

	public void setSelectedCarModel(CarModel selectedCarModel) {
		this.selectedCarModel = selectedCarModel;
		
		basicCharge = selectedCarModel.getBasicCharge();
		lblResultPrice.setText(selectedCarModel.getBasicCharge()+"");
		
//		JOptionPane.showMessageDialog(null, selectedCarModel);
		if(selectedCarModel.getCarType().getCode().equals("S2")) {
			chkDriver(true);

		}else {
			chkDriver(false);
		}
		
		
	}

	private void chkDriver(boolean isChk) {
		for(Component c : pOption.getComponents()) {
			cb = (JCheckBox) c;
			if (cb.getText().equals("driver")) {
				cb.setEnabled(isChk);
				break;
			}
		}
	}
	
	//날짜, 시간
	public long diffDays(String begin, String end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		
		//String 요청시간을 Date로 바꾸기
		Date beginDate = sdf.parse(begin);
		long beginDateTime = beginDate.getTime();
		
		Date endDate = sdf.parse(end);
		long endDateTime = endDate.getTime();
		
		//차이
		long diff = endDateTime - beginDateTime;
		//24시간*60분*60초*1000밀리초 ==> 단위 "일"
		long diffDays = diff / (24*60*60*1000);
		
		
		return diffDays;
	}
}
