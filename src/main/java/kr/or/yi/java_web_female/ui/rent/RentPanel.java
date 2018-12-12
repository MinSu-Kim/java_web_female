package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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

import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.service.RentUIService;

@SuppressWarnings("serial")
public class RentPanel extends JPanel implements ActionListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private CustomerSearchFrame cf; // 고객확인프레임
	private RentUIService service;
	private Customer rentCustomer;
	private JTextField tfCstmName;
	private JButton btnSearch;
	private JButton btnClose;
	private JComboBox<String> comboBoxCar;
	private List<CarType> list;
	private JButton btnRent;

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

		JButton btnSearchCar = new JButton("선택");
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

		JDateChooser dateChooser_2 = new JDateChooser();
		pStartDate.add(dateChooser_2);

		JPanel pEndTime_1 = new JPanel();
		pStart.add(pEndTime_1);
		pEndTime_1.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel lblEndTime_1 = new JLabel("대여시간");
		lblEndTime_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime_1.add(lblEndTime_1);

		JSpinner spStartHour = new JSpinner();
		pEndTime_1.add(spStartHour);

		JLabel lblStartHour = new JLabel("시");
		lblStartHour.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime_1.add(lblStartHour);

		JSpinner spStartMinutes = new JSpinner();
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

		JDateChooser dateChooser_3 = new JDateChooser();
		pEndDate.add(dateChooser_3);

		JPanel pEndTime = new JPanel();
		pEnd.add(pEndTime);
		pEndTime.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel lblEndTime = new JLabel("반납시간");
		lblEndTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndTime);

		JSpinner spEndHour = new JSpinner();
		pEndTime.add(spEndHour);

		JLabel lblEndHour = new JLabel("시");
		lblEndHour.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndHour);

		JSpinner spEndMinutes = new JSpinner();
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

		JPanel pOption = new JPanel();
		pOption.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"\uC635\uC158 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

		JLabel lblResultPrice = new JLabel("New label");
		lblResultPrice.setForeground(Color.RED);
		lblResultPrice.setFont(new Font("Dialog", Font.BOLD, 14));
		pPrice.add(lblResultPrice);

		JPanel pBtn = new JPanel();
		add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnRent = new JButton("대여");
		btnRent.addActionListener(this);
		btnRent.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnRent);

		btnClose = new JButton("닫기");
		btnClose.addActionListener(this);
		btnClose.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pBtn.add(btnClose);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRent) {
			do_btnRent_actionPerformed(e);
		}
		if (e.getSource() == btnClose) {
			do_btnClose_actionPerformed(e);
		}
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}

	public void setRentCustomer(Customer rentCustomer) {
		this.rentCustomer = rentCustomer;
		JOptionPane.showMessageDialog(null, "선택된 고객 " + rentCustomer);
	}

	// 검색버튼
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		if (cf == null) {
			Customer customer = new Customer();
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
			Customer customer = new Customer();
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
	protected void do_btnRent_actionPerformed(ActionEvent e) {
		int selectedIndex = comboBoxCar.getSelectedIndex();
		CarType ct = list.get(selectedIndex);
		JOptionPane.showMessageDialog(null, selectedIndex + "," + ct);
	}
}