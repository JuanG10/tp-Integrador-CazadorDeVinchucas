package clases;

public class Verificacion {
	private Usuario usuario;
	private String tipoVinchuca;
	private NivelDeVerificacion nivelDeVerificacion;
	
	public Verificacion(Usuario usuario, String tipoDeVinchuca, NivelDeVerificacion nivel) {
		this.usuario = usuario;
		this.tipoVinchuca = tipoDeVinchuca;
		this.nivelDeVerificacion = nivel;
	}

	//GETTERS
	
	public Usuario usuario() {
		return usuario;
	}
	public String tipoVinchuca(){
		return tipoVinchuca;
	}

	public boolean esDefinitoria() {
		return true;
	}
}
