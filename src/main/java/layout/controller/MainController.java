package layout.controller;

import layout.ui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainFrame mainFrame;
    private JButton buttonAdd;
    private JTextArea textArea;
    private JTextField inputTextSRC;
    private JLabel labelExplain;
    private Graph graph;
    private int V = 5; // Number of vertices in graph
    private int E = 8; // Number of edges in graph

    public MainController() {
        initComponents();
        initListenners();
    }

    private void initComponents() {
        mainFrame = new MainFrame();
        labelExplain = mainFrame.getLabelExplain();
        buttonAdd = mainFrame.getButtonAdd();
        inputTextSRC = mainFrame.getInputTextSRC();
        textArea = mainFrame.getTextArea();

        graph = new Graph(V, E);
        loadGraph();
    }

    public void showScreen() {
        mainFrame.setVisible(true);
    }

    private void initListenners() {
        buttonAdd.addActionListener(new ButtonAddListenner());
    }

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

    private class ButtonAddListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int end;
            textArea.setText("");
            try {
                end = Integer.parseInt(inputTextSRC.getText());
            } catch (Exception e) {
                end = 4;
            }

            textArea.append("Ultima aresta = " + end + "\n");
            graph.BellmanFord(graph, 0, textArea, end);
            inputTextSRC.setText("");

        }
    }


}
