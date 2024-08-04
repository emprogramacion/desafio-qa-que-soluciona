/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra.menor.distância.em.grafos.solução.em.java;

import java.util.*;

/**
 *
 * @author Erasmo Martinez
 */
public class DijkstraMenorDistânciaEmGrafosSoluçãoEmJava {

    // Clase para representar una arista en el grafo
    static class Edge {

        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Función para encontrar las distancias más cortas usando el algoritmo de Dijkstra
    public static int[] shortestReach(int n, int[][] edges, int s) {
        // Inicializar el grafo usando una lista de adyacencia
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Llenar el grafo con las aristas proporcionadas
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // Inicializar las distancias con infinito
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        // Usar una cola de prioridad para obtener el nodo con la menor distancia estimada
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        pq.add(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.node;
            int currentDist = current.weight;

            // Explorar los vecinos del nodo actual
            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                // Si encontramos un camino más corto hacia el nodo vecino
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }

        // Preparar el resultado, reemplazando distancias no alcanzables por -1
        int[] result = new int[n - 1];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (i == s) {
                continue; // No incluir el nodo inicial en el resultado
            }
            result[index++] = (dist[i] == Integer.MAX_VALUE) ? -1 : dist[i];
        }

        return result;
    }

    public static void main(String[] args) {
        // Test 1
        int n1 = 4;
        int[][] edges1 = {{1, 2, 24}, {1, 4, 20}, {3, 1, 3}, {4, 3, 12}};
        int s1 = 1;
        System.out.println(Arrays.toString(shortestReach(n1, edges1, s1))); // [24, 3, 15]

        // Test 2
        int n2 = 5;
        int[][] edges2 = {{1, 2, 10}, {1, 3, 6}, {2, 4, 8}};
        int s2 = 2;
        System.out.println(Arrays.toString(shortestReach(n2, edges2, s2))); // [10, 16, 8, -1]

        // Test 3
        int n3 = 6;
        int[][] edges3 = {{1, 2, 7}, {1, 3, 9}, {1, 6, 14}, {2, 3, 10}, {2, 4, 15}, {3, 4, 11}, {3, 6, 2}, {4, 5, 6}, {5, 6, 9}};
        int s3 = 1;
        System.out.println(Arrays.toString(shortestReach(n3, edges3, s3))); // [7, 9, 20, 20, 11]

        // Test 4
        int n4 = 3;
        int[][] edges4 = {{1, 2, 1}, {2, 3, 1}};
        int s4 = 1;
        System.out.println(Arrays.toString(shortestReach(n4, edges4, s4))); // [1, 2]

        // Test 5
        int n5 = 4;
        int[][] edges5 = {{1, 2, 1}, {2, 3, 2}, {3, 4, 3}};
        int s5 = 2;
        System.out.println(Arrays.toString(shortestReach(n5, edges5, s5))); // [1, 2, 5]
    }
}
