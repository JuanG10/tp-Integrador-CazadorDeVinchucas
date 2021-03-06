package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Muestra {
	
	
	
	private BufferedImage foto;
	private Ubicacion ubicacion;
	private Insectos tipoDeVinchuca;
	private LocalDate fecha;
	private Usuario usuario;
	private List<Verificacion> listaDeVerificaciones = new ArrayList<Verificacion>();
	private NivelDeVerificacion nivelDeVerificacion;
	private Verificador verificador;
	private List<ZonaDeCobertura> zonasPresentes;
	
	public Muestra(Usuario usuario, Ubicacion ubicacion, Insectos vinchuca, LocalDate fecha, BufferedImage foto) {
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.tipoDeVinchuca = vinchuca;
		this.fecha = fecha;
		this.foto = foto;
		this.verificador = new Verificador(this);
		this.listaDeVerificaciones = new ArrayList<>();
		this.zonasPresentes = new ArrayList<>();
		
		this.serVerificada(new Verificacion(usuario, vinchuca));
	}
	
	public void serVerificada(Verificacion verificacion) {
		if (cantidadDeVerificaciones()< 3) {
			listaDeVerificaciones.add(verificacion);
			verificador.calcularNivelDeVerificacion();
			notificarValidacion();
		} else {
			throw new RuntimeException("La muestra ya fue verificada tres veces");
		}
	}
	
	public void registrarZona(ZonaDeCobertura zona) {
		zonasPresentes.add(zona);
	}
	
	private void notificarValidacion() {
		zonasPresentes.stream().forEach(zona -> zona.muestraValidada(this));
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
