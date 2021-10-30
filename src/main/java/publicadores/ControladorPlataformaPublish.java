package publicadores;



import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import exepciones.PlataformaRepetidaExepcion;
import interfaces.IcPlataforma;
import logica.Fabrica;
import logica.Plataforma;
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPlataformaPublish {
	
	private Fabrica fabrica;
	private IcPlataforma iconPla;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPlataformaPublish() {
		fabrica = Fabrica.getInstancia();
		iconPla = fabrica.getIControladorPlataforma();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPlataforma",this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPlataforma");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint(){
		return endpoint;
	}
	@WebMethod
	public String[] getPlataformas() {
		return iconPla.getPlataformas();
	}
	
	@WebMethod
	public void confirmarAltaPlataforma(String nombre, String desc, String url) { try {
		iconPla.confirmarAltaPlataforma(nombre, desc, url);
	} catch (PlataformaRepetidaExepcion e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	
	@WebMethod
	public boolean existePlataforma(String nombre) {
		return iconPla.existePlataforma(nombre);
	}

	@WebMethod
	public Plataforma buscarPlataforma(String nombre) {
		return iconPla.buscarPlataforma(nombre);
	}
}
