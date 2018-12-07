package clases;

import java.util.List;
import clases.Muestra;
import interfaces.Operador;

public class AND implements Operador {

	@Override
	public List<Muestra> resolver(List<Muestra> m1, List<Muestra> m2) {
		List<Muestra> lista = m1;
		lista.retainAll(m2);
		return lista;
	}

}
