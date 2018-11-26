package clases;


import java.util.ArrayList;

import interfaces.FuncionalidadExtenerna;

public abstract class Organizacion{

	private String tipoDeOrganizacion;
	private Ubicacion ubicacion;
	private Integer cantPersonas;
	private ArrayList <ZonaDeCobertura> zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
	private FuncionalidadExtenerna funcionalidadExternaParaCargaDeMuestras;
	private FuncionalidadExtenerna funcionalidadExternaParaValidacionDeMuestras;
	
	public Organizacion(String tipo, Ubicacion ubicacion, Integer cantPersonas) {
		this.tipoDeOrganizacion = tipo;
		this.ubicacion = ubicacion;
		this.cantPersonas = cantPersonas;
	}
	
	public void registrarZonaDeCobertura(ZonaDeCobertura zona) {
		this.zonasDeCobertura.add(zona);
	}
	public void removerZonaDeCobertura(ZonaDeCobertura zona) {
		this.zonasDeCobertura.remove(zona);
	}
	
	
	//FUNCIONALIDAD EXTERNA
	
	public void setFuncionalidadExternaParaCarga(FuncionalidadExtenerna funcionalidad) {
		this.funcionalidadExternaParaCargaDeMuestras = funcionalidad;
	}
	public void setFuncionalidadExternaParaValidacion(FuncionalidadExtenerna funcionalidad) {
		this.funcionalidadExternaParaValidacionDeMuestras = funcionalidad;
	}
	private void aplicarFuncionalidadExternaPorCargaDeMuestra() {
		this.funcionalidadExternaParaCargaDeMuestras.actuar();
	}
	private void aplicarFuncionalidadExternaPorValidacionDeMuestra() {
		this.funcionalidadExternaParaValidacionDeMuestras.actuar();
	}
	
	
	
	//GETERS
	public String tipoDeOrganizacion() {
		return tipoDeOrganizacion;
	}
	public Ubicacion ubicacion() {
		return ubicacion;
	}
	public Integer cantidadDePersonas() {
		return cantPersonas;
	}
}
