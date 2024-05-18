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
import es.etg.programacion.mercadaw.producto.Cosmetica;
import es.etg.programacion.mercadaw.producto.Drogueria;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Cajero;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.Encargado;
import es.etg.programacion.mercadaw.trabajador.Reponedor;
import es.etg.programacion.mercadaw.trabajador.Trabajador;

public class MercadoMariadbDAOImp implements MercadoDAO{
    private Connection conn;
    private final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
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

            if(categoria.equals(Trabajador.CAJERO.name())){
                Empleado empleado = new Cajero(nombre, apellidos, categoria);
                empleados.add(empleado);
            }else if(categoria.equals(Trabajador.ENCARGADO.name())){
                Empleado empleado = new Encargado(nombre, apellidos, categoria);
                empleados.add(empleado);
            }else if(categoria.equals(Trabajador.REPONEDOR.name())){
                Empleado empleado = new Reponedor(nombre, apellidos, categoria);
                empleados.add(empleado);

            }else if(categoria.equals(Trabajador.STANDARD.name())){
                Empleado empleado = new Empleado(nombre, apellidos, categoria);

            }
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
            double altura = rs.getDouble("altura_en_metros");
            double anchura = rs.getDouble("anchura_en_metros");
            double peso = rs.getDouble("peso_en_kg");
            int numElementos = rs.getInt("numero_elementos");
            String descripcion = rs.getString("descripcion");

            if(categoria.equals(Categoria.ALIMENTACION.name())){
                Producto prod =  new Alimentacion(nombre, marca, categoria, precio, altura, anchura, peso, numElementos, descripcion);
                productos.add(prod);
            }else if(categoria.equals(Categoria.COSMETICA.name())){
                Producto prod = new Cosmetica(nombre, marca, categoria, precio, altura, anchura, peso, numElementos, descripcion);
                productos.add(prod);
            }else if(categoria.equals(Categoria.DROGUERIA.name())){
                Producto prod = new Drogueria(nombre, marca, categoria, precio, altura, anchura, peso, numElementos, descripcion);
                productos.add(prod);
            }
           
        }
        rs.close();
        ps.close();

        return productos;
    }

    @Override
    public int anadir(Producto producto) throws SQLException{
        int numRegistrosActualizados = 0;
        final String sql = "INSERT INTO productos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, producto.getId());
        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getMarca());
        ps.setString(3, producto.getCategoria());
        ps.setDouble(3, producto.getPrecioEnEuros());
        ps.setDouble(3, producto.getIva());
        ps.setDouble(3, producto.getAlturaEnMetros());
        ps.setDouble(3, producto.getAnchuraEnMetros());
        ps.setDouble(3, producto.getPesoEnKg());
        ps.setInt(3, producto.getNumElementos());
        ps.setString(3, producto.getDescripcion());

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public int anadir(Empleado empleado) throws SQLException{
        int numRegistrosActualizados = 0;
        final String sql = "INSERT INTO productos VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, empleado.getIdUsuario());
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(3, empleado.getCategoria());

        numRegistrosActualizados = ps.executeUpdate();
        ps.close();

        return numRegistrosActualizados;
    }

    @Override
    public int eliminar(Producto producto) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "DELETE FROM productos where id = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, producto.getId());

        numRegistrosActualizados = ps.executeUpdate();

        ps.close();
        return numRegistrosActualizados;
    }

    @Override
    public int eliminar(Empleado empleado) throws SQLException{
        int numRegistrosActualizados = 0;
        final String SQL = "DELETE FROM productos where id = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, empleado.getIdUsuario());

        numRegistrosActualizados = ps.executeUpdate();

        ps.close();
        return numRegistrosActualizados;
    }
    
}
