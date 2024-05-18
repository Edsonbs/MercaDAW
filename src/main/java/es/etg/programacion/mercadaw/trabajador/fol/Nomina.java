package es.etg.programacion.mercadaw.trabajador.fol;
import static es.etg.programacion.mercadaw.trabajador.fol.Deducciones.*;

import java.util.LinkedHashMap;
import es.etg.programacion.mercadaw.util.Documento;
/**
 * Clase rellenada con la informacion del empleado que la calcula y las deducciones
 */
public class Nomina implements Documento{
    public final double DIAS_ANYO = 365;
    public final double ANYOS_ANTIG = 2;
    public final double CONTRATO_INDEFINIDO = 20;
    private String nombreEmpleado;
    private double salario;
    private double salarioBruto;
    private double salarioNeto;
    private double salarioAnualBruto;
    private double costeLaboral;
    private double indemnizacion;
    
    public Nomina(String nombreEmpleado, double salario) {
        this.nombreEmpleado = nombreEmpleado;
        this.salario = salario;
        salarioBruto = salario + calcularPPE();
        salarioNeto = calcularSalarioNeto();
        salarioAnualBruto = calcularSalarioAnual();
        costeLaboral = calcularCosteLaboral();
        indemnizacion = calcularIndemnizacion();
    }

    private double calcularCosteLaboral(){
        return salarioBruto * (sumarDeduccionesEmpresa()/100);
    }
    private double calcularSalarioNeto(){
        return salarioBruto - (salarioBruto*(sumarDeducciones()/100));
    }
    private double sumarDeduccionesEmpresa(){
        final double BCCC_EMPRE = 23.6;
        final double DESEMPLEO_EMPRE = 5.5;
        final double FOGASA_EMPRE = 0.2;
        final double FP = 0.6;
        final double MEI_EMPRE = 0.58;
        return BCCC_EMPRE+DESEMPLEO_EMPRE+FOGASA_EMPRE+FP+MEI_EMPRE;
    }

    private double sumarDeducciones(){
        return IRPF.getPorcentaje()+BCCC.getPorcentaje()+FOGASA.getPorcentaje()+MEI.getPorcentaje()+DESEMPLEO.getPorcentaje();
    }

    private double calcularSalarioAnual(){
        return salario*14;
    }

    private double calcularPPE(){
        return (2*salario)/12;
    }
    private double calcularIndemnizacion(){
        return (salarioAnualBruto/DIAS_ANYO)*CONTRATO_INDEFINIDO*ANYOS_ANTIG;
    }

    @Override
    public String getTitulo() {
        final String TITULO = "Nomina de Trabajador";
        return TITULO;
    }

    @Override
    public String getPie() {
        final String PIE = "La Indemnizacion que recibiría el Trabajador sería de "+String.format("%.2f",indemnizacion)+"€";
        return PIE;
    }

    @Override
    public LinkedHashMap<String, String> getContenido() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Nombre del Empleado", nombreEmpleado);
        map.put("Salario Anual", String.format("%.2f",getSalarioAnualBruto())+"€");
        map.put("Total devengado",String.format("%.2f",getSalarioBruto())+"€");
        map.put("Salario Neto", String.format("%.2f",getSalarioNeto())+"€");
        map.put("Coste Laboral", String.format("%.2f",getCosteLaboral())+"€");
        return map;
    }

    public double getDIAS_ANYO() {
        return DIAS_ANYO;
    }

    public double getANYOS_ANTIG() {
        return ANYOS_ANTIG;
    }

    public double getCONTRATO_INDEFINIDO() {
        return CONTRATO_INDEFINIDO;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public double getSalarioAnualBruto() {
        return salarioAnualBruto;
    }

    public void setSalarioAnualBruto(double salarioAnualBruto) {
        this.salarioAnualBruto = salarioAnualBruto;
    }

    public double getCosteLaboral() {
        return costeLaboral;
    }

    public void setCosteLaboral(double costeLaboral) {
        this.costeLaboral = costeLaboral;
    }

    public double getIndemnizacion() {
        return indemnizacion;
    }

    public void setIndemnizacion(double indemnizacion) {
        this.indemnizacion = indemnizacion;
    }
    
}
