package HTML;

import java.util.LinkedList;

/**
 *
 * @author AlisonLeiva
 */
public class HTML {

    public static LinkedList<HTML> listaId = new LinkedList<>();
    public String id;
    public boolean isNoufe;

    public HTML(boolean isNoufe, String id) {
        this.id = id.toLowerCase().trim();
        if (isNoufe) {
            this.isNoufe = true;
        } else {
            this.isNoufe = false;
        }
    }

    public static void agregarId(HTML rep) {
        listaId.add(rep);
    }
}
