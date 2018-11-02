package clases;

import java.util.ArrayList;



public class SistemaWeb {

	private ArrayList<Muestra> muestras = new ArrayList<Muestra>();
	
	public ArrayList<Muestra> muestras(Usuario usuario){
		ArrayList<Muestra> muestrasFiltradas = 
			(ArrayList<Muestra>) muestras.stream().filter(muestra -> muestra.aliasDeUsuario() == usuario.alias()).collect(Collectors.toList());
		
		return muestrasFiltradas;
	}

	public void recibirMuestra(Muestra muestra) {
		
		muestras.add(muestra);
		
	}
	
}
