package clases;

import java.time.LocalDate;

import interfaces.NivelDeConocimiento;

public class ConocimientoExperto implements NivelDeConocimiento {
	LocalDate fechaInicioComoExperto = LocalDate.now();
	
	@Override
	public NivelDeConocimiento verificarNivelDeConocimiento() {
		LocalDate hoy = LocalDate.now();
		
		if(hoy.getMonthValue() > fechaInicioComoExperto.getMonthValue() &
				hoy.getDayOfMonth() >= fechaInicioComoExperto.getDayOfMonth()) {
			return new ConocimientoBasico();
		} else {
			return this;
		}
	}
}
