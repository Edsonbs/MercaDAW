package es.etg.programacion.mercadaw.view;

import java.io.File;
import java.io.IOException;

import es.etg.programacion.mercadaw.App;
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
        App.setRoot("view/gestionEmpleadoView");
    }

    @FXML
    void abrirVistaGestionProductos(MouseEvent event) throws IOException {
        App.setRoot("view/gestionProductoView");
    }

    @FXML
    void importarDatos(MouseEvent event) {
        // Esto abrirá una ventana para seleccionar un fichero:
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
    }

}
