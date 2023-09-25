package com.example.SimpleLoginForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

public class LoginController {
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;




    public void login(ActionEvent event) throws IOException {

        String username = usernameField.getText();
        String password = passwordField.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("display-data-view.fxml"));
        root = fxmlLoader.load();
        DisplayDataController displayDataController = fxmlLoader.getController();
        if (username.isEmpty() && password.isEmpty()){
            passwordLabel.setText("Please Enter username and password");
        }
        else if (password.isEmpty()){
            passwordLabel.setText("Please Enter a password");
        }

        else if (username.isEmpty()){
            passwordLabel.setText("Please Enter a username");
        }

       else if (password.equals("ahmedpassword")){
            displayDataController.displayName(username);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Display Page");
            stage.show();
        }
        else {
            passwordLabel.setText("Password is incorrect please try again!");
        }
    }
    public void exit(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Are you sure you want to exit");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }


    }
}