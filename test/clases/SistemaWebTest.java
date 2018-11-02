package clases;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SistemaWebTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void unSistemaWebRetornaLasMuestrasDeUnUsuario() {
		SistemaWeb sistema = new SistemaWeb();
		
		Usuario usuarioMock = mock(Usuario.class);
		Muestra muestraMock = mock(Muestra.class);
		
		when(usuarioMock.alias()).thenReturn("Jorge");
		when(muestraMock.aliasDeUsuario()).thenReturn("Jorge");
		
		sistema.recibirMuestra(muestraMock);
		
		List<Muestra> resultadoEsperado = new ArrayList<>();
		resultadoEsperado.add(muestraMock);
		
		assertEquals(resultadoEsperado, sistema.muestras(usuarioMock));
		
		
	}

}
