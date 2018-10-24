package clases;

public class Ubicacion {

	private Double latitud;
	private Double longitud;
	
	
	public Ubicacion(Double latitud,Double longitud) {
		this.latitud = latitud;
		this.longitud =longitud;
	}
	
	
	
	public Double distanciaCon(Ubicacion ubicacion) {
		double radioTierra = 6371; //en kilómetros  
        double dLat = Math.toRadians(ubicacion.latitud() - this.latitud);  
        double dLng = Math.toRadians(ubicacion.longitud() - this.longitud);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(ubicacion.latitud()));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;
	}
	
	
	//GETERS
	public Double latitud() {
		return latitud;
	}
	public Double longitud() {
		return longitud;
	}
}
