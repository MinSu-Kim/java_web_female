package kr.or.yi.java_web_female.ui.rent.sub;

import javax.swing.JPanel;

import kr.or.yi.java_web_female.service.RentUIService;

public class CarSubPanel extends JPanel{
	protected RentUIService service;

	public CarSubPanel(RentUIService service) {
		this.service = service;
	}
}
