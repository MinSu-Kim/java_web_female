package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.CarTypeList;
@SuppressWarnings("serial")
public class CarTypeListPanel extends JPanel {
	private JTextField tfCode;
	private JTextField tfType;
	private CarTypeList panelList;
	private CarUiService service;
	private List<CarType> list;

	/**
	 * Create the panel.
	 */
	public CarTypeListPanel() {
		service = new CarUiService();
		initcomponent();
	}

	private void initcomponent() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		panelList = new CarTypeList();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = service.selectAllCarType();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		
		JPanel panelList = new JPanel();
		add(panelList);
		panelList.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "\uCC28\uC885", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelList.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblCode = new JLabel("차종코드");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblCode);
		
		tfCode = new JTextField();
		panelInput.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblType = new JLabel("차량유형");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblType);
		
		tfType = new JTextField();
		panelInput.add(tfType);
		tfType.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panelList.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("추가");
		panelBtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		panelBtn.add(btnCancel);
	}

}
