package clases;

import java.util.ArrayList;
import java.util.List;

public abstract class NivelDeVerificacion {
	
	public abstract boolean esIgualA(NivelDeVerificacion nivel);
	
	public abstract boolean esAlto();
	
	public abstract boolean esMedio();
	
	public abstract boolean esBajo();

	public static Verificacion verificacionPara(Usuario usuario, String tipoDeVinchuca) {
		return verificacionesPosibles().stream().filter(verificacion -> verificacion.puedeEncargarseDe(usuario, tipoDeVinchuca)).findFirst().get().encargarseDe(usuario,  tipoDeVinchuca);
	}
		
	private static List<NivelDeVerificacion> verificacionesPosibles() {
		List<NivelDeVerificacion> verificacionesPosibles = new ArrayList<>();
		verificacionesPosibles.add(new NivelDeVerificacionAlto());
		verificacionesPosibles.add(new NivelDeVerificacionMedio());
		verificacionesPosibles.add(new NivelDeVerificacionBajo());
		
		return verificacionesPosibles;

	}
	
	public abstract boolean puedeEncargarseDe(Usuario usuario, String tipoDeVinchuca);
	
	public abstract Verificacion encargarseDe(Usuario usuario, String tipoDeVinchuca);


}
