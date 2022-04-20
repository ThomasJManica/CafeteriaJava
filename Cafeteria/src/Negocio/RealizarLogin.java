package Negocio;

import Apresentacao.TelaAdmin;
import Apresentacao.TelaAlerta;
import Apresentacao.TelaRealizarPedidos;
import Persistencia.Usuarios;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RealizarLogin {

    private static int idDoUsuario = 0;

    public static boolean Entrar(String usuario, String senha, int tentativas) {
        if (usuario.equals("")
                || senha.equals("")) {
            JPanel alerta = new TelaAlerta("Usuário e/ou senha inválido.");
            alerta.setVisible(true);
            return false;
        }

        char existeOLogin = ExisteOLogin(usuario, senha, tentativas);
        if (existeOLogin == 'N') {
            JPanel alerta = new TelaAlerta("Usuário e/ou senha inválido.");
            alerta.setVisible(true);
            return false;
        }
        if (existeOLogin == 'U') {
            return false;
        }

        if (existeOLogin == 'A') {
            JFrame realizarPedidos = new TelaAdmin();
            realizarPedidos.setVisible(true);
        } else {
            JFrame realizarPedidos = new TelaRealizarPedidos(idDoUsuario);
            realizarPedidos.setVisible(true);
        }
        return true;
    }

    private static char ExisteOLogin(String usuario, String senha, int tentativas) {
        idDoUsuario = Usuarios.RetornaIdDoUsuario(usuario, senha);
        if (idDoUsuario != 0) {
            if (usuario.equals("admin")) {
                return 'A';
            }
            return 'S';
        }

        if (tentativas == 3 && Usuarios.UsuarioExiste(usuario)) {
            String senhaCertaDoUsuario = Usuarios.RetornaSenhaPeloUsuario(usuario);
            JPanel alerta = new TelaAlerta("Senha inválida de novo cara.\nSua senha é: " + senhaCertaDoUsuario + ".");
            alerta.setVisible(true);
            return 'U';
        }

        if (tentativas > 3 && Usuarios.UsuarioExiste(usuario)) {
            String senhaCertaDoUsuario = Usuarios.RetornaSenhaPeloUsuario(usuario);
            JPanel alerta = new TelaAlerta("Não adianta falar contigo...\nSua senha é: " + senhaCertaDoUsuario + ".");
            alerta.setVisible(true);
            return 'U';
        }

        String usuarioDonoDaSenha = Usuarios.RetornaUsuarioPelaSenha(senha);

        if (!usuarioDonoDaSenha.equals("")) {
            JPanel alerta = new TelaAlerta("Senha inválida.\nEssa senha é do usuário: " + usuarioDonoDaSenha + ".");
            alerta.setVisible(true);
            return 'U';
        }

        return 'N';
    }
}
