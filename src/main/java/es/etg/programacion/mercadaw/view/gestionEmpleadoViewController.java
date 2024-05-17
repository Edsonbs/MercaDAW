package es.etg.programacion.mercadaw.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class gestionEmpleadoViewController {

    @FXML
    private Button btnDarAltaEmpleado;

    @FXML
    private Button btnGenerarNomina;

    @FXML
    private TableColumn<?, ?> colApellido;

    @FXML
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private ImageView imgVolver;

    @FXML
    private ChoiceBox<?> seleccionCategoriaTrabajador;

    @FXML
    private TableView<?> tablaEmpleado;

    @FXML
    private TextField txfApellido;

    @FXML
    private TextField txfNombre;

    @FXML
    void darAltaEmpleado(MouseEvent event) {

    }

    @FXML
    void generarNomina(MouseEvent event) {

    }

    @FXML
    void volverVistaAnterior(MouseEvent event) {

    }

}
