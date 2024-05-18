package es.etg.programacion.mercadaw.producto;
import java.util.LinkedHashMap;

import es.etg.programacion.mercadaw.util.Documento;

public abstract class Producto implements Documento, IProducto {
    public final static double PORCENTAJE_5 = 0.05;
    public final static double PORCENTAJE_10 = 0.10;
    public final static double AUMENTO_VENTA = 0.25;
    public final static double DOLAR = 1.11;
    public final static double MAX_ALTURA_ANCHURA = 0.5;
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
    private double precioVenta;

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
        this.precioVenta = calcularPrecioVenta();
        numInstancias++;
    }

    @Override
    public double calcularPrecioTotal(){
        return getPrecioVenta() + calcularPrecioAltura()+ calcularPrecioAnchura()+calcularPrecioPeso();

    }
    @Override
    public double calcularPrecioDolar() {
        return calcularPrecioTotal() * DOLAR;
    }
    @Override
    public double calcularPrecioVenta() {
        double prec = getPrecioEnEuros();
        prec = prec + (prec * AUMENTO_VENTA);
        return prec;
    }
    public double calcularPrecioNumElementos(){
        final int MAX_ELEMENTOS = 2;
        final double SUPLEMENTO = 0.1;
        double prec = getPrecioVenta();
        if (numElementos > MAX_ELEMENTOS) {
            prec = prec * (SUPLEMENTO * numElementos);
            return prec;
        }
        return 0;
        
    }

    public double calcularPrecioAltura(){
        double prec = getPrecioVenta();
            if (alturaEnMetros < MAX_ALTURA_ANCHURA) {
                prec = prec * PORCENTAJE_5;
            }else{
                prec = prec * PORCENTAJE_10;
            }
        return prec;
    }

    public double calcularPrecioAnchura() {
        double prec = getPrecioVenta();
            if (anchuraEnMetros < MAX_ALTURA_ANCHURA) {
                prec = prec * PORCENTAJE_5;
            }else{
                prec = prec * PORCENTAJE_10;
            }
        return prec;
    }

    public double calcularPrecioPeso() {
        final double PORCENTAJE_15 = 0.15;
        final double MAX_PESO = 5;
        final double MIN_PESO = 1;
        double prec = getPrecioVenta();
        if (pesoEnKg < MIN_PESO) {
            prec = prec * PORCENTAJE_5;
        }else if (pesoEnKg > MIN_PESO && pesoEnKg < MAX_PESO) {
            prec = prec * PORCENTAJE_10;
        }else if (pesoEnKg > MAX_PESO) {
            prec = prec * PORCENTAJE_15;
        }
        return prec;
    }
    @Override
    public String toString() {
        return "Nombre: "+getNombre()+" Descripcion: "+getDescripcion()+" Marca: "+getMarca()+" Categoria: "+getCategoria();
    }
    @Override
    public LinkedHashMap<String, String> getContenido(){
       LinkedHashMap<String, String> productos = new LinkedHashMap<>();
       productos.put("Producto", getNombre());
       productos.put("Marca", getMarca());
       productos.put("Precio", getPrecioEnEuros()+"€");
       productos.put("Altura", getAlturaEnMetros()+" m");
       productos.put("Anchura", getAnchuraEnMetros()+" m");
       productos.put("Peso", getPesoEnKg()+" kg");
       productos.put("Elementos", getNumElementos()+"");
       productos.put("Descripcion", getDescripcion());
       productos.put("IVA", getIva()+"");
       productos.put("Categoria", getCategoria());
       productos.put("Precio de venta", getPrecioVenta()+"");
       productos.put("Recargo por peso", calcularPrecioPeso()+"");
       productos.put("Recargo por altura", calcularPrecioAltura()+"");
       productos.put("Recargo por anchura", calcularPrecioAnchura()+"");
       productos.put("Recargo por número de piezas ("+getNumElementos()+")", calcularPrecioNumElementos()+"");
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

    public static double getPorcentaje5() {
        return PORCENTAJE_5;
    }

    public static double getPorcentaje10() {
        return PORCENTAJE_10;
    }

    public static double getAumentoVenta() {
        return AUMENTO_VENTA;
    }

    public static double getDolar() {
        return DOLAR;
    }

    public static double getMaxAlturaAnchura() {
        return MAX_ALTURA_ANCHURA;
    }

    public static int getNumInstancias() {
        return numInstancias;
    }

    public static void setNumInstancias(int numInstancias) {
        Producto.numInstancias = numInstancias;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
}
