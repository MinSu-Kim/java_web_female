package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.FuelList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuelListPanel extends JPanel implements ActionListener {
	private JTextField tfCode;
	private CarUiService service;
	private List<Fuel> list;
	private FuelList panelList;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Create the panel.
	 */
	public FuelListPanel() {
		service = new CarUiService();
		initcomponent();
	}

	private void initcomponent() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		panelList = new FuelList();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = service.selectAllFuel();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "\uC5F0\uB8CC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_4 = new JPanel();
		panelInput.add(panel_4);
		
		JLabel lblCode = new JLabel("연료");
		panel_4.add(lblCode);
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfCode = new JTextField();
		panel_4.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel_1.add(panelBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		
		panelBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panelBtn.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		//추가버튼 눌렀을시 실행
		String code = tfCode.getText();
		Fuel newFuel = new Fuel(code);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		//취소버튼 눌렀을시 실행
		tfCode.setText("");
	}
}
