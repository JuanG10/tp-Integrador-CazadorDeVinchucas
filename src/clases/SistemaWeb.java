package clases;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class SistemaWeb {

	private ArrayList<Muestras> muestras = new ArrayList<Muestras>();
	
	public ArrayList<Muestras> muestras(Usuario usuario){
		ArrayList<Muestras> muestrasFiltradas = 
			(ArrayList<Muestras>) muestras.stream().filter(muestra -> muestra.aliasDeUsuario() == usuario.alias()).collect(Collectors.toList());
		
		return muestrasFiltradas;
	}

	public void recibirMuestra(Muestras muestra) {
		
		muestras.add(muestra);
		
	}
	
}
