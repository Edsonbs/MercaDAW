package es.etg.programacion.mercadaw.util.printer;

import java.io.IOException;

public class Impresora {
    /**
     * Tienes que dar un String con el nombre que tendrá el fichero pdf imprimido, (Solo imprime pdfs)
     * @param nombreImprimido
     * @return un mensaje Success si funciona y otro si se interrumpe
     * @throws IOException
     * @throws InterruptedException
     */
    public String imprimir(String nombreImprimido) throws IOException, InterruptedException{
        try{    Process process = Runtime.getRuntime().exec("bash exportar.sh "+nombreImprimido);
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
