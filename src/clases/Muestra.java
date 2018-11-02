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
		listaDeVerificaciones.add(verificacion);
		this.calcularNivelDeVerificacion();
		}
	}
	
	private void calcularNivelDeVerificacion(){
		if(hayDisencion()) {
			nivelDeVerificacion = "Indefinido";
		} else {
			nivelDeVerificacion = x();
		}
	}
	
	private boolean hayDisencion() {
		List<Verificacion> verificacionesConMayorValor = listaDeVerificaciones.stream().filter(verificacion 
				-> verificacion.esDefinitoria()).collect(Collectors.toList());
		Set<String> tipos = verificacionesConMayorValor.stream().map(verificacion 
				-> verificacion.tipoVinchuca()).collect(Collectors.toSet());
		// REVISAR CASO LISTA VACIA ( SI NO HAY ESPECIALISTA)
		
		return tipos.size() == verificacionesConMayorValor.size();
	}
	private String x() {
		return "";
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
