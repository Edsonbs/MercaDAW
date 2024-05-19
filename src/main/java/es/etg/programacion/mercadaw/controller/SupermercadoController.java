package es.etg.programacion.mercadaw.controller;

import java.io.IOException;

import es.etg.programacion.mercadaw.App;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.view.IViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SupermercadoController extends Application{
    private final String VISTA_INICIAL = "view/inicioView";

    private Stage stagePrincipal;
    //private static Scene scene;
    private static Producto productoSeleccionado; // Producto para que se pueda mostrar infor detallada.

    public static Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public static void setProductoSeleccionado(Producto productoSeleccionado) {
        SupermercadoController.productoSeleccionado = productoSeleccionado;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stagePrincipal = stage;
        stage.setScene(cargarVista(VISTA_INICIAL));
        stage.show();
    }

    private Scene cargarVista(String fxml) throws IOException {
        final String EXTENSION_FXML = ".fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + EXTENSION_FXML));
        Parent root = (Parent) fxmlLoader.load();

        //Obtengo el controlador de la vista para pasarle una referencia al controlador - MVC:
        IViewController viewController = fxmlLoader.<IViewController>getController();
        viewController.setSupermercadoController(this);
        Scene scene = new Scene(root);

        return scene;
    }

    public void cambiarVista(String fxml) throws IOException {
        Scene nuevaEscena = cargarVista(fxml);
        stagePrincipal.setScene(nuevaEscena);
    }
}