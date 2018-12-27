  package kr.or.yi.java_web_female.chart_panel;

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

public class LineChartCarModelCount extends JFXPanel implements InitScene {

	private LineChart<String, Number> lineChart;
	private CategoryAxis xAxis;
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		xAxis = new CategoryAxis();
		xAxis.setLabel("모델별 렌트추이");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(" 렌트회수");
		
		lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setPrefSize(500, 250);
		lineChart.setData(getChartData());
		lineChart.setTitle("Line Chart");
		lineChart.setLegendVisible(true);	// 범례 표시 유무
		lineChart.setLegendSide(Side.BOTTOM);// 범례 위치
		
		return null;
	}

	private ObservableList<Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		//CarModel model1 = new CarModel(CarModel.getCarCode,CarModel.getCarName,)
		return null;
	}

}

























