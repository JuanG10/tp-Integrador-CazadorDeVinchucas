package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SistemaWeb {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	
	public List<Muestra> muestras(Usuario usuario){
		return muestras.stream().filter(muestra -> muestra.aliasDeUsuario().equals(usuario.alias())).collect(Collectors.toList());
	}

	public void recibirMuestra(Muestra muestra) {
		
		muestras.add(muestra);
		
	}
	
}
