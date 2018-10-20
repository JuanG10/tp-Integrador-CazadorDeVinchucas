package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;



public class Muestras {
	
	
	
	private BufferedImage foto;
	private Ubicacion ubicacion;
	private Integer nroDeVerificacion;
	private String tipoDeVinchuca;
	private LocalDate fecha;
	private String aliasUsuario;

	
	public Muestras(String aliasDeUsuario, Ubicacion ubicacion, String vinchuca, LocalDate fecha, BufferedImage foto) {
		this.aliasUsuario = aliasDeUsuario;
		this.ubicacion = ubicacion;
		this.tipoDeVinchuca = vinchuca;
		this.fecha = fecha;
		this.foto = foto;
		
	}
	
	
	
	public void serVerificadaPorSuperior() {
		
	}
	public void serVerificadaPorBasico() {
		
	}
	public void calcularNroDeVerificacion(){
		
	}
	
	
	
	//GETERS
	
	public LocalDate fecha() {
		return fecha;
	}
	public Integer nroDeVerificacion() {
		return nroDeVerificacion;
	}	
	public String aliasDeUsuario() {
		return aliasUsuario;
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
