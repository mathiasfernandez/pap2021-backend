package logica;

import java.io.Serializable; 
import java.util.Objects;

public class UsuariosSeguidosID implements Serializable{
	private static final long serialVersionUID= 1L;
	
	private String seguidor;
	private String usuarioSeguido;
	
	
	public UsuariosSeguidosID() {
		super();
	}
	
	public String getSeguidor() {
		return seguidor;
	}
	public void setSeguidor(String seguidor) {
		this.seguidor = seguidor;
	}
	public String getUsuarioSeguido() {
		return usuarioSeguido;
	}
	public void setUsuarioSeguido(String usuarioSeguido) {
		this.usuarioSeguido = usuarioSeguido;
	}
	@Override
	public int hashCode() {
		return Objects.hash(usuarioSeguido, seguidor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuariosSeguidosID other = (UsuariosSeguidosID) obj;
		return Objects.equals(usuarioSeguido, other.usuarioSeguido) && Objects.equals(seguidor, other.seguidor);
	}
	
	
}
