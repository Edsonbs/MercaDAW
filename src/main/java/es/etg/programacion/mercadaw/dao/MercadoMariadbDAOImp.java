package es.etg.programacion.mercadaw.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<Empleado> listarEmpleados() {

        final String query = "SELECT id, nombre, apellidos, categoria FROM empleados";

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
    public List<Producto> listarProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarProductos'");
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
