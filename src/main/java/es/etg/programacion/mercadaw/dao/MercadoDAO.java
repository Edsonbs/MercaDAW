package es.etg.programacion.mercadaw.dao;

import java.sql.SQLException;
import java.util.List;

import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;

public interface MercadoDAO {
    public List<Empleado> listarEmpleados() throws SQLException;
    public List<Producto> listarProductos()throws SQLException;
    public int anadir(Producto producto) throws SQLException;
    public int anadir(Empleado empleado) throws SQLException;
    public int eliminar(Producto producto)throws SQLException;
    public int eliminar(Empleado empleado)throws SQLException;
}
