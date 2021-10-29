package logica;

 
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UsuariosSeguidosID.class)
public class UsuariosSeguidos {	
	@Id
	@ManyToOne
	private Usuario seguidor;
	@Id
	@ManyToOne
	private Usuario usuarioSeguido;
	
	
	public Usuario getSeguidor() {
		return seguidor;
	}
	public void setSeguidor(Usuario seguidor) {
		this.seguidor = seguidor;
	}
	public Usuario getUsuarioSeguido() {
		return usuarioSeguido;
	}
	public void setUsuarioSeguido(Usuario usuarioSeguido) {
		this.usuarioSeguido = usuarioSeguido;
	}
	@Override
	public int hashCode() {
		return Objects.hash(seguidor, usuarioSeguido);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuariosSeguidos other = (UsuariosSeguidos) obj;
		return Objects.equals(seguidor, other.seguidor) && Objects.equals(usuarioSeguido, other.usuarioSeguido);
	}
	
	
	
	
	
}
