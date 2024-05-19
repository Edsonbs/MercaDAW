package es.etg.programacion.mercadaw.view;

import java.io.File;
import java.io.IOException;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class InicioViewController implements IViewController {

    @FXML
    private Button btnCalcularNominaTrabajador;

    @FXML
    private Button btnGestionarEmpleados;

    @FXML
    private Button btnGestionarProductos;

    private SupermercadoController supermercadoController = null;

    @Override
    public void setSupermercadoController(SupermercadoController controller) {
        this.supermercadoController = controller;
    }

    @FXML
    void abrirVistaGestionEmpleados(MouseEvent event) throws IOException {
        supermercadoController.cambiarVista(RutaVista.VISTA_GESTION_EMPLEADO.getRuta());
    }

    @FXML
    void abrirVistaGestionProductos(MouseEvent event) throws IOException {
        supermercadoController.cambiarVista(RutaVista.VISTA_GESTION_PRODUCTO.getRuta());
    }

    @FXML
    void importarDatos(MouseEvent event) {
        // Abrimos una ventana para seleccionar un fichero:
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        if (file != null){
            file.getName(); // Esta línea es sólo para que no salga en warning este método.
        }
        event.consume();
    }

}
