package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.App;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GestionEmpleadoViewController implements Initializable{

    @FXML
    private Button btnDarAltaEmpleado;

    @FXML
    private Button btnGenerarNomina;

    @FXML
    private TableColumn<Empleado, String> colApellido;

    @FXML
    private TableColumn<Empleado, String> colCategoria;

    @FXML
    private TableColumn<Empleado, String> colID;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private ImageView imgVolver;

    @FXML
    private ChoiceBox<String> seleccionCategoriaEmpleado;

    @FXML
    private TableView<Empleado> tablaEmpleado;

    @FXML
    private TextField txfApellido;

    @FXML
    private TextField txfNombre;

    // Métodos:
    private String[] tipoEmpleados = {"Reponedor", "Cajero", "Encargado", "Otro"};
    private ObservableList<Empleado> empleados;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Con este método, al iniciar la ventana, se harán las siguientes cosas:

        // Con estas dos líneas, primero deshabilito el campo de texto, y luego le doy un valor.
        txfApellido.setDisable(true);
        txfApellido.setText("Impuesto :)");

        // Con la siguiente línea añadimos todas las opciones de la lista "tipoEmpleados".
        seleccionCategoriaEmpleado.getItems().addAll(tipoEmpleados);
    }

    @FXML
    void darAltaEmpleado(MouseEvent event) {
        // Con la siguiente línea obtendremos los datos introducidos por el usuario:
        int idEmpleado = 1234; // Esta línea la tendré que borrar, yo no tendría que pasar el id.
        String nombreEmpleado = txfNombre.getText();
        String apellidoEmpleado = txfApellido.getText();
        String categoriaEmpleado = seleccionCategoriaEmpleado.getSelectionModel().getSelectedItem();

        // Aquí tendremos una lista con los trabajadores creados por el usuario:
        empleados = FXCollections.observableArrayList(new Empleado(idEmpleado, nombreEmpleado, apellidoEmpleado, categoriaEmpleado));

        // Aquí representaremos en cada columna de la tabla cada dato:
        colID.setCellValueFactory(new PropertyValueFactory<Empleado, String>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellido"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<Empleado, String>("categoria"));

        // Con la siguiente línea añadiremos a la tabla los nuevos trabajadores:
        tablaEmpleado.getItems().addAll(empleados);
    }

    @FXML
    void generarNomina(MouseEvent event) {
        // Con estas líneas obtendré el objeto que haya seleccionado el usuario con el click en la tabla:
        Empleado seleccionado = tablaEmpleado.getFocusModel().getFocusedItem();
        if (seleccionado != null){
            // Siempre que el usuario haya seleccionado algo, se realizará la función indicada.
            //System.out.println(seleccionado.getNombre());
        }
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        App.setRoot("view/inicioView");
    }
}
