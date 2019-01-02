package kr.or.yi.java_web_female.chart_panel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.ChartService;

@SuppressWarnings("serial")
public class DataBarChartCustomerAddr extends JFXPanel implements InitScene {

	private BarChart<String, Number> barChart;
	private ChartService service;

	public BarChart<String, Number> getBarChart() {
		return barChart;
	}

	public DataBarChartCustomerAddr() {
		service = new ChartService();
	}

	@Override
	public Scene createScene() {
		Group root = new Group();// javafx.scene.Group - import
		Scene scene = new Scene(root);

		root.setAutoSizeChildren(true);// "자동 크기 조정"하여 상태가 변경 될 때 영역과 컨트롤의 크기가 올바르게 조정

		// 막대형 차트의 X축과 Y축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();// 가로
		xAxis.setLabel("지역");

		NumberAxis yAxis = new NumberAxis();// 세로
		yAxis.setLabel("고객 인원");

		barChart = new BarChart<>(xAxis, yAxis);

		barChart.setPrefSize(440, 230);
		Map<String, String> maps = new HashMap<>();
		barChart.setData(getChartData(maps));
		// TODO Auto-generated method stub
		root.getChildren().add(barChart);// getChildren : Gets the list of children of this Group

		return scene;
	}

	private ObservableList<XYChart.Series<String, Number>> getChartData(Map<String, String> maps) {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();

		List<StateCar> list1 = service.chartAddr();

		for (int i = 0; i < list1.size(); i++) {
			StateCar sc = list1.get(i);

			list.add(getChartData(sc));
		}

		return list;
	}

	private XYChart.Series<String, Number> getChartData(StateCar sc) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();

		dataSeries.setName(sc.getTitle());
		dataSeries.getData().add(new XYChart.Data<>("고객인원", sc.getCount()));

		return dataSeries;
	}

}
