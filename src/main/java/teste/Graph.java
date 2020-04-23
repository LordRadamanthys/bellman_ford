package teste;
// A Java program for Bellman-Ford's single source shortest path
// algorithm.

//A classe Relaxa as arestas até encontar a média de peso de cada vértice, além de montar o grafo e verificar se o mesmo possui um caminho com peso total negativo
class Graph {
//Cria as variáveis e o array
    int V, E;

    ;
//Insere o objeto edge em graph
    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
    Edge edge[];

//Classe que busca o menor caminho em um grafo e usa o peso como tomada de decisão
    void BellmanFord(Graph graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

//Inicializa o as distancias entres os vertices como sendo infinitas
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

//Relexa as arestas para verificar o caminho mais curto e com o menor peso entre os vértices
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
        printArr(dist, V, graph);
    }

//Cria o objeto array do grafo
    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    // A utility function used to print the solution
    void printArr(int[] dist, int V, Graph graph) {
        int aux = 0, verify = 0, j = 0, c = 0, fullWeight = 0;
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);


        System.out.print("\n\n 0\t");
        while (verify != graph.edge[7].dest) {
            if (graph.edge[j].src == verify && graph.edge[j].dest > verify) {
                if (c == 0 || j == 7) {
                    aux = graph.edge[j].dest;
                    c++;
                } else if (dist[aux] > graph.edge[j].weight || graph.edge[j].dest == graph.edge[7].dest) {
                    aux = graph.edge[j].dest;
                }

            } else if (c != 0) {
                System.out.print("\t===>\t" + aux);
                fullWeight += graph.edge[j].weight;
                verify = aux;
                c = 0;
                j = 0;
            }
            if (j < 7) {
                j++;
            } else {
                System.out.print("\t===>\t" + aux);
                fullWeight += graph.edge[j].weight;
                verify = aux;
            }
        }
        System.out.printf("\n\n\npeso: " + fullWeight);
    }

    // Driver method to test above function
    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 2;
        graph.edge[6].dest = 3;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 3;
        graph.edge[7].dest = 4;
        graph.edge[7].weight = -3;

        graph.BellmanFord(graph, 0);
    }
}