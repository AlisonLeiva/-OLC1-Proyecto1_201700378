package Recorridos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import proyecto1.Reporte;

/**
 *
 * @author AlisonLeiva
 */
public class Entorno {

    public HashMap<String, Simbolo> tabla;
    Entorno anterior;

    public Entorno(Entorno anterior) {
        this.anterior = anterior;
        this.tabla = new HashMap<>();
    }

    public void Insertar(String nombre, Simbolo sim, int linea, int columna) {
        if (tabla.containsKey(nombre)) {
            //Reporte.ReporteErrores.add(new Reporte("Semantico", "La variable " + nombre + " ya existe", linea, columna));
            return;
        }
        tabla.put(nombre, sim);
    }

    public void Modificar(String nombre, Simbolo sim, int linea, int columna) {
        for (Entorno e = this; e != null; e = e.anterior) {
            if (e.tabla.containsKey(nombre)) {
                e.tabla.put(nombre, sim);
                return;
            }
        }
        Reporte.ReporteErrores.add(new Reporte("Semantico", "Error en asignacion, la variable " + nombre + " no existe", linea, columna));
    }

    public Simbolo Buscar(String nombre, int linea, int columna) {
        for (Entorno e = this; e != null; e = e.anterior) {
         //   System.out.println("---------///////////////////////////////////////////////////////////////////------------------");
           // e.imprimir();
            if (e.tabla.containsKey(nombre)) {
                Simbolo sim = e.tabla.get(nombre);
                return sim;
            }
        }
        System.out.println("LA VARIABLE NO EXISTE");
        Reporte.ReporteErrores.add(new Reporte("Semantico", "La variable " + nombre + " no existe", linea, columna));
        return null;
    }

    public void imprimir() {
        Iterator<String> sim = tabla.keySet().iterator();
        System.out.println("Variables declaradas:");
        for (Simbolo key : tabla.values()) {
            System.out.println(sim.next() + " ---> " + key.toString());
        }
    }

    void ModificarArray(String nombre, int indice, Simbolo simbolo, int linea, int columna) {
        Simbolo sim = Buscar(nombre, linea, columna);
        if (sim != null) {
            if (indice < sim.ValoresArray.size()) {
                sim.ValoresArray.set(indice, simbolo);
            } else {
                Reporte.agregarReporte(new Reporte("Semantico", "El indice " + indice + " Es mayor a la cantidad de elementos " + sim.ValoresArray.size(), linea, columna));
            }
        }
    }
}
