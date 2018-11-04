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
	
	public void calcularVerificacion() {
		if(hayDisencion()) {
			muestra.setNivelDeVerificacion("Indefinido");
		} else if(fueVerificadaPorExpertoOEspecialista()) {
			muestra.setNivelDeVerificacion("Alto");
		} else {
			muestra.setNivelDeVerificacion(niveles[muestra.listaDeVerificaciones().size()]);
		}
	}
	
	private boolean hayDisencion() {
		List<Verificacion> verificacionesConMayorValor = verificacionesConMayorValor();
		Set<String> tipos = verificacionesConMayorValor.stream().map(verificacion 
				-> verificacion.tipoVinchuca()).collect(Collectors.toSet());
		
		return tipos.size() == verificacionesConMayorValor.size();
	}
	
	private List<Verificacion> verificacionesConMayorValor() {
		if(fueVerificadaPorExpertoOEspecialista()) {
			return muestra.listaDeVerificaciones().stream().filter(verificacion 
					-> verificacion.esDefinitoria()).collect(Collectors.toList());
		} else {
			return muestra.listaDeVerificaciones();
		}
		
	}

	private boolean fueVerificadaPorExpertoOEspecialista() {
		return muestra.listaDeVerificaciones().stream().anyMatch(verificacion -> verificacion.esDefinitoria());
	}

}
