package ar.edu.unju.fi.poo.tp1.ej1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresar una cadena: ");
        String cadena = sc.nextLine();

        System.out.println(substringCount(cadena.length(), cadena));
    }

    public static int substringCount(int n, String s) {

        int count = 0;

        // Contar subcadenas con caracteres iguales consecutivos
        for (int i = 0; i < n; i++) {
            int repeat = 1;

            // Contar cuántos caracteres iguales consecutivos hay
            while (i + 1 < n && s.substring(i, i + 1).equals(s.substring(i + 1, i + 2))) {
                repeat++;
                i++;
            }

            // Sumar al conteo el número de subcadenas formadas por esos caracteres repetidos
            count += repeat * (repeat + 1) / 2;
        }

        // Contar subcadenas donde solo el carácter del medio es diferente
        for (int j = 1; j < n; j++) {
            int repeat = 1;

            // Expande hacia afuera desde el carácter central
            while (j - repeat >= 0 && j + repeat < n &&
                    s.substring(j - repeat, j - repeat + 1).equals(s.substring(j + repeat, j + repeat + 1)) &&
                    s.substring(j - repeat, j - repeat + 1).equals(s.substring(j - 1, j))) {
                count++;
                repeat++;
            }
        }
        return count;
    }

}