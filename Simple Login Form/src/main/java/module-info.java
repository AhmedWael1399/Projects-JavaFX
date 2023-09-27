module com.example.trial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.SimpleLoginForm to javafx.fxml;
    exports com.example.SimpleLoginForm;
}