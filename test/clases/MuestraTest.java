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
	private Insectos tipoDeVinchuca;
	private LocalDate fecha;
	private Usuario usuarioMock;
	private Muestra muestraConMock;
	private SistemaWeb sistema;
	private Usuario usuarioBasico1;
	private Usuario usuarioBasico2;
	private Usuario usuarioBasico3;
	private Usuario usuarioExperto;
	private Usuario usuarioEspecialista1;
	private Usuario usuarioEspecialista2;
	private Muestra muestra;

	@Before
	public void setUp() throws Exception {
		fotoMock = mock(BufferedImage.class);
		ubicacionMock = mock(Ubicacion.class);
		tipoDeVinchuca = new Insectos("Imagen poco clara");
		fecha = LocalDate.now();
		usuarioMock = mock(Usuario.class);
		
		when(usuarioMock.alias()).thenReturn("Jorge");
		
		muestraConMock = new Muestra(usuarioMock, ubicacionMock, tipoDeVinchuca, fecha, fotoMock);
		
		sistema = new SistemaWeb();
		usuarioBasico1 = new Usuario("Jorge", sistema);
		usuarioBasico2 = new Usuario("Juan", sistema, new ConocimientoBasico());
		usuarioBasico3 = new Usuario("Facu", sistema, new ConocimientoBasico());
		usuarioExperto = new Usuario("Jorge el experto", sistema, new ConocimientoExperto());
		usuarioEspecialista1 = new Usuario("Facu el especialista", sistema, new ConocimientoEspecialista());
		usuarioEspecialista2 = new Usuario("Juan el especialista", sistema, new ConocimientoEspecialista());
		muestra = new Muestra(usuarioBasico1, ubicacionMock, tipoDeVinchuca, LocalDate.now(), fotoMock);
	}

	@Test
	public void testConstructorMuestra() {
		
		assertEquals(muestraConMock.fecha(), fecha);
		assertEquals(muestraConMock.fotoVinchuca(), fotoMock);
		assertEquals(muestraConMock.tipoDeVinchuca(), tipoDeVinchuca);
		assertEquals(muestraConMock.ubicacion(), ubicacionMock);
		assertEquals(muestraConMock.aliasDeUsuario(), usuarioMock.alias());
		
	}
	
	@Test

	public void unaMuestraRecienCreadaTiene1Verificaciones() {
		
		assertEquals(new Integer(1), muestraConMock.cantidadDeVerificaciones());
	}
	
	@Test
	public void unaMuestraNoPuedeTenerMasDeTresVerificaciones() {
		
		Verificacion verificacion1mock = mock(Verificacion.class);
		Verificacion verificacion2mock = mock(Verificacion.class);
		Verificacion verificacion3mock = mock(Verificacion.class);
		
		muestraConMock.serVerificada(verificacion1mock);
		muestraConMock.serVerificada(verificacion2mock);
		try {
			muestraConMock.serVerificada(verificacion3mock);
		}catch(Exception e){
			Assert.assertEquals(e.getMessage(),"La muestra ya fue verificada tres veces");
			
		}
	}
	
	@Test
	public void unaMuestraRecienCreadaTieneNivelDeVerificacionBajo() {
		
		assertEquals("Bajo", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioBasicoTieneNivelDeVerificacionMedio() {
		
		usuarioBasico2.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Medio", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosTieneNivelDeVerificacionAlto() {
		
		usuarioBasico2.verificarMuestra(muestra, "Vinchuca");
		usuarioBasico3.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosQueEstanDeAcuerdoYUnoQueNoTieneNivelDeVerificacionMedio() {
		
		usuarioBasico2.verificarMuestra(muestra, "Vinchuca");
		usuarioBasico3.verificarMuestra(muestra, "Imagen poco clara");
		
		assertEquals("Medio", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosQueNoEstanDeAcuerdoTieneNivelDeVerificacionIndefinido() {
		
		usuarioBasico2.verificarMuestra(muestra, "Imagen poco clara");
		
		assertEquals("Indefinido", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioExpertoTieneNivelDeVerificacionAlto() {
		
		usuarioExperto.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioEspecialistaTieneNivelDeVerificacionAlto() {
		
		usuarioEspecialista1.verificarMuestra(muestra, "Vinchuca");
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosEspecialistasQueNoEstanDeAcuerdoTieneNivelDeVerificacionIndefinido() {
		
		
		usuarioEspecialista1.verificarMuestra(muestraConMock, "Vinchuca");
		usuarioEspecialista2.verificarMuestra(muestraConMock, "Imagen poco clara");

		
		assertEquals("Indefinido", muestraConMock.nivelDeVerificacion());
	}




}
