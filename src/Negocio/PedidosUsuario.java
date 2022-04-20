package Negocio;

import Apresentacao.TelaAlerta;
import Persistencia.Pedidos;
import javax.swing.JPanel;

public class PedidosUsuario {

    public static void FazerPedido(int index, int quantidade, int idDoUsuario) {
        if (quantidade <= 0) {
            JPanel alerta = new TelaAlerta("Quantidade deve ser meior que zero");
            alerta.setVisible(true);
            return;
        }
        
        index++;

        if (Pedidos.SalvarPedido(index, quantidade, idDoUsuario)) {
            JPanel alerta = new TelaAlerta("Pedido realizado com sucesso");
            alerta.setVisible(true);
        }
    }
}
