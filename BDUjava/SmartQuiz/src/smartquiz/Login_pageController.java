//[Rony Ahmmed BDU-EdTech] Login And SignUp Controller 
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Login_pageController implements Initializable {

    //signupForm here
    @FXML
    private BorderPane signupForm;
    @FXML
    private TextField su_email;
    @FXML
    private PasswordField su_confirmPassword1;
    @FXML
    private TextField fullName;
    @FXML
    private TextField institutionName;
    @FXML
    private Button su_signup;

    //login Form
    @FXML
    private BorderPane loginForm;
    @FXML
    private TextField u_email;
    @FXML
    private PasswordField u_password;
    @FXML
    private RadioButton u_showPassword;
    @FXML
    private Button u_forgotPassword;
    @FXML
    private Button u_login;

    //go login to signup or    
    @FXML
    private Button su_alreadyAccount;
    @FXML
    private Button su_registerAccount;
    @FXML
    private Button u_registerAccount;
    @FXML
    private Button u_createAccount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //On action browse other page (loginForm , singupForm)
    @FXML
    private void goSignupForm(ActionEvent event) {
        loginForm.setVisible(false);
        signupForm.setVisible(true);
    }

    @FXML
    private void goLoginForm(ActionEvent event) {
        loginForm.setVisible(true);
        signupForm.setVisible(false);
    }

    // forgot and show password
    @FXML
    private void showPassword(ActionEvent event) {
        // when selected than show password 
        if (u_showPassword.isSelected()) {
            u_password.setPromptText(u_password.getText());
            u_password.setText("");
        } else {
            u_password.setText(u_password.getPromptText());
        }
    }

    @FXML
    private void forgotPassword(ActionEvent event) {
    }

    // login or signup =======================================================do================================
    // this code for login 
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @FXML
    public void loginAccount() {
        String sql = "SELECT email, password FROM admin WHERE email = ? and password = ?";
        connect = Database.connect();

        try {

            Alert alert;
            if (u_email.getText().isEmpty() || u_password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Please fill up all Form");
                alert.showAndWait();

            } else {

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, u_email.getText());
                prepare.setString(2, u_password.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    // if correct username and password
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();

                    //to go home 
                    u_login.getScene().getWindow().hide();
                    // show Home
                    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    // if incorrect username and password
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("incorrect Number/email or password");
                    alert.showAndWait();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void signupAccount() {
        String sql = "INSERT INTO admin (email, password, fullname, institution) VALUES ( ?, ?, ?, ?)";

        connect = Database.connect();

        try {

            Alert alert;
            if (su_email.getText().isEmpty() || su_confirmPassword1.getText().isEmpty() || fullName.getText().isEmpty() || institutionName.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText(su_email.getText() + "Please fill up all form");
                alert.showAndWait();

            } else {

                // cheack email is already have
                String checkData = "SELECT email FROM admin WHERE email = '" + su_email.getText() + "'";

                prepare = connect.prepareStatement(checkData);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Already Have this Email");
                    alert.showAndWait();
                } else {

                    if (su_confirmPassword1.getText().length() < 4) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid Password, Make sure it lenght 4 more ...");
                        alert.showAndWait();

                    } else {

                        prepare = connect.prepareStatement(sql);
                        prepare.setString(1, su_email.getText());
                        prepare.setString(2, su_confirmPassword1.getText());
                        prepare.setString(3, fullName.getText());
                        prepare.setString(4, institutionName.getText());
                        prepare.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Create Account Welcome SMARTQuiz");
                        alert.showAndWait();

                        su_email.setText("");
                        su_confirmPassword1.setText("");
                        fullName.setText("");
                        institutionName.setText("");

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
