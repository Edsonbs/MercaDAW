package es.etg.programacion.mercadaw.producto;
import es.etg.programacion.mercadaw.util.Documento;

public abstract class Producto implements Documento {

    private String nombre;
    private String marca;
    private double precioEnEuros;
    private double alturaEnMetros;
    private double anchuraEnMetros;
    private double pesoEnKg;
    private int numElementos;
    private String descripcion;
    private Categoria iva;
    private String categoria;

    public Producto(String nombre, String marca, double precioEnEuros, double alturaEnMetros, double anchuraEnMetros,
            double pesoEnKg, int numElementos, String descripcion, Categoria iva, String categoria) {
        this.nombre = nombre;
        this.marca = marca;
        this.precioEnEuros = precioEnEuros;
        this.alturaEnMetros = alturaEnMetros;
        this.anchuraEnMetros = anchuraEnMetros;
        this.pesoEnKg = pesoEnKg;
        this.numElementos = numElementos;
        this.descripcion = descripcion;
        this.iva = iva;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioEnEuros() {
        return precioEnEuros;
    }

    public void setPrecioEnEuros(double precioEnEuros) {
        this.precioEnEuros = precioEnEuros;
    }

    public double getAlturaEnMetros() {
        return alturaEnMetros;
    }

    public void setAlturaEnMetros(double alturaEnMetros) {
        this.alturaEnMetros = alturaEnMetros;
    }

    public double getAnchuraEnMetros() {
        return anchuraEnMetros;
    }

    public void setAnchuraEnMetros(double anchuraEnMetros) {
        this.anchuraEnMetros = anchuraEnMetros;
    }

    public double getPesoEnKg() {
        return pesoEnKg;
    }

    public void setPesoEnKg(double pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getIva() {
        return iva;
    }

    public void setIva(Categoria iva) {
        this.iva = iva;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
