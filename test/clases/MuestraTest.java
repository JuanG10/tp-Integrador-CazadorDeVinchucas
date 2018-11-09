package clases;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.awt.image.BufferedImage;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MuestraTest {
	
	private BufferedImage fotoMock;
	private Ubicacion ubicacionMock;
	private String tipoDeVinchuca;
	private LocalDate fecha;
	private Usuario usuarioMock;
	private Muestra muestra;

	@Before
	public void setUp() throws Exception {
		fotoMock = mock(BufferedImage.class);
		ubicacionMock = mock(Ubicacion.class);
		tipoDeVinchuca = "Imagen poco clara";
		fecha = LocalDate.now();
		usuarioMock = mock(Usuario.class);
		
		when(usuarioMock.alias()).thenReturn("Jorge");
		
		muestra = new Muestra(usuarioMock, ubicacionMock, tipoDeVinchuca, fecha, fotoMock);
	}

	@Test
	public void testConstructorMuestra() {
		
		assertEquals(muestra.fecha(), fecha);
		assertEquals(muestra.fotoVinchuca(), fotoMock);
		assertEquals(muestra.tipoDeVinchuca(), tipoDeVinchuca);
		assertEquals(muestra.ubicacion(), ubicacionMock);
		assertEquals(muestra.aliasDeUsuario(), usuarioMock.alias());
		
	}
	
	@Test

	public void unaMuestraRecienCreadaTiene1Verificaciones() {
		
		assertEquals(new Integer(1), muestra.cantidadDeVerificaciones());
	}
	
	@Test
	public void unaMuestraNoPuedeTenerMasDeTresVerificaciones() {
		
		Verificacion verificacion1mock = mock(Verificacion.class);
		Verificacion verificacion2mock = mock(Verificacion.class);
		Verificacion verificacion3mock = mock(Verificacion.class);
		
		muestra.serVerificada(verificacion1mock);
		muestra.serVerificada(verificacion2mock);
		try {
			muestra.serVerificada(verificacion3mock);
		}catch(Exception e){
			Assert.assertEquals(e.getMessage(),"La muestra ya fue verificada tres veces");
			
		}
	}
	
	@Test
	public void unaMuestraRecienCreadaTieneNivelDeVerificacionBajo() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario = new Usuario("Jorge", sistema, new ConocimientoBasico());
		Muestra muestra = new Muestra(usuario, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		assertEquals("Bajo", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioBasicoTieneNivelDeVerificacionMedio() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario1 = new Usuario("Jorge", sistema, new ConocimientoBasico());
		Usuario usuario2 = new Usuario("Juan", sistema, new ConocimientoBasico());
		Muestra muestra = new Muestra(usuario1, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		usuario2.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Medio", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosTieneNivelDeVerificacionAlto() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario1 = new Usuario("Jorge", sistema, new ConocimientoBasico());
		Usuario usuario2 = new Usuario("Juan", sistema, new ConocimientoBasico());
		Usuario usuario3 = new Usuario("Facu", sistema, new ConocimientoBasico());
		Muestra muestra = new Muestra(usuario1, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		usuario2.verificarMuestra(muestra, "Vinchuca");
		usuario3.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosQueEstanDeAcuerdoYUnoQueNoTieneNivelDeVerificacionMedio() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario1 = new Usuario("Jorge", sistema, new ConocimientoBasico());
		Usuario usuario2 = new Usuario("Juan", sistema, new ConocimientoBasico());
		Usuario usuario3 = new Usuario("Facu", sistema, new ConocimientoBasico());
		Muestra muestra = new Muestra(usuario1, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		usuario2.verificarMuestra(muestra, "Vinchuca");
		usuario3.verificarMuestra(muestra, "Imagen poco clara");
		
		assertEquals("Medio", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosQueNoEstanDeAcuerdoTieneNivelDeVerificacionIndefinido() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario1 = new Usuario("Jorge", sistema, new ConocimientoBasico());
		Usuario usuario2 = new Usuario("Juan", sistema, new ConocimientoBasico());
		Muestra muestra = new Muestra(usuario1, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		usuario2.verificarMuestra(muestra, "Imagen poco clara");
		
		assertEquals("Indefinido", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioExpertoTieneNivelDeVerificacionAlto() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario1 = new Usuario("Jorge", sistema, new ConocimientoBasico());
		Usuario usuario2 = new Usuario("Juan", sistema, new ConocimientoExperto());
		Muestra muestra = new Muestra(usuario1, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		usuario2.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioEspecialistaTieneNivelDeVerificacionAlto() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario1 = new Usuario("Jorge", sistema, new ConocimientoBasico());
		Usuario usuario2 = new Usuario("Juan", sistema, new ConocimientoEspecialista());
		Muestra muestra = new Muestra(usuario1, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		usuario2.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosEspecialistasQueNoEstanDeAcuerdoTieneNivelDeVerificacionIndefinido() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuario1 = new Usuario("Jorge", sistema);
		Usuario usuario2 = new Usuario("Lucas", sistema, new ConocimientoEspecialista());
		Usuario usuario3 = new Usuario("aslkdjaslkdjlk", sistema, new ConocimientoEspecialista());
		Muestra muestra = new Muestra(usuario1, ubicacionMock, "Vinchuca", LocalDate.now(), fotoMock);
		
		usuario2.verificarMuestra(muestra, "Vinchuca");
		usuario3.verificarMuestra(muestra, "Imagen poco clara");

		
		assertEquals("Indefinido", muestra.nivelDeVerificacion());
	}




}
