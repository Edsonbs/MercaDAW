package es.etg.programacion.mercadaw.view;

import es.etg.programacion.mercadaw.controller.SupermercadoController;

public interface IViewController {
    /**
     * Método para asignar un controlador en un ViewController.
     * @param controller
     */
    public void setSupermercadoController(SupermercadoController controller);
}