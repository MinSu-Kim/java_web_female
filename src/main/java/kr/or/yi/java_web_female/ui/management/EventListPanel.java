package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.service.EventUiService;

public class EventListPanel extends JPanel {
	private JTextField tfEventCode;
	private JTextField tfEventName;
	private JTextField tfEventRate;
	private EventUiService service;

	/**
	 * Create the panel.
	 */
	public EventListPanel() {
		setBorder(new TitledBorder(null, "\uC774\uBCA4\uD2B8\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new EventUiService();
		initcomponents();
		
	}
		private void initcomponents() {
			setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panelList = new JPanel();
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
			
			JButton btnEventOk = new JButton("추가");
			panelBtn.add(btnEventOk);
			
			JButton btnEventCancel = new JButton("취소");
			panelBtn.add(btnEventCancel);

		}

			
		}
		
	


