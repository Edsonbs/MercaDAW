module es.etg.mercadaw {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens es.etg.mercadaw to javafx.fxml;
    exports es.etg.mercadaw;
}
