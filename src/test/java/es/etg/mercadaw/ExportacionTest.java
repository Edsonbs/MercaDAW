package es.etg.mercadaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.etg.programacion.mercadaw.mercado.Supermercado;
import es.etg.programacion.mercadaw.producto.Categoria;
import es.etg.programacion.mercadaw.producto.Cosmetica;
import es.etg.programacion.mercadaw.producto.Producto;
import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.fol.Nomina;
import es.etg.programacion.mercadaw.util.Documento;
import es.etg.programacion.mercadaw.util.printer.Impresora;
import es.etg.programacion.mercadaw.util.writer.WriterMarkdown;

public class ExportacionTest {
    private static Empleado emp = new Empleado("José", "Piñon", "CAJERO");
    private static Empleado emp2 = new Empleado("Maria", "Pérez", "ESTANDAR");
    private static Empleado emp3 = new Empleado("Rodrigo", "Martinez", "ENCARGADO");
    private static Producto p1 = new Cosmetica("Producto", "MarcaDAW", 2, 0.3, 0.2, 0.2, 1, "Descripcion breve", Categoria.COSMETICA, "Cosmetica");
    private static Supermercado sd = new Supermercado("Madrid","Parla","Mercadaw");
    private static Nomina nom = emp2.calcularNomina();
    private static WriterMarkdown mk = new WriterMarkdown();
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
    public void exportarDatosDocumentosTest(){
        String esperado = "Success!";
        String real;
        Impresora a = new Impresora();
        List<Documento> docs = mk.transformarEmpleados(sd.getEmpleados());
        mk.escribir(docs);
        real = a.imprimir("EmpleadosPrueba");
        assertEquals(esperado, real);
    }
    @Test
    public void exportarDatosEtiquetaTest(){
        String esperado = "Success!";
        String real;
        Impresora a = new Impresora();
        List<Documento> docs = mk.transformarEmpleados(sd.getEmpleados());
        mk.escribirEtiqueta(p1);
        real = a.imprimir("EtiquetaPrueba");
        assertEquals(esperado, real);
    }
    @Test
    public void exportarDatosDocumentoTest(){
        String esperado = "Success!";
        String real;
        Impresora a = new Impresora();
        List<Documento> docs = mk.transformarEmpleados(sd.getEmpleados());
        mk.escribir(p1);
        real = a.imprimir("DatosPrueba");
        assertEquals(esperado, real);
    }
    @Test
    public void exportarDatosNominaTest(){
        String esperado = "Success!";
        String real;
        Impresora a = new Impresora();
        List<Documento> docs = mk.transformarEmpleados(sd.getEmpleados());
        mk.escribir(nom);
        real = a.imprimir("NominaPrueba");
        assertEquals(esperado, real);
    }
}
