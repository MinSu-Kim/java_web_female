package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridLayout;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.service.GradeEventUiService;
import kr.or.yi.java_web_female.ui.list.EventList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class EventListPanel extends JPanel implements ActionListener {
	protected List<Event> list;
	private JTextField tfEventCode;
	private JTextField tfEventName;
	private JTextField tfEventRate;
	private GradeEventUiService service;

	private EventList panelList;
	private JButton btnEventOk;
	private JButton btnEventCancel;

	/**
	 * Create the panel.
	 */
	public EventListPanel() {
		setBorder(new TitledBorder(null, "\uC774\uBCA4\uD2B8\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
		service = new GradeEventUiService();
		initcomponents();

	}

	private void initcomponents() {

		panelList = new EventList();
		list = service.selectEventByAll();
		panelList.setList(list);
		panelList.loadDatas();
		panelList.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Event item = panelList.getSelectedItem();
					setItem(item);
					btnEventOk.setText("수정");
				}
			}
		});
		setLayout(new GridLayout(0, 2, 0, 0));
		add(panelList);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelInput = new JPanel();
		panel.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblEventCode = new JLabel("이벤트 코드");
		lblEventCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEventCode);

		tfEventCode = new JTextField();
		panelInput.add(tfEventCode);
		tfEventCode.setColumns(10);

		JLabel lblEventName = new JLabel("이벤트명");
		lblEventName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEventName);

		tfEventName = new JTextField();
		panelInput.add(tfEventName);
		tfEventName.setColumns(10);

		JLabel lblEventRate = new JLabel("할인율");
		lblEventRate.setHorizontalAlignment(SwingConstants.RIGHT);
		panelInput.add(lblEventRate);

		tfEventRate = new JTextField();
		panelInput.add(tfEventRate);
		tfEventRate.setColumns(10);

		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);

		btnEventOk = new JButton("추가");
		btnEventOk.addActionListener(this);

		panelBtn.add(btnEventOk);

		btnEventCancel = new JButton("취소");
		btnEventCancel.addActionListener(this);
		panelBtn.add(btnEventCancel);

		panelList.setPopupMenu(createDeptPopupMenu());

	}

	private JPopupMenu createDeptPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Event item = panelList.getSelectedItem();
				setItem(item);
				btnEventOk.setText("수정");
			}

		});
		popMenu.add(updateItem);

		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				service.deleteEvent(panelList.getSelectedItem());
				panelList.setList(service.selectEventByAll());
				panelList.loadDatas();
			}
		});
		popMenu.add(delItem);

		return popMenu;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEventCancel) {
			do_btnEventCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEventOk) {
			if (btnEventOk.getText() == "추가") {
				do_btnEventOk_actionPerformed(arg0);
			} else {
				do_btnUpdate_actionPerformed(arg0);
			}
		}
	}

	private void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		Event event = getItem();
		service.updateEvent(event);
		panelList.setList(service.selectEventByAll());
		panelList.loadDatas();
		clearTf();
		btnEventOk.setText("추가");
	}

	private Event getItem() {
		String etCode = tfEventCode.getText();
		String etName = tfEventName.getText();
		int etRate = Integer.parseInt(tfEventRate.getText());
		Event item = new Event();
		item.setCode(etCode);
		item.setName(etName);
		item.setRate(etRate);
		return item;
	}

	protected void do_btnEventOk_actionPerformed(ActionEvent arg0) {
		String etCode = tfEventCode.getText();
		String etName = tfEventName.getText();
		int etRate = Integer.parseInt(tfEventRate.getText());
		
		Event event = new Event();
		event.setCode(etCode);
		event.setName(etName);
		event.setRate(etRate);
		
		service.insertEvent(event);
		list = service.selectEventByAll();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		
		clearTf();
	}

	private void clearTf() {
		tfEventCode.setText("");
		tfEventName.setText("");
		tfEventRate.setText("");

	}

	protected void do_btnEventCancel_actionPerformed(ActionEvent arg0) {
		if (btnEventOk.getText() == "수정") {
			btnEventOk.setText("추가");
		}
		clearTf();
	}

	private void setItem(Event item) {
		tfEventCode.setText(item.getCode() + "");
		tfEventName.setText(item.getName() + "");
		tfEventRate.setText(item.getRate() + "");
	}

}
