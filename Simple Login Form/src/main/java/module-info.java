module com.example.trial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.SimpleLoginForm to javafx.fxml;
    exports com.example.SimpleLoginForm;
}