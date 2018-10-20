package clases;

public class Ubicacion {

	private Double latitud;
	private Double longitud;
	
	
	public Ubicacion(Double latitud,Double longitud) {
		this.latitud = latitud;
		this.longitud =longitud;
	}
	
	
	
	public Double distanciaCon(Ubicacion ubicacion) {
		return null;
	}
	
	
	//GETERS
	public Double latitud() {
		return latitud;
	}
	public Double longitud() {
		return longitud;
	}
}
