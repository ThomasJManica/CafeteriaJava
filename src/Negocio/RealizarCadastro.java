package Negocio;

import Ajudantes.Criptografia;
import Apresentacao.TelaAlerta;
import Persistencia.Usuarios;
import javax.swing.JPanel;

public class RealizarCadastro {

    public static boolean Cadastrar(String nome,
            String usuario,
            String senha,
            String confirmarSenha,
            String email) {

        if (Usuarios.UsuarioExiste(usuario)) {
            JPanel alerta = new TelaAlerta("Este nome de usuario já existe.");
            alerta.setVisible(true);
            return false;
        }

        if (!senha.equals(confirmarSenha)) {
            JPanel alerta = new TelaAlerta("Senhas não estão iguais.");
            alerta.setVisible(true);
            return false;
        }

        if (senha.equals("")
                || usuario.equals("")
                || email.equals("")
                || nome.equals("")) {
            JPanel alerta = new TelaAlerta("Campo nulo não permitido.");
            alerta.setVisible(true);
            return false;
        }

        Usuarios.Salvar(nome, usuario, Criptografia.criptografiaBase64Encoder(senha), email);
        return true;
    }

    public static boolean AlterarSenha(int idDoUsuario, String senhaAtual,
            String senhaNova,
            String confirmarSenha) {

        if (!senhaNova.equals(confirmarSenha)) {
            JPanel alerta = new TelaAlerta("Senhas não estão iguais.");
            alerta.setVisible(true);
            return false;
        }

        if (senhaAtual.equals("")
                || senhaNova.equals("")) {
            TelaAlerta alerta = new TelaAlerta("Campo nulo não permitido.");
            alerta.setVisible(true);
            return false;
        }

        if (!Usuarios.SenhaEhValida(idDoUsuario, Criptografia.criptografiaBase64Encoder(senhaAtual))) {
            JPanel alerta = new TelaAlerta("Senha incorreta.");
            alerta.setVisible(true);
            return false;
        }
        
        Usuarios.AlterarSenha(idDoUsuario, Criptografia.criptografiaBase64Encoder(senhaNova));
        return true;
    }
}
