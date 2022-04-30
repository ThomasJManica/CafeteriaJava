package Persistencia;

import DTOs.ProdutosDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Produtos {

    public static ArrayList<ProdutosDTO> RetornaProdutos() {
        ArrayList<ProdutosDTO> produtos = new ArrayList();
        String query = "select id, descricao, preco"
                + "  from produtos "
                + " order by 1";
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
               ProdutosDTO produtosDTO = new ProdutosDTO();
               produtosDTO.id = rs.getInt("id");
                produtosDTO.descricao = rs.getString("descricao");
                produtosDTO.preco = rs.getInt("preco");
                produtos.add(produtosDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return produtos;
    }

    public static boolean SalvarProduto(String descricao, int valor) {
        String query = "insert into produtos "
                + "(descricao, preco)"
                + "values "
                + "('"
                + descricao + "', "
                + valor + ")";
        try (Statement stmt = ConexaoPostgres.CriaConexao()) {

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public static boolean ExcluirProduto(Integer id) {
        String query = "delete from produtos"
                + " where id = " + id;
        try (Statement stmt = ConexaoPostgres.CriaConexao()) {

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public static boolean Alterar(Integer id, String descricao, Integer valor) {
        String query = "update produtos"
                + "        set descricao = '" + descricao + "',"
                + "            preco = " + valor
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
