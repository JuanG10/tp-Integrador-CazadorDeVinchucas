package clases;

public class NivelDeVerificacionMedio extends NivelDeVerificacion{
	
	public boolean esIgualA(NivelDeVerificacion nivel) {
		return nivel.esMedio();
	}
	
	public boolean esAlto() {
		return false;
	}
	
	public  boolean esMedio() {
		return true;
	}
	
	public boolean esBajo( ) {
		return false;
	}
	
	public boolean esMayorA(NivelDeVerificacion nivel) {
		return nivel.esBajo();
	}
	
	public boolean esMenorA(NivelDeVerificacion nivel) {
		return nivel.esAlto();
	}



}
