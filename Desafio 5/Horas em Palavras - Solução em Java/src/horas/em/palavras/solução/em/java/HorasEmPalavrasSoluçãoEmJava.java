/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horas.em.palavras.solução.em.java;

/**
 *
 * @author Erasmo Martinez
 */
public class HorasEmPalavrasSoluçãoEmJava {

    public static String timeInWords(int h, int m) {
        String[] nums = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen",
            "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
            "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine", "half"
        };

        if (m == 0) {
            return nums[h] + " o' clock";
        } else if (m <= 30) {
            if (m == 15 || m == 30) {
                return nums[m] + " past " + nums[h];
            } else if (m == 1) {
                return "one minute past " + nums[h];
            } else {
                return nums[m] + " minutes past " + nums[h];
            }
        } else {
            if (m == 45) {
                return "quarter to " + nums[(h % 12) + 1];
            } else if (m == 59) {
                return "one minute to " + nums[(h % 12) + 1];
            } else {
                return nums[60 - m] + " minutes to " + nums[(h % 12) + 1];
            }
        }
    }

    public static void main(String[] args) {
        // Pruebas
        System.out.println("5:00 -> " + timeInWords(5, 0));
        System.out.println("5:01 -> " + timeInWords(5, 1));
        System.out.println("5:10 -> " + timeInWords(5, 10));
        System.out.println("5:15 -> " + timeInWords(5, 15));
        System.out.println("5:28 -> " + timeInWords(5, 28));
        System.out.println("5:30 -> " + timeInWords(5, 30));
        System.out.println("5:40 -> " + timeInWords(5, 40));
        System.out.println("5:45 -> " + timeInWords(5, 45));
        System.out.println("5:47 -> " + timeInWords(5, 47));
        System.out.println("12:51 -> " + timeInWords(12, 51));
    }
}


