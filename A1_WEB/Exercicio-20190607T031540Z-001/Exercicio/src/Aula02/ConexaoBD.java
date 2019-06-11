package Aula03;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
   static {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
   }
    catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
   }
 }
    public Connection conectar() throws SQLException {
       String servidor = "localhost";
       String porta = "3306";
       String database = "Paises";
       String usuario = "Alunos";
       String senha = "alunos";
       return DriverManager
          .getConnection("jdbc:mysql://localhost:3306/Paises?useTimezone=true&serverTimezone=America/Sao_Paulo",usuario,senha);
    }
}
