package layout.controller;
//import permite que voce possa usar um conjunto de outros códigos, presentes em outros locais para desempenhar funções especificas no código
import layout.ui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Adiciona variaveis e componentes ao código e inicia outros trechos de código
public class MainController {
    private MainFrame mainFrame;
    private JButton buttonAdd;
    private JTextArea textArea;
    private JTextField inputTextSRC;
    private JLabel labelExplain;
    private Graph graph;
    private int V = 5; // Number of vertices in graph
    private int E = 8; // Number of edges in graph
//Indica que o código execute as seguintes funções
    public MainController() {
        initComponents();
        initListenners();
    }
//Adiciona os componentes solicitados ao JFrame (interface grafica do Java)
    private void initComponents() {
        mainFrame = new MainFrame();
        labelExplain = mainFrame.getLabelExplain();
        buttonAdd = mainFrame.getButtonAdd();
        inputTextSRC = mainFrame.getInputTextSRC();
        textArea = mainFrame.getTextArea();
//Cria o Objeto graph
        graph = new Graph(V, E);
//Indica que o código deve executar a função de criação das arestas
        loadGraph();
    }
//Torna a interface grafica visível
    public void showScreen() {
        mainFrame.setVisible(true);
    }
//Inicializa a função que espera um evento de clique em um botão para excutar uma função
    private void initListenners() {
        buttonAdd.addActionListener(new ButtonAddListenner());
    }

    //Adicionando as arestas(caminhos entre os vértices), onde src é o vértice emergente, dest é o vértice incidente e weight é o peso de cada aresta, dentro de um Array
    private void loadGraph() {
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].src = 2;
        graph.edge[6].dest = 3;
        graph.edge[6].weight = 1;

        graph.edge[7].src = 3;
        graph.edge[7].dest = 4;
        graph.edge[7].weight = -3;
    }

//Ação de clique do do botão, quando o botão for pressionado os comandos inseridos dentro do bloco de código são executados
    private class ButtonAddListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
//Cria uma nova variável
            int end;
//O código indica que o texto deve estar vazio naquela parte da tela
            textArea.setText("");
//try é um bloco que trata erros, se o campo for enviado sem preencher é enviado um valor default para a outra função
            try {
                end = Integer.parseInt(inputTextSRC.getText());
            } catch (Exception e) {
                end = 4;
            }
//Exibe no local indicado qual o valor que o usuário  digitou para ser buscado a aresta
            textArea.append("Ultima aresta = " + end + "\n\n");
//O código manda ser executado a classe BellmanFord, e pede para que use os objetos e variaveis enviadas (O que está dentro do parênteses)
            graph.BellmanFord(graph, 0, textArea, end);
//Limpa o campo de texto que o usuário acabou de digitar e enviar
            inputTextSRC.setText("");

        }
    }


}
