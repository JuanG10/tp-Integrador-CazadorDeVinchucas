package interfaces;

import java.util.List;

import clases.Muestras;

public interface NivelDeConocimiento {

	public NivelDeConocimiento verificarNivelDeConocimiento(List<Muestras> muestrasVerificadas, List<Muestras> muestrasEnviadas);
}