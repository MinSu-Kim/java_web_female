package kr.or.yi.java_web_female.ui.rent.sub;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dao.RentMapper;
import kr.or.yi.java_web_female.dao.RentMapperImpl;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.RentHour;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.list.RentList;
import kr.or.yi.java_web_female.ui.login.LoginUI;
import kr.or.yi.java_web_female.ui.rent.AllRentPanel;
import kr.or.yi.java_web_female.ui.rent.RentListPanel;

@SuppressWarnings("serial")
public class RentListInfoPanel extends JPanel implements ActionListener {
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
	private JButton btnReturn;
	private RentUIService service;
	private RentListPanel rentListPanel;
	private AllRentPanel allRentPanel;
	
	public void setAllRentPanel(AllRentPanel allRentPanel) {
		this.allRentPanel = allRentPanel;
	}

	public void setRentListPanel(RentListPanel rentListPanel) {
		this.rentListPanel = rentListPanel;
	}

	public void setService(RentUIService service) {
		this.service = service;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
//		JOptionPane.showMessageDialog(null, rent);
		tfRentCode.setText(rent.getCode());
		tfCarName.setText(rent.getCarCode().getName());
		tfCstmCode.setText(rent.getCustomerCode().getCode());
		tfCstmName.setText(rent.getCustomerCode().getName());
		tfStartDate.setText(rent.getStartDate());
		tfStartTime.setText(rent.getEndTime());
		tfEndDate.setText(rent.getEndDate());
		tfEndTime.setText(rent.getEndTime());
		RentMapper dao = RentMapperImpl.getInstance();
		Map<String, String> map = new HashMap<>();
		map.put("carCode", rent.getCarCode().getCarCode());
		map.put("rCode", rent.getCode());
		
		RentHour result = dao.selectRentHours(map);
//		JOptionPane.showMessageDialog(null, result);
		lblResult.setText(result.getAddPrice() + "원");
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
		
		btnReturn = new JButton("반납");
		btnReturn.addActionListener(this);
		pBtn.add(btnReturn);

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReturn) {
			do_btnReturn_actionPerformed(e);
		}
	}
	
	//반납버튼
	protected void do_btnReturn_actionPerformed(ActionEvent e) {
		service.changeIsReturn(rent);
		JOptionPane.showMessageDialog(null, "반납되었습니다.");
		
		if(LoginUI.loginCusotmer == null) {
			rentListPanel.reloadList();
/*			allRentPanel.reloadList();
			JOptionPane.showMessageDialog(null, allRentPanel);*/
		}
	}
}
