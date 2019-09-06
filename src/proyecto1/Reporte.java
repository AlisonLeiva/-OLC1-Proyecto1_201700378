package proyecto1;

import java.util.LinkedList;

/**
 *
 * @author AlisonLeiva
 */
public class Reporte {

    public static LinkedList<Reporte> ReporteErrores = new LinkedList<>();
    public String tipo;
    public String error;
    public int linea, columna;

    public Reporte(String tipo, String error, int linea, int columna) {
        this.tipo = tipo;
        this.error = error;
        this.linea = linea;
        this.columna = columna;
    }

    public static void agregarReporte(Reporte rep) {
        ReporteErrores.add(rep);
    }

}
