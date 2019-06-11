package service;

import java.sql.SQLException;

import dao.PaisesDAO;
import model.Paises;

public class PaisesService {
	private PaisesDAO paiDAO = new PaisesDAO();

	public int inserir(Paises paises) throws SQLException {
		return paiDAO.inserir(paises);
	
	}

	public void deletar(Paises paises) throws SQLException {
		paiDAO.deletar(paises);
	}

	public void atualizar(Paises paises) throws SQLException {
		paiDAO.atualizar(paises);
	}

	public void selecionar(Paises paises) throws SQLException {
		paiDAO.selecionar(paises);
	}

	public void maiorPopulacao(Paises paises) throws SQLException {
		paiDAO.maiorPopulacao(paises);
	}

	public void menorPopulacao(Paises paises) throws SQLException {
		paiDAO.menorPopulacao(paises);
	}

	public void tresPaises(Paises paises) throws SQLException {
		paiDAO.tresPaises(paises);
	}
}