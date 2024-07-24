/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros.quadrados.solução.em.java;

/**
 *
 * @author Erasmo Martinez
 */
public class NumerosQuadradosSoluçãoEmJava {

    public static int squares(int a, int b) {
        // Inicia el contador de cuadrados perfectos
        int count = 0;

        // Inicia con el menor número entero (1)
        int i = 1;

        // Continua mientras el cuadrado de i sea menor o igual a b
        while (i * i <= b) {
            // Si el cuadrado de i es mayor o igual a 'a' y menor o igual a 'b', es un cuadrado perfecto en el intervalo
            if (i * i >= a) {
                count++;
            }
            // Incrementa i para verificar el próximo número
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(squares(3, 9)); // 2
        System.out.println(squares(24, 49)); // 3
        System.out.println(squares(17, 24)); // 0
        System.out.println(squares(35, 70)); // 3
        System.out.println(squares(100, 1000)); // 22
        System.out.println(squares(59, 999999922)); // 31615
        System.out.println(squares(9, 999999966)); // 31620
        System.out.println(squares(12, 999999988)); // 31619
    }
    
}
