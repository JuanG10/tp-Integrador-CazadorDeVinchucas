import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clases.ConocimientoBasico;
import clases.ConocimientoEspecialista;
import clases.ConocimientoExperto;
import clases.Muestra;
import clases.SistemaWeb;
import clases.Usuario;
import interfaces.NivelDeConocimiento;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class UsuarioTestCase {
	Usuario usEspecialista;
	Usuario usExperto;
	Usuario usBasico;
	NivelDeConocimiento nvlEsp;
	NivelDeConocimiento nvlExp;
	NivelDeConocimiento nvlBas;
	SistemaWeb sisWeb;
	Muestra muestra;

	@BeforeEach
	void setUp() throws Exception {
		nvlEsp = new ConocimientoEspecialista();
		nvlExp = new ConocimientoExperto();
		nvlBas = new ConocimientoBasico();
		sisWeb = mock(SistemaWeb.class);
		usEspecialista = new Usuario("LJF",sisWeb,nvlEsp);
		usExperto = new Usuario("JLF",sisWeb,nvlExp);
		usBasico = new Usuario("FLJ",sisWeb);
		muestra = mock(Muestra.class);
	}

	@Test
	void testUnUsuarioRecienCreadoTieneNivelDeConocimientoBasico() {
		assertEquals(nvlBas,usBasico.nivelDeConocimiento());
	}
	
	@Test
	void testUnUsuarioInicializadoConConocimientoExpertoVuelveABasicoAlRealizarUnaAccionYaQueNoParticipoEnLasMuestras() {
		
		assertEquals(nvlExp,usExperto.nivelDeConocimiento());
		usExperto.verificarMuestra(muestra, "ChincheFoliada");
		assertEquals(nvlBas,usExperto.nivelDeConocimiento());

	}
	
	@Test
	void testUnUsuarioRecienCreadoRealiza20VerificacionesY10EnviosYSeVueleExperto() {
	
		assertEquals(nvlBas,usBasico.nivelDeConocimiento());
		
		List<Muestra> listaMuestras = new ArrayList<Muestra>();
		
		for(int i = 0; i<=20; i++) {
			listaMuestras.add(i, muestra);
		}
		
		when(sisWeb.muestras(usBasico)).thenReturn((ArrayList<Muestra>) listaMuestras);
		
		for(int i = 0; i<=20; i++) {
			usBasico.verificarMuestra(listaMuestras.get(i), "ImagenPocoClara");
		}
		
		assertEquals(nvlExp,usBasico.nivelDeConocimiento());
	
	}

}
