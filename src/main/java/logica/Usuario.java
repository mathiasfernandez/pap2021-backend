package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import  javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	private String nickname;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fNac;
	private String contrasena;
	private String imagen;
	
	@ManyToOne 
	private Funcion IdFunc_Art;
	
	/*@OneToMany(mappedBy = "usuarioSeguido",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<UsuariosSeguidos> usuariosSeguidos = new ArrayList<>();*/
	
	
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nickname, String nombre, String apellido, String correo, Date fNac, String contra,String imagen) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fNac = fNac;
		this.contrasena = contra;
		this.imagen=imagen;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getfNac() {
		return fNac;
	}

	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}

	@Override
	public String toString() {
		return "Usuario [nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", fNac=" + fNac + "]";
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void setImagen(String img) {
		this.imagen = img;
	}
	
	public String getImagen() {
		return imagen;
	}
}
