package clases;

public class NivelDeVerificacionAlto extends NivelDeVerificacion {
	
	public boolean esIgualA(NivelDeVerificacion nivel) {
		return nivel.esAlto();
	}
	
	public boolean esAlto() {
		return true;
	}
	
	public  boolean esMedio() {
		return false;
	}
	
	public boolean esBajo( ) {
		return false;
	}
	
	public boolean esMayorA(NivelDeVerificacion nivel) {
		return nivel.esMedio() || nivel.esBajo();
	}
	
	public boolean esMenorA(NivelDeVerificacion nivel) {
		return false;
	}

	@Override
	public boolean puedeEncargarseDe(Usuario usuario, String tipoDeVinchuca) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Verificacion encargarseDe(Usuario usuario, String tipoDeVinchuca) {
		// TODO Auto-generated method stub
		return null;
	}

}
