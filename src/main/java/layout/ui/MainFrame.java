package layout.ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel mainFrame;
    private JButton buttonAdd;
    private JTextArea textArea;
    private JTextField inputTextSRC;

    public MainFrame() {
        setSize(650, 500);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);
    }

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
}