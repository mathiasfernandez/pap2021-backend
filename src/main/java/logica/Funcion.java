package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtHora;

@Entity
public class Funcion {
	
	@Id
	private String 	nombreFunc;
	private Date fechaRegistroFun;
	private Date fecha;

	@OneToMany(mappedBy = "funcion",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();
	
	
	
	@ManyToOne
	private Espectaculo IdEsp_Func;
	
	//@OneToMany(mappedBy = "IdFunc_Art",cascade = CascadeType.ALL)
	//private List<Artista> artistas = new ArrayList<>();
	
	@ManyToMany
	private List<Artista> IdEsp_ArtInvitados; // para mapear artistas invitados

	
	
public Funcion() {
		super();
	}



public Funcion(String nombreFunc, Date fechaRegistroFun, Date fecha, List<Artista> artistas, Espectaculo espectaculo) {
		super();
		this.nombreFunc = nombreFunc;
		this.fechaRegistroFun = fechaRegistroFun;
		this.fecha = fecha;
		this.IdEsp_ArtInvitados = artistas;
		this.IdEsp_Func = espectaculo;
	}





public Espectaculo getIdEsp_Func() {
	return IdEsp_Func;
}



public void setIdEsp_Func(Espectaculo idEsp_Func) {
	IdEsp_Func = idEsp_Func;
}



public String getNombreFunc() {
		return nombreFunc;
	}



	public void setNombreFunc(String nombreFunc) {
		this.nombreFunc = nombreFunc;
	}



	public Date getFechaRegistroFun() {
		return fechaRegistroFun;
	}



	public void setFechaRegistroFun(Date fechaRegistroFun) {
		this.fechaRegistroFun = fechaRegistroFun;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	/*
	public List<Artista> getArtistas() {
		return artistas;
	}



	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
*/

@Override
	public String toString() {
		return "Funcion [nombreFunc=" + nombreFunc + ", fechaRegistroFun=" + fechaRegistroFun + ", fecha=" + fecha
				 + "]";
	}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Funcion other = (Funcion) obj;
	return Objects.equals(fecha, other.fecha) && Objects.equals(fechaRegistroFun, other.fechaRegistroFun)
			&& Objects.equals(nombreFunc, other.nombreFunc);
}



public String getFuncion() {
	return this.nombreFunc;
}

public List<Artista> getInvitados() {
	return this.IdEsp_ArtInvitados;
}



}

