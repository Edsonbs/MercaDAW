package es.etg.programacion.mercadaw.mercado;

import es.etg.programacion.mercadaw.producto.Categoria;
import es.etg.programacion.mercadaw.producto.IProducto;
import es.etg.programacion.mercadaw.trabajador.IEmpleado;
import es.etg.programacion.mercadaw.trabajador.Trabajador;

public class MercadoFactory {
    public static IProducto crearProducto(Categoria c) {
        if (c == Categoria.ALIMENTACION) {
            return new IProducto() {
            };
        } else if (c == Categoria.COSMETICA) {
            return new IProducto() {
            };
        } else {
            return new IProducto() {
            };
        }
    }

    public static IEmpleado crearTrabajador(Trabajador trab) {
        if (trab == Trabajador.CAJERO) {
            return new IEmpleado() {
            };
        } else if (trab == Trabajador.ENCARGADO) {
            return new IEmpleado() {
            };
        } else if (trab == Trabajador.REPONEDOR) {
            return new IEmpleado() {
            };
        } else {
            return new IEmpleado() {
            };
        }
    }
}
