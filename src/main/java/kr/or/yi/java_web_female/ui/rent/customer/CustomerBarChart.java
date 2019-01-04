package kr.or.yi.java_web_female.ui.rent.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import kr.or.yi.java_web_female.InitScene;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.dto.totalPrice;
import kr.or.yi.java_web_female.service.LoginUiService;
import kr.or.yi.java_web_female.service.RentUIService;
import kr.or.yi.java_web_female.ui.login.LoginUI;

public class CustomerBarChart extends JFXPanel implements InitScene {

	private BarChart<String, Number> barChart;
	private RentUIService service;
	private LoginUiService loginService;
	
	public static Customer loginCustomer;
	public static LoginUI loginUI;
	
	public static void setLoginUI(LoginUI loginUI) {
		CustomerBarChart.loginUI = loginUI;
	}

	public BarChart<String, Number> getBarChart() {
		return barChart;
	}

	/**
	 * Create the panel.
	 */
	public CustomerBarChart() {
		service = new RentUIService();
		loginService = new LoginUiService();
	}

	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub
		Group root = new Group();
		Scene scene = new Scene(root);
		
		root.setAutoSizeChildren(true);
		
		// X축
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("차량명");

		// Y축
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("대여횟수");

		barChart = new BarChart<>(xAxis, yAxis);

		barChart.setPrefSize(450, 250);
		Map<String, String> maps = new HashMap<>();
		barChart.setData(getChartData());
		barChart.setTitle("차량별 대여횟수");
		
		root.getChildren().add(barChart);

		return scene;
	}

	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		// TODO Auto-generated method stub
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();

		List<StateCar> scList = service.selectCarTypeStat(loginUI.loginCusotmer.getCode());
//		JOptionPane.showMessageDialog(null, "scList " + scList);
		
		for (int i = 0; i < scList.size(); i++) {
			StateCar result = scList.get(i);

			list.add(getChartData(result));
		}

		return list;
	}

	private XYChart.Series<String, Number> getChartData(StateCar result) {
		// TODO Auto-generated method stub
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();

		dataSeries.setName(result.getName());

		dataSeries.getData().add(new XYChart.Data<>("대여횟수", result.getCount()));

		return dataSeries;
	}
	
	public void addAllChartData() {
		barChart.getData().clear();
		barChart.setData(getChartData());
	}
}
