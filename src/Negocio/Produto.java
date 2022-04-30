package Negocio;

import Apresentacao.TelaAlerta;
import DTOs.ProdutosDTO;
import Persistencia.Produtos;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Produto {

    public static ArrayList<ProdutosDTO> RetornaProdutos() {
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

    public static void Excluir(Integer id) {
        if (id == 0) {
            JPanel alerta = new TelaAlerta("Id nulo.");
            alerta.setVisible(true);
            return;
        }
        
        if (!Produtos.ExcluirProduto(id)) {
            JPanel alerta = new TelaAlerta("Erro ao excluir o produto.");
            alerta.setVisible(true);
        }
    }
    
    public static void Alterar(Integer id, String descricao, int valor) {
        if (id == 0) {
            JPanel alerta = new TelaAlerta("Id nulo.");
            alerta.setVisible(true);
            return;
        }
        
        if (descricao.isBlank()) {
            JPanel alerta = new TelaAlerta("Descrição inválida.");
            alerta.setVisible(true);
            return;
        }
        
        if (!Produtos.Alterar(id, descricao, valor )) {
                JPanel alerta = new TelaAlerta("Erro ao alterar o produto.");
                alerta.setVisible(true);
            }
    }
}
