package kr.or.yi.java_web_female.chart_panel;

import java.util.List;

import javax.swing.JOptionPane;

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
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.service.RentUIService;

@SuppressWarnings("serial")
public class RentCarOptionsPieChart extends JFXPanel implements InitScene {
	private PieChart pieChart;
	private RentUIService service;
	private int total;
	

	public PieChart getPieChart() {
		return pieChart;
	}

	/**
	 * Create the panel.
	 */
	public RentCarOptionsPieChart() {

	}

	@Override
	public Scene createScene() {
		// TODO Auto-generated method stub
		service = new RentUIService();
		
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(440, 230);
		pieChart.setData(getChartData());
		pieChart.setTitle("대여 시 옵션 선호도");
		pieChart.setLegendVisible(true);
		pieChart.setLegendSide(Side.BOTTOM);
		pieChart.setLabelLineLength(30);
		pieChart.setClockwise(true);
		pieChart.setLabelsVisible(true);
		
		for(Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
		}
		root.getChildren().add(pieChart);
		
		return scene;
	}

	private ObservableList<Data> getChartData() {
		// TODO Auto-generated method stub
		ObservableList<Data> list = FXCollections.observableArrayList();
		
		List<StateCar> rentList = service.selectCarOptionsWithRentCode();
//		JOptionPane.showMessageDialog(null, rentList);
		for(int i = 0 ; i < rentList.size() ; i++) {
			total += rentList.get(i).getCount();
		}
//		JOptionPane.showConfirmDialog(null, total);
		
		
		for(int i = 0 ; i < rentList.size() ; i++) {
			double rate = Math.round(rentList.get(i).getCount() * 100.0 / total);
			list.add(new PieChart.Data(rentList.get(i).getTitle(), rate));
		}
		return list;
	}

}
