package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

public class ZonaDeCoberturaTest {
	
	private Ubicacion ubicacion;
	private ZonaDeCobertura zona;

	@BeforeEach
	public void setUp() throws Exception {
		ubicacion = new Ubicacion((double) 1, (double) 1);
		zona = new ZonaDeCobertura("Alta zona", ubicacion, (double) 100);
	}

	@Test
	public void unaZonaDeCoberturaTieneNombreEpicentroYDistanciaEnKilometros() {
	
		assertEquals("Alta zona", zona.nombre());
		assertEquals(ubicacion, zona.epicentro());
		assertEquals(new Double(100), zona.distancia());
	}
	
	@Test
	public void unaZonaDeCoberturaRecienCreadaNoTieneMuestrasReportadas() {
		
		assertTrue(zona.muestrasEnRango().isEmpty());
	}
	
	@Test
	public void unaZonaDeCoberturaRecienCreadaEnLaQueSeReportaUnaMuestraTieneUnaMuestraReportada() {
		
		Muestra muestra = mock(Muestra.class);
		zona.registrarMuestra(muestra);
		
		assertEquals(1, zona.muestrasEnRango().size());
	}
	
	@Test
	public void unaZonaDeCoberturaSolapaConSiMisma() {
		
		assertTrue(zona.solapaCon(zona));
	}
	
	@Test
	public void unaZonaDeCoberturaSolapaConOtraSiLaDistanciaEntreSusEpicentrosEsMenorALaSumaDeSusRadios() {
		
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		ZonaDeCobertura zonaA = new ZonaDeCobertura("Zona A", ubicacionA, (double) 500);
		
		Ubicacion ubicacionB = new Ubicacion((double) 3, (double) 3);
		ZonaDeCobertura zonaB = new ZonaDeCobertura("Zona B", ubicacionB, (double) 500);
		
		assertTrue(zonaA.solapaCon(zonaB));
	}
	
	@Test
	public void unaZonaDeCoberturaNoSeSolapaConOtra() {
		
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		ZonaDeCobertura zonaA = new ZonaDeCobertura("Zona A", ubicacionA, (double) 1);
		
		Ubicacion ubicacionB = new Ubicacion((double) 3, (double) 3);
		ZonaDeCobertura zonaB = new ZonaDeCobertura("Zona B", ubicacionB, (double) 1);
		
		assertFalse(zonaA.solapaCon(zonaB));
	}
	
	@Test
	public void unaZonaDeCoberturaNoPuedeTenerDistanciaCero() {
		
		try {
			ZonaDeCobertura zonaA = new ZonaDeCobertura("Zona A", mock(Ubicacion.class), (double) 0);
		} catch (Exception e) {
			assertEquals("No se puede instanciar una zona de cobertura con distancia cero", e.getMessage());
		}
	}
	
	@Test
	public void unaUnicaZonaEnUnSistemaSoloSolapaConsigoMisma() {
		
		SistemaWeb sistema = new SistemaWeb();
		
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		ZonaDeCobertura zonaA = new ZonaDeCobertura("Zona A", ubicacionA, (double) 500);
			
		sistema.registrarZonaDeCobertura(zonaA);
		
		assertEquals(1, zonaA.zonasQueSolapan().size());
	}
	
	@Test
	public void unaZonaDeCoberturaConoceAutomaticamenteAUnaZonaSolapadaQueIngresaASuSistema() {
		
		SistemaWeb sistema = new SistemaWeb();
		
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		ZonaDeCobertura zonaA = new ZonaDeCobertura("Zona A", ubicacionA, (double) 500);
		
		Ubicacion ubicacionB = new Ubicacion((double) 3, (double) 3);
		ZonaDeCobertura zonaB = new ZonaDeCobertura("Zona B", ubicacionB, (double) 500);
		
		sistema.registrarZonaDeCobertura(zonaA);
		sistema.registrarZonaDeCobertura(zonaB);
		
		assertEquals(2, zonaA.zonasQueSolapan().size());
	}
	
	@Test
	public void unaZonaDeCoberturaSuscribeAUnaOrganizacion() {
		
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		Organizacion organizacion = new Organizacion("Gubernamental", ubicacionA, 10);
		
		organizacion.registrarZonaDeCobertura(zona);
		
		assertEquals(1, zona.organizacionesSuscritas().size());
	}
	
	@Test
	public void unaZonaDeCoberturaDesuscribeAUnaOrganizacion() {
		
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		Organizacion organizacion = new Organizacion("Gubernamental", ubicacionA, 10);
		
		organizacion.registrarZonaDeCobertura(zona);
		organizacion.removerZonaDeCobertura(zona);
		
		assertEquals(0, zona.organizacionesSuscritas().size());
		
	}
	
	@Test
	public void unaZonaDeCoberturaNotificaAUnaOrganizacionDeUnaNuevaMuestra() {
		
		SistemaWeb sistema = new SistemaWeb();
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		ZonaDeCobertura zonaA = new ZonaDeCobertura("Zona A", ubicacionA, (double) 500);
		Organizacion organizacion = mock(Organizacion.class);
		doCallRealMethod().when(organizacion).registrarZonaDeCobertura(zonaA);
		
		sistema.registrarZonaDeCobertura(zonaA);
		organizacion.registrarZonaDeCobertura(zonaA);
			
		Muestra muestra = new Muestra(mock(Usuario.class), ubicacionA, new Insecto("Imagen poco clara"), LocalDate.now(), mock(BufferedImage.class));
		sistema.recibirMuestra(muestra);
		
		verify(organizacion, times(1)).nuevaMuestra(muestra);
		
	}
	
	@Test
	public void unaZonaDeCoberturaNotificaAUnaOrganizacionDeUnaMuestraValidada() {
		
		SistemaWeb sistema = new SistemaWeb();
		Usuario usuarioBasico = new Usuario("Jorge", sistema);
		Ubicacion ubicacionA = new Ubicacion((double) 0, (double) 0);
		ZonaDeCobertura zonaA = new ZonaDeCobertura("Zona A", ubicacionA, (double) 500);
		Organizacion organizacion = mock(Organizacion.class);
		doCallRealMethod().when(organizacion).registrarZonaDeCobertura(zonaA);
		
		sistema.registrarZonaDeCobertura(zonaA);
		organizacion.registrarZonaDeCobertura(zonaA);
			
		Muestra muestra = new Muestra(usuarioBasico, ubicacionA, new Insecto("Imagen poco clara"), LocalDate.now(), mock(BufferedImage.class));
		sistema.recibirMuestra(muestra);
		
		usuarioBasico.verificarMuestra(muestra, new Insecto("Imagen poco clara"));
		
		verify(organizacion, times(1)).muestraValidada(muestra);
		
	}
}
