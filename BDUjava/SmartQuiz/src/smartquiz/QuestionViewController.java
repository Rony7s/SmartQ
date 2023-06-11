//Rony Ahmmed BDU-EdTech
//This code for Question bank see Question in a Table for DataBase

package smartquiz;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class QuestionViewController implements Initializable {

    @FXML
    private Button bankHome;
    @FXML
    private TableView<QbankTable> QuestionTable;
    @FXML
    private TableColumn<QbankTable, String> Question_text;
    @FXML
    private TableColumn<QbankTable, String> option_a;
    @FXML
    private TableColumn<QbankTable, String> option_b;
    @FXML
    private TableColumn<QbankTable, String> option_c;
    @FXML
    private TableColumn<QbankTable, String> option_d;
    @FXML
    private TableColumn<QbankTable, String> option_r;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Alert alert;

    public ObservableList<QbankTable> TablelistData() {
        ObservableList<QbankTable> listData = FXCollections.observableArrayList();

        String selectData = "SELECT * FROM questionswithans";
        connect = Database.connect();
        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            QbankTable sData;
            while (result.next()) {

                sData = new QbankTable(
                        result.getString("question"),
                        result.getString("option1"),
                        result.getString("option2"),
                        result.getString("option3"),
                        result.getString("option4"),
                        result.getString("rightOption")
                );

                listData.add(sData);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<QbankTable> TablelistData;

    public void TableShowData() {
        TablelistData = TablelistData();

        Question_text.setCellValueFactory(new PropertyValueFactory<QbankTable, String>("question"));
        option_a.setCellValueFactory(new PropertyValueFactory<QbankTable, String>("option_a"));
        option_b.setCellValueFactory(new PropertyValueFactory<QbankTable, String>("option_b"));
        option_c.setCellValueFactory(new PropertyValueFactory<QbankTable, String>("option_c"));
        option_d.setCellValueFactory(new PropertyValueFactory<QbankTable, String>("option_d"));
        option_r.setCellValueFactory(new PropertyValueFactory<QbankTable, String>("rightOption"));

        QuestionTable.setItems(TablelistData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TableShowData();

    }

    @FXML
    private void goHome_page(ActionEvent event) {
        try {
            //to see question page
            bankHome.getScene().getWindow().hide();
            // show exam page

            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("sorry,exam  page is missing Sir" + e);
        }
    }

}
