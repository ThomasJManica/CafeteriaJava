package Persistencia;

import Apresentacao.TelaAlerta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;

public class ConexaoPostgres {

    private final static String URL = "jdbc:postgresql://localhost:5432/cafeteria";
    private final static String USER = "postgres";
    private final static String PASSWORD = "root";

    public static Statement CriaConexao() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            return con.createStatement();
        } catch (SQLException ex) {
            JPanel alerta = new TelaAlerta("Erro ao conectar com o banco de dados, informa o setor de TI reponsável: \n" + ex);
            alerta.setVisible(true);
        }
        return null;
    }
}
