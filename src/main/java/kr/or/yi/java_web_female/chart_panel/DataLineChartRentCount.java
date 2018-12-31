  package kr.or.yi.java_web_female.chart_panel;

import java.awt.Font;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import kr.or.yi.java_web_female.InitScene;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.RentUIService;

@SuppressWarnings("serial")
public class DataLineChartRentCount extends JFXPanel implements InitScene {
	private RentUIService service;
	
	public DataLineChartRentCount() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
	}

	private LineChart<String, Number> lineChart;
	private CategoryAxis xAxis;
	
	public LineChart<String, Number> getLineChart() {
		return lineChart;
	}

	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		xAxis = new CategoryAxis();
		xAxis.setLabel("차종별 렌트추이");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(" 렌트 수");
		
		lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setPrefSize(440, 250);
		lineChart.setData(getChartData());
		lineChart.setTitle("기간별 렌트횟수");
		lineChart.setLegendVisible(true);	// 범례 표시 유무
		lineChart.setLegendSide(Side.BOTTOM);// 범례 위치
		
		root.getChildren().add(lineChart);
		
		return scene;
	}

	private ObservableList<Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		/*CarModel model1 = new CarModel(CarModel.getCarCode,CarModel.getCarName,기간1의 렌트수, 기간2의 렌트수, ... );
		list.add(getChartData(model1));*/
		
		//일단 기간별 전체 렌트횟수 표시
		service = new RentUIService();
		List<StateCar> countList = service.selectCountRentByMonth();
		StateCar car = countList.get(0);
		StateCar car2 = countList.get(1);
		list.add(getChartData(car, car2));
		
		return list;
	}

	private XYChart.Series<String, Number> getChartData(StateCar model,StateCar model2) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		
		dataSeries.setName("전체차종");
		dataSeries.getData().add(new XYChart.Data<>(model.getTitle(),model.getCount()));
		dataSeries.getData().add(new XYChart.Data<>(model2.getTitle(),model2.getCount()));
		
		return dataSeries;
	}

}

























