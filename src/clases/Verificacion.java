package clases;

public class Verificacion {
	private Usuario usuario;
	private Insectos tipoVinchuca;
	
	public Verificacion(Usuario usuario, Insectos tipoDeVinchuca) {
		this.usuario = usuario;
		this.tipoVinchuca = tipoDeVinchuca;
	}

	//GETTERS
	
	public Usuario usuario() {
		return usuario;
	}
	public String tipoVinchuca(){
		return tipoVinchuca.tipoDeInsecto();
	}

	public boolean esDefinitoria() {
		return usuario.esExpertoOEspecialista();
	}
}
