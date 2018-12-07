package clases;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaWebTest {

	@BeforeEach
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
		
		assertEquals(resultadoEsperado, sistema.muestrasSegun(usuarioMock));
		
		
	}

}
