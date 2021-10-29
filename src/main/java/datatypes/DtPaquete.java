package datatypes;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Date;

public class DtPaquete {
	private String nombre;
	private String descripcion;
	private Date fInicio;
	private Date fFinal;
	private int descuento;
	private Date fAlta;
	private float costo;
	private List<DtEspectaculo> espectaculos = new ArrayList<>();
		
	
	public DtPaquete() {
		super();
	}

	public DtPaquete(String nombre, String descripcion, Date fInicio, Date fFinal, int descuento, float costo, Date fAlta,
			ArrayList<DtEspectaculo> espectaculos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fInicio = fInicio;
		this.fFinal = fFinal;
		this.descuento = descuento;
		this.fAlta = fAlta;
		this.costo = costo;
		this.espectaculos = espectaculos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public float getCosto() {
		return costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public Date getfFinal() {
		return fFinal;
	}

	public int getDescuento() {
		return descuento;
	}

	public List<DtEspectaculo> getEspectaculos() {
		return espectaculos;
	}

	@Override
	public String toString() {
		return "DtPaquete [nombre=" + nombre + ", descripcion=" + descripcion + ", fInicio=" + fInicio + ", fFinal="
				+ fFinal + ", descuento=" + descuento + ", espectaculos=" + espectaculos + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtPaquete other = (DtPaquete) obj;
		return Objects.equals(descripcion, other.descripcion) && descuento == other.descuento
				&& Objects.equals(espectaculos, other.espectaculos) && Objects.equals(fFinal, other.fFinal)
				&& Objects.equals(fInicio, other.fInicio) && Objects.equals(nombre, other.nombre);
	}

	public Date getfAlta() {
		return fAlta;
	}
	
	
	
}
