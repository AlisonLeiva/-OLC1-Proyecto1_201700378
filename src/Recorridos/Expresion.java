package Recorridos;

import Recorridos.Simbolo.EnumTipo;

/**
 *
 * @author AlisonLeiva
 */
public class Expresion {

    Simbolo.EnumTipo tipo;
    Object valor;
    int cantidad;

    public Expresion(EnumTipo tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Expresion(Object valor, int cantidad) {
        this.cantidad = cantidad;
        this.valor = valor;
    }

}
