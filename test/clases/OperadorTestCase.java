package clases;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.AND;
import clases.Muestra;
import clases.OR;
import interfaces.Operador;

class OperadorTestCase {
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	List<Muestra> lista;
	List<Muestra> lista2;
	List<Muestra> listaPrueba;
	Operador and;
	Operador or;

	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		lista = new ArrayList<Muestra>();
		lista2 = new ArrayList<Muestra>();
		lista.add(muestra1);
		lista.add(muestra2);
		lista2.add(muestra2);
		lista2.add(muestra3);
		listaPrueba = new ArrayList<Muestra>();
		and = new AND();
		or = new OR();
	}
	
	@Test
	void testUnOperadorANDDevuelveLaIntereseccionEntreDosListasSiendoEstaSoloLaMuestra2() {
		listaPrueba.add(muestra2);
		
		assertTrue(listaPrueba.containsAll(and.resolver(lista, lista2)));
	}
	
	@Test
	void testUnOperadorORDevuelveLaUnionDeDosListasEstandoLasMuestrasDeLa1ALa3() {
		listaPrueba.add(muestra1);
		listaPrueba.add(muestra2);
		listaPrueba.add(muestra3);
		
		assertTrue(listaPrueba.containsAll(or.resolver(lista, lista2)));
	}



}
