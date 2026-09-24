package ni.edu.uam.facapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ni.edu.uam.facapp.dao.CategoriaDAO;
import ni.edu.uam.facapp.model.Categoria;

import java.sql.SQLException;

public class CategoriaController {
    @FXML private TextField txtNombre;
    @FXML private CheckBox chkActiva;
    @FXML private TableView<Categoria> tblCategorias;
    @FXML private TableColumn<Categoria, String> colNombre;
    @FXML private TableColumn<Categoria, Boolean> colActiva;

    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private final ObservableList<Categoria> listaCategorias = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colActiva.setCellValueFactory(new PropertyValueFactory<>("activa"));
        tblCategorias.setItems(listaCategorias);
        chkActiva.setSelected(true);
        cargarCategorias();
    }

    private void cargarCategorias() {
        try {
            listaCategorias.setAll(categoriaDAO.listar());
        } catch (SQLException e) {
            mensaje(Alert.AlertType.ERROR, "Error al cargar categorías desde la base de datos: " + e.getMessage());
        }
    }

    @FXML
    private void guardar() {
        if (txtNombre.getText().isBlank()) {
            mensaje(Alert.AlertType.WARNING, "El nombre de la categoría es obligatorio.");
            return;
        }

        try {
            Categoria categoria = new Categoria(null, txtNombre.getText().trim(), chkActiva.isSelected());
            categoriaDAO.insertar(categoria);
            mensaje(Alert.AlertType.INFORMATION, "Categoría agregada correctamente.");
            limpiar();
            cargarCategorias();
        } catch (SQLException e) {
            mensaje(Alert.AlertType.ERROR, "Error al guardar la categoría en la base de datos: " + e.getMessage());
        }
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
