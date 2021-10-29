package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("A")
public class Artista extends Usuario {
	private String descripcion;
	private String bibliografia;
	private String sitioWeb;
	

	@OneToMany(mappedBy = "IdEsp_Art",cascade = CascadeType.ALL) 
	private List<Espectaculo> espectaculos = new ArrayList<Espectaculo>();

	
	@ManyToMany(mappedBy = "IdEsp_ArtInvitados",cascade = CascadeType.MERGE) 
	private List<Funcion> funcionesInvitado = new ArrayList<>();

	
	@ManyToOne 
	private Funcion IdFunc_Art;
	
	public Artista() {
		super();
	}

	public Artista(String nickname, String nombre, String apellido, String correo, Date fNac, String descripcion, String bibliografia, String sitioWeb, List<Espectaculo> espectaculos, String contra,String imagen) {
		super(nickname,nombre, apellido,correo,fNac,contra,imagen);
		this.descripcion = descripcion;
		this.bibliografia = bibliografia;
		this.sitioWeb = sitioWeb;
		this.espectaculos = espectaculos;
	}

	public String getNickname() {
		return super.getNickname();
	}

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getBibliografia() {
		return bibliografia;
	}


	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}


	public String getSitioWeb() {
		return sitioWeb;
	}


	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	
	public List<Espectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	};

	
	@Override
	public String toString() {
		return "Artista [descripcion=" + descripcion + ", bibliografia=" + bibliografia + ", sitioWeb=" + sitioWeb
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
		Artista other = (Artista) obj;
		return Objects.equals(bibliografia, other.bibliografia) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(sitioWeb, other.sitioWeb);
	}
	
	public void agregarEspectaculo(Espectaculo espectaculo) {
		if (this.espectaculos == null ) {
			this.espectaculos=  new ArrayList<Espectaculo>();
		}
		this.espectaculos.add(espectaculo);
	}


	
	

}
