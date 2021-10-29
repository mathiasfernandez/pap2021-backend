package logica;

import java.io.Serializable; 
import java.util.Objects;

public class RegistroID implements Serializable {
	private static final long serialVersionUID= 1L;
	
	private String espectador;
	private String funcion;
	
	public RegistroID(){
		super();
	}
	
	public String getEspectador() {
		return espectador;
		
	}
	
	public String getFuncion() {
		return funcion;
	}
	
	public void setEspectador(String espectador) {
		this.espectador = espectador;
	}
	
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(espectador, funcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroID other = (RegistroID) obj;
		return Objects.equals(espectador, other.espectador) && Objects.equals(funcion, other.funcion);
	}
	
}


