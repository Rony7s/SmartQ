//Rony Ahmmed BDU-EdTech
//SMARTQuiz exam page
package smartquiz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exam_pageController implements Initializable {

    @FXML
    private Button EMainMenu;
    @FXML
    private Label Etime;

    @FXML
    private AnchorPane questionsSet;
    @FXML
    private VBox exam_page_questions;

    @FXML
    private Label exam_question;
    @FXML
    private Label exam_option1;
    @FXML
    private Label exam_option2;
    @FXML
    private Label exam_option3;
    @FXML
    private Label exam_option4;

    @FXML
    private Button Previous_btn;
    @FXML
    private Button Next_btn;
    @FXML
    private Button Result_btn;
    @FXML
    private CheckBox option_choice1;
    @FXML
    private CheckBox option_choice3;
    @FXML
    private CheckBox option_choice2;
    @FXML
    private CheckBox option_choice4;

    @FXML
    private Button Cancel_btn;

    @FXML
    private void goHome(ActionEvent event) {

        try {
            //to Close this page
            EMainMenu.getScene().getWindow().hide();
            //Loading and show Home

            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("sorry,Home  page is missing");
        }
    }

    //Loading Question from Question set here a class name DemoQuestionSet
    DemoQuestionSet Q = new DemoQuestionSet();
    int index = 1; //index number of question

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //first question with answer
        setQuestion(index);
    }

    //choice option 
    String cOption = "";
    //save choice ans
    String[] saveAns = new String[10];
    @FXML
    public void choiceOption(ActionEvent event) {
        System.out.println("Choice me");
        if (option_choice1.isSelected()) {
            System.out.println("[A]");
            choiceCancel(1);
            cOption = "[A]";
        }

        if (option_choice2.isSelected()) {
            System.out.println("[B]");
            choiceCancel(2);
            cOption = "[B]";
        }
        if (option_choice3.isSelected()) {
            System.out.println("[C]");
            choiceCancel(3);
            cOption = "[C]";
        }
        if (option_choice4.isSelected()) {
            System.out.println("[D]");
            choiceCancel(4);
            cOption = "[D]";
        }

        saveAns[index-1] = cOption;
    }

    @FXML
    private void doCancelOPtion(ActionEvent event) {
        choiceCancel(0);
        cOption = "[D]";
    }

    @FXML
    private void doPrevious(ActionEvent event) {
        if (index > 1) {
            index--;
            setQuestion(index);
        }
    }

    @FXML
    private void doNextAns(ActionEvent event) {
        choiceCancel(0);
        System.out.println("ANS" + cOption);
        if (index < 10) {
            index++;
            setQuestion(index);
  
        }
    }

    @FXML
    private void goResultPage(ActionEvent event) {
        int p = 0;
        for (int i = 0; i < 10; i++) {
            if(saveAns[i] == Q.Call_Answers(i+1)){
                p++;
            }
            System.out.println(i+1+" "+saveAns[i]+" ");
        }
        System.out.println("Right Ans "+p+" Wrong "+(10-p));
        Etime.setText("Right Ans "+p+" Wrong "+(10-p));
    }

    //You can cancel choice without 1 for A 2 for B ... all for 0
    //this methods use next cancel and choice option 
    public void choiceCancel(int c) {
        if (c == 0) {
            option_choice1.setSelected(false);
            option_choice2.setSelected(false);
            option_choice3.setSelected(false);
            option_choice4.setSelected(false);
        }
        if (c == 1) {
            //option_choice1.setSelected(false);
            option_choice2.setSelected(false);
            option_choice3.setSelected(false);
            option_choice4.setSelected(false);
        }
        if (c == 2) {
            option_choice1.setSelected(false);
            //option_choice2.setSelected(false);
            option_choice3.setSelected(false);
            option_choice4.setSelected(false);
        }
        if (c == 3) {
            option_choice1.setSelected(false);
            option_choice2.setSelected(false);
            //option_choice3.setSelected(false);
            option_choice4.setSelected(false);
        }
        if (c == 4) {
            option_choice1.setSelected(false);
            option_choice2.setSelected(false);
            option_choice3.setSelected(false);
            //option_choice4.setSelected(false);
        }

    }

    //function of question 
    public void setQuestion(int Qnumber) {
        exam_question.setText(index + " " + Q.Call_Question(Qnumber));
        exam_option1.setText(Q.Call_Option(Qnumber, 1));
        exam_option2.setText(Q.Call_Option(Qnumber, 2));
        exam_option3.setText(Q.Call_Option(Qnumber, 3));
        exam_option4.setText(Q.Call_Option(Qnumber, 4));
    }
}
