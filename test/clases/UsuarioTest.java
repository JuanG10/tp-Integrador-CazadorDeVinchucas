package clases;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import interfaces.NivelDeConocimiento;

public class UsuarioTest {
	
	private String alias;
	private SistemaWeb sistema;
	private NivelDeConocimiento nivel;
	private Usuario usuario;

	@BeforeEach
	public void setUp() throws Exception {
		alias = "Jorge";
		sistema = mock(SistemaWeb.class);
		nivel = mock(NivelDeConocimiento.class);
		usuario = new Usuario(alias, sistema, nivel);
	}

	@Test
	public void testConstructorUsuario() {
		
		assertEquals(usuario.alias(), alias);
		assertEquals(usuario.nivelDeConocimiento(), nivel);
		assertEquals(usuario.sistemaWeb(), sistema);
	}
	
	@Test
	public void unUsuarioVerificaUnaMuestraYEstaSeAgregaASusMuestrasVerificadas() {
		
		Muestra muestraMock = mock(Muestra.class);
		Insectos vinchuca = new Insectos("Imagen poco clara");
		
		usuario.verificarMuestra(muestraMock, vinchuca);
		
		verify(muestraMock, times(1)).serVerificada(any(Verificacion.class));
		assertEquals(new Integer(1), usuario.cantidadDeMuestrasVerificadas());
	}

}
