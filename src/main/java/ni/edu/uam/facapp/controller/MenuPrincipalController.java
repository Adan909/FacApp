package ni.edu.uam.facapp.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ni.edu.uam.facapp.util.SceneManager;
import java.io.IOException;

public class MenuPrincipalController {

    @FXML
    private void abrirProductos() {
        abrirVentana("/ni/edu/uam/facapp/fxml/producto-view.fxml", "Gestión de Productos");
    }

    @FXML
    private void abrirCategorias() {
        abrirVentana("/ni/edu/uam/facapp/fxml/categoria.fxml", "Gestión de Categorías");
    }

    @FXML
    private void abrirCargos() {
        abrirVentana("/ni/edu/uam/facapp/fxml/cargo.fxml", "Gestión de Cargos");
    }

    @FXML
    private void salir() {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,
                "¿Desea cerrar la aplicación?", ButtonType.OK, ButtonType.CANCEL);
        if (a.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            Platform.exit();
        }
    }

    private void abrirVentana(String rutaFxml, String titulo) {
        try {
            SceneManager.abrirVentana(rutaFxml, titulo);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,
                    "No fue posible abrir la ventana: " + titulo).showAndWait();
        }
    }
}