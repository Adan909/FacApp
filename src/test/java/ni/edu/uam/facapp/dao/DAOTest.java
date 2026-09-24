package ni.edu.uam.facapp.dao;

import ni.edu.uam.facapp.model.Categoria;
import ni.edu.uam.facapp.model.Producto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DAOTest {

    @Test
    void testDAOMethodsExist() throws NoSuchMethodException {
        Method insertarCat = CategoriaDAO.class.getMethod("insertar", Categoria.class);
        assertNotNull(insertarCat);

        Method insertarProd = ProductoDAO.class.getMethod("insertar", Producto.class);
        assertNotNull(insertarProd);

        Categoria categoria = new Categoria(1, "Bebidas", true);
        Producto producto = new Producto(1, "P001", "Coca Cola", categoria, new BigDecimal("25.00"), 10, "img.png", true);

        assertEquals("P001", producto.getCodigo());
        assertEquals("Coca Cola", producto.getNombre());
        assertEquals(1, producto.getCategoria().getId());
        assertEquals(new BigDecimal("25.00"), producto.getPrecioVenta());
        assertEquals(10, producto.getExistencia());
        assertEquals("img.png", producto.getRutaImagen());
        assertTrue(producto.isActivo());
    }
}
