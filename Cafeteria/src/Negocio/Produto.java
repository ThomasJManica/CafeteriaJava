package Negocio;

import Apresentacao.TelaAlerta;
import Persistencia.Produtos;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Produto {

    public static ArrayList<String> RetornaComidas() {
        return Produtos.RetornaProdutos();
    }

    public static void Salvar(String descricao, int valor) {
        if (descricao.equals("")
                || valor <= 0) {
            JPanel alerta = new TelaAlerta("Campo nulo não permitido.");
            alerta.setVisible(true);
            return;
        }

        if (Produtos.SalvarProduto(descricao, valor)) {
            JPanel alerta = new TelaAlerta("Produto salvo com sucesso.");
            alerta.setVisible(true);
        }
    }
}
