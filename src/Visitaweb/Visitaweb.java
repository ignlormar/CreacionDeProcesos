package Visitaweb;

import java.io.*;

public class Visitaweb {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No existe ningún archivo con webs");
            return;
        }

        String filename = args[0];

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            br.close();

            if (line == null) {
                System.out.println("El archivo está vacío");
                return;
            }

            String[] webs = line.split("@");

            if (webs.length > 3) {
                System.out.println("Solo se pueden abrir un maximo de 3 webs");
                return;
            }

            String[] command = new String[webs.length + 1];
            command[0] = "firefox";  // Comando para abrir Firefox

            for (int i = 0; i < webs.length; i++) {
                command[i + 1] = webs[i];
            }

            Process process = Runtime.getRuntime().exec(command);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}