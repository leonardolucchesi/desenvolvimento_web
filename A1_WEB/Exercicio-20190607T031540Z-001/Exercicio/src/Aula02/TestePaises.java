package Aula03;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TestePaises {
	
	
	

	public static void main(String[] args) throws SQLException {
		Paises p = new Paises(6,"Azerbaijao", 3458673, 9327692);
		p.inserir();
		p.maiorPopulacao();
		p.menorPopulacao();
		p.tresPaises();

	
	}

}
