package datatypes;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class DtFuncion {

	private String nomFun;
	private String nomEspectaculo;
	private Date fechaRegistroFun;
	private Date fechaFuncion;
	
	private List<String> invitados = new ArrayList<String>(); 
	
	public DtFuncion() {
		super();
	}


	public DtFuncion(String nomFun, Date fechaRegistroFun, Date fechaFuncion, List<String> invitados) {
		super();
		this.nomFun = nomFun;
		this.fechaRegistroFun = new Date(fechaRegistroFun.getTime());
		this.fechaFuncion = new Date(fechaFuncion.getTime());
		this.invitados = invitados;
	}
	
	public DtFuncion(String nomFun, Date fechaRegistroFun, Date fechaFuncion, List<String> invitados, String espectaculo) {
		super();
		this.nomFun = nomFun;
		this.fechaRegistroFun = new Date(fechaRegistroFun.getTime());
		this.fechaFuncion = new Date(fechaFuncion.getTime());
		this.invitados = invitados;
		this.setNomEspectaculo(espectaculo);
	}
	
	
	public String getNomFun() {
		return nomFun;
	}
	public Date getFechaRegistroFun() {
		return fechaRegistroFun;
	}


	public List<String> getInvitados() {
		return this.invitados;
	}

	@Override
	public String toString() {
		return "DtFuncion [nomFun=" + nomFun + ", fechaRegistroFun=" + fechaRegistroFun + ", fechaFuncion=" + fechaFuncion
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
		DtFuncion other = (DtFuncion) obj;
		return Objects.equals(fechaRegistroFun, other.fechaRegistroFun) && Objects.equals(fechaFuncion, other.fechaFuncion)
				&& Objects.equals(nomFun, other.nomFun);
	}


	public Date getFechaFuncion() {
		return fechaFuncion;
	}


	public void setFechaFuncion(Date fechaFuncion) {
		this.fechaFuncion = fechaFuncion;
	}


	public String getNomEspectaculo() {
		return nomEspectaculo;
	}


	public void setNomEspectaculo(String nomEspectaculo) {
		this.nomEspectaculo = nomEspectaculo;
	}
	
	
}

