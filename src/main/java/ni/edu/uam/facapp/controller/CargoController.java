package ni.edu.uam.facapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ni.edu.uam.facapp.model.Cargo;

public class CargoController {
    @FXML private TextField txtNombre, txtDescripcion;
    @FXML private TableView<Cargo> tblCargos;
    @FXML private TableColumn<Cargo, String> colNombre, colDescripcion;

    private final ObservableList<Cargo> cargos = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        tblCargos.setItems(cargos);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }

    @FXML
    private void guardar() {
        if (txtNombre.getText().isBlank()) {
            mensaje(Alert.AlertType.WARNING, "El nombre del cargo es obligatorio.");
            return;
        }

        cargos.add(new Cargo(null, txtNombre.getText().trim(), txtDescripcion.getText().trim()));
        mensaje(Alert.AlertType.INFORMATION, "Cargo agregado correctamente.");
        limpiar();
    }

    @FXML
    private void cerrar() {
        ((Stage) txtNombre.getScene().getWindow()).close();
    }

    private void limpiar() {
        txtNombre.clear();
        txtDescripcion.clear();
    }

    private void mensaje(Alert.AlertType tipo, String texto) {
        new Alert(tipo, texto, ButtonType.OK).showAndWait();
    }
}