package es.etg.programacion.mercadaw.mercado;

import java.util.List;

import es.etg.programacion.mercadaw.producto.IProducto;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.IEmpleado;
import es.etg.programacion.mercadaw.trabajador.Trabajador;

public interface Gestionable {
    public IEmpleado darAltaEmpleado(String nombre, String apellido, Trabajador categoria);
    public IProducto darAltaProducto(Producto producto);
    public List<Empleado> obtenerEmpleado();
    public List <Producto> obtenerProducto();
}
