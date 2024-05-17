package es.etg.programacion.mercadaw.trabajador;

public enum Trabajador {
    REPONEDOR(1200),
    CAJERO(1300),
    ENCARGADO(1500),
    STANDARD(1000);

    private double salario;

    Trabajador(double salario) {
        this.salario= salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
