package clases;

import java.util.List;

import interfaces.NivelDeConocimiento;

public class ConocimientoEspecialista implements NivelDeConocimiento {

	@Override
	public NivelDeConocimiento verificarNivelDeConocimiento(List<Muestra> muestrasVerificadas,
			List<Muestra> muestrasEnviadas) {
		return this;
	}
	
	public boolean esDefinitorio() {
		return true;
	}
}
