package interfaces;

import java.util.*;


import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtHora;
import exepciones.EspectaculoRepetidoExepcion;
import exepciones.FuncionYaExisteExcepcion;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;

public interface IcEspectaculo {
	
	public DtEspectaculo SeleccionarEspectaculo(Espectaculo espectaculo);
	public void setFuncion(String nomEspectaculo, String nomFuncion, Date fecha, List<String> invitados) ; // da de alta una funcion
	public void setFuncion(String nomEspectaculo, String nomFuncion, Date fecha, String [] invitados)  ; // da de alta una funcion
	public List<String> listarEspectaculos(String nomPlataforma);
	public void confirmarAltaEspectaculo(String nombreEsp, String descripcion, int duracion, int minEspectadores, int maxEspectadores,
			String url, float costo, Date fechaRegistro,String pla, String art,String imagen) ;
	List<DtEspectaculo> getEspectaculos(String plataforma);
	public String[] listarFunciones(String nomEsp);
	public String[] getArrEspectaculos(String plataforma);
	public String[] getArrFunciones(String espectaculo);
	public List<DtFuncion> getNuevasFunciones(Integer top);
	public String[] listarEspectaculo(String nomPlataforma);
	DtEspectaculo buscarEspectaculoNombre(String nomEsp);
	DtFuncion getDtFuncion(String espectaculo, String funcion);
	String[] listarPaquetes(String nomEsp);
	String[] listarEspectaculosArtista(String artista);

}