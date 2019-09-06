package UFE;

/**
 *
 * @author AlisonLeiva
 */
public class AtributoUFE {

    public String id;
    public int x, y, height, width;
    public String color;
    public int border;
    public String classname;
    public String onclick, src;
    public int min, max;

    public AtributoUFE(String id, int x, int y, int height, int widht, String color, int borde, String classname, String onclick, int min, int max, String src) {
        this.id = id;
        this.x = x;
        this.src = src;
        this.y = y;
        this.height = height;
        this.width = widht;
        this.color = color;
        this.border = borde;
        this.classname = classname;
        this.onclick = onclick;
        this.min = min;
        this.max = max;
    }

}
