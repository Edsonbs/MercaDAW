package es.etg.programacion.mercadaw;

import javafx.application.Application;

import es.etg.programacion.mercadaw.controller.SupermercadoController;

/**
 * JavaFX App
 */
public class App {
    public static void main(String[] args) {
        // Controlador:
        SupermercadoController controller = new SupermercadoController();

        Application.launch(SupermercadoController.class, args);
    }

}