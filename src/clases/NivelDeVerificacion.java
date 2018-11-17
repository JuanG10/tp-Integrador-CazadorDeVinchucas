package clases;

public class NivelDeVerificacion {

	
	//TypeObjectPattern
	private String nivelDeVerificacion = "Bajo";
	
	public NivelDeVerificacion(String nivelDeVerificacion) {
		this.nivelDeVerificacion = nivelDeVerificacion;
	}
	
	public String nivelDeVerificacion() {
		return this.nivelDeVerificacion;
	}
}
