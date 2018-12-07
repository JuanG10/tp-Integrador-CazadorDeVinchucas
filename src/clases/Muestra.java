package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Muestra {
	
	
	
	private BufferedImage foto;
	private Ubicacion ubicacion;
	private Insecto tipoDeVinchuca;
	private LocalDate fecha;
	private Usuario usuario;
	private List<Verificacion> listaDeVerificaciones = new ArrayList<Verificacion>();
	private NivelDeVerificacion nivelDeVerificacion;
	private Verificador verificador;
	
	public Muestra(Usuario usuario, Ubicacion ubicacion, Insecto vinchuca, LocalDate fecha, BufferedImage foto) {
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.tipoDeVinchuca = vinchuca;
		this.fecha = fecha;
		this.foto = foto;
		this.verificador = new Verificador(this);
		this.listaDeVerificaciones = new ArrayList<>();
		
		this.serVerificada(new Verificacion(usuario, vinchuca));
	}
	
	public void serVerificada(Verificacion verificacion) {
		if (cantidadDeVerificaciones()< 3) {
			listaDeVerificaciones.add(verificacion);
			verificador.calcularNivelDeVerificacion();
		} else {
			throw new RuntimeException("La muestra ya fue verificada tres veces");
		}
	}
	
	//GETTERS
	
	public LocalDate fecha() {
		return fecha;
	}
	public Integer cantidadDeVerificaciones() {
		return listaDeVerificaciones.size();
	}	
	public String aliasDeUsuario() {
		return usuario.alias();
	}
	public Ubicacion ubicacion() {
		return ubicacion;
	}
	public String tipoDeVinchuca() {
		return tipoDeVinchuca.tipoDeInsecto();
	}
	public BufferedImage fotoVinchuca() {
		return foto;
	}
	public List<Verificacion> listaDeVerificaciones() {
		return listaDeVerificaciones;
	}
	public String nivelDeVerificacion() {
		return nivelDeVerificacion.nivelDeVerificacion();
	}
	
	
	//SETTERS
	
	public void setNivelDeVerificacion(NivelDeVerificacion nivel) {
		this.nivelDeVerificacion = nivel;
	}
}
