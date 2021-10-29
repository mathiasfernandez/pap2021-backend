package logica;

import java.sql.Date;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Entrada {
	
	@OneToMany
	private Espectador IdEspectador_Entrada;
	
	@ManyToOne
	private Espectaculo IdEntrada_Funcion;
	
	
	
	private boolean cajeada;
	private float precio;
	private Date fecha;
	public boolean isCanjeada() {
		return cajeada;
	}
	public void setCajeada(boolean canjeada) {
		this.cajeada = canjeada;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
