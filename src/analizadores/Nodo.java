
package analizadores;

import java.util.LinkedList;

public class Nodo {
    public String estado;
    public String valor;
    public LinkedList<Nodo> hijos;
    public int linea,columna;

    public Nodo(String estado, String valor,int linea,int columna) {
        this.estado = estado;
        this.valor = valor;
        this.hijos = new LinkedList<>();
        this.linea=linea;
        this.columna=columna;
    }

    public void agregarHijo(Nodo hijo) {
        this.hijos.add(hijo);
    }
}
