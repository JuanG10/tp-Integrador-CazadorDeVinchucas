package clases;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import interfaces.NivelDeConocimiento;

public class ConocimientoExperto implements NivelDeConocimiento {
	
	@Override
	public NivelDeConocimiento verificarNivelDeConocimiento(List<Muestra> muestrasVerificadas,
															List<Muestra> muestrasEnviadas) {
		LocalDate hoy = LocalDate.now();

		if (this.cantMuestrasEnviadasEnElMes(muestrasEnviadas,hoy) >= 10 && this.cantMuestrasVerificadasEnElMes(muestrasVerificadas,hoy) >= 20) {
			return this;
		} else {
			return new ConocimientoBasico();
		}
	}
	
	private int cantMuestrasVerificadasEnElMes(List<Muestra> muestrasVerificadas, LocalDate hoy) {
		// TODO Auto-generated method stub
		return calcularCantMuestrasDelMes(muestrasVerificadas, hoy);
	}

	private int cantMuestrasEnviadasEnElMes(List<Muestra> muestrasEnviadas, LocalDate hoy) {
		// TODO Auto-generated method stub
		return calcularCantMuestrasDelMes(muestrasEnviadas,hoy);
	}

	private Integer calcularCantMuestrasDelMes(List<Muestra> muestras, LocalDate hoy) {
		return muestras.stream().filter(muestra -> muestra.fecha().getMonthValue() == hoy.getMonthValue() ||
				(muestra.fecha().getMonthValue() == hoy.getMonthValue()-1 && muestra.fecha().getDayOfMonth() >= hoy.getDayOfMonth())).collect(Collectors.toList()).size();
	}
	
	
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o instanceof ConocimientoExperto)return true;
		return false;
	}
	
	public boolean esDefinitoria() {
		return true;
	}
	public Verificacion verificacionEmitible(Usuario usuario, String tipoDeVinchuca) {
		return null;
		//REVISAR
	}
	
}
