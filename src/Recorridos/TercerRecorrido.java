package Recorridos;

import analizadores.Nodo;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import proyecto1.Reporte;
import HTML.*;
import UFE.*;
import CSS.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import proyecto1.Frame;

/**
 *
 * En el tercer recorrido se ejecutaran los ciclos,instrucciones y demas...
 *
 * @author AlisonLeiva
 */
public class TercerRecorrido {

    JFrame frame;
    public static String ResultadoConsola = "";
    boolean existeBorde = false;
    String colorBorde = "%";
    int grosor = -1;
    int posicion = 0;

    public void Ejecutar(Nodo raiz, Entorno global) {
        /* System.out.println("--------------------------------------------VARIABLES DECLARADAS-- tercer recorrido-------------------------------------------------------");
        global.imprimir();*/
        recorrer(raiz, global, null);
        System.out.println("--------------------------------------------VARIABLES DECLARADAS-- tercer recorrido-------------------------------------------------------");
        global.imprimir();

    }

    private Component recorrer(Nodo raiz, Entorno ent, Component componente) {
        switch (raiz.estado) {
            case "L_INSTRUCCIONES": {
                return ListaInstrucciones(raiz, ent, componente);
            }
            case "REPETIR": {
                EjecutarRepetir(raiz, ent, componente);
                break;
            }
            case "RENDER": {
                EjecutarRender(raiz, ent);
                break;
            }
            case "MIENTRAS": {
                EjecutarMientras(raiz, ent, componente);
                break;
            }
            case "IF": {
                EjecutarIF(raiz, ent, componente);
                break;
            }
            case "IMPRIMIR": {
                EjecutarImprimir(raiz, ent);
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
            case "PANEL": {
                return ObtenerComponente(raiz, ent, "PANEL");
            }
            case "TEXT": {
                return ObtenerComponente(raiz, ent, "TEXT");
            }
            case "TEXTFIELD": {
                return ObtenerComponente(raiz, ent, "TEXTFIELD");

            }
            case "BOTON": {
                return ObtenerComponente(raiz, ent, "BOTON");

            }
            case "IMAGE": {
                return ObtenerComponente(raiz, ent, "IMAGE");

            }
            case "LIST": {
                return ObtenerComponente(raiz, ent, "LIST");

            }
            case "SPINNER": {
                return ObtenerComponente(raiz, ent, "SPINNER");
            }

            case "INSERT_IMPORT": {
                InsertImport(raiz, ent, componente);
            }
        }
        return null;
    }

    private void EjecutarImprimir(Nodo raiz, Entorno ent) {
        Expresion imprimir = EjecutarOperacion.resolverExpresion(raiz.hijos.get(0), ent);
        if (imprimir.tipo != Simbolo.EnumTipo.ERROR) {
            ResultadoConsola += ">> " + imprimir.valor + "\n";
        }
    }

    private void InsertImport(Nodo raiz, Entorno ent, Component componente) {
        String idComponente = raiz.hijos.get(0).valor;
        for (int i = 0; i < Componente.listaComponentes.size(); i++) {
            if (Componente.listaComponentes.get(i).id.equals(idComponente.toLowerCase().trim())) {
                recorrer(Componente.listaComponentes.get(i).listaInstrucciones, ent, componente);
            }
        }
    }

    private Component ListaInstrucciones(Nodo raiz, Entorno ent, Component componente) {
        for (Nodo instruccion : raiz.hijos) {
            if (instruccion.estado.equals("RETURN")) {
                for (Nodo c : instruccion.hijos.get(0).hijos) {
                    Component component = recorrer(c, ent, componente);
                    System.out.println("COMPONENTES_ADD_FRAME " + instruccion.estado);
                    if (component != null) {
                        if (componente instanceof JFrame) {
                            frame.add(component);
                            return frame;
                        } else {
                            ((JPanel) componente).add(component);
                            return componente;
                        }
                    }
                }
                break;
            }
            recorrer(instruccion, ent, componente);
        }
        return null;
    }

    private void EjecutarRepetir(Nodo raiz, Entorno ent, Component componente) {
        Expresion cantidad = EjecutarOperacion.resolverExpresion(raiz.hijos.get(0), ent);
        if (cantidad.tipo != Simbolo.EnumTipo.INT) {
            Reporte.agregarReporte(new Reporte("Semantico", "El parametro de la funcion repetir debe ser tipo INT, no " + cantidad.tipo, raiz.linea, raiz.columna));
            return;
        }
        for (int i = 0; i < Integer.parseInt(cantidad.valor.toString()); i++) {
            Entorno local = new Entorno(ent);
            recorrer(raiz.hijos.get(1), local, componente);
        }
    }

    private void EjecutarMientras(Nodo raiz, Entorno ent, Component componente) {
        Expresion condicion = EjecutarOperacion.resolverExpresion(raiz.hijos.get(0), ent);
        if (condicion.tipo != Simbolo.EnumTipo.BOOLEAN) {
            Reporte.agregarReporte(new Reporte("Semantico", "El parametro de la funcion mientras debe ser tipo BOOLEAN, no " + condicion.tipo, raiz.linea, raiz.columna));
            return;
        }
        while (Boolean.valueOf(condicion.valor.toString())) {
            Entorno local = new Entorno(ent);
            recorrer(raiz.hijos.get(1), local, componente);
            JOptionPane.showMessageDialog(null, "CICLO MIENTRAS ");
            condicion = EjecutarOperacion.resolverExpresion(raiz.hijos.get(0), local);
        }
    }

    private void EjecutarIF(Nodo raiz, Entorno ent, Component componente) {
        for (int i = 0; i < raiz.hijos.size(); i++) {
            boolean cumple = resolverIF(raiz.hijos.get(i), ent, componente);
            if (cumple) {
                break;
            }
        }
    }

    private boolean resolverIF(Nodo raiz, Entorno ent, Component componente) {
        switch (raiz.estado) {
            case "SI": {
                Expresion condicion = EjecutarOperacion.resolverExpresion(raiz.hijos.get(0), ent);
                if (condicion.tipo != Simbolo.EnumTipo.BOOLEAN) {
                    Reporte.agregarReporte(new Reporte("Semantico", "El parametro de la funcion SI debe ser tipo BOOLEAN, no " + condicion.tipo, raiz.linea, raiz.columna));
                    break;
                }
                if (Boolean.valueOf(condicion.valor.toString())) {
                    Entorno local = new Entorno(ent);
                    recorrer(raiz.hijos.get(1), local, componente);
                    return true;
                }
                return false;
            }
            case "L_SINO_SI": {
                for (int i = 0; i < raiz.hijos.size(); i++) {
                    Expresion condicion = EjecutarOperacion.resolverExpresion(raiz.hijos.get(i).hijos.get(0), ent);
                    if (condicion.tipo != Simbolo.EnumTipo.BOOLEAN) {
                        Reporte.agregarReporte(new Reporte("Semantico", "El parametro de la funcion SI debe ser tipo BOOLEAN, no " + condicion.tipo, raiz.linea, raiz.columna));
                        break;
                    }
                    if (Boolean.valueOf(condicion.valor.toString())) {
                        Entorno local = new Entorno(ent);
                        recorrer(raiz.hijos.get(i).hijos.get(1), local, componente);
                        return true;
                    }
                }
                return false;
            }
            case "SINO": {
                Entorno local = new Entorno(ent);
                recorrer(raiz.hijos.get(0), local, componente);
                return true;
            }
        }
        return false;
    }

    private void EjecutarRender(Nodo raiz, Entorno ent) {
        String idComponente = raiz.hijos.get(0).valor;
        String idDiv = raiz.hijos.get(1).valor;
        boolean existeDiv = false;
        frame = new JFrame(idDiv);
        frame.setLayout(null);
        frame.setBounds(0, 0, 1992, 1000);
        frame.setLocationRelativeTo(null);

        for (int i = 0; i < HTML.listaId.size(); i++) {
            if (HTML.listaId.get(i).id.equals(idDiv.toLowerCase().trim())) {
                existeDiv = true;
                break;
            }
        }
        if (existeDiv) {
            boolean existe = false;
            for (posicion = 0; posicion < Componente.listaComponentes.size(); posicion++) {
                if (Componente.listaComponentes.get(posicion).id.equals(idComponente.toLowerCase().trim())) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                recorrer(Componente.listaComponentes.get(posicion).listaInstrucciones, ent, frame);
                ResultadoConsola += ">> Vista creada " + idDiv + "\n";
            }
        } else {
            for (HTML noufe : HTML.listaId) {
                if (noufe.isNoufe) {
                    JLabel label = new JLabel(noufe.id);
                    label.setBounds(20, 20, 1000, 1000);
                    label.setFont(new Font("Century Gothic", Font.PLAIN, 30));
                    frame.add(label);
                    break;
                }
            }
        }
        frame.setVisible(true);

    }

    public void Atributos(Nodo raiz, AtributoUFE a, Entorno ent) {
        for (int i = 0; i < raiz.hijos.size(); i++) {

            String estado = raiz.hijos.get(i).hijos.get(0).valor;
            Expresion valor = EjecutarOperacion.resolverExpresion(raiz.hijos.get(i).hijos.get(1), ent);

            if (!valor.tipo.equals(Simbolo.EnumTipo.ERROR)) {
                switch (estado) {
                    case "id": {
                        a.id = valor.valor.toString();
                        break;
                    }
                    case "x": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.INT)) {
                            a.x = Integer.parseInt(valor.valor.toString());
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'x' debe ser tipo INT, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "y": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.INT)) {
                            a.y = Integer.parseInt(valor.valor.toString());
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'y' debe ser tipo INT, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "max": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.INT)) {
                            a.max = Integer.parseInt(valor.valor.toString());
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'max' debe ser tipo INT, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "min": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.INT)) {
                            a.min = Integer.parseInt(valor.valor.toString());
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'min' debe ser tipo INT, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "height": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.INT)) {
                            a.height = Integer.parseInt(valor.valor.toString());
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'height' debe ser tipo INT, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "width": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.INT)) {
                            a.width = Integer.parseInt(valor.valor.toString());
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'width' debe ser tipo INT, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "color": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.STRING)) {
                            a.color = valor.valor.toString();
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'color' debe ser tipo STRING, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "border": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.INT)) {
                            a.border = Integer.parseInt(valor.valor.toString());
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'border' debe ser tipo INT, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "classname": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.STRING)) {
                            a.classname = valor.valor.toString();
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'classname' debe ser tipo STRING, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "src": {
                        if (valor.tipo.equals(Simbolo.EnumTipo.STRING)) {
                            a.src = valor.valor.toString();
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'src' debe ser tipo STRING, no " + valor.tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case "onclick": {
                        a.onclick = valor.valor.toString();
                        break;
                    }
                }
            }
        }
    }

    private Component ObtenerComponente(Nodo raiz, Entorno ent, String tipoComponente) {
        existeBorde = false;
        colorBorde = "%";
        grosor = -1;

        AtributoUFE a = new AtributoUFE("&", 0, 0, 100, 100, "#FFFFFF", 0, "%", "%", -100, 100, "%");
        System.out.println("--------------------COMPONENTE-------------------- " + raiz.estado);
        Atributos(raiz.hijos.get(0), a, ent);
        System.out.println("id: " + a.id + "\nx: " + a.x + "\ny: " + a.y + "\ncolor: " + a.color + "\nborder: " + a.border + " height: " + a.height + "\nwidth: " + a.width + "\nonclick: " + a.onclick + "\nsrc: " + a.src + "\nmax: " + a.max + "\nmin: " + a.min + "\nclassname: " + a.classname);
        switch (tipoComponente) {
            case "PANEL": {
                JPanel panel = new JPanel();
                panel.setLayout(null);
                panel.setBorder(BorderFactory.createLineBorder(Color.black, a.border));
                AplicarAtributosGenerales(panel, a, raiz, ent);
                if (existeBorde && !colorBorde.equals("%") && grosor != -1) {
                    panel.setBorder(BorderFactory.createLineBorder(Color.decode(colorBorde), grosor));
                }
                if (raiz.hijos.size() == 1) {
                    return panel;
                } else {
                    for (Nodo COMPONENTE : raiz.hijos.get(1).hijos) {
                        System.out.println("ADD_PANEL " + COMPONENTE.estado);
                        Component componente = recorrer(COMPONENTE, ent, panel);
                        if (componente != null) {
                            panel.add(componente);
                        }
                    }

                    return panel;
                }
            }
            case "TEXT": {
                JLabel label = new JLabel();
                label.setBorder(BorderFactory.createLineBorder(Color.black, a.border));
                AplicarAtributosGenerales(label, a, raiz, ent);
                if (existeBorde && !colorBorde.equals("%") && grosor != -1) {
                    label.setBorder(BorderFactory.createLineBorder(Color.decode(colorBorde), grosor));
                }
                if (raiz.hijos.size() == 1) {
                    return label;
                } else {
                    Expresion texto = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1), ent);
                    if (!texto.tipo.equals(Simbolo.EnumTipo.ERROR)) {
                        label.setText(texto.valor.toString());
                    }
                    return label;
                }
            }
            case "TEXTFIELD": {
                JTextField textfield = new JTextField();
                textfield.setBorder(BorderFactory.createLineBorder(Color.black, a.border));
                AplicarAtributosGenerales(textfield, a, raiz, ent);
                if (existeBorde && !colorBorde.equals("%") && grosor != -1) {
                    textfield.setBorder(BorderFactory.createLineBorder(Color.decode(colorBorde), grosor));
                }

                if (raiz.hijos.size() == 1) {
                    return textfield;
                } else {
                    Expresion texto = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1), ent);
                    if (!texto.tipo.equals(Simbolo.EnumTipo.ERROR)) {
                        textfield.setText(texto.valor.toString());
                    }
                    return textfield;
                }
            }
            case "BOTON": {
                JButton btn = new JButton();
                btn.setBorder(BorderFactory.createLineBorder(Color.black, a.border));
                if (!a.onclick.equals("%")) {
                    btn.addActionListener((ActionEvent e) -> {
                        JOptionPane.showMessageDialog(null, a.onclick);
                    });
                }
                AplicarAtributosGenerales(btn, a, raiz, ent);
                if (existeBorde && !colorBorde.equals("%") && grosor != -1) {
                    btn.setBorder(BorderFactory.createLineBorder(Color.decode(colorBorde), grosor));
                }

                if (raiz.hijos.size() == 1) {
                    return btn;
                } else {
                    Expresion texto = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1), ent);
                    if (!texto.tipo.equals(Simbolo.EnumTipo.ERROR)) {
                        btn.setText(texto.valor.toString());
                    } else {
                        Reporte.agregarReporte(new Reporte("Semantico", "La variable no ha sido declarada '" + texto.valor + "'", raiz.linea, raiz.columna));
                    }
                    return btn;
                }

            }
            case "IMAGE": {
                JLabel img = new JLabel();
                img.setBorder(BorderFactory.createLineBorder(Color.black, a.border));
                AplicarAtributosGenerales(img, a, raiz, ent);
                if (existeBorde && !colorBorde.equals("%") && grosor != -1) {
                    img.setBorder(BorderFactory.createLineBorder(Color.decode(colorBorde), grosor));
                }

                if (!a.src.equals("%")) {
                    String ruta = Frame.nombre_proyecto + "\\src\\" + a.src;
                    ImageIcon imagen = new ImageIcon(getClass().getResource(ruta));
                    ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));
                    img.setIcon(icono);
                }
                return img;
            }
            case "LIST": {
                JComboBox combobox = new JComboBox();
                for (int i = 0; i < raiz.hijos.get(1).hijos.size(); i++) {
                    Expresion item = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1).hijos.get(i), ent);
                    if (!item.tipo.equals(Simbolo.EnumTipo.ERROR)) {
                        combobox.addItem(item.valor);
                    }
                }
                combobox.setBorder(BorderFactory.createLineBorder(Color.black, a.border));
                AplicarAtributosGenerales(combobox, a, raiz, ent);
                if (existeBorde && !colorBorde.equals("%") && grosor != -1) {
                    combobox.setBorder(BorderFactory.createLineBorder(Color.decode(colorBorde), grosor));
                }
                if (raiz.hijos.size() == 2) {//sin default
                    combobox.setSelectedIndex(0);
                    return combobox;
                } else {//con default
                    Expresion index = EjecutarOperacion.resolverExpresion(raiz.hijos.get(2).hijos.get(0), ent);
                    if (index.tipo.equals(Simbolo.EnumTipo.INT)) {
                        if (Integer.parseInt(index.valor.toString()) < combobox.getItemCount()) {
                            combobox.setSelectedIndex(Integer.parseInt(index.valor.toString()));
                        }
                    } else {
                        Reporte.agregarReporte(new Reporte("Semantico", "El indice del componente 'List' debe ser INT, no" + index.tipo, raiz.linea, raiz.columna));
                    }
                    return combobox;
                }
            }
            case "SPINNER": {
                JSpinner spinner = new JSpinner();
                spinner.setBorder(BorderFactory.createLineBorder(Color.black, a.border));
                SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
                modeloSpinner.setMaximum(a.max);
                modeloSpinner.setMinimum(a.min);
                AplicarAtributosGenerales(spinner, a, raiz, ent);
                if (existeBorde && !colorBorde.equals("%") && grosor != -1) {
                    spinner.setBorder(BorderFactory.createLineBorder(Color.decode(colorBorde), grosor));
                }
                if (raiz.hijos.size() == 1) {
                    return spinner;
                } else {
                    Expresion texto = EjecutarOperacion.resolverExpresion(raiz.hijos.get(1), ent);
                    if (!texto.tipo.equals(Simbolo.EnumTipo.ERROR)) {
                        modeloSpinner.setValue(Integer.parseInt(texto.valor.toString()));
                        spinner.setModel(modeloSpinner);
                    }
                    return spinner;
                }

            }
        }
        return null;
    }

    private void AplicarAtributosGenerales(Component componente, AtributoUFE a, Nodo raiz, Entorno ent) {
        componente.setBackground(Color.decode(a.color));
        componente.setBounds(a.x, a.y, a.width, a.height);
        if (!a.id.equals("%")) {
            componente.setName(a.id);
        }
        if (!a.classname.equals("%")) {
            AplicarCSS(componente, a.classname, raiz, ent);
        }
    }

    private void AplicarCSS(Component componente, String id, Nodo raiz, Entorno ent) {
        System.out.println("**********************************************A P L I C A N DO  CSS*********************************************************************");
        String[] s = id.split(" ");
        String estilo = s[0].toLowerCase();
        CSS listaAtributos = null;
        for (CSS est : CSS.estilos) {
            if (est.id.equals(estilo)) {
                System.out.println("/////////////////////////////Existe CSS " + est.id);
                listaAtributos = new CSS(est.id, est.atributo, est.subEstilos);
                AtributosCSS(raiz, listaAtributos.atributo, ent, componente);// Se aplica el estilo original
                break;
            }
        }
        if (listaAtributos == null) {
            Reporte.agregarReporte(new Reporte("Semantico", "No se puede aplicar el estilo CSS '" + id + "', no esta creado o no ha sido importado.", raiz.linea, raiz.columna));
            return;
        }
        if (s.length == 2) { //obtener CSS y subestilo
            String subestilo = s[1].toLowerCase();
            for (CSS sub : listaAtributos.subEstilos) {
                if (subestilo.equals(sub.id)) {
                    System.out.println("/////////////////////////Existe sub estilo CSS " + sub.id);
                    listaAtributos = new CSS(sub.atributo);
                    break;
                }
            }
            AtributosCSS(raiz, listaAtributos.atributo, ent, componente);// Se aplica el sub estilo
        }
    }

    public void AtributosCSS(Nodo raiz, LinkedList<AtributoCSS> atributos, Entorno ent, Component componente) {
        String fuente = "%";
        int font_size = 14, anchura = 0, altura = 0;

        for (int i = 0; i < atributos.size(); i++) {

            Expresion atributo = EjecutarOperacion.resolverExpresion(atributos.get(i).valor, ent);
            String valor = atributo.valor.toString();
            Simbolo.EnumTipo tipo = atributo.tipo;

            System.out.println(atributos.get(i).propiedad + " " + valor);
            if (!tipo.equals(Simbolo.EnumTipo.ERROR)) {
                switch (atributos.get(i).propiedad) {
                    case fondo: {
                        if (tipo.equals(Simbolo.EnumTipo.STRING)) {
                            componente.setBackground(Color.decode(valor));
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'background' debe ser tipo STRING, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case existeBorde: {
                        if (tipo.equals(Simbolo.EnumTipo.BOOLEAN)) {
                            existeBorde = Boolean.parseBoolean(valor);
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'existeBorde' debe ser tipo BOOLEAN, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case color_borde: {
                        if (tipo.equals(Simbolo.EnumTipo.STRING)) {
                            colorBorde = valor;
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'color-border' debe ser tipo STRING, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case grosor_borde: {
                        if (tipo.equals(Simbolo.EnumTipo.INT)) {
                            grosor = Integer.parseInt(valor);
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'grosor-border' debe ser tipo INT, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case alineacion: {
                        if (tipo.equals(Simbolo.EnumTipo.STRING)) {
                            if (componente instanceof JButton) {
                                switch (valor) {
                                    case "left":
                                        ((JButton) componente).setHorizontalAlignment(SwingConstants.LEFT);
                                        break;
                                    case "right":
                                        ((JButton) componente).setHorizontalAlignment(SwingConstants.RIGHT);
                                        break;
                                    case "center":
                                        ((JButton) componente).setHorizontalAlignment(SwingConstants.CENTER);
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                            } else if (componente instanceof JTextField) {
                                switch (valor) {
                                    case "left":
                                        ((JTextField) componente).setHorizontalAlignment(SwingConstants.LEFT);
                                        break;
                                    case "right":
                                        ((JTextField) componente).setHorizontalAlignment(SwingConstants.RIGHT);
                                        break;
                                    case "center":
                                        ((JTextField) componente).setHorizontalAlignment(SwingConstants.CENTER);
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                            } else if (componente instanceof JLabel) {
                                switch (valor) {
                                    case "left":
                                        ((JLabel) componente).setHorizontalAlignment(SwingConstants.LEFT);
                                        break;
                                    case "right":
                                        ((JLabel) componente).setHorizontalAlignment(SwingConstants.RIGHT);
                                        break;
                                    case "center":
                                        ((JLabel) componente).setHorizontalAlignment(SwingConstants.CENTER);
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                            }
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'alineacion' debe ser tipo STRING, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }

                    case fuente: {
                        if (tipo.equals(Simbolo.EnumTipo.STRING)) {
                            fuente = valor;
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'fuente' debe ser tipo STRING, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case size_fuente: {
                        if (tipo.equals(Simbolo.EnumTipo.INT)) {
                            font_size = Integer.parseInt(valor);
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'font-size' debe ser tipo INT, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case color_fuente: {
                        if (tipo.equals(Simbolo.EnumTipo.STRING)) {
                            componente.setForeground(Color.decode(valor));
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'color' debe ser tipo STRING, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case altura: {
                        if (tipo.equals(Simbolo.EnumTipo.INT)) {
                            altura = Integer.parseInt(valor);
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'border' debe ser tipo INT, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                    case anchura: {
                        if (tipo.equals(Simbolo.EnumTipo.INT)) {
                            anchura = Integer.parseInt(valor);
                        } else {
                            Reporte.agregarReporte(new Reporte("Semantico", "El parametro 'classname' debe ser tipo INT, no " + tipo, raiz.linea, raiz.columna));
                        }
                        break;
                    }
                }
                if (!fuente.equals("%")) {
                    componente.setFont(new Font(fuente, Font.PLAIN, font_size));
                }

                if (altura != 0 && anchura != 0) {
                    componente.setSize(new Dimension(anchura, altura));
                }
            }

        }
    }

}
