package layout.controller;
//import permite que voce possa usar um conjunto de outros códigos, presentes em outros locais para desempenhar funções especificas no código
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
//A classe Relaxa as arestas até encontar a média de peso de cada vértice, além de montar o grafo e verificar se o mesmo possui um caminho com peso total negativo
class Graph {
//Cria as variáveis e o array
    int V, E;
//Insere o objeto edge em graph
    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
    Edge edge[];

//Metodo que busca o menor caminho em um grafo e usa o peso como tomada de decisão
    void BellmanFord(Graph graph, int src, JTextArea textArea, int end) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

//Loop que inicializao do array com as distancias entres os vertices como sendo infinitas, a posição do array é equivalente ao número do vertice e o valor contido dentro dele corresponde ao peso final do vertice
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
//Define o primeiro vertice não infinito.
        dist[src] = 0;

//Loop que relexa as arestas para verificar o caminho mais curto e com o menor peso entre os vértices, apartir do primeiro vértice não infinito
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
//Chamando a função que valida o peso total do caminho e o exibe
        printArr(dist, graph,textArea, end);
    }

//Cria a função que valida se o caminho é negativo, e que exibe ocaminho caso ele seja positivo
    void printArr(int[] dist, Graph graph, JTextArea textArea, int end) {
//Cria variaveis
        int aux = 0, verify = 0, j = 0, c = 0, fullWeight = 0;
//Cria uma lista para armazenar os passos dado do ponto inicial até o último vértice (Valor inserido pelo usuário)
        List way = new ArrayList<>();
//Loop que busca um canho enquanto a variavel de verificação tiver um valor diferente do último vertice (Valor inserido pelo usuário)
        while (verify != end) {
//motor de decisão que verifica se existe um próximo vértice para avançar e por qual caminho deve ir (baseando-se no menor peso)
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
//Decisão do que vai ser exibido para o usuário
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

//Cria o objeto array do grafo
    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }
}