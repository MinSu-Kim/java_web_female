package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.RentResultFrame;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.SpinnerNumberModel;

public class RentInfoPanel extends CarSubPanel {
	
	/**
	 * Create the panel.
	 */
	public RentInfoPanel(RentUIService service) {
		super(service);
		initComponents();
	}
	
	private void initComponents() {
		setBorder(new TitledBorder(null, "\uB300\uC5EC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		//대여
		JPanel pStart = new JPanel();
		add(pStart);
		pStart.setLayout(new GridLayout(0, 2, 10, 0));

		//대여일자
		JPanel pStartDate = new JPanel();
		pStart.add(pStartDate);
		pStartDate.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblStartDate = new JLabel("대여일자");
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pStartDate.add(lblStartDate);

		JDateChooser dateChooserStart = new JDateChooser();
		pStartDate.add(dateChooserStart);
		
		//대여시간
		JPanel pStartTime = new JPanel();
		pStart.add(pStartTime);
		pStartTime.setLayout(new GridLayout(0, 3, 10, 10));
		
		JLabel lblStartTime = new JLabel("대여시간");
		lblStartTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		pStartTime.add(lblStartTime);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(10, 1, 24, 1));
		pStartTime.add(spinner);
		
		JLabel lblNewLabel = new JLabel("시");
		pStartTime.add(lblNewLabel);
		
		//반납
		JPanel pEnd = new JPanel();
		add(pEnd);
		pEnd.setLayout(new GridLayout(0, 2, 10, 0));

		//반납일자
		JPanel pEndDate = new JPanel();
		pEnd.add(pEndDate);
		pEndDate.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblEndDate = new JLabel("반납일자");
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndDate.add(lblEndDate);

		JDateChooser dateChooserEnd = new JDateChooser();
		pEndDate.add(dateChooserEnd);

		//반납시간
		JPanel pEndTime = new JPanel();
		pEnd.add(pEndTime);
		pEndTime.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblEndTime = new JLabel("반납시간");
		lblEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndTime);

		JSpinner spEndHour = new JSpinner();
		spEndHour.setModel(new SpinnerNumberModel(10, 1, 24, 1));
		pEndTime.add(spEndHour);

		JLabel lblEndHour = new JLabel("시");
		lblEndHour.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndHour.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndHour);
	}
	
	//날짜, 시간
	public long diffDays(String begin, String end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");

		// String 요청시간을 Date로 바꾸기
		Date beginDate = sdf.parse(begin);
		long beginDateTime = beginDate.getTime();

		Date endDate = sdf.parse(end);
		long endDateTime = endDate.getTime();

		// 차이
		long diff = endDateTime - beginDateTime;
		// 24시간*60분*60초*1000밀리초 ==> 단위 "일"
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;
	}

	/*//================================== 시간정보 =======================
	//대여날짜
	Date start = dateChooser_2.getDate();
	SimpleDateFormat ssdf = new SimpleDateFormat("yyyyMMdd");startDate=ssdf.format(start);

	sHour=spStartHour.getValue().toString();sMinutes=spStartMinutes.getValue().toString();
	// 반납날짜
	Date end = dateChooser_3.getDate();
	SimpleDateFormat esdf = new SimpleDateFormat(
			"yyyyMMdd");endDate=esdf.format(end);eHour=spEndHour.getValue().toString();eMinutes=spEndMinutes.getValue().toString();

	Event evt = new Event();
	Insurance ins = new Insurance("I000", "S0", 0);
	Rent r = new Rent("R004", startDate, sHour + ":" + sMinutes + ":00", endDate, eHour + ":" + eMinutes + ":00", false,
			60000, selectedCarModel, customer, ins, evt, 0);

	int shLength = sHour.length();
	int smLength = sMinutes.length();
	int ehLength = eHour.length();
	int emLength = eMinutes.length();

	if(shLength==1||smLength==1||ehLength==1|emLength==1)
	{
		String startHour = "0" + sHour;
		String startMinutes = "0" + sMinutes;
		String endHour = "0" + eHour;
		String endMinutes = "0" + eMinutes;

//				JOptionPane.showMessageDialog(null, startHour + ", " + startMinutes + ", " + endHour + ", " + endMinutes);
		long dd = diffDays(startDate + startHour + startMinutes, endDate + endHour + endMinutes);
		lblResultPrice.setText((basicCharge * dd) + "");
		JOptionPane.showMessageDialog(null, dd);

	}else
	{
		// ========= 테스트
		long dd = diffDays(startDate + sHour + sMinutes, endDate + eHour + eMinutes);
		JOptionPane.showMessageDialog(null, dd);
	}

	RentResultFrame rrf = new RentResultFrame();rrf.setRent(r); // RentResultFrame에서 만든 setter
	rrf.setVisible(true);*/
}
