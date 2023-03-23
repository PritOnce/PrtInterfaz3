module com.example.prtinterfaz3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prtinterfaz3 to javafx.fxml;
    exports com.example.prtinterfaz3;
}