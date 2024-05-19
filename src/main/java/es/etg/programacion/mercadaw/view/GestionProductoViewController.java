package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import es.etg.programacion.mercadaw.producto.Categoria;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.producto.ProductoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GestionProductoViewController implements Initializable, IViewController{

    @FXML
    private Button btnBorrarProducto;

    @FXML
    private Button btnDarAltaProducto;

    @FXML
    private Button btnImprimirEtiqueta;

    @FXML
    private Button btnVerDetallesPrecio;

    @FXML
    private TableColumn<Producto, String> colAltura;

    @FXML
    private TableColumn<Producto, String> colAnchura;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, String> colDescripcion;

    @FXML
    private TableColumn<Producto, String> colElementos;

    @FXML
    private TableColumn<Producto, String> colIva;

    @FXML
    private TableColumn<Producto, String> colMarca;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colPeso;

    @FXML
    private TableColumn<Producto, String> colPrecio;

    @FXML
    private ImageView imgVolver;

    @FXML
    private ChoiceBox<String> seleccionCategoriaProducto;

    @FXML
    private TableView<Producto> tablaProducto;

    @FXML
    private TextField txfAlturaMetros;

    @FXML
    private TextField txfAnchuraMetros;

    @FXML
    private TextArea txfDescripcion;

    @FXML
    private TextField txfIva;

    @FXML
    private TextField txfMarca;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfNumElementos;

    @FXML
    private TextField txfPesoKg;

    @FXML
    private TextField txfPrecioEuros;

    final String MSG_ALERTA_FALLO_CONEXION = "Algo ha fallado durante la conexión a base de datos.";

    private ObservableList <Producto> productos;
    private SupermercadoController supermercadoController;

    @Override
    public void setSupermercadoController(SupermercadoController controller) {
        this.supermercadoController = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final String ATRIBUTO_NOMBRE         = "nombre"              ;
        final String ATRIBUTO_MARCA          = "marca"               ;
        final String ATRIBUTO_CATEGORIA      = "categoria"           ;
        final String ATRIBUTO_PRECIO_EUROS   = "precioEnEuros"       ;
        final String ATRIBUTO_IVA            = "iva"                 ;
        final String ATRIBUTO_ALTURA_METROS  = "alturaEnMetros"      ;
        final String ATRIBUTO_ANCHURA_METROS = "anchuraEnMetros"     ;
        final String ATRIBUTO_PESO_KG        = "pesoEnKg"            ;
        final String ATRIBUTO_NUM_ELEMENTOS  = "numElementos"        ;
        final String ATRIBUTO_DESCIPCION     = "descripcion"         ;
        final String MSG_TXF_IVA             = "IVA SEGÚN CATEGORÍA.";

        String[] categoriasProducto = {Categoria.ALIMENTACION.name(), Categoria.DROGUERIA.name(), Categoria.COSMETICA.name()};
        productos = FXCollections.observableArrayList();

        // Ajustes de representación:
        txfIva.setDisable(true);
        txfIva.setText(MSG_TXF_IVA);
        txfDescripcion.setWrapText(true);
        seleccionCategoriaProducto.getItems().addAll(categoriasProducto);

        // Asignamos el valor de cada columna a un atributo.
        colNombre     .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_NOMBRE        ));
        colMarca      .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_MARCA         ));
        colCategoria  .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_CATEGORIA     ));
        colPrecio     .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_PRECIO_EUROS  ));
        colIva        .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_IVA           ));
        colAltura     .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_ALTURA_METROS ));
        colAnchura    .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_ANCHURA_METROS));
        colPeso       .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_PESO_KG       ));
        colElementos  .setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_NUM_ELEMENTOS ));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_DESCIPCION    ));

        try{
            List<Producto> productosBaseDatos = SupermercadoController.obtenerListaProductos();

            productos.addAll(productosBaseDatos);
            tablaProducto.setItems(productos);
        }catch(Exception excepcion){
            mostrarAviso(MSG_ALERTA_FALLO_CONEXION, AlertType.ERROR);
        }
    }

    @FXML
    void abrirVistaDetallesPrecioVenta(MouseEvent event) throws IOException {
        Producto productoSeleccionado = tablaProducto.getFocusModel().getFocusedItem();

        if (productoSeleccionado != null){
            SupermercadoController.setProductoSeleccionado(productoSeleccionado);
            supermercadoController.cambiarVista(RutaVista.VISTA_VISUALIZACION_PRECIO_PRODUCTO.getRuta());
        }
    }

    @FXML
    void borrarProducto(MouseEvent event) {
        Producto productoSeleccionado = tablaProducto.getFocusModel().getFocusedItem();

        if (productoSeleccionado != null){
            try{
                SupermercadoController.eliminarProducto(productoSeleccionado);
                productos.remove(productoSeleccionado);
    
                tablaProducto.setItems(productos);
            }catch(Exception excepcion){
                System.out.println(excepcion);
                mostrarAviso(MSG_ALERTA_FALLO_CONEXION, AlertType.ERROR);
            }
        }
    }

    @FXML
    void darAltaProducto(MouseEvent event) {
        final String MSG_ALERTA_CAMPOS = "Todos los campos deben estar rellenados (exepto descripción).";
        final String MSG_ALERTA_DUPLICADO = "Este producto ya existe.";
        final String MSG_ALERTA_TIPO_DATO = "Hay bloques numéricos en los que has introducido no numéricos. Recuerda que los decimales son con '.' y no con ','.";
        final int ENTERO_PARA_REPRESENTAR_IVA = 100;
        final String SIMBOLO_PORCENTAJE = " %";

        // Comprobaremos que el usuario haya introducido los datos numéricos con el formato correspondiente.
        try{
            // Obtendremos los datos introducidos por el usuario:
            String nombreProducto = txfNombre.getText();
            String marcaProducto = txfMarca.getText();
            String categoriaProducto = seleccionCategoriaProducto.getSelectionModel().getSelectedItem();
            Double precioEurosProducto = Double.valueOf(txfPrecioEuros.getText());
            Double alturaMetrosProducto = Double.valueOf(txfAlturaMetros.getText());
            Double anchuraMetrosProducto = Double.valueOf(txfAnchuraMetros.getText());
            Double pesoKgProducto = Double.valueOf(txfPesoKg.getText());
            int cantidadElementosProducto = Integer.parseInt(txfNumElementos.getText());
            String descripcionProducto = txfDescripcion.getText();

            Producto unProducto = ProductoFactory.crearProducto(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);

            // Comprobaremos que el usuario no haya dejado ningún campo vacío (salvo Descripción).
            if (unProducto != null){
                txfIva.setText(String.valueOf(unProducto.getIva()*ENTERO_PARA_REPRESENTAR_IVA)+SIMBOLO_PORCENTAJE);

                // Comprobaremos que el producto no se duplique.
                if (productos.contains(unProducto)){
                    mostrarAviso(MSG_ALERTA_DUPLICADO, AlertType.ERROR);
                }else{
                    // Usamos el controlador para eliminar el producto seleccionado de la base de datos.
                    try{
                        SupermercadoController.anadirProducto(unProducto);
                        productos.add(unProducto);

                        tablaProducto.setItems(productos);
                    }catch(Exception excepcion){
                        mostrarAviso(MSG_ALERTA_FALLO_CONEXION, AlertType.ERROR);
                    }
                }
            }else{
                mostrarAviso(MSG_ALERTA_CAMPOS, AlertType.ERROR);
            }
        }catch(NumberFormatException excepcion){
            mostrarAviso(MSG_ALERTA_TIPO_DATO, AlertType.ERROR);
        }
    }

    @FXML
    void imprimirEtiqueta(MouseEvent event) {
        Producto productoSeleccionado = tablaProducto.getFocusModel().getFocusedItem();

        productoSeleccionado.calcularPrecioAltura(); // Esta línea es sólo para que no salga warning.
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        supermercadoController.cambiarVista(RutaVista.VISTA_INICIO.getRuta());
    }

    private void mostrarAviso(String msg, AlertType tipo){
        final String TITULO = "Importante";

        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(TITULO);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
