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


	public void verificarMuestra(Muestra muestra, Insecto insecto) {
		
		Verificacion verificacion = new Verificacion(this, insecto);
		
		muestra.serVerificada(verificacion);
		
		muestrasVerificadas.add(muestra);
		
		
		this.calcularNivelDeConocimiento();//pasar hoy como parametro.
	}
	
	

	private void calcularNivelDeConocimiento() {
		nivelDeConocimiento = nivelDeConocimiento.verificarNivelDeConocimiento(muestrasVerificadas,unSistemaWeb.muestrasSegun(this));
	}
	
	
	//GETTERS
	public String alias() {
		return alias;
	}
	
	public NivelDeConocimiento nivelDeConocimiento() {
		return nivelDeConocimiento;
	}

	public SistemaWeb sistemaWeb() {
		return unSistemaWeb;
	}
	
	public Integer cantidadDeMuestrasVerificadas() {
		return muestrasVerificadas.size();
	}

	public boolean esExpertoOEspecialista() {
		return nivelDeConocimiento.esDefinitorio();
	}

}
