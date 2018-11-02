package clases;

public class Verificacion {
	private Usuario usuario;
	private String tipoVinchuca;
	
	public Verificacion(Usuario usuario, String tipoDeVinchuca) {
		this.usuario = usuario;
		this.tipoVinchuca = tipoDeVinchuca;
	}

	//GETTERS
	
	public Usuario usuario() {
		return usuario;
	}
	public String tipoVinchuca(){
		return tipoVinchuca;
	}
}
