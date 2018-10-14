package clases;

import interfaces.IInsecto;
import interfaces.IUsuarios;

public class Muestras {
	
	
	private IInsecto insecto;
	private Object foto;
	private Ubicacion ubicacion;
	private IUsuarios usuario;
	private String nivelDeVerificacion;

	public Muestras(IInsecto _insecto,Object _foto, Ubicacion _ubicacion, IUsuarios _usuario) {
		insecto = _insecto;
		foto = _foto;
		ubicacion = _ubicacion;
		usuario = _usuario;
		
	}
}
