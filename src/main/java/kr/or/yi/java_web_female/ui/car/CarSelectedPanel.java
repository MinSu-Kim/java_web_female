package kr.or.yi.java_web_female.ui.car;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.dto.UserPic;
import kr.or.yi.java_web_female.service.CarModelService;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.ui.ComboPanel;

public class CarSelectedPanel extends JPanel implements ActionListener {
	private JTextField tfCode;
	private JTextField tfName;
	private CarModelService service;
	private CarUiService carUiService;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnDelete;
	
	private JTextField tfBasicCharge;
	private JTextField tfHour6;
	private JTextField tfHour10;
	private JTextField tfHour12;
	private JTextField tfHourElse;
	private ComboPanel<Brand> cmbBrand;

	private JRadioButton rdbtnAuto;
	private JRadioButton rdbtnStick;
	
	private ComboPanel<CarType> cmbCarType;
	private JTextField tfColor;
	private ComboPanel<Fuel> cmbFuel;

	String imgPath = System.getProperty("user.dir")+"\\images\\"; //이미지가 들어있는 경로
	private JLabel lbl_img;
	private JPanel panel_img;
	private boolean isAdd;
	private CarUi carUi;
	private JLabel lblCount;
	private String filePath;
	private String currentDirectoryPath;
	private JFileChooser chooser;
	/**
	 * Create the panel.
	 */
	public CarSelectedPanel(boolean isAdd) {
		this.isAdd = isAdd;
		service = new CarModelService();
		carUiService = new CarUiService();
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel container = new JPanel();
		add(container, BorderLayout.CENTER);
		container.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		container.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_img = new JPanel();
		panel_img.setBorder(new TitledBorder(null, "\uC0AC\uC9C4", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		
		panel_2.add(panel_img);
		panel_img.setLayout(new BorderLayout(0, 0));
		
		if(isAdd) {
			lbl_img = new JLabel();//새로 추가되는 사진 띄우기
			panel_img.add(lbl_img);
		}else {
			lbl_img = new JLabel();
			panel_img.add(lbl_img);
		}
		
		
		JPanel panel_info = new JPanel();
		panel_2.add(panel_info);
		panel_info.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelCode = new JPanel();
		panel_info.add(panelCode);
		panelCode.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("차량코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panelCode.add(lblCode);
		
		tfCode = new JTextField();
		if(isAdd) {
			String maxCode = service.nextCarCode();
			int numCode = (Integer.parseInt(maxCode.substring(1)))+1;
			String nextCode = String.format("V%03d", numCode);
			tfCode.setText(nextCode);
		}
		tfCode.setEditable(false);
		
		panelCode.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panelName = new JPanel();
		panel_info.add(panelName);
		panelName.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("모델명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelName.add(lblName);
		
		tfName = new JTextField();
		
		panelName.add(tfName);
		tfName.setColumns(10);
		
		
		cmbBrand = new ComboPanel<>();
		cmbBrand.setTitle("브랜드");
		
		//브랜드 콤보박스
		List<Brand> arrBrand = carUiService.selectAllBrand();
		cmbBrand.setComboItems(arrBrand);
		cmbBrand.setSelectedIndex(-1);
		panel_info.add(cmbBrand);
		
		cmbCarType = new ComboPanel<>();
		GridLayout gl_cmbCarType = (GridLayout) cmbCarType.getLayout();
		gl_cmbCarType.setColumns(2);
		gl_cmbCarType.setRows(0);
		cmbCarType.setTitle("차종");
		//차종콤보박스
		List<CarType> arrType = carUiService.selectAllCarType();
		cmbCarType.setComboItems(arrType);	
		cmbCarType.setSelectedIndex(-1);
		panel_info.add(cmbCarType);
		
		//연료콤보박스
		cmbFuel = new ComboPanel<>();
		cmbFuel.setTitle("연료");
		List<Fuel> arrFuel = carUiService.selectAllFuel();
		cmbFuel.setComboItems(arrFuel);
		cmbFuel.setSelectedIndex(-1);
		panel_info.add(cmbFuel);
		
		JPanel panelColor = new JPanel();
		panel_info.add(panelColor);
		panelColor.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblColor = new JLabel("색상");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panelColor.add(lblColor);
		
		tfColor = new JTextField();
		panelColor.add(tfColor);
		tfColor.setColumns(10);
		
		JPanel panelGear = new JPanel();
		panel_info.add(panelGear);
		panelGear.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblGear = new JLabel("변속기");
		lblGear.setHorizontalAlignment(SwingConstants.CENTER);
		panelGear.add(lblGear);
		
		JPanel panelRbtn = new JPanel();
		panelGear.add(panelRbtn);
		panelRbtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		ButtonGroup group = new ButtonGroup();
		
		rdbtnAuto = new JRadioButton("자동");
		group.add(rdbtnAuto);
		panelRbtn.add(rdbtnAuto);
		rdbtnAuto.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbtnStick = new JRadioButton("수동");
		group.add(rdbtnStick);
		panelRbtn.add(rdbtnStick);
		rdbtnStick.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelPrice = new JPanel();
		panel_info.add(panelPrice);
		panelPrice.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblBasicCharge = new JLabel("기본요금");
		panelPrice.add(lblBasicCharge);
		
		JLabel lblHour6 = new JLabel("6시간");
		panelPrice.add(lblHour6);
		
		JLabel lblHour10 = new JLabel("10시간");
		panelPrice.add(lblHour10);
		
		JLabel lblHour12 = new JLabel("12시간");
		panelPrice.add(lblHour12);
		
		JLabel lblHourElse = new JLabel("12시간초과");
		panelPrice.add(lblHourElse);
		
		tfBasicCharge = new JTextField();
		panelPrice.add(tfBasicCharge);
		tfBasicCharge.setColumns(10);
		
		tfHour6 = new JTextField();
		tfHour6.setColumns(10);
		panelPrice.add(tfHour6);
		
		tfHour10 = new JTextField();
		tfHour10.setColumns(10);
		panelPrice.add(tfHour10);
		
		tfHour12 = new JTextField();
		tfHour12.setColumns(10);
		panelPrice.add(tfHour12);
		
		tfHourElse = new JTextField();
		tfHourElse.setColumns(10);
		panelPrice.add(tfHourElse);
		
		JPanel panelRentCnt = new JPanel();
		panel_info.add(panelRentCnt);
		panelRentCnt.setLayout(new BorderLayout(0, 0));
		if(isAdd) {
			JButton imgbtn = new JButton("사진추가");
			imgbtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					 do_fileOpen_actionPerformed(e);
				}
			});
			panelRentCnt.add(imgbtn);
		}else {
			lblCount = new JLabel("대여횟수 : ");
			lblCount.setHorizontalAlignment(SwingConstants.CENTER);
			panelRentCnt.add(lblCount);
		}
		
		JPanel panelBtn = new JPanel();
		container.add(panelBtn, BorderLayout.SOUTH);
		
		if(isAdd) {
			btnOk = new JButton("추가");
		}else {
			btnOk = new JButton("수정");
		}
		btnOk.addActionListener(this);
		panelBtn.add(btnOk);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		panelBtn.add(btnDelete);
		
		btnCancel = new JButton("초기화");
		btnCancel.addActionListener(this);
		panelBtn.add(btnCancel);
	}
	//버튼
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnDelete) {
			do_btnDelete_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnOk) {
			try {
				do_btnOk_actionPerformed(arg0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent arg0) throws IOException {
		if(btnOk.getText().equals("수정")) {
			//수정클릭
			CarModel model = getItem();			
			service.updateCarModel(model);
			carUi.reloadDataCarPanel();
			carUi.close();
		}else {
			//추가 클릭
			CarModel model = getItem();
			service.insertCarModel(model);//디비에 추가완료
			
			//선택한 이미지 바이트로 변환하여 테이블에 저장하기
			UserPic userpic = new UserPic();
			userpic.setCarCode(model.getCarCode());
			userpic.setPic(getPicFile());
			System.out.println(userpic.getPic());//빈배열주소
			service.insertUserPic(userpic);//널포인트ㅠㅠ
			JOptionPane.showMessageDialog(null, "이미지파일이 저장되었습니다.");
			
			carUi.reloadDataCarPanel();
			carUi.close();
		}
		
	}
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		//취소클릭, 지우지 말고 원래값으로 변경(초기화)
		if(btnOk.getText().equals("수정")) {
			String code = tfCode.getText();
			CarModel model = new CarModel();
			model.setCarCode(code);
			setCarModel(model);
		}else {
			cleartf();
		}
		
	}

	private void cleartf() {
		tfName.setText("");
		cmbBrand.setSelectedIndex(-1);
		cmbCarType.setSelectedIndex(-1);
		cmbFuel.setSelectedIndex(-1);
		tfHour6.setText("");
		tfHour10.setText("");
		tfHour12.setText("");
		tfHourElse.setText("");
	}

	protected void do_btnDelete_actionPerformed(ActionEvent arg0) {
		CarModel model = new CarModel();
		model.setCarCode(tfCode.getText());
		service.deleteCarModel(model);
		carUi.reloadDataCarPanel();
		carUi.close();
	}
	
	private CarModel getItem() {
		String code = tfCode.getText().trim();
		String name = tfName.getText().trim();

		Brand brand = cmbBrand.getSelectedItems();	
		CarType cartype = cmbCarType.getSelectedItems();
		Fuel fuel = cmbFuel.getSelectedItems();

		String color = tfColor.getText().trim();//색상
		String gear = "";
		boolean selectedGear = rdbtnAuto.isSelected();
		if(selectedGear) {
			gear = "auto";
		}else {
			gear = "stick";
		}
		//isrent,rentCnt 처리중
		boolean isRent = false;
		//가격
		int basicCharge = Integer.parseInt(tfBasicCharge.getText().replaceAll(",", ""));
		int hour6 = Integer.parseInt(tfHour6.getText().replaceAll(",", ""));
		int hour10 = Integer.parseInt(tfHour10.getText().replaceAll(",", ""));
		int hour12 = Integer.parseInt(tfHour12.getText().replaceAll(",", ""));
		int hourElse = Integer.parseInt(tfHourElse.getText().replaceAll(",", ""));
		
		CarModel item = new CarModel(code, name, color, gear, brand, cartype, basicCharge, hour6, hour10, hour12, hourElse, fuel, isRent, 0);
		return item;
	}
	
	//파일 읽어오기(폴더에 있는 파일)
		protected void do_fileOpen_actionPerformed(ActionEvent e) {
			currentDirectoryPath = System.getProperty("user.dir") + "\\images\\";
			chooser = new JFileChooser(currentDirectoryPath);
			
			int ret = chooser.showSaveDialog(null);
			//X버튼 누르거나 취소 => 1, 파일 열었을 때 => 0
			if( ret != JFileChooser.APPROVE_OPTION) {	//열기버튼 말고 다른 버튼 눌렀으면
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			filePath = chooser.getSelectedFile().getPath();
			
			//고른 이미지 디스플레이
			ImageIcon img = new ImageIcon(filePath);
			Image image = img.getImage();
			
			Image changedImg= image.getScaledInstance(250, 150, Image.SCALE_SMOOTH );
			ImageIcon resimg = new ImageIcon(changedImg);
			lbl_img.setIcon(resimg);
			panel_img.add(lbl_img);
			//파일복사하기(디비이용안하는 방법)
	       /* try(FileInputStream inputStream = new FileInputStream(filePath);
	        		FileOutputStream outputStream = new FileOutputStream(currentDirectoryPath+tfCode.getText()+".png")){
	              
	            int i = 0;
	            byte [] buffer = new byte[512];
	            while((i = inputStream.read(buffer)) != -1) {
	            	outputStream.write(buffer, 0, i);
	            }
	            System.out.println("파일이 복사되었습니다.");
	        } catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
			
			
		}


	public void setCarModel(CarModel carModel) {//set
		String strImg = imgPath+carModel.getCarCode()+".png";
		strImg = strImg.replace("\\", "/");
		ImageIcon img = new ImageIcon(strImg);
		//사진이 없을 경우 파일 insert
		if(img.getImage()==null) {
			img = new ImageIcon(currentDirectoryPath+"no_image.png");
		}
		Image image = img.getImage();
		Image changedImg= image.getScaledInstance(250, 150, Image.SCALE_SMOOTH );
		ImageIcon resimg = new ImageIcon(changedImg);
		lbl_img.setIcon(resimg);
		panel_img.add(lbl_img);
		
		tfCode.setText(carModel.getCarCode());
		tfName.setText(carModel.getName());
		
		cmbBrand.setSelectedItem(carModel.getBrand());
		cmbCarType.setSelectedItem(carModel.getCarType());
		cmbFuel.setSelectedItem(carModel.getFuel());
		
		tfColor.setText(carModel.getColor());
		
		//천단위 콤마찍기
		tfHour6.setText(String.format("%,d",carModel.getHour6()));
		tfHour10.setText(String.format("%,d",carModel.getHour10()));
		tfHour12.setText(String.format("%,d",carModel.getHour12()));
		tfHourElse.setText(String.format("%,d",carModel.getHourElse()));
		tfBasicCharge.setText(String.format("%,d",carModel.getBasicCharge()));

		String gear = carModel.getGear();
		System.out.println(gear);
		if(gear==null) {
			rdbtnAuto.setSelected(false);
			rdbtnStick.setSelected(false);
		}else if(gear.equalsIgnoreCase("auto")) {
			rdbtnAuto.setSelected(true);
		}else {
			rdbtnStick.setSelected(true);
		}
		
		lblCount.setText("대여횟수 : "+ carModel.getRentCnt() +"번");
	}

	public void setCarUi(CarUi carUi) {
		this.carUi = carUi;
	}
	
	private byte[] getPicFile() throws IOException{
		byte[] pic = null;
		File file = new File(filePath);
		System.out.println(filePath);
		try(InputStream is = new FileInputStream(file)){
			pic = new byte[is.available()];
			is.read(pic);
		}
		return pic;
	}


}















