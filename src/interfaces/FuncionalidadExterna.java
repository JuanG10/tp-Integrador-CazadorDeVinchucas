package interfaces;

import clases.Muestra;
import clases.Organizacion;
import clases.ZonaDeCobertura;

public interface FuncionalidadExterna {

	public void nuevoEvento(Organizacion org, ZonaDeCobertura zona, Muestra muestra);

	public void actuar();
}
