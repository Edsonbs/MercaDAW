package es.etg.programacion.mercadaw.mercado;

import java.util.ArrayList;
import java.util.List;

import es.etg.programacion.mercadaw.dao.MercadoMariadbDAOImp;
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
    public void darAlta(Empleado empleado) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(empleado);
        empleados.add(empleado);
    }
    @Override
    public void darAlta(Producto producto) throws Exception {
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(producto);
        productos.add(producto);
    }
    @Override
    public void darBaja(Empleado empleado) throws Exception {
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(empleado);
        empleados.remove(empleado);
    }
    @Override
    public void darBaja(Producto producto) throws Exception {
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(producto);
        productos.remove(producto);
    }

    /**
     * Método para añadir un empleado a la base de datos y a la lista de empleados.
     * @param unEmpleado
     * @throws Exception
     */
    public void anadirEmpleadoBaseDatos(Empleado unEmpleado) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(unEmpleado);
        empleados.add(unEmpleado);
    }
    /**
     * Método para añadir un producto a la base de datos y a la lista de productos.
     * @param unProducto
     * @throws Exception
     */
    public void anadirProductoBaseDatos(Producto unProducto) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(unProducto);
        productos.add(unProducto);
    }

    /**
     * Método para eliminar un empleado de la base de datos y de la lista de empleados.
     * @param unEmpleado
     * @throws Exception
     */
    public void eliminarEmpleadoBaseDatos(Empleado unEmpleado) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(unEmpleado);
        empleados.remove(unEmpleado);
    }
    /**
     * Método para eliminar un producto de la base de datos y de la lista de productos.
     * @param unProducto
     * @throws Exception
     */
    public void eliminarProductoBaseDatos(Producto unProducto) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(unProducto);
        productos.remove(unProducto);
    }

    @Override
    public void cargarDatosIniciales() throws Exception {
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        empleados = baseDatos.listarEmpleados();
        productos = baseDatos.listarProductos();
    }
}
