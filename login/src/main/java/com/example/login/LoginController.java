package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.example.login.connectingToDatabase.getConnection;


public class LoginController {
    @FXML
    private AnchorPane login_form;
    @FXML
    private AnchorPane signup_form;
    @FXML
    private AnchorPane forget_password_form;
    @FXML
    private AnchorPane forgot_password_form;
    @FXML
    private TextField answerQuestion;
    @FXML
    private Button backButtonForgotPassword;
    @FXML
    private Button backButtonLastView;
    @FXML
    private TextField confirmPasswordLastView;
    @FXML
    private Hyperlink forgotPassword;
    @FXML
    private Button loginButton;
    @FXML
    private TextField passwordForgetPasswordLastView;
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private TextField passwordSignup;
    @FXML
    private Button proceedButtonLastView;
    @FXML
    private Button proceedForgotPassword;
    @FXML
    private Button registerButton;
    @FXML
    private Button returnToLoginButton;
    @FXML
    private ComboBox<?> selectQuestion;
    @FXML
    private CheckBox showPassword;
    @FXML
    private Button signupButton;
    @FXML
    private TextField usernameForgotPassword;
    @FXML
    private TextField usernameSignup;
    @FXML
    private TextField usernameLogin;
    @FXML
    private Label loginLabel;
    @FXML
    private Label signupLabel;




public void login(){

    String username = usernameLogin.getText();
    String password = passwordLogin.getText();

    if(username.isEmpty() && password.isEmpty()){
        loginLabel.setText("You Should enter a username and a password");
    }
    if(username.isEmpty()) {
        loginLabel.setText("You Should enter a username");
    }
    if(password.isEmpty()){
        loginLabel.setText("You Should enter a username");
    }

}

public void signupChangeForm(ActionEvent event){
    if (event.getSource() == signupButton){
        login_form.setVisible(false);
        signup_form.setVisible(true);
        forget_password_form.setVisible(false);
        forgot_password_form.setVisible(false);
    }
}

public void signup(){

    Connection conn = getConnection();
    try {
        String user_name = usernameSignup.getText();
        String password = passwordSignup.getText();


        String sql = "INSERT INTO users(user_name, password) VALUES (?,?) ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user_name);
        stmt.setString(2, password);
        stmt.execute();
        conn.close();


    } catch (Exception e) {

        System.out.println("Could not insert data successfully");
        e.printStackTrace();

    }

    String username = usernameSignup.getText();
    String password = passwordSignup.getText();

    if(username.isEmpty() && password.isEmpty()){
        signupLabel.setText("You Should enter a username and a password");
    }
    else if(username.isEmpty()) {
        signupLabel.setText("You Should enter a username");
    }
    else if(password.isEmpty()){
        signupLabel.setText("You Should enter a username");
    }
else {
    String checkUsername = "SELECT * FROM users WHERE user_name = ' " + usernameSignup.getText() + "'";

    String insertedData = "INSERT INTO users"
            + "(user_name, password)"
            + "VALUES(Ahmed, ahmedpassword)";
    }
}
    public void returnToLogin(ActionEvent event){
        if (event.getSource() == returnToLoginButton){
            login_form.setVisible(true);
            signup_form.setVisible(false);
            forget_password_form.setVisible(false);
            forgot_password_form.setVisible(false);
        }
    }


}