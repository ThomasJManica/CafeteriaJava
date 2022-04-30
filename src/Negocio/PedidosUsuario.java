package Negocio;

import Apresentacao.TelaAlerta;
import DTOs.ProdutosDTO;
import Persistencia.Pedidos;
import javax.swing.JPanel;

public class PedidosUsuario {

    public static void FazerPedido(ProdutosDTO produto, int quantidade, int idDoUsuario) {
        if (quantidade <= 0) {
            JPanel alerta = new TelaAlerta("Quantidade deve ser meior que zero");
            alerta.setVisible(true);
            return;
        }
        
        if (Pedidos.SalvarPedido(produto.id, quantidade, idDoUsuario)) {
            JPanel alerta = new TelaAlerta("Pedido realizado com sucesso");
            alerta.setVisible(true);
        }
    }
    
    public static void Excluir(Integer id) {
        if (id == 0) {
            JPanel alerta = new TelaAlerta("Id nulo.");
            alerta.setVisible(true);
        }
        if (!Pedidos.ExcluirProduto(id)) {
            JPanel alerta = new TelaAlerta("Erro ao excluir o pedido.");
            alerta.setVisible(true);
        }
    }
}
