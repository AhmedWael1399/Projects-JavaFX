package com.example.loginform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;

import java.io.IOException;

public class LoginForm extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Connection connection;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/loginandsignup","root","rootpassword");
            if (connection != null){
                System.out.println("Database Connected Successfully");
            }
        } catch (Exception e) {
            System.out.println("Database not Connected");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}