package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.service.CarModelService;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.ComboPanel;
import kr.or.yi.java_web_female.ui.list.CarTotalList;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class CarPanel extends JPanel implements ActionListener {
	private CarUiService service;
	private CarModelService modelService;

	private List<CarModel> list;
	private CarTotalList panelList;
	private JButton btnOk;
	private JButton btnCancel;
	private CarModel selectedModel;


	public CarPanel() {
		service = new CarUiService();
		modelService = new CarModelService();
		initComponents();
	}
	

	private void initComponents() {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSelect = new JPanel();
		add(panelSelect, BorderLayout.NORTH);
		panelSelect.setLayout(new GridLayout(0, 2, 0, 0));
		
		ComboPanel<CarType> panelCarType = new ComboPanel<>();
		panelCarType.setTitle("차종");
		List<CarType> arr = service.selectAllCarType();
		
		//콤보박스에 차종 불러오기
		panelCarType.setComboItems(arr);
		panelSelect.add(panelCarType);
		
		ComboPanel<Brand> panelBrand = new ComboPanel<>();
		panelBrand.setTitle("브랜드");
		List<Brand> arrBrand = service.selectAllBrand();
		//콤보박스에 브랜드 불러오기
		panelBrand.setComboItems(arrBrand);
		panelSelect.add(panelBrand);
		//콤보박스에 연료불러오기
		ComboPanel panelFuel = new ComboPanel();
		panelFuel.setTitle("연료");
		List<Fuel> arrFuel = service.selectAllFuel();
		panelFuel.setComboItems(arrFuel);
		panelSelect.add(panelFuel);
		panelFuel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelGear = new JPanel();
		panelSelect.add(panelGear);
		panelGear.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblGear = new JLabel("변속기");
		lblGear.setHorizontalAlignment(SwingConstants.CENTER);
		panelGear.add(lblGear);
		
		JPanel panelRbtn = new JPanel();
		panelGear.add(panelRbtn);
		panelRbtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnAuto = new JRadioButton("자동");
		panelRbtn.add(rdbtnAuto);
		
		JRadioButton rdbtnStick = new JRadioButton("수동");
		panelRbtn.add(rdbtnStick);
		//전체 테이블 불러오기
		panelList = new CarTotalList();
		
		panelList.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = modelService.selectCarModelByAll();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		
		JPanel panelBtn = new JPanel();
		add(panelBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("선택");
		btnOk.addActionListener(this);
		
		JButton btnAdd = new JButton("추가");
		panelBtn.add(btnAdd);
		panelBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panelBtn.add(btnCancel);
		
		
	
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnOk) {
			do_btnOk_actionPerformed(arg0);
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		//선택눌렀을시 selected화면으로 이동
		CarUi frame = new CarUi();
		CarModel carModel = panelList.getSelectedItem();
		System.out.println(carModel);
		frame.setCarModel(carModel);
		frame.setVisible(true);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		//취소눌렀을시 List 선택초기화
	}
	
}









