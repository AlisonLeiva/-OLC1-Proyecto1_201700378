package CSS;

import analizadores.Nodo;

/**
 *
 * @author AlisonLeiva
 */
public class AtributoCSS {

    public Nodo valor;
    public EnumPropiedad propiedad;

    public AtributoCSS(EnumPropiedad propiedad, Nodo valor) {
        this.propiedad = propiedad;
        this.valor = valor;
    }

    public enum EnumPropiedad {
        fondo, existeBorde, color_borde, grosor_borde,
        alineacion, fuente, size_fuente, color_fuente, altura, anchura
    }
}
