package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.App;
import es.etg.programacion.mercadaw.producto.Alimentacion;
import es.etg.programacion.mercadaw.producto.Categoria;
import es.etg.programacion.mercadaw.producto.Cosmetica;
import es.etg.programacion.mercadaw.producto.Drogueria;
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

public class GestionProductoViewController implements Initializable{

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final String ATRIBUTO_NOMBRE = "nombre";
        final String ATRIBUTO_MARCA = "marca";
        final String ATRIBUTO_CATEGORIA = "categoria";
        final String ATRIBUTO_PRECIO_EUROS = "precioEnEuros";
        final String ATRIBUTO_IVA = "iva";
        final String ATRIBUTO_ALTURA_METROS = "alturaEnMetros";
        final String ATRIBUTO_ANCHURA_METROS = "anchuraEnMetros";
        final String ATRIBUTO_PESO_KG = "pesoEnKg";
        final String ATRIBUTO_NUM_ELEMENTOS = "numElementos";
        final String ATRIBUTO_DESCIPCION = "descripcion";
        final String MSG_TXF_IVA = "IVA SEGÚN CATEGORÍA.";

        String[] categoriasProducto = {Categoria.ALIMENTACION.name(), Categoria.DROGUERIA.name(), Categoria.COSMETICA.name()}; // Lista categorías utilizables:
        productos = FXCollections.observableArrayList(); // Lista de productos a representar:

        // Añadimos todas las opciones de la lista "categoriasProducto".
        txfIva.setDisable(true);
        txfIva.setText(MSG_TXF_IVA);
        seleccionCategoriaProducto.getItems().addAll(categoriasProducto);

        // Aquí representaremos en cada columna de la tabla cada dato correspondiente:
        colNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_NOMBRE));
        colMarca.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_MARCA));
        colCategoria.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_CATEGORIA));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_PRECIO_EUROS));
        colIva.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_IVA));
        colAltura.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_ALTURA_METROS));
        colAnchura.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_ANCHURA_METROS));
        colPeso.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_PESO_KG));
        colElementos.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_NUM_ELEMENTOS));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<Producto, String>(ATRIBUTO_DESCIPCION));
    }

    @FXML
    void abrirVistaDetallesPrecioVenta(MouseEvent event) throws IOException {
        final String RUTA_VISTA_VISUALIZAR_PRECIO_PRODUCTO = "view/visualizarPrecioVentaProducto";
        // Obtengo el producto que ha seleccionado el usuario para generar los detalles:
        Producto seleccionado = tablaProducto.getFocusModel().getFocusedItem();
        App.setRoot(RUTA_VISTA_VISUALIZAR_PRECIO_PRODUCTO);
    }

    @FXML
    void borrarProducto(MouseEvent event) {

    }

    @FXML
    void darAltaProducto(MouseEvent event) {
        final String MSG_AVISO_CATEGORIA = "Tienes que especificar una categoría.";
        final int ENTERO_PARA_REPRESENTAR_IVA = 100;
        final String SIMBOLO_PORCENTAJE = " %";

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

        // Añadiremos un producto lista de producto:
        Producto miProducto = null;
        if (Categoria.ALIMENTACION.name() == categoriaProducto){
            miProducto = new Alimentacion(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);
            productos.add(miProducto);
        } else if (Categoria.DROGUERIA.name() == categoriaProducto){
            miProducto = new Drogueria(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);
            productos.add(miProducto);
        } else if (Categoria.COSMETICA.name() == categoriaProducto){
            miProducto = new Cosmetica(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);
            productos.add(miProducto);
        } else{
            mostrarAviso(MSG_AVISO_CATEGORIA, AlertType.ERROR);
        }

        if (miProducto != null){
            txfIva.setText(String.valueOf(miProducto.getIva()*ENTERO_PARA_REPRESENTAR_IVA)+SIMBOLO_PORCENTAJE);
        }

        // Representaremos en la tabla la lista de productos:
        tablaProducto.setItems(productos);
    }

    @FXML
    void imprimirEtiqueta(MouseEvent event) {
        // Obtengo el producto que ha seleccionado el usuario para imprimirlo:
        Producto seleccionado = tablaProducto.getFocusModel().getFocusedItem();
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        final String RUTA_VISTA_INICIO = "view/inicioView";
        App.setRoot(RUTA_VISTA_INICIO);
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
