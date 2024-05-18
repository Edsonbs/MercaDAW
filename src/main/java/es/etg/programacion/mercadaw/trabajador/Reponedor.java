package es.etg.programacion.mercadaw.trabajador;

public class Reponedor extends Empleado{

    final private double SALARIO = 1200;
    
    public Reponedor(int idUsuario, String nombre, String apellido, String categoria) {
        super(idUsuario, nombre, apellido, categoria);
        

    }

    public double getSALARIO() {
        return SALARIO;
    }
    
}
