package clases;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.NivelDeConocimiento;

public class ConocimientoBasico implements NivelDeConocimiento {

	@Override
	public NivelDeConocimiento verificarNivelDeConocimiento(List<Muestras> muestrasVerificadas,
															List<Muestras> muestrasEnviadas) {
		LocalDate hoy = LocalDate.now();
		
		Integer cantMuestrasEnviadasEnElMes = 
				muestrasEnviadas.stream().filter(muestra -> muestra.fecha().getMonthValue() == hoy.getMonthValue() ||
				(muestra.fecha().getMonthValue() == hoy.getMonthValue()-1 && muestra.fecha().getDayOfMonth() >= hoy.getDayOfMonth())).collect(Collectors.toList()).size();
		
		Integer cantMuestrasVerificadasEnElMes = muestrasVerificadas.stream().filter(muestra -> muestra.fecha().getMonthValue() == hoy.getMonthValue() ||
				(muestra.fecha().getMonthValue() == hoy.getMonthValue()-1 && muestra.fecha().getDayOfMonth() >= hoy.getDayOfMonth())).collect(Collectors.toList()).size();
		
		//Pasar a mensajes y considerar si deberian guardarse directamente en alguna variable.
		
		if (cantMuestrasEnviadasEnElMes < 10 && cantMuestrasVerificadasEnElMes < 20) {
			return this;
		} else {
			return new ConocimientoExperto();
		}
	}
}
