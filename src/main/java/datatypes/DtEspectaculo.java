package datatypes;

import java.util.Date;
import java.util.Objects;

import logica.Artista;
import logica.Plataforma;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtEspectaculo {
	
	private String 	nombreEsp;
	private String descripcion;
	private int duracion;
	private int minEspectadores;
	private int maxEspectadores;
	private String url;
	private float costo;
	private Date fechaRegistro;
	private String plataforma;
	private String artista;
	private String imagen;
	
	public DtEspectaculo() {
		super();
	}


	public DtEspectaculo(String nombreEsp, String descripcion, int duracion, int minEspectadores, int maxEspectadores,String url, float costo, Date fechaRegistro, String pla,String art, String imagen) {
		super();
		this.nombreEsp = nombreEsp;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.costo = costo;
		this.fechaRegistro = fechaRegistro;
		this.plataforma = pla;
		this.artista = art;
		this.imagen = imagen;
	}


	public String getNombreEsp() {
		return nombreEsp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getMinEspectadores() {
		return minEspectadores;
	}


	public int getMaxEspectadores() {
		return maxEspectadores;
	}

	public String getUrl() {
		return url;
	}

	public float getCosto() {
		return costo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public String getArtista() {
		return artista;
	}

	@Override
	public String toString() {
		return "DtEspectaculo [nombreEsp=" + nombreEsp + ", descripcion=" + descripcion + ", duracion=" + duracion
				+ ", minEspectadores=" + minEspectadores + ", maxEspectadores=" + maxEspectadores + ", url=" + url
				+ ", costo=" + costo + ", fechaRegistro=" + fechaRegistro + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtEspectaculo other = (DtEspectaculo) obj;
		return Float.floatToIntBits(costo) == Float.floatToIntBits(other.costo)
				&& Objects.equals(descripcion, other.descripcion) && duracion == other.duracion
				&& Objects.equals(fechaRegistro, other.fechaRegistro) && maxEspectadores == other.maxEspectadores
				&& minEspectadores == other.minEspectadores && Objects.equals(nombreEsp, other.nombreEsp)
				&& Objects.equals(url, other.url);
	}


	public String getImagen() {
		return imagen;
	}


	public void setNombreEsp(String nombreEsp) {
		this.nombreEsp = nombreEsp;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public void setMinEspectadores(int minEspectadores) {
		this.minEspectadores = minEspectadores;
	}


	public void setMaxEspectadores(int maxEspectadores) {
		this.maxEspectadores = maxEspectadores;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setCosto(float costo) {
		this.costo = costo;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}


	public void setArtista(String artista) {
		this.artista = artista;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
}
