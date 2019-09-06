package CSS;

import java.util.LinkedList;

/**
 *
 * @author AlisonLeiva
 */
public class CSS {

    public String id;
    public static LinkedList<CSS> estilos = new LinkedList<>();
    public LinkedList<AtributoCSS> atributo;
    public LinkedList<CSS> subEstilos;
    public int indice;

    public CSS(String id, LinkedList<AtributoCSS> atributo) {
        this.subEstilos = new LinkedList<>();
        this.id = id.toLowerCase();
        this.atributo = atributo;
    }

    public CSS(String id, LinkedList<AtributoCSS> atributo, LinkedList<CSS> subEstilos) {
        this.id = id.toLowerCase();
        this.atributo = atributo;
        this.subEstilos = subEstilos;
    }

    public CSS(LinkedList<AtributoCSS> atributo) {
        this.atributo = atributo;

    }

    public void agregarSubEstilo(CSS subestilo) {
        this.subEstilos.add(subestilo);
    }

    public static void addEstilo(CSS css) {
        estilos.add(css);
    }

    public static void imprimir() {
        for (CSS css : CSS.estilos) {
            System.out.println("CSS " + css.id);
            for (CSS sub : css.subEstilos) {
                System.out.println("SubEstilo " + sub.id);
            }
        }
    }

}
