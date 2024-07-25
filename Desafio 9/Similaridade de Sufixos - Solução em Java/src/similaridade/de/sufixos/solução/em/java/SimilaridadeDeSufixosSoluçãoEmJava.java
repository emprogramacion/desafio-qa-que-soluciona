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

    public static int similarity(String s) {
        int n = s.length();
        int totalSimilarity = 0;

        for (int i = 0; i < n; i++) {
            String suffix = s.substring(i);
            int similarity = calculateSimilarity(s, suffix);
            totalSimilarity += similarity;
        }

        return totalSimilarity;
    }

    private static int calculateSimilarity(String s, String suffix) {
        int maxLength = Math.min(s.length(), suffix.length());
        int similarityLength = 0;

        for (int i = 0; i < maxLength; i++) {
            if (s.charAt(i) == suffix.charAt(i)) {
                similarityLength++;
            } else {
                break;
            }
        }

        return similarityLength;
    }

    public static void main(String[] args) {
        // Teste 1
        String test1 = "ababaa";
        System.out.println("Teste 1: " + similarity(test1)); // Saída esperada: 11

        // Teste 2
        String test2 = "aa";
        System.out.println("Teste 2: " + similarity(test2)); // Saída esperada: 3

        // Teste 3
        String test3 = "abcabccba";
        System.out.println("Teste 3: " + similarity(test3)); // Saída esperada: 13

        // Teste 4
        String test4 = "eabdcbbeeedbdaebdedbcbdcdeeaebbdbedbdbccbaaeababba";
        System.out.println("Teste 4: " + similarity(test4)); // Saída esperada: 63

        // Teste 5
        String test5 = "bcdedeccaabdaebdddaeedabedccdddccbbaaadcbbabccbaadbbbeddecacddbababbabadcbbbacecdaee";
        System.out.println("Teste 5: " + similarity(test5)); // Saída esperada: 105

        // Teste 6
        String test6 = "aeccbdaadbcebddbadbaedeceedbcdaaadcbdebecaddedebccdbadaeed";
        System.out.println("Teste 6: " + similarity(test6)); // Saída esperada: 70
    }
}
