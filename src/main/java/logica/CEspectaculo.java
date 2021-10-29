package logica;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;

import conexion.Conexion;
import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtHora;
import exepciones.EspectaculoRepetidoExepcion;
import exepciones.FuncionYaExisteExcepcion;
import exepciones.UsuarioRepetidoExepcion;
import interfaces.IcEspectaculo;


public class CEspectaculo implements IcEspectaculo {
	
	private String nomFuncion;
	private Date fecha;
	private List<Artista> invitados;
	
	@Override
	public DtEspectaculo SeleccionarEspectaculo(Espectaculo espectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFuncion(String nomEspectaculo, String nomFuncion, Date fecha, List<String> invitados) throws FuncionYaExisteExcepcion {
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		List<Artista> artistasInvitados = new ArrayList<Artista>();
		
		//obtener hora actual para el registro
		LocalDateTime ahora = LocalDateTime.now();
		Date dateAhora = convertToDateViaSqlTimestamp(ahora);
		
		for (String esp : mE.listarEspectaculos()) {
			if(esp.toString().equals(nomEspectaculo)) { 					// comparo strings
				Espectaculo espect = mE.buscarEspectaculo(nomEspectaculo); 	// traigo objeto
				
				for (Funcion fun : espect.getFunciones()) {
					
					if(fun.getNombreFunc().toLowerCase().equals(nomFuncion.toLowerCase())) { 			// chequear que la funcion no exista
						throw new FuncionYaExisteExcepcion("Ya existe una funcion con el nombre '" + nomFuncion + "'");
					}
					
				}
				// obtener artistas invitados desde nickname
				for (String invitado : invitados) {
					artistasInvitados.add((Artista) mU.buscarUsuario(invitado));
				}
				
		
				Funcion f = new Funcion(nomFuncion, dateAhora, fecha, artistasInvitados, espect);	
				
				espect.agregarFuncion(f);
				mE.agregarFuncionEspectaculo(espect, f);
				
			}
		}
		
		
	}

	@Override
	public List<String> listarEspectaculos(String nomPlataforma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmarAltaEspectaculo(String nombreEsp, String descripcion, int duracion, int minEspectadores, int maxEspectadores,String url, float costo, Date fechaRegistro,String plataforma, String art, String imagen) throws EspectaculoRepetidoExepcion {
	
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		
		Plataforma pla = mP.buscarPlataforma(plataforma); 
		Artista artista = (Artista) mU.buscarUsuario(art);
		
		if (mE.existeEspectaculo(nombreEsp))
			throw new EspectaculoRepetidoExepcion("Ya existe un espectaculo con el nombre " + nombreEsp);
		else {
			Espectaculo esp = new Espectaculo(nombreEsp,descripcion,duracion,minEspectadores,maxEspectadores,url,costo,fechaRegistro,pla,artista,imagen);
			artista.agregarEspectaculo(esp);
			pla.agregarEspectaculo(esp);
			mE.agregarEspectaculo(esp);
			}
	}
	
	
	@Override
	public List<DtEspectaculo> getEspectaculos(String plataforma) {
		List<DtEspectaculo> retorno = new ArrayList<>();
				
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		
		ArrayList<String> espectaculos = mE.listarEspectaculos();	// listar los espectaculos existentes en el manejador
		
		for (String espect : espectaculos) { // crear un Dt por espectaculo 
			Espectaculo e = mE.buscarEspectaculo(espect);
			if(e.getPlataforma().getNombrePla().equals(plataforma)) {
				DtEspectaculo dtE = new DtEspectaculo(e.getNombreEsp(), e.getDescripcion(), e.getDuracion(), e.getMinEspectadores(), e.getMaxEspectadores(), e.getUrl(), e.getCosto(), e.getFechaRegistro(),e.getPlataforma().getNombrePla(),e.getArtista().getNickname(),e.getImagen());
				retorno.add(dtE);
			}
		
		}
		return retorno;
	}
	
	@Override
	public String[] getArrEspectaculos(String plataforma) {
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		ArrayList<String> espectaculos = mE.listarEspectaculosPlafatorma(plataforma);	// listar los espectaculos existentes en el manejador
		int tamanio;
		
		try {
			tamanio = espectaculos.size();
		}catch(Exception e) {
			tamanio = 0;
		}
		
		String[] retorno = new String[tamanio];
		int i=0;
		for(String e:espectaculos) {
			retorno[i] = e.toString();
			i++;
		}
		
		return retorno;
	}
	
	@Override
	public String[] listarEspectaculosArtista(String artista) {
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		ArrayList<String> espectaculos = mE.listarEspectaculosArtista(artista);	// listar los espectaculos existentes en el manejador
		int tamanio;
		
		try {
			tamanio = espectaculos.size();
		}catch(Exception e) {
			tamanio = 0;
		}
		
		String[] retorno = new String[tamanio];
		int i=0;
		for(String e:espectaculos) {
			retorno[i] = e.toString();
			i++;
		}
		
		return retorno;
	}
	
	@Override
	public String[] getArrFunciones(String espectaculo) {
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		Espectaculo e = mE.buscarEspectaculo(espectaculo);	// listar los espectaculos existentes en el manejador
		List<Funcion> funciones = e.getFunciones();
		
		String[] retorno = new String[funciones.size()];
		int i=0;
		for(Funcion f:funciones) {
			retorno[i] = f.getNombreFunc();
			i++;
		}
		
		return retorno;
	}
	
	
	@Override
	public List<DtFuncion> getNuevasFunciones(Integer top){
		List<DtFuncion> retorno = new ArrayList<DtFuncion>();
		List<DtFuncion> sinordenar = new ArrayList<DtFuncion>();
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		List<String> espectaculos = mE.listarEspectaculos();
		
		for(String espectaculo:espectaculos) {
			List<String> funciones = mE.listarFunciones(espectaculo);
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date ahora = new Date(System.currentTimeMillis()); 
			for(String funcion:funciones) {
				DtFuncion fun = getDtFuncion(espectaculo, funcion);
				
				fun.setNomEspectaculo(espectaculo); // seteo manual sobre el constructor anterior, asi no tengo qu modificarlo
				// solo agregar los posteriores a ahora
				if(fun.getFechaFuncion().after(ahora)) {
					sinordenar.add(fun);
				}
				
			}
			
		}



		int restantes = sinordenar.size();
		// para obtener el item mas nuevo
		
		
		while((top != 0) && (restantes != 0)) {
			Date fechaMax = null;
			DtFuncion itemMax = null;
			
			for(DtFuncion item:sinordenar){
				if(fechaMax == null){
					itemMax = item;
					fechaMax = item.getFechaFuncion();
				}else if(item.getFechaFuncion().after(fechaMax)){
					itemMax = item;
					fechaMax = item.getFechaFuncion();
				}
				
			}
			retorno.add(itemMax);
			sinordenar.remove(itemMax);
			top = top - 1; 
			restantes = restantes - 1;
		}
		
		
		return retorno;
		
	}
	
	public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
	    return java.sql.Timestamp.valueOf(dateToConvert);
	}

	@Override
	public String[] listarEspectaculo(String nomPlataforma) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override 
	public DtEspectaculo buscarEspectaculoNombre(String nomEsp) {
	ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
	Espectaculo e = mE.buscarEspectaculo(nomEsp);
	
	DtEspectaculo espectaculo_retorno = new DtEspectaculo(e.getNombreEsp(),e.getDescripcion(),e.getDuracion(),e.getMinEspectadores(),e.getMaxEspectadores(),e.getUrl(),e.getCosto(),e.getFechaRegistro(),e.getPlataforma().getNombrePla(),e.getArtista().getNickname(),e.getImagen());
	
	return espectaculo_retorno;
	}

	@Override
	public String[] listarFunciones(String nomEsp) {
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		ArrayList<String> funciones = mE.listarFunciones(nomEsp);	// listar los espectaculos existentes en el manejador
		
		String[] retorno = new String[funciones.size()];
		int i=0;
		for(String f:funciones) {
			retorno[i] = f.toString();
			i++;
		}
		
		return retorno;
			
	}
	
	@Override
	public String[] listarPaquetes(String nomEsp) {
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		ArrayList<String> paquetes = mE.listarPaquetesEsp(nomEsp);	// listar los espectaculos existentes en el manejador
		String[] retorno = new String[paquetes.size()];
		int i=0;
		for(String p:paquetes) {
			retorno[i] = p.toString();
			i++;
		}
		
		return retorno;
			
	}
	
	@Override
	public DtFuncion getDtFuncion(String espectaculo, String funcion) {
		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia(); // obtener el manejador para leer los items
		Espectaculo e = mE.buscarEspectaculo(espectaculo);
		DtFuncion retorno = null;
		
		List<Funcion> funciones = e.getFunciones();
		for(Funcion fun: funciones) {
			if(fun.getNombreFunc().equals(funcion)) {
				
				// devolver lista de string con solo el nomber del artista, arreglar el datatype
				List<Artista> invitados = fun.getInvitados();
				List<String> uInvitados = new ArrayList<String>();
				
				for(Artista a: invitados) {
					uInvitados.add(a.getNickname()); 
				}
				
				
				retorno = new DtFuncion(fun.getNombreFunc(), new Date(fun.getFechaRegistroFun().getTime()), new Date(fun.getFecha().getTime()), uInvitados);
			}
		}
				
		return retorno;
		
	}

}
