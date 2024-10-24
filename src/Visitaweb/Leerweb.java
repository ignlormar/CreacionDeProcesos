package Visitaweb;

import java.io.*;

public class Leerweb {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce maximo 3 URLs separadas por '@':");

        try {
            String input = br.readLine();

            String[] webs = input.split("@");
            if (webs.length > 3) {
                System.out.println("Solo puedes introducir un maximo de 3 webs");
                return;
            }

            String ruta = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Visitaweb" + File.separator + "webs.txt";
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(input);
            bw.newLine();
            bw.close();
            System.out.println("Las URLs se han guardado en " + ruta);

            Visitaweb.main(new String[]{ruta});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}