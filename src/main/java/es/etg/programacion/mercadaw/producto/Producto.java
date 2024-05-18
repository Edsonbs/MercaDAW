package es.etg.programacion.mercadaw.producto;
import java.util.LinkedHashMap;

import es.etg.programacion.mercadaw.util.Documento;

public abstract class Producto implements Documento, IProducto {
    private static int numInstancias = 1;
    private int id;
    private String nombre;
    private String marca;
    private double precioEnEuros;
    private double alturaEnMetros;
    private double anchuraEnMetros;
    private double pesoEnKg;
    private int numElementos;
    private String descripcion;
    protected double iva;
    private String categoria;

    public Producto(String nombre, String marca,String categoria, double precioEnEuros, double alturaEnMetros, double anchuraEnMetros,
            double pesoEnKg, int numElementos, String descripcion) {
        this.id = numInstancias;
        this.nombre = nombre;
        this.marca = marca;
        this.precioEnEuros = precioEnEuros;
        this.alturaEnMetros = alturaEnMetros;
        this.anchuraEnMetros = anchuraEnMetros;
        this.pesoEnKg = pesoEnKg;
        this.numElementos = numElementos;
        this.descripcion = descripcion;
        this.categoria = categoria;
        numInstancias++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public LinkedHashMap<String, String> getContenido(){
       LinkedHashMap productos = new LinkedHashMap<>();
       productos.put(nombre, getNombre());
       productos.put(marca, getMarca());
       productos.put(precioEnEuros, getPrecioEnEuros());
       productos.put(alturaEnMetros, getAlturaEnMetros());
       productos.put(anchuraEnMetros, getAnchuraEnMetros());
       productos.put(pesoEnKg, getPesoEnKg());
       productos.put(numElementos, getNumElementos());
       productos.put(descripcion, getDescripcion());
       productos.put(iva, getIva());
       productos.put(categoria, getCategoria());
       return productos;
    }

    @Override
    public String getTitulo(){
        final String DATOSPROD = "DATOS DEL PRODUCTO";
        return DATOSPROD;
    }

    @Override
    public String getPie(){
        return "";
    }
}
