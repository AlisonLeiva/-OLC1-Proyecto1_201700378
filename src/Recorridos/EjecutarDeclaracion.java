package Recorridos;

import analizadores.Nodo;
import java.util.LinkedList;
import proyecto1.Reporte;

/**
 *
 * @author AlisonLeiva
 */
public class EjecutarDeclaracion {

    public static void DeclaracionVariable(Nodo raiz, Entorno ent) {
        System.out.println("----------------------------->DECLARACION DE VARIABLES<-----------------------------");
        if (raiz.hijos.size() == 1) {//GUARDAR VARIABLE SIN VALOR
            String id = raiz.hijos.get(0).valor;
            ent.Insertar(id, new Simbolo(""), raiz.linea, raiz.columna);
        } else if (raiz.hijos.size() == 2) {//GUARDAR VARIABLE BUSCANDO VALOR 
            Expresion resultado = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1), ent);
            if (!resultado.valor.equals("@Error@")) {
                ent.Insertar(raiz.hijos.get(0).valor, new Simbolo(resultado.tipo, resultado.valor), raiz.hijos.get(0).linea, raiz.hijos.get(0).columna);
            }
        }
    }

    public static void DeclaracionArray(Nodo raiz, Entorno ent) {
        // System.out.println("----------------------------->DECLARACION DE ARRAY<-----------------------------");
        LinkedList<Simbolo> lista = new LinkedList<>();
        String id;
        int cantidad;

        if (raiz.hijos.size() == 1) {//GUARDAR ARRAY  - PRIMERA FORMA
            Expresion resultado = EjecutarOperacion.resolverExpresion(raiz.hijos.get(0), ent);
            if (!resultado.valor.equals("@Error@")) {
                for (int i = 0; i < resultado.cantidad; i++) {
                    lista.add(new Simbolo(Simbolo.EnumTipo.STRING, "0"));
                }
                ent.Insertar(resultado.valor.toString(), new Simbolo(resultado.cantidad, lista), raiz.linea, raiz.columna);
            }
        } else if (raiz.hijos.size() == 2) {//GUARDAR ARRAY  - SEGUNDA FORMA
            id = raiz.hijos.get(0).valor;
            System.out.println("id que da problemas: "+id);
            cantidad = raiz.hijos.get(1).hijos.size();

            for (int i = 0; i < cantidad; i++) {
                Expresion resultado = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1).hijos.get(i), ent);
                if (!resultado.valor.equals("@Error@")) {
                    lista.add(new Simbolo(resultado.tipo, resultado.valor));
                } else {
                    Reporte.agregarReporte(new Reporte("Semantico", "No se puede agregar el elemento al array", raiz.linea, raiz.columna));
                }
            }
            ent.Insertar(id, new Simbolo(cantidad, lista), raiz.linea, raiz.columna);
        }
    }

    public static void AsignacionArray(Nodo raiz, Entorno ent) {
        String id = raiz.hijos.get(0).hijos.get(0).valor;
        Expresion indice = EjecutarOperacion.resolverExpresion(raiz.hijos.get(0).hijos.get(1), ent);
        Expresion valorNuevo = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1), ent);
        if (ent.Buscar(id, raiz.linea, raiz.columna) != null) {
            ent.ModificarArray(String.valueOf(id), Integer.parseInt(indice.valor.toString()), new Simbolo(valorNuevo.tipo, valorNuevo.valor), raiz.linea, raiz.columna);
        }
    }

    public static void AsignacionVariable(Nodo raiz, Entorno ent) {
        // System.out.println("----------------------------->ASIGNACION DE VARIABLES<-----------------------------");
        String id = raiz.hijos.get(0).valor;
        Expresion valor = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1), ent);
        ent.Modificar(String.valueOf(id), new Simbolo(valor.tipo, valor.valor), raiz.linea, raiz.columna);
    }
}
