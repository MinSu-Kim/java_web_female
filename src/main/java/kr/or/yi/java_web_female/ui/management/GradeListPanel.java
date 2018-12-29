package kr.or.yi.java_web_female.ui.management;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridLayout;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.service.GradeEventUiService;
import kr.or.yi.java_web_female.ui.list.GradeList;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GradeListPanel extends JPanel implements ActionListener {
	protected List<Grade> list;
	private JTextField tfGradeCode;
	private JTextField tfGradeName;
	private JTextField tfGradeRate;
	private JTextField tfLosal;
	private JTextField tfHisal;
	private GradeEventUiService service;
	
	private GradeList panelList;
	
	private JButton btnGradeOk;
	private JButton btnGradeCancel;

	
	public GradeListPanel() {
		setBorder(new TitledBorder(null, "\uB4F1\uAE09\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		service = new GradeEventUiService();
		initcomponents();
		
	}
		private void initcomponents() {
			
			panelList= new GradeList();
			list = service.selectGradeByAll();
			panelList.setList(list);
			panelList.getTable().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						Grade item = panelList.getSelectedItem();
						setItem(item);
						btnGradeOk.setText("수정");
					}
				}
			});
			panelList.loadDatas();	
			
			setLayout(new GridLayout(0, 2, 0, 0));
			add(panelList);
			
			JPanel panel = new JPanel();
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JPanel panelInput = new JPanel();
			panel.add(panelInput, BorderLayout.CENTER);
			panelInput.setLayout(new GridLayout(0, 2, 10, 10));
			
			JLabel lblGradeCode = new JLabel("등급코드");
			lblGradeCode.setHorizontalAlignment(SwingConstants.RIGHT);
			panelInput.add(lblGradeCode);
			
			tfGradeCode = new JTextField();
			panelInput.add(tfGradeCode);
			tfGradeCode.setColumns(10);
			
			JLabel lblGradeName = new JLabel("등급명");
			lblGradeName.setHorizontalAlignment(SwingConstants.RIGHT);
			panelInput.add(lblGradeName);
			
			tfGradeName = new JTextField();
			panelInput.add(tfGradeName);
			tfGradeName.setColumns(10);
			
			JLabel lblGradeRate = new JLabel("할인율");
			lblGradeRate.setHorizontalAlignment(SwingConstants.RIGHT);
			panelInput.add(lblGradeRate);
			
			tfGradeRate = new JTextField();
			panelInput.add(tfGradeRate);
			tfGradeRate.setColumns(10);
			
			JLabel lblLosal = new JLabel("최소범위");
			lblLosal.setHorizontalAlignment(SwingConstants.RIGHT);
			panelInput.add(lblLosal);
			
			tfLosal = new JTextField();
			panelInput.add(tfLosal);
			tfLosal.setColumns(10);
			
			JLabel lblHisal = new JLabel("최대범위");
			lblHisal.setHorizontalAlignment(SwingConstants.RIGHT);
			panelInput.add(lblHisal);
			
			tfHisal = new JTextField();
			panelInput.add(tfHisal);
			tfHisal.setColumns(10);
			
			JPanel panelBtn = new JPanel();
			panel.add(panelBtn, BorderLayout.SOUTH);
			
			btnGradeOk = new JButton("추가");
			btnGradeOk.addActionListener(this);
			panelBtn.add(btnGradeOk);
			
			btnGradeCancel = new JButton("취소");
			btnGradeCancel.addActionListener(this);
			panelBtn.add(btnGradeCancel);
			
			panelList.setPopupMenu(createDeptPopupMenu());

		}
		private JPopupMenu createDeptPopupMenu() {
			JPopupMenu popMenu = new JPopupMenu();

			JMenuItem updateItem = new JMenuItem("수정");
			updateItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Grade item = panelList.getSelectedItem();
					setItem(item);
					btnGradeOk.setText("수정");
				}

				
			});
			popMenu.add(updateItem);

			JMenuItem delItem = new JMenuItem("삭제");
			delItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					service.deleteGrade(panelList.getSelectedItem());
					panelList.setList(service.selectGradeByAll());
					panelList.loadDatas();
				}
			});
			popMenu.add(delItem);

			return popMenu;
		}
		
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGradeCancel) {
			do_btnGradeCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGradeOk) {
			if(btnGradeOk.getText() == "추가") {
				do_btnGradeOk_actionPerformed(arg0);
			}else {
				do_btnUpdate_actionPerformed(arg0);
			}
		}
	}
	
	private void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		Grade grade = getItem();
		service.updateGrade(grade);
		panelList.setList(service.selectGradeByAll());
		panelList.loadDatas();
		clearTf();
		btnGradeOk.setText("추가");
	}
	
	private void clearTf() {
		tfGradeCode.setText("");
		tfGradeName.setText("");
		tfGradeRate.setText("");
		tfLosal.setText("");
		tfHisal.setText("");
		
		
	}
	private Grade getItem() {
		String gCode = tfGradeCode.getText();
		String gName = tfGradeName.getText();
		int gRate = Integer.parseInt(tfGradeRate.getText());
		int glosal = Integer.parseInt(tfLosal.getText());
		int gHisal = Integer.parseInt(tfHisal.getText());
		Grade item = new Grade();
		item.setCode(gCode);
		item.setName(gName);
		item.setRate(gRate);
		item.setgLosal(glosal);
		item.setgHisal(gHisal);
		return item;
	}
	protected void do_btnGradeOk_actionPerformed(ActionEvent arg0) {
		String gCode = tfGradeCode.getText();
		String gName = tfGradeName.getText();
		int gRate = Integer.parseInt(tfGradeRate.getText());
		int gLosal = Integer.parseInt(tfLosal.getText());
		int gHisal = Integer.parseInt(tfHisal.getText());
		
		Grade grade = new Grade();
		grade.setCode(gCode);
		grade.setName(gName);
		grade.setRate(gRate);
		grade.setgLosal(gLosal);
		grade.setgHisal(gHisal);
		
		service.insertGrade(grade);
		list = service.selectGradeByAll();
		panelList.setList(list);
		panelList.loadDatas();
		add(panelList);
		
		clearTf();
	}
	protected void do_btnGradeCancel_actionPerformed(ActionEvent arg0) {
		if(btnGradeOk.getText()=="수정") {
			btnGradeOk.setText("추가");
		}
		clearTf();
	}
	private void setItem(Grade item) {
		tfGradeCode.setText(item.getCode()+"");
		tfGradeName.setText(item.getName()+"");
		tfGradeRate.setText(item.getRate()+"");
		tfLosal.setText(item.getgLosal()+"");
		tfHisal.setText(item.getgHisal()+"");
		
		
	}
	}
		


