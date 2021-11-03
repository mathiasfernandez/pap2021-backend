package datatypes;
import java.util.Date;
import java.util.List;

import logica.Artista;
import logica.ManejadorUsuario;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtArtista extends DtUsuario{
	private String descripcion;
	private String bibliografia;
	private String sitio_web;
	
	
	public DtArtista(String nickname, String nombre, String apellido, String correo, Date fNac, String descripcion, String bibliografia, String sitio_web, String contra, String imagen) {
		super(nickname, nombre, apellido, correo, fNac, contra,imagen);
		this.descripcion = descripcion;
		this.bibliografia = bibliografia;
		this.sitio_web = sitio_web;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public String getSitio_web() {
		return sitio_web;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public void setSitio_web(String sitio_web) {
		this.sitio_web = sitio_web;
	}
}
