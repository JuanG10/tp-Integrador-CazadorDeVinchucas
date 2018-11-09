package clases;

public class NivelDeVerificacionAlto extends NivelDeVerificacion {

	@Override
	public boolean puedeEncargarseDe(Usuario usuario, String tipoDeVinchuca) {
		return usuario.esExpertoOEspecialista();
	}

	@Override
	public Verificacion encargarseDe(Usuario usuario, String tipoDeVinchuca) {
		return new Verificacion(usuario, tipoDeVinchuca, new NivelDeVerificacionAlto());
	}

}
