package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {
	
	private String alias;
	//SACAR DE UML muestrasEnviadas Y REVISAR muestrasVerificadas DAME MAYUSCULAS MAS GRANDESSSS
	
	
	public Usuario(String alias) {
		this.alias = alias;
	}
	
	
	
	public void enviarMuestra(BufferedImage foto, String tipoDeVinchuca, String aliasUsuario,Ubicacion ubicacion, LocalDate fecha ) {
		
	}
	public void verificarMuestra(Muestras muestra, Boolean booleano) {
		
	}
	public void verificarConocimiento() {
		//CAMBIAR NOMBRE EN UML
	}
	
	
	private ArrayList<Muestras> pedirMuestrasPropias(){
		return null; //REVISAR
	}
	private void calcularNivelDeConocimiento() {
		//REVISAR SI SIRVE ESTO
	}
	
	
	//GETER
	public String alias() {
		return alias;
	}
	
	
	
	

}
