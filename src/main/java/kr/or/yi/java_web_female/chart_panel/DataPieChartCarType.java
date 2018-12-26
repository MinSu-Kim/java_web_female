package kr.or.yi.java_web_female.chart_panel;

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

public class DataPieChartCarType extends JFXPanel implements InitScene{

	
	private PieChart pieChart;

	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(400, 250);
		pieChart.setData(getChartData());
		pieChart.setTitle("Pie Chart");
		pieChart.setLegendVisible(true);	// 범례 표시 유무
		pieChart.setLegendSide(Side.BOTTOM);// 범례 위치
		pieChart.setLabelLineLength(30);	// 원의 둘레 가장자리와 라벨간의 거리 지정
		pieChart.setClockwise(true); 		// 시계방향 배치여부
		pieChart.setLabelsVisible(true);	// 레이블 표시여부
		
		for(Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
		}
		
		root.getChildren().add(pieChart);

		return scene;
	}


	private ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		list.addAll(new PieChart.Data("경형", 2), new PieChart.Data("소형", 4), new PieChart.Data("중형", 4), new PieChart.Data("대형",2), new PieChart.Data("suv",2));
		return list;
	}
	
	

}






















