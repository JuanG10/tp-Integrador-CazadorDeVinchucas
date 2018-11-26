package clases;

import java.util.List;
import java.util.function.Predicate;

import interfaces.Filtro;
import interfaces.Operador;

public class FiltroCompuesto implements Filtro {
	Filtro f1;
	Filtro f2;
	Operador op;

	public FiltroCompuesto(Filtro filtro, Operador op, Filtro f) {
		
		this.op = op;
		this.f1 = filtro;
		this.f2 = f;
	}

	@Override
	public Filtro componer(Filtro f, Operador op) {
	
		return new FiltroCompuesto(this, op, f);
	}

	@Override
	public List<Muestra> filtrar(Predicate<Muestra> parametro) {

		List<Muestra> lista1 = f1.filtrar(parametro);
		List<Muestra> lista2 = f2.filtrar(parametro);
		return op.resolver(lista1, lista2);
	}

}
