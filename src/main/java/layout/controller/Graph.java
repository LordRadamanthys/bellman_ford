package layout.controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
//A Classe abaixo usa a lógica para achar o menor caminho em um grafo se baseando em um peso pré-definido de cada aresta e calcula o peso de cada vértice.
// A class to represent a connected, directed and weighted graph
class Graph {
    // A class to represent a weighted edge in graph
    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    int V, E;
    Edge edge[];

    // Creates a graph with V vertices and E edges
    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // The main function that finds shortest distances from src
    // to all other vertices using Bellman-Ford algorithm. The
    // function also detects negative weight cycle
    void BellmanFord(Graph graph, int src, JTextArea textArea, int end) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        printArr(dist, V, graph,textArea, end);
    }

    // A utility function used to print the solution
    void printArr(int[] dist, int V, Graph graph, JTextArea textArea, int end) {
        int aux = 0, verify = 0, j = 0, c = 0, fullWeight = 0;
        List way = new ArrayList<>();

        while (verify != end) {
            if (graph.edge[j].src == verify && graph.edge[j].dest > verify) {
                if (c == 0 || j == 7) {
                    aux = graph.edge[j].dest;
                    c++;
                } else if (dist[aux] > graph.edge[j].weight || graph.edge[j].dest == end) {
                    aux = graph.edge[j].dest;
                }

            } else if (c != 0) {
                way.add(aux);
                fullWeight += graph.edge[j].weight;
                verify = aux;
                c = 0;
                j = 0;
            }
            if (j < 7) {
                j++;
            } else {
                way.add(aux);
                fullWeight += graph.edge[j].weight;
                verify = aux;
            }
        }
        if(fullWeight >= 0) {
            textArea.append("0");
            for (Object o : way) {
                textArea.append("\t===>\t" + o);
            }
            textArea.append("\n\n\npeso: " + fullWeight);
        }else{
            textArea.append("O Grafo posssui um ciclo negativo!");
        }
    }
}