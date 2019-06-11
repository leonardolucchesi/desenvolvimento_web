package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaisesDAO {

	public void inserir(PaisesTO to) throws SQLException {
		String sql = "INSERT INTO Paises (id, nome, populacao,area) VALUES (?, ? ,?,?)";

		Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, to.getId());
		ps.setString(2, to.getNome());
		ps.setLong(3, to.getPopulacao());
		ps.setDouble(4, to.getArea());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void deletar(PaisesTO to) throws SQLException {
		String sql = "DELETE INTO Paises (id, nome, populacao,area) VALUES (?, ? ,?,?)";

		Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, to.getId());
		ps.setString(2, to.getNome());
		ps.setLong(3, to.getPopulacao());
		ps.setDouble(4, to.getArea());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void atualizar(PaisesTO to) throws SQLException {
		String sql = "UPDATE Paises SET populacao = ?, area = ? WHERE id = ?";

		Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setLong(1, to.getPopulacao());
		ps.setDouble(2, to.getArea());
		ps.setInt(3, to.getId());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void selecionar(PaisesTO to) throws SQLException {
		String sql = "SELECT * FROM Paises";

		Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, to.getId());
		ps.setString(2, to.getNome());
		ps.setLong(3, to.getPopulacao());
		ps.setDouble(4, to.getArea());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void maiorPopulacao(PaisesTO to) throws SQLException {
		String sql = "SELECT MAX(populacao)FROM Paises";

		Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}

	public void menorPopulacao(PaisesTO to) throws SQLException {
		String sql = "SELECT MIN(populacao)FROM Paises";

		Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}

	public void tresPaises(PaisesTO to) throws SQLException {
		String sql = "SELECT * FROM Paises LIMIT 3";

		Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}

}
