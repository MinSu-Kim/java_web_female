package kr.or.yi.java_web_female.ui.car;

import javax.swing.JPanel;

import static org.junit.Assert.assertFalse;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.service.CarModelService;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.ComboPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import kr.or.yi.java_web_female.ui.list.AbstractListPanel;
import kr.or.yi.java_web_female.ui.list.CarPriceList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CarSelectedPanel extends JPanel implements ActionListener {
	private JTextField tfCode;
	private JTextField tfName;
	private CarModelService service;
	private CarUiService carUiService;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnDelete;
	private CarPanel carPanel;//선택된 차량의 정보가 있는 페널
	private List<CarModel> carList;//모델리스트
	private AbstractListPanel<CarModel> carListPanel;
	
	//이미지 불러오기
	String imgPath = System.getProperty("user.dir")+"\\images\\";//이미지가 들어있는 경로
	private JTextField tfBasicCharge;
	private JTextField tfHour6;
	private JTextField tfHour10;
	private JTextField tfHour12;
	private JTextField tfHourElse;
	
	public void setCarList(List<CarModel> carList) {//???
		this.carList = carList;
		carListPanel.setList(carList);
		carListPanel.loadDatas();
	}

	/**
	 * Create the panel.
	 */
	public CarSelectedPanel() {
		service = new CarModelService();
		carUiService = new CarUiService();
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel container = new JPanel();
		add(container, BorderLayout.CENTER);
		container.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		container.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_img = new JPanel();
		panel_img.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC0AC\uC9C4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel_img);
		
		JPanel panel_info = new JPanel();
		panel_2.add(panel_info);
		panel_info.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelCode = new JPanel();
		panel_info.add(panelCode);
		panelCode.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("차량코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panelCode.add(lblCode);
		
		tfCode = new JTextField();
		tfCode.setEditable(false);
		//선택된 차량코드 자동등록
		tfCode.setText("");
		
		panelCode.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panelName = new JPanel();
		panel_info.add(panelName);
		panelName.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("모델명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelName.add(lblName);
		
		tfName = new JTextField();
		//선택된 차량이름 자동등록
		tfName.setText("");
		
		panelName.add(tfName);
		tfName.setColumns(10);
		
		
		ComboPanel<Brand> panelBrand = new ComboPanel<>();
		panelBrand.setTitle("브랜드");
		
		//브랜드 콤보박스
		List<Brand> arrBrand = carUiService.selectAllBrand();
		panelBrand.setComboItems(arrBrand);
		panel_info.add(panelBrand);
		
		ComboPanel<CarType> panelCarType = new ComboPanel<>();
		GridLayout gridLayout = (GridLayout) panelCarType.getLayout();
		gridLayout.setColumns(2);
		gridLayout.setRows(0);
		panelCarType.setTitle("차종");
		//차종콤보박스
		List<CarType> arrType = carUiService.selectAllCarType();
		panelCarType.setComboItems(arrType);		
		panel_info.add(panelCarType);
		
		JPanel panelGear = new JPanel();
		panel_info.add(panelGear);
		panelGear.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblGear = new JLabel("변속기");
		lblGear.setHorizontalAlignment(SwingConstants.CENTER);
		panelGear.add(lblGear);
		
		JPanel panelRbtn = new JPanel();
		panelGear.add(panelRbtn);
		panelRbtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnAuto = new JRadioButton("자동");
		panelRbtn.add(rdbtnAuto);
		rdbtnAuto.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnStick = new JRadioButton("수동");
		panelRbtn.add(rdbtnStick);
		rdbtnStick.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelPrice = new JPanel();
		panel_info.add(panelPrice);
		panelPrice.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblBasicCharge = new JLabel("기본요금");
		panelPrice.add(lblBasicCharge);
		
		JLabel lblHour6 = new JLabel("6시간");
		panelPrice.add(lblHour6);
		
		JLabel lblHour10 = new JLabel("10시간");
		panelPrice.add(lblHour10);
		
		JLabel lblHour12 = new JLabel("12시간");
		panelPrice.add(lblHour12);
		
		JLabel lblHourElse = new JLabel("12시간초과");
		panelPrice.add(lblHourElse);
		
		tfBasicCharge = new JTextField();
		panelPrice.add(tfBasicCharge);
		tfBasicCharge.setColumns(10);
		
		tfHour6 = new JTextField();
		tfHour6.setColumns(10);
		panelPrice.add(tfHour6);
		
		tfHour10 = new JTextField();
		tfHour10.setColumns(10);
		panelPrice.add(tfHour10);
		
		tfHour12 = new JTextField();
		tfHour12.setColumns(10);
		panelPrice.add(tfHour12);
		
		tfHourElse = new JTextField();
		tfHourElse.setColumns(10);
		panelPrice.add(tfHourElse);
		
		JPanel panelRentCnt = new JPanel();
		panel_info.add(panelRentCnt);
		panelRentCnt.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCount = new JLabel("대여횟수 : ");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		panelRentCnt.add(lblCount);
		
		JPanel panelBtn = new JPanel();
		container.add(panelBtn, BorderLayout.SOUTH);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		panelBtn.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		panelBtn.add(btnDelete);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panelBtn.add(btnCancel);
	}
	//버튼
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnDelete) {
			do_btnDelete_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnUpdate) {
			do_btnUpdate_actionPerformed(arg0);
		}
	}
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		//수정클릭
		CarModel model = getItem();
		service.updateCarModel(model);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		//취소클릭
		clearTf();
	}

	protected void do_btnDelete_actionPerformed(ActionEvent arg0) {
		//삭제선택
	}
	
	private void clearTf() {
		tfName.setText("");
	}
	
	private CarModel getItem() {
		//getitem작성중!
		String code = tfCode.getText().trim();
		String name = tfName.getText().trim();
		
		CarModel item = new CarModel();
		item.setCarCode(code);
		return item;
	}
}















