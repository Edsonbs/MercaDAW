package es.etg.mercadaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.etg.programacion.mercadaw.trabajador.Empleado;
import es.etg.programacion.mercadaw.trabajador.fol.Nomina;

public class NominaTest {
    private Empleado emp = new Empleado("Prueba", "Apellido", "ESTANDAR");
    private Nomina nom = emp.calcularNomina();
    @Test
    public void calcularSalarioAnualTest(){
        double salarioAnualEsperado = 14000;
        assertEquals(salarioAnualEsperado, nom.getSalarioAnualBruto());
    }
    @Test
    public void calcularSalarioBrutoTest(){
        double salarioBrutoEsperado = 1166.67;
        assertEquals(salarioBrutoEsperado, nom.getSalarioBruto());
    }
    @Test
    public void calcularSalarioNetoTest(){
        double salarioNetoEsperado = 927.85;
        assertEquals(salarioNetoEsperado, nom.getSalarioNeto());
    }
    @Test
    public void calcularCosteLaboralTest(){
        double costeLaboralEsperado = 355.6;
        assertEquals(costeLaboralEsperado, nom.getCosteLaboral());
    }
    @Test
    public void calcularIndemnizacionTest(){
        double indemnizacionEsperada = 1534.24;
        assertEquals(indemnizacionEsperada, nom.getIndemnizacion());
    }
}
