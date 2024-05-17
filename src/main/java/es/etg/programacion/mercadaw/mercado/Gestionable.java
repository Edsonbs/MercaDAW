package es.etg.programacion.mercadaw.mercado;

import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;

public interface Gestionable {
    public void darAlta(Empleado empleado);
    public void darAlta(Producto producto);
}
