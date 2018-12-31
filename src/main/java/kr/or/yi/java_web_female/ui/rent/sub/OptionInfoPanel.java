package kr.or.yi.java_web_female.ui.rent.sub;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.rent.MyCheckBox;
import kr.or.yi.java_web_female.ui.rent.RentPanel;

@SuppressWarnings("serial")
public class OptionInfoPanel extends CarSubPanel {
	private List<CarOption> coList;
	private MyCheckBox mcb;
//	private CarModel selectedCarModel;
	private List<CarOption> carOptionList= new ArrayList<>();
	private RentPanel rentPanel;
	
	public void setRentPanel(RentPanel rentPanel) {
		this.rentPanel = rentPanel;
	}

	/**
	 * Create the panel.
	 */
	public OptionInfoPanel(RentUIService service) {
		super(service);
		initComponents();
	}

	private void initComponents() {
		setBorder(new TitledBorder(null, "\uC635\uC158 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
	}

	public void addCarOption() {
		coList = service.selectAllCarOptions();
		for (CarOption co : coList) {
			mcb = new MyCheckBox(co.getName());
			mcb.setCo(co);
//			mcb.setEnabled(false);
//			JCheckBox cb = new JCheckBox(co.getName());
			mcb.addActionListener(chkListener);
			add(mcb);
			if (co.getName().equals("driver")) {
				mcb.setEnabled(false);
			}
		}
	}

	public int getTotalOptionPrice() {
		int result = 0;
		for(CarOption co : carOptionList) {
			result += co.getPrice();
		}
		return result;
	}
	
	
	ActionListener chkListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MyCheckBox mb = (MyCheckBox) e.getSource();
			if (mb.isSelected()) {
				carOptionList.add(mb.getCo());
			} else {
				carOptionList.remove(carOptionList.indexOf(mb.getCo()));
			}
//			JOptionPane.showMessageDialog(null, optionPriceList);
			rentPanel.setOptionPriceList(carOptionList);

		}
	};

	public void setSelectedCarModel(CarModel selectedCarModel) {
//		this.selectedCarModel = selectedCarModel;

		if (selectedCarModel.getCarType().getCode().equals("S2")) {
			chkDriver(true);
		} else {
			chkDriver(false);
		}
	}

	private void chkDriver(boolean isChk) {
		for (Component c : this.getComponents()) {
			JCheckBox cb = (JCheckBox) c;
			if (cb.getText().equals("driver")) {
				cb.setEnabled(isChk);
				break;
			}
		}
	}

}
