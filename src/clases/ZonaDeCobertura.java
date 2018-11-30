package clases;

import java.util.ArrayList;
import java.util.List;


public class ZonaDeCobertura {
	
	private String nombre;
	private Ubicacion epicentro;
	private Double distancia;
	private List<Muestra> muestrasEnRango;
	private List<ZonaDeCobertura> zonasQueSolapan;
	private List<Organizacion> organizacionesSuscritas;

	public ZonaDeCobertura(String nombre, Ubicacion epicentro, Double distancia) {
		if (distancia == 0) {
			throw new RuntimeException("No se puede instanciar una zona de cobertura con distancia cero");
		}
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.distancia = distancia;
		this.muestrasEnRango = new ArrayList<>();
		this.zonasQueSolapan = new ArrayList<>();
		this.organizacionesSuscritas = new ArrayList<>();
	}
	
	public String nombre() {
		return nombre;
	}
	
	public Ubicacion epicentro() {
		return epicentro;
	}
	
	public Double distancia() {
		return distancia;
	}
	
	public List<Organizacion> organizacionesSuscritas() {
		return organizacionesSuscritas;
	}
	
	public void registrarMuestra(Muestra muestra) {
		muestrasEnRango.add(muestra);
		muestra.registrarZona(this);
		notificarRegistro(muestra);
	}
	
	public void registrarZona(ZonaDeCobertura zona) {
		zonasQueSolapan.add(zona);
	}
	
	public List<Muestra> muestrasEnRango() {
		return muestrasEnRango;
	}

	public List<ZonaDeCobertura> zonasQueSolapan() {
		return zonasQueSolapan;
	}
	
	public void evaluarMuestra(Muestra muestra) {
		if(this.muestraEstaEnRango(muestra)) {
			registrarMuestra(muestra);
		}
	}
	
	public void evaluarZona(ZonaDeCobertura zona) {
		if(this.solapaCon(zona)) {
			registrarZona(zona);
		}
	}

	public Boolean solapaCon(ZonaDeCobertura zonaB) {
		return this.distancia() + zonaB.distancia() >= this.epicentro().distanciaCon(zonaB.epicentro());
	}

	public boolean muestraEstaEnRango(Muestra muestra) {
		return epicentro.distanciaCon(muestra.ubicacion())< this.distancia;
	}
	
	public void suscribirOrganizacion(Organizacion organizacion) {
		organizacionesSuscritas.add(organizacion);
	}
	
	public void desuscribirOrganizacion(Organizacion organizacion) {
		organizacionesSuscritas.remove(organizacion);
	}
	
	private void notificarRegistro(Muestra muestra) {
		organizacionesSuscritas.stream().forEach(organizacion -> organizacion.nuevaMuestra(muestra));
	}
	
	public void muestraValidada(Muestra muestra) {
		notificarValidacion(muestra);
	}
	
	private void notificarValidacion(Muestra muestra) {
		organizacionesSuscritas.stream().forEach(organizacion -> organizacion.muestraValidada(muestra));
	}


}
