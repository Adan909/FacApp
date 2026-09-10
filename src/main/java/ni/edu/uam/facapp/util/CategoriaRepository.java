package ni.edu.uam.facapp.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ni.edu.uam.facapp.model.Categoria;

public class CategoriaRepository {
    private static final ObservableList<Categoria> LISTA_CATEGORIAS = FXCollections.observableArrayList(
            new Categoria(1, "Alimentos", true),
            new Categoria(2, "Bebidas", true),
            new Categoria(3, "Limpieza", true)
    );

    public static ObservableList<Categoria> getCategorias() {
        return LISTA_CATEGORIAS;
    }

    public static void agregar(Categoria categoria) {
        LISTA_CATEGORIAS.add(categoria);
    }
}