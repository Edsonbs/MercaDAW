module es.etg.programacion.mercadaw {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires java.sql;

    opens es.etg.programacion.mercadaw to javafx.fxml;
    opens es.etg.programacion.mercadaw.dao to javafx.fxml;
    opens es.etg.programacion.mercadaw.mercado to javafx.fxml;
    opens es.etg.programacion.mercadaw.producto to javafx.fxml;
    opens es.etg.programacion.mercadaw.trabajador to javafx.fxml;
    opens es.etg.programacion.mercadaw.util to javafx.fxml;
    opens es.etg.programacion.mercadaw.util.writer to javafx.fxml;
    opens es.etg.programacion.mercadaw.view to javafx.fxml;

    exports es.etg.programacion.mercadaw;
    exports es.etg.programacion.mercadaw.dao;
    exports es.etg.programacion.mercadaw.mercado;
    exports es.etg.programacion.mercadaw.producto;
    exports es.etg.programacion.mercadaw.trabajador;
    exports es.etg.programacion.mercadaw.util;
    exports es.etg.programacion.mercadaw.util.writer;
    exports es.etg.programacion.mercadaw.view;
}
