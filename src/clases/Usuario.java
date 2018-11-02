package clases;

import java.util.ArrayList;
import java.util.List;

import interfaces.NivelDeConocimiento;

public class Usuario {
	
	private String alias;
	private SistemaWeb unSistemaWeb;
	private List<Muestra> muestrasVerificadas = new ArrayList<Muestra>();
	private NivelDeConocimiento nivelDeConocimiento;
	
	public Usuario(String alias, SistemaWeb sistema) {
		this.alias = alias;
		this.unSistemaWeb = sistema;
		this.nivelDeConocimiento = new ConocimientoBasico();
	}
	
	public Usuario(String alias, SistemaWeb sistema, NivelDeConocimiento nvlConocimiento) {
		this.alias = alias;
		this.unSistemaWeb = sistema;
		this.nivelDeConocimiento = nvlConocimiento;
	}
	
	
	//Esto se hace en el test pasando directamente las muestra a la web hechas a mano.
//	public void enviarMuestra(BufferedImage foto, String tipoDeVinchuca, Ubicacion ubicacion, LocalDate fecha ) {
//		
//		Muestras muestra = new Muestras(this, ubicacion, tipoDeVinchuca, fecha, foto);
//		
//		unSistemaWeb.recibirMuestra(muestra); 
//		
//		this.calcularNivelDeConocimiento();
//	}
	
	
	
	public void verificarMuestra(Muestra muestra, String tipoDeVinchuca) {
		
		Verificacion verificacion = new Verificacion(this, tipoDeVinchuca);
		
		muestra.serVerificada(verificacion);
		
		muestrasVerificadas.add(muestra);
		
		this.calcularNivelDeConocimiento();//pasar hoy como parametro.
		
	}
	
	private void calcularNivelDeConocimiento() {
		nivelDeConocimiento = nivelDeConocimiento.verificarNivelDeConocimiento(muestrasVerificadas,unSistemaWeb.muestras(this));
	}
	
	
	//GETTERS
	public String alias() {
		return alias;
	}
	
	public NivelDeConocimiento nivelDeConocimiento() {
		return nivelDeConocimiento;
	}

}
