package clases;

public class Verificacion {
	private Usuario usuario;
	private Insectos insecto;
	
	public Verificacion(Usuario usuario, Insectos tipoDeVinchuca) {
		this.usuario = usuario;
		this.insecto = tipoDeVinchuca;
	}

	//GETTERS
	
	public Usuario usuario() {
		return usuario;
	}
	public String tipoVinchuca(){
		return insecto.tipoDeInsecto();
	}

	public boolean esDefinitoria() {
		return usuario.esExpertoOEspecialista();
	}
}
