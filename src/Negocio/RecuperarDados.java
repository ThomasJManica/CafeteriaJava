package Negocio;

import Apresentacao.TelaAlerta;
import Persistencia.Usuarios;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RecuperarDados {

    public static String RecuperarSenha(String usuario) {
        if (usuario.equals("")) {
            JPanel alerta = new TelaAlerta("Usuário inválido.");
            alerta.setVisible(true);
            return "";
        }

        String senha = Usuarios.RetornaSenhaPeloUsuario(usuario);

        if (senha.equals("")) {
            JPanel alerta = new TelaAlerta("Usuário inválido.");
            alerta.setVisible(true);
        }
        return senha;
    }

    public static String RecuperarUsuarios() {
        ArrayList<String> usuarios = Usuarios.RecuperaUsuarios();
        
        String usuariosRetorno = "Usuários cadastrados:\n";
        for (String usuario : usuarios) {
            String[] dadosUsuario = usuario.split(";");
            usuariosRetorno += dadosUsuario[0] + "\n";
        }
        return usuariosRetorno;
    }
}
