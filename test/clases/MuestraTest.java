package clases;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.awt.image.BufferedImage;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

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
		//REVISAR


}
