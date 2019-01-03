package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.or.yi.java_web_female.TestFrame;
import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.service.CarModelService;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.ComboPanel;
import kr.or.yi.java_web_female.ui.list.CarTotalList;

@SuppressWarnings("serial")
public class CarPanel extends JPanel implements ActionListener, ItemListener {
	private CarUiService service;
	private CarModelService modelService;

	private List<CarModel> list;
	private CarTotalList panelList;
	private JButton btnOk;
	private JButton btnCancel;
	private ComboPanel<Brand> panelBrand;
	private JRadioButton rdbtnStick;
	private ComboPanel<Fuel> panelFuel;
	private JButton btnAdd;
	private ComboPanel<CarType> panelCarType;
	private JRadioButton rdbtnAuto;
	private JPanel panel_reset;
	private ButtonGroup group;
	private List<CarType> arrCarType;
	private JPanel panelSelect;
	private CarPanel carPanel;
	private List<Brand> arrBrand;
	
	public CarPanel() {
		service = new CarUiService();
		modelService = new CarModelService();
		initComponents();
	}

	private void initComponents() {

		setLayout(new BorderLayout(0, 0));

		panelSelect = new JPanel();
		panelSelect.setBorder(new TitledBorder(null, "\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelSelect, BorderLayout.NORTH);

		panelCarType = new ComboPanel<>();
		GridLayout gridLayout = (GridLayout) panelCarType.getLayout();
		gridLayout.setVgap(10);
		gridLayout.setHgap(10);

		panelCarType.setTitle("차종");
		setListComboBox();
		if(TestFrame.loginEmployee()) {
			panelSelect.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}else {
			panelSelect.setLayout(new GridLayout(0, 2, 0, 0));
		}

		// 콤보박스에 차종 불러오기

		panelCarType.setSelectedIndex(-1);
		panelSelect.add(panelCarType);
		// 아이템리스너

		panelBrand = new ComboPanel<>();
		GridLayout gridLayout_1 = (GridLayout) panelBrand.getLayout();
		gridLayout_1.setHgap(10);
		gridLayout_1.setVgap(10);

		panelBrand.setTitle("브랜드");
		arrBrand = service.selectAllBrand();
		// 콤보박스에 브랜드 불러오기
		panelBrand.setComboItems(arrBrand);
		panelBrand.setSelectedIndex(-1);
		panelSelect.add(panelBrand);
		// changeListener 달기

		// 콤보박스에 연료불러오기
		panelFuel = new ComboPanel<>();

		panelFuel.setTitle("연료");
		List<Fuel> arrFuel = service.selectAllFuel();
		panelFuel.setComboItems(arrFuel);
		panelFuel.setSelectedIndex(-1);
		panelSelect.add(panelFuel);
		panelFuel.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel panelGear = new JPanel();
		panelSelect.add(panelGear);
		panelGear.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblGear = new JLabel("변속기");
		lblGear.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGear.add(lblGear);

		JPanel panelRbtn = new JPanel();
		panelGear.add(panelRbtn);
		panelRbtn.setLayout(new GridLayout(0, 2, 0, 0));

		group = new ButtonGroup();

		rdbtnAuto = new JRadioButton("자동");

		group.add(rdbtnAuto);
		panelRbtn.add(rdbtnAuto);

		rdbtnStick = new JRadioButton("수동");

		group.add(rdbtnStick);
		panelRbtn.add(rdbtnStick);
		
		panel_reset = new JPanel();
		panelSelect.add(panel_reset);
		
		btnCancel = new JButton("초기화");
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_reset.add(btnCancel);
		btnCancel.addActionListener(this);
		
		// 전체 테이블 불러오기
		panelList = new CarTotalList();
		
		panelList.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					showCarUi();
				}
			}

			
		});

		panelList.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = modelService.selectCarModelByAll();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList); //add 한번만!

		panelList.setPopupMenu(createDeptPopupMenu());

		JPanel panelBtn = new JPanel();
		add(panelBtn, BorderLayout.SOUTH);

		btnOk = new JButton("선택");
		btnOk.addActionListener(this);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panelBtn.add(btnAdd);
		//고객은 추가버튼 이용불가능
		if(TestFrame.loginEmployee()) {
			btnAdd.setVisible(true);
		}else {
			btnAdd.setVisible(false);
		}
		panelBtn.add(btnOk);

		panelCarType.getComboBox().addItemListener(this);
		panelBrand.getComboBox().addItemListener(this);
		panelFuel.getComboBox().addItemListener(this);
		rdbtnAuto.addItemListener(this);
		rdbtnStick.addItemListener(this);
		
		/*테이블 컬럼색상변경
		TableCellRenderer renderer = new MyTableCellRenderer();
		table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);*/
		

	}

	private JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		// 수정
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_btnOk_actionPerformed(e);
			}
		});
		popMenu.add(updateItem);
		// 삭제
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modelService.deleteCarModel(panelList.getSelectedItem());
					panelList.setList(modelService.selectCarModelByAll());
					panelList.loadDatas();
					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "해당차량은 렌트중으로 삭제가 불가능합니다.");
				}
				
			}
		});
		popMenu.add(delItem);

		return popMenu;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			do_btnAdd_actionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
	}

	protected void do_btnCancel_actionPerformed(ActionEvent e) {// 취소 클릭시 검색초기화
		// 테이블 전체 불러오기
		list = modelService.selectCarModelByAll();
		panelList.setList(list);
		panelList.loadDatas();
		// 검색필드초기화
		panelBrand.setSelectedIndex(-1);
		panelFuel.setSelectedIndex(-1);
		panelCarType.setSelectedIndex(-1);
		
		//그룹해제 후 setSelectedFalse
		group.remove(rdbtnAuto);
		group.remove(rdbtnStick);
		rdbtnStick.setSelected(false);
		rdbtnAuto.setSelected(false);
		group.add(rdbtnAuto);
		group.add(rdbtnStick);
	}

	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		// 추가
		CarUi frame = new CarUi(true);
		frame.setCarPanel(this);
		frame.setVisible(true);
	}

	protected void do_btnOk_actionPerformed(ActionEvent e) {
		// 선택눌렀을시 selected화면으로 이동
		showCarUi();
	}
	private void showCarUi() {
		CarUi frame = new CarUi(false);
		CarModel carModel = panelList.getSelectedItem();
		frame.setCarModel(carModel);
		frame.setCarPanel(this);
		frame.setVisible(true);
	}
	public void itemStateChanged(ItemEvent e) {
		setLoadAddList();
	}
	
	public void setLoadDatas() {
		list = modelService.selectCarModelByAll();
		panelList.setList(list);
		panelList.loadDatas();
	}

	private void setLoadAddList() {
		setLoadDatas();

		Map<String, String> maps = new HashMap<>();
		if (panelCarType.getSelectedIndex() >= 0) {
			CarType cartype = panelCarType.getSelectedItems();
			maps.put("cartype", cartype.getCode());
		}
		if (panelBrand.getSelectedIndex() >= 0) {
			Brand brand = panelBrand.getSelectedItems();
			maps.put("brand", brand.getNo());
		}
		if (panelFuel.getSelectedIndex() >= 0) {
			Fuel fuel = panelFuel.getSelectedItems();
			maps.put("fuel", fuel.getCode());
		}
		String gear;
		if (rdbtnStick.isSelected()) {
			gear = "stick";
		} else if (rdbtnAuto.isSelected()) {
			gear = "auto";
		} else {
			gear = null;
		}
		maps.put("gear", gear);

		list = modelService.SelectCarModelWithWhere(maps);
		panelList.setList(list);
		panelList.loadDatas();
	}
	
	public void setListComboBox() {
		arrCarType = service.selectAllCarType();
		panelCarType.setComboItems(arrCarType);
		System.out.println("**************"+arrCarType+"******************");
		System.out.println(panelCarType);
		
		
		
		/*arrBrand = service.selectAllBrand();
		System.out.println(arrBrand);//정상출력
		panelBrand.setComboItems(arrBrand);
		panelSelect.add(panelBrand);*/

	}
	
	

}
