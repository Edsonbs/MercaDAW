package es.etg.programacion.mercadaw.util;

import java.util.Map;

public interface Documento {
    /**
     * un mapa con Clave y un Valor de la clase que lo implemente Ejemplo hashmap.put("Nombre",getNombre)
     * @return 
     */
    public Map<String,String> getContenido();
    public String getTitulo();
    public String getPie();
}
