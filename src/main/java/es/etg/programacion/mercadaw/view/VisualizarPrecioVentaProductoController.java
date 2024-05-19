package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import es.etg.programacion.mercadaw.producto.Producto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VisualizarPrecioVentaProductoController implements Initializable, IViewController {

    @FXML
    private ImageView imgVolver;

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
    private TextField txfPrecio;

    @FXML
    private TextField txfPrecioTotal;

    @FXML
    private TextField txfPrecioVenta;

    @FXML
    private TextField txfRecargoAltura;

    @FXML
    private TextField txfRecargoAnchura;

    @FXML
    private TextField txfRecargoNumPiezas;

    @FXML
    private TextField txfRecargoPeso;

    private SupermercadoController supermercadoController = null;

    @Override
    public void setSupermercadoController(SupermercadoController controller) {
        this.supermercadoController = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Producto productoSeleccionado = SupermercadoController.getProductoSeleccionado();

        txfNombre.setDisable(true);
        txfMarca.setDisable(true);
        txfPrecio.setDisable(true);
        txfPrecioVenta.setDisable(true);
        txfRecargoPeso.setDisable(true);
        txfRecargoAltura.setDisable(true);
        txfRecargoAnchura.setDisable(true);
        txfRecargoNumPiezas.setDisable(true);
        txfPrecioTotal.setDisable(true);
        txfIva.setDisable(true);
        txfAlturaMetros.setDisable(true);
        txfAnchuraMetros.setDisable(true);
        txfPesoKg.setDisable(true);
        txfNumElementos.setDisable(true);
        txfDescripcion.setDisable(true);

        txfNombre.setText(productoSeleccionado.getNombre());
        txfMarca.setText(productoSeleccionado.getMarca());
        txfPrecio.setText(String.valueOf(productoSeleccionado.getPrecioEnEuros()));
        txfPrecioVenta.setText(String.valueOf(productoSeleccionado.getPrecioVenta()));
        // txfRecargoPeso aún necesita un método para obtener este dato.
        // txfRecargoAltura aún necesita un método para obtener este dato.
        // txfRecargoAnchura aún necesita un método para obtener este dato.
        // txfRecargoNumPiezas aún necesita un método para obtener este dato.
        // txfPrecioTotal aún necesita un método para obtener este dato.
        txfIva.setText(String.valueOf(productoSeleccionado.getIva()));
        txfAlturaMetros.setText(String.valueOf(productoSeleccionado.getAlturaEnMetros()));
        txfAnchuraMetros.setText(String.valueOf(productoSeleccionado.getAnchuraEnMetros()));
        txfPesoKg.setText(String.valueOf(productoSeleccionado.getPesoEnKg()));
        txfNumElementos.setText(String.valueOf(productoSeleccionado.getNumElementos()));
        txfDescripcion.setText(productoSeleccionado.getDescripcion());
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        final String RUTA_VISTA_GESTION_PRODUCTO = "view/gestionProductoView";

        supermercadoController.cambiarVista(RUTA_VISTA_GESTION_PRODUCTO);
    }
}
