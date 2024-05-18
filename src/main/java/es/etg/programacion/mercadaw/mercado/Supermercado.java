package es.etg.programacion.mercadaw.mercado;

import java.util.ArrayList;
import java.util.List;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;

public class Supermercado implements Gestionable {
    private List<Producto> productos = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private String provincia;
    private String municipio;
    private String nombre;
    
    public Supermercado(String provincia,
        String municipio, String nombre) {
        this.provincia = provincia;
        this.municipio = municipio;
        this.nombre = nombre;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
    @Override
    public void darAlta(Empleado empleado) {
       empleados.add(empleado);
    }
    @Override
    public void darAlta(Producto producto) {
      productos.add(producto);
    }
}
