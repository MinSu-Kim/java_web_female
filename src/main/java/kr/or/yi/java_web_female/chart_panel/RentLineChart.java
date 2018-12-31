package kr.or.yi.java_web_female.chart_panel;

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
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.RentUIService;

public class RentLineChart extends JFXPanel implements InitScene{
	private RentUIService service;
	
	/**
	 * Create the panel.
	 */
	public RentLineChart() {
		service = new RentUIService();
	}

	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		//x축
		//CategoryAxis : 숫자 외 문자열, 다른 데이터가 들어갈 수 있음.
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("대여일자");
		
		//y축
		//NumberAxis : 숫자 데이터로 이루어짐
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("대여횟수");
		
		//Line Chart
		LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setPrefSize(500, 250);	//차트 크기
		lineChart.setData(getChartData());
		lineChart.setTitle("월별 차량 대여 횟수");	//차트 제목
		lineChart.setLegendVisible(true);	//범례 표시 유무
		lineChart.setLegendSide(Side.BOTTOM);	//범례 위치 => 아래
		
		root.getChildren().add(lineChart);
		
		return scene;
	}

	//데이터 넣기
	//XYChart : LineChart의 상위 클래스
	//데이터 넣는 방법 1. getData() 후에 add() 또는 addAll()과 같은 메서드 활용하기 ===> 이 때 넣어줘야 할 데이터 형식 XYChart.Series<X, Y> list;
	//getData()를 통해서 add 해주는 경우 : Series list 하나씩 넣을 수 있음(=데이터 line을 하나씩 넣을 수 있다.)
	//데이터 넣는 방법 2. setData()를 통해 데이터 세팅하기 ===> 이 때 넣어줘야 할 데이터 형식 ObservableList<XYChart.Series<X, Y>> list;
	//setData()를 통한 방법 : 1개 이상의 Series들을 ObservableList에 담아서 한번에 넣어줘야 한다.
	
	//======> setData()방법
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		// TODO Auto-generated method stub
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();		
		
		
		List<StateCar> arr = service.selectCountRentByMonthWithCarType("경형");
		
		for(int i = 0 ; i < arr.size() ; i++) {
			StateCar sc = arr.get(i);
			//x축 : 월, y축 : 대여횟수
			dataSeries.getData().add(new XYChart.Data<>(sc.getTitle().split("-")[1] + "월", sc.getCount()));
			//범례 이름 ====> 차종(경형, 중형, 소형, 대형, ...)
			dataSeries.setName("경형");
		}
		
		list.add(dataSeries);
		
		XYChart.Series<String, Number> dataSeries1 = new Series<String, Number>();

		List<StateCar> arr1 = service.selectCountRentByMonthWithCarType("소형");

		for (int i = 0; i < arr1.size(); i++) {
			StateCar sc = arr1.get(i);
			// x축 : 월, y축 : 대여횟수
			dataSeries1.getData().add(new XYChart.Data<>(sc.getTitle().split("-")[1] + "월", sc.getCount()));
			// 범례 이름 ====> 차종(경형, 중형, 소형, 대형, ...)
			dataSeries1.setName("소형");
		}

		list.add(dataSeries1);	
		
	/*	XYChart.Series<String, Number> dataSeries1 = new Series<String, Number>();
		dataSeries1.setName("2017년");
		
		List<StateCar> arr1 = service.selectCountRentByMonth();
		for(int i = 0 ; i < arr1.size() ; i++) {
			StateCar sc = arr1.get(i);
			dataSeries1.getData().add(new XYChart.Data<>(sc.getTitle().split("-")[1]+"월", sc.getCount() + 10));
		}
		
		list.add(dataSeries1);*/
		
		return list;
	}
	

}
