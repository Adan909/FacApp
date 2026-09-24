package ni.edu.uam.facapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ni.edu.uam.facapp.model.Categoria;
import ni.edu.uam.facapp.util.CategoriaRepository;

public class CategoriaController {
    @FXML private TextField txtNombre;
    @FXML private CheckBox chkActiva;
    @FXML private TableView<Categoria> tblCategorias;
    @FXML private TableColumn<Categoria, String> colNombre;
    @FXML private TableColumn<Categoria, Boolean> colActiva;

    @FXML
    private void initialize() {
        // Asignar la lista compartida
        tblCategorias.setItems(CategoriaRepository.getCategorias());
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

        // Guardar en el repositorio compartido
        CategoriaRepository.agregar(new Categoria(null, txtNombre.getText().trim(), chkActiva.isSelected()));
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
