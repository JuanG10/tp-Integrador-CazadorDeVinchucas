package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.NivelDeConocimiento;

public class Usuario {
	
	private String alias;
	private SistemaWeb sistemaWeb;
	private ArrayList<Muestra> muestrasVerificadas = new ArrayList<Muestra>();
	private NivelDeConocimiento nivelDeConocimiento;
	
	
	public Usuario(String alias, SistemaWeb sistema, NivelDeConocimiento nvlConocimiento) {
		this.alias = alias;
		this.sistemaWeb = sistema;
		this.nivelDeConocimiento = nvlConocimiento;
	}
	
	
	
	public void enviarMuestra(BufferedImage foto, String tipoDeVinchuca, Ubicacion ubicacion, LocalDate fecha ) {
		
		Muestra muestra = new Muestra(this, ubicacion, tipoDeVinchuca, fecha, foto);
		
		sistemaWeb.recibirMuestra(muestra); //Esto se hace en el test pasando directamente las muestra a la web.
		
		this.calcularNivelDeConocimiento();
	}
	
	public void verificarMuestra(Muestra muestra, String tipoDeVinchuca) {
		
		Verificacion verificacion = new Verificacion(this, tipoDeVinchuca);
		
		muestra.serVerificada(verificacion);
		
		muestrasVerificadas.add(muestra);
		
		this.calcularNivelDeConocimiento();//pasar hoy como parametro.
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

	public SistemaWeb sistemaWeb() {
		return sistemaWeb;
	}
	
	public Integer cantidadDeMuestrasVerificadas() {
		return muestrasVerificadas.size();
	}

}
