package clases;

public class NivelDeVerificacionBajo extends NivelDeVerificacion{
	
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
