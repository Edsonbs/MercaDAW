package es.etg.programacion.mercadaw.trabajador;

public class Cajero extends Empleado{

    private final double SALARIO = 1300;

    public Cajero(String nombre, String apellido, String categoria) {
        super(nombre, apellido, categoria);
        
    }

    public double getSALARIO() {
        return SALARIO;
    }
    
}
