package es.etg.programacion.mercadaw.producto;

import java.util.LinkedHashMap;

public class Cosmetica extends Producto{

    public Cosmetica(String nombre, String marca, double precioEnEuros, double alturaEnMetros, double anchuraEnMetros,
            double pesoEnKg, int numElementos, String descripcion, Categoria iva, String categoria) {
        super(nombre, marca, precioEnEuros, alturaEnMetros, anchuraEnMetros, pesoEnKg, numElementos, descripcion, iva,
                categoria);
        //TODO Auto-generated constructor stub
    }

    @Override
    public LinkedHashMap<String, String> getContenido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContenido'");
    }

    @Override
    public String getTitulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitulo'");
    }

    @Override
    public String getPie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPie'");
    }
    
}