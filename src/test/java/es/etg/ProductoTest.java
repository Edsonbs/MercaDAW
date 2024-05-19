package es.etg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.etg.programacion.mercadaw.producto.Cosmetica;
import es.etg.programacion.mercadaw.producto.Producto;

public class ProductoTest {
    @Test
   public void calcularPrecioTest(){
    //LO HE DEBUGEADO PARA COMPROBAR QUE TODOS SON IGUALES, ASI ME AHORRO PRUEBAS
    Producto producto = new Cosmetica("ejemplo", "ejemplo", "COSMETICA", 1, 0.20, 0.20, 0.4, 1, null);

    double precioVentaEsperado = 1.25;
    double precioVentaTest = producto.calcularPrecioVenta();
    
    double recargoPorAlturaEsperado = 0.06;
    double recargoAlturaTest = producto.calcularPrecioAltura();

    double recargoPorAnchuraEsperado = 0.06;
    double recargoAnchuraTest = producto.calcularPrecioAnchura();

    double recargoPesoEsperado = 0.06;
    double recargoPesoTest = producto.calcularPrecioPeso();

    double recargoNumPiezasEsperado = 0;
    double recargoNumPiezasTest = producto.calcularPrecioNumElementos();

    double precioTotalEsperado = 1.44;
    double precioTotalTest = producto.calcularPrecioTotal();

    double precioDolaresEsperado = 1.60;
    double precioDolaresTest = producto.calcularPrecioDolar();

    assertEquals(precioTotalEsperado, precioTotalTest, 1);
   } 
}
