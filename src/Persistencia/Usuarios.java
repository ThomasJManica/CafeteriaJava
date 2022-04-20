package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class Usuarios {

    public static void Salvar(String nome, String usuario,
            String senha, String email) {
        String query = "insert into usuarios "
                + "(nome, usuario, email, senha) "
                + " values "
                + "('"
                + nome + "', '"
                + usuario + "', '"
                + email + "', '"
                + senha + "')";
        try (Statement stmt = ConexaoPostgres.CriaConexao()) {

            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean UsuarioExiste(String usuario) {
        String query = "select count(usuario) quantidate"
                + "  from usuarios "
                + " where usuario = '" + usuario + "'";
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            if (rs.next()) {
                return rs.getInt("quantidate") > 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public static int RetornaIdDoUsuario(String usuario, String senha) {
        String query = "select id"
                + "  from usuarios "
                + " where usuario = '" + usuario
                + "'   and senha = '" + senha + "'";
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static String RetornaSenhaPeloUsuario(String usuario) {
        String query = "select senha"
                + "  from usuarios "
                + " where usuario = '" + usuario + "'";
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            if (rs.next()) {
                return rs.getString("senha");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public static ArrayList<String> RecuperaUsuarios() {
        ArrayList<String> usuarios = new ArrayList();
        String query = "select usuario"
                + "  from usuarios ";
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                usuarios.add(rs.getString("usuario"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return usuarios;
    }

    public static String RetornaUsuarioPelaSenha(String senha) {
        String query = "select usuario"
                + "  from usuarios "
                + " where senha = '" + senha + "'";
        try (Statement stmt = ConexaoPostgres.CriaConexao();
                ResultSet rs = stmt.executeQuery(query);) {

            if (rs.next()) {
                return rs.getString("usuario");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
