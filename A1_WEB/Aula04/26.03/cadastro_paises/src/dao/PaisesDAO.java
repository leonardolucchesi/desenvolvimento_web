package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paises;

public class PaisesDAO {

	public int inserir(Paises paises) throws SQLException {
		String sqlInsert = "INSERT INTO Paises(nome, populacao,area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, paises.getNome());
			stm.setLong(2, paises.getPopulacao());
			stm.setDouble(3, paises.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					paises.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paises.getId();
	}
 

	public void deletar(Paises paises) throws SQLException {
		String sql = "DELETE INTO Paises (id, nome, populacao,area) VALUES (?, ? ,?,?)";

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, paises.getId());
		ps.setString(2, paises.getNome());
		ps.setLong(3, paises.getPopulacao());
		ps.setDouble(4, paises.getArea());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void atualizar(Paises paises) throws SQLException {
		String sql = "UPDATE Paises SET populacao = ?, area = ? WHERE id = ?";

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setLong(1, paises.getPopulacao());
		ps.setDouble(2, paises.getArea());
		ps.setInt(3, paises.getId());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void selecionar(Paises paises) throws SQLException {
		String sql = "SELECT * FROM Paises";

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, paises.getId());
		ps.setString(2, paises.getNome());
		ps.setLong(3, paises.getPopulacao());
		ps.setDouble(4, paises.getArea());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void maiorPopulacao(Paises paises) throws SQLException {
		String sql = "SELECT MAX(populacao)FROM Paises";

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}

	public void menorPopulacao(Paises paises) throws SQLException {
		String sql = "SELECT MIN(populacao)FROM Paises";

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}

	public void tresPaises(Paises paises) throws SQLException {
		String sql = "SELECT * FROM Paises LIMIT 3";

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}

}