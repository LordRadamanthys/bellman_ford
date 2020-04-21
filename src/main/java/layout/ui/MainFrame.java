package layout.ui;
//import permite que voce possa usar um conjunto de outros códigos, presentes em outros locais para desempenhar funções especificas no código
import javax.swing.*;
//Classe que usa o componente JFrame(interface grafica do Java)
public class MainFrame extends JFrame {
//Cria os componentes

//Painel de componentes
    private JPanel mainFrame;
//Botão
    private JButton buttonAdd;
//Area para exibição de texto
    private JTextArea textArea;
//Area para o usuário adicionar um texto, algarismo...
    private JTextField inputTextSRC;
//Texto para ser exibido na tela
    private JLabel labelExplain;

//Adiciona um painel de componentes dentro do JFrame
    public MainFrame() {
        setSize(650, 500);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);
    }
//Inicializa os componentes e retorna-os quando forem solicitados
    public JTextField getInputTextSRC() {
        return inputTextSRC;
    }

    public JPanel getMainFrame() {
        return mainFrame;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JLabel getLabelExplain() {
        return labelExplain;
    }
}