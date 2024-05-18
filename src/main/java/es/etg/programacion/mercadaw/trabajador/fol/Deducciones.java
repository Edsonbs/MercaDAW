package es.etg.programacion.mercadaw.trabajador.fol;

public enum Deducciones {
    IRPF(14),BCCC(4.7),MEI(0.12),DESEMPLEO(1.55),FOGASA(0.10);
    private double porcentaje;
    private Deducciones(double porcentaje){
        this.porcentaje = porcentaje;
    }
    public double getPorcentaje(){
        return porcentaje;
    }
}
