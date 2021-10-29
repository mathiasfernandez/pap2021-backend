package logica;

import java.util.Date;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import datatypes.ModoCanje;

@Entity
@IdClass(RegistroID.class)
public class Registro {
	
	

	@Temporal(TemporalType.DATE)
	private Date fecha;
	private ModoCanje canje;
	
	@Id
	@ManyToOne
	private Espectador espectador;
	
	@Id
	@ManyToOne
	private Funcion funcion;
	
	

	public Registro() { 
		super();
	}
	
	public Registro(Date fecha, ModoCanje canje) {
		super();
		this.fecha = fecha;
		this.canje = canje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ModoCanje getCanje() {
		return canje;
	}

	public void setCanje(ModoCanje canje) {
		this.canje = canje;
	}

	@Override
	public String toString() {
		return "Registro [fecha=" + fecha + ", canje=" + canje + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		return canje == other.canje && Objects.equals(fecha, other.fecha);
	}

	public Espectador getEspectador() {
		return espectador;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}
	
	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

}
