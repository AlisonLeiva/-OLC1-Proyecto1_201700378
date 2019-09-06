package UFE;

import analizadores.Nodo;
import java.util.LinkedList;

/**
 *
 * @author AlisonLeiva
 */
public class Componente {

    /*
    id
    ESTILO CSS
    LinkedListo<AtributoUFE> listaAtributos;
     */
    public static LinkedList<Componente> listaComponentes = new LinkedList<>();
    public String id;
    public Nodo listaInstrucciones;
    public int estaImportado;

    public void setEstaImportado(int estaImportado) {
        this.estaImportado = estaImportado;
    }

    public Componente(String id, Nodo bloque) {
        this.listaInstrucciones = bloque;
        this.id = id.toLowerCase().trim();
        this.estaImportado = -1;
    }

    public static void agregarComponente(Componente componente) {
        listaComponentes.add(componente);
    }

    public static void Imprimir() {
        System.out.println("C O M P O N E N T E S ");
        for (Componente c : listaComponentes) {
            System.out.println(c.id + " " + c.estaImportado);
        }
    }
}
