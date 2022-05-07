package Negocio;

import Apresentacao.TelaAlerta;
import DTOs.ProdutosDTO;
import Persistencia.Pedidos;
import javax.swing.JPanel;

public class PedidosUsuario {

    public static void FazerPedido(ProdutosDTO produto, int quantidade, int idDoUsuario) {
        if (quantidade <= 0) {
            TelaAlerta alerta = new TelaAlerta("Quantidade deve ser meior que zero");
            alerta.setVisible(true);
            return;
        }

        if (Pedidos.SalvarPedido(produto.id, quantidade, idDoUsuario)) {
            TelaAlerta alerta = new TelaAlerta("Pedido realizado com sucesso");
            alerta.setVisible(true);
        }
    }

    public static void Excluir(Integer id) {
        if (id == 0) {
            TelaAlerta alerta = new TelaAlerta("Id nulo.");
            alerta.setVisible(true);
            return;
        }
        if (!Pedidos.ExcluirPedido(id)) {
            TelaAlerta alerta = new TelaAlerta("Erro ao excluir o pedido.");
            alerta.setVisible(true);
        }
    }

    public static void Alterar(Integer id, ProdutosDTO produto, int quantidade) {
        if (id == 0 || id == null) {
            TelaAlerta alerta = new TelaAlerta("Id nulo.");
            alerta.setVisible(true);
            return;
        }

        if (produto == null) {
            TelaAlerta alerta = new TelaAlerta("Selecione um produto.");
            alerta.setVisible(true);
            return;
        }

        if (quantidade <= 0) {
            if (!Pedidos.ExcluirPedido(id)) {
                TelaAlerta alerta = new TelaAlerta("Erro ao excluir o pedido.");
                alerta.setVisible(true);
            }
            return;
        }

        if (!Pedidos.AlterarPedido(id, produto.id, quantidade)) {
            TelaAlerta alerta = new TelaAlerta("Erro ao alterar o pedido.");
            alerta.setVisible(true);
        }
    }
}
