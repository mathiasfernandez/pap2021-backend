package publicadores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtPaquete;
import datatypes.DtUsuario;
import exepciones.UsuarioRepetidoExepcion;
import interfaces.IcPaquete;
import interfaces.IcPlataforma;
import interfaces.IcUsuario;
import logica.Artista;
import logica.Espectaculo;
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
	public void confirmarAltaUsuario(DtUsuario us) {try {
		iconU.confirmarAltaUsuario(us);
	} catch (UsuarioRepetidoExepcion e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	@WebMethod
	public DtUsuario[] getUsuarios(){
		return null;}
	
	public String[] getArtistas() {
		return null;
	}
	@WebMethod
	public String[] listarUsuarios() {
		return null;
	}
	@WebMethod
	public Artista getArtista(String nickname) {
		return null;
	}
	@WebMethod
	public DtUsuario getDtUsuario(String nickname) {
		return null;
	}
	@WebMethod
	public String[] obtenerEspectadores() {
		return null;
	}
	@WebMethod
	public boolean validarIngreso(String user, String contra) {
		return false;
	}
	@WebMethod
	public void seguirUsuario(String seguidor, String usuarioSeguido) {
	}
	@WebMethod
	public void dejarDeSeguirUsuario(String seguidor, String usuarioSeguido) {
	}
	@WebMethod
	public void cargarImagenUrl(String us, String imagen) {
	}
	@WebMethod
	public boolean yaLoSigo(String seguidor, String seguido) {
		return false;
	}

	@WebMethod
	void actualizarUsuario(DtUsuario us) {
	}
	
	@WebMethod
	String[] usuariosSeguidos(String nickname) {
		return null;
	}
	@WebMethod
	String[] usuariosMeSiguen(String nickname) {
		return null;
	}

}
