package es.etg.programacion.mercadaw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.etg.programacion.mercadaw.App;
import es.etg.programacion.mercadaw.dao.MercadoMariadbDAOImp;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.producto.ProductoFactory;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.EmpleadoFactory;
import es.etg.programacion.mercadaw.util.printer.Impresora;
import es.etg.programacion.mercadaw.util.writer.WriterMarkdown;
import es.etg.programacion.mercadaw.view.IViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SupermercadoController extends Application {
    private Stage stagePrincipal;
    // Aquí guardaremos el producto con el que trabajará la vista visualizarPrecioVentaProducto:
    private static Producto productoSeleccionado;
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();

    public static Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public static void setProductoSeleccionado(Producto productoSeleccionado) {
        SupermercadoController.productoSeleccionado = productoSeleccionado;
    }

    /**
     * Método para crear un objeto del tipo Empleado.
     * @param nombreEmpleado
     * @param apellidoEmpleado
     * @param categoriaEmpleado
     * @return Empleado
     */
    public static Empleado crearEmpleado(String nombreEmpleado, String apellidoEmpleado, String categoriaEmpleado) {
        Empleado unEmpleado = EmpleadoFactory.crearEmpleado(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);

        return unEmpleado;
    }

    /**
     * Método para crear un ojeto del tipo Producto.
     * @param nombreProducto
     * @param marcaProducto
     * @param categoriaProducto
     * @param precioEurosProducto
     * @param alturaMetrosProducto
     * @param anchuraMetrosProducto
     * @param pesoKgProducto
     * @param cantidadElementosProducto
     * @param descripcionProducto
     * @return Producto
     */
    public static Producto crearProducto(String nombreProducto, String marcaProducto, String categoriaProducto, double precioEurosProducto, double alturaMetrosProducto, double anchuraMetrosProducto, double pesoKgProducto, int cantidadElementosProducto, String descripcionProducto){
        Producto unProducto = ProductoFactory.crearProducto(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);
        
        return unProducto;
    }

    /**
     * Método para añadir un objeto del tipo Empleado a la base de datos y a la lista empleados.
     * @param unEmpleado
     * @throws Exception
     */
    public static void darAltaEmpleado(Empleado unEmpleado) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(unEmpleado);
        empleados.add(unEmpleado);
    }

    /**
     * Método para añadir un objeto del tipo Producto a la base de datos y a la lista productos.
     * @param unProducto
     * @throws Exception
     */
    public static void darAltaProducto(Producto unProducto) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(unProducto);
        productos.add(unProducto);
    }

    /**
     * Elimina un objeto del tipo Empleado de la base de datos y de la lista empleados.
     * @param unEmpleado
     * @throws Exception
     */
    public static void darBajaEmpleado(Empleado unEmpleado) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(unEmpleado);
        empleados.remove(unEmpleado);
    }

    /**
     * Elimina un objeto del tipo Producto de la base de datos y de la lista de productos.
     * @param unProducto
     * @throws Exception
     */
    public static void darBajaProducto(Producto unProducto) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(unProducto);
        productos.remove(unProducto);
    }

    public static List<Empleado> getEmpleados() {
        return empleados;
    }

    public static void setEmpleados(List<Empleado> empleados) {
        SupermercadoController.empleados = empleados;
    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(List<Producto> productos) {
        SupermercadoController.productos = productos;
    }

    // Base de datos:
    /**
     * Devuelve la lista de empleados que hay en la base de datos.
     * @return List<Empleado>
     * @throws Exception
     */
    public static List<Empleado> obtenerListaEmpleadosBaseDatos() throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        List<Empleado> empleados = baseDatos.listarEmpleados();

        return empleados;
    }

    /**
     * Añade un empleado a la base de datos.
     * @param unEmpleado
     * @throws Exception
     */
    public static void anadirEmpleadoBaseDatos(Empleado unEmpleado) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(unEmpleado);
    }

    /**
     * Elimina un empleado de la base de datos.
     * @param unEmpleado
     * @throws Exception
     */
    public static void eliminarEmpleadoBaseDatos(Empleado unEmpleado) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(unEmpleado);
    }

    /**
     * Devuelve una lista con los productos de la base de datos.
     * @return
     * @throws Exception
     */
    public static List<Producto> obtenerListaProductosBaseDatos() throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        List<Producto> productos = baseDatos.listarProductos();

        return productos;
    }

    /**
     * Añade un producto a la base de datos.
     * @param unProducto
     * @throws Exception
     */
    public static void anadirProductoBaseDatos(Producto unProducto) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.anadir(unProducto);
    }

    /**
     * Borra un producto de la base de datos.
     * @param unProducto
     * @throws Exception
     */
    public static void eliminarProductoBaseDatos(Producto unProducto) throws Exception{
        MercadoMariadbDAOImp baseDatos = new MercadoMariadbDAOImp();

        baseDatos.eliminar(unProducto);
    }

    // Funciones de las vistas:
    /**
     * Método para generar la nómina de un empleado.
     * Crear un fichero.md y lo utiliza para hacer un fichero.pdf.
     * @param unEmpleado
     * @throws IOException
     */
    public static void generarNomina(Empleado unEmpleado) throws IOException{
        final String ESTRUCTURA_NOMBRE = "Nómina_%s_%s";

        String nombre = ESTRUCTURA_NOMBRE.formatted(unEmpleado.getNombre(), unEmpleado.getApellido());

        WriterMarkdown creador = new WriterMarkdown();
        Impresora impresora = new Impresora();

        creador.escribir(unEmpleado.calcularNomina());
        impresora.imprimir(nombre);
    }

    /**
     * Método para imprimir la etiqueta de un producto.
     * Crear un fichero.md y lo utiliza para hacer un fichero.pdf.
     * @param unProducto
     * @throws IOException
     */
    public static void imprimirEtiqueta(Producto unProducto) throws IOException{
        final String ESTRUCTURA_NOMBRE = "Etiqueta_%s_%s";

        WriterMarkdown creador = new WriterMarkdown();
        Impresora impresora = new Impresora();

        creador.escribirEtiqueta(unProducto);
        impresora.imprimir(ESTRUCTURA_NOMBRE.formatted(unProducto.getNombre(), unProducto.getMarca()));
    }
    
    /**
     * Genera un fichero.md que es usado para generar un fichero.pdf con toda la información de un producto.
     * @param unProducto
     * @throws IOException
     */
    public static void imprimirEtiquetaDetallada(Producto unProducto) throws IOException{
        final String ESTRUCTURA_NOMBRE = "Info_Producto_%s_%s";

        WriterMarkdown creador = new WriterMarkdown();
        Impresora impresora = new Impresora();

        creador.escribir(unProducto);
        impresora.imprimir(ESTRUCTURA_NOMBRE.formatted(unProducto.getNombre(), unProducto.getMarca()));
    }

    // Inicio y Vistas:
    @Override
    public void start(Stage stage) throws Exception {
        final String RUTA_INICIO = "view/inicioView";
        stagePrincipal = stage;

        empleados = obtenerListaEmpleadosBaseDatos();
        productos = obtenerListaProductosBaseDatos();
        stage.setScene(cargarVista(RUTA_INICIO));
        stage.show();
    }

    /**
     * Método para cargar la vista de un fichero.fxml que estará mostrando actualmente.
     * @param fxml
     * @return Scene
     * @throws IOException
     */
    private Scene cargarVista(String fxml) throws IOException {
        final String EXTENSION_FXML = ".fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + EXTENSION_FXML));
        Parent root = (Parent) fxmlLoader.load();

        //Obtengo el controlador de la vista para pasarle una referencia al controlador - MVC:
        IViewController viewController = fxmlLoader.<IViewController>getController();
        viewController.setSupermercadoController(this);
        Scene scene = new Scene(root);

        return scene;
    }

    /**
     * Método para cambiar de vista.
     * @param fxml
     * @throws IOException
     */
    public void cambiarVista(String fxml) throws IOException {
        Scene nuevaEscena = cargarVista(fxml);
        stagePrincipal.setScene(nuevaEscena);
    }
}