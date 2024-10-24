package Lanzador;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero entero: ");
        String num1 = sc.nextLine();
        System.out.print("Introduce otro numero entero: ");
        String num2 = sc.nextLine();

        String ruta = System.getProperty("user.dir");

        String[] comando = {"java", "Sumador.Sumador", num1, num2};
        ProcessBuilder pb = new ProcessBuilder(comando);

        File archivo = new File(ruta + "out/production/ProgramacionProcesos1/Sumador/");
        pb.directory(archivo);

        try {
            Process proceso = pb.start();
            InputStream is = proceso.getInputStream();

            int fila;
            while ((fila = is.read()) != -1){
                System.out.println((char) fila);
            }
            is.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
