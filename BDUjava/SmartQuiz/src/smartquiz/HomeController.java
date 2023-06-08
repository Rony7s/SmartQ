package smartquiz;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

 
public class HomeController implements Initializable {

    @FXML
    private HBox About_page;
    @FXML
    private HBox Profile_page;
    @FXML
    private HBox QuestionBank_page;
    @FXML
    private HBox TakeExam_page;
    @FXML
    private HBox JoinExam_page;
    @FXML
    private HBox Settings_page;
    @FXML
    private Button addNewQuestions;
    @FXML
    private Button join_now;
    @FXML
    private Label timeText;
    @FXML
    private Label dateText;
    @FXML
    private Label appUser;
    @FXML
    private Button Profile_item;
    @FXML
    private Button QuestionBank_item;
    @FXML
    private Button TakeExam_item;
    @FXML
    private Button JoinExam_item;
    @FXML
    private Button Settings_item;
    @FXML
    private Button About_item;
    @FXML
    private AnchorPane Home_index1;
    @FXML
    private Button QbankSeeQuestions;
    @FXML
    private Label QbankAddQuestions;
    @FXML
    private AnchorPane Home_index12;
    @FXML
    private TextField join_id;
    @FXML
    private TextField join_code;
    @FXML
    private TextField join_password;
    @FXML
    private AnchorPane Home_index13;
    @FXML
    private AnchorPane Home_index14;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //for Digital watch
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
    }    

    //update time
    
    private void updateTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        timeText.setText(formattedTime);
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        String formattedTime1 = currentTime.format(formatter1);
        dateText.setText(formattedTime1);
    }
    

    @FXML
    private void goProfile_page(ActionEvent event) {
        
        
        Profile_page.setVisible(true);
        QuestionBank_page.setVisible(false);
        TakeExam_page.setVisible(false);
        JoinExam_page.setVisible(false);
        Settings_page.setVisible(false);
        About_page.setVisible(false);
    }

    @FXML
    private void goQuestionBank_page(ActionEvent event) {
        
        Profile_page.setVisible(false);
        QuestionBank_page.setVisible(true);
        TakeExam_page.setVisible(false);
        JoinExam_page.setVisible(false);
        Settings_page.setVisible(false);
        About_page.setVisible(false);
    }

    @FXML
    private void goTakeExam_page(ActionEvent event) {
        
        Profile_page.setVisible(false);
        QuestionBank_page.setVisible(false);
        TakeExam_page.setVisible(true);
        JoinExam_page.setVisible(false);
        Settings_page.setVisible(false);
        About_page.setVisible(false);
    }

    @FXML
    private void goJoinExam_page(ActionEvent event) {

        Profile_page.setVisible(false);
        QuestionBank_page.setVisible(false);
        TakeExam_page.setVisible(false);
        JoinExam_page.setVisible(true);
        Settings_page.setVisible(false);
        About_page.setVisible(false);
    }

    @FXML
    private void goSettings_page(ActionEvent event) {
        
        Profile_page.setVisible(false);
        QuestionBank_page.setVisible(false);
        TakeExam_page.setVisible(false);
        JoinExam_page.setVisible(false);
        Settings_page.setVisible(true);
        About_page.setVisible(false);
    }

    @FXML
    private void goAbout_page(ActionEvent event) {
        
        Profile_page.setVisible(false);
        QuestionBank_page.setVisible(false);
        TakeExam_page.setVisible(false);
        JoinExam_page.setVisible(false);
        Settings_page.setVisible(false);
        About_page.setVisible(true);
    }

    
    
    @FXML
    private void goCreateQuestion_page( ) {
        
        try {
            //to Create Question page
            addNewQuestions.getScene().getWindow().hide();
            // show Home

            Parent root = FXMLLoader.load(getClass().getResource("CreateQuestion.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            

        } catch (Exception e) {
            System.out.println("sorry, page is missing mama");
        }
                    
        
        
        
        
    }

    @FXML
    private void doJoinNow(ActionEvent event) {
        try {
            //to Exampage page
            join_now.getScene().getWindow().hide();
            // show exam page

            Parent root = FXMLLoader.load(getClass().getResource("Exam_page.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("sorry,exam  page is missing mama");
        }
        
        
    }

    @FXML
    private void doQbankSeeQuestions(ActionEvent event) {
    }

    
}
