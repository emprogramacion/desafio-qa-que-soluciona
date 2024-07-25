/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador.de.senhas.solução.em.java;

/**
 *
 * @author Erasmo Martinez
 */
import java.util.Arrays;
import java.util.List;

public class VerificadorDeSenhasSoluçãoEmJava {

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        int n = loginAttempt.length();
        String[] dp = new String[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = null;
        }
        dp[0] = "";

        for (int i = 1; i <= n; i++) {
            for (String password : passwords) {
                int length = password.length();
                if (i >= length && dp[i - length] != null && loginAttempt.substring(i - length, i).equals(password)) {
                    if (dp[i - length].isEmpty()) {
                        dp[i] = password;
                    } else {
                        dp[i] = dp[i - length] + " " + password;
                    }
                    break;
                }
            }
        }
        if (dp[n] != null) {
            return dp[n];
        } else {
            return "WRONG PASSWORD";
        }
    }

    public static void main(String[] args) {
        System.out.println(passwordCracker(Arrays.asList("because", "can", "do", "must", "we", "what"), "wedowhatwemustbecausewecan"));
        System.out.println(passwordCracker(Arrays.asList("hello", "planet"), "helloworld"));
        System.out.println(passwordCracker(Arrays.asList("ab", "abcd", "cd"), "abcd"));
        System.out.println(passwordCracker(Arrays.asList("ozkxyhkcst", "xvglh", "hpdnb", "zfzahm"), "zfzahm"));
        System.out.println(passwordCracker(Arrays.asList("gurwgrb", "maqz", "holpkhqx", "aowypvopu"), "gurwgrb"));
        System.out.println(passwordCracker(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", 
                "aaaaaaaaa", "aaaaaaaaaa"), "aaaaaaaaaab"));
        System.out.println(passwordCracker(Arrays.asList("ejevas", "drdv", "mgxucpnh", 
                "wqixbctfd", "kmmam", "kjquwvis", "liznldbnh", "pivoicfu", "espropqatm", "dbrasoqg"),
                "cfuwqixbctfdliznldbnhkmmamlsprmpqatmljevaskmmamwqixbctfdpivoicauwgixbctfdmgxucpnhejevasdrdvpivoicfuliznldbnh"));
        System.out.println(passwordCracker(Arrays.asList("okweif", "rpgnteja", "ufemijimuw", "vpon", "eoncaf", "udgf", "hhtez",
                "aiknzgy", "bpndljur", "eeycbwv"),"ufemijimuweeycbwvokweifvponbpndljurudgfaiknzgyhhtezufemijimuwufemijimuwai"
                        + "knzgyudgfufemijimuwrpgntejaeoncafvponudgfbpndljurokweifhhtezbpndljurvponufemijimuwu"
                        + "dgfbpndljurufemijimuweoncafrpgntejaudgf"));
    }
}
