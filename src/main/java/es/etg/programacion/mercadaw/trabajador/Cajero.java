package es.etg.programacion.mercadaw.trabajador;

public class Cajero extends Empleado{
    public Cajero(String nombre, String apellido, String categoria) {
        super(nombre, apellido, categoria);

        this.salario = Trabajador.CAJERO.getSalario();
    }
}
