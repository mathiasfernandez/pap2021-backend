package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import interfaces.IcEspectaculo;
import logica.Espectaculo;
import logica.Fabrica;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublish {
	private Fabrica fabrica;
	private IcEspectaculo iconE;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPublish() {
		fabrica = Fabrica.getInstancia();
		iconE = fabrica.getIControladorEspectaculo();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador",this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint(){
		return endpoint;
	}

	// a partir de aca van todos los metodos que se van a publicar
	@WebMethod
	public void seleccionarEspectaculo(Espectaculo espectaculo){
		iconE.SeleccionarEspectaculo(espectaculo);
	}
	
}
