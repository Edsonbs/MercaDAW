package es.etg.programacion.mercadaw.producto;

public class ProductoFactory {
    public static Producto crearProducto(String nombreProducto, String marcaProducto, String categoriaProducto, double precioEurosProducto, double alturaMetrosProducto, double anchuraMetrosProducto, double pesoKgProducto, int cantidadElementosProducto, String descripcionProducto){
        final String CATEGORIA_ALIMENTACION = Categoria.ALIMENTACION.name();
        final String CATEGORIA_DROGUERIA = Categoria.DROGUERIA.name();
        final String CATEGORIA_COSMETICA = Categoria.COSMETICA.name();

        // Comprobaremos que no hayan strings vacíos. Los numéricos lanzarán una excepción, por eso no los manejo.
        Producto miProducto = null;
        if (!(nombreProducto.isBlank() || marcaProducto.isBlank() || categoriaProducto == null)){
            if (CATEGORIA_ALIMENTACION == categoriaProducto){
                miProducto = new Alimentacion(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);
            } else if (CATEGORIA_DROGUERIA == categoriaProducto){
                miProducto = new Drogueria(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);
            } else if (CATEGORIA_COSMETICA == categoriaProducto){
                miProducto = new Cosmetica(nombreProducto, marcaProducto, categoriaProducto, precioEurosProducto, alturaMetrosProducto, anchuraMetrosProducto, pesoKgProducto, cantidadElementosProducto, descripcionProducto);
            }
        }
        return miProducto;
    }
}
