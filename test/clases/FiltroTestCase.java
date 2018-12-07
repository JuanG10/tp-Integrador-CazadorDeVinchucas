package clases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.AND;
import clases.FiltroCompuesto;
import clases.FiltroSimple;
import clases.Muestra;
import clases.OR;
import interfaces.Filtro;
import interfaces.Operador;


class FiltroTestCase {
	List<Muestra> listaPrueba;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Filtro filtroSimple;
	Filtro filtroSimple2;
	Operador and;
	Operador or;
	Predicate<Muestra> p1;


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
		filtroSimple2 = new FiltroSimple(listaPrueba);
		and = new AND();
		or = new OR();
		
		when(muestra1.nivelDeVerificacion()).thenReturn("Medio");
		when(muestra2.nivelDeVerificacion()).thenReturn("Medio");
		when(muestra3.nivelDeVerificacion()).thenReturn("Alto");
		
		p1 = (m) -> m.nivelDeVerificacion().equals("Medio");
	}

	@Test
	void testFiltraUnaListaBasadaEnIgualdadDeTiposDeInsectosPasandoElParametroVinchucaYQuedaSoloLaMuestraTresQueConteniaEseBicho(){
		when(muestra1.tipoDeVinchuca()).thenReturn("Chinche");
		when(muestra2.tipoDeVinchuca()).thenReturn("Facu");
		when(muestra3.tipoDeVinchuca()).thenReturn("Vinchuca");
		
		Predicate<Muestra> p1 = (m) -> m.tipoDeVinchuca().equals("Vinchuca");
		
		assertEquals(1,filtroSimple.filtrar(p1).size());
	}
	
	@Test
	void testFiltraUnaListaBasadaEnSuFechaDeCreacionPasandoComoParametroLaFechaDeHoyYSoloQuedanLasMuestras2y3() {
		when(muestra1.fecha()).thenReturn(LocalDate.now().minusDays(19));
		when(muestra2.fecha()).thenReturn(LocalDate.now());
		when(muestra3.fecha()).thenReturn(LocalDate.now());
		
		Predicate<Muestra> p1 = (m) -> m.fecha().equals(LocalDate.now());
		
		assertEquals(2,filtroSimple.filtrar(p1).size());
	}
	
	@Test
	void testFiltraUnaListaBasadaEnSuNivelDeVerificacionPasandoComoParametroElStringMedioYSoloQuedanLasMuestras1y2() {
		assertEquals(2,filtroSimple.filtrar(p1).size());
	}
	
	@Test
	void testAlComponerUnFiltroSimpleConOtroSeCreaUnFiltroCompuestoConElOperadorANDYDevuelveUnaListaQueContieneTodosLosElementosEnComun() {
		assertEquals(2,filtroSimple.componer(filtroSimple2, and).filtrar(p1).size());
	}
	
	@Test
	void testSeCreaUnFiltroCompuestoSeLoComponeConUnoSimpleYLuegoSeLoFiltraPorNivelDeVerificacionMedioUsandoUnOperadorOR() {
		Filtro filtroCompuesto = new FiltroCompuesto(filtroSimple, or, filtroSimple2);
		
		assertEquals(6,filtroCompuesto.componer(filtroSimple, or).filtrar(p1).size());

	}


}
