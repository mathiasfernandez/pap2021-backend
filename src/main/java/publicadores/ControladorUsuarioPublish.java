package publicadores;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import exepciones.UsuarioRepetidoExepcion;
import interfaces.IcUsuario;
import logica.Artista;
import logica.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorUsuarioPublish {
	private Fabrica fabrica;
	private IcUsuario iconU;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		iconU = fabrica.getIControladorUsuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario",this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint(){
		return endpoint;
	}
	
	@WebMethod
	public DtEspectador crearDtEspectador(String nickname,String nombre,String apellido,String correo, Date fecha,String contrasenia,String imagenUrl) {
	DtEspectador espectador = new DtEspectador(nickname, nombre, apellido, correo, fecha, contrasenia, imagenUrl);
	return espectador;
	}
	
	@WebMethod
	public DtArtista crearDtArtista(String nickname,String nombre,String apellido,String correo,Date fecha,String descripcion, String bibliografia,String sitioWeb,String contrasenia,String imagenUrl) {
	DtArtista artista = new DtArtista(nickname, nombre, apellido, correo, fecha, descripcion, bibliografia, sitioWeb, contrasenia, imagenUrl);
	return artista;
	}
	
	
	@WebMethod
	public void confirmarAltaUsuario(DtUsuario us) {
		try {
			iconU.confirmarAltaUsuario(us);
		} catch (UsuarioRepetidoExepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public DtUsuario[] getUsuarios(){
		DtUsuario[] ret = null;
		try {
			List<DtUsuario> dtusuarios = iconU.getUsuarios();
			int i = 0;
			ret = new DtUsuario[dtusuarios.size()];
	        for(DtUsuario s : dtusuarios) {
	            ret[i]=s;
	            i++;
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	
	public String[] getArtistas() {
		String[] ret = null;
		try {
			ret = iconU.getArtistas();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	@WebMethod
	public String[] listarUsuarios() {
		String[] ret = null;
		try {
			ret = iconU.listarUsuarios();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	@WebMethod
	public Artista getArtista(String nickname) {
		Artista ret = null;
		try {
			ret = iconU.getArtista(nickname);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	
	@WebMethod
	public DtUsuario getDtUsuario(String nickname) {
		DtUsuario ret = null;
		try {
			ret = iconU.getDtUsuario(nickname);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	@WebMethod
	public String[] obtenerEspectadores() {
		String[] ret = null;
		try {
			ret = iconU.obtenerEspectadores();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	@WebMethod
	public boolean validarIngreso(String user, String contra) {
		boolean ret = false;
		try {
			ret = iconU.validarIngreso(user, contra);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	@WebMethod
	public void seguirUsuario(String seguidor, String usuarioSeguido) {
		try {
			iconU.seguirUsuario(seguidor, usuarioSeguido);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@WebMethod
	public void dejarDeSeguirUsuario(String seguidor, String usuarioSeguido) {
		try {
			iconU.dejarDeSeguirUsuario(seguidor, usuarioSeguido);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@WebMethod
	public void cargarImagenUrl(String us, String imagen) {
		try {
			iconU.cargarImagenUrl(us, imagen);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@WebMethod
	public boolean yaLoSigo(String seguidor, String seguido) {
		boolean ret = false;
		try {
			ret = iconU.yaLoSigo(seguidor, seguido);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}

	@WebMethod
	public void actualizarUsuario(DtUsuario us) {
		try {
			iconU.actualizarUsuario(us);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@WebMethod
	public String[] usuariosSeguidos(String nickname) {
		String[] ret = null;
		try {
			ret = iconU.usuariosSeguidos(nickname);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	@WebMethod
	public String[] usuariosMeSiguen(String nickname) {
		String[] ret = null;
		try {
			ret = iconU.usuariosMeSiguen(nickname);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}

}