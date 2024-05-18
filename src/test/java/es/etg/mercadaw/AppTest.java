package es.etg.mercadaw;

import org.junit.jupiter.api.Test;

import es.etg.programacion.mercadaw.App;
import es.etg.programacion.mercadaw.producto.Alimentacion;
import es.etg.programacion.mercadaw.producto.Drogueria;
import es.etg.programacion.mercadaw.producto.Producto;

public class AppTest 
{
   @Test
   public void pruebaid(){
    Producto a = new Alimentacion(null, null, null, 0, 0, 0, 0, 0, null);
    Producto b = new Drogueria(null, null, null, 0, 0, 0, 0, 0, null);
    Producto c = new Alimentacion(null, null, null, 0, 0, 0, 0, 0, null);
   }
   
   
}