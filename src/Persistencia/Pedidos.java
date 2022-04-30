package Persistencia;

import DTOs.PedidosDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Pedidos {

    public static boolean SalvarPedido(int id, int quantidade, int idDoUsuario) {
        String query = "insert into pedidos "
                + "(id_usuario, id_produto, quantidade, data_do_pedido) "
                + " values "
                + "("
                + idDoUsuario + ", "
                + id + ", "
                + quantidade + ","
                + "now())";
        try ( Statement stmt = ConexaoPostgres.CriaConexao()) {

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static ArrayList<PedidosDTO> PedidosDoUsuario(int idDoUsuario) {
        ArrayList<PedidosDTO> pedidos = new ArrayList();
        String query = "select pedidos.id,"
                + "       produtos.descricao, "
                + "       pedidos.quantidade, "
                + "       pedidos.quantidade * produtos.preco preco, "
                + "       pedidos.data_do_pedido data"
                + "  from pedidos, produtos"
                + " where pedidos.id_produto = produtos.id"
                + "   and pedidos.id_usuario = " + idDoUsuario
                + " order by 1";
        try ( Statement stmt = ConexaoPostgres.CriaConexao();  ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                PedidosDTO pedidosdto = new PedidosDTO();
                pedidosdto.id = rs.getInt("id");
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

    public static boolean ExcluirPedido(Integer id) {
        String query = "delete from pedidos"
                + " where id = " + id;
        try ( Statement stmt = ConexaoPostgres.CriaConexao()) {

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static boolean AlterarPedido(Integer id, Integer id_produto, Integer quantidade) {
        String query = "update pedidos"
                + "        set id_produto = " + id_produto + ","
                + "            quantidade = " + quantidade + ","
                + "            data_do_pedido = now()"
                + "      where id = "+id;
        try ( Statement stmt = ConexaoPostgres.CriaConexao()) {

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
