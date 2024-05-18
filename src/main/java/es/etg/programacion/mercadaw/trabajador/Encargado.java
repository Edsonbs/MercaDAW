package es.etg.programacion.mercadaw.trabajador;

    public class Encargado extends Empleado{

    private final double SALARIO = 1500;

    public Encargado(int idUsuario, String nombre, String apellido, String categoria) {
        super(nombre, apellido, categoria);
        
    }

    public double getSALARIO() {
        return SALARIO;
    }
    
}
