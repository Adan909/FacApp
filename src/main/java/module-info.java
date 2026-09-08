module ni.edu.uam.facapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.edu.uam.facapp.controller to javafx.fxml;
    exports ni.edu.uam.facapp;
}