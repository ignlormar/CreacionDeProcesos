package Sumador;

import java.util.Scanner;

public class Sumador {
    public static int Suma(int num1, int num2){
        int result = 0;
        if(num1 > num2){
            System.out.println("El primer numero debe ser menor que el segundo");
        } else {
            for(int i = num1; i < num2; i++){
                result += i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer numero: ");
        int primerNumero = sc.nextInt();

        System.out.print("Introduce el segundo numero: ");
        int segundoNumero = sc.nextInt();

        System.out.println(Suma(primerNumero, segundoNumero));

    }
}
