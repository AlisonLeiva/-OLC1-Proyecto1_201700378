package Recorridos;

import analizadores.Nodo;
import proyecto1.Reporte;

/**
 *
 * @author AlisonLeiva
 */
public class EjecutarOperacion {

    public static Expresion resolverExpresion(Nodo raiz, Entorno ent) {
        return resolver(raiz, ent);
    }

    private static Expresion resolver(Nodo raiz, Entorno ent) {
        switch (raiz.estado) {
            case "INT": {
                return new Expresion(Simbolo.EnumTipo.INT, raiz.valor);
            }
            case "DOUBLE": {
                return new Expresion(Simbolo.EnumTipo.DOUBLE, raiz.valor);
            }
            case "CHAR": {
                return new Expresion(Simbolo.EnumTipo.CHAR, raiz.valor);
            }
            case "BOOLEAN": {
                return new Expresion(Simbolo.EnumTipo.BOOLEAN, raiz.valor);
            }
            case "STRING": {
                return new Expresion(Simbolo.EnumTipo.STRING, raiz.valor);
            }
            case "ID": {
                Simbolo sim = ent.Buscar(raiz.valor, raiz.linea, raiz.columna);
                if (sim != null) {
                    return new Expresion(sim.tipo, sim.valor);
                }
                break;
            }
            case "VALOR_ARRAY": {
                Simbolo sim = ent.Buscar(raiz.hijos.get(0).valor, raiz.linea, raiz.columna);
                if (sim != null) {
                    int indice = Integer.parseInt(resolverExpresion(raiz.hijos.get(1), ent).valor.toString());
                    if (indice < sim.ValoresArray.size()) {
                        Simbolo dato = sim.ValoresArray.get(indice);
                        return new Expresion(dato.tipo, dato.valor);
                    } else {
                        Reporte.agregarReporte(new Reporte("Semantico", "[ARRAY] El indice '" + indice + "' es mayor al tamaño del aray " + sim.ValoresArray.size(), raiz.linea, raiz.columna));
                    }
                }
                break;
            }
            case "ACCESO": {
                Object id = raiz.hijos.get(0).valor;
                Expresion cantidad = resolverExpresion(raiz.hijos.get(1), ent);
                return new Expresion(id, Integer.parseInt(cantidad.valor.toString()));
            }

            case "OPERACION": {
                Expresion valor1 = resolverExpresion(raiz.hijos.get(0), ent);
                Expresion valor2 = resolverExpresion(raiz.hijos.get(2), ent);
                /* System.out.println("--------------------" + raiz.hijos.get(1).estado + "-------------------------------");
                System.out.println("valor 1 " + valor1.tipo + " " + valor1.valor);
                System.out.println("valor 2" + valor2.tipo + " " + valor2.valor);
                */
                if (valor1.tipo.equals(Simbolo.EnumTipo.STRING)) {
                    valor1.valor = valor1.valor.toString().toLowerCase();
                }
                if (valor2.tipo.equals(Simbolo.EnumTipo.STRING)) {
                    valor2.valor = valor2.valor.toString().toLowerCase();
                }
                if (raiz.hijos.get(1).estado.equals("SUMA")) {
                    return EjecutarSuma(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("RESTA")) {
                    return EjecutarResta(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("MULTIPLICACION")) {
                    return EjecutarMultiplicacion(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("DIVISION")) {
                    return EjecutarDivision(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("POTENCIA")) {
                    return EjecutarPotencia(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("!=")) {
                    return EjecutarDiferente(valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("==")) {
                    return EjecutarIgual(valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("<")) {
                    return EjecutarMenor(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("<=")) {
                    return EjecutarMenorIgual(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals(">")) {
                    return EjecutarMayor(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals(">=")) {
                    return EjecutarMayorIgual(raiz, valor1, valor2);
                } else if (raiz.hijos.get(1).estado.equals("^")) {
                    if (valor1.tipo.equals(Simbolo.EnumTipo.BOOLEAN) && valor2.tipo.equals(Simbolo.EnumTipo.BOOLEAN)) {
                        return EjecutarXOR(valor1.valor.toString(), valor2.valor.toString());
                    }
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '^' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));
                } else if (raiz.hijos.get(1).estado.equals("&&")) {
                    if (valor1.tipo.equals(Simbolo.EnumTipo.BOOLEAN) && valor2.tipo.equals(Simbolo.EnumTipo.BOOLEAN)) {
                        return EjecutarAND(valor1.valor.toString(), valor2.valor.toString());
                    }
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '&&' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));

                } else if (raiz.hijos.get(1).estado.equals("||")) {
                    if (valor1.tipo.equals(Simbolo.EnumTipo.BOOLEAN) && valor2.tipo.equals(Simbolo.EnumTipo.BOOLEAN)) {
                        return EjecutarOR(valor1.valor.toString(), valor2.valor.toString());
                    }
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '||' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));
                } else if (raiz.hijos.get(1).estado.equals("!")) {
                    if (valor2.tipo.equals(Simbolo.EnumTipo.BOOLEAN)) {
                        return EjecutarNegacion(valor2.valor.toString());
                    }
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '!' no se puede  aplicar a operandos de tipo " + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        }
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarSuma(Nodo raiz, Expresion valor1, Expresion valor2) {
        switch (valor1.tipo) {
            case INT: {
                switch (valor2.tipo) {
                    case INT: {
                        int result = Integer.parseInt(valor1.valor.toString()) + Integer.parseInt(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) + Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case STRING: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                    case CHAR: {
                        int result = Integer.parseInt(valor1.valor.toString()) + (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                }
            }
            case DOUBLE: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Double.parseDouble(valor1.valor.toString()) + Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) + Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case STRING: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                    case CHAR: {
                        double result = Double.parseDouble(valor1.valor.toString()) + (double) (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
            case STRING: {
                switch (valor2.tipo) {
                    case INT: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                    case DOUBLE: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                    case STRING: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                    case CHAR: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                    case BOOLEAN: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                }
            }
            case CHAR: {
                switch (valor2.tipo) {
                    case INT: {
                        int result = (int) valor1.valor.toString().charAt(0) + Integer.parseInt(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case CHAR: {
                        int result = (int) valor1.valor.toString().charAt(0) + (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = (double) (int) valor1.valor.toString().charAt(0) + Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case STRING: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                }
            }
            case BOOLEAN: {
                switch (valor2.tipo) {
                    case STRING: {
                        return new Expresion(Simbolo.EnumTipo.STRING, valor1.valor.toString() + valor2.valor.toString());
                    }
                }
            }
        }
        Reporte.agregarReporte(new Reporte("Semantico", "El operador '+' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarResta(Nodo raiz, Expresion valor1, Expresion valor2) {
        switch (valor1.tipo) {
            case INT: {
                switch (valor2.tipo) {
                    case INT: {
                        int result = Integer.parseInt(valor1.valor.toString()) - Integer.parseInt(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) - Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        int result = Integer.parseInt(valor1.valor.toString()) - (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                }
            }
            case DOUBLE: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Double.parseDouble(valor1.valor.toString()) - Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) - Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        double result = Double.parseDouble(valor1.valor.toString()) - (double) (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
            case CHAR: {
                switch (valor2.tipo) {
                    case INT: {
                        int result = (int) valor1.valor.toString().charAt(0) - Integer.parseInt(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case CHAR: {
                        int result = (int) valor1.valor.toString().charAt(0) - (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = (double) (int) valor1.valor.toString().charAt(0) - Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
        }
        Reporte.agregarReporte(new Reporte("Semantico", "El operador '-' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarMultiplicacion(Nodo raiz, Expresion valor1, Expresion valor2) {
        switch (valor1.tipo) {
            case INT: {
                switch (valor2.tipo) {
                    case INT: {
                        int result = Integer.parseInt(valor1.valor.toString()) * Integer.parseInt(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) * Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        int result = Integer.parseInt(valor1.valor.toString()) * (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                }
            }
            case DOUBLE: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Double.parseDouble(valor1.valor.toString()) * Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) * Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        double result = Double.parseDouble(valor1.valor.toString()) * (double) (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
            case CHAR: {
                switch (valor2.tipo) {
                    case INT: {
                        int result = (int) valor1.valor.toString().charAt(0) * Integer.parseInt(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case CHAR: {
                        int result = (int) valor1.valor.toString().charAt(0) * (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = (double) (int) valor1.valor.toString().charAt(0) * Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
        }
        Reporte.agregarReporte(new Reporte("Semantico", "El operador '*' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarDivision(Nodo raiz, Expresion valor1, Expresion valor2) {
        if (valor2.valor.equals("0")) {
            Reporte.agregarReporte(new Reporte("Semantico", "No se puede dividir entre '0'", raiz.linea, raiz.columna));
            return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
        }
        switch (valor1.tipo) {
            case INT: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Double.parseDouble(valor1.valor.toString()) / Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));

                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) / Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        double result = Double.parseDouble(valor1.valor.toString()) / (double) (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                }
            }
            case DOUBLE: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Double.parseDouble(valor1.valor.toString()) / Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Double.parseDouble(valor1.valor.toString()) / Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        double result = Double.parseDouble(valor1.valor.toString()) / (double) (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
            case CHAR: {
                switch (valor2.tipo) {
                    case INT: {
                        int result = (int) valor1.valor.toString().charAt(0) / Integer.parseInt(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case CHAR: {
                        int result = (int) valor1.valor.toString().charAt(0) / (int) valor2.valor.toString().charAt(0);
                        return new Expresion(Simbolo.EnumTipo.INT, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = (double) (int) valor1.valor.toString().charAt(0) / Double.parseDouble(valor2.valor.toString());
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
        }
        Reporte.agregarReporte(new Reporte("Semantico", "El operador '/' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarPotencia(Nodo raiz, Expresion valor1, Expresion valor2) {
        switch (valor1.tipo) {
            case INT: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Math.pow(Double.parseDouble(valor1.valor.toString()), Double.parseDouble(valor2.valor.toString()));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Math.pow(Double.parseDouble(valor1.valor.toString()), Double.parseDouble(valor2.valor.toString()));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        double result = Math.pow(Double.parseDouble(valor1.valor.toString()), (double) (int) valor2.valor.toString().charAt(0));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
            case DOUBLE: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Math.pow(Double.parseDouble(valor1.valor.toString()), Double.parseDouble(valor2.valor.toString()));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Math.pow(Double.parseDouble(valor1.valor.toString()), Double.parseDouble(valor2.valor.toString()));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        double result = Math.pow(Double.parseDouble(valor1.valor.toString()), (double) (int) valor2.valor.toString().charAt(0));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
            case CHAR: {
                switch (valor2.tipo) {
                    case INT: {
                        double result = Math.pow((double) (int) valor1.valor.toString().charAt(0), Double.parseDouble(valor2.valor.toString()));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case CHAR: {
                        double result = Math.pow((double) (int) valor1.valor.toString().charAt(0), (double) (int) valor2.valor.toString().charAt(0));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                    case DOUBLE: {
                        double result = Math.pow((double) (int) valor1.valor.toString().charAt(0), Double.parseDouble(valor2.valor.toString()));
                        return new Expresion(Simbolo.EnumTipo.DOUBLE, String.valueOf(result));
                    }
                }
            }
        }
        Reporte.agregarReporte(new Reporte("Semantico", "El operador 'pow' no se puede  aplicar a operandos de tipo " + valor1.tipo + "-" + valor2.tipo, raiz.linea, raiz.columna));
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarDiferente(Expresion valor1, Expresion valor2) {
        if (!valor1.valor.toString().equals(valor2.valor.toString())) {
            return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
        }
        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
    }

    private static Expresion EjecutarIgual(Expresion valor1, Expresion valor2) {
        if (valor1.valor.toString().equals(valor2.valor.toString())) {
            return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
        }
        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));

    }

    private static Expresion EjecutarMenor(Nodo raiz, Expresion valor1, Expresion valor2) {
        if (valor1.tipo.equals(Simbolo.EnumTipo.CHAR)) {
            switch (valor2.tipo) {
                case INT: {//char-int
                    if ((int) valor1.valor.toString().charAt(0) < Integer.parseInt(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//char-double
                    if ((int) valor1.valor.toString().charAt(0) < Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//char-char
                    if ((int) valor1.valor.toString().charAt(0) < (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '<' no se puede  aplicar a operandos de tipo CHAR-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else if (valor1.tipo.equals(Simbolo.EnumTipo.DOUBLE) || valor1.tipo.equals(Simbolo.EnumTipo.INT)) {
            switch (valor2.tipo) {
                case INT: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) < Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) < Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) < (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '<' no se puede  aplicar a operandos de tipo NUMERICO-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else {
            Reporte.agregarReporte(new Reporte("Semantico", "El operador '<' no se puede  aplicar a operandos de tipo " + valor1.tipo, raiz.linea, raiz.columna));
        }
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarMenorIgual(Nodo raiz, Expresion valor1, Expresion valor2) {
        if (valor1.tipo.equals(Simbolo.EnumTipo.CHAR)) {
            switch (valor2.tipo) {
                case INT: {//char-int
                    if ((int) valor1.valor.toString().charAt(0) <= Integer.parseInt(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//char-double
                    if ((int) valor1.valor.toString().charAt(0) <= Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//char-char
                    if ((int) valor1.valor.toString().charAt(0) <= (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '<=' no se puede  aplicar a operandos de tipo CHAR-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else if (valor1.tipo.equals(Simbolo.EnumTipo.DOUBLE) || valor1.tipo.equals(Simbolo.EnumTipo.INT)) {
            switch (valor2.tipo) {
                case INT: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) <= Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) <= Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) <= (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '<=' no se puede  aplicar a operandos de tipo NUMERICO-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else {
            Reporte.agregarReporte(new Reporte("Semantico", "El operador '<=' no se puede  aplicar a operandos de tipo " + valor1.tipo, raiz.linea, raiz.columna));
        }
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarMayor(Nodo raiz, Expresion valor1, Expresion valor2) {
        if (valor1.tipo.equals(Simbolo.EnumTipo.CHAR)) {
            switch (valor2.tipo) {
                case INT: {//char-int
                    if ((int) valor1.valor.toString().charAt(0) > Integer.parseInt(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//char-double
                    if ((int) valor1.valor.toString().charAt(0) > Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//char-char
                    if ((int) valor1.valor.toString().charAt(0) > (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '>' no se puede  aplicar a operandos de tipo CHAR-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else if (valor1.tipo.equals(Simbolo.EnumTipo.DOUBLE) || valor1.tipo.equals(Simbolo.EnumTipo.INT)) {
            switch (valor2.tipo) {
                case INT: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) > Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) > Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) > (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '>' no se puede  aplicar a operandos de tipo NUMERICO-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else {
            Reporte.agregarReporte(new Reporte("Semantico", "El operador '>' no se puede  aplicar a operandos de tipo " + valor1.tipo, raiz.linea, raiz.columna));
        }
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarMayorIgual(Nodo raiz, Expresion valor1, Expresion valor2) {
        if (valor1.tipo.equals(Simbolo.EnumTipo.CHAR)) {
            switch (valor2.tipo) {
                case INT: {//char-int
                    if ((int) valor1.valor.toString().charAt(0) >= Integer.parseInt(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//char-double
                    if ((int) valor1.valor.toString().charAt(0) >= Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//char-char
                    if ((int) valor1.valor.toString().charAt(0) >= (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '>=' no se puede  aplicar a operandos de tipo CHAR-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else if (valor1.tipo.equals(Simbolo.EnumTipo.DOUBLE) || valor1.tipo.equals(Simbolo.EnumTipo.INT)) {
            switch (valor2.tipo) {
                case INT: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) >= Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case DOUBLE: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) >= Double.parseDouble(valor2.valor.toString())) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                case CHAR: {//numero-char
                    if (Double.parseDouble(valor1.valor.toString()) >= (int) valor2.valor.toString().charAt(0)) {
                        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
                    }
                    return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
                }
                default: {
                    Reporte.agregarReporte(new Reporte("Semantico", "El operador '>=' no se puede  aplicar a operandos de tipo NUMERICO-" + valor2.tipo, raiz.linea, raiz.columna));
                }
            }
        } else {
            Reporte.agregarReporte(new Reporte("Semantico", "El operador '>=' no se puede  aplicar a operandos de tipo " + valor1.tipo, raiz.linea, raiz.columna));
        }
        return new Expresion(Simbolo.EnumTipo.ERROR, "@Error@");
    }

    private static Expresion EjecutarXOR(String valor1, String valor2) {
        if (valor1.equals("false") && valor2.equals("false") || valor1.equals("true") && valor2.equals("true")) {
            return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
        }
        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
    }

    private static Expresion EjecutarAND(String valor1, String valor2) {
        if (valor1.equals("true") && valor2.equals("true")) {
            return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
        }
        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
    }

    private static Expresion EjecutarOR(String valor1, String valor2) {
        if (valor1.equals("false") && valor2.equals("false")) {
            return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
        }
        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));

    }

    private static Expresion EjecutarNegacion(String valor1) {
        if (valor1.equals("false")) {
            return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(true));
        }
        return new Expresion(Simbolo.EnumTipo.BOOLEAN, String.valueOf(false));
    }

}
