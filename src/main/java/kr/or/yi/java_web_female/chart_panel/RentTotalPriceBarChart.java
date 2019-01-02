package kr.or.yi.java_web_female.chart_panel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

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
import kr.or.yi.java_web_female.dto.totalPrice;
import kr.or.yi.java_web_female.service.RentUIService;

public class RentTotalPriceBarChart extends JFXPanel implements InitScene{

	private BarChart<String, Number> barChart;
	private RentUIService service;
	
	public BarChart<String, Number> getBarChart() {
		return barChart;
	}

	/**
	 * Create the panel.
	 */
	public RentTotalPriceBarChart() {
		service = new RentUIService();
	}

	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub
		Group root = new Group();
		Scene scene = new Scene(root);
		
		root.setAutoSizeChildren(true);
		
		//X축
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("브랜드");
		
		//Y축
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("매출액");
		
		barChart = new BarChart<>(xAxis, yAxis);
		
		//크기
		barChart.setPrefSize(440, 230);
		Map<String, String> maps = new HashMap<>();
		barChart.setData(getChartData());
		
		root.getChildren().add(barChart);
		
		return scene;
	}

	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		// TODO Auto-generated method stub
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		List<totalPrice> pList = service.selectTotalPrice();
		
		for(int i = 0 ; i < pList.size() ; i++) {
			totalPrice totalPrice = pList.get(i);
			
			list.add(getChartData(totalPrice));
		}
		
		return list;
	}

	private XYChart.Series<String, Number> getChartData(totalPrice totalPrice) {
		// TODO Auto-generated method stub
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		
		dataSeries.setName(totalPrice.getBrand());
		dataSeries.getData().add(new XYChart.Data<>("매출액", totalPrice.getTotalPrice()));
		
		return dataSeries;
	}

}
