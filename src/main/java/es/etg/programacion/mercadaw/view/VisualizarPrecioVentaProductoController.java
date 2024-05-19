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
        final String PLANTILLA_PRECIO_DOLAR = "%s $";
        final String PLANTILLA_SEPARADOR = "%s / %s";

        Producto productoSeleccionado = SupermercadoController.getProductoSeleccionado();

        txfNombre          .setDisable (true);
        txfMarca           .setDisable (true);
        txfPrecio          .setDisable (true);
        txfPrecioVenta     .setDisable (true);
        txfRecargoPeso     .setDisable (true);
        txfRecargoAltura   .setDisable (true);
        txfRecargoAnchura  .setDisable (true);
        txfRecargoNumPiezas.setDisable (true);
        txfPrecioTotal     .setDisable (true);
        txfIva             .setDisable (true);
        txfAlturaMetros    .setDisable (true);
        txfAnchuraMetros   .setDisable (true);
        txfPesoKg          .setDisable (true);
        txfNumElementos    .setDisable (true);
        txfDescripcion     .setDisable (true);
        txfDescripcion     .setWrapText(true);

        txfNombre          .setText(                       productoSeleccionado.getNombre                 ( ));
        txfMarca           .setText(                       productoSeleccionado.getMarca                  ( ));
        txfPrecio          .setText(formatearPrecioAString(productoSeleccionado.getPrecioEnEuros          ()));
        txfPrecioVenta     .setText(formatearPrecioAString(productoSeleccionado.getPrecioVenta            ()));
        txfRecargoPeso     .setText(formatearPrecioAString(productoSeleccionado.calcularPrecioPeso        ()));
        txfRecargoAltura   .setText(formatearPrecioAString(productoSeleccionado.calcularPrecioAltura      ()));
        txfRecargoAnchura  .setText(formatearPrecioAString(productoSeleccionado.calcularPrecioAnchura     ()));
        txfRecargoNumPiezas.setText(formatearPrecioAString(productoSeleccionado.calcularPrecioNumElementos()));
        txfIva             .setText(convertirNumeroAString(productoSeleccionado.getIva                    ()));
        txfAlturaMetros    .setText(convertirNumeroAString(productoSeleccionado.getAlturaEnMetros         ()));
        txfAnchuraMetros   .setText(convertirNumeroAString(productoSeleccionado.getAnchuraEnMetros        ()));
        txfPesoKg          .setText(convertirNumeroAString(productoSeleccionado.getPesoEnKg               ()));
        txfNumElementos    .setText(convertirNumeroAString(productoSeleccionado.getNumElementos           ()));
        txfDescripcion     .setText(                       productoSeleccionado.getDescripcion            ( ));

        txfPrecioTotal.setText(PLANTILLA_SEPARADOR.formatted(formatearPrecioAString(productoSeleccionado.calcularPrecioTotal()),
                            PLANTILLA_PRECIO_DOLAR.formatted(convertirNumeroAString(productoSeleccionado.calcularPrecioDolar()))));
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        final String RUTA_VISTA_GESTION_PRODUCTO = "view/gestionProductoView";

        supermercadoController.cambiarVista(RUTA_VISTA_GESTION_PRODUCTO);
    }

    private String formatearPrecioAString(double numero){
        final String PLANTILLA_PRECIO_EURO = "%s €";

        return PLANTILLA_PRECIO_EURO.formatted(convertirNumeroAString(numero));
    }

    private String convertirNumeroAString(Number numero){
        return String.valueOf(numero);
    }
}
