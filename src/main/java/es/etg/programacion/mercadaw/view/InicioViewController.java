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

public class InicioViewController {

    @FXML
    private Button btnCalcularNominaTrabajador;

    @FXML
    private Button btnGestionarEmpleados;

    @FXML
    private Button btnGestionarProductos;

    @FXML
    void abrirVistaGestionEmpleados(MouseEvent event) throws IOException {
        final String RUTA_VISTA_GESTION_EMPLEADOS = "view/gestionEmpleadoView";

        SupermercadoController.setRoot(RUTA_VISTA_GESTION_EMPLEADOS);
    }

    @FXML
    void abrirVistaGestionProductos(MouseEvent event) throws IOException {
        final String RUTA_VISTA_GESTION_PRODUCTOS = "view/gestionProductoView";

        SupermercadoController.setRoot(RUTA_VISTA_GESTION_PRODUCTOS);
    }

    @FXML
    void importarDatos(MouseEvent event) {
        // Abrimos una ventana para seleccionar un fichero:
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        file.getName(); // Esta línea es sólo para que no salga en warning este método.
        event.consume();
    }

}
