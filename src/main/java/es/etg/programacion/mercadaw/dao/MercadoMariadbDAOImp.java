package es.etg.programacion.mercadaw.dao;

import java.io.File;
import java.util.List;

import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;

public class MercadoMariadbDAOImp implements MercadoDAO{
    private Connection conn;
    private final String URL = "jdbc:mariadb://localhost:3306/MercaDAW";
    private final String DATABASE_USER = "SYSTEM";
    private final String DATABASE_PASS = "secret";
    public MercadoMariadbDAOImp(){
        
        }
    }
    @Override
    public List<Empleado> listarEmpleados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarEmpleados'");
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
