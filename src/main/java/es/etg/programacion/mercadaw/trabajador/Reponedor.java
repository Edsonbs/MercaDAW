package es.etg.programacion.mercadaw.trabajador;

public class Reponedor extends Empleado{
    public Reponedor(String nombre, String apellido, String categoria) {
        super(nombre, apellido, categoria);

        this.salario = Trabajador.REPONEDOR.getSalario();
    }
}
