
package kr.or.yi.java_web_female.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.service.SearchPostService;
import kr.or.yi.java_web_female.ui.list.AddressTable;

@SuppressWarnings("serial")
public class SearchPostUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfDoro;
	private JComboBox<String> cmbSido;
	private JButton btnSearch;
	private SearchPostService postService;
	private AddressTable pList;
	private Post doro;
	
	private JoinUI joinUi; //추가
	
	public void setJoinUi(JoinUI joinUi) {  //추가
		this.joinUi = joinUi;
	}

	public void setpList(AddressTable pList) {
		this.pList = pList;
	}

	public SearchPostUI() {
		setTitle("우편번호 검색");
		postService = new SearchPostService();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pCond = new JPanel();
		contentPane.add(pCond, BorderLayout.NORTH);
		pCond.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel lblSido = new JLabel("시도");
		lblSido.setHorizontalAlignment(SwingConstants.CENTER);
		pCond.add(lblSido);

		String[] strArr = { "강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시", "대전광역시", "부산광역시", "서울특별시", "세종특별자치시",
				"울산광역시", "인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(strArr);
		cmbSido = new JComboBox<>(model);
		cmbSido.setSelectedIndex(-1);

		pCond.add(cmbSido);

		JLabel lblDoro = new JLabel("도로명");
		lblDoro.setHorizontalAlignment(SwingConstants.CENTER);
		pCond.add(lblDoro);

		tfDoro = new JTextField();
		pCond.add(tfDoro);
		tfDoro.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pCond.add(btnSearch);

		pList = new AddressTable();
		
		/*클릭리스너추가*/
		pList.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Post post = pList.getSelectedItem();
				joinUi.setAddress(post);
				SearchPostUI.this.dispose();
			}
		});
		
		contentPane.add(pList, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			do_btnSearch_actionPerformed(e);
		}
	}

	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		try {
			doro = new Post();
			doro.setSido((String) cmbSido.getSelectedItem());
			doro.setDoro(tfDoro.getText().trim());
			pList.setList(postService.selectPostByName(doro));
			pList.loadDatas();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}