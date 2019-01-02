package kr.or.yi.java_web_female.ui.rent.sub;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.RentPanel;

@SuppressWarnings("serial")
public class InsurancePanel extends CarSubPanel implements ItemListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbReg;
	private CarModel selectedCarModel;
	private JRadioButton rbNotReg;
	private RentPanel rentPanel;
	private Insurance insurance;
		
	/**
	 * Create the panel.
	 */
	public InsurancePanel(RentUIService service) {
		super(service);
		initComponents();
	}
	
	private void initComponents() {
		setBorder(new TitledBorder(null, "\uBCF4\uD5D8 \uAC00\uC785\uC5EC\uBD80", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblInsurance = new JLabel("자차손해 면책제도");
		lblInsurance.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsurance.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		add(lblInsurance);
		
		JPanel pChkInsurance = new JPanel();
		add(pChkInsurance);
		pChkInsurance.setLayout(new GridLayout(0, 2, 10, 10));
		
		rbNotReg = new JRadioButton("가입안함");
		
		rbNotReg.addItemListener(this);
		
		buttonGroup.add(rbNotReg);
		rbNotReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rbNotReg.setHorizontalAlignment(SwingConstants.CENTER);
		pChkInsurance.add(rbNotReg);
		
		rbReg = new JRadioButton("일반자차");
		rbReg.addItemListener(this);
		buttonGroup.add(rbReg);
		rbReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rbReg.setHorizontalAlignment(SwingConstants.CENTER);
		pChkInsurance.add(rbReg);
	}

	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == rbNotReg && rbNotReg.isSelected()) {
//			JOptionPane.showMessageDialog(null, "테스트");
			 insurance = new Insurance("I000", "S0", 0);
		}
		if (e.getSource() == rbReg && rbReg.isSelected()) {
			List<Insurance> insuranceList = service.selectInsuranceByCarType(selectedCarModel.getCarType().getCode());
			insurance = insuranceList.get(0);
		}
		System.out.println(insurance);
//		System.out.println("----" + rentPanel);
		rentPanel.setInsurance(insurance);
	}
	
/*	//일반자차를 선택했을 때
	protected void do_rbReg_itemStateChanged(ItemEvent e) {
		// selectInsuranceByCarType(String) ==> 여기서 String은 S1, S2, ...가 와야 함.
		getInsurancePrice();
	}
	
	//가입안함을 선택했을 때
	protected void do_rbNotReg_itemStateChanged(ItemEvent e) {
		getInsurancePrice();
	}*/

	public Insurance getInsurance() {
		return insurance;
	}
	
	public void setSelectedCarModel(CarModel selectedCarModel) {
		this.selectedCarModel = selectedCarModel;
	}

	public void setRentPanel(RentPanel rentPanel) {
		this.rentPanel = rentPanel;
	}
	
	public void setSelectedDefault() {
		rbNotReg.setSelected(true);
	}
}
