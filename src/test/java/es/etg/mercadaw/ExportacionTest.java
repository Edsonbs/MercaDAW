package es.etg.mercadaw;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.etg.programacion.mercadaw.mercado.Supermercado;
import es.etg.programacion.mercadaw.producto.Categoria;
import es.etg.programacion.mercadaw.producto.Cosmetica;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.util.Documento;
import es.etg.programacion.mercadaw.util.writer.WriterMarkdown;

public class ExportacionTest {
    static Empleado emp = new Empleado("José", "Piñon", "CAJERO");
    static Empleado emp2 = new Empleado("Maria", "Pérez", "ESTANDAR");
    static Empleado emp3 = new Empleado("Rodrigo", "Martinez", "ENCARGADO");
    static Producto p1 = new Cosmetica("Producto", "MarcaDAW", 2, 0.3, 0.2, 0.2, 1, "Descripcion breve", Categoria.COSMETICA, "Cosmetica");
    static Supermercado sd = new Supermercado();
    @BeforeAll
    public void inicializar(){
    sd.darAlta(emp);
    sd.darAlta(emp2);
    sd.darAlta(emp3);
    sd.darAlta(p1);
    }
    @Test
    public void escribirDocumentoTest(){
        WriterMarkdown mk = new WriterMarkdown();
        mk.escribir(p1);
    }

    @Test
    public void escribirDocumentosTest(){
        WriterMarkdown mk = new WriterMarkdown();
        List<Documento> docs = mk.transformarEmpleados(sd.getEmpleados());
        mk.escribir(docs);
    }

    @Test
    public void escribirEtiquetaTest(){
        WriterMarkdown mk = new WriterMarkdown();
        mk.escribirEtiqueta(p1);
    }

    @Test
    public void exportarDatos(){
        Impresora a = new Impresora();
        WriterMarkdown mk = new WriterMarkdown();
        List<Documento> docs = mk.transformarEmpleados(sd.getEmpleados());
        mk.escribir(docs);
        a.imprimir("Empleados");
        mk.escribirEtiqueta(p1);
        a.imprimir("Etiqueta");
        mk.escribir(p1);
        a.imprimir("Datos");
    }
}
