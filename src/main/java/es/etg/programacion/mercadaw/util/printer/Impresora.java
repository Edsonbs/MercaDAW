package es.etg.programacion.mercadaw.util.printer;

import java.io.IOException;

public class Impresora {
    /*
     * Tienes que dar un String con el nombre que tendrá el fichero pdf imprimido, (Solo imprime pdfs)
     */
    public String imprimir(String nombreImprimido) throws IOException, InterruptedException{
        Process process = Runtime.getRuntime().exec("bash exportar.sh "+nombreImprimido);
        int exitVal = process.waitFor();
        if (exitVal == 0) {
            return"Success!";
        } else {
            return"Ha habido un error";
        }
 
    }
}
