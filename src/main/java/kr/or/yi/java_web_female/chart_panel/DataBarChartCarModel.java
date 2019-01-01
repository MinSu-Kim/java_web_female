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
import kr.or.yi.java_web_female.service.CarModelService;

@SuppressWarnings("serial")
public class DataBarChartCarModel extends JFXPanel implements InitScene {
	
	//바차트 배열 선언
	private BarChart<String, Number> barChart;
	private CarModelService service;

	public BarChart<String, Number> getBarChart() {
		return barChart;
	}

	//슈퍼생성
	public DataBarChartCarModel() {
		service = new CarModelService();
	}

	@Override
	public Scene createScene() {
		Group root = new Group();//javafx.scene.Group - import
		Scene scene = new Scene(root);
		
		root.setAutoSizeChildren(true);//"자동 크기 조정"하여 상태가 변경 될 때 영역과 컨트롤의 크기가 올바르게 조정
		
		//막대형 차트의 X축과 Y축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();//가로
		xAxis.setLabel("차모델");
		
		NumberAxis yAxis = new NumberAxis();//세로
		yAxis.setLabel("대여 횟수");
		
		barChart = new BarChart<>(xAxis, yAxis);

		barChart.setPrefSize(440, 230);
		Map<String, String> maps = new HashMap<>();
		barChart.setData(getChartData(maps));
		
		root.getChildren().add(barChart);//getChildren : Gets the list of children of this Group
		
		
		
		
		return scene;
	}
	
	//1번 - 차트에 데이터 넣기
	public ObservableList<XYChart.Series<String, Number>> getChartData(Map<String, String> maps) {//매개변수를 map으로 받음
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		List<CarModel> clist = service.SelectCarModelWithWhere(maps);
		
		for(int i = 1;i<clist.size();i++) {
			CarModel model = new CarModel();
			model = clist.get(i);
			model = service.selectCarModelByNo(model);
			
			list.add(getChartData(model));
		}
		
		return list;
	}
	
	//1번  - 차트에 데이터 넣기
	private XYChart.Series<String, Number> getChartData(CarModel model) {//매개변수 있는것
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		
		dataSeries.setName(model.getName());
		dataSeries.getData().add(new XYChart.Data<>("대여횟수",model.getRentCnt()));
		
		return dataSeries;
	}
	
	
}
