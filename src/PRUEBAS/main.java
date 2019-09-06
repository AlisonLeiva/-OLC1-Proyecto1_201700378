/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRUEBAS;

/**
 *
 * @author AlisonLeiva
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CrearMiVentana f = new CrearMiVentana();
           f.mostrar();
        String v1 = "asdfasdf";
        int v2 = 0;
        CambiarValores(v1, v2);
        System.out.println(v1 + " " + v2);

    }

    public static void CambiarValores(String v1, int v2) {
        v1 = "CADENA";
        v2 = 41265;
    }
}
