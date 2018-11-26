package clases;

import java.util.ArrayList;
import java.util.stream.Collectors;



public class SistemaWeb {

	private ArrayList<Muestra> muestras = new ArrayList<Muestra>();
	private ArrayList<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();
	
	public ArrayList<Muestra> muestrasSegun(Usuario usuario){
		ArrayList<Muestra> muestrasFiltradas = 
			(ArrayList<Muestra>) muestras.stream().filter(muestra -> muestra.aliasDeUsuario() == usuario.alias()).collect(Collectors.toList());
		
		return muestrasFiltradas;
	}

	public void recibirMuestra(Muestra muestra) {
		muestras.add(muestra);
		asignarMuestraAZona(muestra);
	}
	private void asignarMuestraAZona(Muestra muestra) {
		for(ZonaDeCobertura zona:zonas) {
			if(zona.muestraEstaEnRango(muestra)) {
				zona.registrarMuestra(muestra);
			}
		}
		
	}

	public ArrayList<Muestra> muestras(){
		return muestras;
	}
	
}
