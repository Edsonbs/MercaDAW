package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VisualizarPrecioVentaProductoController implements Initializable {

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

    // Métodos:

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txfNombre.setDisable(true);
        txfMarca.setDisable(true);
        txfPrecio.setDisable(true);
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
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        final String RUTA_VISTA_GESTION_PRODUCTO = "view/gestionProductoView";

        App.setRoot(RUTA_VISTA_GESTION_PRODUCTO);
    }
}
