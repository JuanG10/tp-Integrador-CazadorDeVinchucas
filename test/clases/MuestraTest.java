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
	private Insecto imagenPocoClara;
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
	private Insecto vinchuca;

	@Before
	public void setUp() throws Exception {
		fotoMock = mock(BufferedImage.class);
		ubicacionMock = mock(Ubicacion.class);
		imagenPocoClara = new Insecto("Imagen poco clara");
		fecha = LocalDate.now();
		usuarioMock = mock(Usuario.class);
		vinchuca = new Insecto("Vinchuca");
		
		when(usuarioMock.alias()).thenReturn("Jorge");
		
		muestraConMock = new Muestra(usuarioMock, ubicacionMock, imagenPocoClara, fecha, fotoMock);
		
		sistema = new SistemaWeb();
		usuarioBasico1 = new Usuario("Jorge", sistema);
		usuarioBasico2 = new Usuario("Juan", sistema, new ConocimientoBasico());
		usuarioBasico3 = new Usuario("Facu", sistema, new ConocimientoBasico());
		usuarioExperto = new Usuario("Jorge el experto", sistema, new ConocimientoExperto());
		usuarioEspecialista1 = new Usuario("Facu el especialista", sistema, new ConocimientoEspecialista());
		usuarioEspecialista2 = new Usuario("Juan el especialista", sistema, new ConocimientoEspecialista());
		muestra = new Muestra(usuarioBasico1, ubicacionMock, vinchuca, LocalDate.now(), fotoMock);
	}

	@Test
	public void testConstructorMuestra() {
		
		assertEquals(muestraConMock.fecha(), fecha);
		assertEquals(muestraConMock.fotoVinchuca(), fotoMock);
		assertEquals(muestraConMock.tipoDeVinchuca(), imagenPocoClara.tipoDeInsecto());
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
		
		usuarioBasico2.verificarMuestra(muestra, vinchuca);
		
		assertEquals("Medio", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosTieneNivelDeVerificacionAlto() {
		
		usuarioBasico2.verificarMuestra(muestra, vinchuca);
		usuarioBasico3.verificarMuestra(muestra, vinchuca);
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosQueEstanDeAcuerdoYUnoQueNoTieneNivelDeVerificacionMedio() {
		
		usuarioBasico2.verificarMuestra(muestra, vinchuca);
		usuarioBasico3.verificarMuestra(muestra, imagenPocoClara);
		
		assertEquals("Medio", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosUsuariosBasicosQueNoEstanDeAcuerdoTieneNivelDeVerificacionIndefinido() {
		
		usuarioBasico2.verificarMuestra(muestra, imagenPocoClara);
		
		assertEquals("Indefinido", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioExpertoTieneNivelDeVerificacionAlto() {
		
		usuarioExperto.verificarMuestra(muestra, vinchuca);
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorUnUsuarioEspecialistaTieneNivelDeVerificacionAlto() {
		
		usuarioEspecialista1.verificarMuestra(muestra, vinchuca);
		
		assertEquals("Alto", muestra.nivelDeVerificacion());
	}
	
	@Test
	public void unaMuestraVerificadaPorDosEspecialistasQueNoEstanDeAcuerdoTieneNivelDeVerificacionIndefinido() {
		
		
		usuarioEspecialista1.verificarMuestra(muestraConMock, vinchuca);
		usuarioEspecialista2.verificarMuestra(muestraConMock, imagenPocoClara);

		
		assertEquals("Indefinido", muestraConMock.nivelDeVerificacion());
	}




}
