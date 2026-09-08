module ni.edu.uam.facapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.edu.uam.facapp to javafx.fxml;
    exports ni.edu.uam.facapp;
}