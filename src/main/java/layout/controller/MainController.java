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
    private Graph graph;
    private int V = 5; // Number of vertices in graph
    private int E = 8;

    public MainController() {
        initComponents();
        initListenners();
    }

    private void initComponents() {
        mainFrame = new MainFrame();
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
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
    }

    private class ButtonAddListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int src;
            textArea.setText("");
            try {
                src = Integer.parseInt(inputTextSRC.getText());
            } catch (Exception e) {
                src = 0;
            }
            int[] list = graph.BellmanFord(graph, src);
            textArea.append("Src = " + src + "\n");
            for (int i = 0; i < V; ++i) {
                // System.out.println(i + "\t\t" + list[i]);
                textArea.append(i + "     -     " + list[i] + "\n");

            }
            inputTextSRC.setText("");

        }
    }


}
