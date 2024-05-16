module es.etg.programacion.mercadaw {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.etg.programacion.mercadaw to javafx.fxml;
    exports es.etg.programacion.mercadaw;
}
