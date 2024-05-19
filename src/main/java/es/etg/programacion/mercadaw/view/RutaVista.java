package es.etg.programacion.mercadaw.view;

public enum RutaVista {
    VISTA_INICIO("view/inicioView"),
    VISTA_GESTION_EMPLEADO("view/gestionEmpleadoView"),
    VISTA_GESTION_PRODUCTO("view/gestionProductoView"),
    VISTA_VISUALIZACION_PRECIO_PRODUCTO("view/visualizarPrecioVentaProducto");

    private String ruta;

    private RutaVista(String ruta){
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }
}
