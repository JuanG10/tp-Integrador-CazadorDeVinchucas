package clases;

import java.util.ArrayList;


public class SistemaWeb {

	private ArrayList<Muestras> muestras = new ArrayList<Muestras>();
	
	public ArrayList<Muestras> muestras(Usuario usuario){
		//Filtrar las muestras cuyos alias de usuario sean los del usuario que las creó
		return null;
	}

	public void recibirMuestra(Muestras muestra) {
		
		muestras.add(muestra);
		
	}
	
}
