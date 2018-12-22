package kr.or.yi.java_web_female.chart_panel;

import java.util.Iterator;
import java.util.List;

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
import javafx.scene.paint.Color;
import kr.or.yi.java_web_female.InitScene;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.service.CarModelService;

@SuppressWarnings("serial")
public class PanelBarChart extends JFXPanel implements InitScene {
	
	//바차트 배열 선언
	private BarChart<String, Number> barChart;
	private CarModelService service;
	
	//슈퍼생성
	public PanelBarChart() {
		service = new CarModelService();
	}

	@Override
	public Scene createScene() {
		Group root = new Group();//javafx.scene.Group - import
		Scene scene = new Scene(root, Color.ALICEBLUE);
		root.setAutoSizeChildren(true);//"자동 크기 조정"하여 상태가 변경 될 때 영역과 컨트롤의 크기가 올바르게 조정
		
		//막대형 차트의 X축과 Y축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();//가로
		xAxis.setLabel("차모델");
		
		NumberAxis yAxis = new NumberAxis();//세로
		yAxis.setLabel("대여 횟수");
		
		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("차량별 대여 횟수 통계");
		
		barChart.setPrefSize(500, 250);
		barChart.setData(getChartData());
		
		root.getChildren().add(barChart);//getChildren : Gets the list of children of this Group
		
		return scene;
	}
	
	//1번 - 차트에 데이터 넣기
	private ObservableList<XYChart.Series<String, Number>> getChartData() {//매개변수 없는것
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		List<CarModel> clist = service.selectCarModelByAll();//널포인트
		
		for(int i = 1;i<clist.size();i++) {//있는 숫자만 반복문 돌리도록 바꾸기ㅠㅠ!
			CarModel model = new CarModel();
			String str = String.format("V%03d", i);
			model.setCarCode(str);
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
	
	//데이터 지우기
	public void deleteAllData() {
		barChart.getData().clear();
	}
	
	//데이터 하나 지우기
	public void delChartData(CarModel model) {
		ObservableList<Series<String, Number>> list = barChart.getData();
		Iterator<Series<String, Number>>  it = list.iterator();
		while(it.hasNext()) {
			Series<String, Number> s = it.next();
			if (s.getName().equals(model.getName())) {
				barChart.getData().remove(s);
				break;
			}
		}
	}
	
	//데이터 추가
	public void updateChartData(CarModel model) {
		ObservableList<Series<String, Number>> list = barChart.getData();
		
		for(int i = 0; i<list.size(); i++) {
			Series<String, Number> s = list.get(i);
			if (s.getName().equals(model.getName())) {
				s.getData().set(0, new XYChart.Data<>("대여횟수", model.getRentCnt()));
				break;
			}
		}
	}
	
	//데이터 추가
	public void addChartData(CarModel model) {
		barChart.getData().add(getChartData(model));
	}
	
	//데이터 모두 추가
	public void addAllChartData() {
		barChart.setData(getChartData());
	}
}



















