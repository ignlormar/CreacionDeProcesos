package ValidaEmail;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int intentos = 3;
        boolean emailValido = false;

        try {
            while (intentos > 0 && !emailValido) {
                System.out.print("Introduce tu email: ");
                String email = br.readLine();

                emailValido = ValidaMail.validarEmail(email);

                if (!emailValido) {
                    intentos--;
                    if (intentos > 0) {
                        System.out.println("Intentos restantes: " + intentos);
                    } else {
                        System.out.println("Has superado los 3 intentos");
                    }
                } else {
                    System.out.println("El email es válido");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
