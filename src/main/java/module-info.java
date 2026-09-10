module ni.edu.uam.facapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    exports ni.edu.uam.facapp.application;
    opens ni.edu.uam.facapp.application to javafx.graphics, javafx.fxml;


    exports ni.edu.uam.facapp.model;
    opens ni.edu.uam.facapp.controller to javafx.fxml;
    opens ni.edu.uam.facapp.model to javafx.base;
}