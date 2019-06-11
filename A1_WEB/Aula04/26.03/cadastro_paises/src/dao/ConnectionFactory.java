package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String usuario = "Alunos", senha = "alunos",stringConexao = "jdbc:mysql://localhost:3306/Paises3?useTimezone=true&serverTimezone=UTC";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtém conexão com o banco de dados
	public static Connection getConnection() throws SQLException {
		return DriverManager
				.getConnection(stringConexao,usuario,senha);
	}
 
}
//"jdbc:mysql://localhost:port/bd_name?useTimezone=true&serverTimezone=UTC"