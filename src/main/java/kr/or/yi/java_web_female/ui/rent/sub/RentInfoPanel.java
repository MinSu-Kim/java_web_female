package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.RentPanel;
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
	private JDateChooser dateChooserEnd;	//대여일시	
	private JDateChooser dateChooserStart;	//반납일시
	private JSpinner spStartHour;	//대여시간
	private JSpinner spEndHour;		//반납시간
	private RentPanel rentPanel;

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

		dateChooserStart = new JDateChooser();
		pStartDate.add(dateChooserStart);
		
		//대여시간
		JPanel pStartTime = new JPanel();
		pStart.add(pStartTime);
		pStartTime.setLayout(new GridLayout(0, 3, 10, 10));
		
		JLabel lblStartTime = new JLabel("대여시간");
		lblStartTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		pStartTime.add(lblStartTime);
		
		spStartHour = new JSpinner();
		spStartHour.setModel(new SpinnerNumberModel(10, 1, 24, 1));
		// ======== 01, 02, .., 09로 표시하기
		JSpinner.NumberEditor nEditorStartHour = new JSpinner.NumberEditor(spStartHour, "00");
		spStartHour.setEditor(nEditorStartHour);
		//
		pStartTime.add(spStartHour);
		
		JLabel lblStartHour = new JLabel("시");
		pStartTime.add(lblStartHour);
		
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

		dateChooserEnd = new JDateChooser();
		pEndDate.add(dateChooserEnd);

		//반납시간
		JPanel pEndTime = new JPanel();
		pEnd.add(pEndTime);
		pEndTime.setLayout(new GridLayout(0, 3, 10, 10));

		JLabel lblEndTime = new JLabel("반납시간");
		lblEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndTime);

		spEndHour = new JSpinner();
		spEndHour.setModel(new SpinnerNumberModel(10, 1, 24, 1));
		// ======== 01, 02, .., 09로 표시하기
		JSpinner.NumberEditor nEditorEndHour = new JSpinner.NumberEditor(spEndHour, "00");
		spEndHour.setEditor(nEditorEndHour);
		//
		pEndTime.add(spEndHour);

		JLabel lblEndHour = new JLabel("시");
		lblEndHour.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndHour.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pEndTime.add(lblEndHour);
	}
	
	// 반납일-대여일[단위 : 일]
	public long diffDays(String begin, String end) throws ParseException {
		// yyyyMMddHH : 연월일시
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");

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
	
	public long totalRentDate() throws ParseException {
		// ===================== 대여일시, 대여시간 ====================
		//1. 대여일시 가져오기
		Date start = dateChooserStart.getDate();
		//date를 simpledateformat으로 바꾸기
		SimpleDateFormat startSdf = new SimpleDateFormat("yyyyMMdd");
		//diffDays에서 매개변수 타입이 String이므로 String으로 받아준다.
		String startDate = startSdf.format(start);
		//2. 대여시간 가져오기
		String sHour = spStartHour.getValue() + "";
		
		// ===================== 반납일시, 반납시간 ====================
		Date end = dateChooserEnd.getDate();
		SimpleDateFormat endSdf = new SimpleDateFormat("yyyyMMdd");
		String endDate = endSdf.format(end);
		String eHour = spEndHour.getValue() + "";
		
		//
		long diff = diffDays(startDate + sHour, endDate + eHour);
		if(diff == 0) {
			JOptionPane.showMessageDialog(null, "대여기간은 최소 1일입니다. 다시 선택해주세요.");
		}
		return diff;
	}

	public void setRentPanel(RentPanel rentPanel) {
		this.rentPanel = rentPanel;
	}
}
