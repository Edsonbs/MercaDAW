package es.etg.programacion.mercadaw.trabajador;

import java.util.LinkedHashMap;

import es.etg.programacion.mercadaw.util.Documento;

public class Empleado implements Documento  {

    public final double STANDARD = 1000;
    private static int id;
    private String nombre;
    private String apellido;
    private String categoria;
    private int idUsuario;
    protected double salario = STANDARD;
    
    public Empleado(int idUsuario, String nombre, String apellido, String categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.idUsuario = idUsuario;
        id++;
    }
    public double getSTANDARD() {
        return STANDARD;
    }
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Empleado.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public LinkedHashMap<String, String> getContenido() {
        LinkedHashMap  empleados = new LinkedHashMap<>();
        empleados.put(id, getIdUsuario());
        empleados.put(nombre, getNombre());
        empleados.put(apellido, getApellido());
        empleados.put(categoria, getCategoria());
        empleados.put(salario, getSalario());
        return empleados;
    }
    @Override
    public String getTitulo() {

        final String DATOSEMP = "DATOS DEL EMPLEADO";
        return DATOSEMP;
        
    }
    @Override
    public String getPie() {
        return "";
    }
    
}
