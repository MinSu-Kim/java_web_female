package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.CarOptionList;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CarOptionListPanel extends JPanel implements ActionListener {
	
	//리스트
	protected List<CarOption> list;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfPrice;
	private CarOptionList panelList;
	private CarUiService service;
	private JButton btnOk;
	


	public CarOptionListPanel() {
		service = new CarUiService();
		initcomponents();
	}
	
	

	private void initcomponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		panelList = new CarOptionList();
				
		panelList.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = service.selectAllCarOption();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "\uCC28\uB7C9\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("옵션번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblNo);
		
		tfNo = new JTextField();
		panelInput.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("옵션명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblName);
		
		tfName = new JTextField();
		panelInput.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblPrice = new JLabel("옵션가격");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblPrice);
		
		tfPrice = new JTextField();
		panelInput.add(tfPrice);
		tfPrice.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		
		panelBtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		panelBtn.add(btnCancel);
	}
	
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		//추가버튼 눌렀을시 실행
		int no = Integer.parseInt(tfNo.getText());
		String name = tfName.getText();
		int price = Integer.parseInt(tfPrice.getText());
		CarOption carOption = new CarOption();
		carOption.setNo(no);
		carOption.setName(name);
		carOption.setPrice(price);
		service.insertCarOption(carOption);
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		tfNo.setText("");
		
	}
	
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		//취소버튼 눌렀을시 실행
		tfNo.setText("");
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
	}
}
