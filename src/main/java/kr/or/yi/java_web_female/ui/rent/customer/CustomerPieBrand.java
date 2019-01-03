package kr.or.yi.java_web_female.ui.rent.customer;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import kr.or.yi.java_web_female.InitScene;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.LoginUiService;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.login.LoginUI;

public class CustomerPieBrand extends JFXPanel implements InitScene {
	public CustomerPieBrand() {
	}
	private PieChart pieChart;
	private RentUIService service;
	private LoginUiService loginService;
	private int total;
	
	public static Customer loginCustomer;
	public static LoginUI loginUI;

	public static void setLoginUI(LoginUI loginUI) {
		CustomerPieBrand.loginUI = loginUI;
	}

	public PieChart getPieChart() {
		return pieChart;
	}

	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub\
		loginService = new LoginUiService();
		service = new RentUIService();
		
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(440, 250);
		pieChart.setData(getChartData());
		pieChart.setTitle("브랜드별 선호도");
		pieChart.setLegendVisible(true);	
		pieChart.setLegendSide(Side.BOTTOM);
		pieChart.setLabelLineLength(30);	
		pieChart.setClockwise(true); 		
		pieChart.setLabelsVisible(true);	
		
		for(Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
		}
		
		root.getChildren().add(pieChart);

		return scene;
	}
	
	private ObservableList<Data> getChartData() {
		// TODO Auto-generated method stub
		ObservableList<Data> list = FXCollections.observableArrayList();
		
		List<StateCar> rentList = service.selectPreference(loginUI.loginCusotmer.getCode());

		for(int i = 0 ; i < rentList.size() ; i++) {
			total += rentList.get(i).getCount();
		}
		
		for(int i = 0 ; i < rentList.size() ; i++) {
			double rate = Math.round(rentList.get(i).getCount() * 100.0 / total);
			list.add(new PieChart.Data(rentList.get(i).getTitle(), rate));
		}
		return list;
	}

}
