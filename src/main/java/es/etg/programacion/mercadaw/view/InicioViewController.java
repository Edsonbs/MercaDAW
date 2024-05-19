package es.etg.programacion.mercadaw.view;

import java.io.IOException;

import es.etg.programacion.mercadaw.controller.SupermercadoController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class InicioViewController implements IViewController {

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
}
