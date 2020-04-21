package layout;

import layout.controller.MainController;
//Método principal, função onde a aplicação tem inicio
public class RunnerUI {
    public static void main(String[] args) {
//O código indica que a função que controla a aplicação deve ser criada
        MainController mainController = new MainController();
//O código indica que a função Que exibe a tela deve ser usada, estando presente na classe criada anteriormente
        mainController.showScreen();
    }
}
