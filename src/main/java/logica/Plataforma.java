package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Plataforma {
	@Id
	private String nombrePla;
	private String descripcionPla;
	private String urlPla;

	@OneToMany(mappedBy = "IdPla_Esp",cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Espectaculo> espectaculos = new ArrayList<Espectaculo>();
	
	
public Plataforma() {
		super();
	}


public Plataforma(String nombrePla,List<Espectaculo> espectaculos,String descripcionPla, String urlPla) {
		super();
		this.nombrePla = nombrePla;
		this.espectaculos = espectaculos;
		this.descripcionPla = descripcionPla;
		this.urlPla = urlPla;
	}


public String getNombrePla() {
		return nombrePla;
	}


public void setNombrePla(String nombrePla) {
		this.nombrePla = nombrePla;
	}
	


public List<Espectaculo> getEspectaculos() {
		return espectaculos;
	}


public void setEspectaculos(List<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}


@Override
public String toString() {
		return "Plataforma [nombrePla=" + nombrePla + "]";
	}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Plataforma other = (Plataforma) obj;
	return Objects.equals(nombrePla, other.nombrePla);
}


public void agregarEspectaculo(Espectaculo espectaculo) {
	if (this.espectaculos == null) {
		this.espectaculos=  new ArrayList<Espectaculo>();
	}
	this.espectaculos.add(espectaculo);
}


public String getDescripcionPla() {
	return descripcionPla;
}


public void setDescripcionPla(String descripcionPla) {
	this.descripcionPla = descripcionPla;
}


public String getUrlPla() {
	return urlPla;
}


public void setUrlPla(String urlPla) {
	this.urlPla = urlPla;
};


}
