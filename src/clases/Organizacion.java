package clases;


import java.util.ArrayList;

public abstract class Organizacion{

	private String tipoDeOrganizacion;
	private Ubicacion ubicacion;
	private Integer cantPersonas;
	private ArrayList <ZonaDeCobertura> zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
	
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
