package com.example.SimpleLoginForm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;


public class LoginForm extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Connection connection;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/aheba","root","rootpassword");
            if (connection != null){
                System.out.println("Database Connected Successfully");
            }
        } catch (Exception e) {
           System.out.println("Database not Connected");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });

    }
    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Are you sure you want to exit");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}