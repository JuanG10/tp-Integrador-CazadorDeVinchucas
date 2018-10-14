package clases;

import interfaces.IUsuarios;

public abstract class Organizacion implements IUsuarios{

	private String alias;
	private Ubicacion ubicacion;
	private Integer cantPersonas;
}
