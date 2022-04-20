package Persistencia;

import DTOs.PedidosDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Pedidos {

    public static boolean SalvarPedido(int index, int quantidade, int idDoUsuario) {
        String query = "insert into pedidos "
                + "(id_usuario, id_produto, quantidade, data_do_pedido) "
                + " values "
                + "("
                + idDoUsuario + ", "
                + index + ", "
                + quantidade + ","
                + "now())";
        try (Statement stmt = ConexaoPostgres.CriaConexao()) {

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static ArrayList<PedidosDTO> PedidosDoUsuario(int idDoUsuario) {
        ArrayList<PedidosDTO> pedidos = new ArrayList();
        String query = "select produtos.descricao, "
                + "       pedidos.quantidade, "
                + "       pedidos.quantidade * produtos.preco preco, "
                + "       pedidos.data_do_pedido data"
                + "  from pedidos, produtos"
                + " where pedidos.id_produto = produtos.id"
                + "   and pedidos.id_usuario = " + idDoUsuario;
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                PedidosDTO pedidosdto = new PedidosDTO();
                pedidosdto.descricao = rs.getString("descricao");
                pedidosdto.quantidade = rs.getInt("quantidade");
                pedidosdto.preco = rs.getInt("preco");
                pedidosdto.data_do_pedido = rs.getDate("data");
                pedidos.add(pedidosdto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pedidos;
    }
}
