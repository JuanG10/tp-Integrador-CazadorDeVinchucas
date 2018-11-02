import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clases.ConocimientoBasico;
import clases.ConocimientoEspecialista;
import clases.ConocimientoExperto;
import clases.SistemaWeb;
import clases.Usuario;
import interfaces.NivelDeConocimiento;

import static org.mockito.Mockito.*;

class UsuarioTestCase {
	Usuario usEspecialista;
	Usuario usExperto;
	Usuario usBasico;
	NivelDeConocimiento nvlEsp;
	NivelDeConocimiento nvlExp;
	SistemaWeb sisWeb;

	@BeforeEach
	void setUp() throws Exception {
		nvlEsp = new ConocimientoEspecialista();
		nvlExp = new ConocimientoExperto();
		sisWeb = new SistemaWeb();
		usEspecialista = new Usuario("LJF",sisWeb,nvlEsp);
		usExperto = new Usuario("JLF",sisWeb,nvlExp);
		usBasico = new Usuario("FLJ",sisWeb);
	}

	@Test
	void testUnUsuarioRecienCreadoTieneNivelDeConocimientoBasico() {
		assertEquals(new ConocimientoBasico(),usBasico.nivelDeConocimiento());
	}
	
	@Test
	void testUnUsuarioInicializadoConConocimientoExpertoVuelveABasicoAlRealizarUnaAccion() {
		Muestra muestra = mock(Muestra.class);
	}

}
