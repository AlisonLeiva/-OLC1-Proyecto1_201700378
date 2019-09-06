/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recorridos;

import java.util.LinkedList;

/**
 *
 * @author AlisonLeiva
 */
public class Simbolo {

    public EnumTipo tipo;
    public Object valor;
    public LinkedList<Simbolo> ValoresArray = null;
    public int cantidad_datos;

    public Simbolo(EnumTipo tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Simbolo(int cantidad_datos, LinkedList<Simbolo> valores) {
        this.ValoresArray = new LinkedList<>(valores);
        this.cantidad_datos = cantidad_datos;
    }

    public Simbolo(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Tipo " + tipo + " Valor " + valor + " Cantidad " + cantidad_datos + " VALORES " + valores();
    }

    String valores() {
        String cadena = "{";
        if (ValoresArray != null) {
            for (Simbolo sim : ValoresArray) {
                cadena += sim.tipo + "-" + sim.valor + ",";
            }
        }

        return cadena + "}";
    }

    public enum EnumTipo {
        INT, DOUBLE, STRING, CHAR, BOOLEAN, ERROR
    }
}
