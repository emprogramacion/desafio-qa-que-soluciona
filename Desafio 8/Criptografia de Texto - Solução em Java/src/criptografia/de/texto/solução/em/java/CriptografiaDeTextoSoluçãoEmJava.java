/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia.de.texto.solução.em.java;

/**
 *
 * @author Erasmo Martinez
 */
public class CriptografiaDeTextoSoluçãoEmJava {

   public static String encryption(String s) {
        // Eliminar espacios del texto original
        s = s.replace(" ", "");
        int l = s.length();

        // Calcular el número de filas y columnas
        int filas = (int) Math.sqrt(l);
        int columnas = filas;

        // Ajustar el número de columnas si es necesario
        if (filas * columnas < l) {
            columnas++;
        }

        // Ajustar el número de filas si es necesario
        if (filas * columnas < l) {
            filas++;
        }

        // Crear una lista de strings para almacenar las columnas resultantes
        String[] listaColumnas = new String[columnas];
        for (int i = 0; i < columnas; i++) {
            listaColumnas[i] = "";
        }

        // Llenar las columnas con los caracteres correspondientes
        for (int i = 0; i < l; i++) {
            int columnaIndex = i % columnas;
            listaColumnas[columnaIndex] += s.charAt(i);
        }

        // Crear el resultado concatenando las columnas con espacios
        String resultado = "";
        for (int i = 0; i < columnas; i++) {
            if (i > 0) {
                resultado += " ";
            }
            resultado += listaColumnas[i];
        }

        return resultado;
    }
   
    public static void main(String[] args) {
        // Pruebas con las entradas proporcionadas
        System.out.println(encryption("haveaniceday")); // Salida esperada: "hae and via ecy"
        System.out.println(encryption("feedthedog"));  // Salida esperada: "fto ehg ee dd"
        System.out.println(encryption("chillout"));    // Salida esperada: "clu hlt io"
        System.out.println(encryption("iuo"));         // Salida esperada: "io u"
        System.out.println(encryption("wclwfoznbmyycxvaxagjhtexdkwjqhlojykopldsxesbbnezqmixfpujbssrbfhlgubvfhpfliimvmnny"));
        // Salida esperada: "wmgjpnull cyjqlejgi lyhhdzbui wctlsqsbm fxeoxmsvv ovxjeirfm zadysxbhn nxkkbffpn bawobphfy"
    }
    
}
