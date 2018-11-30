package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class SistemaWeb {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();
	
	public List<Muestra> muestras(){
		return muestras;
	}
	
	public List<Muestra> muestrasSegun(Usuario usuario){
		ArrayList<Muestra> muestrasFiltradas = 
			(ArrayList<Muestra>) muestras.stream().filter(muestra -> muestra.aliasDeUsuario() == usuario.alias()).collect(Collectors.toList());
		
		return muestrasFiltradas;
	}

	public void recibirMuestra(Muestra muestra) {
		muestras.add(muestra);
		zonas.stream().forEach(zona -> zona.evaluarMuestra(muestra));
	}
	
	public void registrarZonaDeCobertura(ZonaDeCobertura zonaNueva) {
		zonas.stream().forEach(zonaEnSistema -> {
			zonaEnSistema.evaluarZona(zonaNueva);
			zonaNueva.evaluarZona(zonaEnSistema);
		});
		zonaNueva.evaluarZona(zonaNueva);
		zonas.add(zonaNueva);
	}
}
