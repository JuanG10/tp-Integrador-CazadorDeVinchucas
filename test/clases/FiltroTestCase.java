package clases;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.FiltroSimple;
import clases.Muestra;
import interfaces.Filtro;

class FiltroTestCase {
	List<Muestra> listaPrueba;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Filtro filtroSimple;

	@BeforeEach
	void setUp() throws Exception {
		listaPrueba = new ArrayList<Muestra>();
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		listaPrueba.add(muestra1);
		listaPrueba.add(muestra2);
		listaPrueba.add(muestra3);
		filtroSimple = new FiltroSimple(listaPrueba);
	}

	@Test
	void testFiltraUnaListaBasadaEnIgualdadDeTiposDeInsectosPasandoElParametroVinchucaYQuedaSoloLaMuestraTresQueConteniaEseBicho(){
		//Solo es una prueba, hay que ver como comparar clases que usen mensajes para compararse.
		when(muestra1.tipoDeVinchuca()).thenReturn("Chinche");
		when(muestra2.tipoDeVinchuca()).thenReturn("Facu");
		when(muestra3.tipoDeVinchuca()).thenReturn("Vinchuca");
		
		Predicate<Muestra> p1 = (m) -> m.tipoDeVinchuca().equals("Vinchuca");
		
		assertEquals(1,filtroSimple.filtrar(p1).size());
	}
	
	@Test
	void testFiltraUnaListaBasadaEnSuFechaDeCreacionPasandoComoParametroLaFechaDeHoyYSoloQuedanLasMuestras2y3() {
		//Solo es una prueba, hay que ver como comparar clases que usen mensajes para compararse.
		when(muestra1.fecha()).thenReturn(LocalDate.now().minusDays(19));
		when(muestra2.fecha()).thenReturn(LocalDate.now());
		when(muestra3.fecha()).thenReturn(LocalDate.now());
		
		Predicate<Muestra> p1 = (m) -> m.fecha().equals(LocalDate.now());
		
		assertEquals(2,filtroSimple.filtrar(p1).size());
	}
	
	@Test
	void testFiltraUnaListaBasadaEnSuNivelDeVerificacionPasandoComoParametroElStringMedioYSoloQuedanLasMuestras1y2() {
		//Solo es una prueba, hay que ver como comparar clases que usen mensajes para compararse.
		when(muestra1.nivelDeVerificacion()).thenReturn("Medio");
		when(muestra2.nivelDeVerificacion()).thenReturn("Medio");
		when(muestra3.nivelDeVerificacion()).thenReturn("Alto");
		
		Predicate<Muestra> p1 = (m) -> m.nivelDeVerificacion().equals("Medio");
		
		assertEquals(2,filtroSimple.filtrar(p1).size());
	}


}
