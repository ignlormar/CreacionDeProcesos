package Palindromo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Palindromo {

    public static String upper(String palabra){
        return palabra.toUpperCase();
    }

    public static boolean esPalindromo(String palabra){
        palabra = palabra.replace(" ", "").toLowerCase();
        return palabra.equals(palabraInversa(palabra));
    }

    public static String palabraInversa(String palabra){
        StringBuilder invertida = new StringBuilder(palabra);
        return invertida.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        String ruta = System.getProperty("user.dir");
        String directorio = ruta + File.separator + "src" + File.separator + "Palindromo" + File.separator + "texto" + File.separator;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Introduce una palabra o frase:");
        String frase = br.readLine();

        String fraseMayuscula = upper(frase);
        System.out.println("En mayúscula: " + fraseMayuscula);

        boolean palindromo = esPalindromo(frase);
        System.out.println("¿Es palíndromo?: " + palindromo);

        List<File> archivos = new ArrayList<>();
        archivos.add(new File(directorio + "palindromo.txt"));
        archivos.add(new File(directorio + "nopalindromo.txt"));
        archivos.add(new File(directorio + "todas.txt"));

        try {
            for (File file : archivos) {
                if (!file.exists()) {
                    if (file.createNewFile()) {
                        System.out.println(file.getName() + " creado.");
                    } else {
                        System.out.println(file.getName() + " no pudo ser creado.");
                    }
                }
            }

            FileWriter fwTodas = new FileWriter(archivos.get(2), true);
            BufferedWriter bwTodas = new BufferedWriter(fwTodas);
            bwTodas.write(frase);
            bwTodas.newLine();
            bwTodas.close();

            if (palindromo) {
                FileWriter fwPalindromo = new FileWriter(archivos.get(0), true);
                BufferedWriter bwPalindromo = new BufferedWriter(fwPalindromo);
                bwPalindromo.write(frase);
                bwPalindromo.newLine();
                bwPalindromo.close();
            } else {
                FileWriter fwNoPalindromo = new FileWriter(archivos.get(1), true);
                BufferedWriter bwNoPalindromo = new BufferedWriter(fwNoPalindromo);
                bwNoPalindromo.write(frase);
                bwNoPalindromo.newLine();
                bwNoPalindromo.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}