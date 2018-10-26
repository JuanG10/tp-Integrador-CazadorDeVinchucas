package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {
	
	private String alias;
	private SistemaWeb unSistemaWeb;
	private ArrayList<Muestras> muestrasVerificadas = new ArrayList<Muestras>();
	//SACAR DE UML muestrasEnviadas Y REVISAR muestrasVerificadas DAME MAYUSCULAS MAS GRANDESSSS
	
	
	public Usuario(String alias, SistemaWeb sistema) {
		this.alias = alias;
		this.unSistemaWeb = sistema;
	}
	
	
	
	public void enviarMuestra(BufferedImage foto, String tipoDeVinchuca, String aliasUsuario,Ubicacion ubicacion, LocalDate fecha ) {
		
		Muestras muestra = new Muestras(aliasUsuario, ubicacion, tipoDeVinchuca, fecha, foto);
		
		unSistemaWeb.recibirMuestra(muestra);
	}
	public void verificarMuestra(Muestras muestra, Boolean booleano) {
		muestrasVerificadas.add(muestra);
		//Falta terminar
		
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
