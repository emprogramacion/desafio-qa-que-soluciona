/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador.de.vales.solução.em.java;

/**
 *
 * @author Erasmo Martinez
 */
public class ContadorDeValesSoluçãoEmJava {

   public static int countingValleys(String path) {
        // Variable para controlar el nivel actual
        int level = 0;
        // Variable para controlar el número de valles recorridos
        int valleys = 0;
        // Variable para controlar si el caminante está en un valle
        boolean inValley = false;

        // Recorremos cada paso en el camino
        for (char step : path.toCharArray()) {
            // Si sube un nivel, suma 1 al nivel
            if (step == 'U') {
                level++;
            }
            // Si baja un nivel, resta 1 al nivel
            else if (step == 'D') {
                level--;
            }

            // Si el nivel es -1 significa que acaba de entrar en un valle
            if (level == -1) {
                // Establece la variable a true indicando que está en un valle
                inValley = true;
            }
            // Si el nivel es 0 y el caminante estaba en un valle
            else if (level == 0 && inValley) {
                // Cuenta un valle recorrido
                valleys++;
                // Establece la variable a false indicando que ya no está en un valle
                inValley = false;
            }
        }
        // Retorna el total de valles recorridos
        return valleys;
    }
    public static void main(String[] args) {
        System.out.println(countingValleys("DDUUDDUDUUUD"));  // Salida: 2
        System.out.println(countingValleys("UDUUUDUDDD"));    // Salida: 1
        System.out.println(countingValleys("DUDUDUDUDUDUDU")); // Salida: 7
        System.out.println(countingValleys("DDUUUUDDDUUUDDDU")); // Salida: 3
    }
    
}
