package kr.or.yi.java_web_female.ui.rent;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.ui.list.AbstractListPanel;
import kr.or.yi.java_web_female.ui.list.CarModelListPanel;
import kr.or.yi.java_web_female.ui.rent.sub.CarInfoPanel;

public class CarSearchFrame extends JFrame {

	private JPanel contentPane;
	private AbstractListPanel<CarModel> carPanel;
	private List<CarModel> carList;
	private CarInfoPanel carInfoPanel;
	
	public void setCarList(List<CarModel> carList) {
		this.carList = carList;
		carPanel.setList(carList);
		carPanel.loadDatas();
	}
	
	
	/**
	 * Create the frame.
	 */
	public CarSearchFrame() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("차량 선택");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titlePanel.add(lblTitle);
		
		carPanel = new CarModelListPanel();
		carPanel.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				CarModel c = carPanel.getSelectedItem();
				carInfoPanel.setSelectedCarModel(c);
				CarSearchFrame.this.dispose();
			}
		});
		contentPane.add(carPanel, BorderLayout.CENTER);
	}

	public void setCarInfoPanel(CarInfoPanel carInfoPanel) {
		this.carInfoPanel = carInfoPanel;
	}
}
