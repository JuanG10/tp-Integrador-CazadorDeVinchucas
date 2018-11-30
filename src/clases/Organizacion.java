package clases;


import java.util.ArrayList;
import java.util.List;

import interfaces.FuncionalidadExterna;

public class Organizacion{

	private String tipoDeOrganizacion;
	private Ubicacion ubicacion;
	private Integer cantPersonas;
	private FuncionalidadExterna funcionalidadExternaParaCargaDeMuestras;
	private FuncionalidadExterna funcionalidadExternaParaValidacionDeMuestras;
	
	public Organizacion(String tipo, Ubicacion ubicacion, Integer cantPersonas) {
		this.tipoDeOrganizacion = tipo;
		this.ubicacion = ubicacion;
		this.cantPersonas = cantPersonas;
	}
	
	public void registrarZonaDeCobertura(ZonaDeCobertura zona) {
		zona.suscribirOrganizacion(this);
	}
	public void removerZonaDeCobertura(ZonaDeCobertura zona) {
		zona.desuscribirOrganizacion(this);
	}
	
	public void nuevaMuestra(Muestra muestra) {
		aplicarFuncionalidadExternaPorCargaDeMuestra();
	}
	
	public void muestraValidada(Muestra muestra) {
		aplicarFuncionalidadExternaPorValidacionDeMuestra();
	}
	
	
	//FUNCIONALIDAD EXTERNA
	
	public FuncionalidadExterna getFuncionalidadExternaParaCarga() {
		return this.funcionalidadExternaParaCargaDeMuestras;
	}
	public FuncionalidadExterna getFuncionalidadExternaParaValidacion() {
		return this.funcionalidadExternaParaValidacionDeMuestras;
	}
	
	public void setFuncionalidadExternaParaCarga(FuncionalidadExterna funcionalidad) {
		this.funcionalidadExternaParaCargaDeMuestras = funcionalidad;
	}
	public void setFuncionalidadExternaParaValidacion(FuncionalidadExterna funcionalidad) {
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
