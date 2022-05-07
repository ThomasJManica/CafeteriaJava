package Negocio;

import Ajudantes.Criptografia;
import Apresentacao.TelaAdmin;
import Apresentacao.TelaAlerta;
import Apresentacao.TelaUsuarios;
import Persistencia.Usuarios;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RealizarLogin {

    private static int idDoUsuario = 0;

    public static boolean Entrar(String usuario, String senha, int tentativas) {
        if (usuario.equals("")
                || senha.equals("")) {
            TelaAlerta alerta = new TelaAlerta("Usuário e/ou senha inválido.");
            alerta.setVisible(true);
            return false;
        }

        char existeOLogin = ExisteOLogin(usuario, Criptografia.criptografiaBase64Encoder(senha), tentativas);
        if (existeOLogin == 'N') {
            TelaAlerta alerta = new TelaAlerta("Usuário e/ou senha inválido.");
            alerta.setVisible(true);
            return false;
        }
        if (existeOLogin == 'U') {
            return false;
        }

        if (existeOLogin == 'A') {
            JFrame telaAdmin = new TelaAdmin();
            telaAdmin.setVisible(true);
        } else {
            JFrame telaUsuarios = new TelaUsuarios(idDoUsuario);
            telaUsuarios.setVisible(true);
        }
        return true;
    }

    private static char ExisteOLogin(String usuario, String senhaCriptografada, int tentativas) {
        idDoUsuario = Usuarios.RetornaIdDoUsuario(usuario, senhaCriptografada);
        if (idDoUsuario != 0) {
            if (usuario.equals("admin")) {
                return 'A';
            }
            return 'S';
        }

        if (tentativas == 3 && Usuarios.UsuarioExiste(usuario)) {
            String senhaCertaDoUsuario = Usuarios.RetornaSenhaPeloUsuario(usuario);
            TelaAlerta alerta = new TelaAlerta("Senha inválida de novo cara.\nSua senha é: " + senhaCertaDoUsuario + ".");
            alerta.setVisible(true);
            return 'U';
        }

        if (tentativas > 3 && Usuarios.UsuarioExiste(usuario)) {
            String senhaCertaDoUsuario = Usuarios.RetornaSenhaPeloUsuario(usuario);
            TelaAlerta alerta = new TelaAlerta("Não adianta falar contigo...\nSua senha é: " + senhaCertaDoUsuario + ".");
            alerta.setVisible(true);
            return 'U';
        }

        String usuarioDonoDaSenha = Usuarios.RetornaUsuarioPelaSenha(senhaCriptografada);

        if (!usuarioDonoDaSenha.equals("")) {
            TelaAlerta alerta = new TelaAlerta("Senha inválida.\nEssa senha é do usuário: " + usuarioDonoDaSenha + ".");
            alerta.setVisible(true);
            return 'U';
        }

        return 'N';
    }
}
