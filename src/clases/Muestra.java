package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Muestra {
	
	
	
	private BufferedImage foto;
	private Ubicacion ubicacion;
	private String tipoDeVinchuca;
	private LocalDate fecha;
	private Usuario usuario;
	private Integer cantidadDeVerificaciones;
	private List<Verificacion> listaDeVerificaciones = new ArrayList<Verificacion>();
	private String nivelDeVerificacion;
	private Verificador verificador;
	
	public Muestra(Usuario usuario, Ubicacion ubicacion, String vinchuca, LocalDate fecha, BufferedImage foto) {
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.tipoDeVinchuca = vinchuca;
		this.fecha = fecha;
		this.foto = foto;
		this.cantidadDeVerificaciones = 0;
		this.verificador = new Verificador(this);
	}
	
	public void serVerificada(Verificacion verificacion) {
		if (listaDeVerificaciones.size()< 3) {
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
		return cantidadDeVerificaciones;
	}	
	public String aliasDeUsuario() {
		return usuario.alias();
	}
	public Ubicacion ubicacion() {
		return ubicacion;
	}
	public String tipoDeVinchuca() {
		return tipoDeVinchuca;
	}
	public BufferedImage fotoVinchuca() {
		return foto;
	}
	public List<Verificacion> listaDeVerificaciones() {
		return listaDeVerificaciones;
	}
	
	
	//SETTERS
	
	public void setNivelDeVerificacion(String nivel) {
		this.nivelDeVerificacion = nivel;
	}
}
