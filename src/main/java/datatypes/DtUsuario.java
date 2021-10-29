package datatypes;

import java.util.Date;

public abstract class DtUsuario {
	
	private String nickname;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fNac;
	private String contrasena;
	private String imagen;	
	public DtUsuario() {
		super();
	}

	public DtUsuario(String nickname, String nombre, String apellido, String correo, Date fNac, String contra, String imagen) {
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

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public Date getfNac() {
		return fNac;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	public void setImagen(String img) {
		this.imagen = img;
	}
	
	public String getImagen() {
		return imagen;
	}
//	public abstract DtUsuario getDtUsuario(String nickname);
}
