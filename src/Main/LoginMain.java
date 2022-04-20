package Main;

import Apresentacao.TelaLogin;
import Persistencia.PrimeiraConfiguracaoBancoDeDados;
import javax.swing.JFrame;

public class LoginMain {

    public static void main(String[] args) {
        if(!PrimeiraConfiguracaoBancoDeDados.CriarConfig())
            System.exit(0);
        JFrame telaInicial = new TelaLogin();
        telaInicial.setVisible(true);
    }
}
