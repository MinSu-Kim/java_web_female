package kr.or.yi.java_web_female.ui.rent;

import javax.swing.JCheckBox;

import kr.or.yi.java_web_female.dto.CarOption;

@SuppressWarnings("serial")
public class MyCheckBox extends JCheckBox {
	private CarOption co;
	
/*	public MyCheckBox(CarOption co) {
		this.co = co;
	}*/

	public MyCheckBox(String text) {
		super(text);
	}

	public CarOption getCo() {
		return co;
	}

	public void setCo(CarOption co) {
		this.co = co;
	}

	@Override
	public String toString() {
		return String.format("MyCheckBox [co=%s]", co.getName());
	}
	
}
