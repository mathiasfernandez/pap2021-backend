package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtEspectaculo;
import datatypes.DtPaquete;

@Entity
public class Paquete {
	@Id
	private String 	nombrePac;
	private String descripcion;
	private Date fInicio;
	private Date fFinal;
	private int descuento;
	private Date fechaDeAlta;
	private float costo;
	
	@OneToMany(mappedBy = "IdEspPaq",cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos = new ArrayList<>();
	
	public Paquete() {
		super();
	}


	public Paquete(String nombrePac, String descripcion, Date fInicio, Date fFinal, Integer descuento, Date fechaDeAlta,
			List<Espectaculo> espectaculos) {
		super();
		this.nombrePac = nombrePac;
		this.descripcion = descripcion;
		this.fInicio = fInicio;
		this.fFinal = fFinal;
		this.descuento = descuento;
		this.fechaDeAlta = fechaDeAlta;
		this.espectaculos = espectaculos;
	}


	public float getCosto() {
		return costo;
	}


	public void setCosto(float costo) {
		this.costo = costo;
	}


	public String getNombrePac() {
		return nombrePac;
	}


	public void setNombrePac(String nombrePac) {
		this.nombrePac = nombrePac;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getfInicio() {
		return fInicio;
	}


	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}


	public Date getfFinal() {
		return fFinal;
	}


	public void setfFinal(Date fFinal) {
		this.fFinal = fFinal;
	}


	public Integer getDescuento() {
		return descuento;
	}


	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}


	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}


	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}


	public List<Espectaculo> getEspectaculos() {
		return espectaculos;
	}


	public void setEspectaculos(List<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}


	public DtPaquete getInfo() {
		ArrayList<DtEspectaculo> espectaculosDT = new ArrayList();
		for(Espectaculo e: espectaculos) {
			espectaculosDT.add(e.infoEspectaculo());
		}
		DtPaquete retorno = new DtPaquete(this.nombrePac,this.descripcion,this.fInicio,this.fFinal,this.descuento,this.costo,fechaDeAlta,espectaculosDT);
		
		return retorno;
	}


	@Override
	public String toString() {
		return "Paquete [nombrePac=" + nombrePac + ", descripcion=" + descripcion + ", fInicio=" + fInicio + ", fFinal="
				+ fFinal + ", descuento=" + descuento + ", fechaDeAlta=" + fechaDeAlta + ", espectaculos="
				+ espectaculos + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquete other = (Paquete) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(descuento, other.descuento)
				&& Objects.equals(espectaculos, other.espectaculos) && Objects.equals(fFinal, other.fFinal)
				&& Objects.equals(fInicio, other.fInicio) && Objects.equals(fechaDeAlta, other.fechaDeAlta)
				&& Objects.equals(nombrePac, other.nombrePac);
	}
	
	public void agregarEspectaculo(Espectaculo esp) {
		this.espectaculos.add(esp);
		this.descripcion = "hola";
	}
}
