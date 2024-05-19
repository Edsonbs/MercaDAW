package es.etg.programacion.mercadaw.trabajador;

public class EmpleadoFactory {
    /**
     * Devuelve un objeto del tipo empleado. Según la categoría se generará un tipo específico u otro.
     * @param nombreEmpleado
     * @param apellidoEmpleado
     * @param categoriaEmpleado
     * @return Empleado
     */
    public static Empleado crearEmpleado(String nombreEmpleado, String apellidoEmpleado, String categoriaEmpleado){
        final String CATEGORIA_REPONEDOR = Trabajador.REPONEDOR.name();
        final String CATEGORIA_CAJERO = Trabajador.CAJERO.name();
        final String CATEGORIA_ENCARGADO = Trabajador.ENCARGADO.name();
        final String CATEGORIA_OTRO = Trabajador.OTRO.name();

        Empleado miEmpleado = null;

        // Comprobaremos que no nos lleguen datos vacíos.
        if (!(nombreEmpleado.isBlank() || apellidoEmpleado.isBlank() || categoriaEmpleado == null)){
            if (CATEGORIA_REPONEDOR == categoriaEmpleado){
                miEmpleado = new Reponedor(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
            }else if (CATEGORIA_CAJERO == categoriaEmpleado){
                miEmpleado = new Cajero(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
            }else if (CATEGORIA_ENCARGADO == categoriaEmpleado){
                miEmpleado = new Encargado(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
            }else if (CATEGORIA_OTRO == categoriaEmpleado){
                miEmpleado = new Empleado(nombreEmpleado, apellidoEmpleado, categoriaEmpleado);
            }
        }

        return miEmpleado;
    }
}
