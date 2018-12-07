package clases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.FuncionalidadExterna;

class OrganizacionTest {
	
	private Organizacion organizacion;
	private Ubicacion ubicacion;
	private SistemaWeb sistema;
	private Ubicacion ubicacionA;
	private ZonaDeCobertura zonaA;

	@BeforeEach
	void setUp() {
		ubicacion = new Ubicacion((double) 1, (double) 1);
		organizacion = new Organizacion("Gubernamental", ubicacion, 10);
		sistema = new SistemaWeb();
		ubicacionA = new Ubicacion((double) 0, (double) 0);
		zonaA = new ZonaDeCobertura("Zona A", ubicacionA, (double) 500);
	}

	@Test
	void unaOrganizacionTieneNombreTipoYCantidadDePersonas() {
		assertEquals("Gubernamental", organizacion.tipoDeOrganizacion());
		assertEquals(ubicacion, organizacion.ubicacion());
		assertEquals(new Integer(10), organizacion.cantidadDePersonas());
	}
	
	@Test
	void unaOrganizacionLlamaASuFuncionalidadExternaCuandoUnaNuevaMuestraEntraEnSusZonasRegistradas() {
		organizacion.setFuncionalidadExternaParaCarga(mock(FuncionalidadExterna.class));
		
		sistema.registrarZonaDeCobertura(zonaA);
		organizacion.registrarZonaDeCobertura(zonaA);
			
		Muestra muestra = new Muestra(mock(Usuario.class), ubicacionA, new Insecto("Imagen poco clara"), LocalDate.now(), mock(BufferedImage.class));
		sistema.recibirMuestra(muestra);
		
		verify(organizacion.getFuncionalidadExternaParaCarga(), times(1)).actuar();
	}
	
	@Test
	void unaOrganizacionLlamaASuFuncionalidadExternaCuandoUnaMuestraEnSusZonasRegistradasSeValida() {
		
		Usuario usuarioBasico = new Usuario("Jorge", sistema);
		organizacion.setFuncionalidadExternaParaCarga(mock(FuncionalidadExterna.class));
		organizacion.setFuncionalidadExternaParaValidacion(mock(FuncionalidadExterna.class));
		sistema.registrarZonaDeCobertura(zonaA);
		organizacion.registrarZonaDeCobertura(zonaA);
		Muestra muestra = new Muestra(usuarioBasico, ubicacionA, new Insecto("Imagen poco clara"), LocalDate.now(), mock(BufferedImage.class));
		sistema.recibirMuestra(muestra);
		
		usuarioBasico.verificarMuestra(muestra, new Insecto("Imagen poco clara"));
		
		verify(organizacion.getFuncionalidadExternaParaValidacion(), times(1)).actuar();
	}
}
