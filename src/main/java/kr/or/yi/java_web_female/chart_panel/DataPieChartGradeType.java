package kr.or.yi.java_web_female.chart_panel;

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
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.ChartService;

public class DataPieChartGradeType extends JFXPanel implements InitScene {
	private PieChart pieChart;
	private ChartService service;

	public PieChart getPieChart() {
		return pieChart;
	}

	@Override
	public Scene createScene() {
		service = new ChartService();
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);

		pieChart = new PieChart();
		pieChart.setPrefSize(440, 250);

		pieChart.setData(getChartData());
		pieChart.setTitle("등급별 고객인원");
		pieChart.setLegendVisible(true); // 범례 표시 유무
		pieChart.setLegendSide(Side.BOTTOM);// 범례 위치
		pieChart.setLabelLineLength(30); // 원의 둘레 가장자리와 라벨간의 거리 지정
		pieChart.setClockwise(true); // 시계방향 배치여부
		pieChart.setLabelsVisible(true); // 레이블 표시여부

		for (Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
		}

		root.getChildren().add(pieChart);

		return scene;
	}

	private ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		List<StateCar> clist = service.chartGrade();
		List<Customer> totalList = service.selectCustomerByAll();
		int total = totalList.size();

		for (int i = 0; i < clist.size(); i++) {

			StateCar custom = clist.get(i);

			double rate = Math.round((custom.getCount() * 100.0) / total);
			list.add(new PieChart.Data(custom.getTitle(), rate));
		}
		return list;
	}
}
