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
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import exepciones.EspectaculoRepetidoExepcion;
import exepciones.FuncionYaExisteExcepcion;
import interfaces.IcEspectaculo;
import logica.Espectaculo;
import logica.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorEspectaculoPublish {
	private Fabrica fabrica;
	private IcEspectaculo iconE;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorEspectaculoPublish() {
		fabrica = Fabrica.getInstancia();
		iconE = fabrica.getIControladorEspectaculo();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEspectaculo",this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEspectaculo");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint(){
		return endpoint;
	}
	
	 //a partir de aca van todos los metodos que se van a publicar
		@WebMethod
		public void seleccionarEspectaculo(Espectaculo espectaculo){
			iconE.SeleccionarEspectaculo(espectaculo);
		}
		
		@WebMethod
		public void setFuncion(String nomEspectaculo, String nomFuncion, Date fecha, String[] invitados) {
			iconE.setFuncion(nomEspectaculo, nomFuncion, fecha, invitados);
		} 
		
		@WebMethod
		public String[] listarEspectaculos(String nomPlataforma){
			
			List<String> listaEspectaculos = iconE.listarEspectaculos(nomPlataforma);
			int i = 0;
			String[] ret = new String[listaEspectaculos.size()];
	        for(String s : listaEspectaculos) {
	            ret[i]=s;
	            i++;
	        }
	        return ret;}
		
		@WebMethod
		public void confirmarAltaEspectaculo(String nombreEsp, String descripcion, int duracion, int minEspectadores, int maxEspectadores,
				String url, float costo, Date fechaRegistro,String pla, String art,String imagen)  {
			iconE.confirmarAltaEspectaculo(nombreEsp, descripcion, duracion, minEspectadores, maxEspectadores, url, costo, fechaRegistro, pla, art, imagen);
		}
		
		@WebMethod
		public DtEspectaculo[] getEspectaculos(String plataforma){
			List<DtEspectaculo> dtEspectaculo = iconE.getEspectaculos(plataforma);
			int i = 0;
			DtEspectaculo[] ret = new DtEspectaculo[dtEspectaculo.size()];
	        for(DtEspectaculo e : dtEspectaculo) {
	            ret[i]=e;
	            i++;
	        }
	        return ret;
		}
		
		@WebMethod
		public String[] listarFunciones(String nomEsp) {
			return iconE.listarFunciones(nomEsp);
		}
		
		@WebMethod
		public String[] getArrEspectaculos(String plataforma) {
			return iconE.getArrEspectaculos(plataforma);
		}
		
		@WebMethod
		public String[] getArrFunciones(String espectaculo) {
			return iconE.getArrFunciones(espectaculo);
		}
		
		@WebMethod
		public DtFuncion[] getNuevasFunciones(Integer top){
			
			List<DtFuncion> dtFuncion = iconE.getNuevasFunciones(top);
			int i = 0;
			DtFuncion[] ret = new DtFuncion[dtFuncion.size()];
	        for(DtFuncion f : dtFuncion) {
	            ret[i]=f;
	            i++;
	        }
	        return ret;
	     }
		
		@WebMethod
		public String[] listarEspectaculo(String nomPlataforma) {
			return iconE.listarEspectaculo(nomPlataforma);
		}
		
		@WebMethod
		public DtEspectaculo buscarEspectaculoNombre(String nomEsp) {
			return iconE.buscarEspectaculoNombre(nomEsp);
		}
		
		@WebMethod
		public DtFuncion getDtFuncion(String espectaculo, String funcion) {
			return iconE.getDtFuncion(espectaculo, funcion);
		}
		
		@WebMethod
		public String[] listarPaquetes(String nomEsp) {
			return iconE.listarPaquetes(nomEsp);
		}
		
		@WebMethod
		public String[] listarEspectaculosArtista(String artista) {
			return iconE.listarEspectaculosArtista(artista);
		}
		
}
