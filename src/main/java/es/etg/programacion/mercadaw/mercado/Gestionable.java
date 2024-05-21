package es.etg.programacion.mercadaw.mercado;

import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;

public interface Gestionable {
    public void darAlta(Empleado empleado) throws Exception;
    public void darAlta(Producto producto) throws Exception;
    public void darBaja(Empleado empleado) throws Exception;
    public void darBaja(Producto producto) throws Exception;
    public void cargarDatosIniciales() throws Exception;
}
