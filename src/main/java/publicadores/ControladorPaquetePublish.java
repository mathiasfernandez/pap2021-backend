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
import datatypes.DtPaquete;
import interfaces.IcPaquete;
import logica.Espectaculo;
import logica.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPaquetePublish {
	private Fabrica fabrica;
	private IcPaquete iconP;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPaquetePublish() {
		fabrica = Fabrica.getInstancia();
		iconP = fabrica.getIControladorPaquete();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPaquete",this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPaquete");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint(){
		return endpoint;
	}
	
	@WebMethod
	public void confirmarAltaPaquete() {
		iconP.confirmarAltaPaquete();
	}
	
	@WebMethod
	public DtPaquete seleccionarPaquete(String nombre) {
		return null;
//		return iconP.seleccionarPaquete(nombre);
	}
//	
	@WebMethod
	public String[] listarPaquetes() {
//		List<String> listarPaquetes = iconP.listarPaquetes();
//		int i = 0;
//		String[] ret = new String[listarPaquetes.size()];
//        for(String s : listarPaquetes) {
//            ret[i]=s;
//            i++;
//        }
//        return ret;
	return null;
}

	@WebMethod
	public String[] listarPlataformas(){
//		List<String> listarPlataformas = iconP.listarPlataformas();
//		int i = 0;
//		String[] ret = new String[listarPlataformas.size()];
//        for(String s : listarPlataformas) {
//            ret[i]=s;
//            i++;
//        }
//        return ret;
		return null;
   }
		

	@WebMethod
	public String[] listaEspectaculosNOPAQUETE(String plataforma, String paquete) {
//		List<String> listaEspectaculosNOPAQUETE = iconP.listaEspectaculosNOPAQUETE(plataforma, paquete);
//		int i = 0;
//		String[] ret = new String[listaEspectaculosNOPAQUETE.size()];
//        for(String s : listaEspectaculosNOPAQUETE) {
//            ret[i]=s;
//            i++;
//        }
//        return ret;	
		return null;
	}
//	
	@WebMethod
	public void agregarEspectaculoAPaquete(String paquete, String Espectaculo) {
//	iconP.agregarEspectaculoAPaquete(paquete, Espectaculo);

	}
//	
	@WebMethod
	public void agregarPaquete(String nombrePac, String descripcion, Date fInicio, Date fFinal, Integer descuento, Date fechaDeAlta,Espectaculo[] espectaculos) {
//		iconP.agregarPaquete(nombrePac, descripcion, fInicio, fFinal, descuento, fechaDeAlta, espectaculos);	
	}
//	
	@WebMethod
	public boolean ExistePaquete(String nombre) {
//		return iconP.ExistePaquete(nombre)
	return false;
	}
//	
	@WebMethod
	public DtPaquete infoPaquete(String nombre) {
//		return iconP.infoPaquete(nombre);
		return null;
	}
}