/*
 En el segundo recorrido se guardaran los componentes y las variables declaradas
 */
package Recorridos;

import UFE.Componente;
import analizadores.Nodo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import proyecto1.Reporte;

/**
 *
 * @author AlisonLeiva
 */
public class SegundoRecorrido {

    public Entorno Ejecutar(Nodo raiz, Entorno global) {
        recorrer(raiz, global);
        return global;
    }

    private void recorrer(Nodo raiz, Entorno ent) {
        switch (raiz.estado) {
            case "L_INSTRUCCIONES": {
                for (int i = 0; i < raiz.hijos.size(); i++) {
                    recorrer(raiz.hijos.get(i), ent);
                }
                break;
            }
            case "COMPONENTE": {
                String idComponente = raiz.hijos.get(0).valor;
                boolean existe = false;
                for (int j = 0; j < Componente.listaComponentes.size(); j++) {
                    if (idComponente.equals(Componente.listaComponentes.get(j).id)) {
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    Componente.agregarComponente(new Componente(idComponente, raiz.hijos.get(1)));
                } else {
                    Reporte.agregarReporte(new Reporte("Semantico", "Ya existe un componente con ese nombre '" + idComponente + "'", raiz.linea, raiz.columna));
                }
                break;
            }
            case "DECLARACION_ARRAY": {
                EjecutarDeclaracion.DeclaracionArray(raiz, ent);
                break;
            }
            case "ASIGNACION_ARRAY": {
                EjecutarDeclaracion.AsignacionArray(raiz, ent);
                break;
            }
            case "DECLARACION_VAR": {
                for (int j = 0; j < raiz.hijos.get(0).hijos.size(); j++) {
                    EjecutarDeclaracion.DeclaracionVariable(raiz.hijos.get(0).hijos.get(j), ent);
                }
                break;
            }
            case "ASIGNACION_VAR": {
                EjecutarDeclaracion.AsignacionVariable(raiz, ent);
                break;
            }
        }
    }

}
