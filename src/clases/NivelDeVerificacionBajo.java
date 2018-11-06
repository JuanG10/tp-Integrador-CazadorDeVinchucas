package clases;

public class NivelDeVerificacionBajo extends NivelDeVerificacion{
	
	public boolean esIgualA(NivelDeVerificacion nivel) {
		return nivel.esBajo();
	}
	
	public boolean esAlto() {
		return false;
	}
	
	public  boolean esMedio() {
		return false;
	}
	
	public boolean esBajo( ) {
		return true;
	}
	
	public boolean esMayorA(NivelDeVerificacion nivel) {
		return false;
	}
	
	public boolean esMenorA(NivelDeVerificacion nivel) {
		return nivel.esMedio() || nivel.esAlto();
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
