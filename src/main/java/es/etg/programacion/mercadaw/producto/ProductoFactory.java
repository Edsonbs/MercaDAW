package es.etg.programacion.mercadaw.producto;

import es.etg.programacion.mercadaw.trabajador.Cajero;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.Encargado;
import es.etg.programacion.mercadaw.trabajador.Reponedor;
import es.etg.programacion.mercadaw.trabajador.Trabajador;

public class ProductoFactory {
    
    public static Empleado crearEmpleado(String nombreEmpleado, String apellidoEmpleado, String categoriaEmpleado){
        final String CATEGORIA_REPONEDOR = Trabajador.REPONEDOR.name();
        final String CATEGORIA_CAJERO = Trabajador.CAJERO.name();
        final String CATEGORIA_ENCARGADO = Trabajador.ENCARGADO.name();
        final String CATEGORIA_OTRO = Trabajador.OTRO.name();

        Empleado miEmpleado = null;

        if (CATEGORIA_REPONEDOR == categoriaEmpleado){
            miEmpleado = new Reponedor(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
        }else if (CATEGORIA_CAJERO == categoriaEmpleado){
            miEmpleado = new Cajero(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
        }else if (CATEGORIA_ENCARGADO == categoriaEmpleado){
            miEmpleado = new Encargado(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
        }else if (CATEGORIA_OTRO == categoriaEmpleado){
            miEmpleado = new Empleado(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
        }

        return miEmpleado;
    }
}
