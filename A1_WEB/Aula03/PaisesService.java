package Class;

import java.sql.SQLException;

public class PaisesService {
	private PaisesDAO paiDAO = new PaisesDAO();

	public void inserir(PaisesTO to) throws SQLException {
		paiDAO.inserir(to);
	}

	public void deletar(PaisesTO to) throws SQLException {
		paiDAO.deletar(to);
	}

	public void atualizar(PaisesTO to) throws SQLException {
		paiDAO.atualizar(to);
	}

	public void selecionar(PaisesTO to) throws SQLException {
		paiDAO.selecionar(to);
	}

	public void maiorPopulacao(PaisesTO to) throws SQLException {
		paiDAO.maiorPopulacao(to);
	}

	public void menorPopulacao(PaisesTO to) throws SQLException {
		paiDAO.menorPopulacao(to);
	}

	public void tresPaises(PaisesTO to) throws SQLException {
		paiDAO.tresPaises(to);
	}
}
