package Class;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


class PaisesTest {

	private PaisesService pS;
	private PaisesTO fixturePaisesTO;
	
	@Before
	public void inserir() throws SQLException {
		fixturePaisesTO = new PaisesTO();
		fixturePaisesTO.setId(1);
		fixturePaisesTO.setNome("Romenia");
		fixturePaisesTO.setArea(321413);
		fixturePaisesTO.setPopulacao(2375687);
		pS.inserir(fixturePaisesTO);
	}
	@Test
	 public void testInsercao() throws SQLException {
		
		
	}
	

}
