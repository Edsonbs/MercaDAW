package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.EmpleadoFactory;
import es.etg.programacion.mercadaw.trabajador.Trabajador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GestionEmpleadoViewController implements Initializable, IViewController{

    @FXML
    private Button btnBorrarEmpleado1;

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

    private ObservableList<Empleado> empleados;

    final String CATEGORIA_REPONEDOR = Trabajador.REPONEDOR.name();
    final String CATEGORIA_CAJERO = Trabajador.CAJERO.name();
    final String CATEGORIA_ENCARGADO = Trabajador.ENCARGADO.name();
    final String CATEGORIA_OTRO = Trabajador.OTRO.name();
    final String MSG_ALERTA_FALLO_CONEXION = "Algo ha fallado durante la conexión a base de datos.";

    private SupermercadoController supermercadoController = null;

    @Override
    public void setSupermercadoController(SupermercadoController controller) {
        this.supermercadoController = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final String ATRIBUTO_ID = "idUsuario";
        final String ATRIBUTO_NOMBRE = "nombre";
        final String ATRIBUTO_APELLIDO = "apellido";
        final String ATRIBUTO_CATEGORIA = "categoria";

        String[] categoriasEmpleado = {CATEGORIA_REPONEDOR, CATEGORIA_CAJERO, CATEGORIA_ENCARGADO, CATEGORIA_OTRO};
        empleados = FXCollections.observableArrayList();

        // Con la siguiente línea añadimos todas las opciones de la lista "tipoEmpleados".
        seleccionCategoriaEmpleado.getItems().addAll(categoriasEmpleado);

        // Aquí representaremos en cada columna de la tabla cada dato:
        colID.setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_ID));
        colNombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_NOMBRE));
        colApellido.setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_APELLIDO));
        colCategoria.setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_CATEGORIA));

        // Leemos los datos de la base de datos:
        try{
            List<Empleado> empleadosBaseDatos = SupermercadoController.obtenerListaEmpleados();

            empleados.addAll(empleadosBaseDatos);
            tablaEmpleado.setItems(empleados);
        }catch(Exception excepcion){
            mostrarAviso(MSG_ALERTA_FALLO_CONEXION, AlertType.ERROR);
        }
    }

    @FXML
    void borrarEmpleado(MouseEvent event) {
        Empleado empleadoSeleccionado = tablaEmpleado.getFocusModel().getFocusedItem();

        // Comprobamos que se haya seleccionado un empleado.
        if (empleadoSeleccionado != null){
            try{
                SupermercadoController.eliminarEmpleado(empleadoSeleccionado);
                empleados.remove(empleadoSeleccionado);
    
                tablaEmpleado.setItems(empleados);
            }catch(Exception excepcion){
                mostrarAviso(MSG_ALERTA_FALLO_CONEXION, AlertType.ERROR);
            }
        }
    }

    @FXML
    void darAltaEmpleado(MouseEvent event) {
        final String MSG_ALERTA_CAMPOS = "Todos los campos deben estar rellenados.";
        final String MSG_ALERTA_DUPLICADO = "Este empleado ya existe.";

        // Con la siguiente línea obtendremos los datos introducidos por el usuario:
        String nombreEmpleado = txfNombre.getText();
        String apellidoEmpleado = txfApellido.getText();
        String categoriaEmpleado = seleccionCategoriaEmpleado.getSelectionModel().getSelectedItem();

        // Aquí tendremos una lista con los trabajadores creados por el usuario:
        Empleado unEmpleado = EmpleadoFactory.crearEmpleado(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);

        // Comprobamos que se ha creado un empleado correctamente.
        if (unEmpleado != null){
            // Comprobamos que no sea un empleado duplicado.
            if (empleados.contains(unEmpleado)){
                mostrarAviso(MSG_ALERTA_DUPLICADO, AlertType.ERROR);
            }else{
                try{
                    SupermercadoController.anadirEmpleado(unEmpleado);
                    empleados.add(unEmpleado);

                    tablaEmpleado.setItems(empleados);
                }catch(Exception excepcion){
                    mostrarAviso(MSG_ALERTA_FALLO_CONEXION, AlertType.ERROR);
                }
            }
        }else{
            mostrarAviso(MSG_ALERTA_CAMPOS, AlertType.ERROR);
        }
    }

    @FXML
    void generarNomina(MouseEvent event) {
        // Con estas líneas obtendré el objeto que haya seleccionado el usuario con el click en la tabla:
        Empleado seleccionado = tablaEmpleado.getFocusModel().getFocusedItem();
        if (seleccionado != null){
            // Siempre que el usuario haya seleccionado algo, se realizará la función indicada.
        }
    }

    @FXML
    void volverVistaAnterior(MouseEvent event) throws IOException {
        supermercadoController.cambiarVista(RutaVista.VISTA_INICIO.getRuta());
    }

    private void mostrarAviso(String msg, AlertType tipo){
        final String TITULO = "Importante";

        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(TITULO);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
