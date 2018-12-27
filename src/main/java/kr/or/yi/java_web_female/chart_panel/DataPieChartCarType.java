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
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.CarModelService;
import kr.or.yi.java_web_female.service.CarUiService;
import kr.or.yi.java_web_female.service.StateCarChartService;

public class DataPieChartCarType extends JFXPanel implements InitScene{

	
	private PieChart pieChart;
	private StateCarChartService chartService;
	private CarModelService modelService;
	private CarUiService carService;
	
	@Override
	public Scene createScene() {
		chartService = new StateCarChartService();
		modelService = new CarModelService();
		carService = new CarUiService();
		
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(450, 275);
		pieChart.setData(getChartData());
		pieChart.setTitle("차종별 보유차량");
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

		List<StateCar> slist = chartService.selectCountByCarType();
		List<CarModel> clist = modelService.selectCarModelByAll();
		int totalCount = clist.size();
		
		for(int i=0;i<slist.size();i++) {

			StateCar sCar = slist.get(i);

			CarType type = new CarType();
			type.setCode(sCar.getTitle());
			//코드로 차종이름 검색
			CarType resType = carService.selectByCarCode(type);
			
			double rate = Math.round((sCar.getCount()*100.0)/totalCount);
			list.add(new PieChart.Data(resType.getType(),rate ));
		}
		return list;
	}
	
	

}






















