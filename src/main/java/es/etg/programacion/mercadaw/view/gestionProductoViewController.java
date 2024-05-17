package es.etg.programacion.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class gestionProductoViewController {

    @FXML
    private Button btnBorrarProducto;

    @FXML
    private Button btnDarAltaProducto;

    @FXML
    private Button btnImprimirEtiqueta;

    @FXML
    private Button btnVerDetallesPrecio;

    @FXML
    private TableColumn<?, ?> colAltura;

    @FXML
    private TableColumn<?, ?> colAnchura;

    @FXML
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colDescripcion;

    @FXML
    private TableColumn<?, ?> colElementos;

    @FXML
    private TableColumn<?, ?> colIva;

    @FXML
    private TableColumn<?, ?> colMarca;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colPeso;

    @FXML
    private TableColumn<?, ?> colPrecio;

    @FXML
    private ImageView imgVolver;

    @FXML
    private ChoiceBox<?> seleccionCategoriaProducto;

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

    @FXML
    void abrirVistaDetallesPrecioVenta(MouseEvent event) {

    }

    @FXML
    void borrarProducto(MouseEvent event) {

    }

    @FXML
    void darAltaProducto(MouseEvent event) {

    }

    @FXML
    void imprimirEtiqueta(MouseEvent event) {

    }

    @FXML
    void volverVistaAnterior(MouseEvent event) {

    }

}
