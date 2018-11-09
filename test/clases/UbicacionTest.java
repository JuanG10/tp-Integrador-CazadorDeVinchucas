package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UbicacionTest {

	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	
	@Before
	public void setUp() {
		ubicacion1 = new Ubicacion(3.0, 4.0);
		ubicacion2 = new Ubicacion(9.0, 5.0);
	}
	
	
	@Test
	public void testDeLaDistanciaEntreDosUbicaciones() {
		assertEquals( (Double) 676.263917774003, ubicacion1.distanciaCon(ubicacion2));
	}

}
