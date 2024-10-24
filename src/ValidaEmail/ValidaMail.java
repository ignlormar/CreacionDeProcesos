package ValidaEmail;

public class ValidaMail {
    public static boolean validarEmail(String email) {
        if (!email.contains("@")) {
            System.out.println("El email no contiene un @");
            return false;
        }

        String[] partes = email.split("@");

        if (partes.length != 2 || partes[1].isEmpty()) {
            System.out.println("No existe segunda parte");
            return false;
        }

        if (partes[0].length() < 3) {
            System.out.println("La primera parte ha de tener una longitud mínima de 3 caracteres");
            return false;
        }

        String dominio = partes[1];
        if (!(dominio.endsWith(".com") || dominio.endsWith(".es") || dominio.endsWith(".org"))) {
            System.out.println("El dominio no es ni .com ni .esni .org");
            return false;
        }

        return true;
    }
}