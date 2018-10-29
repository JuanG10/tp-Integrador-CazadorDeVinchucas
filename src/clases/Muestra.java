package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.NivelDeConocimiento;



public class Muestra {
	
	
	
	private BufferedImage foto;
	private Ubicacion ubicacion;
	private String tipoDeVinchuca;
	private LocalDate fecha;
	private Usuario usuario;
	private Integer cantidadDeVerificaciones;
	private ArrayList<Verificacion> listaDeVerificaciones = new ArrayList<Verificacion>();
	
	public Muestra(Usuario usuario, Ubicacion ubicacion, String vinchuca, LocalDate fecha, BufferedImage foto) {
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.tipoDeVinchuca = vinchuca;
		this.fecha = fecha;
		this.foto = foto;
		this.cantidadDeVerificaciones = 0;
	}
	
	
	
	public void serVerificada(Verificacion verificacion) {
		if (listaDeVerificaciones.size()< 3) {
		this.calcularNivelDeVerificacion(verificacion);
		listaDeVerificaciones.add(verificacion);
		}
	}
	
	private void calcularNivelDeVerificacion(Verificacion verificacion){
		if(verificacion.tipoVinchuca() == this.tipoDeVinchuca) {
			
			
		}
	}
	
	
	
	//GETERS
	
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
}
