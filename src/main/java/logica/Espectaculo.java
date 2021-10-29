package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtEspectaculo;

@Entity
public class Espectaculo {
	@Id
	private String 	nombreEsp;
	private String descripcion;
	private int duracion;
	private int minEspectadores;
	private int maxEspectadores;
	private String url;
	private float costo;
	private Date fechaRegistro;
	private String imagen;
	
	@ManyToOne
	private Plataforma IdPla_Esp;
	
	@ManyToOne
	private Paquete IdEspPaq;


	public Paquete getIdEspPaq() {
		return IdEspPaq;
	}

	public void setIdEspPaq(Paquete idEspPaq) {
		IdEspPaq = idEspPaq;
	}

	public Artista getIdEsp_Art() {
		return IdEsp_Art;
	}

	public void setIdEsp_Art(Artista idEsp_Art) {
		IdEsp_Art = idEsp_Art;
	}

	@ManyToOne
	private Artista IdEsp_Art;

	@OneToMany(mappedBy = "IdEsp_Func",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Funcion> funciones = new ArrayList<>();
	
	public Espectaculo() {
		super();
	}

	public Espectaculo(String nombreEsp, String descripcion, int duracion, int minEspectadores, int maxEspectadores,
			String url, float costo, Date fechaRegistro,Plataforma plataforma, Artista art,String imagen) {
		super();
		this.nombreEsp = nombreEsp;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.minEspectadores = minEspectadores;
		this.maxEspectadores = maxEspectadores;
		this.url = url;
		this.costo = costo;
		this.fechaRegistro = fechaRegistro;
		this.IdPla_Esp = plataforma;
		this.IdEsp_Art= art;
		this.imagen = imagen;

	}

	public String getNombreEsp() {
		return nombreEsp;
	}
	
	public Plataforma getPlataforma() {
		return IdPla_Esp;
	}
	
	public Artista getArtista() {
		return IdEsp_Art;
	}

	public void setNombreEsp(String nombreEsp) {
		this.nombreEsp = nombreEsp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getMinEspectadores() {
		return minEspectadores;
	}

	public void setMinEspectadores(int minEspectadores) {
		this.minEspectadores = minEspectadores;
	}

	public int getMaxEspectadores() {
		return maxEspectadores;
	}

	public void setMaxEspectadores(int maxEspectadores) {
		this.maxEspectadores = maxEspectadores;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
	

	public void agregarFuncion(Funcion funcion) {
		this.funciones.add(funcion);		
	}

	@Override
	public String toString() {
		return "Espectaculo [nombreEsp=" + nombreEsp + ", descripcion=" + descripcion + ", duracion=" + duracion
				+ ", minEspectadores=" + minEspectadores + ", maxEspectadores=" + maxEspectadores + ", url=" + url
				+ ", costo=" + costo + ", fechaRegistro=" + fechaRegistro + "]";
	}

	public DtEspectaculo infoEspectaculo() {
		DtEspectaculo retorno = new DtEspectaculo(this.nombreEsp,this.descripcion,this.duracion,this.minEspectadores,this.maxEspectadores,this.url,this.costo,this.fechaRegistro,null,null,this.imagen);
		return retorno;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
