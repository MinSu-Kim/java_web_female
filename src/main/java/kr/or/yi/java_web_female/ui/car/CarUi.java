package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.CarModel;

public class CarUi extends JFrame {

	private JPanel contentPane;
	private CarSelectedPanel panelUpdate;
	private boolean isAdd;
	private CarPanel carPanel;
	/**
	 * Create the frame.
	 */
	public CarUi(boolean isAdd) {
		this.isAdd = isAdd;
		initComponents();
	}
	private void initComponents() {
		if(isAdd) {
			setTitle("차량정보추가");
		}else {
			setTitle("차량 세부정보관리");
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelUpdate = new CarSelectedPanel(isAdd);
		panelUpdate.setCarUi(this);
		contentPane.add(panelUpdate, BorderLayout.CENTER);
	}
	
	public void setCarPanel(CarPanel carPanel) {
		this.carPanel = carPanel;
	}
	public void setCarModel(CarModel carModel) {
//		this.carModel = carModel;
		panelUpdate.setCarModel(carModel);
	}
	public void reloadDataCarPanel() {
		carPanel.setLoadDatas();
		
	}
	public void close() {
		dispose();
	}

}
