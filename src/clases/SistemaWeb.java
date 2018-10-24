package clases;

import java.util.ArrayList;


public class SistemaWeb {

	private ArrayList<Muestras> muestras = new ArrayList<Muestras>();
	
	public SistemaWeb() {
		
	}

	public void recibirMuestra(Muestras muestra) {
		
		muestras.add(muestra);
		
	}
	
}
