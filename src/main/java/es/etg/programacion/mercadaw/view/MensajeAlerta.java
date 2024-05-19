package es.etg.programacion.mercadaw.view;

public enum MensajeAlerta {
    MSG_ALERTA_FALLO_CONEXION("Algo ha fallado durante la conexión a base de datos."),
    MSG_ALERTA_FALLO_NOMINA("Algo ha fallado durante la creación de la nómina."),
    MSG_ALERTA_FALLO_ETIQUETA("Algo ha fallado durante la creación de la etiqueta."),
    MSG_ALERTA_CAMPOS_EMPLEADO("Todos los campos deben estar rellenados."),
    MSG_ALERTA_CAMPOS_PRODUCTO("Todos los campos deben estar rellenados (exepto descripción)."),
    MSG_ALERTA_DUPLICADO("Este elemento ya existe."),
    MSG_ALERTA_TIPO_DATO("Hay bloques numéricos en los que has introducido no numéricos. Recuerda que los decimales son con '.' y no con ','."),
    MSG_ALERTA_EXITOSO("Procesado exitosamente.");

    private String mensaje;

    private MensajeAlerta(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
