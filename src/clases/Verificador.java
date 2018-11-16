package clases;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Verificador {
	
	private Muestra muestra;
	public String[] niveles = {"Bajo", "Medio", "Alto"};
	
	public Verificador(Muestra muestra) {
		this.muestra = muestra;
	}
	
	public void calcularNivelDeVerificacion() {
		if(hayDisension()) {
			muestra.setNivelDeVerificacion("Indefinido");
		} else if(fueVerificadaPorExpertoOEspecialista()) {
			muestra.setNivelDeVerificacion("Alto");
		} else {
			muestra.setNivelDeVerificacion(niveles[cantidadDeVerificacionesIgualesALaOriginal() - 1]);
		}
	}
	
	private Integer cantidadDeVerificacionesIgualesALaOriginal() {
		return (int) muestra.listaDeVerificaciones().stream().filter(verificacion -> muestra.tipoDeVinchuca().equals(verificacion.tipoVinchuca())).count();
	}

	private boolean hayDisension() {
		List<Verificacion> verificacionesConMayorValor = verificacionesConMayorValor();
		Set<Insectos> tipos = tiposDeVinchucaSinRepeticiones(verificacionesConMayorValor);
		
		return verificacionesConMayorValor.size() != 1 && tipos.size() == verificacionesConMayorValor.size();
	}

	private Set<Insectos> tiposDeVinchucaSinRepeticiones(List<Verificacion> verificacionesConMayorValor) {
		return verificacionesConMayorValor.stream().map(verificacion 
				-> verificacion.tipoVinchuca()).collect(Collectors.toSet());
	}
	
	private List<Verificacion> verificacionesConMayorValor() {
		if(fueVerificadaPorExpertoOEspecialista()) {
			return verificacionesDeExpertosOEspecialistas();
		} else {
			return muestra.listaDeVerificaciones();
		}
		
	}

	private List<Verificacion> verificacionesDeExpertosOEspecialistas() {
		return muestra.listaDeVerificaciones().stream().filter(verificacion 
				-> verificacion.esDefinitoria()).collect(Collectors.toList());
	}

	private boolean fueVerificadaPorExpertoOEspecialista() {
		return muestra.listaDeVerificaciones().stream().anyMatch(verificacion -> verificacion.esDefinitoria());
	}

}
