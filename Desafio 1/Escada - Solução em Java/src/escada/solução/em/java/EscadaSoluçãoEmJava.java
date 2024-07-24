/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escada.solução.em.java;

import java.util.Scanner;

/**
 *
 * @author Erasmo Martinez
 */
public class EscadaSoluçãoEmJava {

    public static void escada(int n) {

        for (int i = 1; i <= n; i++) {
            // Imprimir espacios en blanco
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // Imprimir los símbolos #
            for (int k = 0; k < i; k++) {
                System.out.print("#");
            }
            // Salto de línea al final de cada nivel de la escalera
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.print("Ingresa el número de niveles de la escalera: ");
        int n = consola.nextInt();
        
        escada(n);
    }

}
