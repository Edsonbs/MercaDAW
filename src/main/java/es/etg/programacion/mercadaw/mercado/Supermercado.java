package es.etg.programacion.mercadaw.mercado;

import java.util.List;

import es.etg.programacion.mercadaw.producto.IProducto;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.IEmpleado;
import es.etg.programacion.mercadaw.trabajador.Trabajador;

public class Supermercado implements Gestionable {
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Empleado> empleados;
    private String provincia;
    private String municipio;
    private String nombre;
    private String fechaCompra;
    
    public Supermercado(List<Cliente> clientes, List<Producto> productos, List<Empleado> empleados, String provincia,
            String municipio, String nombre, String fechaCompra) {
        this.clientes = clientes;
        this.productos = productos;
        this.empleados = empleados;
        this.provincia = provincia;
        this.municipio = municipio;
        this.nombre = nombre;
        this.fechaCompra = fechaCompra;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
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
    public String getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    @Override
    public IEmpleado darAltaEmpleado(String nombre, String apellido, Trabajador categoria) {
        return new IEmpleado() {
        };
    }
    @Override
    public IProducto darAltaProducto(Producto producto) {
        return new IProducto() {
        };
    }
    @Override
    public List<Empleado> obtenerEmpleado() {
        return empleados;
    }
    @Override
    public List<Producto> obtenerProducto() {
        return productos;
    }
    
    

}
