package ni.edu.uam.facapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ni.edu.uam.facapp.model.Categoria;

public class CategoriaController {
    @FXML private TextField txtNombre;
    @FXML private CheckBox chkActiva;
    @FXML private TableView<Categoria> tblCategorias;
    @FXML private TableColumn<Categoria, String> colNombre;
    @FXML private TableColumn<Categoria, Boolean> colActiva;

    private final ObservableList<Categoria> categorias = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Datos de ejemplo para la lista temporal
        categorias.addAll(
                new Categoria(1, "Alimentos", true),
                new Categoria(2, "Bebidas", true),
                new Categoria(3, "Limpieza", true)
        );

        tblCategorias.setItems(categorias);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colActiva.setCellValueFactory(new PropertyValueFactory<>("activa"));
        chkActiva.setSelected(true);
    }

    @FXML
    private void guardar() {
        if (txtNombre.getText().isBlank()) {
            mensaje(Alert.AlertType.WARNING, "El nombre de la categoría es obligatorio.");
            return;
        }

        categorias.add(new Categoria(null, txtNombre.getText().trim(), chkActiva.isSelected()));
        mensaje(Alert.AlertType.INFORMATION, "Categoría agregada correctamente.");
        limpiar();
    }

    @FXML
    private void cerrar() {
        ((Stage) txtNombre.getScene().getWindow()).close();
    }

    private void limpiar() {
        txtNombre.clear();
        chkActiva.setSelected(true);
    }

    private void mensaje(Alert.AlertType tipo, String texto) {
        new Alert(tipo, texto, ButtonType.OK).showAndWait();
    }
}