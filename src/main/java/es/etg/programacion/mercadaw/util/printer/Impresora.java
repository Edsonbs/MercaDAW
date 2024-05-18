package es.etg.programacion.mercadaw.util.printer;

import java.io.IOException;
/**
 * Exporta un Markdown a PDF
 */
public class Impresora {
    /**
     * Tienes que dar un String con el nombre que tendrá el fichero pdf imprimido, (Solo imprime pdfs)
     * @param nombreImprimido
     * @return un mensaje Success si funciona y otro si se interrumpe
     */
    public String imprimir(String nombreImprimido){
        try{    Process process = Runtime.getRuntime().exec("bash ./docker/exportar.sh "+nombreImprimido);
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                return"Success!";
            } else {
                return"Ha habido un error";
            }
        }catch (IOException e){
            return "Ha ocurrido un error en la operacion de Entrada o Salida";
        }catch (InterruptedException e){
            return "La exportación se ha interrumpido";
        }
 
    }
}
