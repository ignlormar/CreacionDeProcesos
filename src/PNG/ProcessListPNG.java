package PNG;

import java.io.File;
import java.util.Scanner;

public class ProcessListPNG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Introduce la ruta del directorio: ");
        String ruta = sc.nextLine();

        //Creamos un objeto File para poder acceder al directorio y hacer comporbaciones
        File carpeta = new File(ruta);

        if (carpeta.isDirectory()){
            //Listamos el contenido del directorio y lo metemos en una lista
            File[] archivos = carpeta.listFiles();
            System.out.println("PNG en " + ruta);

            //Filtramos la lista utilizando solo los archivos que acaban en .png
            for (File archivo : archivos){
                if (archivo.isFile() && archivo.getName().endsWith(".png")){
                    System.out.println(archivo.getName());
                }
            }
        }
        sc.close();
    }
}
