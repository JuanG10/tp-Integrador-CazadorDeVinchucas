package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class ZonaDeCobertura {
	
	private String nombre;
	private Ubicacion epicentro;
	private Double distancia;
	private List<Muestra> muestrasEnRango;

	public ZonaDeCobertura(String nombre, Ubicacion epicentro, Double distancia) {
		if (distancia == 0) {
			throw new RuntimeException("No se puede instanciar una zona de cobertura con distancia cero");
		}
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.distancia = distancia;
		this.muestrasEnRango = new ArrayList<>();
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
	
	public List<Muestra> muestrasEnRango() {
		return muestrasEnRango;
	}

	public void registrarMuestra(Muestra muestra) {
		muestrasEnRango.add(muestra);
	}

	public Boolean solapaCon(ZonaDeCobertura zonaB) {
		return this.distancia() + zonaB.distancia() >= this.epicentro().distanciaCon(zonaB.epicentro());
	}

}
