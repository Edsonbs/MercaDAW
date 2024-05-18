package es.etg.programacion.mercadaw.producto;

public class Cosmetica extends Producto{

    public Cosmetica(String nombre, String marca, String categoria, double precioEnEuros, double alturaEnMetros,
            double anchuraEnMetros, double pesoEnKg, int numElementos, String descripcion) {
        super(nombre, marca, categoria, precioEnEuros, alturaEnMetros, anchuraEnMetros, pesoEnKg, numElementos, descripcion);
        this.iva = Categoria.COSMETICA.getIva();
    }


}