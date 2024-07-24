/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package similaridade.de.sufixos.solução.em.java;

/**
 *
 * @author Erasmo Martinez
 */
public class SimilaridadeDeSufixosSoluçãoEmJava {

    // Método para calcular la similaridad entre un string y ses sufijos
    public static int similarity(String s) {
        int totalSimilarity = 0;
        int length = s.length();

        // Itera sobre cada caracter del string
        for (int i = 0; i < length; i++) {
            // Calcula la similaridad entre el string original e el sufijo que comienza en el índice i
            int similarity = calculateSimilarity(s, i);
            totalSimilarity += similarity;
        }

        return totalSimilarity;
    }

    // Método auxiliar para calcular la similaridad entre el string y un sufijo comenzando en el índice 'start'
    private static int calculateSimilarity(String s, int start) {
        int similarity = 0;
        int length = s.length();

        // Compara caracteres del string original com el sufijo hasta encontrar uno diferente
        for (int i = start, j = 0; i < length && j < length; i++, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                similarity++;
            } else {
                break;
            }
        }

        return similarity;
    }

    public static void main(String[] args) {
        String s1 = "ababaa";
        System.out.println("Similaridad de 'ababaa': " + similarity(s1)); // Salida esperada: 11

        String s2 = "aa";
        System.out.println("Similaridad de 'aa': " + similarity(s2)); // Salida esperada: 3

        String s3 = "abcabccba";
        System.out.println("Similaridad de 'abcabccba': " + similarity(s3)); // Salida esperada: 13

        String s4 = "eabdcbbeeedbdaebdedbcbdcdeeaebbdbedbdbccbaaeababba";
        System.out.println("Similaridad de 'eabdcbbeeedbdaebdedbcbdcdeeaebbdbedbdbccbaaeababba': " + similarity(s4)); // Salida esperada: 63

        String s5 = "bcdedeccaabdaebdddaeedabedccdddccbbaaadcbbabccbaadbbbeddecacddbababbabadcbbbacecdaee";
        System.out.println("Similaridad de 'bcdedeccaabdaebdddaeedabedccdddccbbaaadcbbabccbaadbbbeddecacddbababbabadcbbbacecdaee': " + similarity(s5)); // Salida esperada: 105

        String s6 = "aeccbdaadbcebddbadbaedeceedbcdaaadcbdebecaddedebccdbadaeed";
        System.out.println("Similaridad de 'aeccbdaadbcebddbadbaedeceedbcdaaadcbdebecaddedebccdbadaeed': " + similarity(s6)); // Salida esperada: 70
    }

}
