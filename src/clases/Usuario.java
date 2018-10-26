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
	
	
	public Usuario(String alias, SistemaWeb sistema, NivelDeConocimiento nvlConocimiento) {
		this.alias = alias;
		this.unSistemaWeb = sistema;
		this.nivelDeConocimiento = nvlConocimiento;
	}
	
	
	
	public void enviarMuestra(BufferedImage foto, String tipoDeVinchuca, Ubicacion ubicacion, LocalDate fecha ) {
		
		Muestras muestra = new Muestras(this, ubicacion, tipoDeVinchuca, fecha, foto);
		
		unSistemaWeb.recibirMuestra(muestra);
		
		this.calcularNivelDeConocimiento();
	}
	
	public void verificarMuestra(Muestras muestra, String tipoDeVinchuca) {
		
		Verificacion verificacion = new Verificacion(this, tipoDeVinchuca);
		
		muestra.serVerificada(verificacion);
		
		muestrasVerificadas.add(muestra);
		
		this.calcularNivelDeConocimiento();
		
	}
	
	private void calcularNivelDeConocimiento() {
		nivelDeConocimiento = nivelDeConocimiento.verificarNivelDeConocimiento();
	}
	
	
	//GETTERS
	public String alias() {
		return alias;
	}
	public NivelDeConocimiento nivelDeConocimiento() {
		return nivelDeConocimiento();
	}
	
	
	
	

}
