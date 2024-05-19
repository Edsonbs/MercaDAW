package es.etg.programacion.mercadaw.trabajador;

public enum Trabajador {
    REPONEDOR(1200),
    CAJERO(1300),
    ENCARGADO(1500),
    OTRO(1000);

    private double salario;

    private Trabajador(double salario) {
        this.salario= salario;
    }

    public double getSalario() {
        return salario;
    }

}
