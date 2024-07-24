/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dias.belos.solução.em.java;

import javax.swing.JOptionPane;

/**
 *
 * @author Erasmo Martinez
 */
public class DiasBelosSoluçãoEmJava {

    public static int beautifulDays(int i, int j, int k) {
        int beautifulDaysCount = 0;

        for (int day = i; day <= j; day++) {
            int reversedDay = 0;
            int temp = day;

            //Proceso para invertir el número
            while (temp != 0) {
                int digit = temp % 10;
                reversedDay = reversedDay * 10 + digit;
                temp = temp / 10;
            }

            int difference;
                    
            if (day >= reversedDay) {
                difference = day - reversedDay;
            } else {
                difference = reversedDay - day;
            }

            if (difference % k == 0) {
                beautifulDaysCount++;
            }
        }

        return beautifulDaysCount;
    }

    public static void main(String[] args) {
        System.out.println("El primer día siempre debe ser menor al segundo día");
        int i = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor del primer día (i): "));
        int j = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor del segundo día (j): "));
        int k = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor del número divisor (k): "));

        int dias = beautifulDays(i, j, k);
        System.out.println("Número de días bellos: " + dias);
    }

}
