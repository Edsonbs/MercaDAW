package es.etg.programacion.mercadaw.trabajador;

import java.util.LinkedHashMap;

import es.etg.programacion.mercadaw.util.Documento;

public class Empleado implements Documento  {
    public final double STANDARD = 1000;
    private static int id;
    private String nombre;
    private String apellido;
    private String categoria;
    

    public Empleado(String nombre, String apellido, String categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
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

    @Override
    public LinkedHashMap<String, String> getContenido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContenido'");
    }

    @Override
    public String getTitulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitulo'");
    }

    @Override
    public String getPie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPie'");
    }
}
