package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.App;
import es.etg.programacion.mercadaw.producto.Alimentacion;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.Trabajador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    // Métodos:
    private String[] categoriasProducto = {"Alimentación", "Droguería", "Cosmética"};
    private ObservableList<Producto> productos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Con este método, al iniciar la ventana, se harán las siguientes cosas:

        // Añadimos todas las opciones de la lista "categoriasProducto".
        txfIva.setDisable(true);
        txfIva.setText("OBTENER IVA SEGÚN TIPO");
        seleccionCategoriaProducto.getItems().addAll(categoriasProducto);
    }

    @FXML
    void abrirVistaDetallesPrecioVenta(MouseEvent event) throws IOException {
        // Obtengo el producto que ha seleccionado el usuario para generar los detalles:
        Producto seleccionado = tablaProducto.getFocusModel().getFocusedItem();
        App.setRoot("view/visualizarPrecioVentaProducto");
    }

    @FXML
    void borrarProducto(MouseEvent event) {

    }

    @FXML
    void darAltaProducto(MouseEvent event) {
        // Con la siguiente línea obtendremos los datos introducidos por el usuario:
        String nombreProducto = txfNombre.getText();
        String marcaProducto = txfMarca.getText();
        String categoriaProducto = seleccionCategoriaProducto.getSelectionModel().getSelectedItem();
        String precioEurosProducto = txfPrecioEuros.getText();
        String alturaMetrosProducto = txfAlturaMetros.getText();
        String anchuraMetrosProducto = txfAnchuraMetros.getText();
        String pesoKgProducto = txfPesoKg.getText();
        String cantidadElementosProducto = txfNumElementos.getText();
        String descripcionProducto = txfDescripcion.getText();

        // Aquí tendremos una lista con los trabajadores creados por el usuario:
        //productos = FXCollections.observableArrayList(new Producto(nombreProducto, marcaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto, iva?, categoriaProducto));

        productos = FXCollections.observableArrayList(new Alimentacion(nombreProducto, marcaProducto, categoriaProducto, Double.valueOf(precioEurosProducto), Double.valueOf(alturaMetrosProducto), Double.valueOf(anchuraMetrosProducto), Double.valueOf(pesoKgProducto), Integer.parseInt(cantidadElementosProducto), descripcionProducto));

        // Aquí representaremos en cada columna de la tabla cada dato:
        colNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        colMarca.setCellValueFactory(new PropertyValueFactory<Producto, String>("marca"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<Producto, String>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Producto, String>("precioEnEuros"));
        colIva.setCellValueFactory(new PropertyValueFactory<Producto, String>("iva"));
        colAltura.setCellValueFactory(new PropertyValueFactory<Producto, String>("alturaEnMetros"));
        colAnchura.setCellValueFactory(new PropertyValueFactory<Producto, String>("anchuraEnMetros"));
        colPeso.setCellValueFactory(new PropertyValueFactory<Producto, String>("pesoEnKg"));
        colElementos.setCellValueFactory(new PropertyValueFactory<Producto, String>("numElementos"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));

        // Con la siguiente línea añadiremos a la tabla los nuevos trabajadores:
        tablaProducto.getItems().addAll(productos);
    }

    @FXML
    void imprimirEtiqueta(MouseEvent event) {
        // Obtengo el producto que ha seleccionado el usuario para imprimirlo:
        Producto seleccionado = tablaProducto.getFocusModel().getFocusedItem();
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        App.setRoot("view/inicioView");
    }

}
