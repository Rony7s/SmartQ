package smartquiz;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateQuestionController implements Initializable {

    @FXML
    private Button MainMenu;
    @FXML
    private TextField question_text;
    @FXML
    private TextField option_text1;
    @FXML
    private TextField option_text3;
    @FXML
    private TextField option_text2;
    @FXML
    private TextField option_text4;
    @FXML
    private ToggleGroup radio_button_group;
    @FXML
    private VBox createQuestion_page;
    @FXML
    private RadioButton radio_button1;
    @FXML
    private RadioButton radio_button3;
    @FXML
    private RadioButton radio_button2;
    @FXML
    private RadioButton radio_button4;
    @FXML
    private Button Qcancel;
    @FXML
    private Button Qdelete;
    @FXML
    private Button saveQuestion;
    @FXML
    private Button previewQuestion;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goHome(ActionEvent event) {
        try {
            //to Home page
            MainMenu.getScene().getWindow().hide();
            // show Home

            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("sorry,Home  page is missing mama");
        }
    }

    
    // this code for save question 
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    @FXML
    private void doSaveQuestion(ActionEvent event) {
    
        String sql = "INSERT INTO questionswithans ( question, option1, option2, option3, option4, rightOption) VALUES ( ?, ?, ?, ?, ?, ?)";

        connect = Database.connect();

        try {
            //radio option
            RadioButton selectedRadioButton = (RadioButton) radio_button_group.getSelectedToggle();
            String rightOption = selectedRadioButton.getText();
            
            
            Alert alert;
            if (question_text.getText().isEmpty() || option_text1.getText().isEmpty()|| option_text2.getText().isEmpty()|| option_text3.getText().isEmpty()|| option_text4.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Please fill up all form");
                alert.showAndWait();

            } else {

                // cheack Question is already have
                String checkData = "SELECT question FROM questionswithans WHERE question = '" + question_text.getText() + "'";

                prepare = connect.prepareStatement(checkData);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Already Have this Question");
                    alert.showAndWait();
                } else {

 
                        prepare = connect.prepareStatement(sql);
                        prepare.setString(1, question_text.getText());
                        prepare.setString(2, option_text1.getText());
                        prepare.setString(3, option_text2.getText());
                        prepare.setString(4, option_text3.getText());
                        prepare.setString(5, option_text4.getText());
                        prepare.setString(6, rightOption);
                        prepare.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Create A Question");
                        alert.showAndWait();

                    

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        }

    @FXML
    private void doPreviewQuestion(ActionEvent event) {
    }


    
}
