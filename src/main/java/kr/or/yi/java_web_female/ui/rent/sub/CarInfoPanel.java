package kr.or.yi.java_web_female.ui.rent.sub;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.CarSearchFrame;
import kr.or.yi.java_web_female.ui.rent.RentPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CarInfoPanel extends CarSubPanel implements ActionListener {
	private JComboBox<String> comboBoxCar;
	private JButton btnSearchCar;
	private int selectedIndex;
	private List<CarType> list;
	private CarSearchFrame csf;	//차량선택프레임
	private CarModel selectedCarModel;
	private RentPanel rentPanel;
	/**
	 * Create the panel.
	 */
	public CarInfoPanel(RentUIService service) {
		super(service);
		initComponents();
		loadComboCarType();
	}
	
	//콤보박스에 차종 추가하기
	public void loadComboCarType() {
		list = service.selectAllCarTypes();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		for(CarType ct : list) {
			model.addElement(ct.getType());
		}
		comboBoxCar.setModel(model);
	}
	
	private void initComponents() {
		setBorder(new TitledBorder(null, "\uCC28\uB7C9 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblChoiceCar = new JLabel("차종 선택");
		add(lblChoiceCar);
		
		comboBoxCar = new JComboBox<>();
		add(comboBoxCar);
		
		btnSearchCar = new JButton("선택");
		btnSearchCar.addActionListener(this);
		add(btnSearchCar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearchCar) {
			do_btnSearchCar_actionPerformed(e);
		}
	}
	
	//선택버튼
	protected void do_btnSearchCar_actionPerformed(ActionEvent e) {
		selectedIndex = comboBoxCar.getSelectedIndex();
		CarType ct = list.get(selectedIndex);
		
		List<CarModel> carModelList = service.selectAllCarModels(ct);
		
		if(csf == null) {
			csf = new CarSearchFrame();
		}
		csf.setCarInfoPanel(this);
		csf.setCarList(carModelList);
		csf.setVisible(true);
	}

	public void setSelectedCarModel(CarModel selectedCarModel) {
		this.selectedCarModel = selectedCarModel;
		rentPanel.setSelectedCarModel(selectedCarModel);		
	}

	public void setRentPanel(RentPanel rentPanel) {
		this.rentPanel = rentPanel;
	}
	
	
}
