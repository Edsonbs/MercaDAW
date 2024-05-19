package es.etg.programacion.mercadaw.producto;

public class Alimentacion extends Producto{
    public Alimentacion(String nombre, String marca, String categoria, double precioEnEuros, double alturaEnMetros,
            double anchuraEnMetros, double pesoEnKg, int numElementos, String descripcion) {
        super(nombre, marca, categoria, precioEnEuros, alturaEnMetros, anchuraEnMetros, pesoEnKg, numElementos, descripcion);
        this.iva = Categoria.ALIMENTACION.getIva();
       
    }
}
