package es.etg.programacion.mercadaw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.etg.programacion.mercadaw.producto.Alimentacion;
import es.etg.programacion.mercadaw.producto.Categoria;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;

public class MercadoMariadbDAOImp implements MercadoDAO{
    private Connection conn;
    private final String URL = "jdbc:mariadb://localhost:3306/MercaDAW";
    private final String DATABASE_NAME = "MercaDAW";
    private final String DATABASE_USER = "SYSTEM";
    private final String DATABASE_PASS = "secret";
    public MercadoMariadbDAOImp() throws Exception{
        conn = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
        }
    
    @Override
    public List<Empleado> listarEmpleados() throws SQLException{

        final String query = "SELECT id, nombre, apellidos, categoria FROM empleados_view";

        List<Empleado> empleados = new ArrayList<Empleado>();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String categoria = rs.getString("categoria");

            Empleado a = new Empleado(id, nombre, apellidos, categoria);
            empleados.add(a);
        }
        rs.close();
        ps.close();

        return empleados;
    }

    @Override
    public List<Producto> listarProductos() throws SQLException{
        final String query = "SELECT nombre, marca, categoria, precio_en_euros, iva, altura_en_metros, anchura_en_metros, peso_en_kg, numero_elementos, descripcion FROM productos_view";

        List<Producto> productos = new ArrayList<Producto>();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            String nombre = rs.getString("nombre");
            String marca= rs.getString("marca");
            String categoria = rs.getString("categoria");
            double precio = rs.getDouble("precio");
            double iva = rs.getDouble("iva");
            double altura = rs.getDouble("altura_en_metros");
            double anchura = rs.getDouble("anchura_en_metros");
            double peso = rs.getDouble("peso_en_kg");
            int numElementos = rs.getInt("numero_elementos");
            String descripcion = rs.getString("descripcion");

            if(categoria.equals(Categoria.ALIMENTACION.name())){
                Producto prod =  new Alimentacion(nombre, marca, categoria, precio, altura, anchura, peso, numElementos, descripcion);
                productos.add(prod);
            }
           
        }
        rs.close();
        ps.close();

        return productos;
    }

    @Override
    public int anadir(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'anadir'");
    }

    @Override
    public int anadir(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'anadir'");
    }

    @Override
    public int eliminar(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public int eliminar(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
    
}
