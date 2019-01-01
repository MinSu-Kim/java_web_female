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
		service = new RentUIService();
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
		xAxis.setLabel("브랜드별 렌트추이");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("렌트 수");
		
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
		
		
		String[] arrBrand = {"kia","hyundai","bmw","포드"};
		for(int j=0;j<arrBrand.length;j++) {
			
			List<StateCar> arr1 = service.selectCountRentByMonthWithBrand(arrBrand[j]);
			XYChart.Series<String, Number> dataSeriesS1 = new Series<String, Number>();
			for (int i = 0; i < arr1.size(); i++) {
				StateCar sc = arr1.get(i);
				dataSeriesS1.getData().add(new XYChart.Data<>(sc.getTitle().split("-")[1] + "월", sc.getCount()));
				dataSeriesS1.setName("kia");
			}		
			list.add(dataSeriesS1);
		}
		
		
		return list;
	}



}

























