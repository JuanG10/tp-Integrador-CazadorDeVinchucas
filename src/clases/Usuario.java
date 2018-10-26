package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.NivelDeConocimiento;

public abstract class Usuario {
	
	private String alias;
	private SistemaWeb unSistemaWeb;
	private ArrayList<Muestras> muestrasVerificadas = new ArrayList<Muestras>();
	private NivelDeConocimiento nivelDeConocimiento;
	
	
	public Usuario(String alias, SistemaWeb sistema, NivelDeConocimiento nivelDeConocimiento) {
		this.alias = alias;
		this.unSistemaWeb = sistema;
		this.nivelDeConocimiento = nivelDeConocimiento;
	}
	
	
	
	public void enviarMuestra(BufferedImage foto, String tipoDeVinchuca, Ubicacion ubicacion, LocalDate fecha ) {
		
		Muestras muestra = new Muestras(this, ubicacion, tipoDeVinchuca, fecha, foto);
		
		unSistemaWeb.recibirMuestra(muestra);
	}
	public void verificarMuestra(Muestras muestra, String tipoDeVinchuca) {
		Verificacion verificacion = new Verificacion(this, tipoDeVinchuca);
		muestra.serVerificada(verificacion);
		
		
		
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
	
	
	//GETTERS
	public String alias() {
		return alias;
	}
	public NivelDeConocimiento nivelDeConocimiento() {
		return nivelDeConocimiento();
	}
	
	
	
	

}
