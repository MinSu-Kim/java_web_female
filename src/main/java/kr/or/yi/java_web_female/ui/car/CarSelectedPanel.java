package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.service.CarModelService;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.ComboPanel;

public class CarSelectedPanel extends JPanel implements ActionListener {
	private JTextField tfCode;
	private JTextField tfName;
	private CarModelService service;
	private CarUiService carUiService;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnDelete;
	
	private JTextField tfBasicCharge;
	private JTextField tfHour6;
	private JTextField tfHour10;
	private JTextField tfHour12;
	private JTextField tfHourElse;
	private ComboPanel<Brand> cmbBrand;

	private JRadioButton rdbtnAuto;
	private JRadioButton rdbtnStick;
	
	private ComboPanel<CarType> cmbCarType;
	private JTextField tfColor;
	private ComboPanel<Fuel> cmbFuel;
	//이미지 불러오기
	String imgPath = System.getProperty("user.dir")+"\\images\\";//이미지가 들어있는 경로
	
	
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
		
		panelCode.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panelName = new JPanel();
		panel_info.add(panelName);
		panelName.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("모델명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelName.add(lblName);
		
		tfName = new JTextField();
		
		panelName.add(tfName);
		tfName.setColumns(10);
		
		
		cmbBrand = new ComboPanel<>();
		cmbBrand.setTitle("브랜드");
		
		//브랜드 콤보박스
		List<Brand> arrBrand = carUiService.selectAllBrand();
		cmbBrand.setComboItems(arrBrand);
		panel_info.add(cmbBrand);
		
		cmbCarType = new ComboPanel<>();
		GridLayout gl_cmbCarType = (GridLayout) cmbCarType.getLayout();
		gl_cmbCarType.setColumns(2);
		gl_cmbCarType.setRows(0);
		cmbCarType.setTitle("차종");
		//차종콤보박스
		List<CarType> arrType = carUiService.selectAllCarType();
		cmbCarType.setComboItems(arrType);		
		panel_info.add(cmbCarType);
		
		//연료콤보박스
		cmbFuel = new ComboPanel<>();
		cmbFuel.setTitle("연료");
		List<Fuel> arrFuel = carUiService.selectAllFuel();
		cmbFuel.setComboItems(arrFuel);
		panel_info.add(cmbFuel);
		
		JPanel panelColor = new JPanel();
		panel_info.add(panelColor);
		panelColor.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblColor = new JLabel("색상");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panelColor.add(lblColor);
		
		tfColor = new JTextField();
		panelColor.add(tfColor);
		tfColor.setColumns(10);
		
		JPanel panelGear = new JPanel();
		panel_info.add(panelGear);
		panelGear.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblGear = new JLabel("변속기");
		lblGear.setHorizontalAlignment(SwingConstants.CENTER);
		panelGear.add(lblGear);
		
		JPanel panelRbtn = new JPanel();
		panelGear.add(panelRbtn);
		panelRbtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		ButtonGroup group = new ButtonGroup();
		
		rdbtnAuto = new JRadioButton("자동");
		group.add(rdbtnAuto);
		panelRbtn.add(rdbtnAuto);
		rdbtnAuto.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbtnStick = new JRadioButton("수동");
		group.add(rdbtnStick);
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
		//삭제선택, 디비에는 바로삭제 되지만 테이블 실시간 업데이트 미완성
		CarModel model = new CarModel();
		model.setCarCode(tfCode.getText());
		service.deleteCarModel(model);
	}
	
	private void clearTf() {
		tfName.setText("");
	}
	
	private CarModel getItem() {
		//getitem작성중!
		String code = tfCode.getText().trim();
		String name = tfName.getText().trim();
		//브랜드
		Brand brand = cmbBrand.getSelectedItems();
		
		//차종
		CarType cartype = cmbCarType.getSelectedItems();

		//연료
		Fuel fuel = (Fuel)cmbFuel.getSelectedItems();

		
		String color = tfColor.getText().trim();//색상
		String gear = "";
		boolean selectedGear = rdbtnAuto.isSelected();
		if(selectedGear) {
			gear = "auto";
		}else {
			gear = "stick";
		}
		//isrent,rentCnt 처리중
		boolean isRent = true;
		//가격
		int basicCharge = Integer.parseInt(tfBasicCharge.getText());
		int hour6 = Integer.parseInt(tfHour6.getText());
		int hour10 = Integer.parseInt(tfHour10.getText());
		int hour12 = Integer.parseInt(tfHour12.getText());
		int hourElse = Integer.parseInt(tfHourElse.getText());
		
		CarModel item = new CarModel(code, name, color, gear, brand, cartype, basicCharge, hour6, hour10, hour12, hourElse, fuel, isRent, 0);
		return item;
	}
	

	public void setCarModel(CarModel carModel) {//set
		tfCode.setText(carModel.getCarCode());
		tfName.setText(carModel.getName());
		
		cmbBrand.setSelectedItem(carModel.getBrand());
		cmbCarType.setSelectedItem(carModel.getCarType());
		cmbFuel.setSelectedItem(carModel.getFuel());
		
		tfColor.setText(carModel.getColor());
		tfHour6.setText(carModel.getHour6()+"");
		tfHour10.setText(carModel.getHour10()+"");
		tfHour12.setText(carModel.getHour12()+"");
		tfHourElse.setText(carModel.getHourElse()+"");
		tfBasicCharge.setText(carModel.getBasicCharge()+"");

		String gear = carModel.getGear();
		if(gear.equals("auto")) {
			rdbtnAuto.setSelected(true);
		}else {
			rdbtnStick.setSelected(true);
		}
	}

}















