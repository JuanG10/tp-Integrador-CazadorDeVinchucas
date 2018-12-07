package clases;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import interfaces.NivelDeConocimiento;

public class UsuarioTest {
	
	private String alias;
	private SistemaWeb sistema;
	private NivelDeConocimiento nivel;
	private Usuario usuario;

	@Before
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
		Insecto vinchuca = new Insecto("Imagen poco clara");
		
		usuario.verificarMuestra(muestraMock, vinchuca);
		
		verify(muestraMock, times(1)).serVerificada(any(Verificacion.class));
		assertEquals(new Integer(1), usuario.cantidadDeMuestrasVerificadas());
	}

}
