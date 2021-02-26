package com.bootcamp.modelo;

import java.util.Hashtable;
import java.util.Set;

public class DecodificadorCodigoMorse {
    private static Hashtable<String, String> obtenerEquivalencias() {
        Hashtable<String, String> mapeo = new Hashtable<>();
        mapeo.put("A", ".-");
        mapeo.put("B", "-...");
        mapeo.put("C", "-.-.");
        mapeo.put("CH", "----");
        mapeo.put("D", "-..");
        mapeo.put("E", ".");
        mapeo.put("F", "..-.");
        mapeo.put("G", "--.");
        mapeo.put("H", "....");
        mapeo.put("I", "..");
        mapeo.put("J", ".---");
        mapeo.put("K", "-.-");
        mapeo.put("L", ".-..");
        mapeo.put("M", "--");
        mapeo.put("N", "-.");
        mapeo.put("Ñ", "--.--");
        mapeo.put("O", "---");
        mapeo.put("P", ".--.");
        mapeo.put("Q", "--.-");
        mapeo.put("R", ".-.");
        mapeo.put("S", "...");
        mapeo.put("T", "-");
        mapeo.put("U", "..-");
        mapeo.put("V", "...-");
        mapeo.put("W", ".--");
        mapeo.put("X", "-..-");
        mapeo.put("Y", "-.--");
        mapeo.put("Z", "--..");
        mapeo.put("0", "-----");
        mapeo.put("1", ".----");
        mapeo.put("2", "..---");
        mapeo.put("3", "...--");
        mapeo.put("4", "....-");
        mapeo.put("5", ".....");
        mapeo.put("6", "-....");
        mapeo.put("7", "--...");
        mapeo.put("8", "---..");
        mapeo.put("9", "----.");
        mapeo.put(".", ".-.-.-");
        mapeo.put(",", "--..--");
        mapeo.put(":", "---...");
        mapeo.put("?", "..--..");
        mapeo.put("'", ".----.");
        mapeo.put("-", "-....-");
        mapeo.put("/", "-..-.");
        mapeo.put("\"", ".-..-.");
        mapeo.put("@", ".--.-.");
        mapeo.put("=", "-...-");
        mapeo.put("!", "−.−.−−");
        return mapeo;
    }

    private static String morseAAscii(String morseBuscado) {
        Hashtable<String, String> equivalencias = obtenerEquivalencias();
        Set<String> claves = equivalencias.keySet();
        // La clave es la letra ASCII
        for (String clave : claves) {
            String morse = equivalencias.get(clave);
            if (morse.equals(morseBuscado)) {
                return clave;
            }
        }
        return "";
    }

    private static String decodificarMorse(String codificado) {
        StringBuilder decodificado = new StringBuilder();
        // Necesitamos separarlo por espacios
        String[] morse = codificado.split(" ");
        for (String morseActual : morse) {
            String equivalencia = morseAAscii(morseActual);
            decodificado.append(equivalencia);
        }
        return decodificado.toString();
    }

    public static String decodificar(String codificado) {
        StringBuilder decodificado = new StringBuilder();
        // Necesitamos separar palabras por 3 espacios
        String[] palabras = codificado.split("   ");
        for (String palabra: palabras) {
            decodificado.append(decodificarMorse(palabra)).append(" ");
        }
        return decodificado.toString().trim();
    }
}
