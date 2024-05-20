package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import system.users;

public class MarketUserController implements Initializable {
    int maxItems = 1;
    users currentUser ;
    ArrayList<String> companies = new ArrayList<>(
            Arrays.asList("Amazon","Facebook","EzzSteel","Domety","Elaraby","EgyptAir")
    );
    @FXML
    private VBox companiesVBox;
    @FXML
    private ComboBox<String> periodComboBox;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private CategoryAxis lineChartXAxis;

    @FXML
    private CategoryAxis barChartXAxis;

    @FXML
    void chart1(ActionEvent event) {
        barChart.setVisible(false);
        lineChart.setVisible(true);
    }
    @FXML
    void chart2(ActionEvent event) {
        barChart.setVisible(true);
        lineChart.setVisible(false);
    }


    @Override
    @FXML
    public void initialize(URL url , ResourceBundle resourceBundle) {
        loadItems();
        lineChart.setVisible(false);
        barChart.setVisible(true);
        periodComboBox.getItems().addAll("1 Day", "1 Week", "1 Month", "1 Year");
        periodComboBox.setOnAction(event -> {
            String selectedPeriod = periodComboBox.getValue();
            updateCharts(selectedPeriod);
        });
        updateCharts("1 Day");
        XYChart.Series<String,Number> series3 = new XYChart.Series<>();
        series3.setName("2022");
        series3.getData().add(new XYChart.Data<>("Amazon", 700));
        series3.getData().add(new XYChart.Data<>("Facebook", 890));
        series3.getData().add(new XYChart.Data<>("Elaraby", 900));
        series3.getData().add(new XYChart.Data<>("EgyptAir", 950));
        series3.getData().add(new XYChart.Data<>("Domety", 200));
        series3.getData().add(new XYChart.Data<>("EzzSteel", 1000));

        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("2023");
        series4.getData().add(new XYChart.Data<>("Amazon", 500));
        series4.getData().add(new XYChart.Data<>("Facebook", 1000));
        series4.getData().add(new XYChart.Data<>("Elaraby", 1200));
        series4.getData().add(new XYChart.Data<>("EgyptAir", 800));
        series4.getData().add(new XYChart.Data<>("Domety", 800));
        series4.getData().add(new XYChart.Data<>("EzzSteel", 1500));
        lineChart.getData().addAll(series3, series4);

        XYChart.Series<String,Number> series1 = new XYChart.Series();
        series1.setName("2022");
        series1.getData().add(new XYChart.Data("Amazon",700));
        series1.getData().add(new XYChart.Data("Facebook",890));
        series1.getData().add(new XYChart.Data("Elaraby",900));
        series1.getData().add(new XYChart.Data("EgyptAir",950));
        series1.getData().add(new XYChart.Data("Domety",200));
        series1.getData().add(new XYChart.Data("EzzSteel",1000));

        XYChart.Series<String,Number> series2 = new XYChart.Series();
        series2.setName("2023");
        series2.getData().add(new XYChart.Data("Amazon",500));
        series2.getData().add(new XYChart.Data("Facebook",1000));
        series2.getData().add(new XYChart.Data("Elaraby",1200));
        series2.getData().add(new XYChart.Data("EgyptAir",800));
        series2.getData().add(new XYChart.Data("Domety",800));
        series2.getData().add(new XYChart.Data("EzzSteel",1500));


        barChart.getData().addAll(series1,series2);

    }

    private void updateCharts(String period) {
        lineChart.getData().clear();
        barChart.getData().clear();


        lineChartXAxis.getCategories().clear();
        barChartXAxis.getCategories().clear();

        XYChart.Series<String, Number> lineSeries = new XYChart.Series<>();
        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        lineSeries.setName("Stock Price");
        barSeries.setName("Stock Price");

        List<StockPriceData> stockData = generateStockData(period);

        List<String> categories = new ArrayList<>();
        for (StockPriceData data : stockData) {
            categories.add(data.getTime());
            lineSeries.getData().add(new XYChart.Data<>(data.getTime(), data.getPrice()));
            barSeries.getData().add(new XYChart.Data<>(data.getTime(), data.getPrice()));
        }

        lineChartXAxis.setCategories(FXCollections.observableArrayList(categories));
        barChartXAxis.setCategories(FXCollections.observableArrayList(categories));

        lineChart.getData().add(lineSeries);
        barChart.getData().add(barSeries);
    }

    private List<StockPriceData> generateStockData(String period) {
        List<StockPriceData> data = new ArrayList<>();

        int numberOfPoints = switch (period) {
            case "1 Day" -> 24;
            case "1 Week" -> 7;
            case "1 Month" -> 30;
            case "1 Year" -> 12;
            default -> 0;
        };

        for (int i = 1; i <= numberOfPoints; i++) {
            String time = switch (period) {
                case "1 Day" -> i + "h";
                case "1 Week" -> "Day " + i;
                case "1 Month" -> "Day " + i;
                case "1 Year" -> "Month " + i;
                default -> "";
            };
            double price = Math.random() * 100 + 100;
            data.add(new StockPriceData(time, price));
        }

        return data;
    }

    public static class StockPriceData {
        private final String time;
        private final double price;

        public StockPriceData(String time, double price) {
            this.time = time;
            this.price = price;
        }

        public String getTime() {
            return time;
        }

        public double getPrice() {
            return price;
        }
    }

    @FXML
    public void addNewItem() {
        for (String companies : companies) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ItemCompany.fxml"));
                HBox companyItem = loader.load();

                ItemCompanyController itemController = loader.getController();
                itemController.setCompanyName(companies);

                companiesVBox.getChildren().add(companyItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void loadItems() {
        // Set the maximum number of items to display
        for (int i = 0; i < maxItems; i++) {
            addNewItem();
        }
    }
    public void setUser(users currentUser) {
        this.currentUser = currentUser;
        ItemCompanyController itemCompanyController = new ItemCompanyController();
        itemCompanyController.setUser(currentUser);

    }
}
