package clases;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

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
	public void unUsuarioEnviaUnaMuestraAlSistemaWebYEsteLaRecibe() {
		
		BufferedImage fotoMock = mock(BufferedImage.class);
		String tipoDeVinchuca = "Imagen poco clara";
		Ubicacion ubicacionMock = mock(Ubicacion.class);
		LocalDate fecha = LocalDate.now();
		
		usuario.enviarMuestra(fotoMock, tipoDeVinchuca, ubicacionMock, fecha);
		
		verify(sistema, times(1)).recibirMuestra(any(Muestra.class));
	}
	
	@Test
	public void unUsuarioVerificaUnaMuestraYEstaSeAgregaASusMuestrasVerificadas() {
		
		Muestra muestraMock = mock(Muestra.class);
		String tipoDeVinchuca = "Imagen poco clara";
		
		usuario.verificarMuestra(muestraMock, tipoDeVinchuca);
		
		verify(muestraMock, times(1)).serVerificada(any(Verificacion.class));
		assertEquals(new Integer(1), usuario.cantidadDeMuestrasVerificadas());
	}

}
