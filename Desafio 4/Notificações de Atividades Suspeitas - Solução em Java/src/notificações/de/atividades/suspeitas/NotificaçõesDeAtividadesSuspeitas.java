/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificações.de.atividades.suspeitas;

import java.util.Arrays;

/**
 *
 * @author Erasmo Martinez
 */
public class NotificaçõesDeAtividadesSuspeitas {

    public static int activityNotifications(int[] despesas, int dias) {
        // Inicializa el contador de notificaciones.
        int notificacoes = 0;

        // Inicia el bucle en el primer día después de haber acumulado 'días' suficientes para comenzar el análisis.
        for (int i = dias; i < despesas.length; i++) {
            // Obtiene los datos de los gastos de los últimos 'días' hasta el día actual (sin incluirlo).
            int[] dados_antigos = Arrays.copyOfRange(despesas, i - dias, i);

            // Ordena los datos para facilitar el cálculo de la mediana.
            Arrays.sort(dados_antigos);
            // Calcula el tamaño de la lista ordenada.
            int n = dados_antigos.length;
            // Encuentra el índice del medio en la lista ordenada.
            int meio = n / 2;
            // Si el tamaño de la lista es impar, la mediana es el elemento del medio.
            double mediana;
            if (n % 2 == 1) {
                mediana = dados_antigos[meio];
                // Si el tamaño de la lista es par, la mediana es el promedio de los dos elementos del medio.
            } else {
                mediana = (dados_antigos[meio - 1] + dados_antigos[meio]) / 2.0;
            }

            // Verifica si el gasto actual es al menos el doble de la mediana calculada.
            if (despesas[i] >= 2 * mediana) {
                // Incrementa el contador de notificaciones si la condición es verdadera.
                notificacoes++;
            }
        }

        // Retorna el número total de notificaciones calculado.
        return notificacoes;
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));  // Salida: 2
        System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));  // Salida: 0
        System.out.println(activityNotifications(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 5));  // Salida: 1
        System.out.println(activityNotifications(new int[]{1, 2, 100, 2, 2, 2, 2, 2}, 4));  // Salida: 0
    }

}
