package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.list.BrandList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrandListPanel extends JPanel implements ActionListener {
	private JTextField tfNo;
	private JTextField tfName;
	private CarUiService service;
	private List<Brand> list;
	private BrandList panelList;
	private JButton btnOk;
	private JButton btnCancel;
	
	/**
	 * Create the panel.
	 */
	public BrandListPanel() {
		service = new CarUiService();
		initcomponent();
	}

	private void initcomponent() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		panelList = new BrandList();
		
		panelList.setBorder(new TitledBorder(null, "\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list = service.selectAllBrand();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "\uBE0C\uB79C\uB4DC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("브랜드번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblNo);
		
		tfNo = new JTextField();
		panelInput.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("브랜드명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblName);
		
		tfName = new JTextField();
		panelInput.add(tfName);
		tfName.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
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
		String no = tfNo.getText();
		String name = tfName.getText();
		Brand brand = new Brand();
		service.insertBrand(brand);
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		clearTf();
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		clearTf();
	}

	private void clearTf() {
		tfNo.setText("");
		tfName.setText("");
	}
}
