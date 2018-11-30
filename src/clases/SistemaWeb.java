package clases;

import java.util.ArrayList;
import java.util.stream.Collectors;



public class SistemaWeb {

	private ArrayList<Muestra> muestras = new ArrayList<Muestra>();
	private ArrayList<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();
	
	public ArrayList<Muestra> muestras(){
		return muestras;
	}
	
	public ArrayList<Muestra> muestrasSegun(Usuario usuario){
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
