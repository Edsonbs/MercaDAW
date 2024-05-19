package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import es.etg.programacion.mercadaw.producto.Producto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VisualizarPrecioVentaProductoController implements Initializable, IViewController {

    @FXML
    private Button btnImprimirInfo;

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
    void imprimirVistaDetalladaPrecio(MouseEvent event) {
        Producto productoSeleccionado = SupermercadoController.getProductoSeleccionado();
        if (productoSeleccionado != null){
            try{
                SupermercadoController.imprimirEtiquetaDetallada(productoSeleccionado);
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
        supermercadoController.cambiarVista(RutaVista.VISTA_GESTION_PRODUCTO.getRuta());
    }

    private String formatearPrecioAString(double numero){
        final String PLANTILLA_PRECIO_EURO = "%s €";

        return PLANTILLA_PRECIO_EURO.formatted(convertirNumeroAString(numero));
    }

    private String convertirNumeroAString(Number numero){
        final String PLANTILLA_FORMATO = "#.##";

        DecimalFormat formatoRepresentacion = new DecimalFormat(PLANTILLA_FORMATO);

        return formatoRepresentacion.format(numero);
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
