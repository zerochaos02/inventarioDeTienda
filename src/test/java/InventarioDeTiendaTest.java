// InventarioDeTiendaTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventarioDeTiendaTest {
    @BeforeEach
    void setUp() {
        InventarioDeTienda.setProductos(InventarioDeTienda.crearMatrizLista());
    }

    @Test
    void agregarProductosTest() {
        InventarioDeTienda.setProductos(InventarioDeTienda.crearMatrizLista());
        InventarioDeTienda.agregarProductos(41, 5);
        assertEquals(9, InventarioDeTienda.getProductos()[0][2]);
    }

    @Test
    void restarProductosTest() {
        InventarioDeTienda.setProductos(InventarioDeTienda.crearMatrizLista());
        InventarioDeTienda.restarProductos(41, 2);
        assertEquals(2, InventarioDeTienda.getProductos()[0][2]);
    }

    @Test
    void consultarDisponibilidadTest() {
        InventarioDeTienda.setProductos(InventarioDeTienda.crearMatrizLista());
        assertDoesNotThrow(() -> InventarioDeTienda.consultarDispibilidad(41));
    }

    @Test
    void listarProductosTestImpresion() {
        InventarioDeTienda.setProductos(InventarioDeTienda.crearMatrizLista());
        assertDoesNotThrow(() -> InventarioDeTienda.listarProductos());
    }
}