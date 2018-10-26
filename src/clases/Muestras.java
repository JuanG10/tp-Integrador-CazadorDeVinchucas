package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

import interfaces.NivelDeConocimiento;



public class Muestras {
	
	
	
	private BufferedImage foto;
	private Ubicacion ubicacion;
	private Integer nroDeVerificacion;
	private String tipoDeVinchuca;
	private LocalDate fecha;
	private Usuario usuario;
	private Integer contadorDeVerificaciones;
	private ArrayList<Verificacion> listaDeVerificaciones = new ArrayList<Verificacion>();
	
	public Muestras(Usuario usuario, Ubicacion ubicacion, String vinchuca, LocalDate fecha, BufferedImage foto) {
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		this.tipoDeVinchuca = vinchuca;
		this.fecha = fecha;
		this.foto = foto;
		this.contadorDeVerificaciones = 0;
	}
	
	
	
	public void serVerificada(Verificacion verificacion) {
		if (contadorDeVerificaciones< 3) {
		this.calcularNivelDeVerificacion(verificacion);
		contadorDeVerificaciones ++;
		}
	}
	
	private void calcularNivelDeVerificacion(Verificacion verificacion){
		if(tipoVinchuca == this.tipoDeVinchuca) {
			
		}
	}
	
	
	
	//GETERS
	
	public LocalDate fecha() {
		return fecha;
	}
	public Integer nroDeVerificacion() {
		return nroDeVerificacion;
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
