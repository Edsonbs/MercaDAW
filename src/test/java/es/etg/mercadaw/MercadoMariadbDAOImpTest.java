package es.etg.mercadaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import es.etg.programacion.mercadaw.dao.MercadoMariadbDAOImp;
import es.etg.programacion.mercadaw.producto.Drogueria;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Cajero;
import es.etg.programacion.mercadaw.trabajador.Empleado;

@TestMethodOrder(OrderAnnotation.class)
public class MercadoMariadbDAOImpTest {
    
    @Test
    @Order(10)
    public void listarEmpleadosTest() throws Exception{
        List<Empleado> empleados = new ArrayList<Empleado>();
        MercadoMariadbDAOImp prueba = new MercadoMariadbDAOImp();
        empleados.addAll(prueba.listarEmpleados());

        
        int tamanyoEmpleados = empleados.size();
        int tamanyoListaEmpleadosBd = prueba.listarEmpleados().size();
        assertEquals(tamanyoEmpleados, tamanyoListaEmpleadosBd);
        
    
    }

    @Test
    @Order(20)
    public void listarProductosTest() throws Exception{
        List<Producto> productos = new ArrayList<Producto>();
        MercadoMariadbDAOImp prueba = new MercadoMariadbDAOImp();
        productos.addAll(prueba.listarProductos());

        int tamanyoEmpleados = productos.size();
        int tamanyoListaEmpleadosBd = prueba.listarProductos().size();
        assertEquals(tamanyoEmpleados, tamanyoListaEmpleadosBd);

    
    }
    @Test
    @Order(30)
    public void anadirProductoTest() throws Exception{
        Producto drogueria = new Drogueria("nombre", "marca", "categoria", 10, 1, 1, 1, 1, "ejemplo descripcion");
        MercadoMariadbDAOImp prueba = new MercadoMariadbDAOImp();
        prueba.anadir(drogueria);

            
    };
    @Test
    @Order(40)
    public void anadirEmpleadoTest() throws Exception{
        Empleado empleado = new Cajero("cajero", "apellido", "CAJERO");
        MercadoMariadbDAOImp prueba = new MercadoMariadbDAOImp();
        prueba.anadir(empleado);

            
    };
    @Test
    @Order(50)
    public void eliminarProductoTest() throws Exception{
        Producto drogueria = new Drogueria("nombre", "marca", "categoria", 10, 1, 1, 1, 1, "ejemplo descripcion");
        MercadoMariadbDAOImp prueba = new MercadoMariadbDAOImp();
        prueba.eliminar(drogueria);

    } 
    @Test
    @Order(60)
    public void eliminarEmpleadoTest() throws Exception{
        Empleado empleado = new Cajero("cajero", "apellido", "CAJERO");
        MercadoMariadbDAOImp prueba = new MercadoMariadbDAOImp();
        prueba.eliminar(empleado);

    } 
}        




