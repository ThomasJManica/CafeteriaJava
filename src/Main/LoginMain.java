package Main;

import Apresentacao.TelaLogin;
import Apresentacao.TelaSplash;
import Persistencia.PrimeiraConfiguracaoBancoDeDados;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class LoginMain {

    public static void main(String[] args) {
        if (!PrimeiraConfiguracaoBancoDeDados.CriarConfig()) {
            System.exit(0);
        }
        JFrame telaSplash = new TelaSplash();
        telaSplash.setVisible(true);
        try {  
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaSplash.setVisible(false);
        
        JFrame telaInicial = new TelaLogin();
        telaInicial.setVisible(true);
    }
}
