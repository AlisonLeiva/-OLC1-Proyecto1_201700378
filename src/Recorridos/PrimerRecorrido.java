package Recorridos;

import UFE.Componente;
import analizadores.LexicoCSS;
import analizadores.Nodo;
import java.io.FileInputStream;
import proyecto1.Frame;
import proyecto1.Reporte;
import CSS.*;
import analizadores.LexicoUFE;

/**
 * En este recorrido se importan los componentes necesarios y las variables
 * globales de dichos archivos
 *
 * @author AlisonLeiva
 */
public class PrimerRecorrido {

    public Entorno Ejecutar(Nodo raiz, Entorno global) {
        return recorrer(raiz, global);
    }

    private Entorno recorrer(Nodo raiz, Entorno ent) {
        switch (raiz.estado) {
            case "L_INSTRUCCIONES": {
                for (int i = 0; i < raiz.hijos.size(); i++) {
                    recorrer(raiz.hijos.get(i), ent);
                }
                break;
            }
            case "IMPORT_COMPONENT": {
                EjecutarImportarComponente(raiz, ent);
                break;
            }
            case "IMPORT_CSS": {
                EjecutarImportarCSS(raiz);
                break;
            }
        }
        return ent;
    }

    private void EjecutarImportarCSS(Nodo raiz) {
        String archivo = raiz.hijos.get(0).valor;
        String path = archivo.replace("./", Frame.nombre_proyecto + "\\src\\");
        if (!path.toLowerCase().endsWith(".css")) {
            Reporte.agregarReporte(new Reporte("Semantico", "[FILE] El archivo " + Frame.nombre_proyecto + " debe tener extension '.css'", raiz.linea, raiz.columna));
            return;
        }
        analizadores.parserCSS sintactico;
        try {
            CSS.estilos.clear();
            LexicoCSS lexico = new analizadores.LexicoCSS(new FileInputStream(path));
            sintactico = new analizadores.parserCSS(lexico);
            sintactico.parse();
            CSS.imprimir();
        } catch (Exception ex) {
        }
    }

    private void EjecutarImportarComponente(Nodo raiz, Entorno ent) {
        String id = raiz.hijos.get(0).valor;
        String archivo = raiz.hijos.get(1).valor;
        String path = archivo.replace("/", "\\").replace(".\\", Frame.nombre_proyecto + "\\src\\");
        if (!path.toLowerCase().endsWith(".ufe")) {
            Reporte.agregarReporte(new Reporte("Semantico", "[FILE] El archivo " + Frame.nombre_proyecto + " debe tener extension '.ufe'", raiz.linea, raiz.columna));
            return;
        }
        System.out.println(path);
        analizadores.parserUFE sintactico;
        try {
            LexicoUFE lexico = new analizadores.LexicoUFE(new FileInputStream(path));
            sintactico = new analizadores.parserUFE(lexico);
            sintactico.parse();
            raiz = sintactico.raiz;
            PrimerRecorrido primer_rec = new PrimerRecorrido();
            SegundoRecorrido segundo_rec = new SegundoRecorrido();

            ent = primer_rec.Ejecutar(raiz, ent);
            segundo_rec.Ejecutar(raiz, ent);

        } catch (Exception ex) {
            Reporte.agregarReporte(new Reporte("Semantico", "Error en compilar el archivo: " + Frame.nombre_proyecto, raiz.linea, raiz.columna));

        }
        //Eliminacion de componentes repetidos 
        int size = Componente.listaComponentes.size();
        boolean importado = false;
        for (int i = 0; i < size; i++) {
            Componente c = Componente.listaComponentes.get(i);
            if (id.equals(c.id) && c.estaImportado == -1) {
                Componente.listaComponentes.get(i).setEstaImportado(0);
                importado = true;
            }
        }
        if (!importado) {
            Reporte.agregarReporte(new Reporte("Semantico", "[IMPORT] El Componente '" + id + "' no se encuentra en el archivo " + archivo, raiz.linea, raiz.columna));
        }
        size = Componente.listaComponentes.size();
        for (int i = 0; i < size; i++) {
            if (Componente.listaComponentes.get(i).estaImportado == -1) {
                Componente.listaComponentes.remove(i);
                size--;
                i--;
            }
        }

    }

}
