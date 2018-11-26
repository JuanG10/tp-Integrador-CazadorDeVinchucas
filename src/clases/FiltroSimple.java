package clases;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import interfaces.Filtro;
import interfaces.Operador;

public class FiltroSimple implements Filtro {
	private List<Muestra> listaMuestras;

	public FiltroSimple(List<Muestra> lista) {
		listaMuestras = lista;
	}

	@Override
	public Filtro componer(Filtro f, Operador op) {
		
		return new FiltroCompuesto(this,op,f);
	}
	
	@Override
	public List<Muestra> filtrar(Predicate<Muestra> parametroAComparar) {
		return listaMuestras.stream().filter(parametroAComparar).collect(Collectors.toList());
	}

}
