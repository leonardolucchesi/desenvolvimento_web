package Aula03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Paises {

	private int id;
	private String nome;
	private long populacao;
	private double area;

	public Paises(int id, String nome, long populacao, double area) {

		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}

	public Paises() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void inserir() throws SQLException {
		String sql = "INSERT INTO Paises (id, nome, populacao,area) VALUES (?, ? ,?,?)";
		ConexaoBD bd = new ConexaoBD();
		Connection conn = bd.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setLong(3, populacao);
		ps.setDouble(4, area);
		ps.execute();
		ps.close();
		conn.close();
	}

	public void deletar() throws SQLException {
		String sql = "DELETE INTO Paises (id, nome, populacao,area) VALUES (?, ? ,?,?)";
		ConexaoBD bd = new ConexaoBD();
		Connection conn = bd.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setLong(3, populacao);
		ps.setDouble(4, area);
		ps.execute();
		ps.close();
		conn.close();
	}
    
	public void atualizar() throws SQLException{
		String sql =  "UPDATE Paises SET populacao = ?, area = ? WHERE id = ?"; 
		ConexaoBD bd = new ConexaoBD();
		Connection conn = bd.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setLong(1, populacao);
		ps.setDouble(2, area);
		ps.setInt(3, id);
		ps.execute();
		ps.close();
		conn.close();
	}
	public void selecionar()throws SQLException{
		String sql= "SELECT * FROM Paises";
		ConexaoBD bd = new ConexaoBD();
		Connection conn = bd.conectar();
		PreparedStatement ps = conn.prepareStatement(sql); // PreparedStatement para preparar o comando
		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setLong(3, populacao);
		ps.setDouble(4, area);
		ps.execute();
		ps.close();
		conn.close();
	}
	public void maiorPopulacao()throws SQLException{
		String sql= "SELECT MAX(populacao)FROM Paises";
		ConexaoBD bd = new ConexaoBD();
		Connection conn = bd.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
    }
	public void menorPopulacao()throws SQLException{
		String sql= "SELECT MIN(populacao)FROM Paises";
		ConexaoBD bd = new ConexaoBD();
		Connection conn = bd.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}	
	public void tresPaises()throws SQLException{
		String sql= "SELECT * FROM Paises LIMIT 3";
		ConexaoBD bd = new ConexaoBD();
		Connection conn = bd.conectar();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		ps.close();
		conn.close();
	}
}	
