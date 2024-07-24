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
        int n = loginAttempt.length();  // Longitud del intento de inicio de sesión
        String[] dp = new String[n + 1];  // Array para almacenar la combinación de contraseñas usadas hasta cada posición
        Arrays.fill(dp, null);
        dp[0] = "";  // Inicializa la primera posición como cadena vacía, ya que no es necesario ninguna contraseña para formar una cadena vacía

        for (int i = 1; i <= n; i++) {  // Itera sobre cada posición de la cadena de intento de inicio de sesión
            for (String password : passwords) {  // Itera sobre cada contraseña en la lista de contraseñas
                int length = password.length();  // Longitud de la contraseña actual
                // Verifica si la posición actual es mayor o igual a la longitud de la contraseña,
                // si la combinación hasta la posición anterior es válida
                // y si la subcadena del intento de inicio de sesión corresponde a la contraseña actual
                if (i >= length && dp[i - length] != null && loginAttempt.substring(i - length, i).equals(password)) {
                    if (dp[i - length].isEmpty()) {  // Si la combinación hasta la posición anterior es una cadena vacía
                        dp[i] = password;  // Almacena la contraseña actual en dp[i]
                    } else {
                        dp[i] = dp[i - length] + " " + password;  // De lo contrario, concatena la contraseña actual a la combinación anterior con un espacio
                    }
                    break;  // Sale del bucle de contraseñas, ya que encontró una combinación válida para la posición actual
                }
            }
        }

        // Retorna la combinación de contraseñas usada para formar loginAttempt, o "WRONG PASSWORD" si no es posible formar la cadena
        return dp[n] != null ? dp[n] : "WRONG PASSWORD";
    }

    public static void main(String[] args) {
        // Pruebas
        System.out.println(passwordCracker(Arrays.asList("because", "can", "do", "must", "we", "what"), "wedowhatwemustbecausewecan"));  // Expected: "we do what we must because we can"
        System.out.println(passwordCracker(Arrays.asList("hello", "planet"), "helloworld"));  // Expected: "WRONG PASSWORD"
        System.out.println(passwordCracker(Arrays.asList("ab", "abcd", "cd"), "abcd")); //Expected: "ab cd" or "abcd"
        System.out.println(passwordCracker(Arrays.asList("ozkxyhkcst", "xvglh", "hpdnb", "zfzahm"), "zfzahm"));  // Expected: "zfzahm"
        System.out.println(passwordCracker(Arrays.asList("gurwgrb", "maqz", "holpkhqx", "aowypvopu"), "gurwgrb"));  // Expected: "gurwgrb"
        System.out.println(passwordCracker(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"), "aaaaaaaaaab"));  // Expected: "WRONG PASSWORD"
        System.out.println(passwordCracker(Arrays.asList("ejevas", "drdv", "mgxucpnh", "wqixbctfd", "kmmam", "kjquwvis", "liznldbnh", "pivoicfu", "espropqatm", "dbrasoqg"),
                "cfuwqixbctfdliznldbnhkmmamlsprmpqatmljevaskmmamwqixbctfdpivoicauwgixbctfdmgxucpnhejevasdrdvpivoicfuliznldbnh"));  // Expected: "WRONG PASSWORD"
        System.out.println(passwordCracker(Arrays.asList("okweif", "rpgnteja", "ufemijimuw", "vpon", "eoncaf", "udgf", "hhtez", "aiknzgy", "bpndljur", "eeycbwv"),
                "ufemijimuweeycbwvokweifvponbpndljurudgfaiknzgyhhtezufemijimuwufemijimuwaiknzgyudgfufemijimuwrpgntejaeoncafvponudgfbpndljurokweifhhtezbpndljurvponufemijimuwudgfbpndljurufemijimuweoncafrpgntejaudgf"));  // Expected: "ufemijimuw eeycbwv okweif vpon bpndljur udgf aiknzgy hhtez ufemijimuw ufemijimuw aiknzgy udgf ufemijimuw rpgnteja eoncaf vpon udgf bpndljur okweif hhtez bpndljur vpon ufemijimuw udgf bpndljur ufemijimuw eoncaf rpgnteja udgf"
    }
}
