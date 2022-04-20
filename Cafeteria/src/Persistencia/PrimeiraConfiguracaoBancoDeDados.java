package Persistencia;

import Apresentacao.TelaAlerta;
import java.sql.Statement;
import javax.swing.JPanel;

public class PrimeiraConfiguracaoBancoDeDados {
    private final static String tabelas = "CREATE TABLE IF NOT EXISTS public.pedidos"
            + "("
            + "    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),"
            + "    id_usuario integer,"
            + "    id_produto integer,"
            + "    quantidade integer,"
            + "    data_do_pedido timestamp without time zone,"
            + "    CONSTRAINT pedidos_pkey PRIMARY KEY (id)"
            + ");"
            + "CREATE TABLE IF NOT EXISTS public.produtos"
            + "("
            + "    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),"
            + "    descricao character(50) COLLATE pg_catalog.\"default\","
            + "    preco numeric(6,2),"
            + "    CONSTRAINT produtos_pkey PRIMARY KEY (id)"
            + ");"
            + "CREATE TABLE IF NOT EXISTS public.usuarios"
            + "("
            + "    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),"
            + "    nome character varying(50) COLLATE pg_catalog.\"default\","
            + "    usuario character varying(50) COLLATE pg_catalog.\"default\","
            + "    email character varying(50) COLLATE pg_catalog.\"default\","
            + "    senha character varying(50) COLLATE pg_catalog.\"default\","
            + "    CONSTRAINT usuarios_pkey PRIMARY KEY (id)"
            + ")";

    public static boolean CriarConfig() {
        try (Statement stmt = ConexaoPostgres.CriaConexao()) {
            stmt.executeUpdate(tabelas);
        } catch (Exception e) {
            JPanel alerta = new TelaAlerta("Erro ao criar as configurações iniciais: \n" + e);
            alerta.setVisible(true);
            return false;
        }
        return true;
    }
}
