package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import es.etg.programacion.mercadaw.producto.Categoria;
import es.etg.programacion.mercadaw.producto.Producto;
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
            productos.setAll(SupermercadoController.getProductos());
            tablaProducto.setItems(productos);
        }catch(Exception excepcion){
            mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_CONEXION.getMensaje(), AlertType.ERROR);
        }
    }

    /**
     * Este método abre la vista en la que se mostrará con más detalle la información relacionada con un producto seleccionado.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     * @throws IOException
     */
    @FXML
    void abrirVistaDetallesPrecioVenta(MouseEvent event) throws IOException {
        Producto productoSeleccionado = tablaProducto.getFocusModel().getFocusedItem();

        if (productoSeleccionado != null){
            SupermercadoController.setProductoSeleccionado(productoSeleccionado);
            supermercadoController.cambiarVista(RutaVista.VISTA_VISUALIZACION_PRECIO_PRODUCTO.getRuta());
        }
    }

    /**
     * Método para dar de baja un producto en las base de datos.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     */
    @FXML
    void borrarProducto(MouseEvent event) {
        Producto productoSeleccionado = tablaProducto.getFocusModel().getFocusedItem();

        if (productoSeleccionado != null){
            try{
                SupermercadoController.darBajaProducto(productoSeleccionado);
                productos.setAll(SupermercadoController.getProductos());

                tablaProducto.setItems(productos);
            }catch(Exception excepcion){
                mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_CONEXION.getMensaje(), AlertType.ERROR);
            }
        }
    }

    /**
     * Método para dar de alta un producto en la base de datos.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     */
    @FXML
    void darAltaProducto(MouseEvent event) {
        final int ENTERO_PARA_REPRESENTAR_IVA = 100;
        final String SIMBOLO_PORCENTAJE = " %";

        try{
            String nombreProducto = txfNombre.getText();
            String marcaProducto = txfMarca.getText();
            String categoriaProducto = seleccionCategoriaProducto.getSelectionModel().getSelectedItem();
            Double precioEurosProducto = Double.valueOf(txfPrecioEuros.getText());
            Double alturaMetrosProducto = Double.valueOf(txfAlturaMetros.getText());
            Double anchuraMetrosProducto = Double.valueOf(txfAnchuraMetros.getText());
            Double pesoKgProducto = Double.valueOf(txfPesoKg.getText());
            int cantidadElementosProducto = Integer.parseInt(txfNumElementos.getText());
            String descripcionProducto = txfDescripcion.getText();

            Producto unProducto = SupermercadoController.crearProducto(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);

            if (unProducto != null){
                txfIva.setText(String.valueOf(unProducto.getIva()*ENTERO_PARA_REPRESENTAR_IVA)+SIMBOLO_PORCENTAJE);
                if (productos.contains(unProducto)){
                    mostrarAviso(MensajeAlerta.MSG_ALERTA_DUPLICADO.getMensaje(), AlertType.ERROR);
                }else{
                    try{
                        SupermercadoController.darAltaProducto(unProducto);
                        productos.setAll(SupermercadoController.getProductos());
                        tablaProducto.setItems(productos);
                    }catch(Exception excepcion){
                        mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_CONEXION.getMensaje(), AlertType.ERROR);
                    }
                }
            }else{
                mostrarAviso(MensajeAlerta.MSG_ALERTA_CAMPOS_PRODUCTO.getMensaje(), AlertType.ERROR);
            }
        }catch(NumberFormatException excepcion){
            mostrarAviso(MensajeAlerta.MSG_ALERTA_TIPO_DATO.getMensaje(), AlertType.ERROR);
        }
    }

    /**
     * Método para imprimir la etiqueta de un producto seleccionado por el usuario.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     */
    @FXML
    void imprimirEtiqueta(MouseEvent event) {
        Producto productoSeleccionado = tablaProducto.getFocusModel().getFocusedItem();

        if (productoSeleccionado != null){
            try{
                SupermercadoController.imprimirEtiqueta(productoSeleccionado);
                mostrarAviso(MensajeAlerta.MSG_ALERTA_EXITOSO.getMensaje(), AlertType.INFORMATION);
            }catch(IOException excepcion){
                mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_ETIQUETA.getMensaje(), AlertType.ERROR);
            }
        }
    }

    /**
     * Este método llama al controlador para representar la vista previa a ésta.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     * @throws IOException
     */
    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        supermercadoController.cambiarVista(RutaVista.VISTA_INICIO.getRuta());
    }

    /**
     * Este método se encarga de mostrar una ventana con información contextual.
     * @param msg -> Es el mensaje que mostrará la ventana.
     * @param tipo -> Especifica el tipo de ventana que se está mostrando.
     */
    private void mostrarAviso(String msg, AlertType tipo){
        final String TITULO = "Importante";

        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(TITULO);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
