package clases;


public abstract class Organizacion{

	private String tipoDeOrganizacion;
	private Ubicacion ubicacion;
	private Integer cantPersonas;
	
	public Organizacion(String tipo, Ubicacion ubicacion, Integer cantPersonas) {
		this.tipoDeOrganizacion = tipo;
		this.ubicacion = ubicacion;
		this.cantPersonas = cantPersonas;
	}
	
	
	//GETERS
	public String tipoDeOrganizacion() {
		return tipoDeOrganizacion;
	}
	public Ubicacion ubicacion() {
		return ubicacion;
	}
	public Integer cantidadDePersonas() {
		return cantPersonas;
	}
}
