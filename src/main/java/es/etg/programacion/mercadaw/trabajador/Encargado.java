package es.etg.programacion.mercadaw.trabajador;

    public class Encargado extends Empleado{

    public Encargado(String nombre, String apellido, String categoria) {
        super(nombre, apellido, categoria);

        this.salario = Trabajador.ENCARGADO.getSalario();
    }
}
