package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoConexao {

	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:postgresql://localhost/db_scv";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "positivo";

	public static Connection getConexao() {
		if (conexao == null) {
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			} catch (SQLException ex) {
//				ex.printStackTrace();
				Logger.getLogger(BancoConexao.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex) {
//				ex.printStackTrace();
				Logger.getLogger(BancoConexao.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
		return conexao;
	}

	public static void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
				conexao = null;
			} catch (SQLException ex) {
				Logger.getLogger(BancoConexao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
