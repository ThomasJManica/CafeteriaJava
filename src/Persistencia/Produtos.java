package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Produtos {

    public static ArrayList<String> RetornaProdutos() {
        ArrayList<String> produtos = new ArrayList();
        String query = "select descricao"
                + "  from produtos ";
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                produtos.add(rs.getString("descricao"));
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
}
