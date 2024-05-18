package es.etg.programacion.mercadaw.producto;

public class Drogueria extends Producto{

    public Drogueria(String nombre, String marca, double precioEnEuros, double alturaEnMetros, double anchuraEnMetros,
            double pesoEnKg, int numElementos, String descripcion, Categoria iva, String categoria) {
        super(nombre, marca, precioEnEuros, alturaEnMetros, anchuraEnMetros, pesoEnKg, numElementos, descripcion, iva,
                categoria);
    }
    
}
