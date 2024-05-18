package es.etg.programacion.mercadaw.util.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.util.Documento;

public class WriterMarkdown {
        private static File fichero = new File("Exportacion.md"); 
    /**
     * Genera un documento markdown Exportacion y lo rellena con el toString de Documento
     * @param doc
     * @throws IOException
     */
    public void escribirEtiqueta(Documento doc) throws IOException{
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
        bw.write("Etiqueta de "+doc.getTitulo());
        bw.newLine();
        bw.write("---");
        bw.newLine();
        bw.write(doc.toString());


        bw.flush(); 
        bw.close();  
    }
    /**
     * Genera un documento markdown Exportacion y lo rellena con Documento
     * @param doc
     * @throws IOException
     */
    public void escribir(Documento doc) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
        LinkedHashMap<String,String> cont = doc.getContenido();
        bw.write(doc.getTitulo());
        bw.newLine();
        bw.write("---");
        bw.newLine();
        for (HashMap.Entry<String,String> entry : cont.entrySet()) {
            bw.write("* "+entry.getKey()+": "+entry.getValue());
            bw.newLine();
        }
        bw.newLine();
        bw.write(doc.getPie());
        bw.flush();  
        bw.close();      
    }
    /**
     * Genera un documento markdown Exportacion y lo rellena con los contenidos de Documentos
     * @throws IOException
     */
    public void escribir(List<Documento> docs) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
        LinkedHashMap<String,String> cont = new LinkedHashMap<>();
        bw.write("Lista de "+docs.get(0).getTitulo());
        bw.newLine();
        bw.write("---");
        bw.newLine();
        for (Documento doc : docs) {
            cont = doc.getContenido();
            bw.write("* ");
            for (HashMap.Entry<String,String> entry : cont.entrySet()) {
                bw.write(entry.getKey()+": "+entry.getValue()+" ");
            }
            bw.newLine();
        }
        bw.newLine();
        bw.write(docs.get(0).getPie());
        bw.flush(); 
        bw.close(); 
    }
    /**
     * Transfoma una lista de Empleado a Documento
     * @param empleados
     * @return
     */
    public List<Documento> transformarEmpleados(List<Empleado> empleados){
        List<Documento> docs = new ArrayList<>();
        for (Empleado es : empleados) {
            docs.add(es);
        }
        return docs;
    }
    /**
     * Transfoma una lista de Producto a lista de Documento
     * @param productos
     * @return
     */
    public List<Documento> transformarProductos(List<Producto> productos){
        List<Documento> docs = new ArrayList<>();
        for (Producto es : productos) {
            docs.add(es);
        }
        return docs;
    }
}
