package es.etg.programacion.mercadaw.mercado;

public class Cliente {
    private int codigoPostal;
    private String correoElectronico;
    private String nombre;
    private String fechaCompra;
    
    public Cliente(int codigoPostal, String correoElectronico, String nombre, String fechaCompra) {
        this.codigoPostal = codigoPostal;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.fechaCompra = fechaCompra;
    }
    
    public int getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}
