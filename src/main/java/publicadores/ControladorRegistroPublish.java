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
import datatypes.ModoCanje;
import interfaces.IcRegistro;
import logica.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorRegistroPublish {
	private Fabrica fabrica;
	private IcRegistro icRegistro;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorRegistroPublish() {
		fabrica = Fabrica.getInstancia();
		icRegistro = fabrica.getIControladorRegistro();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRegistro",this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRegistro");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint(){
		return endpoint;
	}
	
	@WebMethod
	public void confirmarRegistro(String espectador, String funcion,Date fechaAlta,ModoCanje canje) { icRegistro.confirmarRegistro();}

}
