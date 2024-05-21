package es.etg.programacion.mercadaw.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import es.etg.programacion.mercadaw.trabajador.Empleado;
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

    private SupermercadoController supermercadoController = null;

    @Override
    public void setSupermercadoController(SupermercadoController controller) {
        this.supermercadoController = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final String ATRIBUTO_ID        = "idUsuario";
        final String ATRIBUTO_NOMBRE    = "nombre"   ;
        final String ATRIBUTO_APELLIDO  = "apellido" ;
        final String ATRIBUTO_CATEGORIA = "categoria";

        String[] categoriasEmpleado = {CATEGORIA_REPONEDOR, CATEGORIA_CAJERO, CATEGORIA_ENCARGADO, CATEGORIA_OTRO};
        empleados = FXCollections.observableArrayList();

        // Con la siguiente línea añadimos todas las opciones de la categoría.
        seleccionCategoriaEmpleado.getItems().addAll(categoriasEmpleado);

        // Aquí representaremos en cada columna de la tabla cada dato:
        colID       .setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_ID       ));
        colNombre   .setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_NOMBRE   ));
        colApellido .setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_APELLIDO ));
        colCategoria.setCellValueFactory(new PropertyValueFactory<Empleado, String>(ATRIBUTO_CATEGORIA));

        try{
            empleados.setAll(SupermercadoController.obtenerEmpleados());
            tablaEmpleado.setItems(empleados);
        }catch(Exception excepcion){
            mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_CONEXION.getMensaje(), AlertType.ERROR);
        }
    }

    /**
     * Clase que borra un empleado de la base de datos.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     */
    @FXML
    void borrarEmpleado(MouseEvent event) {
        final String MSG_OPERACION_EXITOSA = "Se ha eliminado el empleado %s %s exitosamente.";

        Empleado empleadoSeleccionado = tablaEmpleado.getFocusModel().getFocusedItem();

        if (empleadoSeleccionado != null){
            try{
                SupermercadoController.darBajaEmpleado(empleadoSeleccionado);

                empleados.setAll(SupermercadoController.obtenerEmpleados());
                tablaEmpleado.setItems(empleados);
                mostrarAviso(MSG_OPERACION_EXITOSA.formatted(empleadoSeleccionado.getNombre(), empleadoSeleccionado.getApellido()), AlertType.INFORMATION);
            }catch(Exception excepcion){
                mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_CONEXION.getMensaje(), AlertType.ERROR);
            }
        }
    }

    /**
     * Clase que da de alta un empleado en la base de datos.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     */
    @FXML
    void darAltaEmpleado(MouseEvent event) {
        final String MSG_OPERACION_EXITOSA = "Se ha creado el empleado %s %s correctamente.";
        String nombreEmpleado = txfNombre.getText();
        String apellidoEmpleado = txfApellido.getText();
        String categoriaEmpleado = seleccionCategoriaEmpleado.getSelectionModel().getSelectedItem();
        Empleado unEmpleado = SupermercadoController.crearEmpleado(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);

        if (unEmpleado != null){
            // Comprobamos que no sea un empleado duplicado.
            if (empleados.contains(unEmpleado)){
                mostrarAviso(MensajeAlerta.MSG_ALERTA_DUPLICADO.getMensaje(), AlertType.ERROR);
            }else{
                try{
                    SupermercadoController.darAltaEmpleado(unEmpleado);
                    empleados.setAll(SupermercadoController.obtenerEmpleados());
                    tablaEmpleado.setItems(empleados);
                    mostrarAviso(MSG_OPERACION_EXITOSA.formatted(unEmpleado.getNombre(), unEmpleado.getApellido()), AlertType.INFORMATION);
                }catch(Exception excepcion){
                    mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_CONEXION.getMensaje(), AlertType.ERROR);
                }
            }
        }else{
            mostrarAviso(MensajeAlerta.MSG_ALERTA_CAMPOS_EMPLEADO.getMensaje(), AlertType.ERROR);
        }
    }

    /**
     * Este método se encarga de crear un fichero.md, y empleándolo genera un fichero.pdf.
     * Este método se ejecuta cuando el usuario pulsa el botón destinado a ello.
     * @param event
     */
    @FXML
    void generarNomina(MouseEvent event) {
        Empleado empleadoSeleccionado = tablaEmpleado.getFocusModel().getFocusedItem();

        if (empleadoSeleccionado != null){
            try{
                SupermercadoController.generarNomina(empleadoSeleccionado);
                mostrarAviso(MensajeAlerta.MSG_ALERTA_EXITOSO.getMensaje(), AlertType.INFORMATION);
            }catch(IOException excepcion){
                mostrarAviso(MensajeAlerta.MSG_ALERTA_FALLO_NOMINA.getMensaje(), AlertType.ERROR);
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
        supermercadoController.cambiarVista(RutaVista.VISTA_INICIO.getRuta());
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
