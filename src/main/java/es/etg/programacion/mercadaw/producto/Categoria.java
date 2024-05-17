package es.etg.programacion.mercadaw.producto;

public enum Categoria {
    ALIMENTACION(0.04),
    DROGUERIA(0.10),
    COSMETICA(0.21);

    private double iva;

    private Categoria(double iva) {
        this.iva = iva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
}
